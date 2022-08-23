
package modelo.dto;

public class TipoDeCambioDto {
    private int Id;
    private float comprausd;
    private float ventausd;
    private float compraeuros;
    private float ventaeuros;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public float getComprausd() {
        return comprausd;
    }

    public void setComprausd(float comprausd) {
        this.comprausd = comprausd;
    }

    public float getVentausd() {
        return ventausd;
    }

    public void setVentausd(float ventausd) {
        this.ventausd = ventausd;
    }

    public float getCompraeuros() {
        return compraeuros;
    }

    public void setCompraeuros(float compraeuros) {
        this.compraeuros = compraeuros;
    }

    public float getVentaeuros() {
        return ventaeuros;
    }

    public void setVentaeuros(float ventaeuros) {
        this.ventaeuros = ventaeuros;
    }
    
}
