package ccms_mvc.controller.Lawyer;

import ccms_mvc.controller.MainMenuCntl;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.Lawyer.LawyerMainMenuUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LawyerMainMenuCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private LawyerMainMenuUI lawyerMainMenuUI;
    private int indexOfCurrentPerson;

    public LawyerMainMenuCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        lawyerMainMenuUI = new LawyerMainMenuUI(this);
        //Call to addActionListernerButtons toactivate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        lawyerMainMenuUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        lawyerMainMenuUI.btnQuit.addActionListener(this);
        lawyerMainMenuUI.btnMainMenu.addActionListener(this);
        lawyerMainMenuUI.btnLawyerSearchSpecificCase.addActionListener(this);
        lawyerMainMenuUI.btnLawyerViewCaseDetails.addActionListener(this);
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
        if (obj.equals(lawyerMainMenuUI.btnQuit)) {
            System.exit(0);
        }

        //Return to Main Menu
        if (obj.equals(lawyerMainMenuUI.btnMainMenu)){
            MainMenuCntl mainMenuCntl = new MainMenuCntl();
            lawyerMainMenuUI.dispose();
        }
        
        //Search Specific Case
        if (obj.equals(lawyerMainMenuUI.btnLawyerSearchSpecificCase)){
            LawyerSearchCntl lawyerSearchCntl = new LawyerSearchCntl();
            lawyerMainMenuUI.dispose();
        }
        
        //View Case Details
        if (obj.equals(lawyerMainMenuUI.btnLawyerViewCaseDetails)){
            LawyerViewCntl lawyerViewCntl = new LawyerViewCntl();
            lawyerMainMenuUI.dispose();
        }

        
    }
}
