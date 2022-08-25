package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CodigosEnum;
import modelo.dbo.BDConexion;
import modelo.dbo.CuentasBD;
import modelo.dbo.MovimientosBD;
import modelo.dbo.UsuarioBD;
import modelo.dto.ClienteConectadoDto;
import modelo.dto.ComboItemDto;
/**
 *
 * @author Haziel
 */
//@WebServlet(name = "PagarMisTarjetas", urlPatterns = {"/MisTarjetasBambif"})
public class TransferirAOtrasCuentasBambif extends HttpServlet {
    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BDConexion conn = new BDConexion();
        UsuarioBD usuarioBD = new UsuarioBD(conn);
        MovimientosBD movbd = new MovimientosBD(conn);
        HttpSession sesion = request.getSession();
        
        
        
        String cuentaid_origen = (request.getParameter("origen"));
        String cuentaid_destino = (request.getParameter("destino"));
        BigDecimal monto = new BigDecimal(request.getParameter("monto"));
        String descripcion = request.getParameter("descripcion"); 
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estadoMov");

        usuarioBD.TransferirEntreCuentasPropias(cuentaid_origen , cuentaid_destino , monto, descripcion );        
                
        doGet(request,response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        BDConexion conn = new BDConexion();
        CuentasBD cuentasbd = new CuentasBD(conn);
        HttpSession sesion = request.getSession(); /* recuperar session actual */
        
        /* Convertir objeto de la sesion y lo castea al tipo ClienteConectadoDto*/
        ClienteConectadoDto clienteactual=(ClienteConectadoDto) sesion.getAttribute("cliente");
        
        ArrayList<ComboItemDto> listaTarjetas = cuentasbd.getCuentasUsuario(clienteactual.getId(), CodigosEnum.TipoCuentaTarjetas);
        ArrayList<ComboItemDto> listaCuentas = cuentasbd.getCuentasUsuario(clienteactual.getId(), CodigosEnum.TipoCuentaAhorros);
        conn.desconectar();
        request.setAttribute("listaTarjetas", listaTarjetas);
        request.setAttribute("listaCuentas", listaCuentas);
        /* Redirecciono a mi Vista JSP con la informacion inicial que se necesita*/
        rd = request.getRequestDispatcher("/transferiraotrascuentas.jsp"); 
        rd.forward(request, response);
    }

}