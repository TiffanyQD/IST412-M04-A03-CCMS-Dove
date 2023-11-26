package ccms_mvc.controller.Civilian;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Civilian.CivilianViewUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CivilianViewCntl implements ActionListener {

    private CourtCases[] arrayCourtCases;
    private CourtCases courtCases;

    private CivilianViewUI civilianViewUI;
    private int indexOfCurrentCourtCase;

    public CivilianViewCntl() {
//        personList = new PersonList();
//        courtCasesList = new CourtCasesList();

        ObjectMapper mapper = new ObjectMapper();
        
       try {
           arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);
       } catch (IOException e){
           e.printStackTrace();
       }



        civilianViewUI = new CivilianViewUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        civilianViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        civilianViewUI.btnQuit.addActionListener(this);
        civilianViewUI.btnCivilianMainMenu.addActionListener(this);
        civilianViewUI.btnView.addActionListener(this);
        civilianViewUI.btnNext.addActionListener(this);
        civilianViewUI.btnPrevious.addActionListener(this);

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
        if (obj.equals(civilianViewUI.btnPrevious)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals 0, then loop around to the last element in the 
            array list.
             */
            indexOfCurrentCourtCase = civilianViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }
            
            civilianViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            civilianViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(civilianViewUI.btnNext)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals the last element in the array list, then loop 
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = civilianViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }
            civilianViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            civilianViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(civilianViewUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(civilianViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            civilianViewUI.enableButtons(true);
            
            boolean caseNumberFound = false;
            for (int i =0; i < arrayCourtCases.length; i ++){
                if (arrayCourtCases[i].getCaseNumber().equals(civilianViewUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }
            
            if (caseNumberFound) {
                civilianViewUI.parseCourtCases(courtCases);
                civilianViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
//                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was NOT found. !!!");
                civilianViewUI.clearTheFieldsInCourtCasesUI();
            }

        }
        
        if (obj.equals(civilianViewUI.btnCivilianMainMenu)){
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            civilianViewUI.dispose();
        }

    }
}
