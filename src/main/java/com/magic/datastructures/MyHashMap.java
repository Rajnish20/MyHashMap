package com.magic.datastructures;

import java.util.Locale;

public class MyHashMap<K, V> {
    MyLinkedList<K, V> myLinkedList;

    public MyHashMap() {
        this.myLinkedList = new MyLinkedList<>();
    }

    public V get(K key) {
        MyMapNode<K, V> myMapNode = this.myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void put(K key, V value) {
        MyMapNode<K, V> myMapNode = this.myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            this.myLinkedList.append(myMapNode);
        } else {
            System.out.println("found");
            myMapNode.setValue(value);
        }
    }
    public void print()
    {
        myLinkedList.printLinkedList();
    }
}
