package utils;

import linkedList.Node;

public class Swap {
    public static void swap(int[] arr,int a,int b){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

    public  static void swap(Node[] nodeArr,int a,int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
}
