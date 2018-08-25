package com.example.dataStructure.array;

public class MyArray {
    private  long [] array;
    private  int elems;

    public MyArray(){
        array=new long[50];
    }
    public MyArray(int size){
        array=new long[size];
    }

    public long[] insert(long value){
        array[elems]=value;
        elems++;
        return array;
    }

    public void display(){
        for (long arr:array){
            System.out.println(arr);
        }
    }

}
