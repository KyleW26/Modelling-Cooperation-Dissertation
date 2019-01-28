package dissertation;

import java.util.Random;

/**
 *
 * @author kylewilliams
 */
public class Attempt3 {

    static char[] strategyArray = new char[165];
    static boolean[][] groupArray = new boolean[10][165];
    static int noOfIndividuals = strategyArray.length;
    static int randomPerson = 0; // Individual and Group
    static double r = 10; // Multiplication Value
    static double c = 10; // Cost of contributions
    static double PD, PC;
    static float sum;
    static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        generateIndividuals();
        calculateIndividualPayoff();
        checkNeighbours();
        offerGroupChange(sum, randomPerson);
    }

    public static void generateIndividuals() {
        final String alphabet = "CD";
        final int N = alphabet.length();
        Random r = new Random();

        for (int i = 0; i < noOfIndividuals; i++) {
            strategyArray[i] = alphabet.charAt(r.nextInt(N));

            for (int y = 0; y < groupArray.length; y++) {
                groupArray[y][i] = r.nextBoolean();
            }
        }

        for (int i = 0; i < groupArray.length; i++) {
            for (int j = 0; j < noOfIndividuals; j++) {
                System.out.print(j + ": " + groupArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    // int i = individual ... int g = group
    public static float calculateIndividualPayoff() {
        // Groups (rows)
        for (int g = 0; g < groupArray.length; g++) {
            double Nc = 0;
            double N = 0;
            // Individuals (columns)
            for (int i = 0; i < noOfIndividuals; i++) {
                if (groupArray[g][i] == true) {
                    N++;
                    if (strategyArray[i] == 'C') {
                        Nc++;
                    }
                }
            }

            if (groupArray[g][randomPerson] == true) {
                PD = (r * Nc * c) / N;
                PC = PD - c;

                if (strategyArray[randomPerson] == 'C') {
                    sum += PC;
                } else if (strategyArray[randomPerson] == 'D') {
                    sum += PD;
                }
            }

            System.out.println();
            System.out.println("N in group " + g + ": " + N);
            System.out.println("Nc in group " + g + ": " + Nc);
            System.out.println("Sum of group " + g + ": " + sum);
            System.out.println();
        }
        return sum;
    }

    public static int checkNeighbours() {

        for (int w = 0; w < 165; w++) {
            randomPerson = rand.nextInt(165) + 0;
            // Get the neighbour
            int leftNeighbour = randomPerson - 1;
            int rightNeighbour = randomPerson + 1;

            // Error checking if there is no neighbour on the right hand side
            if (rightNeighbour >= 165) {
                System.out.println("There is no neighbour on the right, checking individual 0.");
                rightNeighbour = 0;
            }
            // Error checking if there is no neighbour on the left hand side
            if (leftNeighbour < 0) {
                System.out.println("There is no neighbour on the left, checking individual 0.");
                leftNeighbour = 0;
            }

            // Get the strategy
            char leftNeighbourStrat = strategyArray[leftNeighbour];
            char rightNeighbourStrat = strategyArray[rightNeighbour];

            System.out.println();
            System.out.println("Random Individual: " + randomPerson + " is a " + strategyArray[randomPerson]);
            System.out.println("Individual " + leftNeighbour + " = " + leftNeighbourStrat);
            System.out.println("Individual " + rightNeighbour + " = " + rightNeighbourStrat);

            // Length of array & calculations for payoff
            int individual = groupArray[0].length;
            double sumLeft = 0.0;
            double sumRight = 0.0;
            // Groups (rows)
            for (int g = 0; g < groupArray.length; g++) {
                double Nc = 0;
                double N = 0;
                // Individuals (columns)
                for (int i = 0; i < individual; i++) {
                    if (groupArray[g][i] == true) {
                        N++;
                        if (strategyArray[i] == 'C') {
                            Nc++;
                        }
                    }
                }

                if (groupArray[g][leftNeighbour] == true) {
                    PD = (r * Nc * c) / N;
                    PC = PD - c;

                    if (strategyArray[leftNeighbour] == 'C') {
                        sumLeft += PC;
                    } else {
                        sumLeft += PD;
                    }
                }

                if (groupArray[g][rightNeighbour] == true) {
                    PD = (r * Nc * c) / N;
                    PC = PD - c;

                    if (strategyArray[rightNeighbour] == 'C') {
                        sumRight += PC;
                    } else {
                        sumRight += PD;
                    }
                }
                System.out.println();
                System.out.println("N in group " + g + ": " + N);
                System.out.println("Nc in group " + g + ": " + Nc);
            }
            // Print out the sums of the left & right neighbour
            System.out.println("Sum of individual " + leftNeighbour + ": " + sumLeft);
            System.out.println("Sum of individual " + rightNeighbour + ": " + sumRight);
            System.out.println();

            // Change the strategy array based upon values being higher or lower
            if (sumLeft > sum) {
                strategyArray[randomPerson] = leftNeighbourStrat;
                System.out.println("Strategy of "
                        + "individual " + randomPerson + " has been updated to " + leftNeighbourStrat);
            }

            if (sumRight > sum) {
                strategyArray[randomPerson] = rightNeighbourStrat;
                System.out.println("Strategy of "
                        + "individual " + randomPerson + " has been updated to " + rightNeighbourStrat);
            }

            // Print out the strategy array
            for (int x = 0; x < strategyArray.length; x++) {
                System.out.print(strategyArray[x] + " ");
            }

            System.out.println();
        }
        return randomPerson;
    }

    public static void offerGroupChange(float sum, int randomPerson) {
        System.out.println("-------------------");
        System.out.println("offerGroupChange...");
        System.out.println("-------------------");
        randomPerson = rand.nextInt(165) + 0;

        int leftNeighbour = randomPerson - 1;
        int rightNeighbour = randomPerson + 1;

        // Get the strategy
        char leftNeighbourStrat = strategyArray[leftNeighbour];
        char rightNeighbourStrat = strategyArray[rightNeighbour];

        // Length of array & calculations for payoff
        int individual = groupArray[0].length;
        double sumLeft = 0.0;
        double sumRight = 0.0;
        // Groups (rows)
        for (int g = 0; g < groupArray.length; g++) {
            double Nc = 0;
            double N = 0;
            // Individuals (columns)
            for (int i = 0; i < individual; i++) {
                if (groupArray[g][i] == true) {
                    N++;
                    if (strategyArray[i] == 'C') {
                        Nc++;
                    }
                }
            }

            if (groupArray[g][leftNeighbour] == true) {
                PD = (r * Nc * c) / N;
                PC = PD - c;

                if (strategyArray[leftNeighbour] == 'C') {
                    sumLeft += PC;
                } else {
                    sumLeft += PD;
                }
            }

            if (groupArray[g][rightNeighbour] == true) {
                PD = (r * Nc * c) / N;
                PC = PD - c;

                if (strategyArray[rightNeighbour] == 'C') {
                    sumRight += PC;
                } else {
                    sumRight += PD;
                }
            }
            System.out.println();
            System.out.println("N in group " + g + ": " + N);
            System.out.println("Nc in group " + g + ": " + Nc);
        }
        // Print out the sums of the left & right neighbour
        System.out.println("Sum of individual " + leftNeighbour + ": " + sumLeft);
        System.out.println("Sum of individual " + rightNeighbour + ": " + sumRight);
        System.out.println();
        System.out.println("Sum of individual " + randomPerson + " = " + sum);

        int randomGroup = rand.nextInt(9) + 1;
        int randomSecondGroup = rand.nextInt(9) + 1;

        // Offer a chance to leave a group and join a random one
        if (sumLeft > sum) {
            if (groupArray[randomGroup][randomPerson] == true) {
                System.out.println("Individual " + randomPerson + " is now leaving group " + randomGroup
                        + " and joining group " + randomSecondGroup+", because the payoff of the left neighbour"
                                + " was higher.");
                groupArray[randomGroup][randomPerson] = false;
                groupArray[randomSecondGroup][randomPerson] = true;
            }
        }

        if (sumRight > sum) {
            if (groupArray[randomGroup][randomPerson] == true) {
                System.out.println("Individual " + randomPerson + " is now leaving group " + randomGroup
                        + " and joining group " + randomSecondGroup+", because the payoff of the right neighbour"
                                + " was higher.");
                groupArray[randomGroup][randomPerson] = false;
                groupArray[randomSecondGroup][randomPerson] = true;
            }
        }
    }
}
