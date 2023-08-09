package net.iescierva.dam22_06.mislugaresjavar.datos;

import net.iescierva.dam22_06.mislugaresjavar.modelo.Lugar;

public interface RepositorioLugares {
    Lugar get_element(int id); //Devuelve el elemento dado su id
    void add(Lugar lugar); //Añade el elemento indicado
    int add_blank(); //Añade un elemento en blanco y devuelve su id
    void delete(int id); //Elimina el elemento con el id indicado
    int size(); //Devuelve el número de elementos
    void update_element(int id, Lugar lugar); //Reemplaza un elemento
}