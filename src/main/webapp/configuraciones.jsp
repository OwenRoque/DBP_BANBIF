<%@page import="modelo.dto.ClienteConectadoDto"%>
<%@page import="modelo.dto.ClienteDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClienteConectadoDto cc= (ClienteConectadoDto) session.getAttribute("cliente");
    ClienteDto informacion =  (ClienteDto) session.getAttribute("informacion");
    
    if(session.getAttribute("cliente_id") == null){
        session.invalidate();
        response.sendRedirect("index.html");
        return;
    }
%> 
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>BanBif Banking</title>
    <link rel="stylesheet" href="css/estilos_configuraciones.css">
    <link rel="stylesheet" href="css/pagar_styles.css"/>
    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
    <script src="js/editarConfiguracionAjax.js"> </script>
    <script>
    function abrir_menupagar(){
        document.getElementById('menu_pagar').showModal();
    }
    function abrir_bienvenido(){
        document.getElementById('menu_bienvenido').showModal();
    }  
    function abrir_menutransferencias(){
        document.getElementById('menu_transferencias').showModal();
    }
    function abrir_tipodecambio(){
        const url = "TipoDeCambio"; // servlet
        const params = {
            headers: { "content-type": "application/json; charset=UTF-8" },
            method: 'GET'
        };
        fetch(url, params)
                .then(data => { return data.json(); })
                .then(res => { 
                    document.getElementById("compraeuros").innerHTML = res.compraeuros;
                    document.getElementById("ventaeuros").innerHTML = res.ventaeuros;
                    document.getElementById("comprausd").innerHTML = res.comprausd;
                    document.getElementById("ventausd").innerHTML = res.ventausd;
                    document.getElementById("menu_tipodecambio").showModal();
                    console.log(res);
                })
                .catch(error => console.log(error));    
    }
    // Solo de la pagina
    function abrir_cambiodatospersonales(){
        document.getElementById('EditarDatosPersonales').showModal();
    }
    function abrir_cambiarcontra(){
        document.getElementById("cambiar_contra").showModal();
    }
    
    document.addEventListener("click",() =>{
        document.getElementById('menu_pagar').close();  
        document.getElementById('menu_bienvenido').close();  
        document.getElementById('menu_transferencias').close();
        document.getElementById('menu_tipodecambio').close();
    });
    </script>
