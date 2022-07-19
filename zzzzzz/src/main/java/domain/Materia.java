/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Josué Daniel Marroquín Hernández <jmarroquin-2020296@kinal.edu.gt>
 * @date 09-nov-2021
 * @time 12:11:14
 * Codigo Tecnico: IN5BV
 * Carnet: 2020296
 */
public class Materia {
    
    private int idMateria;
    private String nombreMateria;
    private Date cicloEscolar;
    private Time horarioInicio;
    private Time horarioFinal;
    private String catedratico;
    private String salon;
    private int cupoMaximo;
    private int cupoMinimo;

    public Materia() {
    }

    public Materia(int idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(String nombreMateria, Date cicloEscolar, Time horarioInicio, Time horarioFinal, String catedratico, String salon, int cupoMaximo, int cupoMinimo) {
        this.nombreMateria = nombreMateria;
        this.cicloEscolar = cicloEscolar;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.catedratico = catedratico;
        this.salon = salon;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
    }

    public Materia(int idMateria, String nombreMateria, Date cicloEscolar, Time horarioInicio, Time horarioFinal, String catedratico, String salon, int cupoMaximo, int cupoMinimo) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.cicloEscolar = cicloEscolar;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.catedratico = catedratico;
        this.salon = salon;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Date getCicloEscolar() {
        return cicloEscolar;
    }

    public void setCicloEscolar(Date cicloEscolar) {
        this.cicloEscolar = cicloEscolar;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + ", cicloEscolar=" + cicloEscolar + ", horarioInicio=" + horarioInicio + ", horarioFinal=" + horarioFinal + ", catedratico=" + catedratico + ", salon=" + salon + ", cupoMaximo=" + cupoMaximo + ", cupoMinimo=" + cupoMinimo + '}';
    }

    
    
}
