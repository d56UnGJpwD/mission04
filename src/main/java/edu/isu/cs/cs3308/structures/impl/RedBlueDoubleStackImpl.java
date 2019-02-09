package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

public class RedBlueDoubleStackImpl<E> implements RedBlueDoubleStack<E>
{

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

    private int redSize;
    private int blueSize;
    private Node<E> redFirst;
    private Node<E> blueFirst;


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

    @Override
    public int sizeRed()
    {
        return redSize;
    }

    @Override
    public int sizeBlue()
    {
        return blueSize;
    }

    @Override
    public boolean isRedEmpty()
    {
        if(sizeRed() > 0)
        {
            return false;
        }
        return true;
    }

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
