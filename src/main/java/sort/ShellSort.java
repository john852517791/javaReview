package sort;

public class ShellSort {
    public static void main(String[] args) {
        /**
         * 设置一个增量d【一般为n/2】
         *
         *相隔为d的数为一组
         *
         * */
        int[] a = {22,3, 1, 5, 3, 6, 9, 8, 6, 4, 2};
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println("排序后");
        int[] b = shellSort(a);

        for (int i=0;i<b.length;i++){
            System.out.println(a[i]);
        }


    }

    public static int[] shellSort(int[] a){
        int d,i,j,temp;
        int n=a.length;

//        将a[0]当作暂存位
        for (d=n/2;d>=1;d=d/2){
            for (i=d+1;i<n;i++){
                if (a[i]<a[i-d]){
                    temp=a[i];
                    for (j=i-d;j>0 && temp<a[j];j-=d){
                        a[j+d]=a[j];
                    }
                    a[j+d]=temp;
                }
            }
        }

        return a;
    }

}
