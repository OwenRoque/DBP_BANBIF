package modelo.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TipoCodigoEnum;
import modelo.dto.ComboItemDto;

public class CodigosBD {

    public CodigosBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private final BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    /*Un Array del Objeto ComboItemDto, que es un Dto simplificado para trabajar con la vista*/
    public ArrayList<ComboItemDto> getTiposBy(TipoCodigoEnum tipoCodigoEnum){
        ArrayList<ComboItemDto> listaCodigosDto = new ArrayList<>();
        try{
            String sql = "SELECT Id, nombre, IFNULL(valor,'') as valor FROM codigos " +
                        "WHERE tipo=? ORDER BY 2";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tipoCodigoEnum.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) { 
                ComboItemDto i=new ComboItemDto();
                i.setId(rs.getInt("Id"));
                i.setNombre(rs.getString("nombre"));
                i.setValue(rs.getString("valor"));
                listaCodigosDto.add(i);
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Cuentas: " + e.getMessage());
        }

        return listaCodigosDto;
    }
    
    public ComboItemDto getbyId(int id){
        ComboItemDto item = null;
        try{
            String sql = "SELECT Id, nombre, IFNULL(valor,'') as valor FROM codigos " +
                        "WHERE Id=? ORDER BY 2";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) { 
                item=new ComboItemDto();
                item.setId(rs.getInt("Id"));
                item.setNombre(rs.getString("nombre"));
                item.setValue(rs.getString("valor"));
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Cuenta: " + e.getMessage());
        }

        return item;
    }
}
