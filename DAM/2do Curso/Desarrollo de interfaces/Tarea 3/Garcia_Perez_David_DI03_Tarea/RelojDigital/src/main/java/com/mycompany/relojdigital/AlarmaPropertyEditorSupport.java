
package com.mycompany.relojdigital;

import java.beans.PropertyEditorSupport;
import java.util.Date;


public class AlarmaPropertyEditorSupport extends PropertyEditorSupport {

    private PanelAlarma panel = new PanelAlarma();
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
    
    @Override
    public java.awt.Component getCustomEditor() {
        return panel;
    }
    
    @Override
    public String getJavaInitializationString() {
        Date horaAlarma = panel.obtenerDatosAlarma().getHoraAlarma();
        boolean activa = panel.obtenerDatosAlarma().isActiva();
        return "new com.mycompany.relojdigital.Alarma(new java.util.Date("+ horaAlarma.getTime() +"l),"+ activa+")";
    }
    
    @Override
    public Object getValue() {
        return panel.obtenerDatosAlarma();
    }
}
