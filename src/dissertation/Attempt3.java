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
public class Attempt3 {

    static char[] strategyArray = {'C', 'D', 'C', 'C', 'C', 'D', 'D'};

    // Generate 3 different groups
    static boolean[][] groupArray = {
        {true, true, false, true, false, false, true},
        {true, false, true, true, false, false, false},
        {true, true, true, true, true, false, true}};

    static int randomPerson = 0; // Individual and Group
    static double r = 2.0; // Multiplication Value
    static double Nc = 0.0; // Number of cooperators
    static double N = 0.0; // Number of individuals
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

    // int i = individual ... int k = group
    public static void calculateGroup() {

        /*for (int row = 0; row < groupArray.length; row++) {
            sum = 0;
            for (int column = 0; column < groupArray[row].length; column++) {
                if(groupArray[row][randomPerson] == true) {
                    N++;
                }

                //System.out.print("\t" + groupArray[row][column] + "\t|");
            }
            // System.out.println();
        } */
 /*  for G [row][column]
                sum = 0;
                    for K = 0:2
                        IF col belongs to row
                                sum += payoff(k)
                        end
                    end
        end */
 
        for (int g = 0; g < groupArray.length; g++) {
            sum = 0;
            for (int i = 0; i < groupArray[1].length; i++) {
                if (groupArray[g][randomPerson] == true) {
                    //sum += payoff(k);
                    N++;
                }
            }
        }
        

        System.out.println(groupArray.length);
        System.out.println(groupArray[1].length);

        System.out.println(N);

        System.out.println(" ");
        System.out.println("Random Individual: " + randomPerson);
        System.out.println("Value of N: " + N);
        System.out.println("Amount of groups: " + groupArray.length); // Groups
    }
}
