package ccms_mvc.controller.Civilian;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Civilian.CivilianSearchUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * This is the controller class that is used in conjunction with the
 * CivilianSearchUI to search Court Case details for the Civilian.
 */
@Getter
@Setter
public class CivilianSearchCntl implements ActionListener {

    //Create an Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Create a reference to the CourtCases object
    private CourtCases courtCases;

    //Create an ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Create an ArrayList of CourtCases
    private List<CourtCases> arrayListCourtCases;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    //Reference to ObjectMapper
    private ObjectMapper mapper;

    //Create a reference to the CivilianSearchUI object
    private CivilianSearchUI civilianSearchUI;

    /**
     * CivilianSearchCntl Constructor
     */
    public CivilianSearchCntl() {

        //Instantiate ObjectMapper to read json from a file.
        mapper = new ObjectMapper();

        try {
            //Read the court case information into an array (arrayCourtCases)
            arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);

            //Create an arraylist (listCourtCases) from the array (arrayCourtCases)
            listCourtCases = Arrays.asList(arrayCourtCases);

            //Create a modifiable ArrayList from listCourtCases
            arrayListCourtCases = new ArrayList<>(listCourtCases);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Instantiate CivilianSearchUI
        civilianSearchUI = new CivilianSearchUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the CivilianSearchUI to be visible (true)
        civilianSearchUI.setVisible(true);
    }

    /**
     * Add ActionListener for all of the buttons on the CivilianSearchUI
     */
    public void addActionListenersButtons() {
        civilianSearchUI.btnQuit.addActionListener(this);
        civilianSearchUI.btnCivilianMainMenu.addActionListener(this);
        civilianSearchUI.btnSearch.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(civilianSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The Search button was pressed
        if (obj.equals(civilianSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            civilianSearchUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(civilianSearchUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                civilianSearchUI.errorMessage.setText("Case Number: " + civilianSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                civilianSearchUI.errorMessage.setText("Case Number: " + civilianSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }

        //The Civilian Main Menu button was pressed.	
        if (obj.equals(civilianSearchUI.btnCivilianMainMenu)) {
            CivilianMainMenuCntl civilianMainMenuCntl = new CivilianMainMenuCntl();
            civilianSearchUI.dispose();
        }

    }
}
