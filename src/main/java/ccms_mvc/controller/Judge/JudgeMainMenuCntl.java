package ccms_mvc.controller.Judge;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.view.Judge.JudgeMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the controller class for JudgeMainMenuUI. The menu allows the clerk
 * to navigate to the following functions: 1.) Search for Specific Cases 2.)
 * View Case Details 3.) Detailed Information
 */
public class JudgeMainMenuCntl implements ActionListener {

    //Create a reference to JudgeMainMenuUI object
    private JudgeMainMenuUI judgeMainMenuUI;

    /**
     * JudgeMainMenuCntl Constructor
     */
    public JudgeMainMenuCntl() {
        //Instantiate CivilianMainMenu
        judgeMainMenuUI = new JudgeMainMenuUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the JudgeMainMenuUI to be visible (true)
        judgeMainMenuUI.setVisible(true);
    }

    /**
     * This method will add the addActionListener for each button on the
     * JudgeMainMenuUI.
     */
    public void addActionListenersButtons() {
        judgeMainMenuUI.btnQuit.addActionListener(this);
        judgeMainMenuUI.btnMainMenu.addActionListener(this);
        judgeMainMenuUI.btnSearchSpecificCase.addActionListener(this);
        judgeMainMenuUI.btnViewCaseDetails.addActionListener(this);
        judgeMainMenuUI.btnDetailedInformation.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(judgeMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(judgeMainMenuUI.btnMainMenu)) {
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            judgeMainMenuUI.dispose();
        }

        //Search Specific Case
        if (obj.equals(judgeMainMenuUI.btnSearchSpecificCase)) {
            JudgeSearchCntl judgeSearchCntl = new JudgeSearchCntl();
            judgeMainMenuUI.dispose();
        }

        //View Case Details
        if (obj.equals(judgeMainMenuUI.btnViewCaseDetails)) {
            JudgeViewCntl judgeViewCntl = new JudgeViewCntl();
            judgeMainMenuUI.dispose();
        }

        //Detailed Information
        if (obj.equals(judgeMainMenuUI.btnDetailedInformation)) {
            JudgeDetailedInformationCntl judgeDetailedInformationCntl = new JudgeDetailedInformationCntl();
            judgeMainMenuUI.dispose();
        }

    }
}
