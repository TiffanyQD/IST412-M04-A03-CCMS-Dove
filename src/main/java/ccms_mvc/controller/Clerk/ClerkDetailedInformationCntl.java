package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.CourtLocation;
import ccms_mvc.view.Clerk.ClerkDetailedInformationUI;
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
 * This class will allow the clerk/admin to view, add, delete, update, and save
 * detailed court case information.
 */
@Getter
@Setter
public class ClerkDetailedInformationCntl implements ActionListener {

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

    //Create a refernce to ClerkDetailedInformationUI
    private ClerkDetailedInformationUI clerkDetailedInformationUI;

    /**
     * ClerkDetailedInformationCntl Constructor
     */
    public ClerkDetailedInformationCntl() {

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

        //Instantiate ClerkDetailedInformationUI
        clerkDetailedInformationUI = new ClerkDetailedInformationUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the ClerDetailedInformationUI to be visible (true)
        clerkDetailedInformationUI.setVisible(true);
        //Enable all of the buttons except for Save button
        clerkDetailedInformationUI.enableButtons(true);
    }

    /**
     * This method will activate the ActionListener for all of the buttons.
     */
    public void addActionListenersButtons() {
        clerkDetailedInformationUI.btnQuit.addActionListener(this);
        clerkDetailedInformationUI.btnClerkMainMenu.addActionListener(this);
        clerkDetailedInformationUI.btnView.addActionListener(this);
        clerkDetailedInformationUI.btnAdd.addActionListener(this);
        clerkDetailedInformationUI.btnUpdate.addActionListener(this);
        clerkDetailedInformationUI.btnDelete.addActionListener(this);
        clerkDetailedInformationUI.btnSave.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The VIEW button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(clerkDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
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

        //The Clerk Main Menu button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnClerkMainMenu)) {
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            clerkDetailedInformationUI.dispose();
        }

        //The DELETE button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnDelete)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);

            if (!arrayListCourtCases.isEmpty()) {
                indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
                arrayListCourtCases.remove(indexOfCurrentCourtCase);
                if (arrayListCourtCases.isEmpty()) {
                    clerkDetailedInformationUI.errorMessage.setText("There are no more records to delete.");
                    clerkDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                } else {
                    clerkDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(0));
                    clerkDetailedInformationUI.setIndexOfCurrentCourtCase(0);
                }

                mapper = new ObjectMapper();

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            } else {
                clerkDetailedInformationUI.errorMessage.setText("Empty List. You cannot delete any elements.");
            }

        }

        //The ADD button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnAdd)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(false);
            //Clear the fields in the ClerkDetailedInformationUI
            clerkDetailedInformationUI.clearTheFieldsInCourtCasesUI();
        }

        //The SAVE button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnSave)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);
            //Instantiate a CourtCase class
            CourtCases court = new CourtCases();

            //Set the various fields in CourtCases to the corresponding values
            //in the ClerkDetailedInformationUI. 
            try {
                //Set the Court System field
                court.setCourtSystem(CourtSystem.valueOf(clerkDetailedInformationUI.getCourtSystemTextField().getText()));
                //Set the CourtLocation field
                court.setLocation(CourtLocation.valueOf(clerkDetailedInformationUI.getLocationTextField().getText()));
                //Set the Case Number field
                court.setCaseNumber(clerkDetailedInformationUI.getCaseNumberTextField());
                //Set the Party Name field
                court.setPartyName(clerkDetailedInformationUI.getPartyNameTextField().getText());
                //Set the Case Type field
                court.setCaseType(CaseType.valueOf(clerkDetailedInformationUI.getCaseTypeTextField().getText()));
                //Set the Filing Data field
                court.setFilingDate(clerkDetailedInformationUI.getFilingDateTextField().getText());
                //Set the Case Status 
                court.setCaseStatus(CaseStatus.valueOf(clerkDetailedInformationUI.getCaseStatusTextField().getText()));
                //Set the Plantiff
                court.setPlantiff(clerkDetailedInformationUI.getPlantiffTextField().getText());
                //Set the Defendant
                court.setDefendant(clerkDetailedInformationUI.getDefendantTextField().getText());
                //Set the Judge Comments
                court.setJudgeInformation(clerkDetailedInformationUI.getJudgeCommentsTextArea().getText());
                //Set the Lawyer Comments
                court.setLawyerInformation(clerkDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Add the CourtCases to the CourtCases Array List
                arrayListCourtCases.add(court);

                //Set index of the current court case
                indexOfCurrentCourtCase = arrayListCourtCases.size() - 1;
                clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Even though the element was added, redraw the screen with the element.
                clerkDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));
                //Enable all of the buttons except for Save button
                clerkDetailedInformationUI.enableButtons(true);

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                clerkDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }

        //The Update button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnUpdate)) {
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);

            try {
                //Update the record with the various fields from the PersonUI. 
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCourtSystem(CourtSystem.valueOf(clerkDetailedInformationUI.getCourtSystemTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLocation(CourtLocation.valueOf(clerkDetailedInformationUI.getLocationTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseNumber(clerkDetailedInformationUI.getCaseNumberTextField());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPartyName(clerkDetailedInformationUI.getPartyNameTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseType(CaseType.valueOf(clerkDetailedInformationUI.getCaseTypeTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setFilingDate(clerkDetailedInformationUI.getFilingDateTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseStatus(CaseStatus.valueOf(clerkDetailedInformationUI.getCaseStatusTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPlantiff(clerkDetailedInformationUI.getPlantiffTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setDefendant(clerkDetailedInformationUI.getDefendantTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setJudgeInformation(clerkDetailedInformationUI.getJudgeCommentsTextArea().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLawyerInformation(clerkDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Set index of the current person
                clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Even though the element was added, redraw the screen with the element.
                clerkDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                clerkDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }
    }
}
