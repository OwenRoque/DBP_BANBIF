package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dbo.BDConexion;
import modelo.dbo.UsuarioBD;
import modelo.dto.ClienteConectadoDto;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
                
        BDConexion conn = new BDConexion();
        UsuarioBD usuarioBD = new UsuarioBD(conn);
        
        String cIp= getClientIpAddr(request);
        //boolean acceso = usuarioBD.validarUsuario(usuario, clave);
        ClienteConectadoDto acceso = usuarioBD.validarUsuario(usuario, clave, cIp);
        
        System.out.println(acceso);
        System.out.println("user: "+usuario);
        System.out.println("pass: "+clave);
        conn.desconectar();
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        
        if(acceso!=null){
            sesion.setAttribute("cliente_id",acceso.getId());
            sesion.setAttribute("cliente",acceso);
            out.println("OK ACCESO DESDE:" + acceso.getIp());
        } else {
            out.println("ERROR: Usuario y/o clave incorrectos");
            sesion.invalidate();
        }
    }

    public static String getClientIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_X_FORWARDED");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_FORWARDED");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("HTTP_VIA");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("REMOTE_ADDR");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
}