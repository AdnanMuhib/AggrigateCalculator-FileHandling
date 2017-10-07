/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This function check the numbers in all rows, all columns, and
 * both diagonals sum to the same constant.
 * @version 4 10 Oct 2017
 * @author Sumbal
 */
public final class Lab5 {
    /**.
    * Default constructor
    */
    private Lab5() {

    }
    /**.
     * Main Function
     * @param args some arguments
     * @throws FileNotFoundException exception
     * @throws IOException exception
     */
    public static void main(final String[] args)
            throws FileNotFoundException, IOException {
        //file reader instance.
        FileReader fr = new FileReader("C:\\Users\\Sumbal\\Documents\\"
                + "NetBeansProjects\\Lab5\\src\\lab5\\Input.txt.txt");
        //Line reader instance.
        BufferedReader br = new BufferedReader(fr);
        //Read Line and store in a string.
        String line = br.readLine();
        //How many matrix in file.
        int numOfMatrix = 0;
        //Used for store size of each matrix.
        int[] sizes  = new int[numOfMatrix];
        //Used for counting size exist in file.
        int size = 0;
        //Used for split file line.
        String[] s = null;
        //Used for store sum of all rows,
        //columns and diagonals.
        int[] sum =  new int[0];
        //Used for store matrix components.
        int[][] tables = new int[0][0];
        //used for all following
        //variables for iterators.
        int z = 0;
        int h = 0;
        int c = 0;
        int i = 0;
        int j = 0;
        //check for next matrix come.
        int checkk = 0;
        /*
        This loop Used for storing sizez of all matrix.
        */
        for (int p = 0; line != null; p++) {
            if (p == 0) {
                numOfMatrix = Integer.parseInt(line);
                sizes = new int[numOfMatrix];
            } else if (line.equals("")) {
                line = br.readLine();
                sizes[size] = Integer.parseInt(line);
                size++;
            }
            line = br.readLine();
        }
        //Again File read.
        FileReader r = new FileReader("C:\\Users\\Sumbal\\Documents\\"
                + "NetBeansProjects\\Lab5\\src\\lab5\\Input.txt.txt");
        BufferedReader dr = new BufferedReader(r);
        String linee = dr.readLine();
        /*
        size of sum define for all rows,
        columns and diagonals.
        */
        sum = new int[(sizes[j] + sizes[j]) + 2];
        //loop untill matrix will be end.
        for (; j < numOfMatrix;) {
            for (; linee != null; i++) {
                /*
                ignore start lines start from where
                start form size of first matrix.
                */
                if (i >= 2) {
                    if (i == 2) {
                        linee = dr.readLine();
                    }
                    /*
                    In which check sum of rows,
                    columns and diagonals and print true or false.
                    */
                    if (checkk > 0) {
                        linee = dr.readLine();
                        checkk = 0;
                        //loop will run untill all sum stors.
                        for (; h < sum.length;) {
                            //sum new size for next matrix.
                            if (j > 0) {
                                sum = new int[(sizes[j] + sizes[j]) + 2];
                            }
                            //sum of all rows.
                            for (int m = 0; m < tables.length; m++) {
                                for (int n = 0; n < tables.length; n++) {
                                    sum[h] += tables[m][n];
                                }
                                h++;
                            }
                            //sum of all columns.
                            for (int m = 0; m < tables.length; m++) {
                                for (int n = 0; n < tables.length; n++) {
                                    sum[h] += tables[n][m];
                                }
                                h++;
                            }
                            //sum of right side diagonals.
                            for (int m = 0; m < 1; m++) {
                                for (int n = 0; n < tables.length; n++) {
                                    sum[h] += tables[n][n];
                                }
                                h++;
                            }
                            //sum of left side diagonals.
                            int n = tables.length - 1;
                            for (int m = 0; m < tables.length; m++) {
                                for (; n >= 0;) {
                                    sum[h] += tables[m][n];
                                    System.out.println(sum[h]);
                                    n--;
                                    break;
                                }
                            }
                        h++;
                        }
                        //check equals sum.
                        for (int g = 0; g < sum.length - 1; g++) {
                            if (sum[g] == sum[g + 1]) {
                                c = 1;
                            } else {
                                c = 0;
                                break;
                            }
                        }
                        //Print true or false.
                        if (c == 1) {
                            System.out.println(true);
                            j++;
                        } else {
                            System.out.println(false);
                            j++;
                        }
                        c = 0;
                        h = 0;
                    } else { //read line form file,split and store in 2D array.
                        tables = new int[sizes[j]][sizes[j]];
                        for (int k = 0; k < sizes[j]; k++) {
                            if (j > 0 && k == 0) {
                                linee = dr.readLine();
                            }
                            z = 0;
                            s = linee.split("\t");
                            for (int l = 0; l < sizes[j]; l++) {
                                for (; z < s.length;) {
                                    tables[k][l] = Integer.parseInt(s[z]);
                                    System.out.println(tables[k][l]);
                                    z++;
                                    break;
                                }
                            }
                            if (k != sizes[j] - 1) {
                                linee = dr.readLine();
                            } else {
                                checkk = 1;
                            }
                        }
                    }
                }
            if (checkk == 0) {
                linee = dr.readLine();
            }
            }
            linee = dr.readLine();
        }
    }
}
