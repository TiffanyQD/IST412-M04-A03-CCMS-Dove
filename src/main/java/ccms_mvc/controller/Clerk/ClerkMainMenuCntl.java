package ccms_mvc.controller.Clerk;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Clerk.ClerkMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClerkMainMenuCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private ClerkMainMenuUI clerkMainMenuUI;
    private int indexOfCurrentPerson;

    public ClerkMainMenuCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        clerkMainMenuUI = new ClerkMainMenuUI(this);
        //Call to addActionListernerButtons toactivate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        clerkMainMenuUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        clerkMainMenuUI.btnQuit.addActionListener(this);
        clerkMainMenuUI.btnMainMenu.addActionListener(this);
        clerkMainMenuUI.btnSearchSpecificCase.addActionListener(this);
        clerkMainMenuUI.btnViewCaseDetails.addActionListener(this);
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

//        //The PREVIOUS button was pressed
//        if (obj.equals(loginUI.btnPrevious)) {
//            /*
//            So that you don't have problems with out of bounds, if the current 
//            position equals 0, then loop around to the last element in the 
//            array list.
//             */
//            indexOfCurrentPerson = loginUI.getIndexOfCurrentPerson();
//            if (indexOfCurrentPerson == 0) {
//                indexOfCurrentPerson = personList.getPersonArrayList().size() - 1;
//            } else {
//                indexOfCurrentPerson--;
//            }
//            loginUI.setIndexOfCurrentPerson(indexOfCurrentPerson);
//            loginUI.parsePerson(personList.getPersonArrayList().get(indexOfCurrentPerson));
//        }
//
//        //The NEXT button was pressed
//        if (obj.equals(loginUI.btnNext)) {
//            /*
//            So that you don't have problems with out of bounds, if the current 
//            position equals the last element in the array list, then loop 
//            around to the first element in the array list.
//             */
//            indexOfCurrentPerson = loginUI.getIndexOfCurrentPerson();
//            if (indexOfCurrentPerson == personList.getPersonArrayList().size() - 1) {
//                indexOfCurrentPerson = 0;
//            } else {
//                indexOfCurrentPerson++;
//            }
//            loginUI.setIndexOfCurrentPerson(indexOfCurrentPerson);
//            loginUI.parsePerson(personList.getPersonArrayList().get(indexOfCurrentPerson));
//        }

        //The QUIT button was pressed
        if (obj.equals(clerkMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(clerkMainMenuUI.btnMainMenu)){
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            clerkMainMenuUI.dispose();
        }
        
        //Search Specific Case
        if (obj.equals(clerkMainMenuUI.btnSearchSpecificCase)){
            ClerkSearchCntl clerkSearchCntl = new ClerkSearchCntl();
            clerkMainMenuUI.dispose();
        }
        
        //View Case Details
        if (obj.equals(clerkMainMenuUI.btnViewCaseDetails)){
            ClerkViewCntl clerkViewCntl = new ClerkViewCntl();
            clerkMainMenuUI.dispose();
        }

        
    }
}
