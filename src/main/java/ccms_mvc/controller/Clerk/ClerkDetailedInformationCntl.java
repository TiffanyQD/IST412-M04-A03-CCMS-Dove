package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Clerk.ClerkDetailedInformationUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ClerkDetailedInformationCntl implements ActionListener {

    private CourtCases[] arrayCourtCases;
    private CourtCases courtCases;

    private ClerkDetailedInformationUI clerkDetailedInformationUI;
    private int indexOfCurrentCourtCase;

    public ClerkDetailedInformationCntl() {
//        personList = new PersonList();
//        courtCasesList = new CourtCasesList();

        ObjectMapper mapper = new ObjectMapper();
        
       try {
           arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);
       } catch (IOException e){
           e.printStackTrace();
       }



        clerkDetailedInformationUI = new ClerkDetailedInformationUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        clerkDetailedInformationUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        clerkDetailedInformationUI.btnQuit.addActionListener(this);
        clerkDetailedInformationUI.btnClerkMainMenu.addActionListener(this);
        clerkDetailedInformationUI.btnView.addActionListener(this);
        clerkDetailedInformationUI.btnAdd.addActionListener(this);
        clerkDetailedInformationUI.btnUpdate.addActionListener(this);

    }

    public CourtCases[] getArrayCourtCases() {
        return arrayCourtCases;
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

        //The PREVIOUS button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnUpdate)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals 0, then loop around to the last element in the 
            array list.
             */
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }
            
            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkDetailedInformationUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnAdd)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals the last element in the array list, then loop 
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }
            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkDetailedInformationUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);
            
            boolean caseNumberFound = false;
            for (int i =0; i < arrayCourtCases.length; i ++){
                if (arrayCourtCases[i].getCaseNumber().equals(clerkDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }
            
            if (caseNumberFound) {
                clerkDetailedInformationUI.parseCourtCases(courtCases);
                clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                clerkDetailedInformationUI.errorMessage.setText("Case Number: " + clerkDetailedInformationUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                clerkDetailedInformationUI.errorMessage.setText("Case Number: " + clerkDetailedInformationUI.getCaseNumberTextField() + " was NOT found. !!!");
                clerkDetailedInformationUI.clearTheFieldsInCourtCasesUI();
            }

        }
        
        if (obj.equals(clerkDetailedInformationUI.btnClerkMainMenu)){
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl(); 
            clerkDetailedInformationUI.dispose();
        }

    }
}
