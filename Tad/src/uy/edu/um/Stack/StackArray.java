package uy.edu.um.Stack;

import static java.util.Arrays.copyOf;

public class StackArray<T> implements MyStack<T> {

private  T[] array= (T[])new Object[10];
private int size=0;

    public T pop() throws EmptyStackException {
        T result=null;
        if(this.size==0){
            throw new EmptyStackException();
        }
        else {
            result=this.array[this.size-1];
            this.array[this.size-1] = null;
            this.size=this.size-1;
        }
        return result;
    }

    public T top() throws EmptyStackException {
        if(this.size==0){
            throw new EmptyStackException();
        }
        else{
            return (T) this.array[this.size-1];
        }
    }
    public int get(){

            return this.array.length;
        }




    public void push(T element){

    if(this.array.length==this.size){
        T[] array2=copyOf(this. array,this.array.length*2 );

      this.array=array2;

    }
        if (this.size==0){
            this.array[0]=element;
            this.size=this.size+1;
        }
        else{
            this.array[this.size]=element;
            this.size=this.size+1;
        }
    }

    public boolean isEmpty(){
        boolean verif=true;
        if(this.size>0){
            verif=false;
        }
        return verif;
    }
    public void makeEmpty(){
        for(int i=0; i<this.size; i++){
            this.array[i]=null;
        }
        this.size=0;
    }
public static void main(String[] args){
        StackArray<Integer> stack= new StackArray<Integer>();
        int p=0;
        for(int i=0; i<1000;i++) {
            stack.push(i);
        }
        try {
            p = (int) stack.top();
        }
        catch (EmptyStackException e) {
            e.printStackTrace();
        }


        System.out.println(p);
        System.out.println(stack.get());
}

}
