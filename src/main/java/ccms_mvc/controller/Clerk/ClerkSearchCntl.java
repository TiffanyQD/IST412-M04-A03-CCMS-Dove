package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Clerk.ClerkSearchUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This is the controller class that is used in conjunction with the
 * ClerkSearchUI to search Court Case details.
 */
public class ClerkSearchCntl implements ActionListener {

    //Create an Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Create a reference to the CourtCases object
    private CourtCases courtCases;

    //Create an ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Create a reference to the ClerkSearchUI object
    private ClerkSearchUI clerkSearchUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * ClerkSearchCntl Constructor
     */
    public ClerkSearchCntl() {

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

        //Instantiate ClerkSearchUI
        clerkSearchUI = new ClerkSearchUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the Person UI to be visible (true)
        clerkSearchUI.setVisible(true);
    }

    /**
     * Add ActionListener for all of the buttons on the clerkSearchUI
     */
    public void addActionListenersButtons() {
        clerkSearchUI.btnQuit.addActionListener(this);
        clerkSearchUI.btnClerkMainMenu.addActionListener(this);
        clerkSearchUI.btnSearch.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(clerkSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The SEARCH button was pressed
        if (obj.equals(clerkSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            clerkSearchUI.enableButtons(true);

//            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
//            boolean caseNumberFound = false;
//            for (CourtCases courtCases : courtCasesArrayList) {
//                if (courtCases.getCaseNumber().equals(clerkSearchUI.getCaseNumberTextField())) {
//                    caseNumberFound = true;
//                    break;
//                }
//            }
            //TODO Would prefer if the following code used the listCourtCases instead of arrayCourtCases
            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(clerkSearchUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
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

        //The Clerk Main Menu button was pressed.	
        if (obj.equals(clerkSearchUI.btnClerkMainMenu)) {
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            clerkSearchUI.dispose();
        }

    }
}
