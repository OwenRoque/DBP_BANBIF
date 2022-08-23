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
public class Maestroubigeos{

    private String codigo;
    private String codigoPais;
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    private String nombreDepartamento;
    private String nombreProvincia;
    private String nombreDistrito;
    private String nombreCapital;
    private int estado;
    private String autorizado;
    private Date createdAt;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigoPais
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * @param codigoPais the codigoPais to set
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    /**
     * @return the codigoDepartamento
     */
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * @param codigoDepartamento the codigoDepartamento to set
     */
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    /**
     * @return the codigoProvincia
     */
    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    /**
     * @param codigoProvincia the codigoProvincia to set
     */
    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    /**
     * @return the codigoDistrito
     */
    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    /**
     * @param codigoDistrito the codigoDistrito to set
     */
    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    /**
     * @return the nombreDepartamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * @param nombreDepartamento the nombreDepartamento to set
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     * @return the nombreProvincia
     */
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    /**
     * @param nombreProvincia the nombreProvincia to set
     */
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    /**
     * @return the nombreDistrito
     */
    public String getNombreDistrito() {
        return nombreDistrito;
    }

    /**
     * @param nombreDistrito the nombreDistrito to set
     */
    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    /**
     * @return the nombreCapital
     */
    public String getNombreCapital() {
        return nombreCapital;
    }

    /**
     * @param nombreCapital the nombreCapital to set
     */
    public void setNombreCapital(String nombreCapital) {
        this.nombreCapital = nombreCapital;
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
     * @return the autorizado
     */
    public String getAutorizado() {
        return autorizado;
    }

    /**
     * @param autorizado the autorizado to set
     */
    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
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
    
}
