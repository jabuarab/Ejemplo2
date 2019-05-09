package edu.um.prog2.tad.linkedlist;

import edu.um.prog2.tad.Exeptions.ValueAintExistExeption;

public interface MyList<T> {
    void agregar(T value);

    void borrar(T value) throws ValueAintExistExeption;

    void borrar(int i);

    T obtener(int i);
}
