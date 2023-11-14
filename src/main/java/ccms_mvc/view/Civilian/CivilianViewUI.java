package ccms_mvc.view.Civilian;

import ccms_mvc.controller.Civilian.CivilianViewCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.Person;
import java.util.ArrayList;

/**
 *
 * @author Tiffany Dove
 */
public class CivilianViewUI extends javax.swing.JFrame {

    //Reference to Person Controller
    private CivilianViewCntl civilianViewCntl;
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
    public CivilianViewUI(CivilianViewCntl civilianViewCntl) {
        this.civilianViewCntl = civilianViewCntl;
        initComponents();
        arrayListPerson = civilianViewCntl.getListOfPerson();
        arrayListCourtCases = civilianViewCntl.getListOfCourtCases();
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
        this.btnMainMenu.setEnabled(enabled);
        this.btnSearch.setEnabled(enabled);
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

        civilianViewCaseDetailsPanel = new javax.swing.JPanel();
        ccmsLabel = new javax.swing.JLabel();
        caseNumberLabel = new javax.swing.JLabel();
        caseNumberTextField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        civilianViewCaseDetailsLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        partyNameLabel = new javax.swing.JLabel();
        partyNameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        civilianViewCaseDetailsPanel.setToolTipText("Person Panel");

        ccmsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ccmsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ccmsLabel.setText("Court Case Managment System");
        ccmsLabel.setToolTipText("");

        caseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseNumberLabel.setText("Case Number:");

        caseNumberTextField.setToolTipText("Please enter ID num.");
        caseNumberTextField.setName("caseNumberTextField"); // NOI18N

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setToolTipText("Search Judge for Specifiic Case");

        btnMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMainMenu.setText("Civilian Main Menu");
        btnMainMenu.setToolTipText("Return to Civilan Main Menu");

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("exit the application");

        civilianViewCaseDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        civilianViewCaseDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        civilianViewCaseDetailsLabel.setText("Civilian - View Case Details");
        civilianViewCaseDetailsLabel.setToolTipText("");

        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setToolTipText("");

        partyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partyNameLabel.setText("Party Name:");

        javax.swing.GroupLayout civilianViewCaseDetailsPanelLayout = new javax.swing.GroupLayout(civilianViewCaseDetailsPanel);
        civilianViewCaseDetailsPanel.setLayout(civilianViewCaseDetailsPanelLayout);
        civilianViewCaseDetailsPanelLayout.setHorizontalGroup(
            civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(civilianViewCaseDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(68, 68, 68)
                        .addComponent(btnMainMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuit))
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(partyNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caseNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, 94))
        );
        civilianViewCaseDetailsPanelLayout.setVerticalGroup(
            civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(civilianViewCaseDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caseNumberLabel)
                    .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(btnMainMenu))
                    .addComponent(btnQuit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(civilianViewCaseDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(civilianViewCaseDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSearch;
    private javax.swing.JLabel caseNumberLabel;
    private javax.swing.JTextField caseNumberTextField;
    private javax.swing.JLabel ccmsLabel;
    private javax.swing.JLabel civilianViewCaseDetailsLabel;
    private javax.swing.JPanel civilianViewCaseDetailsPanel;
    public javax.swing.JLabel errorMessage;
    public javax.swing.JLabel partyNameLabel;
    public javax.swing.JTextField partyNameTextField;
    // End of variables declaration//GEN-END:variables

}
