
package modelo.dto;

import modelo.Clientes;

/* Dto = Data Transfer Object para Cliente*/
public class ClienteDto extends Clientes{
    private String tipodoc;  // DNI  
    private String nivelestudios;
    private String nacionalidad;
    private String ubigeo;
    private String nombrevia_residencia;
    private String nombrevia_laboral;
    private String nombreprofesiondatolaboral;
    private String nombrebanco;
    
    
    /*
        Modificación: agregar atributos de departamento_residencia, provincia_residencia, distrito_residencia..,
    */
    private String departamento_residencia; 
    private String provincia_residencia;
    private String distrito_residencia;
    
    private String departamento_laboral; 
    private String provincia_laboral;
    private String distrito_laboral;
    
    
    public String getDepartamentoResidencia(){
        return this.departamento_residencia;
    }
    
    public void setDepartamentoResidencia(String departamento){
        this.departamento_residencia = departamento;
    }
    
    public String getProvinciaResidencia(){
        return this.provincia_residencia;
    }
    
    public void setProvinciaResidencia(String provincia){
        this.provincia_residencia = provincia;
    }
    
    public String getDistritoResidencia(){
        return this.distrito_residencia;
    }
    
    public void setDistritoResidencia(String distrito){
        this.distrito_residencia = distrito;
    }
    
    
    public String getDepartamentoLaboral(){
        return this.departamento_laboral;
    }
    
    public void setDepartamentoLaboral(String departamento){
        this.departamento_laboral = departamento;
    }
    
    public String getProvinciaLaboral(){
        return this.provincia_laboral;
    }
    
    public void setProvinciaLaboral(String provincia){
        this.provincia_laboral = provincia;
    }
    
    public String getDistritoLaboral(){
        return this.distrito_laboral;
    }
    
    public void setDistritoLaboral(String distrito){
        this.distrito_laboral = distrito;
    }
    
    
    /* FIN MODIFICACION ....................................*/
    
    
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
