
package modelo.dto;

import java.util.Date;

/* DSto = Dtaa Transfer Object */
public class ClienteConectadoDto  {
    /* Id del Cliente */
    private int id; 
    private int tdoc_idc; /* Tipo de Documento, si es DNI, RUC, etc DNI=60 segun tabla codigos*/
    private String numerodoc;  // DNI  
    private String razon;
    private String email;
    private Date ingreso;
    private String ip; //Dirección IP de Ingreso

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
     * @return the razon
     */
    public String getRazon() {
        return razon;
    }

    /**
     * @param razon the razon to set
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    public String getEmailPrivate(){
        String temporal="@";
        try{
            String[] cad = email.split("@");
            temporal = "*****@" + cad[1];
        }catch(Exception e){
            temporal="@";
        }
        return temporal;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ingreso
     */
    public Date getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
