package edu.um.prog2.Stack;

import edu.um.prog2.Stack.Exeptions.EmptyStackException;

public interface MyStack<T> {
    public void pop() throws EmptyStackException;

    public T top() throws EmptyStackException;

    public void push(T value);

    public boolean isEmpty();

    public void makeEmpty();
}