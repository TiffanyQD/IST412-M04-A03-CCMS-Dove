package ccms_mvc.view.Lawyer;

import ccms_mvc.controller.Lawyer.LawyerSearchCntl;
import ccms_mvc.model.CourtCases;
import java.util.List;
import javax.swing.JTextField;

/**
 * This class sets up the is LawyerSearchUI Form.
 *
 * @author Tiffany Dove
 */
public class LawyerSearchUI extends javax.swing.JFrame {

    //Reference to ClerkSearchCntl Controller
    private LawyerSearchCntl lawyerSearchCntl;

    //Array List of Court Cases
    private List<CourtCases> listCourtCases;

    //Counter of the current Court Case
    private int indexOfCurrentCourtCase = 0;

    //Reference to CourtCases class
    private CourtCases courtCases;

    //Boolean variable to check if this is the first execution
    private boolean blnFirstTime = true;

    //Get the index of the current court case
    public int getIndexOfCurrentCourtCase() {
        return indexOfCurrentCourtCase;
    }

    //Set the index of the current court case
    public void setIndexOfCurrentCourtCase(int indexOfCurrentCourtCase) {
        this.indexOfCurrentCourtCase = indexOfCurrentCourtCase;
    }

    /**
     * Creates new form LawyerSearchUI
     */
    public LawyerSearchUI(LawyerSearchCntl lawyerSearchCntl) {
        this.lawyerSearchCntl = lawyerSearchCntl;
        initComponents();

        //Retrieve a list of all of the court cases
        listCourtCases = lawyerSearchCntl.getArrayListCourtCases();

        if (blnFirstTime) {
            clearTheFieldsInCourtCasesUI();
            blnFirstTime = false;
        } else {
            //Retreive a specific court case from the list of court cases.
            courtCases = listCourtCases.get(indexOfCurrentCourtCase);

            //Using the CourtCase class, take the values and populate
            //the UI.
            parseCourtCases(courtCases);
        }
    }

    /**
     * Parse the Court Cases
     */
    public void parseCourtCases(CourtCases courtCases) {

        //Set the Court System field
        this.courtSystemTextField.setText(courtCases.getCourtSystem().name());

        //Set the CourtLocation field
        this.locationTextField.setText(courtCases.getLocation().name());

        //Set the Case Number field
        this.caseNumberTextField.setText(courtCases.getCaseNumber());

        //Set the Party Name field
        this.partyNameTextField.setText(courtCases.getPartyName());

        //Set the Case Type field
        this.caseTypeTextField.setText(courtCases.getCaseType().name());

        //Set the Filing Data field
        this.filingDateTextField.setText(courtCases.getFilingDate());

        //Set the Case Status 
        this.caseStatusTextField.setText(courtCases.getCaseStatus().name());

    }

    /**
     * Clear the Fields in the Court Case UI
     */
    public void clearTheFieldsInCourtCasesUI() {

        //Set the Court System field
        this.courtSystemTextField.setText("");

        //Set the CourtLocation field
        this.locationTextField.setText("");

        //Set the Case Number field
        this.caseNumberTextField.setText("");

        //Set the Party Name field
        this.partyNameTextField.setText("");

        //Set the Case Type field
        this.caseTypeTextField.setText("");

        //Set the Filing Data field
        this.filingDateTextField.setText("");

        //Set the Case Status 
        this.caseStatusTextField.setText("");

    }

    public JTextField getCaseStatusTextField() {
        return caseStatusTextField;
    }

    public void setCaseStatusTextField(JTextField caseStatusTextField) {
        this.caseStatusTextField = caseStatusTextField;
    }

    public JTextField getCaseTypeTextField() {
        return caseTypeTextField;
    }

    public void setCaseTypeTextField(JTextField caseTypeTextField) {
        this.caseTypeTextField = caseTypeTextField;
    }

    public JTextField getCourtSystemTextField() {
        return courtSystemTextField;
    }

    public void setCourtSystemTextField(JTextField courtSystemTextField) {
        this.courtSystemTextField = courtSystemTextField;
    }

    public JTextField getFilingDateTextField() {
        return filingDateTextField;
    }

    public void setFilingDateTextField(JTextField filingDateTextField) {
        this.filingDateTextField = filingDateTextField;
    }

    public JTextField getLocationTextField() {
        return locationTextField;
    }

    public void setLocationTextField(JTextField locationTextField) {
        this.locationTextField = locationTextField;
    }

    public JTextField getPartyNameTextField() {
        return partyNameTextField;
    }

    public void setPartyNameTextField(JTextField partyNameTextField) {
        this.partyNameTextField = partyNameTextField;
    }

    //Get the Case Number field
    public String getCaseNumberTextField() {
        return caseNumberTextField.getText();
    }

    //Set the Case Number field
    public void setCaseNumberTextField(String caseNumberTextFieldString) {
        this.caseNumberTextField.setText(caseNumberTextFieldString);
    }

