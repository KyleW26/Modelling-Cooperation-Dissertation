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
    static double payoffCoopG0, payoffDefecG0, payoffCoopG1, payoffDefecG1, payoffCoopG2, payoffDefecG2;

    // Variables for my various methods
    static int randomIndividual; // Initialised in the chooseRandom method
    static int noIndividuals = groupArray[0].length; // Second dimension
    static int whileVar, testVal; // Loop vars
    static int testTrue = 0;

    public static void chooseRandom() {
        Random rand = new Random();
        int memberOf = 0;

        randomIndividual = rand.nextInt(7) + 0;

        while (testVal < noGroups) {
            if (groupArray[testVal][randomIndividual] == true) {
                //calculateGroup();
                memberOf++;
            }
            testVal++;
        }

        System.out.println("Individual " + randomIndividual);
        // Check the strategy of the randomIndividual
        char checkStrategy = strategyArray[randomIndividual];

        System.out.println("Strategy: " + checkStrategy);
        System.out.println("Member of: " + memberOf + " groups");
        System.out.println(" ");

        if (groupArray[0][randomIndividual] == true) {
            //System.out.println("Individual " + randomIndividual + " is a member of group 0.");
            while (whileVar < 7) {
                if (groupArray[0][whileVar] == true) {
                    testTrue++;
                    if (strategyArray[testTrue] == 'C') {
                        Nc++;
                    }
                }
                whileVar++;
            }
            N = testTrue;

            if (groupArray[1][randomIndividual] == true) {
                //System.out.println("Individual " + randomIndividual + " is a member of group 0.");
                while (whileVar < 7) {
                    if (groupArray[1][whileVar] == true) {
                        testTrue++;
                        if (strategyArray[testTrue] == 'C') {
                            Nc++;
                        }
                    }
                    whileVar++;
                }
                N = testTrue;

                payoffCoopG0 = (R * Nc * C) / N;
                payoffDefecG0 = payoffCoopG0 - C;
                System.out.println("Group 0 Cooperator payoff: " + payoffCoopG0);
                System.out.println("Group 0 Defector payoff: " + payoffDefecG0);
            }

        }
    }

    

    public static void calculateGroup() {

        int testTrue = 0;

        // Test whether players are cooperators or defectors (BY GROUP)
        while (whileVar < 7) {
            if (groupArray[testVal][whileVar] == true) {
                testTrue++;
                if (strategyArray[testTrue] == 'C') {
                    Nc++;
                }
            }
            whileVar++;
        }
        N = testTrue;

        System.out.println("Group: " + testVal);
        System.out.println("No. of Individuals: " + N);
        System.out.println("No. of Cooperators: " + Nc);
        System.out.println(" ");
        calculatePayoff();
    }

    public static void calculatePayoff() {
        double PC = (R * Nc * C) / N;
        double PD = PC - C;
        System.out.println("PC: " + PC);
        System.out.println("PD: " + PD);
    }

    public static void main(String[] args) {
        //System.out.println(noRows);
        //chooseRandom();
        //calculatePayoff();
        calculateGroup();
    }

}
