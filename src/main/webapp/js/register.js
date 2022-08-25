const isEmpty = (str) => str.trim() === '';

function acceder()  {
    
    var dni = document.getElementById('usuario');
    var clave = document.getElementById('clave');
    
    dniVal = dni.value;
    claveVal = clave.value;
    

    
    if(window.XMLHttpRequest){
        ajax = new XMLHttpRequest();
    }
    else{
        ajax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    ajax.onreadystatechange = function() {
        if(ajax.readyState === 4 && ajax.status === 200){
            if(ajax.responseText.trim().includes("OK")){
                window.location.href = "inicio.jsp";
            } else {      
                alert(ajax.responseText);
            }
        }
    };
    
    ajax.open("POST","Login");
    ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.send("usuario=" + dniVal + "&clave=" + claveVal);
}
function clean(){
    var dni = document.getElementById('DNI');
    var clave = document.getElementById('clave');
    var claveAgain = document.getElementById('claveAgain');
    dni.value = '';
    clave.value = '';
    claveAgain = '';
}

function asignar(){
    
    btnAgregar = document.getElementById('btnAcceder');
    btnClean = document.getElementById('btnClean');
    btnClean.addEventListener("click",clean);
    btnAgregar.addEventListener("click",acceder);
}

window.addEventListener("load",asignar);