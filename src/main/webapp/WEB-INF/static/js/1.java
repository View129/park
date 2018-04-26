public class Demo01 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int i = 0;
        System.out.println("随机生成10个数：");
        // 输入10个整数
        while (true) {
            //a[i] = sc.nextInt();
            a[i] = (int) (Math.random()*10 + 1);
            i++;
            if (i == 10) {
                break;
            }
        }
        System.out.println("生成的数组为:");
        for (Integer b : a) {
            System.out.print(b + "  ");
        }
         
        // 冒泡排序(降序) 
        System.out.println("\n冒泡排序(从大到小): ");
        for (int k = 0; k < a.length - 1; k++) { 
            for (int j = k + 1; j < a.length; j++) { //升序把<改成> 
                if (a[k] < a[j]) { int temp = a[k];
                    a[k] = a[j]; a[j] = temp; 
                } 
            } 
        }
         
        for (Integer b : a) {
            System.out.print(b + "  ");
        }
 
        /*
         // 快速排序 
         Arrays.sort(a);
         */
 
        /*// 选择排序
        for (i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }*/
         
        // 插入排序
        System.out.println("\n插入排序(从小到大):");
        for (i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else
                    break;
            }
        }
         
        // 输出排序后的数组
        for (Integer b : a) {
            System.out.print(b + "  ");
        }
    }
}