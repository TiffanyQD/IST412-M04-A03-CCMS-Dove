package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Clerk.ClerkViewUI;
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
 * This controller class that is used in conjunction with the ClerkViewUI to
 * display/view Court Case details.
 */
@Getter
@Setter
public class ClerkViewCntl implements ActionListener {

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

    //Call to ClerkViewUI object
    private ClerkViewUI clerkViewUI;

    /**
     * Constructor for ClerkViewCntl
     */
    public ClerkViewCntl() {

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

        //Instantiate ClerkViewUI
        clerkViewUI = new ClerkViewUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the ClerkViewUI to be visible (true)
        clerkViewUI.setVisible(true);
    }

    /**
     * Call to addActionListener method to activate listener for various
     * buttons.
     */
    public void addActionListenersButtons() {
        clerkViewUI.btnQuit.addActionListener(this);
        clerkViewUI.btnClerkMainMenu.addActionListener(this);
        clerkViewUI.btnView.addActionListener(this);
        clerkViewUI.btnNext.addActionListener(this);
        clerkViewUI.btnPrevious.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The PREVIOUS button was pressed
        if (obj.equals(clerkViewUI.btnPrevious)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals 0, then loop around to the last element in the 
            array list.
             */
            indexOfCurrentCourtCase = clerkViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }

            clerkViewUI.errorMessage.setText("");
            clerkViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkViewUI.clearTheFieldsInCourtCasesUI();
            clerkViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(clerkViewUI.btnNext)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals the last element in the array list, then loop 
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = clerkViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }

            clerkViewUI.errorMessage.setText("");
            clerkViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkViewUI.clearTheFieldsInCourtCasesUI();
            clerkViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(clerkViewUI.btnQuit)) {
            System.exit(0);
        }

        //The View button was pressed
        if (obj.equals(clerkViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            clerkViewUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(clerkViewUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                clerkViewUI.clearTheFieldsInCourtCasesUI();
                clerkViewUI.parseCourtCases(courtCases);
                clerkViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                clerkViewUI.errorMessage.setText("Case Number: " + clerkViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                clerkViewUI.errorMessage.setText("Case Number: " + clerkViewUI.getCaseNumberTextField() + " was NOT found. !!!");
                clerkViewUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Clerk Main Menu button was pressed.	
        if (obj.equals(clerkViewUI.btnClerkMainMenu)) {
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            clerkViewUI.dispose();
        }

    }
}
