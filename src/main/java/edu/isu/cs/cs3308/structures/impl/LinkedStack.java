package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {

    //Here is my Singly linked Node, A doubly linked node is unnecessary for a stack
    public class Node<E> {
        private E element;
        private Node<E> next;

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getElement(){
            return element;
        }

        public Node(E e, Node<E> next){
            this.element = e;
            this.next = next;
        }
    }

    //stack only needs a size and a top node
    private int size;
    private Node<E> first;

    public LinkedStack(){
        first = null;
        size = 0;
    }
    //add an element to the top of the stack
    public void push(E element){
        if(element != null) {
            Node<E> old = first;
            first = new Node(element, old);
            size++;
        }
    }

    //look at the top element
    public E peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return first.getElement();
        }
    }

    //returns and deletes the top element from the stack
    public E pop(){
        if(isEmpty()){
            return null;
        }
        E value = first.getElement();
        first = first.next;
        size--;
        return value;
    }
    //returns the first node for testing purposes
    public Node<E> getFirst(){
        return first;
    }
    //returns the size of the stack
    public int size(){
        return size;
    }
    //checks if the stack is empty, if there is not top there is no stack or stack = null
    public boolean isEmpty(){
        if(first == null) {
            return true;
        }
        else{return false;}
    }
    //transfers from one stack to the provided stack and deletes the existing one
    public void transfer(Stack<E> to){
        if(to != null) {
            Node<E> current = first;
            while (current != null) {
                to.push(current.getElement());

                current = current.next;
                pop();
            }
        }
    }
    //reverses the order of the stack by going through the addToBot function
    public void reverse(){
        if(size > 0)
        {
            Node<E> top = first;
            pop();
            reverse();

            addToBot(top);

        }
    }
    //adds the top element to the bottom
    private void addToBot(Node<E> node){
        if(size == 0){
            push(node.getElement());
        }
        else{
            Node<E> top = first;
            pop();
            addToBot(top);
        }
    }
    //similar to transfer, but keeps both stacks intact
    public void merge(Stack<E> other){

        if(other != null){
            Stack<E> temp = other;
            temp.reverse();
            temp.transfer(this);


        }

    }

    //prints the contents of the stack
    public void printStack(){
        Node<E> current = first;
        while(current != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }
}