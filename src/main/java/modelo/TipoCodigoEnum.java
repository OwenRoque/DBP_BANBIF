/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Haziel
 */
public enum TipoCodigoEnum {
    TipoVia("TVIA"),
    TipoEstudio("TESTUDIO"),
    TipoProfesion("TPROFESION"),
    TipoDocumentoIdentidad("TDOC"),
    TipoBanco("TBANCO"),
    TipoTransferencia("TTRANS"),
    TipoFrecuencia("TFREC"),
    TipoCuenta("TCUENTA"),
    ;
  

    private final String value;
    public String getValue()
    {
        return this.value;
    }
  
    TipoCodigoEnum(String _value)
    {
        this.value = _value;
    }
}
