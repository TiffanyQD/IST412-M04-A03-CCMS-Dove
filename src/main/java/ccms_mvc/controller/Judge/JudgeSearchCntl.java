package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Judge.JudgeSearchUI;
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
 * JudgeSearchUI to search Court Case details for the Civilian.
 */
@Getter
@Setter
public class JudgeSearchCntl implements ActionListener {

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

    //Create a reference to the JudgeSearchUI object
    private JudgeSearchUI judgeSearchUI;

    /**
     * JudgeSearchCntl Constructor
     */
    public JudgeSearchCntl() {

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

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(judgeSearchUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
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
