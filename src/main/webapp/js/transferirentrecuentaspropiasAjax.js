function exec(){
    var cuentaid_origen = document.getElementById('origen').value;
    var cuentaid_destino = document.getElementById('destino').value;
    var monto = document.getElementById('monto').value;
    /*
    var programado = document.getElementById('programado').value;
    var fechavence = document.getElementById('fechavence').value;
    var descripcion = document.getElementById('descripcion').value;
    var tipoperacion = document.getElementById('tipooperacion').value;
  */
    if(window.XMLHttpRequest){
        ajax = new XMLHttpRequest();
    }
    else{
        ajax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //let contenido = document.getElementById("tbody");
    ajax.onreadystatechange = function(){
        if(ajax.readyState === 4 && ajax.status === 200){
            //contenido.innerHTML = ajax.responseText;
        }
    }
    ajax.open("POST","TransferirEntreCuentasPropias");
    ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.send("origen=" + cuentaid_origen + "&destino=" + cuentaid_destino + "&monto=" + monto);
}

function asignar() {
    var btnConfirm = document.getElementById("btnConfirmar");
    btnConfirm.addEventListener("click",exec);
}
window.addEventListener("load",asignar);


