package ccms_mvc.controller;

import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtCasesList;
import ccms_mvc.model.Person;
import ccms_mvc.model.PersonList;
import ccms_mvc.view.LoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginIdCntl implements ActionListener {

    private Person person;
    private PersonList personList;

    private CourtCases courtCases;
    private CourtCasesList courtCasesList;

    private LoginUI loginUI;
    private int indexOfCurrentPerson;

    public LoginIdCntl() {
        personList = new PersonList();
        courtCasesList = new CourtCasesList();
        loginUI = new LoginUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        loginUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        loginUI.btnQuit.addActionListener(this);
        loginUI.btnSubmit.addActionListener(this);
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
        if (obj.equals(loginUI.btnQuit)) {
            System.exit(0);
        }

//        //The DELETE button was pressed
//        if (obj.equals(loginUI.btnDelete)) {
//            if (personList.getPersonArrayList().size() > 0) {
//                indexOfCurrentPerson = loginUI.getIndexOfCurrentPerson();
//                personList.getPersonArrayList().remove(indexOfCurrentPerson);
//                if (personList.getPersonArrayList().size() == 0) {
//                    System.out.println("There are no more records to delete.");
//                    loginUI.clearTheFieldsInPersonUI();
//                } else {
//                    loginUI.parsePerson(personList.getPersonArrayList().get(0));
//                }
//            } else {
//                System.out.println("Empty List. You cannot delete any elements.");
//            }
//
//        }

        //The ADD button was pressed
        if (obj.equals(loginUI.btnSubmit)) {
            //Enable all of the buttons except for Save button
            loginUI.enableButtons(true);

            if (loginUI.getLoginIdTextField().equals("admin")
                    && loginUI.getPasswordTextField().equals("password")) {
                MainMenuCntl mainMenuCntl = new MainMenuCntl();

            } else {
                //Set Error Message Label
                loginUI.setErrorMessageLabel("Invalid iogin ID and password combination.");

                //Clear the fields in the Person UI
                loginUI.clearTheFieldsInPersonUI();
            }
        }

//        //The SAVE button was pressed
//        if (obj.equals(loginUI.btnSave)) {
//            //Instantiate a Person class
//            Person person = new Person();
//            //Set the various fields in Person to the corresponding values
//            //in the LoginUI. 
//            person.setIdNum(Integer.parseInt(loginUI.getIdNumTextField()));
//            person.setName(loginUI.getNameTextField());
//            person.setAddress(loginUI.getAddressTextField());
//            person.setCity(loginUI.getCityTextField());
//            person.setState(loginUI.getStateTextField());
//            person.setZipCode(Integer.parseInt(loginUI.getZipCodeTextField()));
//            //Add the Person to the Person Array List
//            personList.getPersonArrayList().add(person);
//            //Set index of the current person
//            indexOfCurrentPerson = personList.getPersonArrayList().size() - 1;
//            loginUI.setIndexOfCurrentPerson(indexOfCurrentPerson);
//            //Even though the element was added, redraw the screen with the element.
//            loginUI.parsePerson(personList.getPersonArrayList().get(indexOfCurrentPerson));
//            //Enable all of the buttons except for Save button
//            loginUI.enableButtons(true);
//        }
//
//        //The Update button was pressed
//        if (obj.equals(loginUI.btnUpdate)) {
//            indexOfCurrentPerson = loginUI.getIndexOfCurrentPerson();
//            Person person = personList.getPersonArrayList().get(indexOfCurrentPerson);
//            //Update the record with the various fields from the LoginUI. 
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setIdNum(Integer.parseInt(loginUI.getIdNumTextField()));
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setName(loginUI.getNameTextField());
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setAddress(loginUI.getAddressTextField());
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setCity(loginUI.getCityTextField());
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setState(loginUI.getStateTextField());
//            personList.getPersonArrayList().get(indexOfCurrentPerson).setZipCode(Integer.parseInt(loginUI.getZipCodeTextField()));
//            //Set index of the current person
//            loginUI.setIndexOfCurrentPerson(indexOfCurrentPerson);
//            //Even though the element was added, redraw the screen with the element.
//            loginUI.parsePerson(personList.getPersonArrayList().get(indexOfCurrentPerson));
//        }
    }
}
