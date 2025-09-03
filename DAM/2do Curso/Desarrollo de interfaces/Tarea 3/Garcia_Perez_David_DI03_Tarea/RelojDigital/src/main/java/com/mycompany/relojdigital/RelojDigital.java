package com.mycompany.relojdigital;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase representa un reloj digital con funcionalidades de alarma.
 * El reloj puede mostrar la hora en formato de 12 o 24 horas, y la alarma
 * se activa en un horario específico. Cuando se activa la alarma, se muestra
 * un mensaje en una ventana emergente.
 */
public class RelojDigital extends JPanel implements ActionListener, Serializable {

    private boolean formato; // Variable para almacenar el formato de hora: false = 24 horas, true = 12 horas
    // Variables para almacenar la hora y minuto de la alarma
    private int horaAlarma;
    private int minutoAlarma;
    
    // Mensaje de la alarma que se mostrará al activarse
    private String mensajeAlarma = "¡Alarma activada!";
    // Objeto que representa la alarma
    private Alarma alarma;
    
    // Variable para almacenar la hora actual
    private LocalTime tiempo = LocalTime.now();

    // Formatos de hora para 12 y 24 horas
    private final DateTimeFormatter formato12Horas = DateTimeFormatter.ofPattern("hh:mm:ss a");
    private final DateTimeFormatter formato24Horas = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    // Temporizador para actualizar la hora cada segundo
    private final Timer temporizador;

    // Lista de oyentes que recibirán notificaciones cuando la alarma se active
    private final List<AlarmaListener> alarmaListeners = new ArrayList<>();

    
    /**
     * Constructor que inicializa el temporizador para actualizar la hora
     * cada segundo y configura la alarma como inactiva.
     */
    public RelojDigital() {
        temporizador = new Timer(1000, this);
        temporizador.start();

        // Inicializamos la alarma como inactiva
        alarma = new Alarma(null, false);
        
    }

    //Métodos getter y setter:
    
    public Alarma getAlarma() {
        return alarma;
    }

    /**
     * Establece el objeto de la alarma. Si la alarma no es nula y tiene una hora de alarma
     * configurada, se extraen la hora y los minutos de esa alarma.
     *
     * @param alarma El objeto Alarma a configurar.
     */
    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;

        if (alarma != null && alarma.getHoraAlarma() != null) {
            this.horaAlarma = alarma.getHoraAlarma().getHours();
            this.minutoAlarma = alarma.getHoraAlarma().getMinutes();
        }
    }

    
    public boolean isFormato() {
        return formato;
    }

    /**
     * Establece el formato de la hora. Si el formato es true, se usará el formato de 12 horas,
     * y si es false, se usará el formato de 24 horas.
     *
     * @param formato El formato a establecer.
     */
    public void setFormato(boolean formato) {
        this.formato = formato;
        repaint();
    }

    public int getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(int horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public int getMinutoAlarma() {
        return minutoAlarma;
    }

    public void setMinutoAlarma(int minutoAlarma) {
        this.minutoAlarma = minutoAlarma;
    }

    public String getMensajeAlarma() {
        return mensajeAlarma;
    }

    public void setMensajeAlarma(String mensajeAlarma) {
        this.mensajeAlarma = mensajeAlarma;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }


     /**
     * Método que se ejecuta cuando la alarma se activa. Notifica a todos los oyentes
     * y muestra un mensaje emergente con el mensaje de la alarma.
     */
    private void fireAlarmaActivada() {
        // Notifica a todos los oyentes de la alarma
        for (AlarmaListener listener : alarmaListeners) {
            listener.onAlarmaActivada(mensajeAlarma);
        }
        // Muestra un mensaje emergente con el mensaje de la alarma
        javax.swing.SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, mensajeAlarma, "Alarma Activada", JOptionPane.WARNING_MESSAGE);
        });
        alarma.setActiva(false); // Desactiva la alarma tras activarse
         // Repinta el panel para reflejar el cambio
        repaint();
    }

    /**
 * Método que se llama para pintar el componente (reloj) en el panel.
 * 
 * Este método es responsable de pintar el reloj en el panel cada vez que se repinta.
 * Dependiendo de la configuración del formato (12 o 24 horas), se selecciona el formato de hora
 * adecuado. Luego, se dibuja la hora directamente en el panel en el centro de la pantalla.
 * 
 * @param g El objeto Graphics utilizado para pintar el componente en el panel.
 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la clase base para asegurarse de que se repinten las capas superiores

        g.setFont(new Font("Arial", Font.BOLD, 40));// Establece la fuente a Arial, negrita, con un tamaño de 40 puntos
        g.setColor(Color.RED);// Establece el color del texto a rojo
        FontMetrics metrics = g.getFontMetrics();// Obtiene las métricas de la fuente para calcular el tamaño del texto
        String horaTexto = formato ? tiempo.format(formato12Horas) : tiempo.format(formato24Horas); // Obtiene la hora en el formato adecuado (12 o 24 horas)
        int anchoTexto = metrics.stringWidth(horaTexto);// Calcula el ancho del texto
        int altoTexto = metrics.getAscent();// Calcula la altura del texto
        int x = (getWidth() - anchoTexto) / 2; // Calcula la posición X para centrar el texto horizontalmente
        int y = (getHeight() + altoTexto) / 2; // Calcula la posición Y para centrar el texto verticalmente
        g.drawString(horaTexto, x, y);// Dibuja el texto de la hora en el panel en las coordenadas calculadas
        
    }

    /**
     * Método que se ejecuta cada segundo para actualizar la hora y verificar si la alarma debe activarse.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualiza la hora cada segundo
        tiempo = LocalTime.now();
        
        repaint();// Repinta el panel con la nueva hora

        // Si la alarma está activada, verifica si la hora actual coincide con la hora de la alarma
        if (alarma != null && alarma.isActiva()) {
            LocalTime alarmaTime = LocalTime.of(horaAlarma, minutoAlarma);
            //verifica si la hora actual está dentro del intervalo de 1 segundo antes y 59 segundos después de la hora de la alarma. 
            //Si la condición se cumple, se activa la alarma.
            if (tiempo.isAfter(alarmaTime.minusSeconds(1)) && tiempo.isBefore(alarmaTime.plusSeconds(59))) {
                fireAlarmaActivada();
            }
        }
    }
}