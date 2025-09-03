package com.mycompany.relojdigital;

import java.util.EventListener;


public interface AlarmaListener extends EventListener {
    
    void onAlarmaActivada(String mensaje);
    
    
}
