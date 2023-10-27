package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "autobuses")
public class Autobuses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String placa;
    private int modelo;
    

    public Autobuses(int id, String placa, int modelo) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
