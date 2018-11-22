package dissertation;

import java.util.Random;

/**
 *
 * @author kylewilliams
 */
public class Attempt3 {

    static char[] strategyArray = {'C', 'D', 'C', 'C', 'C', 'D', 'D'};

    // Generate 3 different groups
    static boolean[][] groupArray = {
        {true, true, false, true, false, false, true},
        {true, false, true, true, false, false, false},
        {true, true, true, true, true, false, true}};

    static boolean memberOf[] = new boolean[3];

    static int randomPerson = 0; // Individual and Group
    static double r = 2.0; // Multiplication Value
    //static double Nc = 0.0; // Number of cooperators
    //static double N = 0.0; // Number of individuals
    static double c = 10.0; // Cost of contributions
    static double PD, PC, sum;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getRandom();
        calculateGroup();
    }

    public static void getRandom() {
        Random rand = new Random();
        randomPerson = rand.nextInt(7) + 0;
    }

    // int i = individual ... int g = group
    public static void calculateGroup() {
        int individual = groupArray[0].length;

        // Groups (rows)
        for (int g = 0; g < groupArray.length; g++) {
            double Nc = 0;
            double N = 0;
            //double sum = 0;
            // Individuals (columns)
            for (int i = 0; i < individual; i++) {
                if (groupArray[g][i] == true) {
                    N++;
                    if (strategyArray[i] == 'C') {
                        Nc++;
                    }
                }
                //System.out.println(groupArray[g][i]);
            }

            if (groupArray[g][randomPerson] == true) {
                PD = (r * Nc * c) / N;
                PC = PD - c;

                if (strategyArray[randomPerson] == 'C') {
                    sum += PC;
                } else {
                    sum += PD;
                }
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println();

        memberOf[0] = groupArray[0][randomPerson] == true;
        memberOf[1] = groupArray[1][randomPerson] == true;
        memberOf[2] = groupArray[2][randomPerson] == true;

        System.out.println("Random Individual: " + randomPerson);
        System.out.println("Individual " + randomPerson + " is a member of groups: "
                + memberOf[0] + " " + memberOf[1] + " " + memberOf[2]);
    }
}
