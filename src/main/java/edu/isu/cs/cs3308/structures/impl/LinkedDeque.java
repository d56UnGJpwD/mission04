package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;
public class LinkedDeque<E> implements Deque<E>
{

    //doubly linked node class
    public class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public void setNext(Node<E> next){
            this.next = next;
        }

        public void setPrev(Node<E> prev){ this.prev = prev;}

        public Node<E> getNext(){
            return next;
        }

        public Node<E> getPrev(){ return prev; }

        public E getElement(){
            return element;
        }

        public Node(E e, Node<E> previous, Node<E> next){
            this.element = e;
            this.prev = previous;
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    //this is essentially a doubly linked list
    public LinkedDeque(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    //returns the first node
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    //transfers from one queue into the provided queue and does empty the source queue
    public void transfer(Queue<E> into)
    {
        if(into != null)
        {
            reverse();
            while(!this.isEmpty())
            {
                into.offer(this.poll());
            }
        }

    }
    //merges both queues but does not empty the source queue
    public void merge(Queue<E> from)
    {
        if(from == null)
        {
        }
        else
        {
            LinkedDeque<E> temp = new LinkedDeque<>();
            while(!from.isEmpty())
            {
                E val = from.poll();
                offer(val);
                temp.offer(val);

            }
            while(!temp.isEmpty())
            {
                E val = temp.poll();
                from.offer(val);
            }

        }
    }

    //view the last element in the deque
    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    //add to the front
    public void offerFirst(E element){
        addBetween(element, header, header.getNext());
    }
    //add to the last
    public void offer(E element){
        addBetween(element, trailer.getPrev(), trailer);
    }
    //remove the first node
    public E poll(){
        if(isEmpty()){
            return null;
        }
        return remove(0);
    }
    //remove the last node
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        return remove(size -1);
    }
    //helper function that handles all adding
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        if(e != null){
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            size++;
        }
    }

    //my remove helper function
    public E remove(int index){
        if(index >= 0 && index < size){
            Node<E> removed = getNode(index);
            Node<E> predecessor = removed.getPrev();
            Node<E> successor = removed.getNext();

            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            return removed.getElement();
        }
        return null;
    }
    //uses a stack to reverse a queue
    public void reverse()
    {
        Stack<E> stack = new LinkedStack<>();
        while(!this.isEmpty())
        {
            stack.push(this.poll());
        }
        while(!stack.isEmpty())
        {
            offer(stack.pop());
        }

    }
    //my node searcher function
    private Node<E> getNode(int index){
        if(index >= 0 && index < size){
            Node<E> current = header;
            int i = 0;

            while(current != null){
                if(i == index){
                    return current.next;
                }
                i++;
                current = current.next;
            }
        }
        return null;
    }
    //size of the deque
    public int size(){
        return size;
    }
    //empty checker
    public boolean isEmpty(){
        return size == 0;
    }
    //prints contents of queue
    public void printQueue(){
        Node<E> current = header.next;
        while(current.next != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }



}
