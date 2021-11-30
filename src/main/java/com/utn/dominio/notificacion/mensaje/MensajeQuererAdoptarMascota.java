package com.utn.dominio.notificacion.mensaje;

import com.utn.dominio.persona.Persona;

public class MensajeQuererAdoptarMascota extends Mensaje {

    public MensajeQuererAdoptarMascota(Persona personaAdoptante, String nombreMascota) {
        super("Hola, soy " + personaAdoptante.nombre() + ". Vi a tu mascota " + nombreMascota + " en la plataforma. " +
            "Mi número es " + personaAdoptante.telefono() + " y mi email es " + personaAdoptante.email(),
            "[Importante] Rescate de Patitas");
    }

}