// ================================================================
// FORMULARIO PROGRESIVO - SISTEMA DE SEGUIMIENTO DE CASOS
// ================================================================

const TOTAL_PASOS = 11;
let pasoActual = 1;
let pasosCompletados = new Set();

// ================================================================
// INICIALIZACIÓN
// ================================================================

document.addEventListener('DOMContentLoaded', function() {
    console.log('🚀 Inicializando formulario progresivo...');

    const modo = document.getElementById('modoFormulario')?.value;

    if (modo === 'editar') {
        cargarProgresoGuardado();
    } else {
        limpiarFormularioNuevo();
    }
    actualizarUI();
    configurarAutoguardado();
    configurarEventos();

    console.log('✅ Formulario inicializado correctamente');
});

function limpiarFormularioNuevo() {
    console.log('🆕 Nuevo formulario, limpiando datos...');
    localStorage.removeItem('seguimiento_progreso');
    localStorage.removeItem('seguimiento_datos');
    pasoActual = 1;
    pasosCompletados = new Set();

    const form = document.getElementById('mainForm');
    if (form) form.reset();

    document.querySelectorAll('.paso-container').forEach((paso, index) => {
        paso.classList.remove('completed', 'active');
        paso.querySelector('.paso-body')?.classList.remove('expanded');

        if (index === 0) {
            paso.classList.add('active');
            paso.querySelector('.paso-body')?.classList.add('expanded');
            paso.classList.remove('locked');
        } else {
            paso.classList.add('locked');
        }

        paso.querySelector('.status-icon').textContent = index === 0 ? '🔓' : '🔒';
        paso.querySelector('.status-text').textContent = index === 0 ? 'En progreso' : 'Bloqueado';
    });

    actualizarBarraProgreso();
    actualizarBotones();
}

// ================================================================
// CONFIGURACIÓN DE EVENTOS
// ================================================================

function configurarEventos() {
    document.querySelectorAll('input, textarea, select').forEach(campo => {
        campo.addEventListener('change', () => guardarEnLocalStorage());
        campo.addEventListener('input', function() {
            this.classList.remove('campo-invalido');
        });
    });

    window.addEventListener('beforeunload', () => guardarEnLocalStorage());
}

// ================================================================
// NAVEGACIÓN ENTRE PASOS
// ================================================================

