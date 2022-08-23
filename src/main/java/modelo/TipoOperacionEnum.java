/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Haziel
 */
public enum TipoOperacionEnum {
    PagarOtrasTarjetas("POT"),
    PagarTarjetasOtrosBancos("PTO"),
    PagarTarjetasDiners("PTD"),
    PagarPrestamos("PPR"),
    PagarServicios("PSE") ;
  

    private final String value;
    public String getValue()
    {
        return this.value;
    }
  
    TipoOperacionEnum(String _value)
    {
        this.value = _value;
    }
}
