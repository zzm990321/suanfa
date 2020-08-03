package basic.array.createarray;

import java.util.Arrays;

public class Array<E>{
    private E[] data;
    private int size;

    //构造函数
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数 默认容量10
    public Array(){
        this(10);
    }

    //返回容量
    public int getCapacity(){
        return data.length;
    }

    //返回元素个数
    public int getSize(){
        return size;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size,e);
    }
    public void addFirst(E  e){
        add(0,e);
    }

    //指定位置添加元素
    public void add(int index ,E e){
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed Array is full");
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed ");
        }
        for(int i = size - 1;i>index;i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index){
        if(index <0||index >=size){
            throw new IllegalArgumentException("Get failed");
        }
        return data[index];
    }
    public void set(int index,E e){
        if(index <0||index >=size){
            throw new IllegalArgumentException("Set failed");
        }
        data[index] = e;
    }

    public boolean contains (E e){
        for(int i=0;i<size;i++) {
            if (data[i] == e) {
                return true;
            }
        }
            return false;
        }

    public int find(E e){
        for(int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index <0||index >= size){
            throw new IllegalArgumentException("remove failed");
        }
        E ret = data[index];
        for(int i= index +1;i<size;i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",size, data.length));
        res.append('[');
        for(int i=0; i<size;i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
            res.append(']');
            return res.toString();
        }

        public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0 ; i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
        }

    public E getLast() {
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }
}


