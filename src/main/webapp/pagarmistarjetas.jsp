<%@page import="modelo.TipoOperacionEnum"%>
<%@page import="modelo.Movimientos"%>
<%@page import="modelo.dto.ClienteConectadoDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:useBean id='mov' class='modelo.Movimientos'>--%>
<%
    ClienteConectadoDto cc= (ClienteConectadoDto) session.getAttribute("cliente");
    if(session.getAttribute("cliente_id") == null){
        session.invalidate();
        response.sendRedirect("index.html");
        return;
    }
    Movimientos mov=new Movimientos();
    if(request.getAttribute("movimiento")!=null){
        mov=(Movimientos) request.getAttribute("movimiento");
    }
    
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BanBif Banking</title>
    <link rel="stylesheet" href="css/pagar_styles.css"/>
    <link rel="stylesheet" href="css/modal_styles.css"/>
    <script>
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
    <div class='contenido-text'>
        <form method="POST" action="PagarMisTarjetas"> 
        <br>
        <h1>Pagar</h1>
        <br>
        <div class='mis_targetas_bambif'>
            <select name='mis_targetas_bambif' class="select_targetas">
                <option selected>Mis Targetas Bambif</option>
            </select>
        </div>
        <input id="tipooperacion" type="hidden" name="tipooperacion" value="PMT">
        <div class='formulario_tarjetas'>
            <div class="obligatorio">
                <div class='partes'>
                    <h3> 1° Tarjeta a pagar  </h3>
                    <hr>
                    <select id="tarjeta" name='tarjeta' required>
                        <option value='' <%=mov.getId()<0 ? "selected" : "" %>>Seleccione un producto</option>
                        <c:forEach items="${listaTarjetas}" var="lc" varStatus="status">
                            <option value="${lc.id}" 
                                <c:if test="${mov.getCuentadestinoId()==lc.id}">
                                    <c:out value="selected"/>
                                </c:if>>
                                ${lc.nombre} - Saldo: ${lc.value}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class='partes'>
                    <h3> 2° Monto a pagar  </h3>
                    <hr>
                </div>
                <div class='partes'>
                    <h3> 3° Cuenta origen (a debitar)  </h3>
                    <hr>
                    <select name='cuenta' id="cuenta" required>
                        <option value='' <%=mov.getId()==-1 ? "selected" : "" %>>Seleccione un producto</option>
                        <c:forEach items="${listaCuentas}" var="lc" varStatus="status">
                            <option value="${lc.id}"
                                <c:if test="${mov.getCuentaorigenId()==lc.id}">
                                    <c:out value="selected"/>
                                </c:if>
                            >
                            ${lc.nombre} - Saldo: ${lc.value}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="monto">
                <input name="monto" type='number' 
                       id="monto" value="${mov.getMontoString()}" 
                       class="login_user"
                       required 
                       placeholder="Ingrese monto"/>
            </div>
            <hr class="hr1">
            <hr>
            <div class='datos_adicionales'>
                <h3> 4° Datos adicionales</h3>
                <div class='datos_adicionales'>
                    <div class="descripcion">
                        <h4>Descripcion</h4>
                        <input name="descripcion" placeholder='Descripcion' id="descripcion" 
                               autocomplete="off" 
                               value="${mov.getNombreoperacion()}"
                        />
                    </div>
                    <div class="enviar_a_correo">
                        <h4>Enviar confirmacion a:</h4>
                        <h4 class="correo"><%=cc.getEmailPrivate()%></h4>
                    </div>
                </div>
            </div>
            <hr>
            <div class="programar">
                <h5> <label class="switch"> 
                        <input name="programado" type="checkbox" id="programado"> 
                        <span class="slider round"></span> 
                    </label> Programar</h5>
                <br>
                <h5>
                    Su transaccion sera ejecutada el &nbsp;
                    <input name="fechavence" type="date" id="fechavence">
                </h5>
                <h5>Frecuencia: 
                    <select name="frecuencia" id="frecuencia">
                        <option value="una_vez" selected="">Una sola vez</option>
                        <option value="dos_veces">Dos veces</option>
                        <option value='tres_veces'>Tres veces</option>
                    </select>  
                </h5>
                <h5>Para transferencias y Pagos Programados con cambio de moneda, se muestra un 
                    tipo de cambio referencial. EL tipo de cambio final, sera el que esta vigente el
                    día que se realice la transferencia o pago.</h5>
            </div>
        <br>
        <br>
        </div>
        
        <div class="botones_final">
            <button type="button">Limpiar</button>
            <button type="button">Cancelar</button>
            <button class="open-modalprocess" type="button" id="btnProceed"  data-open="modalprocess">Siguiente</button>
        </div>
        
        <div class="modalprocess" id="modalprocess" data-animation="slideInOutLeft">
          <div class="modalprocess-dialog">
            <header class="modalprocess-header">
              CONFIRME SU OPERACIÓN
              <button type="button" class="close-modalprocess" aria-label="close modal" data-close>
                ✕  
              </button>
            </header>
            <section class="modalprocess-content">
              <p><strong>Confirme su operación, digitando su token o Clave</strong></p>
              <br/>
              <div class="login_content_main_data">
                <input id="tokenmodal" type="password" class="login_user" name="token">
              </div>

              <div style="clear:both;"></div>

                <div class="login_button_base">
                    <div class="login_button">
                        <button id="btnProcesarPagoMisTarjetas" class="login_button_main" type="submit">
                            <span class="login_button_main_text">PROCESAR</span>
                        </button>
                    </div>
               </div>
              <br>
            </section>
          </div>
        </div>                
    </form>
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
            <a href="configuraciones.jsp">Cambiar contraseña</a>
            <a href="configuraciones.jsp">Cambiar datos personales</a>
            <a href="configuraciones.jsp">Configuración personal</a>
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
    if(document.getElementById('menu_bienvenido')!==null){
        document.getElementById('menu_pagar')
                .addEventListener("click", ()=> { document.getElementById('menu_pagar').close();});
    }
    if(document.getElementById('menu_bienvenido')!==null){
        document.getElementById('menu_bienvenido')
                .addEventListener("click", ()=> { document.getElementById('menu_bienvenido').close();});
    }
    if(document.getElementById('menu_bienvenido')!==null){
        document.getElementById('menu_transferencias')
                .addEventListener("click", ()=> { document.getElementById('menu_transferencias').close();});
    }
    //});
    </script>
    <script title="modalprocesar">
        const openEls = document.querySelectorAll("[data-open]");
        const closeEls = document.querySelectorAll("[data-close]");
        const isVisible = "is-visible";

        for(const el of openEls) {
          el.addEventListener("click", function() {
            const modalId = this.dataset.open;
            document.getElementById(modalId).classList.add(isVisible);
          });
        }
        
        for (const el of closeEls) {
          el.addEventListener("click", function() {
            this.parentElement.parentElement.parentElement.classList.remove(isVisible);
          });
        }

        document.addEventListener("click", e => {
            if (e.target === document.querySelector(".modalprocess.is-visible")) {
                document.querySelector(".modalprocess.is-visible").classList.remove(isVisible);
            }
        });

        document.addEventListener("keyup", e => {
            if (e.key === "Escape" && document.querySelector(".modalprocess.is-visible")) {
                document.querySelector(".modalprocess.is-visible").classList.remove(isVisible);
            }
        });
    </script>
</body>
</html>