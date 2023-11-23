package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Lawyer.LawyerSearchUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LawyerSearchCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private LawyerSearchUI lawyerSearchUI;
    private int indexOfCurrentPerson;

    public LawyerSearchCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        lawyerSearchUI = new LawyerSearchUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        lawyerSearchUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        lawyerSearchUI.btnQuit.addActionListener(this);
        lawyerSearchUI.btnLawyerMainMenu.addActionListener(this);
        lawyerSearchUI.btnSearch.addActionListener(this);

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
        if (obj.equals(lawyerSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(lawyerSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            lawyerSearchUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(lawyerSearchUI.getCaseNumberTextField())) {
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                lawyerSearchUI.errorMessage.setText("Case Number: " + lawyerSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerSearchUI.errorMessage.setText("Case Number: " + lawyerSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(lawyerSearchUI.btnLawyerMainMenu)){
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
        }

    }
}
