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
    static int noGroups = groupArray.length;

    // Define the equation variables
    static double Nc, N; // Number of Cooperators (Nc) & Number of individuals (N)
    static double R = 2.0; // Multiplication Value
    static double C = 10.0; // Cost of contribution

    // Variables for my various methods
    static int randomIndividual;
    static int noIndividuals = groupArray[0].length; // Second dimension

    public static void chooseRandom() {
        Random rand = new Random();
        int memberOf = 0;
        int testVal = 0;
        //int hardCodeVal = 6;

            randomIndividual = rand.nextInt(7) + 0;
            while (testVal < noGroups) {
                if (groupArray[testVal][randomIndividual] == true) {
                    memberOf++;
                }
                testVal++;
            }

        char checkStrategy = strategyArray[randomIndividual];

        System.out.println("Individual " + randomIndividual);
        System.out.println("Strategy: " + checkStrategy);
        System.out.println("Member of: " + memberOf + " groups");

    }

    public static void calculatePayoff() {
        double PC = (R * Nc * C) / N;
        double PD = PC - C;
    }

    public static void main(String[] args) {
        //System.out.println(noRows);
        chooseRandom();
    }

}
