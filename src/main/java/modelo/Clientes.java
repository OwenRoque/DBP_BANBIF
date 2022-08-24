package modelo;

public class Clientes {
    private int Id;
    private int tdoc_idc;
    private String numerodoc;  // DNI  
    private String apepat;
    private String apemat;
    private String nombres;
    private String fecnac;
    private String clave;
    private int estado;
    private String email;
    private String telefonomovil;
    private String telefonocasa;
    private int nivelestudios_idc;
    private int nacionalidad_id;
    private String ubigeo_codigo;
    private int via_idc_residencia;
    private String direccion_residencia;
    private String numero_residencia;
    private String interior_residencia;
    private String urbanizacion_residencia;
    private String coddepartamento_laboral;
    private int via_idc_laboral;
    private String direccion_laboral;
    private String numero_laboral;
    private String interior_laboral;
    private String urbanizacion_laboral;
    private int profesion_idc_datolaboral;
    private String nombreempresa_datolaboral;
    private String rucempresa_datolaboral;
    private String rubroempresa_datolaboral;
    private String telefono_datolaboral;
    private String cargo_datolaboral;
    private boolean escuentaexterna;
    private int banco_idc;

    public String getRazon() {
        return apepat + " " + apemat + " " + nombres;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the tdoc_idc
     */
    public int getTdoc_idc() {
        return tdoc_idc;
    }

    /**
     * @param tdoc_idc the tdoc_idc to set
     */
    public void setTdoc_idc(int tdoc_idc) {
        this.tdoc_idc = tdoc_idc;
    }

    /**
     * @return the numerodoc
     */
    public String getNumerodoc() {
        return numerodoc;
    }

    /**
     * @param numerodoc the numerodoc to set
     */
    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    /**
     * @return the apepat
     */
    public String getApepat() {
        return apepat;
    }

    /**
     * @param apepat the apepat to set
     */
    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    /**
     * @return the apemat
     */
    public String getApemat() {
        return apemat;
    }

    /**
     * @param apemat the apemat to set
     */
    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the fecnac
     */
    public String getFecnac() {
        return fecnac;
    }

    /**
     * @param fecnac the fecnac to set
     */
    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefonomovil
     */
    public String getTelefonomovil() {
        return telefonomovil;
    }

    /**
     * @param telefonomovil the telefonomovil to set
     */
    public void setTelefonomovil(String telefonomovil) {
        this.telefonomovil = telefonomovil;
    }

    /**
     * @return the telefonocasa
     */
    public String getTelefonocasa() {
        return telefonocasa;
    }

    /**
     * @param telefonocasa the telefonocasa to set
     */
    public void setTelefonocasa(String telefonocasa) {
        this.telefonocasa = telefonocasa;
    }

    /**
     * @return the nivelestudios_idc
     */
    public int getNivelestudios_idc() {
        return nivelestudios_idc;
    }

    /**
     * @param nivelestudios_idc the nivelestudios_idc to set
     */
    public void setNivelestudios_idc(int nivelestudios_idc) {
        this.nivelestudios_idc = nivelestudios_idc;
    }

    /**
     * @return the nacionalidad_id
     */
    public int getNacionalidad_id() {
        return nacionalidad_id;
    }

    /**
     * @param nacionalidad_id the nacionalidad_id to set
     */
    public void setNacionalidad_id(int nacionalidad_id) {
        this.nacionalidad_id = nacionalidad_id;
    }

    /**
     * @return the ubigeo_codigo
     */
    public String getUbigeo_codigo() {
        return ubigeo_codigo;
    }

    /**
     * @param ubigeo_codigo the ubigeo_codigo to set
     */
    public void setUbigeo_codigo(String ubigeo_codigo) {
        this.ubigeo_codigo = ubigeo_codigo;
    }

    /**
     * @return the via_idc_residencia
     */
    public int getVia_idc_residencia() {
        return via_idc_residencia;
    }

    /**
     * @param via_idc_residencia the via_idc_residencia to set
     */
    public void setVia_idc_residencia(int via_idc_residencia) {
        this.via_idc_residencia = via_idc_residencia;
    }

    /**
     * @return the direccion_residencia
     */
    public String getDireccion_residencia() {
        return direccion_residencia;
    }

    /**
     * @param direccion_residencia the direccion_residencia to set
     */
    public void setDireccion_residencia(String direccion_residencia) {
        this.direccion_residencia = direccion_residencia;
    }

    /**
     * @return the numero_residencia
     */
    public String getNumero_residencia() {
        return numero_residencia;
    }

    /**
     * @param numero_residencia the numero_residencia to set
     */
    public void setNumero_residencia(String numero_residencia) {
        this.numero_residencia = numero_residencia;
    }

    /**
     * @return the interior_residencia
     */
    public String getInterior_residencia() {
        return interior_residencia;
    }

    /**
     * @param interior_residencia the interior_residencia to set
     */
    public void setInterior_residencia(String interior_residencia) {
        this.interior_residencia = interior_residencia;
    }

    /**
     * @return the urbanizacion_residencia
     */
    public String getUrbanizacion_residencia() {
        return urbanizacion_residencia;
    }

    /**
     * @param urbanizacion_residencia the urbanizacion_residencia to set
     */
    public void setUrbanizacion_residencia(String urbanizacion_residencia) {
        this.urbanizacion_residencia = urbanizacion_residencia;
    }

    /**
     * @return the coddepartamento_laboral
     */
    public String getCoddepartamento_laboral() {
        return coddepartamento_laboral;
    }

    /**
     * @param coddepartamento_laboral the coddepartamento_laboral to set
     */
    public void setCoddepartamento_laboral(String coddepartamento_laboral) {
        this.coddepartamento_laboral = coddepartamento_laboral;
    }

    /**
     * @return the via_idc_laboral
     */
    public int getVia_idc_laboral() {
        return via_idc_laboral;
    }

    /**
     * @param via_idc_laboral the via_idc_laboral to set
     */
    public void setVia_idc_laboral(int via_idc_laboral) {
        this.via_idc_laboral = via_idc_laboral;
    }

    /**
     * @return the direccion_laboral
     */
    public String getDireccion_laboral() {
        return direccion_laboral;
    }

    /**
     * @param direccion_laboral the direccion_laboral to set
     */
    public void setDireccion_laboral(String direccion_laboral) {
        this.direccion_laboral = direccion_laboral;
    }

    /**
     * @return the numero_laboral
     */
    public String getNumero_laboral() {
        return numero_laboral;
    }

    /**
     * @param numero_laboral the numero_laboral to set
     */
    public void setNumero_laboral(String numero_laboral) {
        this.numero_laboral = numero_laboral;
    }

    /**
     * @return the interior_laboral
     */
    public String getInterior_laboral() {
        return interior_laboral;
    }

    /**
     * @param interior_laboral the interior_laboral to set
     */
    public void setInterior_laboral(String interior_laboral) {
        this.interior_laboral = interior_laboral;
    }

    /**
     * @return the urbanizacion_laboral
     */
    public String getUrbanizacion_laboral() {
        return urbanizacion_laboral;
    }

    /**
     * @param urbanizacion_laboral the urbanizacion_laboral to set
     */
    public void setUrbanizacion_laboral(String urbanizacion_laboral) {
        this.urbanizacion_laboral = urbanizacion_laboral;
    }

    /**
     * @return the profesion_idc_datolaboral
     */
    public int getProfesion_idc_datolaboral() {
        return profesion_idc_datolaboral;
    }

    /**
     * @param profesion_idc_datolaboral the profesion_idc_datolaboral to set
     */
    public void setProfesion_idc_datolaboral(int profesion_idc_datolaboral) {
        this.profesion_idc_datolaboral = profesion_idc_datolaboral;
    }

    /**
     * @return the nombreempresa_datolaboral
     */
    public String getNombreempresa_datolaboral() {
        return nombreempresa_datolaboral;
    }

    /**
     * @param nombreempresa_datolaboral the nombreempresa_datolaboral to set
     */
    public void setNombreempresa_datolaboral(String nombreempresa_datolaboral) {
        this.nombreempresa_datolaboral = nombreempresa_datolaboral;
    }

    /**
     * @return the rucempresa_datolaboral
     */
    public String getRucempresa_datolaboral() {
        return rucempresa_datolaboral;
    }

    /**
     * @param rucempresa_datolaboral the rucempresa_datolaboral to set
     */
    public void setRucempresa_datolaboral(String rucempresa_datolaboral) {
        this.rucempresa_datolaboral = rucempresa_datolaboral;
    }

    /**
     * @return the rubroempresa_datolaboral
     */
    public String getRubroempresa_datolaboral() {
        return rubroempresa_datolaboral;
    }

    /**
     * @param rubroempresa_datolaboral the rubroempresa_datolaboral to set
     */
    public void setRubroempresa_datolaboral(String rubroempresa_datolaboral) {
        this.rubroempresa_datolaboral = rubroempresa_datolaboral;
    }

    /**
     * @return the telefono_datolaboral
     */
    public String getTelefono_datolaboral() {
        return telefono_datolaboral;
    }

    /**
     * @param telefono_datolaboral the telefono_datolaboral to set
     */
    public void setTelefono_datolaboral(String telefono_datolaboral) {
        this.telefono_datolaboral = telefono_datolaboral;
    }

    /**
     * @return the cargo_datolaboral
     */
    public String getCargo_datolaboral() {
        return cargo_datolaboral;
    }

    /**
     * @param cargo_datolaboral the cargo_datolaboral to set
     */
    public void setCargo_datolaboral(String cargo_datolaboral) {
        this.cargo_datolaboral = cargo_datolaboral;
    }

    /**
     * @return the escuentaexterna
     */
    public boolean isEscuentaexterna() {
        return escuentaexterna;
    }

    /**
     * @param escuentaexterna the escuentaexterna to set
     */
    public void setEscuentaexterna(boolean escuentaexterna) {
        this.escuentaexterna = escuentaexterna;
    }

    /**
     * @return the banco_idc
     */
    public int getBanco_idc() {
        return banco_idc;
    }

    /**
     * @param banco_idc the banco_idc to set
     */
    public void setBanco_idc(int banco_idc) {
        this.banco_idc = banco_idc;
    }
        
}
