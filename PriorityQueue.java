import java.util.*;

class PriorityQueue {
    private List<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(int x) {
        heap.add(x);
        bubbleUp(heap.size() - 1);
    }

    public int getMin() {
        if (heap.isEmpty())
            return Integer.MAX_VALUE;
        return heap.get(0);
    }

    public int delMin() {
        if (heap.isEmpty())
            return Integer.MAX_VALUE;

        int minValue = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastValue);
            bubbleDown(0);
        }
        return minValue;
    }

    private void bubbleUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(parent) > heap.get(index)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void bubbleDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest))
            smallest = leftChild;
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest))
            smallest = rightChild;

        if (smallest != index) {
            swap(smallest, index);
            bubbleDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class PriorityQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        PriorityQueue priorityQueue = new PriorityQueue();
        for (int i = 0; i < T; i++) {
            String[] operation = scanner.nextLine().split(" ");

            if (operation[0].equals("insert")) {
                int x = Integer.parseInt(operation[1]);
                priorityQueue.insert(x);
            } else if (operation[0].equals("delMin")) {
                priorityQueue.delMin();
            } else if (operation[0].equals("getMin")) {
                int minValue = priorityQueue.getMin();
                if (minValue == Integer.MAX_VALUE)
                    System.out.println("Empty");
                else
                    System.out.println(minValue);
            }
        }
        scanner.close();
    }
}