</head>
<body>
    <!-- Navbar -->
    <header class="header">
        <div class="container" >
            <div class="btn-menu">
                <label for="btn-menu">☰</label>
            </div>
            <div class="logo">
                <h1><img class ="logoo" src="icons/logo.png" width="110" height="30"></h1>
            </div>
            <nav class="menu" >
                <a href="#">
                    <img src="icons/imbox.png" width="20px" height="20px" class="img1">
                </a>
                <a href="javascript:abrir_bienvenido()">
                    <i class="fas fa-chevron-down"></i>
                    <%= cc.getRazon() %>
                </a>
                <a href="CerrarSesion">
                    <img src="icons/logout.png" width="20px" height="20px" class="img1">
                </a>
            </nav>
        </div>
    </header>
                
    <!-- Sidebav -->
    <div class="body-container">
        <div class="container-left">
            <div class="menu">
                <nav>
                    <ul>						
                        <li>
                            <a href="inicio.jsp" class="etiquetas">
                                <img src="icons/inicio.png" width="30px" height="30px" class="img1">
                                <br> Inicio<p></p>
                            </a>
                        </li>	
                        <li>
                            <a href="operaciones.jsp" class="etiquetas" >
                                <img src="icons/estrella.png" width="30px" height="30px" class="img1">
                                <br>Operaciones Frecuentes<p></p>
                            </a>
                        </li>	
                        <li>
                            <a href="javascript:abrir_menutransferencias()" class="etiquetas" >
                                <img src="icons/transfer.png" width="30px" height="30px" class="img1"> <!-- class="nav-btn-submenu" -->
                                <br>Transferir<p></p>
                            </a>
                        </li>	
                        <li>
                            <a href="javascript:abrir_menupagar()" class="etiquetas" >
                                <img src="icons/pagar.png" width="30px" height="30px" class="img1">
                                <br>Pagar<p></p>
                            </a>
                        </li>	
                        <li>
                            <a href="ofertas.jsp" class="etiquetas" >
                                <img src="icons/ofertas.png" width="30px" height="30px" class="img1">
                                <br>Mis Ofertas<p></p>
                            </a>
                        </li>	
                        <li>
                            <a href="javascript:abrir_tipodecambio()" class="etiquetas" >
                                <img src="icons/cambio.png" width="30px" height="30px" class="img1">
                                <br>Tipo de Cambio<p></p>
                            </a>
                        </li>	
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <!-- Hidden Sidenav -->
    <input type="checkbox" id="btn-menu">
    <div class="container-menu">
        <div class="cont-menu">
            <nav>
                <a href="inicio.jsp">Inicio</a>
                <a href="operaciones.jsp">Operaciones Frecuentes</a>
                <a href="javascript:abrir_menutransferencias()">Transferir</a>
                <a href="javascript:abrir_menupagar()">Pagar</a>
                <a href="ofertas.jsp">Mis ofertas</a>
                <a href="javascript:abrir_tipodecambio()">Tipos de Cambio</a>
            </nav>
        </div>
    </div>
    
    <!-- Main Content -->
    <div class="contenido-text">
        <div class="titulo">
                <h1>Configuración Personal</h1>
        </div>
        <div class="container-divs">
            <div class="datos-col1">
                <div class="block-fixed">
                    <span>Datos Personales</span>
                    <div class="title-confipersonal"><a class="title-confipersonal" href="javascript:abrir_cambiodatospersonales()"> Cambiar</a></div>
                </div>
                <div class="blocks-container">
                    <div class="block">
                        <h3>Nombre Completo: </h3>
                        <h4><%= informacion.getRazon() %></h4>
                        <h3>Correo: </h3>
                        <h4> <%= informacion.getEmail() %> </h4>
                    </div>
                    <div class="block">
                        <h2> Personales</h2>
                        <div class="personal-data">
                            <div class="telefonos">
                                <div class ="telfonos-labels">
                                    <div class="etiquetatittle">Teléfono de casa:</div>
                                    <!-- TELEFONO POR JSP -->
                                    <div class="valor-tel"> 0 </div>
                                </div>
                                <div class ="telfonos-labels">
                                    <div class="etiquetatittle">Teléfono de celular:</div>
                                    <!-- TELEFONO POR JSP -->
                                    <div class="valor-tel"> ******** </div>    
                                </div>      
                            </div>
                            <label>
                                <div class="etiqueta">Nivel de estudio:</div>
                                <div class="valor"> <%= informacion.getNivelestudios() %>  </div>
                            </label>
                            <br>
                            <label>
                                <div class="etiqueta">Nacionalidad: </div>
                                <div class="valor"> <%= informacion.getNacionalidad() %></div>
                            </label>
                        </div>	
                    </div>
                    <div class="block">
                        <h2> Datos de Residencia</h2>
                        <div class="residencia-data">
                            <label for="">
                                <div class="etiqueta">Departamento:</div>
                                 <div class="valor"><%= informacion.getDepartamentoResidencia()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Provincia:</div>
                                 <div class="valor"><%= informacion.getProvinciaResidencia()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Distrito</div>
                                 <div class="valor"><%= informacion.getDistritoResidencia()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Via:</div>
                                 <div class="valor">----</div>
                            </label>
                            <br>
                            <div class="residencia">
                                <label for="">
                                    <div class="etiqueta">Dirección</div>
                                    <div class="valor"><%= informacion.getDireccion_residencia()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Numero:</div>
                                    <div class="valor"><%= informacion.getNumero_residencia()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Interior:</div>
                                    <div class="valor"><%= informacion.getInterior_residencia()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Urbanización:</div>
                                 <div class="valor"><%= informacion.getUrbanizacion_residencia()%></div>
                                </label>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div class="block">
                        <h2> Dirección Laboral</h2>
                        <div class="residencia-data">
                            <label for="">
                                <div class="etiqueta">Departamento:</div>
                                <div class="valor"><%= informacion.getDepartamentoLaboral()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Provincia:</div>
                                 <div class="valor"><%= informacion.getProvinciaLaboral()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Distrito</div>
                                 <div class="valor"><%= informacion.getDistritoLaboral()%></div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Via:</div>
                                 <div class="valor"><%= informacion.getVia_idc_laboral()%></div>
                            </label>
                            <br>
                            <div class="telefonos">
                                <label for="">
                                    <div class="etiqueta">Dirección</div>
                                    <div class="valor"><%= informacion.getDireccion_laboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Numero:</div>
                                    <div class="valor"><%= informacion.getNumero_laboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Interior:</div>
                                    <div class="valor"><%= informacion.getInterior_laboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Urbanización:</div>
                                    <div class="valor"><%= informacion.getUrbanizacion_laboral()%></div>
                                </label>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div class="block">
                        <h2> Datos Laborales</h2>
                        <div class="residencia-data">
                            <label for="">
                                <div class="etiqueta">Profesión:</div>
                                <div class="valor">----</div>
                            </label>
                            <br>
                            <div class="telefonos">
                                <label for="">
                                    <div class="etiqueta">Nombre de la Empresa:</div>
                                    <div class="valor"><%= informacion.getNombreempresa_datolaboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">RUC:</div>
                                    <div class="valor"><%= informacion.getRucempresa_datolaboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Rubro de la Empresa:</div>
                                    <div class="valor"><%= informacion.getRubroempresa_datolaboral()%></div>
                                </label>
                                <br>
                                <label for="">
                                    <div class="etiqueta">Nombre de Teléfono:</div>
                                    <div class="valor"><%= informacion.getTelefono_datolaboral()%></div>
                                </label>
                                <br>
                            </div>
                            <label for="">
                                <div class="etiqueta">Cargo:</div>
                                    <div class="valor"><%= informacion.getCargo_datolaboral()%></div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="datos-col2">
                <div class="datos-row1">
                    <div class="block-fixed-row1">Seguridad</div>
                    <div class="row-content">
                        <!-- CODIGO CADAD -->
                        <div class="row-content-divs">
                            <div class="seguridad">
                                <div>Contraseña</div>
                                <div>* ** *sd*as</div>
                                <div><a href="javascript:abrir_cambiarcontra()">Cambiar </a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="datos-row2">
                    <div class="block-fixed-row2">Otras Configuraciones</div>
                    <div class="row-content">
                        <div class="row-content-divs">
                            <label for="idiomas">
                                <div class="etiqueta">Idioma:</div>
                                <div class="valor">
                                    <select name="idiomas" id="idiomas">
                                        <option value="English">English</option>
                                        <option value="Español">Español</option>
                                    </select>
                                </div>
                            </label>
                        </div>
                        <div class="row-content-divs">
                            <label for="notificaiones">
                                <div class="etiqueta">Recibir notifiaciones por:</div>
                                <div class="valor">
                                    <select name="notificaiones" id="notificaiones">
                                        <option value="Email"> Email</option>
                                        <option value="Inbox">Inbox</option>
                                    </select>
                                </div>
                            </label>
                        </div>
                        <div class="row-content-divs">
                            <label for="notificaiones">
                                <div class="etiqueta">Modo de envio:</div>
                                <div class="valor"> -----</div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Cambiar Contrasena -->
    <dialog id="cambiar_contra" class="cambio_contra">
        <div class='Cabezera'>
            <div><h4>Cambiar Contraseña</h4></div>
            <div><a href='configuraciones.jsp'><img src="icons/logout.png" width="20px" height="20px" class="img1"></a></div>
        </div>
        <div class="formulario">
            <p style="color: black; width: 100%;padding: 5px;text-align: right;">|   Obligatorio</p>
            <div class="modificacion">
                <h5>Ultima modificacion</h5>
                <p style="font-size: 15px;">20/08/2022</p>
            </div>
            <div class="modificacion">
                <h5>Contraseña:</h5>
                <input type="text" id="Contrasena">
            </div>
            <div class="modificacion">
                <h5>Nueva Contraseña</h5>
                <input type="password" id="Nueva_Contrasena">
            </div>
            <div class="modificacion_1">
                <p>Contraseña debe tener al menos un caracter en mayúscula</p>
                <p>Contraseña debe tener al menos un caracter en minúscula</p>
                <p>El largo de la contraseña debe tener entre 8 y 10 caracteres</p>
                <p>Contraseña debe tener al menos un caracter especial[-,.;&%$,etc...]</p>
                <p>Contraseña debe tener al menos un caracter númerico</p>
            </div>
            <div class="modificacion">
                <h5 style='padding-top: 5px; '>Confirmación de contraseña</h5>
                <input type="password" id="Confirmacion">
            </div>
        </div>
    </dialog>
    
    <!-- Cambiar Datos Personasles -->
    <dialog id='EditarDatosPersonales' class="EditarDatosPersonales"> 
        <form class='FormularioPersonal'>
            <div class="block-fixed">Cambiar datos personales</div>
            <div class="blocks-container">
                <div class="block">
                    <h3>Nombre Completo: </h3>
                    <h4><%= informacion.getRazon()%></h4>
                    <h3>Correo: </h3>
                    <h4> <%= informacion.getEmail()%> </h4>
                </div>
                <div class="block">
                    <h2> Datos personales</h2>
                    <div class="personal-data">
                        <div class="telefonos">
                            <div class ="telfonos-labels">
                                <div class="etiquetatittle"> Teléfono de casa:</div>
                                <!-- TELEFONO POR JSP -->
                                <div class="valor-tel"> 0 </div>
                            </div>
                            <div class ="telfonos-labels">
                                <div class="etiquetatittle">Teléfono de celular:</div>
                                <!-- TELEFONO POR JSP -->
                                <div class="valor-tel"> ******** </div>    
                            </div>      
                        </div>
                        <label>
                            <div class="etiqueta">Nivel de estudio:</div>
                            <div class="valor">
                                <select name="nivel_estudio" id="nivel_estudio">
                                    <option>Elija una opción</option>
                                    <option value="Analfabeto">Analfabeto</option>
                                    <option value="Bachiller">Bachiller</option>
                                    <option value="Doctorado">Doctorado</option>
                                    <option value="Maestria">Maestria</option>
                                    <option value="Primaria">Primaria</option>
                                    <option value="Secundaria">Secundaria</option>
                                    <option value="Técnico">Técnico</option>
                                    <option value="Titualdo">Titualdo</option>
                                    <option value="Universidad Incompleta">Universidad Incompleta</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <label> 
                            <div class="etiqueta">Nacionalidad: </div>
                            <div class="valor">
                                <select name="nacionalidad" id="nacionalidad">
                                   <option value="Peru">Perú</option>
                                   <option value="Paraguay">Paraguay</option>
                                   <option value="Jamaica">Jamaica</option>
                                   <option value="Japan">Japan</option>
                                   <option value="Israel">Israel</option>
                                   <option value ="Iraq">Iraq</option>
                                   <option value="France">France</option>
                                   <option value="Ecuandor">Ecuador</option>
                                   <option value="Ethiopia">Ethiopia</option>
                                   <option value="Gabon">Gabon</option>
                               </select>
                            </div>
                        </label>
                    </div>	
                </div>
                <div class="block">
                    <h2> Datos de Residencia</h2>
                    <div class="residencia-data">
                        <label for="departamento">
                            <div class="etiqueta">Departamento:</div>
                            <div class="valor">
                                <select name="departamento_residencia" id="departamento_residencia">
                                    <option value="Arequipa">Arequipa</option>
                                    <option value="Ancash">Ancash</option>
                                    <option value="Cusco">Cusco</option>
                                    <option value="Cajamarca">Cajamarca</option>
                                    <option value="Huancavelica">Huancavelica</option>
                                    <option value="Huanuco">Huanuco</option>
                                    <option value="Ica">Ica</option>
                                    <option value="Junin">Junin</option>
                                    <option value="La libertad">La libertad</option>
                                    <option value="Lambayque">Lambayque</option>
                                    <option value="Lima">Lima</option>
                                    <option value="Loreto">Loreto</option>
                                    <option value="Madre de Dios">Madre de Dios</option>
                                    <option value="Moquegua">Moquegua</option>
                                    <option value="Pasco">Pasco</option>
                                    <option value="Piura">Piura</option>
                                    <option value="Puno">Puno</option>
                                    <option value="San Martin">San Martin</option>
                                    <option value="Tacna">Tacna</option>
                                    <option value="Tumbes">Tumbes</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <label for="via">
                            <div class="etiqueta">Via:</div>
                            <div class="valor">
                                <select name="via_residencia"  id="via_residencia">
                                    <option> Elija una opción</option>
                                    <option value="Alameda">ALAMEDA</option>
                                    <option value="Avenida">AVENIDA</option>
                                    <option value="Bajada">BAJADA</option>
                                    <option value="Calle">CALLE</option>
                                    <option value="Carretera">CARRETERA</option>
                                    <option value="Galeria">GALERIA</option>
                                    <option value="Jiron">JIRON</option>
                                    <option value="Melecon">MALECON</option>
                                    <option value="Manzana">MANZANA</option>
                                    <option value="Ovalo">OVALO</option>
                                    <option value="Parque">PARQUE</option>
                                    <option value="Pasaje">PASAJE</option>
                                    <option value="Plaza-Plazuela">PLAZ-PLAZUELA</option>
                                    <option value="Portal">PORTAL</option>
                                    <option value="Prolongacion">PROLONGACION</option>
                                    <option value="Rama">RAMA</option>
                                    <option value="Sub ramal">SUB RAMAL</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <div class="residencia">
                            <label for="direccion-residencia">
                                <div class="etiqueta">Dirección:</div>
                                <div class="valor">
                                    <input name="direccion_residencia" type="text" id="direccion_residencia" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="numero">
                                <div class="etiqueta">Número:</div>
                                <div class="valor">
                                    <input name="numero_residencia" id="numero_residencia" type="number" id="numero" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="interior">
                                <div class="etiqueta">Interior:</div>
                                <div class="valor">
                                    <input name="interior_residencia" id="interior_residencia" type="text" id="interior" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="urbanizacion">
                                <div class="etiqueta">Urbanización:</div>
                                <div class="valor">
                                    <input name="urbanizacion_residencia" id ="urbanizacion_residencia" type="text" id="urbanizacion" class="inputs-data">
                                </div>
                            </label>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <h2> Dirección Laboral</h2>
                    <div class="residencia-data">
                        <label for="departamento">
                            <div class="etiqueta">Departamento: </div>
                            <div class="valor">
                                <select name="departamento_laboral" id="departamento_laboral">
                                    <option value="Arequipa">Arequipa</option>
                                    <option value="Ancash">Ancash</option>
                                    <option value="Cusco">Cusco</option>
                                    <option value="Cajamarca">Cajamarca</option>
                                    <option value="Huancavelica">Huancavelica</option>
                                    <option value="Huanuco">Huanuco</option>
                                    <option value="Ica">Ica</option>
                                    <option value="Junin">Junin</option>
                                    <option value="La libertad">La libertad</option>
                                    <option value="Lambayque">Lambayque</option>
                                    <option value="Lima">Lima</option>
                                    <option value="Loreto">Loreto</option>
                                    <option value="Madre de Dios">Madre de Dios</option>
                                    <option value="Moquegua">Moquegua</option>
                                    <option value="Pasco">Pasco</option>
                                    <option value="Piura">Piura</option>
                                    <option value="Puno">Puno</option>
                                    <option value="San Martin">San Martin</option>
                                    <option value="Tacna">Tacna</option>
                                    <option value="Tumbes">Tumbes</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <label for="via">
                            <div class="etiqueta">Via: </div>
                            <div class="valor">
                                <select name="via_loboral" id="via_loboral">
                                    <option> Elija una opción</option>
                                    <option value="Alameda">ALAMEDA</option>
                                    <option value="Avenida">AVENIDA</option>
                                    <option value="Bajada">BAJADA</option>
                                    <option value="Calle">CALLE</option>
                                    <option value="Carretera">CARRETERA</option>
                                    <option value="Galeria">GALERIA</option>
                                    <option value="Jiron">JIRON</option>
                                    <option value="Melecon">MALECON</option>
                                    <option value="Manzana">MANZANA</option>
                                    <option value="Ovalo">OVALO</option>
                                    <option value="Parque">PARQUE</option>
                                    <option value="Pasaje">PASAJE</option>
                                    <option value="Plaza-Plazuela">PLAZ-PLAZUELA</option>
                                    <option value="Portal">PORTAL</option>
                                    <option value="Prolongacion">PROLONGACION</option>
                                    <option value="Rama">RAMA</option>
                                    <option value="Sub ramal">SUB RAMAL</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <div class="residencia">
                            <label for="direccion-residencia">
                                <div class="etiqueta">Dirección: </div>
                                <div class="valor">
                                    <input name="direccion_laboral" id="direccion_laboral" type="text" id="direccion" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="numero">
                                <div class="etiqueta">Número:</div>
                                <div class="valor">
                                    <input name="numero_laboral" id="numero_laboral" type="number" id="numero" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="interior">
                                <div class="etiqueta">Interior:</div>
                                <div class="valor">
                                    <input name="interior_laboral" id="interior_laboral" type="text" id="interior" class="inputs-data">
                                </div>

                            </label>
                            <br>
                            <label for="urbanizacion">
                                <div class="etiqueta">Urbanización:</div>
                                <div class="valor">
                                    <input name="urbanizacion_laboral" id="urbanizacion_laboral" type="text" id="urbanizacion" class="inputs-data">
                                </div>
                            </label>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="block">
                    <h2> Datos Laborales</h2>
                    <div class="residencia-data">
                        <label for="profesion">
                            <div class="etiqueta">Profesión:</div>
                            <div class="valor">
                                <select name="profesion" id="profesion">
                                    <option value="ABOGADO">ABOGADO</option>
                                    <option value="ACTOR,ACTRIZ">ACTOR,ACTRIZ</option>
                                    <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                                    <option value="ADUANERO">ADUANERO</option>
                                    <option value="ARQUITECTO">ARQUITECTO</option>
                                    <option value="ANTROPOLGO">ANTROPOLGO</option>
                                    <option value="CAJERO">CAJERO</option>
                                    <option value="CONTADOR">CONTADOR</option>
                                    <option value="CONTRATISTA">CONTRATISTA</option>
                                    <option value="DOCENTE">DOCENTE</option>
                                    <option value="ECONOMISTA">ECONOMISTA</option>
                                    <option value="EMPRESARIO">EMPRESARIO</option>
                                    <option value="ENFERMERO">ENFERMERO</option>
                                    <option value="INGENIERO">INGENIERO</option>
                                </select>
                            </div>
                        </label>
                        <br>
                        <div class="telefonos">
                            <label for="empresa">
                                <div class="etiqueta">Nombre de la Empresa:</div>
                                <div class="valor">
                                    <input name="nomre_empresa" id="nomre_empresa" type="text" id="empresa" class="inputs-data">
                                </div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">RUC:</div>
                            </label>
                            <br>
                            <label for="">
                                <div class="etiqueta">Rubro de la empresa: </div>
                            </label>
                            <br>
                            <label for="telefono-number">
                                <div class="etiqueta">Número de teléfono:</div>
                                <div class="valor">
                                    <input name="telefono_laboral" id="telefono_laboral" type="number" id="telefono-number" class="inputs-data">
                                </div>
                            </label>
                            <br>
                        </div>
                        <label for="cargo">
                            <div class="etiqueta">Cargo:</div>
                            <div class="valor">
                                <select name="cargo_laboral" id="cargo_laboral">
                                    <option value="ABOGADO">ABOGADO</option>
                                    <option value="ACTOR,ACTRIZ">ACTOR,ACTRIZ</option>
                                    <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                                    <option value="ADUANERO">ADUANERO</option>
                                    <option value="ARQUITECTO">ARQUITECTO</option>
                                    <option value="ANTROPOLGO">ANTROPOLGO</option>
                                    <option value="CAJERO">CAJERO</option>
                                    <option value="CONTADOR">CONTADOR</option>
                                    <option value="CONTRATISTA">CONTRATISTA</option>
                                    <option value="DOCENTE">DOCENTE</option>
                                    <option value="ECONOMISTA">ECONOMISTA</option>
                                    <option value="EMPRESARIO">EMPRESARIO</option>
                                    <option value="ENFERMERO">ENFERMERO</option>
                                    <option value="INGENIERO">INGENIERO</option>

                                </select>
                            </div>
                        </label>
                    </div>
                </div>
            </div>
            <div class="buttons-container">
                <input type="submit" value="Cancelar" class="btn">
                <input type="submit" value="Confirmar" class="btn" id="btnGuardar">
            </div>
        </form>
    </dialog>

    <!-- Menu Pagar -->
    <dialog class="menu_pagar" id="menu_pagar">
        <ul>
            <li>
                <img src="icons/creditcard.png" width="30px" height="30px">
                <a href="PagarMisTarjetas">
                 Mis Tarjetas Bambif</a>
            </li>
            <li><a href="pagarotrastarjetas.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                 Otras Tarjetas Bambif</a>
            </li>
            <li><a href="pagartarjetasdeotrosbancos.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                 Tarjetas de otros bancos</a>
            </li>
            <li><a href="pagartarjetasdiners.jsp"> <img src="icons/diners.png" width="30px" height="30px">
                 Tarjetas Diners</a>
            </li>
            <li><a href="prestamos.jsp"> <img src="icons/prestamos.png" width="30px" height="30px">
                 Prestamos</a>
            </li>
            <li><a href="servicios.jsp"> <img src="icons/servicios.png" width="30px" height="30px">
                 Servicios</a>
            </li>
        </ul>
    </dialog>

    <!-- Menu Bienvenido -->
    <dialog class='menu_bienvenido' id="menu_bienvenido">
        <div class="headermodal">
            <h3><%=cc.getRazon() %></h3>
        </div>
        <div class='MenuModifi'>
            
        </div>
        <div class="bodymodal">
            <a href="configuraciones.jsp">Cambiar contraseña</a>
            <a href="configuraciones.jsp">Cambiar datos personales</a>
            <a href="configuraciones.jsp">Configuración personal</a>
        </div>
    </dialog>
    
    <!-- Menu Transferencias -->
    <dialog class="menu_transferencias" id="menu_transferencias">
        <ul>
            <li><a href="transferirentrecuentaspropias.jsp"> <img src="icons/bank.png" width="30px" height="30px">
                Entre Cuentas Propias</a>
            </li>
            <li><a href="transferiraotrascuentas.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                 A Otras Cuentas Bambif</a>
            </li>
            <li><a href="transferiraotrosbancos.jsp"> <img src="icons/bank.png" width="30px" height="30px">
                 A otros bancos</a>
            </li>
            <li><a href="__transferiralexterior.jsp"> <img src="icons/mundo.png" width="30px" height="30px">
                 Al exterior</a>
            </li>
        </ul>
    </dialog>

    <!-- Menu Tipo de Cambio -->
    <dialog id="menu_tipodecambio" class="contenido-cambio">
        <h4 style="color: #fff; padding: 7px 10px">Tipo de cambio</h4>
        <div class="opciones">
           <div class="compra" style="border: 1px solid #999999; box-shadow: rgb(150,150,150) 5px 5px; color: #20a6ff;">Compra</div>
           <div class="Venta" style="border: 1px solid #999999; box-shadow: rgb(150,150,150) 5px 5px; color: #20a6ff;">Venta</div>
        </div>
        <div class="Monedas_Cambio">
            <h5 style="border-bottom: 1px solid #1f1f1f">
                <img src="icons/euro.png" width="20px" height="20px" class="img1" style="background: black">
                Euros
            </h5>
            <div class="opciones">
                <h4 id="compraeuros" class="compra"></h4>
                <h4 id="ventaeuros" class="Venta"></h4>
            </div>
        </div>
        <div class="Monedas_Cambio" style="border-radius: 0 0 10px 10px;">
            <h5 style="border-bottom: 1px solid #1f1f1f"> - Dolar-USA</h5>
            <div class="opciones">
                <h4 id="comprausd" class="compra"></h4>
                <h4 id="ventausd" class="Venta"></h4>
            </div>
        </div>
    </dialog>  
    
</body>
</html>