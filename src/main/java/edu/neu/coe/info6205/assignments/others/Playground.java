package edu.neu.coe.info6205.assignments.others;

import java.util.Arrays;

public class Playground {

    public static void merge(int[] a, int[] aux, int l, int m, int r){
        for(int i = l; i <= r; i++){
            aux[i] = a[i];
        }
        int i = l, j = m + 1;
        for(int p = l; p <= r; p++){
            if(i > m){
                a[p] = aux[j++];
            }else if(j > r){
                a[p] = aux[i++];
            }else if(aux[j] < aux[i]){
                a[p] = aux[j++];
            }else{
                a[p] = aux[i++];
            }
        }
    }

    public static void sort(int[] a){
        int[] aux = new int[a.length];
        int n = a.length;
        for(int len = 1; len < n; len *= 2){
            for(int lo = 0; lo < n - len; lo += len * 2){
                int mid = lo + len - 1;
                int hi = Math.min(n - 1, lo + 2 * len - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    public static int partition(int[] a, int l, int r){
        int i = l, j = r + 1, v = a[l];
        while(true){
            while (a[++i] < v){
                if(i == r){
                    break;
                }
            }
            while(a[--j] > v){

                if(j == l){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    public static void quick(int[] a, int l, int r){
        if(l >= r){
            return;
        }
        int j =partition(a, l, r);
        quick(a, l, j - 1);
        quick(a, j + 1, r);
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(1 << 21);
    }
}
