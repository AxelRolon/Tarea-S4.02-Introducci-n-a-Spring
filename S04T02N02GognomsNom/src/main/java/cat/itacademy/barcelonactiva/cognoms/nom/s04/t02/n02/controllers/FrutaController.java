/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.model.services.FrutaServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/fruta")
public class FrutaController {
    //CRUD CREADOS CON RESPUESTAS DE CODIGO HTTP , GRACIAS A RESPONSEENTITY
    @Autowired
    FrutaServices frutaService;
    
   //GET
@GetMapping("/getALL")
@ResponseStatus(HttpStatus.OK)
public List<Fruta> getAllFruta(){
    // Map<String, Object> response = new HashMap<>();
    return frutaService.getAllFruta();
    // return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
     
}
    
    //Post crear nueva fruta , @RequestBody
    @PostMapping("/add")
     public ResponseEntity<?> addFruta(@RequestBody Fruta fruta){
        
         Map<String, Object> response = new HashMap<>();
         try {
             frutaService.saveFruta(fruta);
             response.put("Mensaje", "Se guardo con exito la fruta : ");

        } catch (DataAccessException e) {
          response.put("Mensaje", "Ocurrio un error al agregar la fruta");
          response.put("Error:", e.getMostSpecificCause().getMessage());
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        
        } 
     return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
     
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateFruta(@RequestBody Fruta fruta){
         Map<String, Object> response = new HashMap<>();
         try {
             frutaService.saveFruta(fruta);
             response.put("Mensaje", "Se actualizo correctamente".concat(fruta.getNombre()));
        } catch (DataAccessException e) {
                    response.put("Error", "No Se actualizo correctamente la fruta : ".concat(fruta.getNombre()));
         
                  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);//El servidor procesó correctamente la solicitud, pero no devuelve ningún contenido

        }
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            
            }

    //get frutiña by idesiño jeje
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFrutaById(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();// msg y codigo de error <m,c>
        
        if(!frutaService.getAllFruta().isEmpty()){
        try {
        frutaService.getFrutaById(id);
        Fruta fruta = frutaService.mostrarFruta(id);            
        
        response.put("Se encontro la fruta indicada por id de nombre = ", fruta.getNombre());
                    
        } catch (DataAccessException e) {
          response.put("Mensaje", "Ocurrio un error al buscar fruta con id".concat(id.toString()));
          response.put("Error:", e.getMostSpecificCause().getMessage());
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        
        } 
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }else{
            System.out.println("Base de datos vacia");
        }return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //Delete fruta por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFrutaById(@PathVariable Long id){
        
        Map<String, Object> response = new HashMap<>();// msg y codigo de error <m,c>
        try {
          frutaService.removeFrutaById(id);
                    response.put("Mensaje", "Se elimino la Fruta con id".concat(id.toString()));

        } catch (DataAccessException e) {
          response.put("Mensaje", "Ocurrio un error al eliminar la fruta con id".concat(id.toString()));
          response.put("Error:", e.getMostSpecificCause().getMessage());
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        
        } 
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
}

