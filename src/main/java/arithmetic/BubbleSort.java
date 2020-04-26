package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/6 0006.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b ;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a+b);
    }
    private int getRandom(){
        int s = (int)Math.random()*100;
        return s;
    }
}
