import java.util.Arrays;
import java.util.Collection;

class Main<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public Main() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public Main(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public void add(E element) {
        ensureCapacity();
        array[size++] = element;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else
        return (E) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    // Метод добавляет все элементы из другой коллекции
    public void addAll(Collection<? extends E> collection) {
        ensureCapacity(size + collection.size());
        for (E element : collection) {
            array[size++] = element; // цикл вставляет в новые созданные индексы элементы из другой коллекции
        }
    }

    public void bubbleSort() {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if ((int) array[i] > (int) array[i + 1]) {
                    Object temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }


    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}

