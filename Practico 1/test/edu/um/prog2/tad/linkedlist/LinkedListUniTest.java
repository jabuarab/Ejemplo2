package edu.um.prog2.tad.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListUniTest {


    @Test
    void testagregar() {
        LinkedListUni<Integer> pepe = new LinkedListUni<>();
        pepe.agregar(4);
        System.out.println(pepe.getLength());

        Integer p= pepe.obtener(0);
        System.out.println(p);
        if(  p!=4 || pepe.getLength()!=1){
            fail();
            
        }



    }

    @Test
    void testborrar() {
    }

    @Test
    void testborrar1() {
        LinkedListUni<Integer> pepe = new LinkedListUni<>();
        pepe.agregar(2);
        pepe.agregar(3);
        pepe.borrar(0);
        if(pepe.getLength()!=1 || pepe.obtener(0)!=3 ){
            fail();
        }
        pepe.agregar(4);
        pepe.agregar(5);
        pepe.borrar(1);
        if(pepe.getLength()!=1 || pepe.obtener(0)!=3 || pepe.obtener(1)!=5){
            fail();
        }
        pepe.borrar(0);
        pepe.borrar(0);

    }

    @Test
    void testobtener() {
        LinkedListUni<Integer> pepe = new LinkedListUni<>();
        pepe.agregar(4);
        pepe.agregar(1);
        pepe.agregar(7);
        int a= pepe.obtener(2);
        if(a!=7){
            fail();
        }

    }

    @Test
    void testcontiene() {
        LinkedListUni<Integer> pepe = new LinkedListUni<>();
        pepe.agregar(4);
        if(!pepe.contiene(4)){
            fail();
        }


    }

    @Test
    void testaddFirst() {
    }
}


    if(raiz!= null){
        queue.raiz
            }
    while(!queue.isEmpty){
        aux=queuedeque;
            auxQueue.enqueue(aux);
    if(aux.hasleft()){
        queue.enqueue(aux.getleft())
            }

            if(aux.hasRigth()){
            queue.enqueue(aux.getRigth())
            }
            }