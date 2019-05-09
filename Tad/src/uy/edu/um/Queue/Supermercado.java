package uy.edu.um.Queue;

import uy.edu.um.prog2.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
public class Supermercado {


public static void inicializarColas(LinkedList<Queue> lista, int cantidad){
    for(int i=0;i<cantidad;i++){
        lista.add(new Queue<Integer>());
    }
}

public static void iniciarTE(int[] lista){
    for(int i=0; i< lista.length; i++){
        lista[i]=0;
    }
}

public static void estadoActual(LinkedList<Queue> lista, int[] tEspera){
    for(int i=0; i< tEspera.length;i++){
        System.out.println("fila "+(i+1)+" cantidad de clientes: "+ lista.get(i+1).size()+" tiempo de espera: "+tEspera[i]);
    }
}
 public static long getTiempoE(int fila, Long[] lista){
    return lista[fila];

 }

public static int cajaVacia(int[] lista){
    boolean verif=false;
    int i=0;
    while (i<lista.length && verif==false){
        if(lista[i]==0){
            verif=true;
        }
        i=i+1;
    }
    if(verif==false){
        i=-1;
    }
    return i;
}
public static int agregarCliente(int cantProductos, int[] tEspera, LinkedList<Queue> lista){
    int result=0;
    int aux=cajaVacia(tEspera);
    if(aux!=-1){
        lista.get(aux).enqueue(cantProductos);
        tEspera[aux-1]= cantProductos*5;
        result=aux;
    }else{
        int aux1=tEspera[0];
        int temp=0;
        for(int i=0;i< tEspera.length; i++){
          if(aux1>=tEspera[i]){
              temp=i+1;
          }
            aux1=tEspera[i];
        }
        lista.get(temp).enqueue(cantProductos);
        tEspera[temp-1]=tEspera[temp-1]+ (cantProductos*5);
        result=temp;
    }
    return result;
}




public static void liberarCliente(int fila, LinkedList<Queue> lista){
    try {
        lista.get(fila).dequeue();
    }catch (EmptyQueueException e){
        e.printStackTrace();

    }
}
public static void actualizarTE(int[] tEspera){
    for(int i=0; i<tEspera.length; i++){
        if(tEspera[i]>0){
            tEspera[i]= tEspera[i]-5;
        }
    }
}



    public static void main(String[] args){
LinkedList<Queue> lista= new LinkedList();
Scanner sc= new Scanner(System.in);
System.out.println("ingrese el numero de cajas");
int cajas=sc.nextInt();
int[] tEspera= new int[cajas];
iniciarTE(tEspera);
inicializarColas(lista, cajas);
        Timer timer1=new Timer();
        TimerTask task1=new TimerTask(){
            public void run(){
                System.out.println(" ");
                estadoActual(lista,tEspera);
            }
        };
        timer1.scheduleAtFixedRate(task1, 0,30000);
String aux="si";
Scanner sc1=new Scanner(System.in);

Timer timer2= new Timer();
TimerTask task2= new TimerTask(){
    public void run(){
        actualizarTE(tEspera);

    }
};

timer2.schedule(task2, 0, 5000);

while(aux.equals("si")){
    Timer timer=new Timer();
    System.out.println("ingrese cantidad de productos");
    int cant=sc.nextInt();
   int lugar=agregarCliente(cant, tEspera, lista);
    TimerTask task= new TimerTask(){
        public void run() {
            liberarCliente(lugar, lista);
        }
    };
    timer.schedule(task, tEspera[lugar-1]+(cant*5000));
        System.out.println("desea agregar otro cliente? (si/no)");
        aux=sc1.nextLine();
        }
  /*      int cant1=30;
        int cant2=35;
        int cant3=37;
        int cant4=34;
        agregarCliente(cant1, tEspera, lista);
        agregarCliente(cant2, tEspera, lista);
        agregarCliente(cant3, tEspera, lista);
        agregarCliente(cant4, tEspera, lista);
*/

    }
}
