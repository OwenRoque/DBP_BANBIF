package modelo.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Movimientos;
//import modelo.TipoOperacionEnum;
import modelo.dto.MovimientoDto;

public class MovimientosBD {

    public MovimientosBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    public String saveMovimiento(Movimientos reg){
        String resultado = null;
        try{
            String sql = "CALL PagarTarjetas(?,?,?,?,?,?,?)";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            /*Orden de Parametros de Procedure
            IN `tipooperacionIN` varchar(35),
            IN `cuentaorigenidIN` int,
            IN `cuentadestinoidIN` int,
            IN `montoIN` decimal(15,2),
            IN `nombreoperacionIN` varchar(256),
            IN `cciexternoIN` varchar(35),
            IN `fechaprogramadaIN` datetime */
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, reg.getTipooperacionprincipal().getValue());
            preparedStatement.setInt(2, reg.getCuentaorigenId());
            preparedStatement.setInt(3, reg.getCuentadestinoId());
            preparedStatement.setBigDecimal(4, reg.getMonto());
            preparedStatement.setString(5, reg.getNombreoperacion());
            preparedStatement.setString(6, reg.getCciexterno());
            if(reg.getFechaprogramado()!=null)
                preparedStatement.setDate(7, new java.sql.Date(reg.getFechaprogramado().getTime()));
            preparedStatement.setDate(7, null);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                resultado = rs.getString("res");
            }
            rs.close();
        } catch (SQLException e){
            System.out.println("Error Cargando Cuentas: " + e.getMessage());
        }
        return resultado;
    }
    
    public ArrayList<MovimientoDto> getMovimientoByCuenta(int cuenta_id){
        ArrayList<MovimientoDto> listamovDto = new ArrayList<>();
        try{
        String sql = "SELECT mov.Id,DATE_FORMAT(mov.fechaoperacion, '%d.%m.%Y %H:%i:%s') AS fecha\n" +
        ",case when mov.tipomovimiento='A' THEN mov.monto ELSE 0.00 END as abono\n" +
        ",case when mov.tipomovimiento='A' THEN 0.00 ELSE mov.monto END as cargo\n" +
        ",mov.nombreoperacion\n" +
        ",mov.estadomovimiento\n" +
        "FROM movimientos as mov\n" +
        "INNER JOIN cuentas as cori on cori.Id=mov.cuentaorigenId\n" +
        "INNER JOIN cuentas as cdes on cdes.Id=mov.cuentadestinoId\n" + 
        "WHERE mov.cuentaorigenId=? \n" +
        "ORDER BY 1 desc\n" +
        "LIMIT 50";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            //preparedStatement.setString(1, tipoOperacionEnum.getValue());
            preparedStatement.setInt(1, cuenta_id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) { // if antes
                MovimientoDto i=new MovimientoDto();
                i.setId(rs.getInt("Id"));
                i.setFecha(rs.getString("fecha"));
                i.setAbono(rs.getDouble("abono"));
                i.setCargo(rs.getDouble("cargo"));
                i.setNombreoperacion(rs.getString("nombreoperacion"));
                i.setEstadoMovimiento(rs.getString("estadomovimiento"));
                listamovDto.add(i);
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Cuentas: " + e.getMessage());
        }

        return listamovDto;
    }
}
