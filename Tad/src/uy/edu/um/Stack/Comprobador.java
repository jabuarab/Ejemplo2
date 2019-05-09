package uy.edu.um.Stack;

import java.util.Scanner;

public class Comprobador {

    public static void comprobar(String texto) throws DesbalanceException{
        String[] parts= texto.split("");
        Stack<String> pila= new Stack();
        String aux=null;
        for(int i=0; i<parts.length;i++){
            if(parts[i].equals("(") || parts[i].equals("[") || parts[i].equals("{") ){
                pila.push(parts[i]);
            }
            if(parts[i].equals(")")) {
                try {
                    aux = pila.pop();
                } catch (EmptyStackException e) {
                    e.printStackTrace();
                }
                if (aux.equals("(") == false) {
                    throw new DesbalanceException();
                }
            }
                if(parts[i].equals("]")) {
                    try {
                        aux = pila.pop();
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
                    if (aux.equals("[") == false) {
                        throw new DesbalanceException();
                    }
                }
                if(parts[i].equals("}")) {
                    try {
                        aux = pila.pop();
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
                    if (aux.equals("{") == false) {
                        throw new DesbalanceException();
                    }
                }
            }
        if(pila.isEmpty()==false){
            throw new DesbalanceException();
        }else{
            System.out.println("codigo correcto");
        }
        }

        public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca codigo a comprobar");
       // String codigo=sc.nextLine();
        String codigo="(hfkdsahkhdsk) {dfhdskljf [dhfs;khfd]";
        try{
        comprobar(codigo);
        }catch (DesbalanceException e){
        e.printStackTrace();}
        }

    }



