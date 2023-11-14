package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Clerk.ClerkSearchUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClerkSearchCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private ClerkSearchUI clerkSearchUI;
    private int indexOfCurrentPerson;

    public ClerkSearchCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        clerkSearchUI = new ClerkSearchUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        clerkSearchUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        clerkSearchUI.btnQuit.addActionListener(this);
        clerkSearchUI.btnMainMenu.addActionListener(this);
        clerkSearchUI.btnSearch.addActionListener(this);

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
        if (obj.equals(clerkSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(clerkSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            clerkSearchUI.enableButtons(true);

            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
            boolean caseNumberFound = false;
            for (CourtCases courtCases : courtCasesArrayList) {
                if (courtCases.getCaseNumber().equals(clerkSearchUI.getCaseNumberTextField())) {
                    caseNumberFound = true;
                    break;
                }
            }
            if (caseNumberFound) {
                clerkSearchUI.errorMessage.setText("Case Number: " + clerkSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                clerkSearchUI.errorMessage.setText("Case Number: " + clerkSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }
        
        if (obj.equals(clerkSearchUI.btnMainMenu)){
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
        }

    }
}
