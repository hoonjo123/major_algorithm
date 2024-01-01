import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,7};
        int n = arr.length;


        //최초 힙구성 : n/2번만큼 heapify를 수행
        for(int i= (n/2) -1 ; i>=0; i--){
            heapify(arr,n,i);
        }

        //최대힙을 이용한 정렬
        //root = 최댓값이 보장되어있음.
        //맨 끝자리와 첫번째 자리를 체인지한다.(마지막 자리가 점차 한개씩 줄어드는 형식)
        //하향식으로 체인지
        //주의해야할 점 : 마지막까지 체크하지 않도록

        //최초 힙구성 이후에 0번째(루트노드)와 마지막번째 노드를 체인지시켜보기 =>
        //0번째부터 heapify -> 마지막번째(n-1), 0번째 change : 마지막 번째는 지속적으로 변화함
        //다시 0번째부터 heapify -> 다시 자리 change

        for(int i =n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //0번째와 마지막자리 자리 체인지
            heapify(arr,i,0);

        }
        System.out.println(Arrays.toString(arr));
    }
    //최소힙을 이용하여 정렬하기
//    [1, 3, 5, 5, 6, 7, 7, 8, 9]




    //최대힙 구하기 //[9, 8, 7, 7, 3, 5, 5, 1, 6]
    static void heapify(int[] arr,int n,int root){//root는 변화하는자리
        //xx조건의 경우에 change로직 : left와 right 비교해서 자리 change
        //&&로
        int largest = root;
        int left = 2*root+1;
        int right = 2*root+2;
        //if(change가 발생하면) {
        if(left < n && arr[left] < arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] < arr[largest]) {
            largest = right;
        }

        if(largest != root){
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);//change가 발생한 부모index int i); //몇 번째 자리에서 heapify 할건지?
        }
    }



    //최소힙 구하기  [1, 3, 5, 6, 7, 5, 9, 8, 7]
//static void heapify(int[] arr,int n,int root){//root는 변화하는자리
//    //xx조건의 경우에 change로직 : left와 right 비교해서 자리 change
//    //&&로
//    int largest = root;
//    int left = 2*root+1;
//    int right = 2*root+2;
//    //if(change가 발생하면) {
//    if(left < n && arr[left] < arr[largest]) {
//        largest = left;
//    }
//
//    if(right < n && arr[right] < arr[largest]) {
//        largest = right;
//    }
//
//    if(largest != root){
//        int temp = arr[root];
//        arr[root] = arr[largest];
//        arr[largest] = temp;
//
//        heapify(arr, n, largest);//change가 발생한 부모index int i); //몇 번째 자리에서 heapify 할건지?
//        }
//    }

    //0,1,2,3,4 가 있음
    //dfs 순서를 출력해보자
    //2차원배열
    //0,1   {0,1,1,0,0}
    //0,2   {1,0,0,1,0}
    //1,0   {1,0,0,1,1}
    //1,3   {0,1,1,0,0}
    //2,0   {0,0,1,0,0}
    //2,3
    //2.4
    //3,1
    //3,2
    //4,2
}
