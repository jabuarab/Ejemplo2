package uy.edu.um.Queue;

public interface MyQueue<T> {

    public void enqueue(T element);

    public T dequeue() throws EmptyQueueException;

    public boolean isEmpty();

    public T getFirst() throws EmptyQueueException;

}
