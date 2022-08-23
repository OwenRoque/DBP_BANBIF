package modelo.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import modelo.dto.ClienteConectadoDto;

public class UsuarioBD {

    /* Crear Constructor */
    public UsuarioBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private final BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    public ClienteConectadoDto validarUsuario(String usuario, String clave, String ip){
        ClienteConectadoDto clienteDto = null;
        try{
            String sql = "SELECT Id,tdoc_idc,numerodoc,clave,email,concat(apepat,' ',apemat,', ',nombres) as razon FROM clientes  where estado=1 and numerodoc=? and tdoc_idc=60 LIMIT 1";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) { /* antes era while, ahora es if, porque solo habra un registro */
                if(rs.getString("clave").equals(clave)){
                    clienteDto = new ClienteConectadoDto();
                    clienteDto.setId(rs.getInt("id"));
                    clienteDto.setTdoc_idc(rs.getInt("tdoc_idc"));
                    clienteDto.setNumerodoc(rs.getString("numerodoc"));
                    clienteDto.setRazon(rs.getString("razon"));
                    clienteDto.setEmail(rs.getString("email"));
                    clienteDto.setIngreso(new Date());
                    clienteDto.setIp(ip);
                    return clienteDto;
                }
            }
        } catch (SQLException e){
            System.out.println("Error UsuarioBD.validarUsuario(): " + e.getMessage());
        }

        return null;
    }
    public void RegistrarUsuario(String usuario, String clave){
        System.out.println("Error operación no permitida por el momento");
//        try{
//            String sql = "INSERT INTO usuario VALUES ('" + usuario + "','" + clave + "')";
//            PreparedStatement preparedStatement = conn.getConexion().prepareStatement(sql);
//            preparedStatement.executeQuery();
//        } catch (SQLException e){
//            System.out.println("Error UsuarioDB registrarUsuario: " + e.getMessage());
//        }
    }
}
