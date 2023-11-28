package ccms_mvc.controller.Civilian;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.view.Civilian.CivilianMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the controller class for CivilianMainMenuUI. The menu allows the
 * civilian to navigate to the following functions: 1.) Search for Specific
 * Cases 2.) View Case Details 3.) Detailed Information
 */
public class CivilianMainMenuCntl implements ActionListener {

    //Create a reference to CivilianMainMenuUI object
    private CivilianMainMenuUI civilianMainMenuUI;

    /**
     * CivilianMainMenuCntl Constructor
     */
    public CivilianMainMenuCntl() {
        //Instantiate CivilianMainMenu
        civilianMainMenuUI = new CivilianMainMenuUI(this);

        //Call to addActionListernerButtons to activate the listener 
        //for various buttons.
        addActionListenersButtons();

        //set the CivilanMainMenuUI to be visible (true)
        civilianMainMenuUI.setVisible(true);
    }

    /**
     * This method will add the addActionListener for each button on the
     * CivilianMainMenuUI.
     */
    public void addActionListenersButtons() {
        civilianMainMenuUI.btnQuit.addActionListener(this);
        civilianMainMenuUI.btnMainMenu.addActionListener(this);
        civilianMainMenuUI.btnSearchSpecificCase.addActionListener(this);
        civilianMainMenuUI.btnViewCaseDetails.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(civilianMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(civilianMainMenuUI.btnMainMenu)) {
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            civilianMainMenuUI.dispose();
        }

        //Search Specific Case
        if (obj.equals(civilianMainMenuUI.btnSearchSpecificCase)) {
            CivilianSearchCntl civilianSearchCntl = new CivilianSearchCntl();
            civilianMainMenuUI.dispose();
        }

        //View Case Details
        if (obj.equals(civilianMainMenuUI.btnViewCaseDetails)) {
            CivilianViewCntl civilianViewCntl = new CivilianViewCntl();
            civilianMainMenuUI.dispose();
        }

    }
}
