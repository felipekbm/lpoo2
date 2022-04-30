/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Juiz;

/**
 *
 * @author User
 */
public interface IJuizDAO extends IDAO<Juiz> {
    

    public java.util.List<Juiz> buscaPorNome(String nome);
}
