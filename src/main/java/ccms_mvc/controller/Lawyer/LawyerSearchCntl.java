package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Lawyer.LawyerSearchUI;
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
 * LawyerSearchUI to search Court Case details.
 */
@Getter
@Setter
public class LawyerSearchCntl implements ActionListener {

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

    //Create a reference to the LawyerSearchUI object
    private LawyerSearchUI lawyerSearchUI;

    /**
     * LawyerSearchCntl Constructor
     */
    public LawyerSearchCntl() {

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

        //Instantiate LawyerSearchUI
        lawyerSearchUI = new LawyerSearchUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the Person UI to be visible (true)
        lawyerSearchUI.setVisible(true);
    }

    /**
     * Add ActionListener for all of the buttons on the lawyerSearchUI
     */
    public void addActionListenersButtons() {
        lawyerSearchUI.btnQuit.addActionListener(this);
        lawyerSearchUI.btnLawyerMainMenu.addActionListener(this);
        lawyerSearchUI.btnSearch.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed.
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(lawyerSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The SEARCH button was pressed
        if (obj.equals(lawyerSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            lawyerSearchUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(lawyerSearchUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                lawyerSearchUI.errorMessage.setText("Case Number: " + lawyerSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerSearchUI.errorMessage.setText("Case Number: " + lawyerSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }

        //The Lawyer Main Menu button was pressed.
        if (obj.equals(lawyerSearchUI.btnLawyerMainMenu)) {
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            lawyerSearchUI.dispose();
        }

    }
}
