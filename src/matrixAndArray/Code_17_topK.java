package matrixAndArray;



/**
 * 有N个长度不一的数组，所有的数组都是有序的
 * ，请从大到小打印这N个数组整体最大的前K个数
 */
public class Code_17_topK {

public class HeapNode {
    public int value;//值
    public int arrNum;//来自那个数组
    public int index;//数组的哪个位置

    public HeapNode(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}

public void printTopK(int[][] matrix,int topK){
    int heapSize = matrix.length;
    HeapNode[] heap = new HeapNode[heapSize];
    for (int i = 0; i != heapSize; i++) {
        int index = matrix[i].length - 1;
        heap[i] = new HeapNode(matrix[i][index],i,index);
        heapInsert(heap,i);
    }
    System.out.println("TOP"+topK+":");
    for (int i = 0; i != topK; i++) {
        if(heapSize == 0){
            break;
        }
        System.out.println(heap[0].value + " ");
        if(heap[0].index != 0 ){
            heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
        }else{
            swap(heap,0,--heapSize);
        }
        heapify(heap,0,heapSize);
    }
}

    private void heapInsert(HeapNode[] heap, int index) {
        while(index != 0){
            int parent = (index - 1) / 2;
            if(heap[parent].value < heap[index].value){
                swap(heap,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }

    private void heapify(HeapNode[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while(left < heapSize){
            if(heap[left].value>heap[index].value){
                largest = left;
            }
            if(right < heapSize && heap[right].value > heap[largest].value){
                largest = right;
            }
            if(largest != index){
                swap(heap, largest,index);
            }else{
                 break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }

    }

    private void swap(HeapNode[] heap, int index1, int index2) {
        HeapNode tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }
}