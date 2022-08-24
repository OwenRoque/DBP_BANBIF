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
    private TipoOperacionEnum tipooperacionprincipal; /* Utilizar TipoOperacionEnum*/
    private int cuentaorigenId;
    private int cuentadestinoId;
    private BigDecimal monto;
    private String nombreoperacion;
    private EstadoMovimientoEnum estadomovimiento;
    private Character tipomovimiento; /*Solo puede ser A=Abono o C=Cargo*/
    private String cciexterno; /* Max long 35*/
    private Date fechaprogramado; /*Solo si es una operacion Programada*/
    private int estado; /* 0=Anulado, 1=OK,2=Programado */

    public String getMontoString() {
        return String.valueOf(monto.doubleValue());
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaoperacion() {
        return fechaoperacion;
    }

    public void setFechaoperacion(Date fechaoperacion) {
        this.fechaoperacion = fechaoperacion;
    }

    public TipoOperacionEnum getTipooperacionprincipal() {
        return tipooperacionprincipal;
    }

    public void setTipooperacionprincipal(TipoOperacionEnum tipooperacionprincipal) {
        this.tipooperacionprincipal = tipooperacionprincipal;
    }

    public int getCuentaorigenId() {
        return cuentaorigenId;
    }

    public void setCuentaorigenId(int cuentaorigenId) {
        this.cuentaorigenId = cuentaorigenId;
    }

    public int getCuentadestinoId() {
        return cuentadestinoId;
    }

    public void setCuentadestinoId(int cuentadestinoId) {
        this.cuentadestinoId = cuentadestinoId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getNombreoperacion() {
        return nombreoperacion;
    }

    public void setNombreoperacion(String nombreoperacion) {
        this.nombreoperacion = nombreoperacion;
    }

    public EstadoMovimientoEnum getEstadomovimiento() {
        return estadomovimiento;
    }

    public void setEstadomovimiento(EstadoMovimientoEnum estadomovimiento) {
        this.estadomovimiento = estadomovimiento;
    }

    public Character getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(Character tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public String getCciexterno() {
        return cciexterno;
    }

    public void setCciexterno(String cciexterno) {
        this.cciexterno = cciexterno;
    }

    public Date getFechaprogramado() {
        return fechaprogramado;
    }

    public void setFechaprogramado(Date fechaprogramado) {
        this.fechaprogramado = fechaprogramado;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
