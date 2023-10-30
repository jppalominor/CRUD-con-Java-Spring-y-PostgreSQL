package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table (name = "horario_autobuses")
public class HorarioAutobuses {

    private int autobus_id;
    private int hora_id;


    public int getAutobus_id(){
        return autobus_id;
    }

    public void setAutobus_id(int autobus_id){
        this.autobus_id = autobus_id;
    }

    public int getHora_id(){
        return hora_id;
    }

    public void setHora_id(int hora_id){
        this.hora_id = hora_id;
    }

    
    public HorarioAutobuses(){}

}