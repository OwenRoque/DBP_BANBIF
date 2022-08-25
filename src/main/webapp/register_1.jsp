<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css"/>
        <script src="js/register.js"></script>
    </head>
    <body>
        <header>
            <div style="height: 200px;">
                <div class="header_blue">
                    <div class="ph_top" style="margin-right:20px;">
                        <div class="language">
                            <div class="language_content">
                                <a class="language_content_access">
                                    <span class ="language_separator">|</span>
                                    <span class="language_content_text">Español</span>
                                    <div style="clear: both;"></div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="ph_top">
                        <div class="contact">
                            <div class="contact_content">
                                <a class="contact_content_access">
                                    <span class="contact_content_text">Contáctenos</span>
                                    <div style="clear: both;"></div>
                                </a>                        
                            </div>
                        </div>
                    </div>
                    <div style="clear:both;"></div>
                    <a class="logo"></a>
                </div>
            </div>
        </header>
        <main>
            <div class="contenedor">
                <div class="login">
                    <div class="login_content">
                        <div class="login_content_tab_conteiner">
                            <div class="login_main">
                                <div class="login_parts">
                                    <div class="login_header">
                                        <div class="login_header_tittle">Bienvenido a la Banca por Internet - Personas</div>
                                    </div>
                                    <div class="login_separator">
                                        <span class="login_separator_text">Paso 1 de 4: </span>
                                        <span class="login_separator_text_2">Complete la informacion del usuario</span>
                                    </div>
                                    <div class="login_content_form_base">
                                        <div class="login_content_form">
                                            <div class="login_begin">
                                                <span class="login_begin_text">
                                                    Obligatorio
                                                </span>
                                            </div>
                                            <form style="margin-top: -10px;" method="get">
                                                <!--
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Tipo de tarjeta</span>
                                                    <div class="login_boxdrop_space">
                                                        <select class="login_boxdrop_select">
                                                            <option>Debito</option>
                                                            <option>Credito</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Numero de tarjeta</span>
                                                    <div class="login_content_main_data">
                                                        <input class= "login_user" id="clave" name="clave" placeholder="**** **** **** ****">                                           
                                                    </div>  
                                                </div> -->
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Tipo de documento</span>
                                                    <div class="login_boxdrop_space">
                                                        <select class="login_boxdrop_select">
                                                            <option>DNI</option>
                                                            <option>RUC</option>
                                                            <option>Carnet de Extranjeria</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Numero de documento</span>
                                                    <div class="login_content_main_data">
                                                        <input class= "login_user" id="DNI" name="DNI" placeholder="Numero de documento">                                           
                                                    </div>  
                                                </div>
                                                <div style="clear:both;"></div>
                                                <h4 class="h4_tittle">Crea ahora tu clave para la Banca por internet o APP</h4>
                                                <div class="login_boxdrop">
                                                    <div class="login_text_container"><span class="login_boxdrop_text, text_small">Nueva clave</span></div>
                                                    <div style="display: inline-block;position: relative;">
                                                        <div class="login_content_main_data">
                                                            <input class= "login_user_extended" style="margin-left: 54px;" id="clave" name="clave" placeholder="Nueva clave">    
                                                            <ul class="login_table">
                                                                <li>
                                                                    <span>Clave debe tener al menos un caracter en mayuscula</span>                                                                
                                                                </li>
                                                                <li>
                                                                    <span>Clave debe tener al menos un caracter en minuscula</span>                                                                
                                                                </li>
                                                                <li>
                                                                    <span>El largo de la clave debe tener entre 8 y 10 caracteres</span>                                                                
                                                                </li>
                                                                <li>
                                                                    <span>Clave debe tener al menos un caracter especial (-;_;@;&,etc.)</span>
                                                                </li>
                                                                <li>
                                                                    <span>Clave debe tener al menos un caracter numerico</span>
                                                                </li>
                                                            </ul>                                   
                                                        </div>
                                                          
                                                    </div>
                                                </div>
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text, text_small">Repetir nueva clave</span>
                                                    <div class="login_content_main_data">
                                                        <input class= "login_user_extended" style="margin-left: 15px;" id="claveAgain" name="claveAgain" placeholder="Repetir nueva clave">                                           
                                                    </div>  
                                                </div>
                                                <div style="clear:both;"></div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="login_footer">
                                        <div style="float:right;">
                                            <div class="login_button">
                                                <button id="btnClean" class="login_button_cancel" type="button">
                                                    <span class="login_button_cancel_text">Limpiar</span>
                                                </button>
                                            </div>  
                                            <div class="login_button">
                                                <a id="btnCancel" class="login_button_cancel" type="button" href="index.html">
                                                    <span class="login_button_cancel_text">Cancelar</span>
                                                </a>
                                            </div>  
                                            <div class="login_button">
                                                <button id="btnRegistrar" class="login_button_next" type="button">
                                                    <span class="login_button_next_text">Registrar</span>
                                                </button>
                                            </div>    
                                        </div>
                                    </div>  
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div>
            <div stule="clear:both;"></div>            
        </main>
    </body>
</html>
