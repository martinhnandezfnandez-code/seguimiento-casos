// ================================================================
// FORMULARIO PROGRESIVO - SISTEMA DE SEGUIMIENTO DE CASOS
// Adaptado para usar el CSS existente del proyecto
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

    // 1️⃣ Limpiar localStorage SOLO del formulario
    localStorage.removeItem('seguimiento_progreso');
    localStorage.removeItem('seguimiento_datos');

    // 2️⃣ Resetear variables
    pasoActual = 1;
    pasosCompletados = new Set();

    // 3️⃣ Resetear formulario visual
    const form = document.getElementById('mainForm');
    if (form) {
        form.reset();
    }

    // 4️⃣ Resetear pasos visuales
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
    // Autoguardar al cambiar cualquier campo
    document.querySelectorAll('input, textarea, select').forEach(campo => {
        campo.addEventListener('change', function() {
            guardarEnLocalStorage();
        });

        // Quitar indicador de error al escribir
        campo.addEventListener('input', function() {
            this.classList.remove('campo-invalido');
        });
    });

    // Confirmar antes de salir si hay cambios sin guardar
    window.addEventListener('beforeunload', function(e) {
        guardarEnLocalStorage();
    });
}

// ================================================================
// NAVEGACIÓN ENTRE PASOS
// ================================================================

