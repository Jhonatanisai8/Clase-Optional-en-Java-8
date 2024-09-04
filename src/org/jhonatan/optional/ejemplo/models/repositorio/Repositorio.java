/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.jhonatan.optional.ejemplo.models.repositorio;

import java.util.Optional;
import org.jhonatan.optional.ejemplo.models.Computador;

/**
 *
 * @author User
 */
public interface Repositorio<T> {

    Optional<Computador> filtrar(String nombre);
}
