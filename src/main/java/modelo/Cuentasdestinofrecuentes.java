/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Haziel
 */
public class Cuentasdestinofrecuentes {
    private int id;
    private String nombreCuentaDestinoTransferencia;
    private int idCuentaorigen;
    private int idCuentaDestino;
    private int bancoIdc;
    private String numerocciexterna;

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
     * @return the nombreCuentaDestinoTransferencia
     */
    public String getNombreCuentaDestinoTransferencia() {
        return nombreCuentaDestinoTransferencia;
    }

    /**
     * @param nombreCuentaDestinoTransferencia the nombreCuentaDestinoTransferencia to set
     */
    public void setNombreCuentaDestinoTransferencia(String nombreCuentaDestinoTransferencia) {
        this.nombreCuentaDestinoTransferencia = nombreCuentaDestinoTransferencia;
    }

    /**
     * @return the idCuentaorigen
     */
    public int getIdCuentaorigen() {
        return idCuentaorigen;
    }

    /**
     * @param idCuentaorigen the idCuentaorigen to set
     */
    public void setIdCuentaorigen(int idCuentaorigen) {
        this.idCuentaorigen = idCuentaorigen;
    }

    /**
     * @return the idCuentaDestino
     */
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * @param idCuentaDestino the idCuentaDestino to set
     */
    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * @return the bancoIdc
     */
    public int getBancoIdc() {
        return bancoIdc;
    }

    /**
     * @param bancoIdc the bancoIdc to set
     */
    public void setBancoIdc(int bancoIdc) {
        this.bancoIdc = bancoIdc;
    }

    /**
     * @return the numerocciexterna
     */
    public String getNumerocciexterna() {
        return numerocciexterna;
    }

    /**
     * @param numerocciexterna the numerocciexterna to set
     */
    public void setNumerocciexterna(String numerocciexterna) {
        this.numerocciexterna = numerocciexterna;
    }
}
