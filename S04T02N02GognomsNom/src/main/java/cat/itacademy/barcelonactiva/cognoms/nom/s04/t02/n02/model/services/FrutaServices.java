/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.repository.FrutaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
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
