public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public void printHeap() {
        System.out.println("Массив значений: ");

        for (int n = 0; n < currentSize; n++) {
            if (heapArray[n] != null) {
                System.out.println(heapArray[n].getValue() + " ");
            }
            else {
                System.out.println("-");
            }
        }
        System.out.println();

        int countOfGaps = 32;
        int itemsPerRow = 1;
        int columnNumber = 0;
        String lines = "___________________________________________________________________";
        System.out.println(lines);
        for (int i = 0; i < currentSize; i++) {
            if (columnNumber == 0) {
                for (int k = 0; k < countOfGaps; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[i].getValue());

            if (++columnNumber == itemsPerRow) {
                countOfGaps /= 2;
                itemsPerRow *= 2;
                columnNumber = 0;
                System.out.println();
            }
            else {
                for (int k = 0; k < countOfGaps * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + lines);
    }

    public boolean insertNode(int value) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(value);
        heapArray[currentSize] = newNode;
        displaceUp(currentSize++);
        return true;
    }

    public Node removeNode(int index) {
        if(index > 0 && currentSize > index) {
            Node root = heapArray[index];
            heapArray[index] = heapArray[--currentSize];
            heapArray[currentSize] = null;
            displaceDown(index);
            return root;
        }
        return null;
    }

    public boolean changeNode(int index, int newValue) {
        if (index < 0 || currentSize<=index) {
            return false;
        }
        int oldValue = heapArray[index].getValue();
        heapArray[index].setValue(newValue);

        if (oldValue < newValue) {
            displaceUp(index);
        }
        else {
            displaceDown(index);
        }
        return true;
    }

    private void displaceUp(int index) {
        int parentIndex = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parentIndex].getValue() < bottom.getValue()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    private void displaceDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getValue() < heapArray[rightChild].getValue()) {
                largerChild = rightChild;
            }
            else {
                largerChild = leftChild;
            }

            if (top.getValue() >= heapArray[largerChild].getValue()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
}
