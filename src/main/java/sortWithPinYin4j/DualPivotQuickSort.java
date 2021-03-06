package sortWithPinYin4j;


import preprocess.IsSorted;
import preprocess.NameData;

import java.util.Random;

public class DualPivotQuickSort {

    static String[][] names;
    static int len;
    static Random random;
    public static void init(int len){
        String arr[][] = new NameData().getNamesArray();
        names = new String[len][2];
        if(len <= 1000000){
            for(int i = 0; i < len; i++){
                names[i][0] = arr[i][0];
                names[i][1] = arr[i][1];
            }
        }else{
            if(len == 2000000){
                for(int i = 0; i < 1000000; i++){
                    names[i][0] = arr[i][0];
                    names[i][1] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i][0] = arr[i - 1000000][0];
                    names[i][1] = arr[i - 1000000][1];
                }
            }else{
                for(int i = 0; i < 1000000; i++){
                    names[i][0] = arr[i][0];
                    names[i][1] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i][0] = arr[i - 1000000][0];
                    names[i][1] = arr[i - 1000000][1];
                }
                for(int i = 2000000; i < 4000000; i++){
                    names[i][0] = names[i - 2000000][0];
                    names[i][1] = names[i - 2000000][1];
                }
            }
        }
    }

    public static void sort(int len){
        init(len);
        sort(names);
    }

    public static void sort(Comparable[][] a) {
        //shuffle(a);
        sort(a, 0, a.length - 1);

    }

    public static void sort(int l, int r){
        sort(names, l, r - 1);
    }

    public static void sort(){
        sort(names,0, len - 1);
    }


    private static void sort(Comparable[][] a, int lo, int hi) {
        if (hi <= lo) return;
        if (less(a[hi][0], a[lo][0])) exch(a, lo, hi);
        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if       (less(a[i][0], a[lo][0])) exch(a, lt++, i++);
            else if  (less(a[hi][0], a[i][0])) exch(a, i, gt--);
            else                         i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);
        sort(a, lo, lt-1);
        if (less(a[lt][0], a[gt][0])) sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Object[][] a, int i, int j) {
        Object swap = a[i][0];
        a[i][0] = a[j][0];
        a[j][0] = swap;
        Object swap1 = a[i][1];
        a[i][1] = a[j][1];
        a[j][1] = swap1;
    }

    public static void shuffle(Object[][] a) {
        for(int i = 0;i < a.length;i++){
            int row = (int)(Math.random()*a.length);
            Object temp = a[i][0];
            a[i][0] = a[row][0];
            a[row][0] = temp;
            Object temp1 = a[i][1];
            a[i][1] = a[row][1];
            a[row][1] = temp1;

        }
    }



    public static void main(String[] args) {
        sort(1000000);
        for(int i = 0; i < 1000; i++){
            System.out.println(names[i][1]);
        }
    }
}
