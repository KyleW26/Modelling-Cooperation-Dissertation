/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissertation;

import java.util.Random;

/**
 *
 * @author kylewilliams
 */
public class newDissertation {

    // Generate 3 different strategies
    static char[] strategyArray = {'C', 'D', 'C', 'C', 'C', 'D', 'D'};

    // Generate 3 different groups
    static boolean[][] groupArray = {
        {true, true, false, true, false, false, true},
        {true, false, true, true, false, false, false},
        {true, true, true, true, true, false, true}};

    // Three groups, known as 0-2, hence why I have to subtract one from this value
    static int noRows = groupArray.length;

    // Define the equation variables
    static double Nc, N; // Number of Cooperators (Nc) & Number of individuals (N)
    static double R = 2.0; // Multiplication Value
    static double C = 10.0; // Cost of contribution

    public void calculatePayoff() {
        // PC = (r * Nc * C) / N;
        // PD = PC - C

    }

    public static void chooseRandom() {
        Random rand = new Random();
        int[] randomArray = new int[7];

        // Choose a random invidual 7 times
        for (int i = 0; i < 7; i++) {
            int randomIndividual = rand.nextInt(7) + 0;
            randomArray[i] = randomIndividual;
        }
    }

    public static void main(String[] args) {
        //System.out.println(noRows);
        chooseRandom();
    }

}
