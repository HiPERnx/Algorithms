//NB49
package Default;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Gustaf Nilstadius
 *         Created by Gustaf Nilstadius ( hipernx ) on 2015-03-05.
 */
public class NB49Main {
    private static int[] integers;
    private static int max = 1000, min = -1000;
    private static int inc = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of integers:");
        int n = s.nextInt(); s.close();
        if(n < 1){
            System.out.println("You're stupid.");
            System.exit(-1);
        }
        Random rand = new Random();
        integers = new int[n];
        for (int i = 0; i < n; i++) {

            integers[i] = (rand.nextInt((max - min) + 1) + min);
        }
        if(args.length > 0){
            System.out.println(Arrays.toString(integers));
        }

        System.out.println("" + maxSum(integers, 0, integers.length-1));
        System.out.println("Number of calls to maxSum: " + inc);

    }

    private static int maxSum(int[] a, int left, int right){
        inc++;
        if (left > right) return 0;
        if (left == right) return (0 > a[left]) ? 0:a[left];

        int center = (left+right)/2, sum = 0, maxLeft = 0, maxRight = 0;
        for (int i = center; i >= left ; i--) {
            sum+=a[i];
            maxLeft = (sum > maxLeft) ? sum:maxLeft;
        }
        sum = 0;
        for (int i = center+1; i <= right; i++) {
            sum+=a[i];
            maxRight = (sum > maxRight) ? sum:maxRight;
        }
        int maxCenter = maxLeft + maxRight;

        return Math.max(Math.max(maxCenter, maxSum(a, left, center)), maxSum(a, center+1, right));

    }
}
