package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

public class RedBlueDoubleStackImpl<E> implements RedBlueDoubleStack<E>
{
    //singly linked node class
    public class Node<E>
    {
        private E element;
        private Node<E> next;

        public void setNext(Node<E> next)
        {
            this.next = next;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public E getElement()
        {
            return element;
        }

        public Node(E element, Node<E> next)
        {
            this.element = element;
            this.next = next;
        }
    }

    //there has to be a size for both red and blue
    //along with a first node for each as well
    private int redSize;
    private int blueSize;
    private Node<E> redFirst;
    private Node<E> blueFirst;

    //adds a new node to the front of red
    @Override
    public void pushRed(E element)
    {
        if(element != null)
        {
            Node<E> old = redFirst;
            redFirst = new Node(element, old);
            redSize++;
        }
    }
    //adds a new node to the front of blue
    @Override
    public void pushBlue(E element)
    {
        if(element != null)
        {
            Node<E> old = blueFirst;
            blueFirst = new Node(element, old);
            blueSize++;
        }
    }
    //removes the first node of red
    @Override
    public E popRed()
    {
        if(isRedEmpty()){
            return null;
        }
        E value = redFirst.getElement();
        redFirst = redFirst.next;
        redSize--;
        return value;
    }
    //removes the first node of blue
    @Override
    public E popBlue()
    {
        if(isBlueEmpty()){
            return null;
        }
        E value = blueFirst.getElement();
        blueFirst = blueFirst.next;
        blueSize--;
        return value;
    }
    //looks at the first node of red
    @Override
    public E peekRed()
    {
        if(isRedEmpty()){
            return null;
        }
        else{
            return redFirst.getElement();
        }
    }
    //looks at the first node of blue
    @Override
    public E peekBlue()
    {
        if(isBlueEmpty()){
            return null;
        }
        else{
            return blueFirst.getElement();
        }
    }
    //returns size of red
    @Override
    public int sizeRed()
    {
        return redSize;
    }
    //returns size of blue
    @Override
    public int sizeBlue()
    {
        return blueSize;
    }
    //checks if red is empty
    @Override
    public boolean isRedEmpty()
    {
        if(sizeRed() > 0)
        {
            return false;
        }
        return true;
    }
    //returns true if blue is empty
    @Override
    public boolean isBlueEmpty()
    {
        if(sizeBlue() > 0)
        {
            return false;
        }
        return true;
    }

}
