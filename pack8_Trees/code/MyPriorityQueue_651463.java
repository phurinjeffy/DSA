package code;

public class MyPriorityQueue_651463 implements MyQueueInterface {
    MyMinHeap heap = new MyMinHeap();

    @Override
    public void enqueue(int d) {
        if (!isFull())
            heap.insert(d);
    }

    @Override
    public int dequeue() {
        if (!isEmpty())
            return heap.remove();
        return -1;
    }

    @Override
    public int front() {
        if (!isEmpty())
            return heap.peek();
        return -1;
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public String toString() {
        return heap.toString();
    }
}
