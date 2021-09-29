package casodeuso.dueño;

import dominio.Personas;
import dominio.persona.Persona;

import dominio.animal.Sexo;
import dominio.animal.Animal;
import dominio.animal.Tamaño;
import dominio.animal.Mascota;

import java.util.List;
import java.util.Map;

public class RegistrarMascota {

    private final Personas personas;

    public RegistrarMascota(Personas personas) {
        this.personas = personas;
    }

    public void ejecutar(
        int documentoDueño, int idMascota, String nombre, Animal tipoAnimal, String apodo, int edad, Sexo sexo,
        Tamaño tamaño, String descripcionFisica, List<String> fotos, Map<String, String> caracteristicas){
            Mascota mascota = new Mascota(idMascota, nombre, tipoAnimal, apodo, edad, sexo, tamaño, descripcionFisica, fotos, caracteristicas);
            Persona persona = personas.obtenerPorNumeroDocumento(documentoDueño);
            persona.añadirMascota(mascota);
            personas.guardar(persona);
    }

}