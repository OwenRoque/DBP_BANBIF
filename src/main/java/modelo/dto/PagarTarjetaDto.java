package modelo.dto;

import java.util.Date;

public class PagarTarjetaDto {

    private int tarjeta_id;
    private double monto;
    private int cuentaorigen_id;
    private String descripcion;
    private boolean esProgramado;
    private Date fechaEjecucion;
    private String frecuencia;
    private String tokenConfirmacion;

    /**
     * @return the tarjeta_id
     */
    public int getTarjeta_id() {
        return tarjeta_id;
    }

    /**
     * @param tarjeta_id the tarjeta_id to set
     */
    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the cuentaorigen_id
     */
    public int getCuentaorigen_id() {
        return cuentaorigen_id;
    }

    /**
     * @param cuentaorigen_id the cuentaorigen_id to set
     */
    public void setCuentaorigen_id(int cuentaorigen_id) {
        this.cuentaorigen_id = cuentaorigen_id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the esProgramado
     */
    public boolean isEsProgramado() {
        return esProgramado;
    }

    /**
     * @param esProgramado the esProgramado to set
     */
    public void setEsProgramado(boolean esProgramado) {
        this.esProgramado = esProgramado;
    }

    /**
     * @return the fechaEjecucion
     */
    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    /**
     * @param fechaEjecucion the fechaEjecucion to set
     */
    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    /**
     * @return the frecuencia
     */
    public String getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * @return the tokenConfirmacion
     */
    public String getTokenConfirmacion() {
        return tokenConfirmacion;
    }

    /**
     * @param tokenConfirmacion the tokenConfirmacion to set
     */
    public void setTokenConfirmacion(String tokenConfirmacion) {
        this.tokenConfirmacion = tokenConfirmacion;
    }

}
