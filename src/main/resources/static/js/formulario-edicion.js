// ================================================================
// MODO EDICIÓN - SISTEMA DE SEGUIMIENTO DE CASOS
// ================================================================

console.log('📝 Modo edición cargado');

// ================================================================
// FUNCIONES ESPECÍFICAS PARA EDICIÓN
// ================================================================

function eliminarCaso() {
    if (confirm('⚠️ ¿Estás seguro de que deseas eliminar este caso?\n\nEsta acción no se puede deshacer.')) {
        const formularioId = document.querySelector('input[name="id"]')?.value;

        if (!formularioId) {
            mostrarNotificacion('❌ No se pudo obtener el ID del caso', 'error');
            return;
        }

        mostrarNotificacion('🗑️ Eliminando caso...', 'info');

        fetch(`/alumnado/eliminar/${formularioId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                mostrarNotificacion('✓ Caso eliminado correctamente', 'success');
                setTimeout(() => {
                    window.location.href = '/alumnado/listar';
                }, 1500);
            } else {
                mostrarNotificacion('❌ Error al eliminar el caso', 'error');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            mostrarNotificacion('❌ Error de conexión al eliminar el caso', 'error');
        });
    }
}

// ================================================================
// SOBRESCRIBIR FUNCIONES DEL FORMULARIO BASE
// ================================================================

// Sobrescribir la función guardarFormulario del formulario.js
function guardarFormulario() {
    const form = document.getElementById('mainForm');

    if (!form) {
        mostrarNotificacion('❌ No se encontró el formulario', 'error');
        return;
    }

    // Validar campos requeridos (opcional en modo edición)
    const camposInvalidos = form.querySelectorAll('.campo-invalido');
    if (camposInvalidos.length > 0) {
        mostrarNotificacion('⚠️ Hay campos con errores que necesitan corrección', 'warning');
        return;
    }

    mostrarNotificacion('💾 Guardando cambios...', 'info');

    // Usar el método original del formulario: submit directo
    setTimeout(() => {
        form.submit();
    }, 500);
}

window.volverMenu = function() {
    console.log("Navegando hacia la lista de alumnos...");

    const cambios = detectarCambios(); // Función que ya tienes en tu JS de edición

    if (cambios) {
        if (confirm('⚠️ Tienes cambios sin guardar.\n\n¿Deseas guardar antes de salir?')) {
            guardarFormulario();
            return; // Detenemos la salida para que se ejecute el guardado
        }
    }

    // Usamos la URL absoluta para evitar errores de ruta relativa
    window.location.href = window.location.origin + '/alumnado/listar';
};

// Sobrescribir exportarFormulario para modo edición
function exportarFormulario() {
    const form = document.getElementById('mainForm');
    const formData = new FormData(form);
    const datos = {};

    // Convertir FormData a objeto
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

    const exportData = {
        modo: 'edicion',
        id: document.querySelector('input[name="id"]')?.value,
        datos: datos,
        exportadoEn: new Date().toISOString(),
        version: '1.0'
    };

    const blob = new Blob([JSON.stringify(exportData, null, 2)], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `caso_${exportData.id}_${new Date().toISOString().split('T')[0]}.json`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    mostrarNotificacion('📥 Datos exportados correctamente', 'success');
}

// ================================================================
// DETECCIÓN DE CAMBIOS
// ================================================================

let valoresOriginales = {};

function capturarValoresOriginales() {
    const form = document.getElementById('mainForm');
    const formData = new FormData(form);

    for (let [key, value] of formData.entries()) {
        valoresOriginales[key] = value;
    }
}

function detectarCambios() {
    const form = document.getElementById('mainForm');
    const formData = new FormData(form);

    for (let [key, value] of formData.entries()) {
        if (valoresOriginales[key] !== value) {
            return true;
        }
    }

    return false;
}

// ================================================================
// INICIALIZACIÓN DEL MODO EDICIÓN
// ================================================================

document.addEventListener('DOMContentLoaded', function() {
    console.log('🚀 Inicializando modo edición...');

    const modo = document.getElementById('modoFormulario')?.value;

    if (modo !== 'edicion') {
        console.log('⚠️ No es modo edición, saltando inicialización específica');
        return;
    }

    // 1️⃣ Expandir todos los pasos
    document.querySelectorAll('.paso-body').forEach(body => {
        body.classList.add('expanded');
    });

    // 2️⃣ Desbloquear todos los pasos
    document.querySelectorAll('.paso-container').forEach(container => {
        container.classList.remove('locked');
        container.classList.add('unlocked', 'active');

        // Actualizar iconos y texto
        const statusIcon = container.querySelector('.status-icon');
        const statusText = container.querySelector('.status-text');

        if (statusIcon) statusIcon.textContent = '📝';
        if (statusText) statusText.textContent = 'Editable';
    });

    // 3️⃣ Deshabilitar clicks en headers (ya no colapsan)
    document.querySelectorAll('.paso-header').forEach(header => {
        header.style.cursor = 'default';
        header.onclick = null;
    });

    // 4️⃣ Capturar valores originales para detectar cambios
    capturarValoresOriginales();

    // 5️⃣ Configurar autoguardado (cada 60 segundos en modo edición)
    configurarAutoguardadoEdicion();

    // 6️⃣ Configurar advertencia al salir con cambios sin guardar
    window.addEventListener('beforeunload', function(e) {
        if (detectarCambios()) {
            e.preventDefault();
            e.returnValue = '¿Estás seguro de que quieres salir? Tienes cambios sin guardar.';
        }
    });

    // 7️⃣ Ocultar navegación de pasos (no se necesita en modo edición)
    const navegacion = document.querySelector('.paso-navigation');
    if (navegacion) {
        navegacion.style.display = 'none';
    }

    // 8️⃣ Ocultar barra de progreso (no aplica en modo edición)
    const progressContainer = document.querySelector('.progress-container');
    const progressText = document.querySelector('.progress-text');
    if (progressContainer) progressContainer.style.display = 'none';
    if (progressText) progressText.style.display = 'none';

    console.log('✅ Modo edición inicializado correctamente');
});

// ================================================================
// AUTOGUARDADO EN MODO EDICIÓN
// ================================================================

function configurarAutoguardadoEdicion() {
    // Autoguardar cada 60 segundos (más espaciado que en modo nuevo)
    setInterval(() => {
        if (detectarCambios()) {
            console.log('💾 Autoguardado: Cambios detectados');
            mostrarNotificacion('💾 Guardando cambios automáticamente...', 'info');
            guardarFormulario();
        }
    }, 60000); // 60 segundos
}

// ================================================================
// ATAJOS DE TECLADO PARA EDICIÓN
// ================================================================

document.addEventListener('keydown', function(e) {
    const modo = document.getElementById('modoFormulario')?.value;

    if (modo !== 'edicion') return;

    // Ctrl/Cmd + S para guardar
    if ((e.ctrlKey || e.metaKey) && e.key === 's') {
        e.preventDefault();
        guardarFormulario();
    }

    // Ctrl/Cmd + E para exportar
    if ((e.ctrlKey || e.metaKey) && e.key === 'e') {
        e.preventDefault();
        exportarFormulario();
    }

    // Ctrl/Cmd + Q para volver al menú
    if ((e.ctrlKey || e.metaKey) && e.key === 'q') {
        e.preventDefault();
        volverMenu();
    }
});

// ================================================================
// FUNCIONES AUXILIARES PARA EDICIÓN
// ================================================================

// Scroll suave al hacer click en un campo
document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('input, textarea, select').forEach(campo => {
        campo.addEventListener('focus', function() {
            this.scrollIntoView({ behavior: 'smooth', block: 'center' });
        });
    });
});

// Indicador visual de cambios guardados
let timeoutGuardado = null;

function marcarComoGuardado() {
    clearTimeout(timeoutGuardado);

    const botones = document.querySelectorAll('.btn-save, .btn-floating-save');
    botones.forEach(btn => {
        btn.style.background = 'linear-gradient(135deg, #4CAF50, #45a049)';
        btn.innerHTML = btn.classList.contains('btn-floating-save') ? '✓' : '✓ Guardado';
    });

    timeoutGuardado = setTimeout(() => {
        botones.forEach(btn => {
            btn.style.background = 'linear-gradient(135deg, #667eea, #764ba2)';
            btn.innerHTML = btn.classList.contains('btn-floating-save') ? '💾' : '💾 Guardar Cambios';
        });
    }, 3000);
}

// ================================================================
// LOG DE MODO EDICIÓN
// ================================================================

console.log(`
╔═══════════════════════════════════════════════════════════╗
║                                                           ║
║   ✏️  MODO EDICIÓN ACTIVADO                               ║
║   Sistema de Seguimiento de Casos                         ║
║                                                           ║
║   ✅ Todos los pasos desbloqueados                        ║
║   ✅ Autoguardado cada 60 segundos                        ║
║   ✅ Detección de cambios sin guardar                     ║
║                                                           ║
║   Atajos de teclado:                                      ║
║   • Ctrl/Cmd + S: Guardar                                 ║
║   • Ctrl/Cmd + E: Exportar                                ║
║   • Ctrl/Cmd + Q: Volver al menú                          ║
║                                                           ║
╚═══════════════════════════════════════════════════════════╝
`);

window.addEventListener('scroll', function () {
    const bar = document.getElementById('bottomBar');
    if (!bar) return;

    if (window.scrollY > 150) {
        bar.classList.add('visible');
    } else {
        bar.classList.remove('visible');
    }
});
