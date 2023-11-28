package ccms_mvc.controller;

import ccms_mvc.controller.Civilian.CivilianMainMenuCntl;
import ccms_mvc.controller.Clerk.ClerkMainMenuCntl;
import ccms_mvc.controller.Judge.JudgeMainMenuCntl;
import ccms_mvc.controller.Lawyer.LawyerMainMenuCntl;
import ccms_mvc.view.MainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the main menu controller. The responsibility of this class is that it
 * will direct the user to the appropriate menu.
 */
public class MainMenuCntl implements ActionListener {

    //Call to the Main Menu UI
    private MainMenuUI mainMenuUI;

    //Index of the current court case
    private int indexOfCurrentPerson;

    public MainMenuCntl() {
        //Create an instance of MainMenuUI
        mainMenuUI = new MainMenuUI(this);

        //Call to addActionListernerButtons to activate the listener for various
        //buttons.
        addActionListenersButtons();

        //Set the MainMenuUI to be visible (true)
        mainMenuUI.setVisible(true);
    }

    /**
     * This method will add action listeners for the various buttons on the
     * MainMenuUI
     */
    public void addActionListenersButtons() {
        mainMenuUI.btnQuit.addActionListener(this);
        mainMenuUI.btnCivilianMainMenu.addActionListener(this);
        mainMenuUI.btnClerkMainMenu.addActionListener(this);
        mainMenuUI.btnJudgeMainMenu.addActionListener(this);
        mainMenuUI.btnLawyerMainMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(mainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //The Civilian Menu button was pressed
        if (obj.equals(mainMenuUI.btnCivilianMainMenu)) {
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            mainMenuUI.dispose();
        }

        //The Clerk Menu button was pressed
        if (obj.equals(mainMenuUI.btnClerkMainMenu)) {
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            mainMenuUI.dispose();
        }

        //The Judge Menu button was pressed
        if (obj.equals(mainMenuUI.btnJudgeMainMenu)) {
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            mainMenuUI.dispose();
        }

        //The Lawyer Menu button was pressed
        if (obj.equals(mainMenuUI.btnLawyerMainMenu)) {
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            mainMenuUI.dispose();
        }

    }
}
