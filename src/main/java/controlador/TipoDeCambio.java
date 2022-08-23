
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dbo.BDConexion;
import modelo.dbo.TipoDeCambioBD;
import modelo.dto.TipoDeCambioDto;

public class TipoDeCambio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BDConexion conn = new BDConexion();
        TipoDeCambioBD tc = new TipoDeCambioBD(conn);
        Date def = new Date(System.currentTimeMillis());
        TipoDeCambioDto ret = tc.getTipoDeCambio(def);
        conn.desconectar();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(ret);
        out.print(json);
        out.flush();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