function togglePaso(numeroPaso) {
    const pasoContainer = document.querySelector(`.paso-container[data-paso="${numeroPaso}"]`);

    // Si está bloqueado, no hacer nada
    if (pasoContainer.classList.contains('locked')) {
        mostrarNotificacion('⚠️ Completa los pasos anteriores primero', 'warning');
        return;
    }

    const body = pasoContainer.querySelector('.paso-body');
    const isExpanded = body.classList.contains('expanded');

    // Contraer todos los pasos
    document.querySelectorAll('.paso-body').forEach(b => b.classList.remove('expanded'));
    document.querySelectorAll('.paso-container').forEach(c => c.classList.remove('active'));

    // Expandir el paso clickeado si no estaba expandido
    if (!isExpanded) {
        body.classList.add('expanded');
        pasoContainer.classList.add('active');
        pasoActual = numeroPaso;

        // Scroll suave hacia el paso
        setTimeout(() => {
            pasoContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);
    }
}

function avanzarPaso() {
    // Validar el paso actual
    if (!validarPasoActual()) {
        mostrarNotificacion('⚠️ Por favor, completa todos los campos requeridos', 'warning');
        return;
    }

    // Marcar como completado
    pasosCompletados.add(pasoActual);

    // Actualizar estado visual del paso completado
    const pasoContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
    pasoContainer.classList.add('completed');
    pasoContainer.classList.remove('active');
    pasoContainer.querySelector('.paso-body').classList.remove('expanded');
    pasoContainer.querySelector('.status-icon').textContent = '✓';
    pasoContainer.querySelector('.status-text').textContent = 'Completado';

    // Desbloquear siguiente paso
    const siguientePaso = pasoActual + 1;
    if (siguientePaso <= TOTAL_PASOS) {
        const siguienteContainer = document.querySelector(`.paso-container[data-paso="${siguientePaso}"]`);
        siguienteContainer.classList.remove('locked');
        siguienteContainer.classList.add('active');
        siguienteContainer.querySelector('.paso-body').classList.add('expanded');
        siguienteContainer.querySelector('.status-icon').textContent = '🔓';
        siguienteContainer.querySelector('.status-text').textContent = 'En progreso';

        pasoActual = siguientePaso;

        // Scroll hacia el siguiente paso
        setTimeout(() => {
            siguienteContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 100);
    }

    // Guardar progreso
    guardarProgreso();
    actualizarBarraProgreso();
    actualizarBotones();
    mostrarNotificacion('✓ Paso completado correctamente');
}

function retrocederPaso() {
    const anteriorPaso = pasoActual - 1;
    if (anteriorPaso >= 1) {
        // Contraer paso actual
        const pasoActualContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
        pasoActualContainer.classList.remove('active');
        pasoActualContainer.querySelector('.paso-body').classList.remove('expanded');

        // Expandir paso anterior
        const anteriorContainer = document.querySelector(`.paso-container[data-paso="${anteriorPaso}"]`);
        anteriorContainer.classList.add('active');
        anteriorContainer.querySelector('.paso-body').classList.add('expanded');

        pasoActual = anteriorPaso;

        // Scroll hacia el paso anterior
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

    // Mostrar/ocultar botón anterior
    if (btnPrev) {
        btnPrev.style.display = pasoActual === 1 ? 'none' : 'inline-flex';
    }

    // En el último paso, cambiar texto del botón
    if (btnNext) {
        if (pasoActual === TOTAL_PASOS) {
            btnNext.textContent = '✓ Finalizar y Enviar';
            btnNext.type = 'button'; // Mantener como button para controlar el submit
            btnNext.onclick = function() {
                finalizarFormulario();
            };
        } else {
            btnNext.textContent = 'Siguiente →';
            btnNext.type = 'button';
            btnNext.onclick = function() {
                avanzarPaso();
            };
        }
    }
}

function actualizarCirculosProgreso() {
    // Esta función ya no es necesaria con el nuevo diseño
    // Se mantiene por compatibilidad
}

function actualizarEstadoPaso(numPaso, estado) {
    const pasoContainer = document.querySelector(`.paso-container[data-paso="${numPaso}"]`);

    if (pasoContainer) {
        pasoContainer.classList.remove('active', 'completed', 'locked');
        pasoContainer.classList.add(estado);
    }
}

// ================================================================
// FINALIZACIÓN DEL FORMULARIO
// ================================================================

function finalizarFormulario() {
    // Validar el último paso
    if (!validarPasoActual()) {
        mostrarNotificacion('⚠️ Por favor, completa todos los campos requeridos', 'warning');
        return;
    }

    // Marcar último paso como completado
    pasosCompletados.add(pasoActual);

    // Guardar progreso final
    guardarProgreso();

    // Mostrar notificación
    mostrarNotificacion('✓ Guardando formulario...', 'info');

    // Pequeña pausa para que el usuario vea la notificación
    setTimeout(() => {
        const form = document.getElementById('mainForm');

        if (!form) {
            mostrarNotificacion('❌ Error: No se encontró el formulario', 'error');
            return;
        }

        // Limpiar localStorage después de enviar exitosamente
        localStorage.removeItem('seguimiento_progreso');
        localStorage.removeItem('seguimiento_datos');

        // Enviar el formulario al servidor
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

            if (!primerCampoInvalido) {
                primerCampoInvalido = campo;
            }
        } else {
            campo.classList.remove('campo-invalido');
        }
    });

    // Scroll al primer campo inválido
    if (primerCampoInvalido) {
        setTimeout(() => {
            primerCampoInvalido.scrollIntoView({ behavior: 'smooth', block: 'center' });
            primerCampoInvalido.focus();
        }, 100);
    }

    return todosValidos;
}

function validarCampo(campo) {
    // Checkbox: verificar si es parte de un grupo
    if (campo.type === 'checkbox') {
        const grupo = campo.closest('.checkbox-group');
        if (grupo) {
            const algunoMarcado = Array.from(grupo.querySelectorAll('input[type="checkbox"]'))
                .some(cb => cb.checked);
            return algunoMarcado;
        }
        return campo.checked;
    }

    // Radio: verificar si alguno está seleccionado
    if (campo.type === 'radio') {
        const nombre = campo.name;
        return document.querySelector(`input[name="${nombre}"]:checked`) !== null;
    }

    // Otros campos: verificar que no estén vacíos
    return campo.value.trim() !== '';
}

// ================================================================
// GUARDADO Y RECUPERACIÓN
// ================================================================

function guardarFormulario() {
    // Guardado local (por seguridad)
    guardarProgreso();

    const form = document.getElementById('mainForm');

    if (!form) {
        mostrarNotificacion('❌ No se encontró el formulario', 'error');
        return;
    }

    mostrarNotificacion('💾 Guardando borrador...', 'info');

    // ENVÍA AL CONTROLADOR @PostMapping("/guardar")
    setTimeout(() => {
        form.submit();
    }, 500);
}

window.volverMenu = function () {
    console.log("Navegando hacia la lista de alumnos...");

    const cambios = detectarCambios(); // Función que ya tienes en tu JS de edición

    if (cambios) {
        const confirmarSalida = confirm(
            '⚠️ Tienes cambios sin guardar.\n\n¿Deseas guardar antes de salir?'
        );

        if (confirmarSalida) {
            guardarFormulario();
            return; // Detenemos la navegación para que primero se ejecute el guardado
        }
    }
    // Redirige al menú principal usando URL absoluta
    window.location.href = window.location.origin + '/';
};


function exportarFormulario() {
    const datosGuardados = localStorage.getItem('seguimiento_datos');
    const progresoGuardado = localStorage.getItem('seguimiento_progreso');

    if (!datosGuardados) {
        mostrarNotificacion('⚠️ No hay datos para exportar', 'warning');
        return;
    }

    const exportData = {
        progreso: JSON.parse(progresoGuardado || '{}'),
        datos: JSON.parse(datosGuardados),
        exportadoEn: new Date().toISOString()
    };

    const blob = new Blob([JSON.stringify(exportData, null, 2)], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `seguimiento_caso_${new Date().toISOString().split('T')[0]}.json`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    mostrarNotificacion('📥 Datos exportados correctamente');
}

function guardarPasoActual() {
    guardarEnLocalStorage();
    guardarProgreso();
    mostrarNotificacion('💾 Progreso guardado correctamente', 'success');
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

    // Guardar todos los valores del formulario
    for (let [key, value] of formData.entries()) {
        if (datos[key]) {
            // Si ya existe, convertir a array
            if (!Array.isArray(datos[key])) {
                datos[key] = [datos[key]];
            }
            datos[key].push(value);
        } else {
            datos[key] = value;
        }
    }

    // Guardar checkboxes no marcados también
    form.querySelectorAll('input[type="checkbox"]').forEach(cb => {
        if (!cb.checked && cb.name) {
            datos[cb.name] = false;
        }
    });

    localStorage.setItem('seguimiento_datos', JSON.stringify(datos));
}

function cargarProgresoGuardado() {
    // Cargar progreso de pasos
    const progresoGuardado = localStorage.getItem('seguimiento_progreso');

    if (progresoGuardado) {
        try {
            const progreso = JSON.parse(progresoGuardado);
            pasoActual = progreso.pasoActual || 1;
            pasosCompletados = new Set(progreso.pasosCompletados || []);

            // Restaurar estado visual
            pasosCompletados.forEach(numeroPaso => {
                const pasoContainer = document.querySelector(`.paso-container[data-paso="${numeroPaso}"]`);
                if (pasoContainer) {
                    pasoContainer.classList.add('completed');
                    pasoContainer.classList.remove('locked');
                    pasoContainer.querySelector('.status-icon').textContent = '✓';
                    pasoContainer.querySelector('.status-text').textContent = 'Completado';
                }
            });

            // Desbloquear todos los pasos hasta el actual
            for (let i = 1; i <= pasoActual; i++) {
                const pasoContainer = document.querySelector(`.paso-container[data-paso="${i}"]`);
                if (pasoContainer && !pasosCompletados.has(i)) {
                    pasoContainer.classList.remove('locked');
                }
            }

            // Activar paso actual
            const pasoActualContainer = document.querySelector(`.paso-container[data-paso="${pasoActual}"]`);
            if (pasoActualContainer) {
                pasoActualContainer.classList.add('active');
                pasoActualContainer.querySelector('.paso-body').classList.add('expanded');

                // Contraer paso 1 si no es el actual
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

    // Cargar datos del formulario
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

            // Si es una NodeList (múltiples elementos con el mismo name)
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
        if (campo.value === valor) {
            campo.checked = true;
        }
    } else {
        campo.value = valor || '';
    }
}

// ================================================================
// AUTOGUARDADO
// ================================================================

function configurarAutoguardado() {
    // Autoguardar cada 30 segundos
    setInterval(() => {
        guardarEnLocalStorage();
        console.log('💾 Autoguardado ejecutado');
    }, 30000);
}

// ================================================================
// NOTIFICACIONES
// ================================================================

function mostrarNotificacion(mensaje, tipo = 'success') {
    const notification = document.getElementById('saveNotification');
    const icon = document.getElementById('notificationIcon');
    const text = document.getElementById('notificationText');

    if (!notification) return;

    // Configurar icono y color según tipo
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

    // Mostrar notificación
    notification.style.opacity = '1';
    notification.style.transform = 'translateY(0)';

    // Ocultar después de 3 segundos
    setTimeout(() => {
        notification.style.opacity = '0';
        notification.style.transform = 'translateY(100px)';
    }, 3000);
}

// ================================================================
// FUNCIONES AUXILIARES
// ================================================================

// Función para la tabla del cronograma (Paso 2)
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

    // Configurar eventos en los nuevos campos
    row.querySelectorAll('input').forEach(input => {
        input.addEventListener('change', guardarEnLocalStorage);
    });

    // Guardar automáticamente
    setTimeout(() => guardarEnLocalStorage(), 100);

    mostrarNotificacion('➕ Fila añadida al cronograma', 'info');
}

// Reiniciar formulario completo
function reiniciarFormulario() {
    if (confirm('⚠️ ¿Estás seguro de que quieres reiniciar todo el formulario?\n\nEsta acción eliminará todo el progreso guardado y no se puede deshacer.')) {
        localStorage.removeItem('seguimiento_progreso');
        localStorage.removeItem('seguimiento_datos');
        location.reload();
    }
}

// Exportar datos a JSON
function exportarDatos() {
    const datosGuardados = localStorage.getItem('seguimiento_datos');
    const progresoGuardado = localStorage.getItem('seguimiento_progreso');

    if (!datosGuardados) {
        mostrarNotificacion('⚠️ No hay datos para exportar', 'warning');
        return;
    }

    const exportData = {
        progreso: JSON.parse(progresoGuardado || '{}'),
        datos: JSON.parse(datosGuardados),
        exportadoEn: new Date().toISOString(),
        version: '1.0'
    };

    const blob = new Blob([JSON.stringify(exportData, null, 2)], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `seguimiento_caso_${new Date().toISOString().split('T')[0]}.json`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    mostrarNotificacion('📥 Datos exportados correctamente', 'success');
}

// ================================================================
// ATAJOS DE TECLADO
// ================================================================

document.addEventListener('keydown', function(e) {
    // Ctrl/Cmd + S para guardar
    if ((e.ctrlKey || e.metaKey) && e.key === 's') {
        e.preventDefault();
        guardarFormulario();
    }

    // Ctrl/Cmd + → para avanzar
    if ((e.ctrlKey || e.metaKey) && e.key === 'ArrowRight') {
        e.preventDefault();
        if (pasoActual < TOTAL_PASOS) {
            avanzarPaso();
        }
    }

    // Ctrl/Cmd + ← para retroceder
    if ((e.ctrlKey || e.metaKey) && e.key === 'ArrowLeft') {
        e.preventDefault();
        if (pasoActual > 1) {
            retrocederPaso();
        }
    }
});

// ================================================================
// LOG DE INICIALIZACIÓN
// ================================================================

console.log(`
╔═══════════════════════════════════════════════════════════╗
║                                                           ║
║   📋 SISTEMA DE SEGUIMIENTO DE CASOS                      ║
║   Formulario Progresivo v1.0                              ║
║                                                           ║
║   ✅ Guardado automático cada 30 segundos                 ║
║   ✅ Barra de progreso visual                             ║
║   ✅ Navegación entre pasos                               ║
║   ✅ Validación de campos requeridos                      ║
║                                                           ║
║   Atajos de teclado:                                      ║
║   • Ctrl/Cmd + S: Guardar                                 ║
║   • Ctrl/Cmd + →: Siguiente paso                          ║
║   • Ctrl/Cmd + ←: Paso anterior                           ║
║                                                           ║
╚═══════════════════════════════════════════════════════════╝
`);

/* ================================================================
   BOTONES FLOTANTES (Guardar y Volver Arriba)
   ================================================================ */

.btn-floating-save, .btn-floating-top {
    position: fixed;
    right: 30px;
    width: 60px;
    height: 60px;
    border-radius: 50%;
    border: none;
    color: white;
    font-size: 24px;
    cursor: pointer;
    box-shadow: 0 4px 15px rgba(0,0,0,0.3);
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 1000;
    transition: all 0.3s ease;
}

/* Botón Guardar (Verde) */
.btn-floating-save {
    bottom: 30px;
    background: linear-gradient(135deg, #4CAF50, #45a049);
}

/* Botón Volver Arriba (Marrón institucional) */
.btn-floating-top {
    bottom: 105px; /* Encima del de guardar */
    background: linear-gradient(135deg, #8B4513, #A0522D);
    opacity: 0; /* Empezamos invisible */
    visibility: hidden;
}

/* Efectos Hover */
.btn-floating-save:hover, .btn-floating-top:hover {
    transform: scale(1.1) translateY(-5px);
    box-shadow: 0 6px 20px rgba(0,0,0,0.4);
}

/* Clase para mostrar el botón de arriba al hacer scroll */
.btn-floating-top.visible {
    opacity: 1;
    visibility: visible;
}