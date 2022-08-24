
package modelo.dto;

import modelo.Clientes;

/* Dto = Data Transfer Object para Cliente*/
public class ClienteDto extends Clientes{
    private String razon; // nombre completo
    private String tipodoc;  // DNI  
    private String nivelestudios;
    private String nacionalidad;
    private String ubigeo;
    private String nombrevia_residencia;
    private String nombrevia_laboral;
    private String nombreprofesiondatolaboral;
    private String nombrebanco; 

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNivelestudios() {
        return nivelestudios;
    }

    public void setNivelestudios(String nivelestudios) {
        this.nivelestudios = nivelestudios;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getNombrevia_residencia() {
        return nombrevia_residencia;
    }

    public void setNombrevia_residencia(String nombrevia_residencia) {
        this.nombrevia_residencia = nombrevia_residencia;
    }

    public String getNombrevia_laboral() {
        return nombrevia_laboral;
    }

    public void setNombrevia_laboral(String nombrevia_laboral) {
        this.nombrevia_laboral = nombrevia_laboral;
    }

    public String getNombreprofesiondatolaboral() {
        return nombreprofesiondatolaboral;
    }

    public void setNombreprofesiondatolaboral(String nombreprofesiondatolaboral) {
        this.nombreprofesiondatolaboral = nombreprofesiondatolaboral;
    }

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }
    
}
