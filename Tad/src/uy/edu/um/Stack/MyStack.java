package uy.edu.um.Stack;

public interface MyStack <T> {

   public T pop() throws EmptyStackException;

    public T top() throws EmptyStackException;

    public void push(T element);

    public boolean isEmpty();

    public void makeEmpty();

}
