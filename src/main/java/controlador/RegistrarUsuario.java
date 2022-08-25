package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dbo.BDConexion;
import modelo.dbo.UsuarioBD;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RegistrarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String usuario = "";
            String clave = "";
            List <FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for(FileItem item : items){
                if(item.isFormField()){
                    String fieldname = item.getFieldName();
                    String fieldvalue = item.getString();
                    if(fieldname.equals("usuario")){
                        usuario = fieldvalue;
                    } else if (fieldname.equals("clave")){
                        clave = fieldvalue;
                    }
                }
            }
            
            BDConexion conn = new BDConexion();
            UsuarioBD usuarioBD = new UsuarioBD(conn);
            usuarioBD.RegistrarUsuario(usuario, clave);
            conn.desconectar();

            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('USUARIO REGISTRADO CORRECTAMENTE');");
            out.println("location = 'index.html';");
            out.println("</script>");
            
        } catch (Exception ex){
            System.out.println("Exception: " + ex.toString());
            out.println("<script type=\"text/javascript\">");
            out.println("alert('ERROR AL REGISTRAR USUARIO');");
            out.println("location='register.jsp';");
            out.println("</script>");
        }
    }
    
}