function togglePaso(numeroPaso) {
    const pasoContainer = document.querySelector(`.paso-container[data-paso="${numeroPaso}"]`);

    if (pasoContainer.classList.contains('locked')) {
        mostrarNotificacion('⚠️ Completa los pasos anteriores primero', 'warning');
        return;
    }

    const body = pasoContainer.querySelector('.paso-body');
    const isExpanded = body.classList.contains('expanded');

    document.querySelectorAll('.paso-body').forEach(b => b.classList.remove('expanded'));
    document.querySelectorAll('.paso-container').forEach(c => c.classList.remove('active'));

    if (!isExpanded) {
        body.classList.add('expanded');
        pasoContainer.classList.add('active');
        pasoActual = numeroPaso;

        setTimeout(() => {
            pasoContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);
    }
}

function avanzarPaso() {
    if (!validarPasoActual()) {
        mostrarNotificacion('⚠️ Por favor, completa todos los campos requeridos', 'warning');
        return;
    }

    pasosCompletados.add(pasoActual);

    const pasoContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
    pasoContainer.classList.add('completed');
    pasoContainer.classList.remove('active');
    pasoContainer.querySelector('.paso-body').classList.remove('expanded');
    pasoContainer.querySelector('.status-icon').textContent = '✓';
    pasoContainer.querySelector('.status-text').textContent = 'Completado';

    const siguientePaso = pasoActual + 1;
    if (siguientePaso <= TOTAL_PASOS) {
        const siguienteContainer = document.querySelector(`.paso-container[data-paso="${siguientePaso}"]`);
        siguienteContainer.classList.remove('locked');
        siguienteContainer.classList.add('active');
        siguienteContainer.querySelector('.paso-body').classList.add('expanded');
        siguienteContainer.querySelector('.status-icon').textContent = '🔓';
        siguienteContainer.querySelector('.status-text').textContent = 'En progreso';

        pasoActual = siguientePaso;

        setTimeout(() => {
            siguienteContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);
    }

    guardarProgreso();
    actualizarBarraProgreso();
    actualizarBotones();
    mostrarNotificacion('✓ Paso completado correctamente');
}

function retrocederPaso() {
    const anteriorPaso = pasoActual - 1;
    if (anteriorPaso >= 1) {
        const pasoActualContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
        pasoActualContainer.classList.remove('active');
        pasoActualContainer.querySelector('.paso-body').classList.remove('expanded');

        const anteriorContainer = document.querySelector(`.paso-container[data-paso="${anteriorPaso}"]`);
        anteriorContainer.classList.add('active');
        anteriorContainer.querySelector('.paso-body').classList.add('expanded');

        pasoActual = anteriorPaso;

        setTimeout(() => {
            anteriorContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);

        actualizarBotones();
    }
}

// ================================================================
// ACTUALIZACIÓN DE UI
// ================================================================

function actualizarUI() {
    actualizarBarraProgreso();
    actualizarBotones();
}

function actualizarBarraProgreso() {
    const porcentaje = (pasosCompletados.size / TOTAL_PASOS) * 100;
    const progressBar = document.getElementById('progressBar');
    const progressText = document.getElementById('progressText');

    if (progressBar) {
        progressBar.style.width = porcentaje + '%';
        progressBar.textContent = Math.round(porcentaje) + '%';
    }

    if (progressText) {
        progressText.textContent = `${pasosCompletados.size} de ${TOTAL_PASOS} pasos completados`;
    }
}

function actualizarBotones() {
    const btnPrev = document.getElementById('btnPrev');
    const btnNext = document.getElementById('btnNext');

    if (btnPrev) {
        btnPrev.style.display = pasoActual === 1 ? 'none' : 'inline-flex';
    }

    if (btnNext) {
        if (pasoActual === TOTAL_PASOS) {
            btnNext.textContent = '✓ Finalizar y Enviar';
            btnNext.type = 'button';
            btnNext.onclick = () => finalizarFormulario();
        } else {
            btnNext.textContent = 'Siguiente →';
            btnNext.type = 'button';
            btnNext.onclick = () => avanzarPaso();
        }
    }
}

// ================================================================
// FINALIZACIÓN DEL FORMULARIO
// ================================================================

function finalizarFormulario() {
    if (!validarPasoActual()) {
        mostrarNotificacion('⚠️ Por favor, completa todos los campos requeridos', 'warning');
        return;
    }

    pasosCompletados.add(pasoActual);
    guardarProgreso();
    mostrarNotificacion('✓ Guardando formulario...', 'info');

    setTimeout(() => {
        const form = document.getElementById('mainForm');
        if (!form) {
            mostrarNotificacion('❌ Error: No se encontró el formulario', 'error');
            return;
        }

        localStorage.removeItem('seguimiento_progreso');
        localStorage.removeItem('seguimiento_datos');
        form.submit();
    }, 500);
}

// ================================================================
// VALIDACIÓN
// ================================================================

function validarPasoActual() {
    const pasoElement = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
    if (!pasoElement) return true;

    const camposRequeridos = pasoElement.querySelectorAll('input[required], textarea[required], select[required]');
    let todosValidos = true;
    let primerCampoInvalido = null;

    camposRequeridos.forEach(campo => {
        const esValido = validarCampo(campo);
        if (!esValido) {
            todosValidos = false;
            campo.classList.add('campo-invalido');
            if (!primerCampoInvalido) primerCampoInvalido = campo;
        } else {
            campo.classList.remove('campo-invalido');
        }
    });

    if (primerCampoInvalido) {
        setTimeout(() => {
            primerCampoInvalido.scrollIntoView({ behavior: 'smooth', block: 'center' });
            primerCampoInvalido.focus();
        }, 100);
    }

    return todosValidos;
}

function validarCampo(campo) {
    if (campo.type === 'checkbox') {
        const grupo = campo.closest('.checkbox-group');
        if (grupo) {
            return Array.from(grupo.querySelectorAll('input[type="checkbox"]')).some(cb => cb.checked);
        }
        return campo.checked;
    }

    if (campo.type === 'radio') {
        return document.querySelector(`input[name="${campo.name}"]:checked`) !== null;
    }

    return campo.value.trim() !== '';
}

// ================================================================
// GUARDADO Y RECUPERACIÓN - ¡AQUÍ ESTÁ LA CORRECCIÓN!
// ================================================================

function guardarFormulario() {
    console.log('💾 Iniciando guardado del formulario...');

    const form = document.getElementById('mainForm');
    if (!form) {
        mostrarNotificacion('❌ No se encontró el formulario', 'error');
        return;
    }

    // Validar paso 1
    const paso1 = document.querySelector(`.paso-container[data-paso="1"]`);
    if (paso1) {
        const camposRequeridos = paso1.querySelectorAll('input[required], textarea[required], select[required]');
        let todosValidos = true;

        camposRequeridos.forEach(campo => {
            if (!validarCampo(campo)) {
                todosValidos = false;
                campo.classList.add('campo-invalido');
            }
        });

        if (!todosValidos) {
            mostrarNotificacion('⚠️ Completa al menos los datos de identificación (Paso 1)', 'warning');
            togglePaso(1);
            return;
        }
    }

    // Guardar en localStorage
    guardarProgreso();
    guardarEnLocalStorage();

    mostrarNotificacion('💾 Guardando en el servidor...', 'info');

    // Enviar formulario
    setTimeout(() => {
        console.log('📤 Enviando formulario a:', form.action);
        form.submit();
    }, 800);
}

function guardarProgreso() {
    const progreso = {
        pasoActual: pasoActual,
        pasosCompletados: Array.from(pasosCompletados),
        timestamp: new Date().toISOString()
    };
    localStorage.setItem('seguimiento_progreso', JSON.stringify(progreso));
    guardarEnLocalStorage();
}

function guardarEnLocalStorage() {
    const form = document.getElementById('mainForm');
    if (!form) return;

    const formData = new FormData(form);
    const datos = {};

    for (let [key, value] of formData.entries()) {
        if (datos[key]) {
            if (!Array.isArray(datos[key])) {
                datos[key] = [datos[key]];
            }
            datos[key].push(value);
        } else {
            datos[key] = value;
        }
    }

    form.querySelectorAll('input[type="checkbox"]').forEach(cb => {
        if (!cb.checked && cb.name) {
            datos[cb.name] = false;
        }
    });

    localStorage.setItem('seguimiento_datos', JSON.stringify(datos));
}

function cargarProgresoGuardado() {
    const progresoGuardado = localStorage.getItem('seguimiento_progreso');

    if (progresoGuardado) {
        try {
            const progreso = JSON.parse(progresoGuardado);
            pasoActual = progreso.pasoActual || 1;
            pasosCompletados = new Set(progreso.pasosCompletados || []);

            pasosCompletados.forEach(numeroPaso => {
                const pasoContainer = document.querySelector(`.paso-container[data-paso="${numeroPaso}"]`);
                if (pasoContainer) {
                    pasoContainer.classList.add('completed');
                    pasoContainer.classList.remove('locked');
                    pasoContainer.querySelector('.status-icon').textContent = '✓';
                    pasoContainer.querySelector('.status-text').textContent = 'Completado';
                }
            });

            for (let i = 1; i <= pasoActual; i++) {
                const pasoContainer = document.querySelector(`.paso-container[data-paso="${i}"]`);
                if (pasoContainer && !pasosCompletados.has(i)) {
                    pasoContainer.classList.remove('locked');
                }
            }

            const pasoActualContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
            if (pasoActualContainer) {
                pasoActualContainer.classList.add('active');
                pasoActualContainer.querySelector('.paso-body').classList.add('expanded');

                if (pasoActual !== 1) {
                    const paso1 = document.querySelector(`.paso-container[data-paso="1"]`);
                    if (paso1) {
                        paso1.classList.remove('active');
                        paso1.querySelector('.paso-body').classList.remove('expanded');
                    }
                }
            }

            mostrarNotificacion('📂 Progreso anterior restaurado', 'info');
        } catch (error) {
            console.error('Error al cargar progreso:', error);
        }
    }

    cargarDatosFormulario();
}

function cargarDatosFormulario() {
    const datosGuardados = localStorage.getItem('seguimiento_datos');
    if (!datosGuardados) return;

    try {
        const datos = JSON.parse(datosGuardados);
        const form = document.getElementById('mainForm');

        Object.keys(datos).forEach(key => {
            const elementos = form.elements[key];
            if (!elementos) return;

            if (elementos.length > 1) {
                elementos.forEach((elemento, index) => {
                    const valor = Array.isArray(datos[key]) ? datos[key][index] : datos[key];
                    setValorCampo(elemento, valor);
                });
            } else {
                setValorCampo(elementos, datos[key]);
            }
        });
    } catch (error) {
        console.error('Error al cargar datos:', error);
    }
}

function setValorCampo(campo, valor) {
    if (!campo) return;

    if (campo.type === 'checkbox') {
        campo.checked = valor === 'on' || valor === true || valor === 'true';
    } else if (campo.type === 'radio') {
        if (campo.value === valor) campo.checked = true;
    } else {
        campo.value = valor || '';
    }
}

// ================================================================
// FUNCIONES AUXILIARES
// ================================================================

window.volverMenu = function() {
    console.log("Navegando hacia el menú...");
    const form = document.getElementById('mainForm');
    if (form && detectarCambios()) {
        if (confirm('⚠️ Tienes cambios sin guardar.\n\n¿Deseas guardar antes de salir?')) {
            guardarFormulario();
            return;
        }
    }
    window.location.href = '/admin/menu';
};

function detectarCambios() {
    const form = document.getElementById('mainForm');
    if (!form) return false;

    const formData = new FormData(form);
    for (let [key, value] of formData.entries()) {
        if (value && value.trim() !== '') return true;
    }
    return false;
}

function agregarFila() {
    const tbody = document.getElementById("cronogramaBody");
    if (!tbody) return;

    const index = tbody.rows.length;
    const row = tbody.insertRow();

    row.innerHTML = `
        <td><input type="date" name="paso2DTO.cronogramaDTO[${index}].fecha" class="input-fecha-tabla"></td>
        <td><input type="text" name="paso2DTO.cronogramaDTO[${index}].situacion" class="input-tabla"></td>
        <td><input type="text" name="paso2DTO.cronogramaDTO[${index}].actuacion" class="input-tabla"></td>
        <td><input type="text" name="paso2DTO.cronogramaDTO[${index}].documento" class="input-tabla"></td>
        <td><input type="text" name="paso2DTO.cronogramaDTO[${index}].observaciones" class="input-tabla"></td>
    `;

    row.querySelectorAll('input').forEach(input => {
        input.addEventListener('change', guardarEnLocalStorage);
    });

    setTimeout(() => guardarEnLocalStorage(), 100);
    mostrarNotificacion('➕ Fila añadida al cronograma', 'info');
}

function configurarAutoguardado() {
    setInterval(() => {
        guardarEnLocalStorage();
        console.log('💾 Autoguardado ejecutado');
    }, 30000);
}

function mostrarNotificacion(mensaje, tipo = 'success') {
    const notification = document.getElementById('saveNotification');
    const icon = document.getElementById('notificationIcon');
    const text = document.getElementById('notificationText');

    if (!notification) return;

    if (tipo === 'warning') {
        notification.style.background = 'linear-gradient(135deg, #FF9800, #F57C00)';
        icon.textContent = '⚠️';
    } else if (tipo === 'info') {
        notification.style.background = 'linear-gradient(135deg, #2196F3, #1976D2)';
        icon.textContent = '💡';
    } else if (tipo === 'error') {
        notification.style.background = 'linear-gradient(135deg, #f44336, #d32f2f)';
        icon.textContent = '❌';
    } else {
        notification.style.background = 'linear-gradient(135deg, #4CAF50, #45a049)';
        icon.textContent = '✓';
    }

    text.textContent = mensaje;
    notification.style.opacity = '1';
    notification.style.transform = 'translateY(0)';

    setTimeout(() => {
        notification.style.opacity = '0';
        notification.style.transform = 'translateY(100px)';
    }, 3000);
}

// ================================================================
// ATAJOS DE TECLADO
// ================================================================

document.addEventListener('keydown', function(e) {
    if ((e.ctrlKey || e.metaKey) && e.key === 's') {
        e.preventDefault();
        guardarFormulario();
    }
    if ((e.ctrlKey || e.metaKey) && e.key === 'ArrowRight') {
        e.preventDefault();
        if (pasoActual < TOTAL_PASOS) avanzarPaso();
    }
    if ((e.ctrlKey || e.metaKey) && e.key === 'ArrowLeft') {
        e.preventDefault();
        if (pasoActual > 1) retrocederPaso();
    }
});

console.log(`
╔═══════════════════════════════════════════════════════════╗
║   📋 SISTEMA DE SEGUIMIENTO DE CASOS                      ║
║   Formulario Progresivo v1.0                              ║
║   ✅ Guardado automático | ✅ Validación                  ║
║   Atajos: Ctrl+S (Guardar) | Ctrl+← → (Navegar)          ║
╚═══════════════════════════════════════════════════════════╝
`);