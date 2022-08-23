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

public class Cuentas{
    private int id;
    private int cliente_id;
    private String cuenta;
    private String cci;
    private String nombre;
    private int tipocuenta_id;
    private Character moneda;
    private Date fechaapertura;
    private BigDecimal teaanual;
    private BigDecimal saldocontable;
    private BigDecimal saldodisponible;
    private int estado;
    private Date createdAt;
    private String banco;
    private int cuentaprincipal_id;

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
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the cci
     */
    public String getCci() {
        return cci;
    }

    /**
     * @param cci the cci to set
     */
    public void setCci(String cci) {
        this.cci = cci;
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
     * @return the tipocuenta_id
     */
    public int getTipocuenta_id() {
        return tipocuenta_id;
    }

    /**
     * @param tipocuenta_id the tipocuenta_id to set
     */
    public void setTipocuenta_id(int tipocuenta_id) {
        this.tipocuenta_id = tipocuenta_id;
    }

    /**
     * @return the moneda
     */
    public Character getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(Character moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the fechaapertura
     */
    public Date getFechaapertura() {
        return fechaapertura;
    }

    /**
     * @param fechaapertura the fechaapertura to set
     */
    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }

    /**
     * @return the teaanual
     */
    public BigDecimal getTeaanual() {
        return teaanual;
    }

    /**
     * @param teaanual the teaanual to set
     */
    public void setTeaanual(BigDecimal teaanual) {
        this.teaanual = teaanual;
    }

    /**
     * @return the saldocontable
     */
    public BigDecimal getSaldocontable() {
        return saldocontable;
    }

    /**
     * @param saldocontable the saldocontable to set
     */
    public void setSaldocontable(BigDecimal saldocontable) {
        this.saldocontable = saldocontable;
    }

    /**
     * @return the saldodisponible
     */
    public BigDecimal getSaldodisponible() {
        return saldodisponible;
    }

    /**
     * @param saldodisponible the saldodisponible to set
     */
    public void setSaldodisponible(BigDecimal saldodisponible) {
        this.saldodisponible = saldodisponible;
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

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the cuentaprincipal_id
     */
    public int getCuentaprincipal_id() {
        return cuentaprincipal_id;
    }

    /**
     * @param cuentaprincipal_id the cuentaprincipal_id to set
     */
    public void setCuentaprincipal_id(int cuentaprincipal_id) {
        this.cuentaprincipal_id = cuentaprincipal_id;
    }
    
}
