<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("usuario") == null){
        session.invalidate();
        response.sendRedirect("index.html");
        return;
    }
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/transferir_styles.css"/>
        <link rel="stylesheet" href="css/pagar_styles.css"/>
        <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
        
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
                    <a href="javascript:abrir_bienvenido()">Bienvenido <%=session.getAttribute("usuario") %> <i class="fas fa-chevron-down"></i>
                    </a>
                    <a href="CerrarSesion">
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
                                <a href="javascript:abrir()" class="etiquetas" >
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
    <div class='contenido-text'>
         <br>
        <h1>Transferir</h1>
        <br>
        <div class='mis_targetas_bambif'>
            <select name='mis_targetas_bambif' class="select_targetas">
                <option selected>Al exterior</option>
                
            </select>
        </div>
        
        <div class='formulario_tarjetas'>
            <div class>
                <div class="obligatorio">
                    <div class='partes'>
                        <h3> Cuenta de Origen  </h3>
                        
                        <select name='producto' >
                            <option value='' selected="">Seleccione un producto</option>
                            <option value=''>??</option>
                            <option value=''>??</option>
                            <option value=''>??</option>
                        </select>
                    </div>
                    <div class='partes'>
                        <h3> 2 Cuenta del beneficiario a acreditar  </h3>
                        <div class='partes btn_top'>
                            <input type="button" name="cuenta_acreditar" value='Registrada' placeholder="Registrada">
                            <input type='button' name="cuenta_acreditar" value='Nueva' placeholder='Nueva'>
                        </div>
                        <hr>
                        <select name='producto' >
                            <option value='' selected="">Ingrese datos del producto</option>
                            <option value=''>??</option>
                            <option value=''>??</option>
                            <option value=''>??</option>
                        </select>
                    </div>
                    <div class='partes'>
                        <h3> 3 Monto a transferir </h3>
                        <div class="partes">
                            <select name='moneda' >
                                <option value='dolat' selected>Dólar USA</option>
                                <option value='euro'>Euro</option>
                                <option value='peso'>Peso</option>
                            </select>
                            <input type="number" placeholder="Ingrese un monto"> 
                        </div>
                        <hr>
                    </div>
                </div>
                
                
            </div>
            <hr>
                <h3> 4 Datos adicionales</h3>
            <div class='datos_adicionales2'>
                
                <div class="one">
                    <h3> Datos del contacto</h3>
                    <table>
                        <tbody> 
                            <tr>
                                <td>Nombre</td>
                                <td><input name="nombre"></td>                               
                            </tr>     
                            <tr>
                                <td>Telefono</td>
                                <td><input name="nombre"></td>
                            </tr>      
                            <tr>
                                <td>Anexo</td>
                                <td><input name="nombre"></td>
                            </tr>  
                            <tr>
                                <td>Mail</td>
                                <td><input name="nombre"></td>
                            </tr>   
                            <tr>
                                <td>Tipo de gastos</td>
                                <td>    
                                    <select>
                                        <option selected>Seleccione</option>
                                    </select>
                                </td>
                            </tr>      
                        </tbody>
                    </table>
                </div>
                <div class="two">
                    <h3> Remesas(opcional)</h3>
                    <table>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <select>
                                    <option selected>Seleccione</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Detalles</td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <select>
                                    <option selected>Seleccione</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Detalles</td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <select>
                                    <option selected>Seleccione</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Detalles</td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <select>
                                    <option selected>Seleccione</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Detalles</td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <select>
                                    <option selected>Seleccione</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Detalles</td>
                        </tr>
                    </table>
                </div>
                <div class="tree">
                    <h3>Instrucciones adicionales solo para Bambif</h3>
                    <table>
                        <tr>
                            <td><p>Instrucciones: </p></td>
                            <td><input type="text" style="width: 200px; height: 200px;"></td>
                        </tr>
                    </table>
                    
                </div>

            </div>
            <hr>
            <div class="programar">

                <h5> <label class="switch"> <input type="checkbox"> <span class="slider round"></span> </label> Programar</h5>
                <br>
                <h5>Su transaccion sera ejecutada el &nbsp;<input type="date">
                </h5>
                
                <h5>Frecuencia: <select name="frecuencia">
                        <option value="una_vez" selected="">Una sola vez</option>
                        <option value="dos_veces">Dos veces</option>
                        <option value='tres_veces'>Tres veces</option>

                    </select>  </h5>
                <h5>Para transferencias y Pagos Programados con cambio de moneda, se muestra un tipo de cambio referencial. EL tipo de cambio final, sera el que esta vigente el día que se realice la transferencia o pago.</h5>
            </div>
       <br>
        <br>
        </div>
        
        <div class="botones_final">
            <button>Limpiar</button>
            <button>Cancelar</button>
            <button>Siguiente</button>
        </div>
    </div>               
    <input type="checkbox" id="btn-menu">
	<div class="container-menu">
		<div class="cont-menu">
			<nav>
				<a href="inicio.jsp">Inicio</a>
				<a href="operaciones.jsp">Operaciones Frecuentes</a>
				<a href="javascript:abrir_menutransferencias()">Transferir</a>
				<a href="javascript:abrir()">Pagar</a>
				<a href="ofertas.jsp">Mis ofertas</a>
				<a href="javascript:abrir_tipodecambio()">Tipos de Cambio</a>
			</nav>
			<label for="btn-menu">✖️</label>
		</div>
	</div>










    
    <dialog id='menu_bienvenido' class="containermodal">
        <div class="headermodal">
            <h3><%=session.getAttribute("usuario") %></h3>
        </div>
        <div class='MenuModifi'>
            
        </div>
        <div class="bodymodal">
            <a href="configuraciones.jsp">Cambiar contraseña</a>
            <a href="configuraciones.jsp">Cambiar datos personales</a>
            <a href="configuraciones.jsp">Configuración personal</a>
        </div>

    </dialog>
    
    <dialog class="menu_transferencias" id="menu_transferencias">
            <ul>
                    <li>
                        <img src="icons/bank.png" width="30px" height="30px"><a href="EntreCuentasPropias.jsp">
                         Entre Cuentas Propias</a>
                    </li>
                    <li><a href="AOtrasCuentasBambif.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                         A Otras Cuentas Bambif</a>
                    </li>
                    <li><a href="AOtrosBancos.jsp"> <img src="icons/bank.png" width="30px" height="30px">
                         A otros bancos</a>
                    </li>
                    <li><a href="AlExterior.jsp"> <img src="icons/mundo.png" width="30px" height="30px">
                         Al exterior</a>
                    </li>
            </ul>
    </dialog>

    <dialog class="menu_pagar" id="menu_pagar">
        <ul>
                <li>
                    <img src="icons/creditcard.png" width="30px" height="30px">
                    <a href="MisTarjetasBambif.jsp">
                     Mis Tarjetas Bambif</a>
                </li>
                <li><a href="OtrasTarjetasBambif.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                     Otras Tarjetas Bambif</a>
                </li>
                <li><a href="TarjetasDeOtrosBancos.jsp"> <img src="icons/creditcard.png" width="30px" height="30px">
                     Tarjetas de otros bancos</a>
                </li>
                <li><a href="TarjetasDiners.jsp"> <img src="icons/diners.png" width="30px" height="30px">
                     Tarjetas Diners</a>
                </li>
                <li><a href="Prestamos.jsp"> <img src="icons/prestamos.png" width="30px" height="30px">
                     Prestamos</a>
                </li>
                <li><a href="Servicios.jsp"> <img src="icons/servicios.png" width="30px" height="30px">
                     Servicios</a>
                </li>
        </ul>
    </dialog>
    
    <dialog id="menu_tipodecambio" class="contenido-cambio">
        <h4 style="color: #fff; padding: 7px 10px">Tipo de cambio</h4>
        <div class="opciones">
           <div class="compra" style="border: 1px solid #999999; box-shadow: rgb(150,150,150) 5px 5px; color: #20a6ff;">Compra</div>
           <div class="Venta" style="border: 1px solid #999999; box-shadow: rgb(150,150,150) 5px 5px; color: #20a6ff;">Venta</div>
        </div>
        <div class="Monedas_Cambio">
            <h5 style="border-bottom: 1px solid #1f1f1f"><img src="icons/euro.png" width="20px" height="20px"  class="img1"style="background: black">Euros</h5>
            <div class="opciones">
                <h4 class="compra">3.300000</h4>
                <h4 class="Venta">4.520000</h4>
            </div>
        </div>
        <div class="Monedas_Cambio" style="border-radius: 0 0 10px 10px;">
            <h5 style="border-bottom: 1px solid #1f1f1f"> - Dolar-USA</h5>
            <div class="opciones">
                <h4 class="compra">3.610000</h4>
                <h4 class="Venta">4.130000</h4>
            </div>
        </div>
 
    </dialog>
    
    <script>
        function abrir(){
            //document.getElementById('submenu').style.display="block";
            document.getElementById('menu_pagar').showModal();
        }
        function abrir_bienvenido(){
            document.getElementById('menu_bienvenido').showModal();
        }  
        function abrir_menutransferencias(){
            document.getElementById('menu_transferencias').showModal();
        }
        function abrir_tipodecambio(){
            document.getElementById("menu_tipodecambio").showModal();
        }
        document.addEventListener("click",() =>{
            document.getElementById('menu_pagar').close();  
            document.getElementById('menu_bienvenido').close();  
            document.getElementById('menu_transferencias').close();  
            document.getElementById('menu_tipodecambio').close();
        })
        
        
    </script>
    </body>
</html>
