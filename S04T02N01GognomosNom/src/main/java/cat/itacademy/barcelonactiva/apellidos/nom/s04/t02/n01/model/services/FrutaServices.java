package cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.repository.FrutaRepository;
import java.net.URI;
import static java.nio.file.Files.list;
import java.util.ArrayList;

import java.util.*;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FrutaServices {
    
    @Autowired
    private FrutaRepository frutaRepository;
   
     //html GET
    public ArrayList<Fruta> getAllFruta(){
    
    return (ArrayList<Fruta>)frutaRepository.findAll();//casteo

    }
   
    public Fruta mostrarFruta(long id) {
		return frutaRepository.findById(id).orElse(null);
	}
   
    //CREATE
    public Fruta saveFruta(Fruta fruta){
        
        return frutaRepository.save(fruta);
    }
    // retorna una fruta por su id
     public void getFrutaById(Long id) {
       frutaRepository.existsById(id);
    }
     
  /*  public void updateFruta(Fruta fruta, long id){
        
        list.stream().map(b->{
            if(b.getId()== id)
            {
                b.setNombre(getNombre);
            }
            return b;
        }).collect(Collectors.toList());
        
    }*/

 public void removeFrutaById(Long id) {
        
            frutaRepository.deleteById(id);
        
        }
    
}
