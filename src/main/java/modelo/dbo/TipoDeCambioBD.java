
package modelo.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import modelo.dto.TipoDeCambioDto;

public class TipoDeCambioBD {
    /* Crear Constructor */
    public TipoDeCambioBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private final BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    public TipoDeCambioDto getTipoDeCambio(Date fecha){
        TipoDeCambioDto tcambio = new TipoDeCambioDto();
        try{
            String sql = "SELECT tc.comprausd, tc.ventausd, tc.compraeuros, tc.ventaeuros " +
                         "FROM tipocambio as tc " +
                         "WHERE tc.fecha=?";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDate(1, fecha);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { 
                tcambio.setComprausd(rs.getFloat("comprausd"));
                tcambio.setVentausd(rs.getFloat("ventausd"));
                tcambio.setCompraeuros(rs.getFloat("compraeuros"));
                tcambio.setVentaeuros(rs.getFloat("ventaeuros"));
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Tipos de Cambios: " + e.getMessage());
        }
        return tcambio;
    }
}
