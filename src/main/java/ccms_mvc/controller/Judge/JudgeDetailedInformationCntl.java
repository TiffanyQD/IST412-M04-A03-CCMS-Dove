package ccms_mvc.controller.Judge;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.CourtLocation;
import ccms_mvc.view.Judge.JudgeDetailedInformationUI;
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
 * This class will allow the judge to view, add, delete, update, and save
 * detailed court case information.
 */
@Getter
@Setter
public class JudgeDetailedInformationCntl implements ActionListener {

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

    //Create a refernce to JudgeDetailedInformationUI
    private JudgeDetailedInformationUI judgeDetailedInformationUI;

    /**
     * JudgeDetailedInformationCntl Constructor
     */
    public JudgeDetailedInformationCntl() {

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

        //Instantiate JudgeDetailedInformationUI
        judgeDetailedInformationUI = new JudgeDetailedInformationUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the JudgeDetailedInformationUI to be visible (true)
        judgeDetailedInformationUI.setVisible(true);
        //Enable all of the buttons except for Save button
        judgeDetailedInformationUI.enableButtons(true);
    }

    /**
     * This method will activate the ActionListener for all of the buttons.
     */
    public void addActionListenersButtons() {
        judgeDetailedInformationUI.btnQuit.addActionListener(this);
        judgeDetailedInformationUI.btnJudgeMainMenu.addActionListener(this);
        judgeDetailedInformationUI.btnView.addActionListener(this);
        judgeDetailedInformationUI.btnAdd.addActionListener(this);
        judgeDetailedInformationUI.btnUpdate.addActionListener(this);
        judgeDetailedInformationUI.btnDelete.addActionListener(this);
        judgeDetailedInformationUI.btnSave.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The VIEW button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            judgeDetailedInformationUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(judgeDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                judgeDetailedInformationUI.parseCourtCases(courtCases);
                judgeDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                judgeDetailedInformationUI.errorMessage.setText("Case Number: " + judgeDetailedInformationUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                judgeDetailedInformationUI.errorMessage.setText("Case Number: " + judgeDetailedInformationUI.getCaseNumberTextField() + " was NOT found. !!!");
                judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Judge Main Menu button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnJudgeMainMenu)) {
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            judgeDetailedInformationUI.dispose();
        }

        //The DELETE button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnDelete)) {
            //Enable all of the buttons except for Save button
            judgeDetailedInformationUI.enableButtons(true);

            if (!arrayListCourtCases.isEmpty()) {
                indexOfCurrentCourtCase = judgeDetailedInformationUI.getIndexOfCurrentCourtCase();
                arrayListCourtCases.remove(indexOfCurrentCourtCase);
                if (arrayListCourtCases.isEmpty()) {
                    judgeDetailedInformationUI.errorMessage.setText("There are no more records to delete.");
                    judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                } else {
                    judgeDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(0));
                    judgeDetailedInformationUI.setIndexOfCurrentCourtCase(0);
                }

                mapper = new ObjectMapper();

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            } else {
                judgeDetailedInformationUI.errorMessage.setText("Empty List. You cannot delete any elements.");
            }

        }

        //The ADD button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnAdd)) {
            //Enable all of the buttons except for Save button
            judgeDetailedInformationUI.enableButtons(false);
            //Clear the fields in the JudgeDetailedInformationUI
            judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
        }

        //The SAVE button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnSave)) {
            //Enable all of the buttons except for Save button
            judgeDetailedInformationUI.enableButtons(true);
            //Instantiate a CourtCase class
            CourtCases court = new CourtCases();

            //Set the various fields in CourtCases to the corresponding values
            //in the JudgeDetailedInformationUI. 
            try {
                //Set the Court System field
                court.setCourtSystem(CourtSystem.valueOf(judgeDetailedInformationUI.getCourtSystemTextField().getText()));
                //Set the CourtLocation field
                court.setLocation(CourtLocation.valueOf(judgeDetailedInformationUI.getLocationTextField().getText()));
                //Set the Case Number field
                court.setCaseNumber(judgeDetailedInformationUI.getCaseNumberTextField());
                //Set the Party Name field
                court.setPartyName(judgeDetailedInformationUI.getPartyNameTextField().getText());
                //Set the Case Type field
                court.setCaseType(CaseType.valueOf(judgeDetailedInformationUI.getCaseTypeTextField().getText()));
                //Set the Filing Data field
                court.setFilingDate(judgeDetailedInformationUI.getFilingDateTextField().getText());
                //Set the Case Status 
                court.setCaseStatus(CaseStatus.valueOf(judgeDetailedInformationUI.getCaseStatusTextField().getText()));
                //Set the Plantiff
                court.setPlantiff(judgeDetailedInformationUI.getPlantiffTextField().getText());
                //Set the Defendant
                court.setDefendant(judgeDetailedInformationUI.getDefendantTextField().getText());
                //Set the Judge Comments
                court.setJudgeInformation(judgeDetailedInformationUI.getJudgeCommentsTextArea().getText());
                //Set the Lawyer Comments
                court.setLawyerInformation(judgeDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Add the CourtCases to the CourtCases Array List
                arrayListCourtCases.add(court);

                //Set index of the current court case
                indexOfCurrentCourtCase = arrayListCourtCases.size() - 1;
                judgeDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Clear the fields in the Court Case UI
                judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                //Even though the element was added, redraw the screen with the element.
                judgeDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));
                //Enable all of the buttons except for Save button
                judgeDetailedInformationUI.enableButtons(true);

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                judgeDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }

        //The Update button was pressed
        if (obj.equals(judgeDetailedInformationUI.btnUpdate)) {
            indexOfCurrentCourtCase = judgeDetailedInformationUI.getIndexOfCurrentCourtCase();
            //Enable all of the buttons except for Save button
            judgeDetailedInformationUI.enableButtons(true);

            try {
                //Update the record with the various fields from the JudgeDetailedInformationUI. 
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCourtSystem(CourtSystem.valueOf(judgeDetailedInformationUI.getCourtSystemTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLocation(CourtLocation.valueOf(judgeDetailedInformationUI.getLocationTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseNumber(judgeDetailedInformationUI.getCaseNumberTextField());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPartyName(judgeDetailedInformationUI.getPartyNameTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseType(CaseType.valueOf(judgeDetailedInformationUI.getCaseTypeTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setFilingDate(judgeDetailedInformationUI.getFilingDateTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setCaseStatus(CaseStatus.valueOf(judgeDetailedInformationUI.getCaseStatusTextField().getText()));
                arrayListCourtCases.get(indexOfCurrentCourtCase).setPlantiff(judgeDetailedInformationUI.getPlantiffTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setDefendant(judgeDetailedInformationUI.getDefendantTextField().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setJudgeInformation(judgeDetailedInformationUI.getJudgeCommentsTextArea().getText());
                arrayListCourtCases.get(indexOfCurrentCourtCase).setLawyerInformation(judgeDetailedInformationUI.getLawyerCommentsTextArea().getText());

                //Set index of the current Court Case
                judgeDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                //Clear the fields in the Court Case UI
                judgeDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                //Even though the element was added, redraw the screen with the element.
                judgeDetailedInformationUI.parseCourtCases(arrayListCourtCases.get(indexOfCurrentCourtCase));

                try {
                    mapper.writeValue(new File("src/resources/courtCases.json"), arrayListCourtCases);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception ex) {
                judgeDetailedInformationUI.errorMessage.setText("Problem with the data that was entered. Please correct the data that was entered.");
            }

        }
    }
}
