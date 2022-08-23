

function exec(){
    var tipoperacion = document.getElementById('tipooperacion').value;
    var tarjeta = document.getElementById('tarjeta').value;
    var monto = document.getElementById('monto').value;
    var cuenta = document.getElementById('cuenta').value;
    var descripcion = document.getElementById('descripcion').value;
    var programado = document.getElementById('programado').value;
    var fechavence = document.getElementById('fechavence').value;
    var frecuencia = document.getElementById('frecuencia').value;
    var token = document.getElementById('token').value;
    //no es ajax, POST es directo a servlet
    
}

function asignar() {
    var btnConfirm = document.getElementById("btnSubmit");
    btnConfirm.addEventListener("click",exec);
}
window.addEventListener("load",asignar);


