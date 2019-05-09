package uy.edu.um.linkedlist;

public class ListNode {
    private int item;
    private ListNode next=null;

    public ListNode(int item){
        this.item=item;
    }

    public ListNode getNext(){

        return this.next;
    }
    public void setNext(ListNode nodo){
        this.next=nodo;
    }

    public int getItem(){
        return this.item;
    }

    public void setItem(int item){
        this.item=item;
    }
}
