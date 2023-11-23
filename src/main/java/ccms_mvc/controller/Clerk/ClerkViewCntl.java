package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Clerk.ClerkViewUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClerkViewCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private ClerkViewUI clerkViewUI;
    private int indexOfCurrentPerson;

    public ClerkViewCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        clerkViewUI = new ClerkViewUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        clerkViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        clerkViewUI.btnQuit.addActionListener(this);
        clerkViewUI.btnClerkMainMenu.addActionListener(this);
        clerkViewUI.btnView.addActionListener(this);

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
        if (obj.equals(clerkViewUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(clerkViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            clerkViewUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            String partyName = "";
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(clerkViewUI.getCaseNumberTextField())) {
                    partyName = courtCases.getPartyName();
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                clerkViewUI.partyNameTextField.setText(partyName);
                clerkViewUI.errorMessage.setText("Case Number: " + clerkViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                clerkViewUI.errorMessage.setText("Case Number: " + clerkViewUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(clerkViewUI.btnClerkMainMenu)){
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
        }

    }
}
