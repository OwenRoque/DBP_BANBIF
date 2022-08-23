/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

/**
 *
 * @author Haziel
 */
public class TipoCuentaDto {
    private int id;
    private String numcuenta; // numero de la cuenta
    private String nombretipocuenta; // nombre del tipo de cuenta
    private String nombrealias;
    private String cci;
    private String moneda;
    private float saldocontable;
    private float saldodisponible;

    public String getSaldoContable() {
        String ret;
        if ("S".equals(moneda))
            ret = "S/. ";
        else ret = "$ ";
        ret = ret+String.valueOf(saldocontable);
        return ret;
    }
    
    public String getSaldoDisponible() {
        String ret;
        if ("S".equals(moneda))
            ret = "S/. ";
        else ret = "$ ";
        ret = ret+String.valueOf(saldodisponible);
        return ret;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getNombretipocuenta() {
        return nombretipocuenta;
    }

    public void setNombretipocuenta(String nombretipocuenta) {
        this.nombretipocuenta = nombretipocuenta;
    }

    public String getNombrealias() {
        return nombrealias;
    }

    public void setNombrealias(String nombrealias) {
        this.nombrealias = nombrealias;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getSaldocontable() {
        return saldocontable;
    }

    public void setSaldocontable(float saldocontable) {
        this.saldocontable = saldocontable;
    }

    public float getSaldodisponible() {
        return saldodisponible;
    }

    public void setSaldodisponible(float saldodisponible) {
        this.saldodisponible = saldodisponible;
    }
    
}