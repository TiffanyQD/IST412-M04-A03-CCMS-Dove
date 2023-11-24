package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Judge.JudgeViewUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JudgeViewCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private JudgeViewUI judgeViewUI;
    private int indexOfCurrentPerson;

    public JudgeViewCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        judgeViewUI = new JudgeViewUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        judgeViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        judgeViewUI.btnQuit.addActionListener(this);
        judgeViewUI.btnJudgeMainMenu.addActionListener(this);
        judgeViewUI.btnView.addActionListener(this);

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
        if (obj.equals(judgeViewUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(judgeViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            judgeViewUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            String partyName = "";
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(judgeViewUI.getCaseNumberTextField())) {
                    partyName = courtCases.getPartyName();
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                judgeViewUI.partyNameTextField.setText(partyName);
                judgeViewUI.errorMessage.setText("Case Number: " + judgeViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                judgeViewUI.errorMessage.setText("Case Number: " + judgeViewUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(judgeViewUI.btnJudgeMainMenu)){
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            judgeViewUI.dispose();
        }

    }
}
