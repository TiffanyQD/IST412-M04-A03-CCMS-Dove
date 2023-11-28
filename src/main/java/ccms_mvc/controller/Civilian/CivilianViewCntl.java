package ccms_mvc.controller.Civilian;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Civilian.CivilianViewUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This controller class that is used in conjunction with the CivilianViewUI to
 * display/view Court Case details.
 */
public class CivilianViewCntl implements ActionListener {

    //Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Call CourCases object
    private CourtCases courtCases;

    //ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Call to CivilianViewUI object
    private CivilianViewUI civilianViewUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * Constructor for CivilianViewCntl
     */
    public CivilianViewCntl() {

        //Call ObjectMapper which will be used to retrieve json of court cases.
        ObjectMapper mapper = new ObjectMapper();

        try {
            //Read the courtCases.json file and place the contents into arrayCourtCases
            arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);

            //Create an arraylist (listCourtCases) from the array (arrayCourtCases)
            listCourtCases = Arrays.asList(arrayCourtCases);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Instantiate CivilianViewUI
        civilianViewUI = new CivilianViewUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the CivilianViewUI to be visible (true)
        civilianViewUI.setVisible(true);
    }

    /**
     * Call to addActionListener method to activiate listener for various
     * buttons.
     */
    public void addActionListenersButtons() {
        civilianViewUI.btnQuit.addActionListener(this);
        civilianViewUI.btnCivilianMainMenu.addActionListener(this);
        civilianViewUI.btnView.addActionListener(this);
        civilianViewUI.btnNext.addActionListener(this);
        civilianViewUI.btnPrevious.addActionListener(this);

    }

    public List<CourtCases> getListCourtCases() {
        return listCourtCases;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //TODO Would prefer if the following code used the listCourtCases instead of arrayCourtCases
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

        //The View button was pressed
        if (obj.equals(civilianViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            civilianViewUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
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
                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                civilianViewUI.errorMessage.setText("Case Number: " + civilianViewUI.getCaseNumberTextField() + " was NOT found. !!!");
                civilianViewUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Civilian Main Menu button was pressed.	
        if (obj.equals(civilianViewUI.btnCivilianMainMenu)) {
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            civilianViewUI.dispose();
        }
    }
}
