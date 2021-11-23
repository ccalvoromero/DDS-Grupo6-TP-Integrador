package com.utn.infraestructura.api.datos;

import com.utn.dominio.animal.Animal;
import com.utn.dominio.animal.Sexo;
import com.utn.dominio.animal.Tamaño;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class ControladorDatos {

    @GetMapping("datos/mascota/animal")
    public ResponseEntity<List<String>> obtenerTiposDeAnimales() {
        return ResponseEntity.status(200).body(Animal.getDescripciones());
    }
    @GetMapping("datos/mascota/sexo")
    public ResponseEntity<List<String>> obtenerTiposDeSexos() {
        return ResponseEntity.status(200).body(Sexo.getDescripciones());
    }
    @GetMapping("datos/mascota/tamanio")
    public ResponseEntity<List<String>> obtenerTiposDeTamaño() {
        return ResponseEntity.status(200).body(Tamaño.getDescripciones());
    }



}