/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
/**
 *
 * @author Haziel
 */
public class Tipocuentas {
    private int id;
    private int tipoIdc;
    private String nombre;
    private BigDecimal teaAnual;
    private BigDecimal montoMinimoApertura;
    private Boolean productoDigital;
    private BigDecimal costoMantenimientoSoles;
    private BigDecimal costoMantenimientoDolares;
    private String promociones;
    private int estado;   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipoIdc
     */
    public int getTipoIdc() {
        return tipoIdc;
    }

    /**
     * @param tipoIdc the tipoIdc to set
     */
    public void setTipoIdc(int tipoIdc) {
        this.tipoIdc = tipoIdc;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the teaAnual
     */
    public BigDecimal getTeaAnual() {
        return teaAnual;
    }

    /**
     * @param teaAnual the teaAnual to set
     */
    public void setTeaAnual(BigDecimal teaAnual) {
        this.teaAnual = teaAnual;
    }

    /**
     * @return the montoMinimoApertura
     */
    public BigDecimal getMontoMinimoApertura() {
        return montoMinimoApertura;
    }

    /**
     * @param montoMinimoApertura the montoMinimoApertura to set
     */
    public void setMontoMinimoApertura(BigDecimal montoMinimoApertura) {
        this.montoMinimoApertura = montoMinimoApertura;
    }

    /**
     * @return the productoDigital
     */
    public Boolean getProductoDigital() {
        return productoDigital;
    }

    /**
     * @param productoDigital the productoDigital to set
     */
    public void setProductoDigital(Boolean productoDigital) {
        this.productoDigital = productoDigital;
    }

    /**
     * @return the costoMantenimientoSoles
     */
    public BigDecimal getCostoMantenimientoSoles() {
        return costoMantenimientoSoles;
    }

    /**
     * @param costoMantenimientoSoles the costoMantenimientoSoles to set
     */
    public void setCostoMantenimientoSoles(BigDecimal costoMantenimientoSoles) {
        this.costoMantenimientoSoles = costoMantenimientoSoles;
    }

    /**
     * @return the costoMantenimientoDolares
     */
    public BigDecimal getCostoMantenimientoDolares() {
        return costoMantenimientoDolares;
    }

    /**
     * @param costoMantenimientoDolares the costoMantenimientoDolares to set
     */
    public void setCostoMantenimientoDolares(BigDecimal costoMantenimientoDolares) {
        this.costoMantenimientoDolares = costoMantenimientoDolares;
    }

    /**
     * @return the promociones
     */
    public String getPromociones() {
        return promociones;
    }

    /**
     * @param promociones the promociones to set
     */
    public void setPromociones(String promociones) {
        this.promociones = promociones;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
