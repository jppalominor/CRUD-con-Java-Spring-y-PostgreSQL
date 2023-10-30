package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "horario_cargadores")
public class HorarioCargadores {

    private int hora_id;
    private int cargador_id;
    private int autobus_id;

    

    public HorarioCargadores(int hora_id, int cargador_id, int autobus_id) {
        this.hora_id = hora_id;
        this.cargador_id = cargador_id;
        this.autobus_id = autobus_id;
    }
    public int getCargador_id() {
        return cargador_id;
    }
    public void setCargador_id(int cargador_id) {
        this.cargador_id = cargador_id;
    }
    
    public int getAutobus_id() {
        return autobus_id;
    }
    public void setAutobus_id(int autobus_id) {
        this.autobus_id = autobus_id;
    }
    public int getHora_id() {
        return hora_id;
    }
    public void setHora_id(int hora_id) {
        this.hora_id = hora_id;
    }
    

    
}
