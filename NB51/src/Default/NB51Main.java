//NB51
package Default;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Gustaf Nilstadius
 *         Created by Gustaf Nilstadius ( hipernx ) on 2015-03-05.
 */
public class NB51Main {
    private static int[] values;
    public static void main(String[] args) {
        int currencies;
        int sum;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Number of Currencies:");
        currencies = s.nextInt(); s.nextLine();
        values = new int[currencies];
        for (int i = 0; i < currencies; i++) {
            System.out.print("Enter value nr" + (i + 1) + " :");
            values[i] = s.nextInt(); s.nextLine();
        }
        System.out.print("Enter value to be exchenged:");
        sum = s.nextInt(); s.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        System.out.println("" + exchange(sum, sb));
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static int exchange(int sum, StringBuilder sb){
        for (int i = 0; i < values.length; i++) {
            if(values[i] == sum) {
                sb.append(","+ values[i]);
                return 1;

            }
        }
        int v = sum;
        StringBuilder nextSB;
        StringBuilder saveSB = null;
        for (int i = 1; i <= sum/2; i++) {
            nextSB = new StringBuilder();
            int x = (exchange(i, nextSB) + exchange(sum-i, nextSB));
            //v = (v < x) ? v : x;
            if(v > x){
                v = x;
                saveSB = nextSB;
            }
        }
        sb.append(saveSB);
        return v;
    }
}
