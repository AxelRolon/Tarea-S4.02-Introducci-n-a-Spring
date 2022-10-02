/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PC
 */
public interface FrutaRepository extends JpaRepository<Fruta, Long> {
    
}
