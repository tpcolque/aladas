package ar.com.ada.api.aladas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.repos.AeropuertoRepository;

@Service
public class AeropuertoService {
    
    @Autowired
    private AeropuertoRepository repo; //Declaro el repo

    //para crear el aeropuerto le tengo que pasar el aeropuertoID porque no esta como autoincremental
    public void crear(Integer aeropuertoID, String nombre, String codigoIATA){

        Aeropuerto aeropuerto = new Aeropuerto(); //Declaro e instancio
        aeropuerto.setAeropuertoID(aeropuertoID);
        aeropuerto.setNombre(nombre);
        aeropuerto.setCodigoIATA(codigoIATA);
        repo.save(aeropuerto); //aca lo salvo en el repo lo que acabo de setear arriba

    }
    public List<Aeropuerto> obtenerTodos(){

        return repo.findAll(); // aca busca a todos a traves del metodo y lo guarda en el repo
        
    }
}
