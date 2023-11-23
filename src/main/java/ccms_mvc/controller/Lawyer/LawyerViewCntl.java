package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Lawyer.LawyerViewUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LawyerViewCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private LawyerViewUI lawyerViewUI;
    private int indexOfCurrentPerson;

    public LawyerViewCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        lawyerViewUI = new LawyerViewUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        lawyerViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        lawyerViewUI.btnQuit.addActionListener(this);
        lawyerViewUI.btnMainMenu.addActionListener(this);
        lawyerViewUI.btnView.addActionListener(this);

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
        if (obj.equals(lawyerViewUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(lawyerViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            lawyerViewUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            String partyName = "";
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(lawyerViewUI.getCaseNumberTextField())) {
                    partyName = courtCases.getPartyName();
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                lawyerViewUI.partyNameTextField.setText(partyName);
                lawyerViewUI.errorMessage.setText("Case Number: " + lawyerViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerViewUI.errorMessage.setText("Case Number: " + lawyerViewUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(lawyerViewUI.btnMainMenu)){
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
        }

    }
}
