package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Clerk.ClerkViewUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This controller class that is used in conjunction with the ClerkViewUI to
 * display/view Court Case details.
 */
public class ClerkViewCntl implements ActionListener {

    //Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Call CourCases object
    private CourtCases courtCases;

    //ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Call to ClerkViewUI object
    private ClerkViewUI clerkViewUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * Constructor for ClerkViewCntl
     */
    public ClerkViewCntl() {

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

    public List<CourtCases> getListCourtCases() {
        return listCourtCases;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //TODO Would prefer if the following code used the listCourtCases instead of arrayCourtCases
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
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(clerkViewUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
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
