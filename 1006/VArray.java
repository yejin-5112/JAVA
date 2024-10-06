package OpenChallenge3;

public class VArray {
    private int[] array;
    private int size;

    public VArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == array.length) {
            expand();
        }
        array[size] = value;
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (size == array.length) {
            expand();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void expand() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}