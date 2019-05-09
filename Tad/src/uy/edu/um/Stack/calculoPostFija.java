package uy.edu.um.Stack;

import java.util.Scanner;

public class calculoPostFija {

    public static void calcular(String operacion) throws EmptyStackException {
        String[] parts=operacion.split(" ");
        Stack<Integer> pila=new Stack();
        int aux1=0;
        int aux2=0;
        int aux3=0;
        for(int i=0; i<parts.length; i++){
            if(parts[i].equals("+") || parts[i].equals("-") || parts[i].equals("*") || parts[i].equals("/")){
                if(parts[i].equals("+")){
                    try {
                        aux1=pila.pop();
                        aux2=pila.pop();
                        aux3=aux1+aux2;
                        pila.push(aux3);
                    } catch (EmptyStackException emptyStackException) {
                        emptyStackException.printStackTrace();
                    }

                }
                if(parts[i].equals("-")){
                    try {
                        aux1=pila.pop();
                        aux2=pila.pop();
                        aux3=aux1-aux2;
                        pila.push(aux3);
                    } catch (EmptyStackException emptyStackException) {
                        emptyStackException.printStackTrace();
                    }

                }
                if(parts[i].equals("*")){
                    try {
                        aux1=pila.pop();
                        aux2=pila.pop();
                        aux3=aux1*aux2;
                        pila.push(aux3);
                    } catch (EmptyStackException emptyStackException) {
                        emptyStackException.printStackTrace();
                    }

                }
                if(parts[i].equals("/")){
                    try {
                        aux1=pila.pop();
                        aux2=pila.pop();
                        aux3=aux1/aux2;
                        pila.push(aux3);
                    } catch (EmptyStackException emptyStackException) {
                        emptyStackException.printStackTrace();
                    }

                }
            }else{
                pila.push(Integer.parseInt(parts[i]));
              System.out.println();
            }

        }

     System.out.println("Resultado: " + pila.pop());
    }
public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        String sig="si";
        while(sc.equals("no")==false) {
            System.out.println("introduzca una operacion con sus elementos separados por un espacio");
            String operacion = sc.nextLine();
            //String operacion="1 2 + 4 *";
            try {
                calcular(operacion);
            } catch (EmptyStackException e) {
                e.printStackTrace();
            }
            System.out.println("desea realizar otra operacion?(si/no)");
            sig=sc.nextLine();
        }

}
}
