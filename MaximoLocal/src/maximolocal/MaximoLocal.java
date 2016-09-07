/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximolocal;

import java.util.Arrays;

/**
 *
 * @author Anuar
 */
public class MaximoLocal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int input = 10;

        boolean[] bits = new boolean[7];
        for (int i = 6; i >= 0; i--) {
            bits[i] = (input & (1 << i)) != 0;
        }

        System.out.println(input + " = " + Arrays.toString(bits));

        int length = 11;
        int number = 1;
        final boolean[] ret = new boolean[length];
        for (int i = 0; i < length; i++) {
            ret[length - 1 - i] = (1 << i & number) != 0;
        }
        System.out.println(input + " = " + Arrays.toString(ret));
    }
}
