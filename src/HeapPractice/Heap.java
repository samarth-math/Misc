package HeapPractice;


import CustomDataStructures.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {

    List<Integer> heap = new ArrayList<Integer>();
    public static void main(String[] args){
        Integer[] arr = new Integer[]{ 10, 12, 15, 3, 7, 5 };
        Heap heap = new Heap(arr);
        heap.maxHeapify(0);
    }
    public Heap(Integer[] arr) {
        Collections.addAll(this.heap, arr);
    }

    public void Heap(Integer ...arr) {
        Collections.addAll(this.heap, arr);
    }
    public Integer getCurrent(int i) {
        if (heap.size()>i)
        return heap.get(i);
        else
            return null;
    }
    public Integer getParent( int i) {
        return heap.get((i- 1)/2);
    }
    public Pair<Integer, Integer> getLChild(int i) {
        int index = i*2 + 1;
        if (heap.size()>index)
        return Pair.of(index, heap.get(index));
        else
            return null;
    }
    public Pair<Integer, Integer> getRChild(int i) {
        int index = i*2 + 2;
        if (heap.size()>index)
            return Pair.of(index, heap.get(index));
        else
        return null;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void maxHeapify(int root) {
        if (getLChild(root) != null) {
            maxHeapify(getLChild(root).fst);
        }
        if (getLChild(root) != null) {
            maxHeapify(getRChild(root).fst);
        }
        if (getRChild(root) == null && getLChild(root) == null) {
            return;
        }
        if (getRChild(root) == null) {
            if (getCurrent(root) < getLChild(root).snd){
                swap(root, getLChild(root).fst);
            }
        }
        if (getLChild(root) == null) {
            if (getCurrent(root) < getRChild(root).snd){
                swap(root, getRChild(root).fst);
            }
        } else {
            Pair<Integer,Integer> largerElement;
            largerElement = getLChild(root).snd>getRChild(root).snd?getLChild(root):getRChild(root);
            if (getCurrent(root) < largerElement.snd){
                swap(root, largerElement.fst);
            }
        }
    }
}
