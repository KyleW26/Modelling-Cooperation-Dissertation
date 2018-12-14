/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissertation;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author kylewilliams
 */
public class newDissertation {

    static char[] strategyArray = new char[165];
    static boolean[][] groupArray = new boolean[10][165];
    static int noOfIndividuals = strategyArray.length;

    public static void main(String[] args) {
        final String alphabet = "CD";
        final int N = alphabet.length();
        Random r = new Random();

        for (int i = 0; i < noOfIndividuals; i++) {
            strategyArray[i] = alphabet.charAt(r.nextInt(N));
            
            for (int y = 0; y < groupArray.length; y++) {
                groupArray[y][i] = r.nextBoolean();
            }
        }

        // Uncomment to print out the array
        /*for (int z = 0; z < groupArray.length; z++) {
            for (int j = 0; j < groupArray[z].length; j++) {
                System.out.print(groupArray[z][j] + " ");
            }
            System.out.println();
        } */

    }
}
