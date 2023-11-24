package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Judge.JudgeSearchUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JudgeSearchCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private JudgeSearchUI judgeSearchUI;
    private int indexOfCurrentPerson;

    public JudgeSearchCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        judgeSearchUI = new JudgeSearchUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        judgeSearchUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        judgeSearchUI.btnQuit.addActionListener(this);
        judgeSearchUI.btnJudgeMainMenu.addActionListener(this);
        judgeSearchUI.btnSearch.addActionListener(this);

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
        if (obj.equals(judgeSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(judgeSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            judgeSearchUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(judgeSearchUI.getCaseNumberTextField())) {
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                judgeSearchUI.errorMessage.setText("Case Number: " + judgeSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                judgeSearchUI.errorMessage.setText("Case Number: " + judgeSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(judgeSearchUI.btnJudgeMainMenu)){
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            judgeSearchUI.dispose();
        }

    }
}
