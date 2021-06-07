package com.magic.datastructures;

import java.util.ArrayList;

public class MyHashTable<K, V> {
    public int bucketSize;
    ArrayList<MyLinkedList<K, V>> bucket;

    public MyHashTable() {
        bucketSize = 10;
        this.bucket = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            this.bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashcode = Math.abs(key.hashCode());
        return hashcode % bucketSize;

    }

    public void put(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.bucket.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            bucket.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);

        } else
            myMapNode.setValue(value);
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.bucket.get(index);
        if (myLinkedList == null)
            return null;
        MyMapNode<K, V> myMapNode = myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void remove(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.bucket.get(index);
        if (myLinkedList == null)
            System.out.println("Key not Found");
        else
            myLinkedList.deleteFromLinkedList(key);
    }

    public void print() {
        for (int i = 0; i < bucketSize; i++) {
            MyLinkedList<K, V> myLinkedList = this.bucket.get(i);
            if (myLinkedList != null) {
                myLinkedList.printLinkedList();
            }
        }
    }

}
