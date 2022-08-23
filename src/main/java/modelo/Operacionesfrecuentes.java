/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
/**
 *
 * @author Haziel
 */
public class Operacionesfrecuentes{

    private int id;
    private int clienteId;
    private int movimientoId;
    private String nombre;
    private int frecuenciaIdc;
    private String frecuenciaejecucion;
    private String frecuenciaejecucionDia;
    private Date fechatermino;
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
     * @return the clienteId
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * @return the movimientoId
     */
    public int getMovimientoId() {
        return movimientoId;
    }

    /**
     * @param movimientoId the movimientoId to set
     */
    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
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
     * @return the frecuenciaIdc
     */
    public int getFrecuenciaIdc() {
        return frecuenciaIdc;
    }

    /**
     * @param frecuenciaIdc the frecuenciaIdc to set
     */
    public void setFrecuenciaIdc(int frecuenciaIdc) {
        this.frecuenciaIdc = frecuenciaIdc;
    }

    /**
     * @return the frecuenciaejecucion
     */
    public String getFrecuenciaejecucion() {
        return frecuenciaejecucion;
    }

    /**
     * @param frecuenciaejecucion the frecuenciaejecucion to set
     */
    public void setFrecuenciaejecucion(String frecuenciaejecucion) {
        this.frecuenciaejecucion = frecuenciaejecucion;
    }

    /**
     * @return the frecuenciaejecucionDia
     */
    public String getFrecuenciaejecucionDia() {
        return frecuenciaejecucionDia;
    }

    /**
     * @param frecuenciaejecucionDia the frecuenciaejecucionDia to set
     */
    public void setFrecuenciaejecucionDia(String frecuenciaejecucionDia) {
        this.frecuenciaejecucionDia = frecuenciaejecucionDia;
    }

    /**
     * @return the fechatermino
     */
    public Date getFechatermino() {
        return fechatermino;
    }

    /**
     * @param fechatermino the fechatermino to set
     */
    public void setFechatermino(Date fechatermino) {
        this.fechatermino = fechatermino;
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
