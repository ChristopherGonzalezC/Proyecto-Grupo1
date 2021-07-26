/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dao;

import java.util.List;

/**
 *
 * @author kriz_
 */
public interface DAO <T,K>{
    
    void insertar(T a) throws DAOException;
    void modificar(T a) throws DAOException;
    void eliminar(K a) throws DAOException;
    List<T> obtenerTodos() throws DAOException;
    List<T> obtenerLista(K a) throws DAOException;
    T obtener(K id) throws DAOException;
}
