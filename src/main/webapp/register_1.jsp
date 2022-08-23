<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css"/>
        <script src="js/portal.js"></script>
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
                                        <span class="login_separator_text_2">Complete la información del usuario</span>
                                    </div>
                                    <div class="login_content_form_base">
                                        <div class="login_content_form">
                                            <div class="login_begin">
                                                <span class="login_begin_text">
                                                    Obligatorio
                                                </span>
                                            </div>
                                            <form style="margin-top: -10px;" method="get">
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Tipo de tarjeta</span>
                                                    <div class="login_boxdrop_space">
                                                        <select class="login_boxdrop_select">
                                                            <option>Débito</option>
                                                            <option>Crédito</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Numero de tarjeta</span>
                                                    <div class="login_content_main_data">
                                                        <input class= "login_user" id="clave" name="clave" placeholder="**** **** **** ****">                                           
                                                    </div>  
                                                </div>
                                                <div class="login_boxdrop">
                                                    <span class="login_boxdrop_text">Tipo de tarjeta</span>
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
                                                        <input class= "login_user" id="clave" name="clave" placeholder="Numero de documento">                                           
                                                    </div>  
                                                </div>
                                                <div style="clear:both;"></div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="login_footer">
                                        <div style="float:right;">
                                            <div class="login_button">
                                                <button id="btn" class="login_button_cancel" type="button">
                                                    <span class="login_button_cancel_text">Limpiar</span>
                                                </button>
                                            </div>  
                                            <div class="login_button">
                                                <button id="btn" class="login_button_cancel" type="button">
                                                    <span class="login_button_cancel_text">Cancelar</span>
                                                </button>
                                            </div>  
                                            <div class="login_button">
                                                <button id="btn" class="login_button_next" type="button">
                                                    <span class="login_button_next_text">Siguiente</span>
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
