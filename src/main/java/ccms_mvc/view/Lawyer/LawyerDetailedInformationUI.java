package ccms_mvc.view.Lawyer;

import ccms_mvc.controller.Lawyer.LawyerDetailedInformationCntl;
import ccms_mvc.model.CourtCases;
import java.util.List;
import lombok.Getter;

/**
 * This class sets up the is LawyerDetailedInformationUI Form.
 *
 * @author Tiffany Dove
 */
@Getter
public class LawyerDetailedInformationUI extends javax.swing.JFrame {

    //Reference to LawyerDetailedInformationCntl Controller
    private LawyerDetailedInformationCntl lawyerDetailedInformationCntl;

    //Array List of Court Cases
    private List<CourtCases> listCourtCases;

    //Counter of the current Court Case
    private int indexOfCurrentCourtCase = 0;

    //Reference to CourtCases class
    private CourtCases courtCases;

    //Get the index of the current court case
    public int getIndexOfCurrentCourtCase() {
        return indexOfCurrentCourtCase;
    }

    //Set the index of the current court case
    public void setIndexOfCurrentCourtCase(int indexOfCurrentCourtCase) {
        this.indexOfCurrentCourtCase = indexOfCurrentCourtCase;
    }

    /**
     * Creates new form LawyerDetailedInformationUI
     */
    public LawyerDetailedInformationUI(LawyerDetailedInformationCntl lawyerDetailedInformationCntl) {
        this.lawyerDetailedInformationCntl = lawyerDetailedInformationCntl;
        initComponents();

        //Retrieve a list of all of the court cases
        listCourtCases = lawyerDetailedInformationCntl.getArrayListCourtCases();

        //Retreive a specific court case from the list of court cases.
        courtCases = listCourtCases.get(indexOfCurrentCourtCase);

        //Using the CourtCase class, take the values and populate
        //the UI.
        parseCourtCases(courtCases);
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

        //Set the Plantiff
        this.plantiffTextField.setText(courtCases.getPlantiff());

        //Set the Defendant
        this.defendantTextField.setText(courtCases.getDefendant());

        //Set the Judge Comments
        this.judgeCommentsTextArea.setText(courtCases.getJudgeInformation());

        //Set the Lawyer Comments
        this.lawyerCommentsTextArea.setText(courtCases.getLawyerInformation());
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

        //Set the Plantiff
        this.plantiffTextField.setText("");

        //Set the Defendant
        this.defendantTextField.setText("");

        //Set the Judge Comments
        this.judgeCommentsTextArea.setText("");

        //Set the Lawyer Comments
        this.lawyerCommentsTextArea.setText("");
    }

    //Get the Case Number field
    public String getCaseNumberTextField() {
        return caseNumberTextField.getText();
    }

    //Set the Case Number field
    public void setCaseNumberTextField(String caseNumberTextFieldString) {
        this.caseNumberTextField.setText(caseNumberTextFieldString);
    }

    //Set the Party Name field
    public void setPartyName(String partyNameTextFieldString) {
        this.partyNameTextField.setText(partyNameTextFieldString);
    }

