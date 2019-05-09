package uy.edu.um.linkedlist;

public class ProblemaJosefo {

    public LinkedList juego(int m, CLinkedList<Object> colIntegrantes ) throws IlegalArgumentsException{
        LinkedList<Object> lista= new LinkedList();
        if(m> colIntegrantes.size()){
            throw new IlegalArgumentsException();
        }else{

            while(colIntegrantes.size()!=1){
                try {
                    lista.add(colIntegrantes.get(m));
                }catch (NodoNoExiste e){
                    e.printStackTrace();
                }
                try {
                    colIntegrantes.remove(m);
                }catch (NodoNoExiste e){
                    e.printStackTrace();
                }
                try {
                    colIntegrantes.setPrimero(colIntegrantes.getNodo(m));
                }catch (NodoNoExiste e){
                    e.printStackTrace();
                }
            }
        }
    return lista;
    }



    public static void main(String[] atgs){





    }
}
