package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;
public class LinkedDeque<E> implements Deque<E>
{

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

    public LinkedDeque(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }


    public E peek(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }

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

    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void offerFirst(E element){
        addBetween(element, header, header.getNext());
    }

    public void offer(E element){
        addBetween(element, trailer.getPrev(), trailer);
    }

    public E poll(){
        if(isEmpty()){
            return null;
        }
        return remove(0);
    }

    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        return remove(size -1);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        if(e != null){
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            size++;
        }
    }


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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printQueue(){
        Node<E> current = header.next;
        while(current.next != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }



}
