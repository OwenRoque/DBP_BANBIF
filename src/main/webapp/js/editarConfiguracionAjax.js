const isEmpty = (str) => str.trim() === '';

function acceder(){
    console.log(cargoLaboral+"sdfasdf");
    var nivelEstudio = document.getElementById("nivel_estudio").value;
    var nacionalidad = document.getElementById("nacionalidad").value;
    var departamentoResidencia = document.getElementById("departamento_residencia").value;
    var viaResidencia = document.getElementById("via_residencia").value;
    var direccionResidencia = document.getElementById("direccion_residencia").value;
    var numeroResidencia = document.getElementById("numero_residencia").value;
    var interiorResidencia = document.getElementById("interior_residencia").value;
    var urbanizacionResidenncia = document.getElementById("urbanizacion_residencia").value;
    
    
    var departamentoLaboral = document.getElementById("departamento_laboral").value;
    var viaLaboral = document.getElementById("via_loboral").value;
    var direccionLaboral = document.getElementById("direccion_laboral").value;
    var numeroLaboral = document.getElementById("numero_laboral").value;
    var interiorLaboral = document.getElementById("interior_laboral").value;
    var urbanizacionLaboral = document.getElementById("urbanizacion_laboral").value;
    
    var profesionLaboral = document.getElementById("profesion").value;
    var nombreEmpresa = document.getElementById("nomre_empresa").value;
    var telefonoLaboral = document.getElementById("telefono_laboral").value;
    var cargoLaboral = document.getElementById("cargo_laboral").value;
    
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
    };
    console.log(cargoLaboral+"sdfasdf");
    ajax.open("POST","ConfiguracionesInfo");
    ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.send("nivelEstudio=" + nivelEstudio + "&nacionalidad=" + nacionalidad + "&departamentoResidencia=" + departamentoResidencia + "&viaResidencia="+viaResidencia+"&direccionResidencia=" + direccionResidencia + "&numeroResidencia="+numeroResidencia+"&interiorResidencia="+interiorResidencia+"&urbanizacionResidenncia="+urbanizacionResidenncia+"&departamentoLaboral="+departamentoLaboral+"&viaLaboral="+viaLaboral+"&direccionLaboral="+direccionLaboral+"&numeroLaboral="+numeroLaboral+"&interiorLaboral="+interiorLaboral+"&urbanizacionLaboral="+urbanizacionLaboral+"&profesionLaboral="+profesionLaboral+"&nombreEmpresa="+nombreEmpresa+"&telefonoLaboral="+telefonoLaboral+"&cargoLaboral="+cargoLaboral);
    
}
function asignar(){
    
    btnAgregar = document.getElementById('btnGuardar');
    btnAgregar.addEventListener("click",acceder);
}

window.addEventListener("load",asignar);