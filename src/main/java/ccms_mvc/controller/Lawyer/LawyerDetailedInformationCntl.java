package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.CourtLocation;
import ccms_mvc.view.Lawyer.LawyerDetailedInformationUI;
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
 * This class will allow the lawyer to view, add, delete, update, and save
 * detailed court case information.
 */
@Getter
@Setter
public class LawyerDetailedInformationCntl implements ActionListener {

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

    //Create a refernce to LawyerDetailedInformationUI
    private LawyerDetailedInformationUI lawyerDetailedInformationUI;

    /**
     * LawyerDetailedInformationCntl Constructor
     */
    public LawyerDetailedInformationCntl() {

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

        //Instantiate LawyerDetailedInformationUI
        lawyerDetailedInformationUI = new LawyerDetailedInformationUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the LawyerDetailedInformationUI to be visible (true)
        lawyerDetailedInformationUI.setVisible(true);
        //Enable all of the buttons except for Save button
        lawyerDetailedInformationUI.enableButtons(true);
    }

    /**
     * This method will activate the ActionListener for all of the buttons.
     */
    public void addActionListenersButtons() {
        lawyerDetailedInformationUI.btnQuit.addActionListener(this);
        lawyerDetailedInformationUI.btnLawyerMainMenu.addActionListener(this);
        lawyerDetailedInformationUI.btnView.addActionListener(this);
        lawyerDetailedInformationUI.btnAdd.addActionListener(this);
        lawyerDetailedInformationUI.btnUpdate.addActionListener(this);
        lawyerDetailedInformationUI.btnDelete.addActionListener(this);
        lawyerDetailedInformationUI.btnSave.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The VIEW button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(lawyerDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                lawyerDetailedInformationUI.parseCourtCases(courtCases);
                lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                lawyerDetailedInformationUI.errorMessage.setText("Case Number: " + lawyerDetailedInformationUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerDetailedInformationUI.errorMessage.setText("Case Number: " + lawyerDetailedInformationUI.getCaseNumberTextField() + " was NOT found. !!!");
                lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Lawyer Main Menu button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnLawyerMainMenu)) {
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            lawyerDetailedInformationUI.dispose();
        }

        //The DELETE button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnDelete)) {
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);

            if (!arrayListCourtCases.isEmpty()) {
                indexOfCurrentCourtCase = lawyerDetailedInformationUI.getIndexOfCurrentCourtCase();
                arrayListCourtCases.remove(indexOfCurrentCourtCase);
                if (arrayListCourtCases.isEmpty()) {
                    lawyerDetailedInformationUI.errorMessage.setText("There are no more records to delete.");
                    lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                } else {
                    lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                    lawyerDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(0));
                    lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(0);
                }

                mapper = new ObjectMapper();

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            } else {
                lawyerDetailedInformationUI.errorMessage.setText("Empty List. You cannot delete any elements.");
            }

        }

        //The ADD button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnAdd)) {
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(false);
            //Clear the fields in the LawyerDetailedInformationUI
            lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
        }

        //The SAVE button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnSave)) {
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);
            //Instantiate a CourtCase class
            CourtCases court = new CourtCases();

            //Set the various fields in CourtCases to the corresponding values
            //in the LawyerDetailedInformationUI. 
            try {
                //Set the Court System field
                court.setCourtSystem(CourtSystem.valueOf(lawyerDetailedInformationUI.getCourtSystemTextField().getText()));
                //Set the CourtLocation field
                court.setLocation(CourtLocation.valueOf(lawyerDetailedInformationUI.getLocationTextField().getText()));
                //Set the Case Number field
                court.setCaseNumber(lawyerDetailedInformationUI.getCaseNumberTextField());
                //Set the Party Name field
                court.setPartyName(lawyerDetailedInformationUI.getPartyNameTextField().getText());
                //Set the Case Type field
                court.setCaseType(CaseType.valueOf(lawyerDetailedInformationUI.getCaseTypeTextField().getText()));
                //Set the Filing Data field
                court.setFilingDate(lawyerDetailedInformationUI.getFilingDateTextField().getText());
                //Set the Case Status 
                court.setCaseStatus(CaseStatus.valueOf(lawyerDetailedInformationUI.getCaseStatusTextField().getText()));
                //Set the Plantiff
                court.setPlantiff(lawyerDetailedInformationUI.getPlantiffTextField().getText());
                //Set the Defendant
                court.setDefendant(lawyerDetailedInformationUI.getDefendantTextField().getText());
                //Set the Judge Comments
                court.setJudgeInformation(lawyerDetailedInformationUI.getJudgeCommentsTextArea().getText());
                //Set the Lawyer Comments
                court.setLawyerInformation(lawyerDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Add the CourtCases to the CourtCases Array List
                arrayListCourtCases.add(court);

                //Set index of the current court case
                indexOfCurrentCourtCase = arrayListCourtCases.size() - 1;
                lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Clear the fields in the Court Case UI
                lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                //Even though the element was added, redraw the screen with the element.
                lawyerDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));
                //Enable all of the buttons except for Save button
                lawyerDetailedInformationUI.enableButtons(true);

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                lawyerDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }

        //The Update button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnUpdate)) {
            indexOfCurrentCourtCase = lawyerDetailedInformationUI.getIndexOfCurrentCourtCase();
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);

            try {
                //Update the record with the various fields from the LawyerDetailedInformationUI. 
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCourtSystem(CourtSystem.valueOf(lawyerDetailedInformationUI.getCourtSystemTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLocation(CourtLocation.valueOf(lawyerDetailedInformationUI.getLocationTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseNumber(lawyerDetailedInformationUI.getCaseNumberTextField());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPartyName(lawyerDetailedInformationUI.getPartyNameTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseType(CaseType.valueOf(lawyerDetailedInformationUI.getCaseTypeTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setFilingDate(lawyerDetailedInformationUI.getFilingDateTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseStatus(CaseStatus.valueOf(lawyerDetailedInformationUI.getCaseStatusTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPlantiff(lawyerDetailedInformationUI.getPlantiffTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setDefendant(lawyerDetailedInformationUI.getDefendantTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setJudgeInformation(lawyerDetailedInformationUI.getJudgeCommentsTextArea().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLawyerInformation(lawyerDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Set index of the current Court Case
                lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Clear the fields in the Court Case UI
                lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                //Even though the element was added, redraw the screen with the element.
                lawyerDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                lawyerDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }
    }
}
