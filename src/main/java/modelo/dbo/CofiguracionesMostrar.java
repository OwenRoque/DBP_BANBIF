
package modelo.dbo;

/**
 *
 * @author AVELINO
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.ClienteDto;


public class CofiguracionesMostrar {
    
    private final BDConexion conn;
    
    public CofiguracionesMostrar(BDConexion conn) {
        this.conn = conn;
    }
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    
   public ClienteDto getInfoClientes(int idClientes){
       ClienteDto clienteInfo = new ClienteDto();
       
       try{
            //String sql = "SELECT apepat, apemat, nombres, email, nombre FROM clientes INNER JOIN codigos WHERE clientes.nivelestudios_idc = codigos.id AND clientes.id='"+idClientes+"' LIMIT 1";
            String rra="----";
            String sql ="SELECT apepat, apemat, nombres, email, nombre, citizenship, nombreDepartamento, nombreProvincia, nombreDistrito, direccion_residencia, numero_residencia, interior_residencia, urbanizacion_residencia, coddepartamento_laboral, direccion_laboral, numero_laboral, interior_laboral, urbanizacion_laboral, nombreempresa_datolaboral, rucempresa_datolaboral, rubroempresa_datolaboral, telefono_datolaboral, cargo_datolaboral FROM clientes INNER JOIN codigos, nacionalidad, maestroubigeos WHERE clientes.nivelestudios_idc = codigos.id AND clientes.id='"+idClientes+"' AND clientes.nacionalidad_id = nacionalidad.id AND clientes.ubigeo_codigo=maestroubigeos.codigo  LIMIT 1";
           
            Connection con=conn.getConexion();
            if(con==null){
                System.out.println("Error en conexión de Base de datos");
                return null;
            }
            
            PreparedStatement preparedStatement = conn.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) { 
                System.out.println("ESTUDIO_ASDADAD");
                
                clienteInfo.setApemat(rs.getString("apemat"));
                clienteInfo.setApepat(rs.getString("apepat"));
                clienteInfo.setNombres(rs.getString("nombres"));
                clienteInfo.setEmail(rs.getString("email"));
                clienteInfo.setNivelestudios(rs.getString("nombre"));
                clienteInfo.setNacionalidad(rs.getString("citizenship"));
                clienteInfo.setDepartamentoResidencia(rs.getString("nombreDepartamento"));
                clienteInfo.setProvinciaResidencia(rs.getString("nombreDistrito"));
                clienteInfo.setDistritoResidencia(rs.getString("nombreDistrito"));
                clienteInfo.setDireccion_residencia(rs.getString("direccion_residencia"));
                clienteInfo.setNumero_residencia(rs.getString("numero_residencia"));
                clienteInfo.setInterior_residencia(rs.getString("interior_residencia"));
                clienteInfo.setUrbanizacion_residencia(rs.getString("urbanizacion_residencia"));
                clienteInfo.setDepartamentoLaboral(rs.getString("coddepartamento_laboral"));
                /*...falta otros valores*/
                clienteInfo.setDireccion_laboral(rs.getString("direccion_laboral"));
                clienteInfo.setNumero_laboral(rs.getString("numero_laboral"));
                clienteInfo.setInterior_laboral(rs.getString("interior_laboral"));
                clienteInfo.setUrbanizacion_laboral(rs.getString("urbanizacion_laboral"));
                
                /*bluq 3*/
                clienteInfo.setNombreempresa_datolaboral(rs.getString("nombreempresa_datolaboral"));
                clienteInfo.setRucempresa_datolaboral(rs.getString("rucempresa_datolaboral"));
                clienteInfo.setRubroempresa_datolaboral(rs.getString("rubroempresa_datolaboral"));
                clienteInfo.setTelefono_datolaboral(rs.getString("telefono_datolaboral"));
                clienteInfo.setCargo_datolaboral(rs.getString("cargo_datolaboral"));
                
                
                
            }
        } catch (SQLException e){
            System.out.println("Error Cargando Tipos de Cambios: " + e.getMessage());
        }
        return clienteInfo;
   }
   
   public void setInfoClientes(int cuenta_origen, String nivelEstudio, String nacionalidad, String  departamentoResidencia, String viaResidencia, String  direccionResidencia, String numeroResidencia, String interiorResidencia, String urbanizacionResidenncia, String departamentoLaboral, String viaLaboral, String direccionLaboral, String numeroLaboral, String interiorLaboral, String urbanizacionLaboral, String profesionLaboral, String nombreEmpresa, String telefonoLaboral, String cargoLaboral){
       try{
            String sql = "UPDATE clientes SET direccion_residencia = " + direccionResidencia + ", numero_residencia = " + numeroResidencia + ", interior_residencia = " + interiorResidencia +" WHERE id=' " + cuenta_origen + "'";
            String sql2 = "UPDATE clientes SET urbanizacion_residencia= " + urbanizacionResidenncia + ", direccion_laboral=" + direccionLaboral + ", numero_laboral =" + numeroLaboral +" WHERE id= '" + cuenta_origen + "'";
            String sql3 = "UPDATE clientes SET interior_laboral=" + interiorLaboral + ", urbanzacion_laboral=" + urbanizacionLaboral + ", nombreempresa_datolaboral=" + nombreEmpresa +" WHERE id= '" + cuenta_origen + "'";
            String sql4 = "UPDATE clientes SET telefono_datolaboral="+telefonoLaboral+", cargo_datolaboral=" + cargoLaboral + " WHERE id= '" + cuenta_origen + "'";
            
            

            PreparedStatement preparedStatement = conn.getConexion().prepareStatement(sql);
            preparedStatement.execute();
            PreparedStatement preparedStatement2 = conn.getConexion().prepareStatement(sql2);
            preparedStatement2.execute();
            PreparedStatement preparedStatement3 = conn.getConexion().prepareStatement(sql3);
            preparedStatement3.execute();
            PreparedStatement preparedStatement4 = conn.getConexion().prepareStatement(sql4);
            preparedStatement4.execute();
            
            
        }catch (SQLException e){    
            System.out.println("Error UsuarioBD.TransferirEntreCuentasPropias: " + e.getMessage());
        }
       
   }
   
}
