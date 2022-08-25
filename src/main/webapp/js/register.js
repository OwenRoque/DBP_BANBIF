const isEmpty = (str) => str.trim() === '';
function clean(){
    var dni = document.getElementById('DNI');
    var clave = document.getElementById('clave');
    var claveAgain = document.getElementById('claveAgain');
    dni.value = '';
    clave.value = '';
    claveAgain = '';
}

function asignar(){
    btnClean = document.getElementById('btnClean');
    btnClean.addEventListener("click",clean);
}

window.addEventListener("load",asignar);