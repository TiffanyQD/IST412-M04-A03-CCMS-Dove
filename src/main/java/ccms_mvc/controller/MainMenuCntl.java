package ccms_mvc.controller;

import ccms_mvc.controller.Civilian.CivilianMainMenuCntl;
import ccms_mvc.controller.Clerk.ClerkMainMenuCntl;
import ccms_mvc.controller.Judge.JudgeMainMenuCntl;
import ccms_mvc.controller.Lawyer.LawyerMainMenuCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.MainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private MainMenuUI mainMenuUI;
    private int indexOfCurrentPerson;

    public MainMenuCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        mainMenuUI = new MainMenuUI(this);
        //Call to addActionListernerButtons toactivate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        mainMenuUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        mainMenuUI.btnQuit.addActionListener(this);
        mainMenuUI.btnCivilianMainMenu.addActionListener(this);
        mainMenuUI.btnClerkMainMenu.addActionListener(this);
        mainMenuUI.bntJudgeMainMenu.addActionListener(this);
        mainMenuUI.btnLawyerMainMenu.addActionListener(this);
    }

    public ArrayList<Person> getListOfPerson() {
        return personList.getPersonArrayList();
    }

    public ArrayList<CourtCases> getListOfCourtCases() {
        return courtCasesList.getCourtCasesArrayList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(mainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Civilian
        if (obj.equals(mainMenuUI.btnCivilianMainMenu)){
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            mainMenuUI.dispose();
        }
        
        //Clerk
        if (obj.equals(mainMenuUI.btnClerkMainMenu)){
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            mainMenuUI.dispose();
        }
        
        //Judge
        if (obj.equals(mainMenuUI.bntJudgeMainMenu)){
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            mainMenuUI.dispose();
        }

        //Lawyer
        if (obj.equals(mainMenuUI.btnLawyerMainMenu)){
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            mainMenuUI.dispose();
        }

        
    }
}
