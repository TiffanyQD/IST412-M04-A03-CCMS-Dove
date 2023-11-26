package ccms_mvc.controller.Civilian;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Civilian.CivilianSearchUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CivilianSearchCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private CivilianSearchUI civilianSearchUI;
    private int indexOfCurrentPerson;

    public CivilianSearchCntl() {
//        personList = new PersonList();
//        courtCasesList = new CourtCasesList();
        //TODO Tiffany, Add logic to retrieve cases.
        civilianSearchUI = new CivilianSearchUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        civilianSearchUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        civilianSearchUI.btnQuit.addActionListener(this);
        civilianSearchUI.btnCivilianMainMenu.addActionListener(this);
        civilianSearchUI.btnSearch.addActionListener(this);

    }

//    public ArrayList<Person> getListOfPerson() {
//        return personList.getPersonArrayList();
//    }
//
//    public ArrayList<CourtCases> getListOfCourtCases() {
//        return courtCasesList.getCourtCasesArrayList();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(civilianSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(civilianSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            civilianSearchUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(civilianSearchUI.getCaseNumberTextField())) {
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                civilianSearchUI.errorMessage.setText("Case Number: " + civilianSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                civilianSearchUI.errorMessage.setText("Case Number: " + civilianSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(civilianSearchUI.btnCivilianMainMenu)){
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            civilianSearchUI.dispose();
        }

    }
}
