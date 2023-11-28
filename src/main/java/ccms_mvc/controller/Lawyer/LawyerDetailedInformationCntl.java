package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.Location;
import ccms_mvc.view.Lawyer.LawyerDetailedInformationUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This class will allow the lawyer to view, add, delete, update, and save
 * detailed court case information.
 */
public class LawyerDetailedInformationCntl implements ActionListener {

    private CourtCases[] arrayCourtCases;
    private CourtCases courtCases;
    private List<CourtCases> listCourtCases;
    ObjectMapper mapper;

    private LawyerDetailedInformationUI lawyerDetailedInformationUI;
    private int indexOfCurrentCourtCase;

    public LawyerDetailedInformationCntl() {

        //Instantiate ObjectMapper to read json from a file.
        mapper = new ObjectMapper();

        try {
            //Read the court case information into an array (arrayCourtCases)
            arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);
            //Convert array(arrayCourtCases) to an ArrayList(listCourtCases)
            listCourtCases = Arrays.asList(arrayCourtCases);
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

    /**
     * Method to retrieve an ArrayList of CourtCases
     */
    public List<CourtCases> getListCourtCases() {
        return listCourtCases;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //TODO Convert references of arrayCourtCases to listCourtCases

        
        
        
        
        //The QUIT button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(lawyerDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                lawyerDetailedInformationUI.parseCourtCases(courtCases);
                lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                lawyerDetailedInformationUI.errorMessage.setText("Case Number: " + lawyerDetailedInformationUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerDetailedInformationUI.errorMessage.setText("Case Number: " + lawyerDetailedInformationUI.getCaseNumberTextField() + " was NOT found. !!!");
                lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
            }

        }

        if (obj.equals(lawyerDetailedInformationUI.btnLawyerMainMenu)) {
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            lawyerDetailedInformationUI.dispose();
        }

        //The DELETE button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnDelete)) {
            if (!getListCourtCases().isEmpty()) {
                indexOfCurrentCourtCase = lawyerDetailedInformationUI.getIndexOfCurrentCourtCase();
                getListCourtCases().remove(indexOfCurrentCourtCase);
                if (getListCourtCases().isEmpty()) {
                    lawyerDetailedInformationUI.errorMessage.setText("There are no more records to delete.");
                    lawyerDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                } else {
                    lawyerDetailedInformationUI.parseCourtCases(getListCourtCases().get(0));
                    lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(0);
                }

                mapper = new ObjectMapper();

                try {
                    List<CourtCases> listCourtCases1 = getListCourtCases();
                    mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
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
            //Instantiate a CourtCase class
            CourtCases court = new CourtCases();
            //Set the various fields in CourtCases to the corresponding values
            //in the LawyerDetailedInformationUI. 

            //Set the Court System field
            court.setCourtSystem(CourtSystem.valueOf(lawyerDetailedInformationUI.getCourtSystemTextField().getText()));
            //Set the Location field
            court.setLocation(Location.valueOf(lawyerDetailedInformationUI.getLocationTextField().getText()));
            //Set the Case Number field
            court.setCaseNumber(lawyerDetailedInformationUI.getCaseNumberTextField());
            //Set the Party Name field
            court.setPartyName(lawyerDetailedInformationUI.getPartyNameTextField().getText());
            //Set the Case Type field
            court.setCaseType(CaseType.valueOf(lawyerDetailedInformationUI.getCaseTypeTextField().getText()));
            //Set the Filing Data field
            court.setFillingDate(lawyerDetailedInformationUI.getFilingDateTextField().getText());
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
            getListCourtCases().add(court);

            //Set index of the current court case
            indexOfCurrentCourtCase = getListCourtCases().size() - 1;
            lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            //Even though the element was added, redraw the screen with the element.
            lawyerDetailedInformationUI.parseCourtCases(getListCourtCases().get(indexOfCurrentCourtCase));
            //Enable all of the buttons except for Save button
            lawyerDetailedInformationUI.enableButtons(true);

            try {
                List<CourtCases> listCourtCases1 = getListCourtCases();
                mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }

        //The Update button was pressed
        if (obj.equals(lawyerDetailedInformationUI.btnUpdate)) {
            indexOfCurrentCourtCase = lawyerDetailedInformationUI.getIndexOfCurrentCourtCase();
            CourtCases cc = getListCourtCases().get(indexOfCurrentCourtCase);

            //Update the record with the various fields from the PersonUI. 
            getListCourtCases().get(indexOfCurrentCourtCase).setCourtSystem(CourtSystem.valueOf(lawyerDetailedInformationUI.getCourtSystemTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setLocation(Location.valueOf(lawyerDetailedInformationUI.getLocationTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseNumber(lawyerDetailedInformationUI.getCaseNumberTextField());
            getListCourtCases().get(indexOfCurrentCourtCase).setPartyName(lawyerDetailedInformationUI.getPartyNameTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseType(CaseType.valueOf(lawyerDetailedInformationUI.getCaseTypeTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setFillingDate(lawyerDetailedInformationUI.getFilingDateTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseStatus(CaseStatus.valueOf(lawyerDetailedInformationUI.getCaseStatusTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setPlantiff(lawyerDetailedInformationUI.getPlantiffTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setDefendant(lawyerDetailedInformationUI.getDefendantTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setJudgeInformation(lawyerDetailedInformationUI.getJudgeCommentsTextArea().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setLawyerInformation(lawyerDetailedInformationUI.getLawyerCommentsTextArea().getText());

            //Set index of the current person
            lawyerDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            //Even though the element was added, redraw the screen with the element.
            lawyerDetailedInformationUI.parseCourtCases(getListCourtCases().get(indexOfCurrentCourtCase));

            try {
                List<CourtCases> listCourtCases1 = getListCourtCases();
                mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }
    }
}
