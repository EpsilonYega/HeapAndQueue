import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        Heap heap = new Heap(100);
//        heap.insertNode(14);
//        heap.insertNode(61);
//        heap.insertNode(85);
//        heap.insertNode(24);
//        heap.insertNode(74);
//        heap.insertNode(26);
//        heap.insertNode(17);
//        heap.insertNode(50);
//        heap.insertNode(40);
//        heap.insertNode(45);
//        heap.insertNode(21);
//        heap.insertNode(32);
//        heap.insertNode(59);
//        heap.insertNode(58);
//        heap.insertNode(13);
//        heap.printHeap();

        Queue<String> testStringsPQ = new PriorityQueue<>();
        testStringsPQ.add("a$$");
        testStringsPQ.add("8081");
        testStringsPQ.add("kh32");
        testStringsPQ.add("zxc");
        testStringsPQ.add("/ato");
        while (!testStringsPQ.isEmpty()) {
            System.out.println(testStringsPQ.poll());
        }
    }
}