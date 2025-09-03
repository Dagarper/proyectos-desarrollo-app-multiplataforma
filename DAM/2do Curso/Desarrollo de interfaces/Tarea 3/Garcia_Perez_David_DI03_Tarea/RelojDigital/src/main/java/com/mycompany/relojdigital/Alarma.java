package com.mycompany.relojdigital;

import java.io.Serializable;
import java.util.Date;
import javax.swing.JLabel;

/**
 * La clase Alarma representa una alarma que contiene la hora de activación y un
 * estado que indica si la alarma está activada o desactivada. Esta clase
 * extiende de JLabel para poder ser utilizada en interfaces gráficas.
 */
public class Alarma extends JLabel implements Serializable {

    // Hora a la que debe sonar la alarma
    private Date horaAlarma;
    // Estado que indica si la alarma está activa o no
    private boolean activa = false;

    /**
     * Constructor que inicializa una nueva alarma con una hora y un estado de
     * activación.
     */
    public Alarma(Date horaAlarma, boolean activa) {
        this.horaAlarma = horaAlarma;
        this.activa = activa;

    }

    /**
     * Obtiene la hora de la alarma. Devuelve la hora a la que está configurada
     * la alarma.
     */
    public Date getHoraAlarma() {
        return horaAlarma;
    }

    /**
     * Establece la hora de la alarma.
     * @param horaAlarma La nueva hora a la que debe sonar la alarma.
     */
    public void setHoraAlarma(Date horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    /**
     * Obtiene el estado de la alarma, si está activa o desactivada. devuelve
     * true si la alarma está activa y false si está desactivada.
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Establece el estado de la alarma.
     * @param activa El nuevo estado de la alarma: true para activarla, false
     * para desactivarla.
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

}
