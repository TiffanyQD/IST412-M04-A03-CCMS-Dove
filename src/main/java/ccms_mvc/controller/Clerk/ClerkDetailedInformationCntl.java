package ccms_mvc.controller.Clerk;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.Location;
import ccms_mvc.view.Clerk.ClerkDetailedInformationUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ClerkDetailedInformationCntl implements ActionListener {

    private CourtCases[] arrayCourtCases;
    private CourtCases courtCases;
    private List<CourtCases> listCourtCases;
    ObjectMapper mapper;

    private ClerkDetailedInformationUI clerkDetailedInformationUI;
    private int indexOfCurrentCourtCase;

    public ClerkDetailedInformationCntl() {
//        personList = new PersonList();
//        courtCasesList = new CourtCasesList();

        mapper = new ObjectMapper();

        try {
            arrayCourtCases = mapper.readValue(new File("src/resources/courtCases.json"), CourtCases[].class);
            listCourtCases = Arrays.asList(arrayCourtCases);
        } catch (IOException e) {
            e.printStackTrace();
        }

        clerkDetailedInformationUI = new ClerkDetailedInformationUI(this);
        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();
        //set the Person UI to be visible (true)
        clerkDetailedInformationUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        clerkDetailedInformationUI.btnQuit.addActionListener(this);
        clerkDetailedInformationUI.btnClerkMainMenu.addActionListener(this);
        clerkDetailedInformationUI.btnView.addActionListener(this);
        clerkDetailedInformationUI.btnAdd.addActionListener(this);
        clerkDetailedInformationUI.btnUpdate.addActionListener(this);
        clerkDetailedInformationUI.btnDelete.addActionListener(this);
        clerkDetailedInformationUI.btnSave.addActionListener(this);

    }

    public List<CourtCases> getListCourtCases() {
        return listCourtCases;

    }

//    public ArrayList<CourtCases> getListOfCourtCases() {
//        return courtCasesList.getCourtCasesArrayList();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The PREVIOUS button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnUpdate)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals 0, then loop around to the last element in the 
            array list.
             */
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }

            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkDetailedInformationUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnAdd)) {
            /*
            So that you don't have problems with out of bounds, if the current 
            position equals the last element in the array list, then loop 
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }
            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            clerkDetailedInformationUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnView)) {
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(clerkDetailedInformationUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
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

        if (obj.equals(clerkDetailedInformationUI.btnClerkMainMenu)) {
            ClerkMainMenuCntl clerkMainMenuCntl = new ClerkMainMenuCntl();
            clerkDetailedInformationUI.dispose();
        }

        //The DELETE button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnDelete)) {
            if (!getListCourtCases().isEmpty()) {
                indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
                getListCourtCases().remove(indexOfCurrentCourtCase);
                if (getListCourtCases().isEmpty()) {
                    clerkDetailedInformationUI.errorMessage.setText("There are no more records to delete.");
                    clerkDetailedInformationUI.clearTheFieldsInCourtCasesUI();
                } else {
                    clerkDetailedInformationUI.parseCourtCases(getListCourtCases().get(0));
                    clerkDetailedInformationUI.setIndexOfCurrentCourtCase(0);
                }

                mapper = new ObjectMapper();

                try {
                    List<CourtCases> listCourtCases1 = getListCourtCases();
                    mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
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
            //Clear the fields in the Person UI
            clerkDetailedInformationUI.clearTheFieldsInCourtCasesUI();
        }

        //The SAVE button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnSave)) {
            //Instantiate a CourtCase class
            CourtCases court = new CourtCases();
            //Set the various fields in CourtCases to the corresponding values
            //in the ClerkDetailedInformationUI. 

            //Set the Court System field
            court.setCourtSystem(CourtSystem.valueOf(clerkDetailedInformationUI.getCourtSystemTextField().getText()));
            //Set the Location field
            court.setLocation(Location.valueOf(clerkDetailedInformationUI.getLocationTextField().getText()));
            //Set the Case Number field
            court.setCaseNumber(clerkDetailedInformationUI.getCaseNumberTextField());
            //Set the Party Name field
            court.setPartyName(clerkDetailedInformationUI.getPartyNameTextField().getText());
            //Set the Case Type field
            court.setCaseType(CaseType.valueOf(clerkDetailedInformationUI.getCaseTypeTextField().getText()));
            //Set the Filing Data field
            court.setFillingDate(clerkDetailedInformationUI.getFilingDateTextField().getText());
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

            //Add the Person to the CourtCases Array List
            getListCourtCases().add(court);

            //Set index of the current person
            indexOfCurrentCourtCase = getListCourtCases().size() - 1;
            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            //Even though the element was added, redraw the screen with the element.
            clerkDetailedInformationUI.parseCourtCases(getListCourtCases().get(indexOfCurrentCourtCase));
            //Enable all of the buttons except for Save button
            clerkDetailedInformationUI.enableButtons(true);

            try {
                List<CourtCases> listCourtCases1 = getListCourtCases();
                mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }

        //The Update button was pressed
        if (obj.equals(clerkDetailedInformationUI.btnUpdate)) {
            indexOfCurrentCourtCase = clerkDetailedInformationUI.getIndexOfCurrentCourtCase();
            CourtCases cc = getListCourtCases().get(indexOfCurrentCourtCase);

            //Update the record with the various fields from the PersonUI. 
            getListCourtCases().get(indexOfCurrentCourtCase).setCourtSystem(CourtSystem.valueOf(clerkDetailedInformationUI.getCourtSystemTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setLocation(Location.valueOf(clerkDetailedInformationUI.getLocationTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseNumber(clerkDetailedInformationUI.getCaseNumberTextField());
            getListCourtCases().get(indexOfCurrentCourtCase).setPartyName(clerkDetailedInformationUI.getPartyNameTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseType(CaseType.valueOf(clerkDetailedInformationUI.getCaseTypeTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setFillingDate(clerkDetailedInformationUI.getFilingDateTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setCaseStatus(CaseStatus.valueOf(clerkDetailedInformationUI.getCaseStatusTextField().getText()));
            getListCourtCases().get(indexOfCurrentCourtCase).setPlantiff(clerkDetailedInformationUI.getPlantiffTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setDefendant(clerkDetailedInformationUI.getDefendantTextField().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setJudgeInformation(clerkDetailedInformationUI.getJudgeCommentsTextArea().getText());
            getListCourtCases().get(indexOfCurrentCourtCase).setLawyerInformation(clerkDetailedInformationUI.getLawyerCommentsTextArea().getText());

            //Set index of the current person
            clerkDetailedInformationUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            //Even though the element was added, redraw the screen with the element.
            clerkDetailedInformationUI.parseCourtCases(getListCourtCases().get(indexOfCurrentCourtCase));

            try {
                List<CourtCases> listCourtCases1 = getListCourtCases();
                mapper.writeValue(new File("src/resources/courtCases.json"), listCourtCases1);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }
    }
}
