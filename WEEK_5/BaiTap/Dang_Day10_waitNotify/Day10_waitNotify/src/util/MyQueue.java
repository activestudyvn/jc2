/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author 404NotFound
 */
public class MyQueue<E> {

    private final Object sync = new Object();
    private final int capacity;
    private Queue<E> queue = new LinkedList<>();

    public MyQueue() {
        this.capacity = 1024;
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
    }

    public void offer(E e) {
        synchronized (sync) {
            try {
                while (queue.size() == capacity) {
                    sync.wait();
                }
            } catch (InterruptedException ex) {
            }
            queue.offer(e);
            sync.notify();
        }
    }
    
    public E poll() {
        synchronized(sync){
            try {
                while (queue.size() == 0) {                    
                    sync.wait();
                }
            } catch (Exception e) {
            }
            E e = queue.poll();
            sync.notify();
            return e;
        }
    }
    
    public int size(){
        return queue.size();
    }
}
