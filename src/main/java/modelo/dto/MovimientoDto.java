
package modelo.dto;


/**
 *
 * @author Haziel
 */
public class MovimientoDto {
    private int Id;
    private String fecha; // en Mov
    private double abono;
    private double cargo;
    private String nombreoperacion; // en Mov
    private String estadoMovimiento;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreoperacion() {
        return nombreoperacion;
    }

    public void setNombreoperacion(String nombreoperacion) {
        this.nombreoperacion = nombreoperacion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getFecha() {
        return fecha;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public String getEstadoMovimiento() {
        return estadoMovimiento;
    }

    public void setEstadoMovimiento(String estadoMovimiento) {
        this.estadoMovimiento = estadoMovimiento;
    }
    
}
