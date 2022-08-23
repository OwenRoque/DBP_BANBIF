<%@page import="modelo.dto.ClienteConectadoDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClienteConectadoDto c=(ClienteConectadoDto) session.getAttribute("cliente");
    if(session.getAttribute("cliente_id") == null){
        session.invalidate();
        response.sendRedirect("index.html");
        return;
    }
%> 
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menù Lateral con Css</title>
    <link rel="stylesheet" href="css/estilos.css"/>
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
    document.addEventListener("click",() =>{
        document.getElementById('menu_pagar').close();  
        document.getElementById('menu_bienvenido').close();  
        document.getElementById('menu_transferencias').close();  

    });
</script>
</head>
<body>
    <header class="header">
        <div class="container">
            <div class="btn-menu">
                <label for="btn-menu">☰</label>
            </div>
            <div class="logo">
                <h1><img class ="logoo" src="icons/logo.png" width="110" height="30"></h1>
            </div>
            <nav class="menu">
                <a href="#">
                    <img src="icons/imbox.png" width="20px" height="20px" class="img1">
                </a>
                <a href="#">
                    <%= c.getRazon() %>
                </a>
                <a href="#">
                    <img src="icons/logout.png" width="20px" height="20px" class="img1">
                </a>
            </nav>
        </div>
    </header>
                
    <div class="body-container">
        <div class="container-left">
            <div class="menu">
                <nav>
                    <ul>						
                        <li>
                            <a href="home" class="etiquetas">
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
                            <a href="cambio.jsp" class="etiquetas" >
                                <img src="icons/cambio.png" width="30px" height="30px" class="img1">
                                <br>Tipo de Cambio<p></p>
                            </a>
                        </li>	
                    </ul>
                </nav>
            </div>
        </div>
    </div>
                
    <dialog class="menu_pagar" id="menu_pagar">
        <ul>
            <ul>
                <li><a href="PagarMisTarjetas"> <img src="icons/creditcard.png" width="30px" height="30px" class="img1">
                     Mis Tarjetas Bambif</a>
                </li>
                <li><a href="pagarotrastarjetas.jsp"> <img src="icons/creditcard.png" width="30px" height="30px" class="img1">
                     Otras Tarjetas Bambif</a>
                </li>
                <li><a href="pagartarjetasdeotrosbancos.jsp"> <img src="icons/creditcard.png" width="30px" height="30px" class="img1">
                     Tarjetas de otros bancos</a>
                </li>
                <li><a href="pagartarjetasdiners.jsp"> <img src="icons/diners.png" width="30px" height="30px" class="img1">
                     Tarjetas Diners</a>
                </li>
                <li><a href="prestamos.jsp"> <img src="icons/prestamos.png" width="30px" height="30px" class="img1"> 
                     Prestamos</a>
                </li>
                <li><a href="servicios.jsp"> <img src="icons/servicios.png" width="30px" height="30px" class="img1">
                     Servicios</a>
                </li>
            </ul>
        </ul>
    </dialog>
                
    <dialog class="menu_transferencias" id="menu_transferencias">
        <ul>
            <li>
                <img src="icons/bank.png" width="30px" height="30px"><a href="TranferirEntreCuentasPropias">
                 Entre Cuentas Propias</a>
            </li>
            <li><a href="TransferirAOtrasCuentas"> <img src="icons/creditcard.png" width="30px" height="30px">
                 A Otras Cuentas Bambif</a>
            </li>
            <li><a href="transferiraotrosbancos.jsp"> <img src="icons/bank.png" width="30px" height="30px">
                 A otros bancos</a>
            </li>
        </ul>
    </dialog>
<!--	--------------->
<input type="checkbox" id="btn-menu">
<div class="container-menu">
    <div class="cont-menu">
        <nav>
            <a href="inicio.jsp">Inicio</a>
            <a href="operaciones.jsp">Operaciones Frecuentes</a>
            <a href="javascript:abrir_menutransferencias()">Transferir</a>
            <a href="javascript:abrir_menupagar()">Pagar</a>
            <a href="ofertas.jsp">Mis ofertas</a>
            <a href="cambio.jsp">Tipos de Cambio</a>
        </nav>
        <label for="btn-menu">✖️</label>
    </div>
</div>

<div class="contenido-text">
    <h2>Contenido</h2>
    <h2>Contenido</h2>
    <h2>Contenido</h2>
    <h2>Contenido</h2>
    <h2>Contenido</h2>
</div>

</body>
</html>