    /**
     * Enable the buttons in the UI
     */
    public void enableButtons(boolean enabled) {
        this.btnLawyerMainMenu.setEnabled(enabled);
        this.btnView.setEnabled(enabled);
        this.btnQuit.setEnabled(enabled);
        this.btnAdd.setEnabled(enabled);
        this.btnUpdate.setEnabled(enabled);
        this.btnDelete.setEnabled(enabled);
        this.btnSave.setEnabled(!enabled);
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
        btnView = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        lawyerModifyCaseInformationLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        partyNameLabel = new javax.swing.JLabel();
        partyNameTextField = new javax.swing.JTextField();
        courtSystemLabel = new javax.swing.JLabel();
        courtSystemTextField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        locationTextField = new javax.swing.JTextField();
        caseTypeLabel = new javax.swing.JLabel();
        filingDateLabel = new javax.swing.JLabel();
        caseStatusLabel = new javax.swing.JLabel();
        caseInformationLabel = new javax.swing.JLabel();
        caseInformationSeparator = new javax.swing.JSeparator();
        involvedPartiesSeparator = new javax.swing.JSeparator();
        involvedPartiesLabel = new javax.swing.JLabel();
        plantiffLabel = new javax.swing.JLabel();
        plantiffTextField = new javax.swing.JTextField();
        defendantLabel = new javax.swing.JLabel();
        defendantTextField = new javax.swing.JTextField();
        judgeInformationSeparator = new javax.swing.JSeparator();
        judgeInformationLabel = new javax.swing.JLabel();
        judgeCommentsLabel = new javax.swing.JLabel();
        judgeScrollPane = new javax.swing.JScrollPane();
        judgeCommentsTextArea = new javax.swing.JTextArea();
        lawyerInformationSeparator1 = new javax.swing.JSeparator();
        lawyerInformationLabel = new javax.swing.JLabel();
        lawyerCommentsLabel = new javax.swing.JLabel();
        lawyerScrollPane = new javax.swing.JScrollPane();
        lawyerCommentsTextArea = new javax.swing.JTextArea();
        caseTypeTextField = new javax.swing.JTextField();
        filingDateTextField = new javax.swing.JTextField();
        caseStatusTextField = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLawyerMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        civilianViewCaseDetailsPanel.setToolTipText("Civilian View Case Details Panel");

        ccmsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ccmsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ccmsLabel.setText("Court Case Managment System");
        ccmsLabel.setToolTipText("Court Case Managment System");

        caseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseNumberLabel.setForeground(new java.awt.Color(255, 0, 0));
        caseNumberLabel.setText("Case Number:");
        caseNumberLabel.setToolTipText("Case Number:");

        caseNumberTextField.setToolTipText("Please Enter a Case Number (i.e.. 11111)");
        caseNumberTextField.setName("caseNumberTextField"); // NOI18N

        btnView.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnView.setText("View");
        btnView.setToolTipText("View Case Details for Specifiic Case - Civilian ");

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("Exit the Application");

        lawyerModifyCaseInformationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lawyerModifyCaseInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lawyerModifyCaseInformationLabel.setText("Lawyer - Detailed Case Information");
        lawyerModifyCaseInformationLabel.setToolTipText("Clerk - Detailed Case Information");

        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setToolTipText("");

        partyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partyNameLabel.setText("Party Name:");
        partyNameLabel.setToolTipText("Party Name:");

        partyNameTextField.setToolTipText("Party Name Field");

        courtSystemLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        courtSystemLabel.setText("Court System:");
        courtSystemLabel.setToolTipText("Court System:");

        courtSystemTextField.setToolTipText("Please enter one of the following CIRCUIT, DISTRIC");
        courtSystemTextField.setName("caseNumberTextField"); // NOI18N

        locationLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        locationLabel.setText("Location:");
        locationLabel.setToolTipText("Location:");

        locationTextField.setToolTipText("Location TePlease enter one of the following: BALTIMORE, BALTIMORE_CITY, PRINCE_GEORGE, MONTGOMERYxt Field");
        locationTextField.setName("caseNumberTextField"); // NOI18N

        caseTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseTypeLabel.setText("Case Type:");
        caseTypeLabel.setToolTipText("Case Type:");

        filingDateLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        filingDateLabel.setText("Filing Date:");
        filingDateLabel.setToolTipText("Filing Date:");

        caseStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caseStatusLabel.setText("Case Status:");
        caseStatusLabel.setToolTipText("Case Status:");

        caseInformationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        caseInformationLabel.setText("Case Information");
        caseInformationLabel.setToolTipText("Case Information");

        involvedPartiesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        involvedPartiesLabel.setText("Involved Parties Information");

        plantiffLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        plantiffLabel.setText("Plantiff:");
        plantiffLabel.setToolTipText("Plantiff:");

        plantiffTextField.setToolTipText("Plantiff Text Field");

        defendantLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        defendantLabel.setText("Defendant:");
        defendantLabel.setToolTipText("Defendant:");

        defendantTextField.setToolTipText("Defendant Text Field");

        judgeInformationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        judgeInformationLabel.setText("Judge Information:");
        judgeInformationLabel.setToolTipText("Judge Information:");

        judgeCommentsLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        judgeCommentsLabel.setText("Judge Comments:");
        judgeCommentsLabel.setToolTipText("Judge Comments:");

        judgeCommentsTextArea.setEditable(false);
        judgeCommentsTextArea.setColumns(20);
        judgeCommentsTextArea.setRows(5);
        judgeCommentsTextArea.setToolTipText("Judge Comments Text Area");
        judgeScrollPane.setViewportView(judgeCommentsTextArea);

        lawyerInformationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lawyerInformationLabel.setText("Lawyer Information:");
        lawyerInformationLabel.setToolTipText("Lawyer Information:");

        lawyerCommentsLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lawyerCommentsLabel.setText("Lawyer Comments:");
        lawyerCommentsLabel.setToolTipText("Lawyer Comments:");

        lawyerCommentsTextArea.setColumns(20);
        lawyerCommentsTextArea.setRows(5);
        lawyerCommentsTextArea.setToolTipText("Lawyer Comments Text Field");
        lawyerScrollPane.setViewportView(lawyerCommentsTextArea);

        caseTypeTextField.setToolTipText("Please enter one of the following: CIVIL, CRIMINAL, TRAFFIC, CIVIL_ACTION");
        caseTypeTextField.setName("caseNumberTextField"); // NOI18N

        filingDateTextField.setToolTipText("Court System Text Field");
        filingDateTextField.setName("caseNumberTextField"); // NOI18N

        caseStatusTextField.setToolTipText("Please enter one of the following: OPEN, CLOSED, POSTPONED");
        caseStatusTextField.setName("caseNumberTextField"); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setToolTipText("to move fowards through the objects in teh ArrayList");

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Delete");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Save");

        btnLawyerMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLawyerMainMenu.setText("Lawyer Main Menu");
        btnLawyerMainMenu.setToolTipText("Return to Lawyer Main Menu");

        javax.swing.GroupLayout civilianViewCaseDetailsPanelLayout = new javax.swing.GroupLayout(civilianViewCaseDetailsPanel);
        civilianViewCaseDetailsPanel.setLayout(civilianViewCaseDetailsPanelLayout);
        civilianViewCaseDetailsPanelLayout.setHorizontalGroup(
            civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caseInformationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(partyNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(caseNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(courtSystemLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(locationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(caseInformationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(courtSystemTextField)
                                            .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(caseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caseStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(filingDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filingDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(caseTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caseTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLawyerMainMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuit)
                        .addGap(34, 34, 34))
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(involvedPartiesSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(judgeInformationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lawyerInformationSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                .addComponent(lawyerCommentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lawyerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lawyerInformationLabel)
                            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(plantiffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(plantiffTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(defendantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(defendantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(involvedPartiesLabel)
                                    .addComponent(judgeInformationLabel)
                                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(judgeCommentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(judgeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lawyerModifyCaseInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        civilianViewCaseDetailsPanelLayout.setVerticalGroup(
            civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lawyerModifyCaseInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caseInformationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caseInformationLabel)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courtSystemLabel)
                            .addComponent(courtSystemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel)
                            .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caseNumberLabel)
                            .addComponent(caseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(partyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(partyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(civilianViewCaseDetailsPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caseTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caseTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filingDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filingDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caseStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(involvedPartiesSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(involvedPartiesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plantiffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plantiffTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defendantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defendantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(judgeInformationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(judgeInformationLabel)
                .addGap(18, 18, 18)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judgeCommentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(judgeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lawyerInformationSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lawyerInformationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lawyerCommentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lawyerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(civilianViewCaseDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnQuit)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnLawyerMainMenu))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        btnView.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(civilianViewCaseDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(civilianViewCaseDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnLawyerMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnUpdate;
    public javax.swing.JButton btnView;
    private javax.swing.JLabel caseInformationLabel;
    private javax.swing.JSeparator caseInformationSeparator;
    private javax.swing.JLabel caseNumberLabel;
    private javax.swing.JTextField caseNumberTextField;
    public javax.swing.JLabel caseStatusLabel;
    private javax.swing.JTextField caseStatusTextField;
    public javax.swing.JLabel caseTypeLabel;
    private javax.swing.JTextField caseTypeTextField;
    private javax.swing.JLabel ccmsLabel;
    private javax.swing.JPanel civilianViewCaseDetailsPanel;
    private javax.swing.JLabel courtSystemLabel;
    private javax.swing.JTextField courtSystemTextField;
    public javax.swing.JLabel defendantLabel;
    public javax.swing.JTextField defendantTextField;
    public javax.swing.JLabel errorMessage;
    public javax.swing.JLabel filingDateLabel;
    private javax.swing.JTextField filingDateTextField;
    private javax.swing.JLabel involvedPartiesLabel;
    private javax.swing.JSeparator involvedPartiesSeparator;
    public javax.swing.JLabel judgeCommentsLabel;
    private javax.swing.JTextArea judgeCommentsTextArea;
    private javax.swing.JLabel judgeInformationLabel;
    private javax.swing.JSeparator judgeInformationSeparator;
    private javax.swing.JScrollPane judgeScrollPane;
    public javax.swing.JLabel lawyerCommentsLabel;
    private javax.swing.JTextArea lawyerCommentsTextArea;
    private javax.swing.JLabel lawyerInformationLabel;
    private javax.swing.JSeparator lawyerInformationSeparator1;
    private javax.swing.JLabel lawyerModifyCaseInformationLabel;
    private javax.swing.JScrollPane lawyerScrollPane;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    public javax.swing.JLabel partyNameLabel;
    public javax.swing.JTextField partyNameTextField;
    public javax.swing.JLabel plantiffLabel;
    public javax.swing.JTextField plantiffTextField;
    // End of variables declaration//GEN-END:variables

}
