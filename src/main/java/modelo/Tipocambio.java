/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Haziel
 */
public class Tipocambio {
    private int id;
    private Date fecha;
    private BigDecimal comprausd;
    private BigDecimal ventausd;
    private BigDecimal compraeuros;
    private BigDecimal ventaeuros;

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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the comprausd
     */
    public BigDecimal getComprausd() {
        return comprausd;
    }

    /**
     * @param comprausd the comprausd to set
     */
    public void setComprausd(BigDecimal comprausd) {
        this.comprausd = comprausd;
    }

    /**
     * @return the ventausd
     */
    public BigDecimal getVentausd() {
        return ventausd;
    }

    /**
     * @param ventausd the ventausd to set
     */
    public void setVentausd(BigDecimal ventausd) {
        this.ventausd = ventausd;
    }

    /**
     * @return the compraeuros
     */
    public BigDecimal getCompraeuros() {
        return compraeuros;
    }

    /**
     * @param compraeuros the compraeuros to set
     */
    public void setCompraeuros(BigDecimal compraeuros) {
        this.compraeuros = compraeuros;
    }

    /**
     * @return the ventaeuros
     */
    public BigDecimal getVentaeuros() {
        return ventaeuros;
    }

    /**
     * @param ventaeuros the ventaeuros to set
     */
    public void setVentaeuros(BigDecimal ventaeuros) {
        this.ventaeuros = ventaeuros;
    }
}
