package com.magic.datastructures;

public class MyLinkedList<K, V> {

    MyMapNode<K, V> head = null;
    MyMapNode<K, V> tail = null;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(MyMapNode<K, V> myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        else
        {
            tail.next = myNode;
        }
        this.tail = myNode;
    }

    public MyMapNode<K, V> search(K key) {
        MyMapNode<K, V> tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.key.equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    public void deleteFromLinkedList(K key) {
        if (head.key.equals(key)) {
            head = head.next;
        }
        MyMapNode<K, V> temp = head;
        if (tail.key.equals(key)) {
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
        } else {
            while (temp.next != null) {
                if (temp.next.key.equals(key)) {
                    MyMapNode<K, V> found = temp.next;
                    temp.next = found.next;
                }
                temp = temp.next;
            }
        }
    }


    public void printLinkedList() {
        MyMapNode<K, V> tempNode = this.head;
        while (tempNode!= null) {
            System.out.println(tempNode.key + " " + tempNode.value);
            tempNode = tempNode.next;
        }
    }


}
