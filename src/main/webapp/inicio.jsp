<%@page import="modelo.dto.TipoCuentaDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dbo.BDConexion"%>
<%@page import="modelo.dbo.CuentasBD"%>
<%@page import="modelo.dto.ClienteConectadoDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClienteConectadoDto cc= (ClienteConectadoDto) session.getAttribute("cliente");
    if(session.getAttribute("cliente_id") == null){
        session.invalidate();
        response.sendRedirect("index.html");
        return;
    }
    BDConexion conn = new BDConexion();
    CuentasBD cuenta = new CuentasBD(conn);
    ArrayList<TipoCuentaDto> alcuentas =  cuenta.getALLCuentasUsuario(cc.getId());
%> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BanBif Banking</title>
    <link rel="stylesheet" href="css/inicio.css"/>
    <link rel="stylesheet" href="css/pagar_styles.css"/>
    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
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
                <label for="btn-menu">???</label>
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
        <form class="search" target="_blank">
            <p>
                <input type="image" src="icons/search.png" width="15px" height="15px">
                <input type="search" name="busqueda" placeholder="Buscar...">
            </p>
        </form>
        <div class="full-box tile-container"> 
            <% for(TipoCuentaDto t : alcuentas) { %>
                <a href="ahorro.jsp"  class="tile">
                    <div class="tile-icon">    
                        <p><% out.println(t.getNombretipocuenta()); %></p>
                        <p><% out.println(t.getNombrealias()); %></p>
                    </div>
                    <div class="tile-cuenta"><% out.println(t.getNumcuenta()); %></div>
                    <div class="tile-saldo">
                        <p>Saldo Contable</p>
                        <p><% out.println(t.getSaldoContable()); %></p>
                    </div>
                    <div class="tile-saldo">
                        <p>Saldo Disponible</p>
                        <p><% out.println(t.getSaldoDisponible()); %></p>
                    </div>
                </a>
                <div class="dropdown">
                    <button>...</button>
                    <div class="dropdown-content">
                        <a href="">Ver Producto</a>
                        <a href="">Transferir</a>
                        <a href="">Pagar</a>
                        <a href="">Configurar alerta</a>
                        <a href="">Editar Alias</a>
                    </div>
                </div>
            <% } %>
        </div>
    </div>	
    
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
            <a href="ConfiguracionesInfo">Cambiar contrase??a</a>
            <a href="ConfiguracionesInfo">Cambiar datos personales</a>
            <a href="ConfiguracionesInfo">Configuraci??n personal</a>
        </div>
    </dialog>
    
    <!-- Menu Transferencias -->
    <dialog class="menu_transferencias" id="menu_transferencias">
        <ul>
            <li><a href="TransferirEntreCuentasPropias"> <img src="icons/bank.png" width="30px" height="30px">
                Entre Cuentas Propias</a>
            </li>
            <li><a href="TransferirAOtrasCuentasBambif"> <img src="icons/creditcard.png" width="30px" height="30px">
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