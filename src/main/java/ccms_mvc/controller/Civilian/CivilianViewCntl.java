package ccms_mvc.controller.Civilian;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Civilian.CivilianViewUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CivilianViewCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private CivilianViewUI civilianViewUI;
    private int indexOfCurrentPerson;

    public CivilianViewCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        civilianViewUI = new CivilianViewUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        civilianViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        civilianViewUI.btnQuit.addActionListener(this);
        civilianViewUI.btnMainMenu.addActionListener(this);
        civilianViewUI.btnSearch.addActionListener(this);

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
        if (obj.equals(civilianViewUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(civilianViewUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            civilianViewUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            String partyName = "";
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(civilianViewUI.getCaseNumberTextField())) {
                    partyName = courtCases.getPartyName();
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                civilianViewUI.partyNameTextField.setText(partyName);
                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(civilianViewUI.btnMainMenu)){
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
        }

    }
}
