package ccms_mvc.view.Judge;

import ccms_mvc.controller.Judge.JudgeMainMenuCntl;

/**
 * This class sets up the is JudgeMainMenuUI Form.
 *
 * @author Tiffany Dove
 */
public class JudgeMainMenuUI extends javax.swing.JFrame {

    //Reference to JudgeMainMenuCntl Controller
    private JudgeMainMenuCntl judgeMainMenuCntl;

    /**
     * Creates new form JudgeMainMenuUI
     */
    public JudgeMainMenuUI(JudgeMainMenuCntl judgeMainMenuCntl) {
        this.judgeMainMenuCntl = judgeMainMenuCntl;
        initComponents();

    }

    //Set the error message
    public void setErrorMessageString(String errorMessageString) {
        this.errorMessageLabel.setText(errorMessageString);
    }

    /**
     * Enable the buttons in the UI
     */
    public void enableButtons(boolean enabled) {

        this.btnSearchSpecificCase.setEnabled(enabled);
        this.btnViewCaseDetails.setEnabled(enabled);
        this.btnQuit.setEnabled(enabled);
        this.btnMainMenu.setEnabled(enabled);
        this.btnDetailedInformation.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judgeMainMenuPanel = new javax.swing.JPanel();
        ccmsMainMenuLabel = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        btnSearchSpecificCase = new javax.swing.JButton();
        btnViewCaseDetails = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        judgeMainMenuLabel = new javax.swing.JLabel();
        btnDetailedInformation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        judgeMainMenuPanel.setToolTipText("Person Panel");

        ccmsMainMenuLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ccmsMainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ccmsMainMenuLabel.setText("Court Case Management System");
        ccmsMainMenuLabel.setToolTipText("Court Case Management System");

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("Exit the Application");

        btnSearchSpecificCase.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchSpecificCase.setText("Search Specific Case");
        btnSearchSpecificCase.setToolTipText("Search Specific Case");

        btnViewCaseDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewCaseDetails.setText("View Case Details");
        btnViewCaseDetails.setToolTipText("View Case Details");

        btnMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setToolTipText("exit the application");

        judgeMainMenuLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        judgeMainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judgeMainMenuLabel.setText("Judge Main Menu");
        judgeMainMenuLabel.setToolTipText("Judge Main Menu");

        btnDetailedInformation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDetailedInformation.setText("Detailed Information");
        btnDetailedInformation.setToolTipText("View Case Details for Lawyer");

        javax.swing.GroupLayout judgeMainMenuPanelLayout = new javax.swing.GroupLayout(judgeMainMenuPanel);
        judgeMainMenuPanel.setLayout(judgeMainMenuPanelLayout);
        judgeMainMenuPanelLayout.setHorizontalGroup(
            judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judgeMainMenuPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(judgeMainMenuPanelLayout.createSequentialGroup()
                        .addGroup(judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccmsMainMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                            .addComponent(judgeMainMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(judgeMainMenuPanelLayout.createSequentialGroup()
                        .addGroup(judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(judgeMainMenuPanelLayout.createSequentialGroup()
                                .addComponent(btnQuit)
                                .addGap(123, 123, 123)
                                .addComponent(btnMainMenu))
                            .addComponent(btnDetailedInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnViewCaseDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchSpecificCase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        judgeMainMenuPanelLayout.setVerticalGroup(
            judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judgeMainMenuPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(judgeMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnSearchSpecificCase)
                .addGap(31, 31, 31)
                .addComponent(btnViewCaseDetails)
                .addGap(30, 30, 30)
                .addComponent(btnDetailedInformation)
                .addGap(54, 54, 54)
                .addComponent(errorMessageLabel)
                .addGap(69, 69, 69)
                .addGroup(judgeMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainMenu)
                    .addComponent(btnQuit))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(judgeMainMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(judgeMainMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDetailedInformation;
    public javax.swing.JButton btnMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSearchSpecificCase;
    public javax.swing.JButton btnViewCaseDetails;
    private javax.swing.JLabel ccmsMainMenuLabel;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JLabel judgeMainMenuLabel;
    private javax.swing.JPanel judgeMainMenuPanel;
    // End of variables declaration//GEN-END:variables

}
