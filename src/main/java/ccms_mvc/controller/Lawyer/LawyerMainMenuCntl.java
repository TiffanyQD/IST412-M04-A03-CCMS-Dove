package ccms_mvc.controller.Lawyer;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.view.Lawyer.LawyerMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the controller class for LawyerMainMenuUI. The menu allows the lawyer
 * to navigate to the following functions: 1.) Search for Specific Cases 2.)
 * View Case Details 3.) Detailed Information
 */
public class LawyerMainMenuCntl implements ActionListener {

    //Create a reference to LawyerMainMenuUI object
    private LawyerMainMenuUI lawyerMainMenuUI;

    /**
     * LawyerMainMenuCntl Constructor
     */
    public LawyerMainMenuCntl() {
        //Instantiate LawyerMainMenuUI
        lawyerMainMenuUI = new LawyerMainMenuUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the LawyerMainMenuUI to be visible (true)
        lawyerMainMenuUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        lawyerMainMenuUI.btnQuit.addActionListener(this);
        lawyerMainMenuUI.btnMainMenu.addActionListener(this);
        lawyerMainMenuUI.btnLawyerSearchSpecificCase.addActionListener(this); //TODO Be Careful with "Lawyer"
        lawyerMainMenuUI.btnLawyerViewCaseDetails.addActionListener(this); //TODO Be Careful with "Lawyer"
        lawyerMainMenuUI.btnDetailedInformation.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(lawyerMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(lawyerMainMenuUI.btnMainMenu)) {
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            lawyerMainMenuUI.dispose();
        }

        //Search Specific Case
        if (obj.equals(lawyerMainMenuUI.btnLawyerSearchSpecificCase)) {
            LawyerSearchCntl lawyerSearchCntl = new LawyerSearchCntl();
            lawyerMainMenuUI.dispose();
        }

        //View Case Details
        if (obj.equals(lawyerMainMenuUI.btnLawyerViewCaseDetails)) {
            LawyerViewCntl lawyerViewCntl = new LawyerViewCntl();
            lawyerMainMenuUI.dispose();
        }

        //Detailed Information
        if (obj.equals(lawyerMainMenuUI.btnDetailedInformation)) {
            LawyerDetailedInformationCntl lawyerDetailedInformationCntl = new LawyerDetailedInformationCntl();
            lawyerMainMenuUI.dispose();
        }

    }
}
