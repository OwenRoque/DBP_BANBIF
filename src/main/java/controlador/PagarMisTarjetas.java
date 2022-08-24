package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CodigosEnum;
import modelo.EstadoMovimientoEnum;
import modelo.Movimientos;
import modelo.TipoOperacionEnum;
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
        if(clienteactual==null) /* si se acabo la session */{
            rd = request.getRequestDispatcher("index.html"); 
            rd.forward(request, response);
            return; //salir de funcion
        }
        
        ArrayList<ComboItemDto> listaTarjetas = cuentasbd.getCuentasUsuario(clienteactual.getId(), CodigosEnum.TipoCuentaTarjetas);
        ArrayList<ComboItemDto> listaCuentas = cuentasbd.getCuentasUsuario(clienteactual.getId(), CodigosEnum.TipoCuentaAhorros);
        conn.desconectar();
        Movimientos mov = new Movimientos();
        mov.setMonto(BigDecimal.valueOf(1000));
        mov.setId(0);
        mov.setCuentadestinoId(9);
        mov.setCuentaorigenId(2);
        mov.setNombreoperacion("PAGO TARJETA");
        request.setAttribute("listaTarjetas", listaTarjetas);
        request.setAttribute("listaCuentas", listaCuentas);
        request.setAttribute("mov", mov); /* Tendra Datos del movimiento para Redibujar*/
        /* Redirecciono a mi Vista JSP con la informacion inicial que se necesita*/
        rd = request.getRequestDispatcher("/pagarmistarjetas.jsp"); 
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String res="ERROR";
        RequestDispatcher rd;
        BDConexion conn = new BDConexion();
        MovimientosBD movbd = new MovimientosBD(conn);
        Movimientos mov= new Movimientos();/*registro a enviar a movbd*/
        HttpSession sesion = request.getSession();
        ClienteConectadoDto clienteConectadoDto = (ClienteConectadoDto)sesion.getAttribute("cliente");
        UsuarioBD userdb = new UsuarioBD(conn);
        String claveuserdb = userdb.getClavebyId(clienteConectadoDto.getId());
        String token = request.getParameter("token");
        if(!token.equals(claveuserdb)){
            res = "ERROR, Token Inválido";
        }
        else{
            String tipooperacion = request.getParameter("tipooperacion");
            int tarjeta = Integer.valueOf(request.getParameter("tarjeta"));
            BigDecimal monto = new BigDecimal(request.getParameter("monto"));
            int cuenta_id = Integer.valueOf(request.getParameter("cuenta"));
            String descripcion = request.getParameter("descripcion");
            if(descripcion==null) 
                descripcion="";
            mov.setTipooperacionprincipal(TipoOperacionEnum.PagarMisTarjeta);
            mov.setCuentaorigenId(cuenta_id);
            mov.setCuentadestinoId(tarjeta); /*En pago de tarjetas tarjeta es el Id Destino*/
            mov.setMonto(monto);
            mov.setNombreoperacion(descripcion);
            
            mov.setEstadomovimiento(EstadoMovimientoEnum.REGULAR);
            mov.setCciexterno("");
            
            int programado = 0;
            if(request.getParameter("programado") != null){
                String fechavence = request.getParameter("fechavence");
                Date fechaprogramado;
                try {
                    fechaprogramado = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(fechavence);
                    mov.setFechaprogramado(fechaprogramado);

                } catch (ParseException ex) {
                    mov.setFechaprogramado(null);
                    Logger.getLogger(PagarMisTarjetas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
             
            //no usamos por ahora 
            //String frecuencia = request.getParameter("frecuencia");
            
        /*int id,Date fechaoperacion, TipoOperacionEnum tipooperacionprincipal
        int cuentaorigenId,int cuentadestinoId,BigDecimal monto,String nombreoperacion
    EstadoMovimientoEnum estadomovimiento,Character tipomovimiento,String cciexterno
    Date fechaprogramado,int estado; */
    
        res=movbd.saveMovimiento(mov);
    }
    if(!res.contains("ERROR"))
    {
        rd = request.getRequestDispatcher("/inicio.jsp");
    }
    else{
        rd = request.getRequestDispatcher("/pagarmistarjetas.jsp");
    }
    request.setAttribute("mensaje", res);
    rd.forward(request, response);
    }
}