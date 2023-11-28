package ccms_mvc.view.Civilian;

import ccms_mvc.controller.Civilian.CivilianMainMenuCntl;

/**
 *
 * @author Tiffany Dove
 */
public class CivilianMainMenuUI extends javax.swing.JFrame {

    //Reference to Person Controller
    private CivilianMainMenuCntl civilianMainMenuCntl;

    /**
     * Creates new form Civilian Main Menu UI
     */
    public CivilianMainMenuUI(CivilianMainMenuCntl civilianMainMenuCntl) {
        this.civilianMainMenuCntl = civilianMainMenuCntl;
        initComponents();
    }

    public void setErrorMessageString(String errorMessageString) {
        this.errorMessageLabel.setText(errorMessageString);
    }

    public void enableButtons(boolean enabled) {

        this.btnSearchSpecificCase.setEnabled(enabled);
        this.btnViewCaseDetails.setEnabled(enabled);
        this.btnQuit.setEnabled(enabled);
        this.btnMainMenu.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        civilianMainMenuPanel = new javax.swing.JPanel();
        ccmsMainMenuLabel = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        btnSearchSpecificCase = new javax.swing.JButton();
        btnViewCaseDetails = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        civilianMainMenuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        civilianMainMenuPanel.setToolTipText("Person Panel");

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
        btnViewCaseDetails.setToolTipText("View Case Details ofr Clerk");

        btnMainMenu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setToolTipText("Return to the Main Menu");

        civilianMainMenuLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        civilianMainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        civilianMainMenuLabel.setText("Civilian Main Menu");
        civilianMainMenuLabel.setToolTipText("Civilian Main Menu");

        javax.swing.GroupLayout civilianMainMenuPanelLayout = new javax.swing.GroupLayout(civilianMainMenuPanel);
        civilianMainMenuPanel.setLayout(civilianMainMenuPanelLayout);
        civilianMainMenuPanelLayout.setHorizontalGroup(
            civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianMainMenuPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(civilianMainMenuPanelLayout.createSequentialGroup()
                        .addGroup(civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchSpecificCase)
                            .addComponent(btnViewCaseDetails)
                            .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(civilianMainMenuPanelLayout.createSequentialGroup()
                                .addComponent(btnQuit)
                                .addGap(123, 123, 123)
                                .addComponent(btnMainMenu)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(civilianMainMenuPanelLayout.createSequentialGroup()
                        .addGroup(civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccmsMainMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                            .addComponent(civilianMainMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        civilianMainMenuPanelLayout.setVerticalGroup(
            civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(civilianMainMenuPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ccmsMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(civilianMainMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnSearchSpecificCase)
                .addGap(28, 28, 28)
                .addComponent(btnViewCaseDetails)
                .addGap(113, 113, 113)
                .addComponent(errorMessageLabel)
                .addGap(69, 69, 69)
                .addGroup(civilianMainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainMenu)
                    .addComponent(btnQuit))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(civilianMainMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(civilianMainMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMainMenu;
    public javax.swing.JButton btnQuit;
    public javax.swing.JButton btnSearchSpecificCase;
    public javax.swing.JButton btnViewCaseDetails;
    private javax.swing.JLabel ccmsMainMenuLabel;
    private javax.swing.JLabel civilianMainMenuLabel;
    private javax.swing.JPanel civilianMainMenuPanel;
    private javax.swing.JLabel errorMessageLabel;
    // End of variables declaration//GEN-END:variables

}
