package modelo.dbo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import modelo.Clientes;
import modelo.dto.ClienteConectadoDto;
import modelo.dto.ClienteDto;

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
    
    public Clientes getbyId(int cliente_id){
        ClienteDto clienteDto = null;
        try{
            String sql = "SELECT cli.Id, cli.tdoc_idc, IFNULL(cotdoc.nombre,'') as tipodoc, cli.numerodoc, cli.apepat, cli.apemat, cli.nombres, \n" +
                        "cli.fecnac, cli.estado, cli.email, cli.telefonomovil, cli.telefonocasa,\n" +
                        "ifnull(cli.nivelestudios_idc,-1) as nivelestudios_idc, IFNULL(cotnivel.nombre,'') as nivelestudios,\n" +
                        "IFNULL(cli.nacionalidad_id,-1) as nacionalidad_id, IFNULL(cotnaci.nombre,'') as nacionalidad,\n" +
                        "IFNULL(cli.ubigeo_codigo,'') as ubigeo_codigo, \n" +
                        "IFNULL(concat(ubi.nombreDepartamento,' ',ubi.nombreProvincia, ' ', ubi.nombreDistrito),'') as ubigeo,\n" +
                        "IFNULL(cli.via_idc_residencia,'') via_idc_residencia,\n" +
                        "IFNULL(cotresi.nombre,'') as nombrevia_residencia,\n" +
                        "IFNULL(cli.direccion_residencia,'') as direccion_residencia,\n" +
                        "IFNULL(cli.numero_residencia,'') as numero_residencia,\n" +
                        "IFNULL(cli.interior_residencia,'') as interior_residencia,\n" +
                        "IFNULL(cli.urbanizacion_residencia,'') as urbanizacion_residencia,\n" +
                        "IFNULL(cli.coddepartamento_laboral,'') as coddepartamento_laboral,\n" +
                        "IFNULL(cli.via_idc_laboral,'') as coddepartamento_laboral, \n" +
                        "IFNULL(cotlabo.nombre,'') as nombrevia_laboral,\n" +
                        "IFNULL(cli.direccion_laboral,'') as direccion_laboral,\n" +
                        "IFNULL(cli.numero_laboral,'') as numero_laboral,\n" +
                        "IFNULL(cli.interior_laboral,'') as interior_laboral,\n" +
                        "IFNULL(cli.urbanizacion_laboral,'') as urbanizacion_laboral,\n" +
                        "IFNULL(cli.profesion_idc_datolaboral,-1) as profesion_idc_datolaboral,\n" +
                        "IFNULL(cotprofe.nombre,'') as nombreprofesiondatolaboral,\n" +
                        "IFNULL(cli.nombreempresa_datolaboral,'') as nombreempresa_datolaboral,\n" +
                        "IFNULL(cli.rucempresa_datolaboral,'') as rucempresa_datolaboral,\n" +
                        "IFNULL(cli.rubroempresa_datolaboral,'') as rubroempresa_datolaboral,\n" +
                        "IFNULL(cli.telefono_datolaboral,'') as telefono_datolaboral,\n" +
                        "IFNULL(cli.cargo_datolaboral,'') as cargo_datolaboral,\n" +
                        "cli.created_at, IFNULL(cli.banco_idc,-1) as banco_idc,\n" +
                        "IFNULL(cotbanco.nombre,'') as nombrebanco\n" +
                        "FROM clientes as cli\n" +
                        "LEFT JOIN codigos AS cotdoc on cotdoc.Id=cli.tdoc_idc\n" +
                        "LEFT JOIN codigos AS cotnivel on cotnivel.Id=cli.nivelestudios_idc\n" +
                        "LEFT JOIN codigos AS cotnaci on cotnaci.Id=cli.nacionalidad_id\n" +
                        "LEFT JOIN maestroubigeos AS ubi on ubi.codigo=cli.ubigeo_codigo\n" +
                        "LEFT JOIN codigos AS cotresi on cotresi.Id=cli.via_idc_residencia\n" +
                        "LEFT JOIN codigos AS cotlabo on cotlabo.Id=cli.via_idc_laboral\n" +
                        "LEFT JOIN codigos AS cotprofe on cotprofe.Id=cli.profesion_idc_datolaboral\n" +
                        "LEFT JOIN codigos AS cotbanco on cotbanco.Id=cli.banco_idc\n" +
                        "WHERE cli.Id=? LIMIT 1";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, cliente_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) { 
                clienteDto = new ClienteDto();
            }
        } catch (SQLException e){
            System.out.println("Error UsuarioBD.validarUsuario(): " + e.getMessage());
        }

        return clienteDto;
    }
    
    public String getClavebyId(int cliente_id){
        String resultado = null;
        try{
            String sql = "SELECT clave FROM clientes WHERE Id=?";
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, cliente_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) { 
                resultado = rs.getString("clave");
            }
        } catch (SQLException e){
            System.out.println("Error UsuarioBD.validarUsuario(): " + e.getMessage());
        }
        return resultado;
    }
    
    public void TransferirEntreCuentasPropias(String cuentaid_origen , String cuentaid_destino , BigDecimal monto,String descripcion){
        // evitar doble registro
        if (descripcion==null)
            return;
        try{
            String sql = "UPDATE cuentas SET saldocontable = saldocontable - "+monto+", "
                    + "saldodisponible = saldodisponible - "+monto+" "
                    + "WHERE id= '"+cuentaid_origen+"'";
            PreparedStatement preparedStatement = conn.getConexion().prepareStatement(sql);
            preparedStatement.execute();
            
            String sql2 = "UPDATE cuentas SET saldocontable = saldocontable + "+monto+", "
                    + "saldodisponible = saldodisponible + "+monto+" "
                    + "WHERE id= '"+cuentaid_destino+"'";
            PreparedStatement preparedStatement2 = conn.getConexion().prepareStatement(sql2);
            preparedStatement2.execute();
            
            String sqlMov = "INSERT INTO movimientos(fechaoperacion,tipooperacionprincipal,cuentaorigenId,"
                    + "cuentadestinoId,monto,nombreoperacion, estadomovimiento,tipomovimiento,estado) "
                    + "VALUES (NOW(),'TEC', ?, ?, ?, ?, 'REG', 'C', 1);";
            
            PreparedStatement preparedStatement3 = conn.getConexion().prepareStatement(sqlMov);
            preparedStatement3.setString(1, cuentaid_origen);
            preparedStatement3.setString(2, cuentaid_destino);
            preparedStatement3.setBigDecimal(3, monto);
            preparedStatement3.setString(4, descripcion); /*nombre operacion*/
            preparedStatement3.execute();
            
            String sqlMov2 = "INSERT INTO movimientos(fechaoperacion,tipooperacionprincipal,cuentaorigenId,"
                    + "cuentadestinoId,monto,nombreoperacion, estadomovimiento,tipomovimiento,estado) "
                    + "VALUES (NOW(),'TEC', ?, ?, ?, ?, 'REG', 'A', 1);";
            
            PreparedStatement preparedStatement4 = conn.getConexion().prepareStatement(sqlMov2);
            preparedStatement4.setString(1, cuentaid_destino);
            preparedStatement4.setString(2, cuentaid_origen);
            preparedStatement4.setBigDecimal(3, monto);
            preparedStatement4.setString(4, descripcion); /*nombre operacion*/
            preparedStatement4.execute();
            
        }catch (SQLException e){    
            System.out.println("Error UsuarioBD.TransferirEntreCuentasPropias: " + e.getMessage());
        }
    }
}
