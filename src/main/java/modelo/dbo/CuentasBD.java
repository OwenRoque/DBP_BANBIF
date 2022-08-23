package modelo.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CodigosEnum;
import modelo.dto.ComboItemDto;
import modelo.dto.TipoCuentaDto;

public class CuentasBD {

    public CuentasBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private final BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    /*Un Array del Objeto ComboItemDto, que es un Dto simplificado para trabajar con la vista*/
    public ArrayList<ComboItemDto> getCuentasUsuario(int cliente_id, CodigosEnum tipoCuentaEnum){
        ArrayList<ComboItemDto> listaCuentasDto = new ArrayList<>();
        try{
            String sql = "SELECT cu.Id, cu.cuenta, cu.saldodisponible " +
                        "FROM cuentas as cu " +
                        "INNER JOIN clientes as cli on cli.Id=cu.cliente_id " +
                        "INNER JOIN tipocuentas as tcu on tcu.Id=cu.tipocuenta_id " +
                        "INNER JOIN codigos as cod on cod.Id=tcu.tipo_idc " +
                        "WHERE cu.estado=1 " +
                        "AND cli.Id=?" +
                        " AND tcu.tipo_idc=?" + /* 115=ahorros, 116=Tarjetas (Tabla Codigos)*/
                        " ORDER BY 2";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, cliente_id);
            preparedStatement.setInt(2, tipoCuentaEnum.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) { // if antes
                ComboItemDto i=new ComboItemDto();
                i.setId(rs.getInt("Id"));
                i.setNombre(rs.getString("cuenta"));
                i.setValue(String.valueOf(rs.getDouble("saldodisponible")));
                listaCuentasDto.add(i);
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Cuentas: " + e.getMessage());
        }

        return listaCuentasDto;
    }
    
    public ArrayList<TipoCuentaDto> getALLCuentasUsuario(int cliente_id){
        ArrayList<TipoCuentaDto> listaAllCuentasDto = new ArrayList<>();
        try{
            String sql = "SELECT cu.Id, cu.cuenta, tcu.Nombre as nombretipocuenta, " +
                            "cu.nombre as nombrealias, cu.cci, cu.moneda, cu.saldocontable, cu.saldodisponible " +
                            "FROM cuentas as cu " +
                            "INNER JOIN clientes as cli on cli.Id=cu.cliente_id " +
                            "INNER JOIN tipocuentas as tcu on tcu.Id=cu.tipocuenta_id " +
                            "INNER JOIN codigos as cod on cod.Id=tcu.tipo_idc " +
                            "WHERE cu.estado=1 " +
                            "AND cli.Id=? " +
                            "ORDER BY 2";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, cliente_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TipoCuentaDto i = new TipoCuentaDto();
                i.setId(rs.getInt("Id"));
                i.setNumcuenta(rs.getString("cuenta"));
                i.setNombretipocuenta(rs.getString("nombretipocuenta"));
                i.setNombrealias(rs.getString("nombrealias"));
                i.setCci(rs.getString("cci"));
                i.setMoneda(rs.getString("moneda"));
                i.setSaldocontable(rs.getFloat("saldocontable"));
                i.setSaldodisponible(rs.getFloat("saldodisponible"));
                listaAllCuentasDto.add(i);
            }
        } catch (SQLException e){
            System.out.println("Error Cargando todas las Cuentas: " + e.getMessage());
        }
        return listaAllCuentasDto;
    }
}
