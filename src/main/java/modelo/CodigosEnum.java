/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Haziel
 */
public enum CodigosEnum {
    TipoCuentaAhorros(115),
    TipoCuentaTarjetas(116);
  

    private final int value;
    public int getValue()
    {
        return this.value;
    }
  
    CodigosEnum(int _value)
    {
        this.value = _value;
    }
}
