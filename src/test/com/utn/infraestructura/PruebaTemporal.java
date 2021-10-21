package com.utn.infraestructura;

import com.utn.dominio.Personas;
import com.utn.dominio.Voluntarios;
import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Mascota;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;
import com.utn.dominio.autenticacion.Usuario;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;
import com.utn.dominio.organizacion.Organizacion;
import com.utn.dominio.organizacion.Voluntario;
import com.utn.dominio.persona.Contacto;
import com.utn.dominio.persona.Direccion;
import com.utn.dominio.persona.Documento;
import com.utn.dominio.persona.Persona;
import com.utn.dominio.publicacion.Preferencia;
import com.utn.dominio.publicacion.PublicacionBusquedaAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEnAdopcion;
import com.utn.dominio.publicacion.PublicacionMascotaEncontrada;
import com.utn.infraestructura.persistencia.PersonasEnMySQL;
import com.utn.infraestructura.persistencia.VoluntariosEnMySQL;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class PruebaTemporal {

    private Voluntarios voluntarios = new VoluntariosEnMySQL();
    private Personas personas = new PersonasEnMySQL();

    //@BeforeEach
    //void inicializar() { voluntarios = }

    @Test
    public void se_rescata_voluntario_con_sus_usuarios() {
        //Voluntario voluntario = voluntarios.obtenerPorNumeroDNI(5488759);
        Voluntario voluntario = voluntarios.obtenerPorNombreUsuario("pepe");
        System.out.println(" Mi usuario es: " + voluntario.getUsuario().nombreUsuario() + " y contraseña: " + voluntario.getUsuario().getContraseña());
    }

    @Test
    public void se_persiste_voluntario_en_db(){
        Organizacion organizacion = new Organizacion("nombre", new Direccion(3,3), TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Usuario usuario = new Usuario("pepe", "hola1234");
        Voluntario voluntario = new Voluntario(usuario, organizacion);

        organizacion.añadirVoluntario(voluntario);

        voluntarios.guardar(voluntario);
    }

    @Test
    public void se_rescata_persona_de_db(){
        Persona persona = personas.obtenerPorNumeroDocumento(38554127);

        System.out.println("Hola");

    }

    @Test
    public void se_persiste_persona_en_db(){
        Contacto contactoTest = new Contacto("Eduardo","Bavutti","+54 9 11 8755-7845","ebavutti@gmail.com");
        LocalDate nacimientoTest = LocalDate.of(1990,04,27);
        Documento documentoTest = new Documento("DNI", 38554127);
        Direccion domicilioTest = new Direccion(1742.38,2394.2);
        Contacto otroContactoTest = new Contacto("Isabela", "Ferriera", "+54 9 11 7855-4121", "iferriera@gmail.com");
        Usuario usuarioTest = new Usuario("edubavutti", "1990isaedu");

        Direccion domicilioOrgTest = new Direccion(5447.358, 5648.74);
        Usuario usuarioVolTest = new Usuario("volOrg", "324ae41gg");
        Organizacion organizacionTest = new Organizacion("PatitasJugetonas", domicilioOrgTest, TamañoFoto.GRANDE, CalidadFoto.BAJA);
        Voluntario voluntarioTest = new Voluntario(usuarioVolTest, organizacionTest);
        organizacionTest.agregarPreguntaAdopcion("Tu animal tiene vacunas?");
        organizacionTest.agregarPreguntaAdopcion("Tu animal es jugeton?");
        organizacionTest.añadirVoluntario(voluntarioTest);
        Mascota mascotaTest = new Mascota("Solange", "Sol", 5, Animal.PERRO, Sexo.HEMBRA, Tamaño.GRANDE,
                "Soy muy linda y tierna");

        mascotaTest.añadirFoto("foto1.png");
        mascotaTest.añadirFoto("foto2.png");
        mascotaTest.añadirCaracteristica("Vacuna","Si");
        mascotaTest.añadirCaracteristica("Parasitos","No");

        Mascota otraMascotaTest = new Mascota("Pepa", "Pepita", 1, Animal.GATO, Sexo.HEMBRA,Tamaño.CHICO,
                "Me gusta jugar con lana");

        otraMascotaTest.añadirFoto("foto1.jpg");
        otraMascotaTest.añadirFoto("foto2.jpg");
        otraMascotaTest.añadirCaracteristica("Parasitos","No");
        otraMascotaTest.añadirCaracteristica("Garras","Si");
        otraMascotaTest.añadirCaracteristica("Perdida de Pelo","No");

        usuarioTest.añadirOrganizacion(organizacionTest);
        Persona personaTest = new Persona(contactoTest, nacimientoTest, documentoTest, domicilioTest, otroContactoTest, usuarioTest, 32);
        organizacionTest.añadirPersona(personaTest);
        personaTest.añadirMascota(mascotaTest);
        personaTest.añadirMascota(otraMascotaTest);

        organizacionTest.añadirPublicacionBusquedaAdopcion(new PublicacionBusquedaAdopcion(personaTest, personaTest.getPreferencia(), new ArrayList<String>(){{add("Hola"); add("Adios");}}));
        organizacionTest.añadirPublicacionMascotaEnAdopcion(new PublicacionMascotaEnAdopcion(personaTest,mascotaTest, new ArrayList<String>(){{add("Debe ser");add("Por dogshow");}}));
        organizacionTest.añadirPublicacionMascotaEncontrada(new PublicacionMascotaEncontrada(personaTest,new Direccion(20,23),"Todo okey"));

        organizacionTest.añadirCaracteristica("Perrito gordito");
        organizacionTest.agregarPreguntaAdopcion("Cuanto pesa??");
        organizacionTest.agregarPreguntaQuieroAdoptar("Tiene patio??");
        personaTest.setPreferencia(new Preferencia(Sexo.HEMBRA,Animal.PERRO,Tamaño.CHICO));

        personas.guardar(personaTest);
    }
}