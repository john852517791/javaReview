package sort;

import sun.security.util.Length;

public class InsertionSort {
    public static void main(String[] args) {

        /**
         * 思想————默认0~i-1的序列都排好序了，将i的数字插入到前面的序列中
         * 1、判断前一位是否大于a[i]
         * 2、判断前面有几位大于a[i]，则后移他们
         * 3、插入原a[i]值到，某个位置
         *
         *
         * 空间复杂度O(1)
         * 平均时间复杂度O(n^2)
         * 稳定
         * */

        int[] a = new int[]{3,9,1,3,1,4,5,2};
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

//        System.out.println("排序后");
//
//        int[] b = insertionSort(a);
//        for (int i=0;i<b.length;i++){
//            System.out.println(b[i]);
//        }
        System.out.println("排序后");

        int[] c = insertionSort2(a);
        for (int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }


    public static int[] insertionSort(int[] a){
        int i,j,temp;
        for (i=1;i<a.length;i++){
            if (a[i]<a[i-1]){
                temp=a[i];
                for (j=i-1;j>=0&&a[j]>temp;j--){
                    a[j+1]=a[j];
                }
                a[j+1]=temp;
            }
        }
        return a;
    }

    public static int[] insertionSort2(int[] a){
        int i,j,temp;
        for (i=1;i<a.length;i++){
            if (a[i]<a[i-1]){
                temp=a[i];
                for (j=i-1;j>=0;j--){
                    if (a[j]>temp)
                        a[j+1]=a[j];

                    else break;//注意

                }
                a[j+1]=temp;
            }
        }
        return a;
    }


}
