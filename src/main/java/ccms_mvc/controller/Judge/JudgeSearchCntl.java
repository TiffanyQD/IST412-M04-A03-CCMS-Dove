package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Judge.JudgeSearchUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This is the controller class that is used in conjunction with the
 * JudgeSearchUI to search Court Case details for the Civilian.
 */
public class JudgeSearchCntl implements ActionListener {

    //Create an Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Create a reference to the CourtCases object
    private CourtCases courtCases;

    //Create an ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Create a reference to the JudgeSearchUI object
    private JudgeSearchUI judgeSearchUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * JudgeSearchCntl Constructor
     */
    public JudgeSearchCntl() {

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

        //Instantiate CivilianSearchUI
        judgeSearchUI = new JudgeSearchUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the Person UI to be visible (true)
        judgeSearchUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        judgeSearchUI.btnQuit.addActionListener(this);
        judgeSearchUI.btnJudgeMainMenu.addActionListener(this);
        judgeSearchUI.btnSearch.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(judgeSearchUI.btnQuit)) {
            System.exit(0);
        }

        //The SEARCH button was pressed
        if (obj.equals(judgeSearchUI.btnSearch)) {
            //Enable all of the buttons except for Save button
            judgeSearchUI.enableButtons(true);

//            ArrayList<CourtCases> courtCasesArrayList = courtCasesList.getCourtCasesArrayList();
//            boolean caseNumberFound = false;
//            for (CourtCases courtCases : courtCasesArrayList) {
//                if (courtCases.getCaseNumber().equals(judgeSearchUI.getCaseNumberTextField())) {
//                    caseNumberFound = true;
//                    break;
//                }
//            }
            //TODO Would prefer if the following code used the listCourtCases instead of arrayCourtCases
            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(judgeSearchUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                judgeSearchUI.errorMessage.setText("Case Number: " + judgeSearchUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                judgeSearchUI.errorMessage.setText("Case Number: " + judgeSearchUI.getCaseNumberTextField() + " was NOT found. !!!");
            }

        }

        if (obj.equals(judgeSearchUI.btnJudgeMainMenu)) {
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            judgeSearchUI.dispose();
        }

    }
}