    /**
     * Enable the buttons in the UI
     */
    public void enableButtons(boolean enabled) {
        this.btnLawyerMainMenu.setEnabled(enabled);
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

        searchSpecificCasesPanel = new javax.swing.JPanel();
        ccmsLabel = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnLawyerMainMenu = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        searchSpecificCasesLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        courtSystemLabel = new javax.swing.JLabel();
        courtSystemTextField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        locationTextField = new javax.swing.JTextField();
        caseNumberLabel = new javax.swing.JLabel();
        caseNumberTextField = new javax.swing.JTextField();
        partyNameLabel = new javax.swing.JLabel();
        partyNameTextField = new javax.swing.JTextField();
        caseTypeLabel = new javax.swing.JLabel();
        caseTypeTextField = new javax.swing.JTextField();
        filingDateLabel = new javax.swing.JLabel();
        filingDateTextField = new javax.swing.JTextField();
        caseStatusLabel = new javax.swing.JLabel();
        caseStatusTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchSpecificCasesPanel.setToolTipText("Lawyer Search Specific Cases Panel");

        ccmsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ccmsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ccmsLabel.setText("Court Case Managment System");
        ccmsLabel.setToolTipText("Court Case Managment System");

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setToolTipText("Search for Specifiic Case");

        btnLawyerMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLawyerMainMenu.setText("Lawyer Main Menu");
        btnLawyerMainMenu.setToolTipText("Return to Clerk Main Menu");

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("Exit the Application");

        searchSpecificCasesLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchSpecificCasesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchSpecificCasesLabel.setText("Lawyer - Search Specific Cases");
        searchSpecificCasesLabel.setToolTipText("Search Specific Cases for Clerk");

        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setToolTipText("");

        courtSystemLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        courtSystemLabel.setText("Court System:");
        courtSystemLabel.setToolTipText("Court System:");

        courtSystemTextField.setEditable(false);
        courtSystemTextField.setToolTipText("Please enter one of the following CIRCUIT, DISTRIC");
        courtSystemTextField.setName("caseNumberTextField"); // NOI18N

        locationLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        locationLabel.setText("Location:");
        locationLabel.setToolTipText("Location:");

        locationTextField.setEditable(false);
        locationTextField.setToolTipText("Please enter one of the following: BALTIMORE, BALTIMORE_CITY, PRINCE_GEORGE, MONTGOMERY");
        locationTextField.setName("caseNumberTextField"); // NOI18N

        caseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseNumberLabel.setText("Case Number:");
        caseNumberLabel.setToolTipText("Case Number:");

        caseNumberTextField.setToolTipText("Please Enter a Case Number (i.e.. 11111)");
        caseNumberTextField.setName("caseNumberTextField"); // NOI18N

        partyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partyNameLabel.setText("Party Name:");
        partyNameLabel.setToolTipText("Party Name:");

        partyNameTextField.setEditable(false);
        partyNameTextField.setToolTipText("Party Name Field");

        caseTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseTypeLabel.setText("Case Type:");
        caseTypeLabel.setToolTipText("Case Type:");

        caseTypeTextField.setEditable(false);
        caseTypeTextField.setToolTipText("Please enter one of the following: CIVIL, CRIMINAL, TRAFFIC, CIVIL_ACTION");
        caseTypeTextField.setName("caseNumberTextField"); // NOI18N

        filingDateLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        filingDateLabel.setText("Filing Date:");
        filingDateLabel.setToolTipText("Filing Date:");

        filingDateTextField.setEditable(false);
        filingDateTextField.setToolTipText("Court System Text Field");
        filingDateTextField.setName("caseNumberTextField"); // NOI18N

        caseStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseStatusLabel.setText("Case Status:");
        caseStatusLabel.setToolTipText("Case Status:");

        caseStatusTextField.setEditable(false);
        caseStatusTextField.setToolTipText("Please enter one of the following: OPEN, CLOSED, POSTPONED");
        caseStatusTextField.setName("caseNumberTextField"); // NOI18N

        javax.swing.GroupLayout searchSpecificCasesPanelLayout = new javax.swing.GroupLayout(searchSpecificCasesPanel);
        searchSpecificCasesPanel.setLayout(searchSpecificCasesPanelLayout);
        searchSpecificCasesPanelLayout.setHorizontalGroup(
            searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                                .addComponent(partyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchSpecificCasesPanelLayout.createSequentialGroup()
                                        .addComponent(caseNumberLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(caseTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                                                .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchSpecificCasesPanelLayout.createSequentialGroup()
                                                .addComponent(courtSystemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(courtSystemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(caseStatusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(filingDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caseStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filingDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(caseTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnLawyerMainMenu)
                        .addGap(82, 82, 82)
                        .addComponent(btnQuit)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchSpecificCasesPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchSpecificCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175))
        );
        searchSpecificCasesPanelLayout.setVerticalGroup(
            searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchSpecificCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(caseNumberLabel)
                        .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(caseTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(caseTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filingDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caseStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filingDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchSpecificCasesPanelLayout.createSequentialGroup()
                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courtSystemLabel)
                            .addComponent(courtSystemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel)
                            .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(searchSpecificCasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnLawyerMainMenu)
                    .addComponent(btnQuit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchSpecificCasesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchSpecificCasesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLawyerMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSearch;
    private javax.swing.JLabel caseNumberLabel;
    private javax.swing.JTextField caseNumberTextField;
    public javax.swing.JLabel caseStatusLabel;
    private javax.swing.JTextField caseStatusTextField;
    public javax.swing.JLabel caseTypeLabel;
    private javax.swing.JTextField caseTypeTextField;
    private javax.swing.JLabel ccmsLabel;
    private javax.swing.JLabel courtSystemLabel;
    private javax.swing.JTextField courtSystemTextField;
    public javax.swing.JLabel errorMessage;
    public javax.swing.JLabel filingDateLabel;
    private javax.swing.JTextField filingDateTextField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    public javax.swing.JLabel partyNameLabel;
    public javax.swing.JTextField partyNameTextField;
    private javax.swing.JLabel searchSpecificCasesLabel;
    private javax.swing.JPanel searchSpecificCasesPanel;
    // End of variables declaration//GEN-END:variables

}
