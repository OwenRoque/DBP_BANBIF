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

public class Movimientos {
//    private static final long serialVersionUID = 1L;
    private int id;
    private Date fechaoperacion;
    private String tipooperacionprincipal; /* Utilizar TipoOperacionEnum*/
    private BigDecimal monto;
    private String nombreoperacion;
    private String estadomovimiento;
    private Character tipomovimiento;
    private String cciexterno;
    private Cuentas cuentadestinoId;
    private Cuentas cuentaorigenId;

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
     * @return the fechaoperacion
     */
    public Date getFechaoperacion() {
        return fechaoperacion;
    }

    /**
     * @param fechaoperacion the fechaoperacion to set
     */
    public void setFechaoperacion(Date fechaoperacion) {
        this.fechaoperacion = fechaoperacion;
    }

    /**
     * @return the tipooperacionprincipal
     */
    public String getTipooperacionprincipal() {
        return tipooperacionprincipal;
    }

    /**
     * @param tipooperacionprincipal the tipooperacionprincipal to set
     */
    public void setTipooperacionprincipal(String tipooperacionprincipal) {
        this.tipooperacionprincipal = tipooperacionprincipal;
    }

    /**
     * @return the monto
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    /**
     * @return the nombreoperacion
     */
    public String getNombreoperacion() {
        return nombreoperacion;
    }

    /**
     * @param nombreoperacion the nombreoperacion to set
     */
    public void setNombreoperacion(String nombreoperacion) {
        this.nombreoperacion = nombreoperacion;
    }

    /**
     * @return the estadomovimiento
     */
    public String getEstadomovimiento() {
        return estadomovimiento;
    }

    /**
     * @param estadomovimiento the estadomovimiento to set
     */
    public void setEstadomovimiento(String estadomovimiento) {
        this.estadomovimiento = estadomovimiento;
    }

    /**
     * @return the tipomovimiento
     */
    public Character getTipomovimiento() {
        return tipomovimiento;
    }

    /**
     * @param tipomovimiento the tipomovimiento to set
     */
    public void setTipomovimiento(Character tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    /**
     * @return the cciexterno
     */
    public String getCciexterno() {
        return cciexterno;
    }

    /**
     * @param cciexterno the cciexterno to set
     */
    public void setCciexterno(String cciexterno) {
        this.cciexterno = cciexterno;
    }

    /**
     * @return the cuentadestinoId
     */
    public Cuentas getCuentadestinoId() {
        return cuentadestinoId;
    }

    /**
     * @param cuentadestinoId the cuentadestinoId to set
     */
    public void setCuentadestinoId(Cuentas cuentadestinoId) {
        this.cuentadestinoId = cuentadestinoId;
    }

    /**
     * @return the cuentaorigenId
     */
    public Cuentas getCuentaorigenId() {
        return cuentaorigenId;
    }

    /**
     * @param cuentaorigenId the cuentaorigenId to set
     */
    public void setCuentaorigenId(Cuentas cuentaorigenId) {
        this.cuentaorigenId = cuentaorigenId;
    }

    
}
