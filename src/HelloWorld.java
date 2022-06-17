import Heaps.Heap;

public class HelloWorld {
    public static void main(String[] args){
    Integer[] arr = new Integer[]{ 10, 12, 15, 3, 7, 5 };
    Heap heap = new Heap(arr);
    heap.maxHeapify(0);
    }
}
