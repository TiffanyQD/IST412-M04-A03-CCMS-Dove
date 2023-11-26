package ccms_mvc.view.Clerk;

import ccms_mvc.controller.Clerk.ClerkViewCntl;
import ccms_mvc.controller.Judge.JudgeViewCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.Person;
import java.util.ArrayList;

/**
 *
 * @author Tiffany Dove
 */
public class ClerkAddDetails extends javax.swing.JFrame {

    //Reference to Person Controller
    private ClerkViewCntl clerkViewCntl;
    //An arrayList of Person
    private ArrayList<Person> arrayListPerson;  
    //An arrayList of Person
    private ArrayList<CourtCases> arrayListCourtCases;  
    //Counter of the current Person
    private int indexOfCurrentPerson = 0;
    //Reference to Person class
    private Person person;

    public int getIndexOfCurrentPerson() {
        return indexOfCurrentPerson;
    }
            
            
    /**
     * Creates new form PersonUI
     */
    public ClerkAddDetails(ClerkViewCntl clerkViewCntl) {
        this.clerkViewCntl = clerkViewCntl;
        initComponents();
        arrayListPerson = clerkViewCntl.getListOfPerson();
        arrayListCourtCases = clerkViewCntl.getListOfCourtCases();
        //Get a Person occurrence from the arrayList using the current position.
        //namely current person.
        person = arrayListPerson.get(indexOfCurrentPerson);
        //Using the Person (person) class, take the values and populate
        //the UI.

//        parsePerson(person);
    }

//    public void parsePerson(Person person) {
//        //set the UI's id num text field with the id num from Person
//        idNumTextField.setText(String.valueOf(person.getIdNum()));
//        //set the UI's name text field with the name from Person
//        nameTextField.setText(person.getName());
//        //set the UI's address text field with the address from Person
//        addressTextField.setText(person.getAddress());
//        //set the UI's city text field with the city from Person
//        cityTextField.setText(person.getCity());
//        //set the UI's state text field with the state from Person
//        stateTextField.setText(person.getState());
//        //set the UI's zip code text field with the zip code from Person
//        zipCodeTextField.setText(String.valueOf(person.getZipCode()));
//    }

    public void clearTheFieldsInPersonUI() {
        //set the UI's id num text field with the id num from Person
        caseNumberTextField.setText("");
    }


    public String getCaseNumberTextField(){
        return caseNumberTextField.getText();
    }

    public void setCaseNumberTextField(String caseNumberTextFieldString){
        this.caseNumberTextField.setText(caseNumberTextFieldString);
    }

    public void setPartyName(String partyNameTextFieldString){
        this.partyNameTextField.setText(partyNameTextFieldString);
    }

    public void enableButtons(boolean enabled){
        this.btnClerkMainMenu.setEnabled(enabled);
        this.btnView.setEnabled(enabled);
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

        clerkViewCaseDetailsPanel = new javax.swing.JPanel();
        ccmsLabel = new javax.swing.JLabel();
        caseNumberLabel = new javax.swing.JLabel();
        caseNumberTextField = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        btnClerkMainMenu = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        clerkViewCaseDetailsLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        partyNameLabel = new javax.swing.JLabel();
        partyNameTextField = new javax.swing.JTextField();
        partyNameLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clerkViewCaseDetailsPanel.setToolTipText("Clerk - View Case Details");

        ccmsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ccmsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ccmsLabel.setText("Court Case Managment System");
        ccmsLabel.setToolTipText("Court Case Managment System");

        caseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseNumberLabel.setText("Case Number:");
        caseNumberLabel.setToolTipText("Case Number:");

        caseNumberTextField.setToolTipText("Please Enter a Case Number (i.e. 11111)");
        caseNumberTextField.setName("caseNumberTextField"); // NOI18N

        btnView.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnView.setText("View");
        btnView.setToolTipText("View Case Details for Clerk");

        btnClerkMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnClerkMainMenu.setText("Clerk Main Menu");
        btnClerkMainMenu.setToolTipText("Return to Clerk Main Menu");

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("exit the application");

        clerkViewCaseDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clerkViewCaseDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clerkViewCaseDetailsLabel.setText("Clerk - Add Case Details");
        clerkViewCaseDetailsLabel.setToolTipText("View Case Details for Clerk");

        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setToolTipText("");

        partyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partyNameLabel.setText("Party Name:");
        partyNameLabel.setToolTipText("Party Name:");

        partyNameTextField.setToolTipText("Party Name Field");

        partyNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partyNameLabel1.setText("Court Case Details:");
        partyNameLabel1.setToolTipText("Party Name:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout clerkViewCaseDetailsPanelLayout = new javax.swing.GroupLayout(clerkViewCaseDetailsPanel);
        clerkViewCaseDetailsPanel.setLayout(clerkViewCaseDetailsPanelLayout);
        clerkViewCaseDetailsPanelLayout.setHorizontalGroup(
            clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clerkViewCaseDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
            .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnClerkMainMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuit))
                    .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(partyNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caseNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(partyNameLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, 94))
        );
        clerkViewCaseDetailsPanelLayout.setVerticalGroup(
            clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(clerkViewCaseDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caseNumberLabel)
                    .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clerkViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addComponent(partyNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126)
                .addGroup(clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clerkViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(btnClerkMainMenu))
                    .addComponent(btnQuit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(clerkViewCaseDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clerkViewCaseDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClerkMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnView;
    private javax.swing.JLabel caseNumberLabel;
    private javax.swing.JTextField caseNumberTextField;
    private javax.swing.JLabel ccmsLabel;
    private javax.swing.JLabel clerkViewCaseDetailsLabel;
    private javax.swing.JPanel clerkViewCaseDetailsPanel;
    public javax.swing.JLabel errorMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel partyNameLabel;
    public javax.swing.JLabel partyNameLabel1;
    public javax.swing.JTextField partyNameTextField;
    // End of variables declaration//GEN-END:variables

}