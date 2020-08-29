import javafx.beans.binding.ObjectExpression;

import java.util.*;

/**
 * 构建一个 MyArrayList 让该类实现 List 接口，然后重写里面的大部分方法
 */
public class MyArrayList<T> implements List{

    private int size;
    private Object[] data;
    private static final int CAPACITY = 20;

    public MyArrayList() {
        this.data = new Object[CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        for (int i = 0; i < size; i++) {
            res[i] = data[i];
        }
        return res;
    }

    @Override
    public boolean add(Object o) {
        if (o == null)
            return false;

        if (size == data.length)
            resize((int) 1.5*data.length);
        data[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;

        int res = indexOf(o);
        if (res != -1) {
            for (int i = size - 1; i >= res; i--) {
                data[i] = data[i-1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            return false;

        for (Object elem : data) {
            if (elem.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index Error");
        }
        Object pre = data[index];
        data[index] = element;
        return pre;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index Error");
        }
        if (size == data.length) {
            resize((int)1.5*data.length);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index Error");
        }
        Object pre = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        return pre;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null)
            return -1;

        for (int i = 0; i < size; i++) {
            if (data[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (toIndex > fromIndex)
            throw new IllegalArgumentException("Require toIndex >= fromIndex");
        fromIndex = fromIndex < 0 ? 0 : fromIndex;
        toIndex = toIndex > size ? size : toIndex;
        Object[] res = new Object[toIndex - fromIndex];
        int count = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            res[count++] = data[i];
        }
        return null;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i<size;i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList list = (MyArrayList) o;
        return size == list.size &&
                Arrays.equals(data, list.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    /**
     * 以下方法均为未进行重写的
     * @return
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public T[] toArray(Object[] a) {
        return null;
    }
}



