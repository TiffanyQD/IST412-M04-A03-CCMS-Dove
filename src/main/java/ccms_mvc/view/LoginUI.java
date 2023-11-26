package ccms_mvc.view;

import ccms_mvc.controller.LoginIdCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.Person;
import java.util.ArrayList;

/**
 *
 * @author Tiffany Dove
 */
public class LoginUI extends javax.swing.JFrame {

    //Reference to Login Id Controller
    private LoginIdCntl loginIdCntl;
    //An arrayList of Person
    private ArrayList<Person> arrayListPerson;  
    //An arrayList of Court Cases
    private ArrayList<CourtCases> arrayListCourtCases;  
    //Counter of the current Person
    private int indexOfCurrentPerson = 0;
    //Reference to Person class
    private Person person;

    public int getIndexOfCurrentPerson() {
        return indexOfCurrentPerson;
    }

    public void setIndexOfCurrentPerson(int indexOfCurrentPerson) {
        this.indexOfCurrentPerson = indexOfCurrentPerson;
    }
            
    /**
     * Creates new form PersonUI
     */
    public LoginUI(LoginIdCntl loginIdCntl) {
        this.loginIdCntl = loginIdCntl;
        initComponents();
//        arrayListPerson = loginIdCntl.getListOfPerson();
//        arrayListCourtCases = loginIdCntl.getListOfCourtCases();
        //Get a Person occurrence from the arrayList using the current position.
        //namely current person.
//        person = arrayListPerson.get(indexOfCurrentPerson);
        //Using the Person (person) class, take the values and populate
        //the UI.


//        parsePerson(person);
//        parseLogIn();
    }

//    public void parsePerson(Person person) {
//        //set the UI's id num text field with the id num from Person
//        loginIdTextField.setText(String.valueOf(person.getIdNum()));
//        //set the UI's name text field with the name from Person
//        passwordTextField.setText(person.getName());
//        //set the UI's address text field with the address from Person
//        addressTextField.setText(person.getAddress());
//        //set the UI's city text field with the city from Person
//        cityTextField.setText(person.getCity());
//        //set the UI's state text field with the state from Person
//        stateTextField.setText(person.getState());
//        //set the UI's zip code text field with the zip code from Person
//        zipCodeTextField.setText(String.valueOf(person.getZipCode()));
//    }


    public void clearTheFieldsInLoginUI() {
        //set the UI's id num text field with the id num from Person
        loginIdTextField.setText("");
        //set the UI's name text field with the name from Person
        passwordTextField.setText("");
        //set the UI's address text field with the address from Person
    }


    public String getLoginIdTextField(){
        return loginIdTextField.getText();
    }

    public void setLoginIdTextField(String loginTextFieldString){
        this.loginIdTextField.setText(loginTextFieldString);
    }

    public String getPasswordTextField(){
        return passwordTextField.getText();
    }

    public void setErrorMessageLabel(String errorMessageLabel){
        this.errorMessageLabel.setText(errorMessageLabel);
    }

    public void setPasswordTextField(String passwordTextFieldString){
        this.passwordTextField.setText(passwordTextFieldString);
    }

    public void enableButtons(boolean enabled){
        this.btnSubmit.setEnabled(enabled);
        this.btnQuit.setEnabled(enabled);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        courtCaseManagementPanel = new javax.swing.JPanel();
        courtCaseManagementLabel = new javax.swing.JLabel();
        idNumLabel = new javax.swing.JLabel();
        loginIdTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        courtCaseManagementPanel.setToolTipText("Person Panel");

        courtCaseManagementLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        courtCaseManagementLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courtCaseManagementLabel.setText("Court Case Management System");
        courtCaseManagementLabel.setToolTipText("");

        idNumLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        idNumLabel.setText("Login ID:");

        loginIdTextField.setToolTipText("Please enter a Login Id");
        loginIdTextField.setName("loginIdTextField"); // NOI18N

        passwordTextField.setToolTipText("Please enter a password.");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nameLabel.setText("Password:");

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("exit the application");

        errorMessageLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout courtCaseManagementPanelLayout = new javax.swing.GroupLayout(courtCaseManagementPanel);
        courtCaseManagementPanel.setLayout(courtCaseManagementPanelLayout);
        courtCaseManagementPanelLayout.setHorizontalGroup(
            courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courtCaseManagementPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courtCaseManagementLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(courtCaseManagementPanelLayout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuit)
                        .addGap(193, 193, 193))
                    .addGroup(courtCaseManagementPanelLayout.createSequentialGroup()
                        .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(errorMessageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(courtCaseManagementPanelLayout.createSequentialGroup()
                                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idNumLabel)
                                    .addComponent(nameLabel))
                                .addGap(54, 54, 54)
                                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(passwordTextField))
                                .addGap(150, 150, 150)))
                        .addContainerGap(182, Short.MAX_VALUE))))
        );
        courtCaseManagementPanelLayout.setVerticalGroup(
            courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courtCaseManagementPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(courtCaseManagementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idNumLabel)
                    .addComponent(loginIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addGroup(courtCaseManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnQuit))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(courtCaseManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(courtCaseManagementPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSubmit;
    private javax.swing.JLabel courtCaseManagementLabel;
    private javax.swing.JPanel courtCaseManagementPanel;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JLabel idNumLabel;
    private javax.swing.JTextField loginIdTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passwordTextField;
    // End of variables declaration//GEN-END:variables

}
