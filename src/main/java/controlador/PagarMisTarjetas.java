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
import modelo.dto.ClienteConectadoDto;
import modelo.dto.ComboItemDto;
/**
 *
 * @author Haziel
 */
//@WebServlet(name = "PagarMisTarjetas", urlPatterns = {"/MisTarjetasBambif"})
public class PagarMisTarjetas extends HttpServlet {

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
        rd = request.getRequestDispatcher("/pagarmistarjetas.jsp"); 
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BDConexion conn = new BDConexion();
        MovimientosBD movbd = new MovimientosBD(conn);
        HttpSession sesion = request.getSession();
        
        String tipooperacion = request.getParameter("tipooperacion");
        int tarjeta = Integer.valueOf(request.getParameter("tarjeta"));
        BigDecimal monto = new BigDecimal(request.getParameter("monto"));
        int cuenta_id = Integer.valueOf(request.getParameter("cuenta"));
        String descripcion = request.getParameter("descripcion");
        int programado = 0;
        if(request.getParameter("programado") != null){
            programado = Integer.valueOf( request.getParameter("programado") );
        }
        
        String fechavence = request.getParameter("fechavence");
        String frecuencia = request.getParameter("frecuencia");
        String token = request.getParameter("token");
        /*
        BDConexion conn = new BDConexion();
        UsuarioBD usuarioBD = new UsuarioBD();
        
        usuarioBD.setConexion(conn);
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
            out.println("ACCESO OK DESDE:" + acceso.getIp());
        } else {
            sesion.invalidate();
            out.println("Usuario y/o clave incorrectos");
        }*/
    }
    
}