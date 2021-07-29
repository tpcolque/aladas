package ar.com.ada.api.aladas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.response.GenericReponse;
import ar.com.ada.api.aladas.services.AeropuertoService;

@RestController
public class AeropuertoController {

    @Autowired
    AeropuertoService service;

    @PostMapping("/api/aeropuertos")
    public ResponseEntity<GenericReponse> crear(@RequestBody Aeropuerto aeropuerto){

        GenericReponse respuesta = new GenericReponse();

        service.crear(aeropuerto.getAeropuertoID(), aeropuerto.getNombre(), aeropuerto.getCodigoIATA());
        respuesta.isOk = true;
        respuesta.message = "Se creo correctamente";
        respuesta.id = aeropuerto.getAeropuertoID();

        return ResponseEntity.ok(respuesta);
        
    }
    
}
