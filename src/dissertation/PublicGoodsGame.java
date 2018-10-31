/*
 * Public Goods Games - Modelling Cooperation
 * Creator: Mathew Kyle Williams - Bangor University School of Computer Science
 * Tutor: Dr Ik Soo Lim
 */
package dissertation;

import java.util.Scanner;

public class PublicGoodsGame {

    // Generate ALL variables
    static Scanner sc = new Scanner(System.in);

    // Define the multiplication value and the cost of the contributions
    static double r = 3; // Multiplication Value
    static double c = 10; // Cost of contributions
    static double N, Nc;
    static int selectedGroup, selectedIndividual;

    // Variables for use in loops
    static int whileVar = 0;
    static int testCoop = 0;
    static int whileVarBool = 0;
    static int testTrue = 0;

    // Generate 3 different strategies
    static char[]strategyArray = {'C', 'D', 'C', 'C', 'C', 'D', 'D'};
    
    // Generate 3 different groups
    static boolean[][] groupArray = {
        {true, true, false, true, false, false, true},
        {true, false, true, true, false, false, false},
        {true, true, true, true, true, false, true}};

    // Store which member belongs to which group
    static boolean[] isMember = new boolean[3];
    static int noRows = groupArray.length - 1;
    static int[] memberOf = new int[3];

    public static void menuSystem() {
        System.out.println("Welcome to Kyles public goods game simulation!");
        System.out.print("Would you like to calculate payoff via group (g) or individual (i)? :> ");
        char groupOrInd = sc.next().charAt(0);

        // Select what you'd like to calculate
        switch (groupOrInd) {
            case 'g':
            case 'G':
                calculateGroup();
                break;
            case 'i':
            case 'I':
                calculateIndividual();
                break;
            default:
                System.out.println("ERROR: Unexpected value.");
                break;
        }
    }

    public static void calculateGroup() {
        // Select which group you'd like to assess
        System.out.println(" ");
        System.out.println("There are 3 groups (0-2)...");
        System.out.print("Select which group you would like assess :> ");
        selectedGroup = sc.nextInt();

        // Test whether players are cooperators or defectors (BY GROUP)
        while (whileVarBool < 7) {
            if (groupArray[selectedGroup][whileVarBool] == true) {
                testTrue++;
                if (strategyArray[testTrue] == 'C') {
                    testCoop++;
                }
            }
            whileVarBool++;
        }

        //Payoff calculation & More variables
        N = testTrue;
        Nc = testCoop;
        double payoffDefector = (r * Nc * c) / N;
        double payoffCooperator = payoffDefector - c;

        // Print out the calculated value, also increase the value by one so that it matches the initial input
        System.out.println("From group " + (selectedGroup) + " I have calculated: ");
        System.out.println("r = " + r);
        System.out.println("Nc = " + Nc);
        System.out.println("C = " + c);
        System.out.println("N = " + N);
        System.out.println(" ");
        System.out.print("Therefore, Payoff for a defector is: " + payoffDefector + "\n");
        System.out.print("Payoff for a cooperator is: " + payoffCooperator + "\n");
    }

    public static void calculateIndividual() {
        // Select which individual you'd like to assess
        System.out.println(" ");
        System.out.println("There are 7 individuals (0-6)...");
        System.out.print("Select which individual you would like assess :> ");
        selectedIndividual = sc.nextInt();

        //System.out.println("Number of rows: " + noRows);
        //System.out.println("Individual: " + selectedIndividual);
        // Calculate how many groups an individual is a part of
        int i = 0;
        while (i <= noRows) {
            // [row][column]
            if (groupArray[i][selectedIndividual] == true) {
                testTrue++;
                isMember[i] = true;
            }
            i++;
        }

        System.out.println("Individual " + selectedIndividual + " is a member of " + testTrue + " groups.");
        int y = 0;
        while (y < 3) {
            System.out.println("Individual " + selectedIndividual + " is a member of group " + y + " : " + isMember[y]);
            // If any number in the integer array isMember other than 0 it means the person is a member of that group
            if(isMember[y] == true) {
                memberOf[y] = 1;
            }
            y++;
        }
        
        System.out.println("Member of: "+memberOf[0]+memberOf[1]+memberOf[2]);
    }
    

    public static void main(String[] args) {
        menuSystem();
    }

}
