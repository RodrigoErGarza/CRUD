/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author alumno
 */
public class Departamento {
    
    private int id_departamento;
    private String IT;
    private String Contabilidad;
    private String RRHH;
    private String Marketing;
    private String Produccion;

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getIT() {
        return IT;
    }

    public void setIT(String IT) {
        this.IT = IT;
    }

    public String getContabilidad() {
        return Contabilidad;
    }

    public void setContabilidad(String Contabilidad) {
        this.Contabilidad = Contabilidad;
    }

    public String getRRHH() {
        return RRHH;
    }

    public void setRRHH(String RRHH) {
        this.RRHH = RRHH;
    }

    public String getMarketing() {
        return Marketing;
    }

    public void setMarketing(String Marketing) {
        this.Marketing = Marketing;
    }

    public String getProduccion() {
        return Produccion;
    }

    public void setProduccion(String Produccion) {
        this.Produccion = Produccion;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id_departamento=" + id_departamento + ", IT=" + IT + ", Contabilidad=" + Contabilidad + ", RRHH=" + RRHH + ", Marketing=" + Marketing + ", Produccion=" + Produccion + '}';
    }
    
    
    
}
