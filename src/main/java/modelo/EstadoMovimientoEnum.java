/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Haziel
 */
public enum EstadoMovimientoEnum {
    REGULAR("REG"),
    DIFERIDO("DIF"),
    RETENIDO("RET");
  

    private final String value;
    public String getValue()
    {
        return this.value;
    }
  
    EstadoMovimientoEnum(String _value)
    {
        this.value = _value;
    }
}
