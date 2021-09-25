package edu.neu.coe.info6205.assignments.others;

public class MergeSortTrain {

    public static void main(String[] args){
        int n = 10;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random()*100);
            System.out.print(arr[i] +" ");
        }
        msort(arr, 0, n - 1, new int[n]);
        System.out.println(" ");
        for(int num : arr){
            System.out.print(num +" ");
        }

    }

    public static void msort(int[] arr, int l, int r, int[] temp){
        if(l < r){
            int m = l +  (r - l)/2;
            msort(arr, l, m, temp);
            msort(arr, m + 1, r, temp);
            merge(arr, l, r, m, temp);
        }
    }

    public static void merge(int[] arr, int l, int r, int m, int[] temp){
        int i = l, j = m + 1;
        int p = 0;
        while(i <= m && j <= r){
            if(arr[i] < arr[j]){
                temp[p++] = arr[i++];
            }else{
                temp[p++] = arr[j++];
            }
        }
        while(i <= m){
            temp[p++] = arr[i++];
        }
        while(j <= r){
            temp[p++] = arr[j++];
        }
        p = 0;
        while(l <= r){
            arr[l++] = temp[p++];
        }
    }


    public static void binary_sort(){
        
    }

}
