package ccms_mvc.controller.Clerk;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.view.Clerk.ClerkMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the controller class for ClerkMainMenuUI. The menu allows the clerk
 * to navigate to the following functions: 1.) Search for Specific Cases 2.)
 * View Case Details 3.) Detailed Information
 */
public class ClerkMainMenuCntl implements ActionListener {

    //Create a reference to ClerkMainMenuUI object
    private ClerkMainMenuUI clerkMainMenuUI;

    /**
     * ClerkMainMenuCntl Constructor
     */
    public ClerkMainMenuCntl() {
        //Instantiate ClerkMainMenuUI
        clerkMainMenuUI = new ClerkMainMenuUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the ClerkMainMenuUI to be visible (true)
        clerkMainMenuUI.setVisible(true);
    }

    /**
     * This method will add the addActionListener for each button on the
     * clerkMainMenuUI.
     */
    public void addActionListenersButtons() {
        clerkMainMenuUI.btnQuit.addActionListener(this);
        clerkMainMenuUI.btnMainMenu.addActionListener(this);
        clerkMainMenuUI.btnSearchSpecificCase.addActionListener(this);
        clerkMainMenuUI.btnViewCaseDetails.addActionListener(this);
        clerkMainMenuUI.btnDetailedInformation.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(clerkMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(clerkMainMenuUI.btnMainMenu)) {
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            clerkMainMenuUI.dispose();
        }

        //Search Specific Case
        if (obj.equals(clerkMainMenuUI.btnSearchSpecificCase)) {
            ClerkSearchCntl clerkSearchCntl = new ClerkSearchCntl();
            clerkMainMenuUI.dispose();
        }

        //View Case Details
        if (obj.equals(clerkMainMenuUI.btnViewCaseDetails)) {
            ClerkViewCntl clerkViewCntl = new ClerkViewCntl();
            clerkMainMenuUI.dispose();
        }

        //Detailed Information
        if (obj.equals(clerkMainMenuUI.btnDetailedInformation)) {
            ClerkDetailedInformationCntl clerkDetailedInformationCntl = new ClerkDetailedInformationCntl();
            clerkMainMenuUI.dispose();
        }

    }
}
