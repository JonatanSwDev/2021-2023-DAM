package net.iescierva.jgg.musica.Data;

import net.iescierva.jgg.musica.Modelo.Cancion;

public interface RepositorioCanciones {
    Cancion get(int id); //Devuelve el elemento dado su id
    void ordenarLista(Boolean random);
    int size(); //Devuelve el número de elementos
    void update(int id, Cancion cancion); //Reemplaza un elemento
}
