package modelo.dbo;

public class MovimientosBD {

    public MovimientosBD(BDConexion conn) {
        this.conn = conn;
    }
    
    private BDConexion conn;
    
    public BDConexion getConexion(){
        return this.conn;
    }
    
    public boolean saveMovimiento(){
        return false;
    }
//    public ArrayList<ComboItemDto> getCuentasUsuario(int cliente_id, CodigosEnum tipoCuentaEnum){
//        ArrayList<ComboItemDto> listaCuentasDto = new ArrayList<ComboItemDto>();
//        try{
//            String sql = "SELECT cu.Id, cu.cuenta, cu.saldodisponible " +
//                        "FROM cuentas as cu " +
//                        "INNER JOIN clientes as cli on cli.Id=cu.cliente_id " +
//                        "INNER JOIN tipocuentas as tcu on tcu.Id=cu.tipocuenta_id " +
//                        "INNER JOIN codigos as cod on cod.Id=tcu.tipo_idc " +
//                        "WHERE cu.estado=1 " +
//                        "AND cli.Id=?" +
//                        " AND tcu.tipo_idc=?" + /* 115=ahorros, 116=Tarjetas (Tabla Codigos)*/
//                        " ORDER BY 2";
//            Connection con=conn.getConexion();
//            if(con==null){
//                System.out.println("Error en conexión de Base de datos");
//                return null;
//            }
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setInt(1, cliente_id);
//            preparedStatement.setInt(2, tipoCuentaEnum.getValue());
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()) {
//                ComboItemDto i=new ComboItemDto();
//                i.setId(rs.getInt("Id"));
//                i.setNombre(rs.getString("cuenta"));
//                i.setValue(String.valueOf(rs.getDouble("saldodisponible")));
//                listaCuentasDto.add(i);
//            }
//        } catch (SQLException e){
//            System.out.println("Error Cargando Cuentas: " + e.getMessage());
//        }
//
//        return listaCuentasDto;
//    }
    
}
