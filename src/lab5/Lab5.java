/**@package Lab5 package info
 * @package lab5 Lab5 Project Assignment
 */
package lab5;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Adnan
 */
public class Lab5 {
    /**.
     * COnstant for Total Marks in FSC
     */
    private static final int FSC_TOTAL = 1100;
    /**.
     * Constant for Total marks in ECAT
     */
    private static final int ECAT_TOTAL = 400;
    /**.
     * Constant for fsc percentage to be considered in ECAT
     */
    private static final double FSC_PERCENTAGE = 0.7;
    /**.
     * Constant for ecat percentage to be considered in ECAT
     */
    private static final double ECAT_PERCENTAGE = 0.3;
    /**.
     * Constant for 100
     */
    private static final double HUNDRED = 100.0;
    /**.
     * Constant for Total length of Roll Number
     */
    private static final int ROLL_NUMBER_LENGTH = 13;
    /**.
     * Constant Number
     */
    private static final int FOUR = 4;
    /**.
     * Constant Number
     */
    private static final int NINE = 9;
    /**.
     * Passing Aggregate Value
     */
    private static final int PASS_AGGREGATE = 65;
    /**.
     * Constant Number
     */
    private static final int DECIMAL_PLACES = 5;
    /** this is lab5.
     *  Default Constructor.
     */
    public Lab5() {
        rollNo = "";
        fscMarks = 0;
        ecatMarks = 0;
        status = "";
        students = new ArrayList<Lab5>();
    }
    /**.
     * This is Main Function
     * @param args no arguments
     * @throws FileNotFoundException this will throw some exception
     * @throws IOException this will throw some exception
     */
    public static void main(final String[] args)
            throws FileNotFoundException, IOException {
        Lab5 admissions = new Lab5();
        Lab5 student;
        FileReader fr = new FileReader("C:\\Users\\AntiVirus\\"
                + "Desktop\\admission.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (!(line == null)) {
            student = new Lab5();
            student.setRollNo(line);
            if (admissions.isValidRollNumber(line)) {
                String fscMarks = JOptionPane.showInputDialog(null, "Enter"
                        + " FSC Marks");
                while (!fscMarks.chars().allMatch(Character::isDigit)) {
                    fscMarks = JOptionPane.showInputDialog(null, "Incorrect!! "
                            + "Enter FSC Marks");
                }
                while (!admissions.areValidFSCMarks(
                        Integer.parseInt(fscMarks))) {
                    fscMarks = JOptionPane.showInputDialog(null, "Incorrect!!"
                            + " Enter FSC Marks");
                    while (!fscMarks.chars().allMatch(Character::isDigit)) {
                       fscMarks = JOptionPane.showInputDialog(null, "Incorect!!"
                               + " Enter FSC Marks");
                    }
                }
                student.setFscMarks(Integer.parseInt(fscMarks));
                String ecatMarks = JOptionPane.showInputDialog(null,
                        "Enter Ecat Mark");
                while (!ecatMarks.chars().allMatch(Character::isDigit)) {
                    ecatMarks = JOptionPane.showInputDialog(null, "Incorrect!!"
                            + " Enter Ecat Marks");
                }
                while (!admissions.areValidEcatMarks(
                        Integer.parseInt(ecatMarks))) {
                    ecatMarks = JOptionPane.showInputDialog(null, "Incorrect!!"
                            + " Enter Ecat Marks");
                    while (!ecatMarks.chars().allMatch(Character::isDigit)) {
                        ecatMarks = JOptionPane.showInputDialog(null,
                                "Incorrect!! Enter Ecat Marks");
                    }
                }
                student.setEcatMarks(Integer.parseInt(ecatMarks));
                Double aggr = student.calculateAggrigate(student.getFscMarks(),
                        student.getEcatMarks());
                student.setAggregate(aggr);
                student.setStatus(student.getStatus(aggr));
            } else {
                student.setStatus("Roll Number not valid");
            }
            admissions.students.add(student);
            line = br.readLine();
        }
        admissions.printStudents();
    }
    /**.
     * This Method calculates the aggregate of student
     * @param fsc Marks of FSC
     * @param ecat Marks of Ecat
     * @return double: aggregate
     */
    public double calculateAggrigate(final int fsc, final int ecat) {
        double result =  (fsc * 1.0 / FSC_TOTAL) * FSC_PERCENTAGE
                + (ecat * 1.0  / ECAT_TOTAL) * ECAT_PERCENTAGE;
        return result * HUNDRED;
    }
    /**.
     * This method validates the given student roll number
     * @param rNo : roll Number of the Student
     * @return boolean
     */
    public boolean isValidRollNumber(final String rNo) {
        if (rNo.length() != ROLL_NUMBER_LENGTH) {
              return false;
        }
        if (rNo.substring(0, FOUR).chars().allMatch(Character::isDigit)
                && rNo.substring(FOUR, NINE).equals("ENTRY")
                && rNo.substring(NINE, ROLL_NUMBER_LENGTH).chars().
                        allMatch(Character::isDigit)) {
                return true;
        }
        return false;
    }
    /**.
     * Checks whether entered marks are valid or not
     * @param fsc Marks of FSC
     * @return boolean
     */
    public boolean areValidFSCMarks(final int fsc) {
        if (fsc >= 0  && fsc <= FSC_TOTAL) {
            return true;
        }
        return false;
    }
    /**.
     * Checks whether entered marks are valid or not
     * @param ecat Marks of Ecat
     * @return boolean
     */
    public boolean areValidEcatMarks(final int ecat) {
        if (ecat >= 0  && ecat <= ECAT_TOTAL) {
            return true;
        }
        return false;
    }
    /**.
     * This method returns the status of admission
     * @param agri Aggregate of the student
     * @return String: Status
     */
    public String getStatus(final double agri) {
        if (agri < PASS_AGGREGATE) {
            return "Rejected";
        }
        return "Accepted";
    }
    /**.
     * This Method Prints the Students in a Specific Format
     */
    public void printStudents() {
        System.out.println("Roll Number, FSC Marks, "
                + "Entry Test Marks, Aggregate, Status");
        for (int i = 0; i < this.students.size(); i++) {
            if (!students.get(i).getStatus().equals("Roll Number not valid")) {
            String aggr = "" + students.get(i).aggregate;
            System.out.println("" + students.get(i).rollNo
                    + ", " + students.get(i).fscMarks
                    + ", " + students.get(i).ecatMarks
                    + ", " + aggr.substring(0, DECIMAL_PLACES)
                    + ", " + students.get(i).getStatus());
            } else {
                String aggr = "" + students.get(i).aggregate;
                System.out.println("" + students.get(i).rollNo
                        + ",,," + students.get(i).getStatus());
            }
        }
    }
    /**.
     * Return Roll Number
     * @return Roll Number of Student
     */
    public String getRollNo() {
        return rollNo;
    }
    /**.
     * Setter function for the Roll number
     * @param rollN Roll Number of the student
     */
    public void setRollNo(final String rollN) {
        this.rollNo = rollN;
    }
    /**.
     * getter function for the FSC Marks
     * @return int: FSC marks
     */
    public int getFscMarks() {
        return fscMarks;
    }
    /**.
     * Setter Function for the FSC Marks
     * @param fscMark Marks obtained in fsc
     */
    public void setFscMarks(final int fscMark) {
        this.fscMarks = fscMark;
    }
    /**.
     * Getter Method for Ecat marks
     * @return int: marks obtained in ecat
     */
    public int getEcatMarks() {
        return ecatMarks;
    }
    /**.
     * Setter function for ecat marks
     * @param ecatMark marks obtained in ecat.
     */
    public void setEcatMarks(final int ecatMark) {
        this.ecatMarks = ecatMark;
    }
    /**.
     * getter method for Admission Status
     * @return string: status of the admission Accepted, Rejected
     */
    public String getStatus() {
        return status;
    }
    /**.
     * Setter method for the Status
     * @param stat String: Status of admission accepted or rejected
     */
    public void setStatus(final String stat) {
        this.status = stat;
    }
    /**.
     * Getter method for the aggregate
     * @return double:  aggregate of student
     */
    public double getAggregate() {
        return aggregate;
    }
    /**.
     * setter method for Aggregate
     * @param aggr double: Aggregate of the Student
     */
    public void setAggregate(final double aggr) {
        this.aggregate = aggr;
    }
    /**.
     * Getter Method for the ArrayList of Students
     * @return ArrayList Students Lab5
     */
    public ArrayList<Lab5> getStudents() {
        return students;
    }
    /**.
     * Setter method for the ArrayList of the Student
     * @param std students list
     */
    public void setStudents(final ArrayList<Lab5> std) {
        this.students = std;
    }
   /**.
    * Attributes
    */
    private String rollNo;
    /**.
     * Attribute for the FSC MARKS.
     */
    private int fscMarks;
    /** Attribute for the ECAT MARKS.
     */
    private int ecatMarks;
    /** Attribute for the Status.
     */
    private String status;
    /** Attribute for the Aggregate.
     */
    private double aggregate;
    /** Attribute for the LIST of Students.
     */
    private ArrayList<Lab5> students;
}
