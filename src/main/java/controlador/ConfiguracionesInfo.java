/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dbo.BDConexion;
import modelo.dto.ClienteDto;
import modelo.dbo.CofiguracionesMostrar;
import modelo.dto.ClienteConectadoDto;

/**
 *
 * @author AVELINO
 */
public class ConfiguracionesInfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String nivelEstudio = request.getParameter("nivelEstudio");
            String nacionalidad = request.getParameter("nacionalidad");
            String departamentoResidencia = request.getParameter("departamentoResidencia");
            String viaResidencia = request.getParameter("viaResidencia");
            String direccionResidencia = request.getParameter("direccionResidencia");
            String numeroResidencia = request.getParameter("numeroResidencia");
            String interiorResidencia = request.getParameter("interiorResidencia");
            String urbanizacionResidenncia = request.getParameter("urbanizacionResidenncia");
                
                
            String departamentoLaboral = request.getParameter("departamentoLaboral");
            String viaLaboral = request.getParameter("viaLaboral");
            String direccionLaboral = request.getParameter("direccionLaboral");
            String numeroLaboral = request.getParameter("numeroLaboral");
            String interiorLaboral = request.getParameter("interiorLaboral");
            String urbanizacionLaboral = request.getParameter("urbanizacionLaboral");
                
            String profesionLaboral = request.getParameter("profesionLaboral");
            String nombreEmpresa = request.getParameter("nombreEmpresa");
            String telefonoLaboral = request.getParameter("telefonoLaboral");
            String cargoLaboral = request.getParameter("cargoLaboral");

            BDConexion conn = new BDConexion();
        
            System.out.println("INICIO EN CONFICOsdfasdfa");
        
            CofiguracionesMostrar edit = new CofiguracionesMostrar(conn);
            
            HttpSession sesion = request.getSession(); /* recuperar session actual */
        
        
        
        /* Convertir objeto de la sesion y lo castea al tipo ClienteConectadoDto*/
            ClienteConectadoDto clienteactual = (ClienteConectadoDto) sesion.getAttribute("cliente");
            
            //String idActual = clienteactual.getId()+"";
            edit.setInfoClientes( clienteactual.getId() , nivelEstudio, nacionalidad, departamentoResidencia, viaResidencia, direccionResidencia, numeroResidencia, interiorResidencia, urbanizacionResidenncia, departamentoLaboral, viaLaboral, direccionLaboral, numeroLaboral, interiorLaboral, urbanizacionLaboral, profesionLaboral, nombreEmpresa, telefonoLaboral, cargoLaboral);

            RequestDispatcher rd = request.getRequestDispatcher("/configuraciones.jsp");

            doGet(request,response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        BDConexion conn = new BDConexion();
        
        
       System.out.println("INICIO EN CONFICO");
        
        CofiguracionesMostrar info = new CofiguracionesMostrar(conn);
        HttpSession sesion = request.getSession(); /* recuperar session actual */
        
        
        
        /* Convertir objeto de la sesion y lo castea al tipo ClienteConectadoDto*/
        ClienteConectadoDto clienteactual = (ClienteConectadoDto) sesion.getAttribute("cliente");
        
        
        
        ClienteDto userrr = info.getInfoClientes(clienteactual.getId());
        /*String userrr = "holamundo";*/
                
        
        //conn.desconectar();
        sesion.setAttribute("informacion", userrr);
        
        /* Redirecciono a mi Vista JSP con la informacion inicial que se necesita*/
        rd = request.getRequestDispatcher("/configuraciones.jsp"); 
        rd.forward(request, response);
        
    }

    
    

    

}
