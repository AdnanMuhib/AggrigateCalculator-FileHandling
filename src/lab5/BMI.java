/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @package driver a packafa
 */
package driver;
import java.awt.Color;
/**
 * @author Muhammad Adnan Mohib
 */
public class BMI extends javax.swing.JFrame {
    /**.
     * Creates new form BMI
     */
    public BMI() {
        initComponents();
        this.heightUnit = "CM";
        this.weightUnit = "KG";
        this.gender = "MALE";
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        textHeightFeet.hide();
        textHeightInches.hide();
        textHeightFeet.setText("0");
        textHeightInches.setText("0");
        textWeightLB.hide();
        textWeightLB.setText("0");
        textWeightSt.setText("0");
        textWeightSt.hide();
    }
    /**.
     * age getter
     * @return int: Age
     */
    public int getAge() {
        return age;
    }
    /**.
     * age setter
     * @param agge age of the person
     */
    public void setAge(final int agge) {
        this.age = agge;
    }
    /**.
     * Height Getter
     * @return double: height
     */
    public double getHeight_() {
        return height;
    }
    /**.
     * height setter
     * @param heighht double: height of the person
     */
    public void setHeight(final double heighht) {
        this.height = heighht;
    }
    /**.
     * weight getter
     * @return double: weight of the person
     */
    public double getWeight() {
        return weight;
    }
    /**.
     * weight setter
     * @param weighht double: weight of the person 
     */
    public void setWeight(final double weighht) {
        this.weight = weighht;
    }
    /**.
     * gender getter
     * @return String: Male or Female
     */
    public String getGender() {
        return gender;
    }
    /**.
     * gender setter
     * @param gender String : Male or Female 
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }
    /**.
     * weight unit getter
     * @return String: KG or LB or LB+ST
     */
    public String getWeightUnit() {
        return weightUnit;
    }
    /**.
     * setter for weight unit
     * @param weightUnit String : KG or LB or LB+ST
     */
    public void setWeightUnit(final String weightUnit) {
        this.weightUnit = weightUnit;
    }
    /**.
     * getter for height unit
     * @return String CM or FT+IN
     */
    public String getHeightUnit() {
        return heightUnit;
    }
    /**.
     * setter for the height unit
     * @param heightUnit String: CM or FT+IN
     */
    public void setHeightUnit(final String heightUnit) {
        this.heightUnit = heightUnit;
    }
    /**.
     * getter for BMI Value
     * @return double: Body Mass Index
     */
    public double getBmi() {
        return bmi;
    }
    /**.
     * setter for BMI value
     * @param bmi double: BOdy Mass Index
     */
    public void setBmi(final double bmi) {
        this.bmi = bmi;
    }
    /**.
     * getter for ideal Weight
     * @return Double: Ideal Weight
     */
    public double getIdealWeight() {
        return idealWeight;
    }
    /**.
     * Setter for idea weight
     * @param idealWeight Double Ideal Weight
     */
    public void setIdealWeight(final double idealWeight) {
        this.idealWeight = idealWeight;
    }
    /**.
     * getter for FAT value
     * @return Double: FAT Value
     */
    public double getFat() {
        return fat;
    }
    /**.
     * setter for the fat value
     * @param fat Double FAT Value
     */
    public void setFat(double fat) {
        this.fat = fat;
    }
    /**
     * Calculates BMI Value and Displays it to the BMI Value Label
     */
    private void calculateBMI() {
        double h = this.getHeight_() / 100;
        this.setBmi(this.getWeight() / (h * h));
        String bmiLblTxt = "" + getBmi() + "";
        lblBMIValue.setText(bmiLblTxt.substring(0, 5));
        showMessage();
    }
    /**
     * calculates Ideal Weight
     * @return Double : the Ideal weight of the person
     */
    private double calculateIdealWeight() {
        if (this.height != 0) {
            double inchesHeight;
            double finalIdealWeightKG = 0;
            if ("CM".equals(this.heightUnit)) {
                inchesHeight = this.height * 0.393701;
            }
            else {
                inchesHeight = this.height * 0.393701;
            }
            double inchesOver5Feet = inchesHeight - 60.0;
            if (this.gender.equals("FEMALE")) {
                finalIdealWeightKG = 53.1 + (1.36 * inchesOver5Feet);
                this.idealWeight = finalIdealWeightKG;
            } else if (!this.gender.equals("MALE")) {
                if (this.weightUnit.equals("KG")) {
                    lblIdealWeightValue.setText("0.0KG");
                } else {
                    lblIdealWeightValue.setText("0.0LBS");
                    return 0.0;
                }
            } else {
                finalIdealWeightKG = 56.2 + (1.41 * inchesOver5Feet);
                this.idealWeight = finalIdealWeightKG;
            }
            if (finalIdealWeightKG >= 200.0) {
                if (this.weightUnit.equals("KG")) {
                    lblIdealWeightValue.setText("0.0" + "KG");
                } else {
                    lblIdealWeightValue.setText("0.0" + "LBS");
                    return 0.0;
                }
            }
            if ("KG".equals(this.weightUnit)) {
                String temp = "" + this.getIdealWeight();
                lblIdealWeightValue.setText(temp.substring(0, 6) + "KG");
                return finalIdealWeightKG;
            } else if (!this.weightUnit.equals("LB+ST") && !this.weightUnit.equals("LB")) {
                lblIdealWeightValue.setText("0.0");
                return 0.0;
            } else {
                String temp = "" + this.getIdealWeight() * 2.20462;
                lblIdealWeightValue.setText(temp.substring(0,6) + "LBS");
                return finalIdealWeightKG * 2.20462;
            }
        }
        return 0;
    }
    /**
     * Calculates FAT
     * @return Double: FAT
     */
    private double calculateFAT() {
        int i = 1;
        if (this.bmi > 100 || this.age < 1) {
            this.lblFATValue.setText("0.0 %");
            return 0;
        }
        double f = (1.2 * this.bmi) + (0.23 * this.age);
        if (!this.gender.equals("MALE")) {
            i = 0;
        }
        this.fat = (f - (((float) i) * 10.8)) - 5.4;
        if (this.fat < 100.0f && this.fat >= 0 ) {
            String temp = "" + this.fat;
            this.lblFATValue.setText("" + temp.substring(0, 5) + "%");
            return this.fat;
        }
        lblFATValue.setText("0%");
        return 0;
    }
    /**
     * Displays a message after BMI Calculation on the
     * basis of BMI Value and changes the message colour accordingly
     */
    private void showMessage(){
        if (this.bmi < 16) {
            lblMessage.setText("YOU NEED SOME BITES");
            lblMessage.setForeground(Color.red);
        } else if (bmi >= 16 && bmi < 17   ) {
            lblMessage.setText("TIME FOR A RUN!!!");
            lblMessage.setForeground(Color.pink);
        } else if (bmi >= 17 && bmi < 18.5) {
            lblMessage.setText("TIME FOR A RUN..");
            lblMessage.setForeground(Color.yellow);
        } else if (bmi >= 18.5 && bmi < 25) {
            lblMessage.setText("GREAT SHAPE!");
            lblMessage.setForeground(Color.green);
        } else if (bmi >= 25 && bmi < 30) {
            lblMessage.setText("TIME FOR A RUN..");
            lblMessage.setForeground(Color.yellow);
        } else if (bmi >= 30 && bmi < 35) {
            lblMessage.setText("TIME FOR A RUN..");
            lblMessage.setForeground(Color.red);
        } else if (bmi >= 40 ) {
            lblMessage.setText("LOT OF BMI WIEGH YOURSELD DOWN!!!");
            lblMessage.setForeground(Color.red);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textAge = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        textHeightCM = new javax.swing.JTextField();
        textHeightFeet = new javax.swing.JTextField();
        textHeightInches = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        textWeight = new javax.swing.JTextField();
        textWeightLB = new javax.swing.JTextField();
        textWeightSt = new javax.swing.JTextField();
        dropDownGender = new javax.swing.JComboBox<>();
        dropDownHeightUnit = new javax.swing.JComboBox<>();
        dropDownWeightUnit = new javax.swing.JComboBox<>();
        lblBMI = new javax.swing.JLabel();
        lblBMIValue = new javax.swing.JLabel();
        lblIdealWeight = new javax.swing.JLabel();
        lblIdealWeightValue = new javax.swing.JLabel();
        lblFAT = new javax.swing.JLabel();
        lblFATValue = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(10, 143, 8));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BMI CALCULATOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setForeground(new java.awt.Color(10, 143, 8));
        jLabel2.setText("Age");

        jLabel3.setForeground(new java.awt.Color(10, 143, 8));
        jLabel3.setText("Height");

        jLabel4.setForeground(new java.awt.Color(10, 143, 8));
        jLabel4.setText("Weight");

        textAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textAgeFocusLost(evt);
            }
        });
        textAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAgeKeyTyped(evt);
            }
        });

        jPanel2.setLayout(null);

        textHeightCM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textHeightCMFocusLost(evt);
            }
        });
        textHeightCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHeightCMActionPerformed(evt);
            }
        });
        textHeightCM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHeightCMKeyTyped(evt);
            }
        });
        jPanel2.add(textHeightCM);
        textHeightCM.setBounds(15, 10, 140, 20);

        textHeightFeet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textHeightFeetFocusLost(evt);
            }
        });
        textHeightFeet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHeightFeetActionPerformed(evt);
            }
        });
        textHeightFeet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHeightFeetKeyTyped(evt);
            }
        });
        jPanel2.add(textHeightFeet);
        textHeightFeet.setBounds(20, 10, 70, 20);

        textHeightInches.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textHeightInchesFocusLost(evt);
            }
        });
        textHeightInches.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHeightInchesKeyTyped(evt);
            }
        });
        jPanel2.add(textHeightInches);
        textHeightInches.setBounds(90, 10, 60, 20);

        jPanel3.setLayout(null);

        textWeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textWeightFocusLost(evt);
            }
        });
        textWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWeightActionPerformed(evt);
            }
        });
        textWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textWeightKeyTyped(evt);
            }
        });
        jPanel3.add(textWeight);
        textWeight.setBounds(15, 10, 140, 20);

        textWeightLB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textWeightLBFocusLost(evt);
            }
        });
        textWeightLB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWeightLBActionPerformed(evt);
            }
        });
        textWeightLB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textWeightLBKeyTyped(evt);
            }
        });
        jPanel3.add(textWeightLB);
        textWeightLB.setBounds(20, 10, 60, 20);

        textWeightSt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textWeightStFocusLost(evt);
            }
        });
        textWeightSt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textWeightStKeyTyped(evt);
            }
        });
        jPanel3.add(textWeightSt);
        textWeightSt.setBounds(80, 10, 70, 20);

        dropDownGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        dropDownGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownGenderActionPerformed(evt);
            }
        });

        dropDownHeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CM", "FT+IN" }));
        dropDownHeightUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownHeightUnitActionPerformed(evt);
            }
        });

        dropDownWeightUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "LB", "LB+ST" }));
        dropDownWeightUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownWeightUnitActionPerformed(evt);
            }
        });

        lblBMI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBMI.setForeground(new java.awt.Color(10, 143, 8));
        lblBMI.setText("BMI");

        lblBMIValue.setForeground(new java.awt.Color(10, 143, 8));
        lblBMIValue.setText("0");

        lblIdealWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIdealWeight.setForeground(new java.awt.Color(10, 143, 8));
        lblIdealWeight.setText("IDEAL WEIGHT");

        lblIdealWeightValue.setForeground(new java.awt.Color(10, 143, 8));
        lblIdealWeightValue.setText("0");

        lblFAT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFAT.setForeground(new java.awt.Color(10, 143, 8));
        lblFAT.setText("FAT");

        lblFATValue.setForeground(new java.awt.Color(10, 143, 8));
        lblFATValue.setText("0");

        lblMessage.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(10, 143, 8));
        jLabel5.setText("BMI CLASSIFICATION");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(233, 89, 86));
        jLabel6.setText("VERY SEVERLY UNDERWEIGHT                           < 16");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(239, 108, 1));
        jLabel7.setText("SEVERLY UNDERWEIGHT                                     16 - 17");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(249, 168, 37));
        jLabel8.setText("UNDERWEIGHT                                                       17 - 18.5");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(92, 152, 18));
        jLabel9.setText("NORMAL                                                                  18.5 - 25");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(249, 168, 37));
        jLabel10.setText("OVERWEIGHT                                                          25  -  30");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(239, 108, 1));
        jLabel11.setText("OBESE CLASS I                                                       30 - 35");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(233, 89, 86));
        jLabel12.setText("OBESE CLASS II                                                      35 - 40");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(229, 28, 35));
        jLabel13.setText("OBESE CLASS III                                                      > 40");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addComponent(textAge, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(lblBMIValue)
                                    .addComponent(lblBMI, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(lblIdealWeightValue)
                                    .addComponent(lblIdealWeight))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(lblFAT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFATValue))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dropDownWeightUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(dropDownGender, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dropDownHeightUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dropDownGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropDownHeightUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(dropDownWeightUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBMI)
                    .addComponent(lblIdealWeight)
                    .addComponent(lblFAT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBMIValue)
                    .addComponent(lblIdealWeightValue)
                    .addComponent(lblFATValue))
                .addGap(18, 18, 18)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**.
     * Nothing to do with any thing
     * @param evt an event
     */
    private void textHeightFeetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHeightFeetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHeightFeetActionPerformed
    /**.
     * Nothing to do with any thing
     * @param evt an event
     */
    private void textWeightLBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWeightLBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWeightLBActionPerformed
    /**.
     * When something is typed in Age text box
     * @param evt an event
     */
    private void textAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAgeKeyTyped
         String temp = textAge.getText();
        if (!Character.isDigit(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
        }
        if(temp.length() > 2){
            temp = temp.substring(0, 2);
            textAge.setText(temp);
        }
    }//GEN-LAST:event_textAgeKeyTyped
    /**.
     * When focus is lost in Age text box
     * @param evt an event
     */
    private void textAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textAgeFocusLost
        if(!"".equals(textAge.getText())){
            this.setAge(Integer.parseInt(textAge.getText()));
            calculateFAT();
        }
    }//GEN-LAST:event_textAgeFocusLost
    /**.
     * When something is typed in Height for CM box
     * @param evt an event
     */
    private void textHeightCMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHeightCMKeyTyped
         String temp = textHeightCM.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.')) {
            getToolkit().beep();
            evt.consume();
        }
        if(temp.length() > 4){
            temp = temp.substring(0, 4);
            textHeightCM.setText(temp);
        }
    }//GEN-LAST:event_textHeightCMKeyTyped
    /**.
     * When something is typed in Height for Feet text box
     * @param evt an event
     */
    private void textHeightFeetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHeightFeetKeyTyped
        String temp = textHeightFeet.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.')) {
            getToolkit().beep();
            evt.consume();
        }

        if(temp.length() > 2){
            temp = temp.substring(0, 2);
            textHeightFeet.setText(temp);
        }
    }//GEN-LAST:event_textHeightFeetKeyTyped
    /**.
     * When something is typed in Height Inches text box
     * @param evt an event
     */
    private void textHeightInchesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHeightInchesKeyTyped
        String temp = textHeightInches.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() =='.')) {
            getToolkit().beep();
            evt.consume();
        }
        if(temp.length() > 3){
            temp = temp.substring(0, 3);
            textHeightInches.setText(temp);
        }
    }//GEN-LAST:event_textHeightInchesKeyTyped
    /**.
     * When Focus is lost in text box
     * @param evt an event
     */
    private void textHeightCMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textHeightCMFocusLost
         if(!"".equals(textHeightCM.getText()) ){
            this.setHeight(Double.parseDouble(textHeightCM.getText()));
            if(this.weight != 0){
                calculateBMI();
                calculateIdealWeight();
            }
        }
    }//GEN-LAST:event_textHeightCMFocusLost
    /**.
     * When Focus is lost in text box
     * @param evt an event
     */
    private void textHeightFeetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textHeightFeetFocusLost
        if(!"".equals(textHeightFeet.getText())){
            double temp = Double.parseDouble(textHeightFeet.getText()) * 12
                    + Double.parseDouble(textHeightInches.getText());
            temp = temp * 2.54;
            this.height = temp;
            if(this.weight != 0){
                calculateBMI();
                calculateIdealWeight();
            }
        }
    }//GEN-LAST:event_textHeightFeetFocusLost
    /**.
     * When Focus is lost in text box
     * @param evt an event
     */
    private void textHeightInchesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textHeightInchesFocusLost
        if (!"".equals(textHeightFeet.getText())) {
            double temp = Double.parseDouble(textHeightFeet.getText()) * 12
                    + Double.parseDouble(textHeightInches.getText());
            temp = temp * 2.54;
            this.height = temp;
            if (this.weight != 0) {
                calculateBMI();
                calculateIdealWeight();
            }
        }
    }//GEN-LAST:event_textHeightInchesFocusLost
    /**.
     * When key is typed in text box
     * @param evt an event
     */
    private void textWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textWeightKeyTyped
        String temp = textWeight.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.')) {
            getToolkit().beep();
            evt.consume();
        }
        if (temp.length() > 4) {
            temp = temp.substring(0, 4);
            textWeight.setText(temp);
        }
    }//GEN-LAST:event_textWeightKeyTyped
    /**.
     * When key is typed in text box
     * @param evt an event
     */
    private void textWeightLBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textWeightLBKeyTyped
         String temp = textWeightLB.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.')) {
            getToolkit().beep();
            evt.consume();
        }
        if (temp.length() > 4) {
            temp = temp.substring(0, 4);
            textWeightLB.setText(temp);
        }
    }//GEN-LAST:event_textWeightLBKeyTyped
    /**.
     * When key is typed in text box
     * @param evt an event
     */
    private void textWeightStKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textWeightStKeyTyped
       String temp = textWeightSt.getText();
        if (!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.')) {
            getToolkit().beep();
            evt.consume();
        }
        if (temp.length() > 2) {
            temp = temp.substring(0, 2);
            textWeightSt.setText(temp);
        }
    }//GEN-LAST:event_textWeightStKeyTyped
    /**.
     * When focus lost from text box
     * @param evt an event
     */
    private void textWeightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textWeightFocusLost
        if (dropDownWeightUnit.getSelectedIndex() == 0) {
            if (!"".equals(textWeight.getText())) {
                this.weight = Double.parseDouble(textWeight.getText());
                if(this.height != 0){
                    calculateBMI();
                    calculateIdealWeight();
                    if(this.age != 0){
                        calculateFAT();
                    }
                }
            }
        }
        if (dropDownWeightUnit.getSelectedIndex() == 1) {
            if (!"".equals(textWeight.getText())) {
                this.weight = Double.parseDouble(textWeight.getText()) * 0.453592;
                if (this.height != 0) {
                    calculateBMI();
                }
            }
        }
    }//GEN-LAST:event_textWeightFocusLost
     /**.
     * When focus lost from text box
     * @param evt an event
     */
    private void textWeightLBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textWeightLBFocusLost
        if(!"".equals(textWeightLB.getText())){
                double temp = Double.parseDouble(textWeightLB.getText()) * 0.453592 +
                              Double.parseDouble(textWeightSt.getText()) * 6.35029;
                this.weight = temp;
                if(this.height != 0){
                    calculateBMI();
                    calculateIdealWeight();
                    if(this.age != 0){
                        calculateFAT();
                    }
                }
            }
    }//GEN-LAST:event_textWeightLBFocusLost
     /**.
     * When focus lost from text box
     * @param evt an event
     */
    private void textWeightStFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textWeightStFocusLost
        if(!"".equals(textWeightLB.getText())){
                double temp = Double.parseDouble(textWeightLB.getText()) * 0.453592 +
                              Double.parseDouble(textWeightSt.getText()) * 6.35029;
                this.weight = temp;
                if(this.height != 0){
                    calculateBMI();
                    calculateIdealWeight();
                    if(this.age != 0){
                        calculateFAT();
                    }
                }
            }
    }//GEN-LAST:event_textWeightStFocusLost
     /**.
     * When drop down changes value
     * @param evt an event
     */
    private void dropDownWeightUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownWeightUnitActionPerformed
        if (dropDownWeightUnit.getSelectedIndex() == 0) {
            textWeightLB.hide();
            textWeightSt.hide();
            textWeight.show();
            this.weightUnit = "KG";
            if (this.idealWeight != 0 ) {
                String temp = "" + this.getIdealWeight();
                lblIdealWeightValue.setText(temp.substring(0,6) + "KG");
            }
        } else if (dropDownWeightUnit.getSelectedIndex() == 1) {
            this.weightUnit = "LB";
            textWeightLB.hide();
            textWeightSt.hide();
            textWeight.show();
            if (this.idealWeight != 0) {
                String temp = "" + this.getIdealWeight() * 2.20462;
                lblIdealWeightValue.setText(temp.substring(0,6) + "LBS");
            }
        } else if (dropDownWeightUnit.getSelectedIndex() == 2) {
            this.weightUnit = "LB+ST";
            textWeightLB.show();
            textWeightSt.show();
            textWeight.hide();
            if (this.idealWeight != 0) {
                String temp = "" + this.getIdealWeight() * 2.20462;
                lblIdealWeightValue.setText(temp.substring(0,6) + "LBS");
            }
        }
    }//GEN-LAST:event_dropDownWeightUnitActionPerformed
    /**.
     * When drop down changes value
     * @param evt an event
     */
    private void dropDownHeightUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownHeightUnitActionPerformed
        if (dropDownHeightUnit.getSelectedIndex() == 0) {
            textHeightCM.show();
            textHeightFeet.hide();
            textHeightInches.hide();
            this.heightUnit = "CM";
        }
        if (dropDownHeightUnit.getSelectedIndex() == 1) {
            textHeightCM.hide();
            textHeightFeet.show();
            textHeightInches.show();
            this.heightUnit = "FT+IN";
        }
    }//GEN-LAST:event_dropDownHeightUnitActionPerformed
    /**.
     * When drop down changes value
     * @param evt an event
     */
    private void dropDownGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownGenderActionPerformed
        if (dropDownGender.getSelectedIndex() == 0) {
            this.gender = "MALE";
            calculateFAT();

        } else {
            this.gender = "FEMALE";
            calculateFAT();
        }
        calculateIdealWeight();
    }//GEN-LAST:event_dropDownGenderActionPerformed
    /**.
     * When drop down changes value
     * @param evt an event
     */
    private void textHeightCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHeightCMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHeightCMActionPerformed
    /**.
     * When drop down changes value
     * @param evt an event
     */
    private void textWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWeightActionPerformed

    /**.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(BMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BMI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BMI().setVisible(true);
            }
        });
    }
    // Variable declaration - modifiable
    private int age;
    private double height;
    private double weight;
    private String gender;
    private String weightUnit;
    private String heightUnit;
    private double bmi;
    private double idealWeight;
    private double fat;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dropDownGender;
    private javax.swing.JComboBox<String> dropDownHeightUnit;
    private javax.swing.JComboBox<String> dropDownWeightUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBMI;
    private javax.swing.JLabel lblBMIValue;
    private javax.swing.JLabel lblFAT;
    private javax.swing.JLabel lblFATValue;
    private javax.swing.JLabel lblIdealWeight;
    private javax.swing.JLabel lblIdealWeightValue;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField textAge;
    private javax.swing.JTextField textHeightCM;
    private javax.swing.JTextField textHeightFeet;
    private javax.swing.JTextField textHeightInches;
    private javax.swing.JTextField textWeight;
    private javax.swing.JTextField textWeightLB;
    private javax.swing.JTextField textWeightSt;
    // End of variables declaration//GEN-END:variables
}
