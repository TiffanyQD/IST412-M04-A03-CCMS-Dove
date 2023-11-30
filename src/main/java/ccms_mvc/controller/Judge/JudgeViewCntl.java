package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Judge.JudgeViewUI;
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
 * This controller class that is used in conjunction with the JudgeViewUI to
 * display/view Court Case details.
 */
@Getter
@Setter
public class JudgeViewCntl implements ActionListener {

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

    //Call to JudgeViewUI object
    private JudgeViewUI judgeViewUI;

    /**
     * Constructor for JudgeViewCntl
     */
    public JudgeViewCntl() {

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

        //Instantiate JudgeViewUI
        judgeViewUI = new JudgeViewUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the JudgeViewUI to be visible (true)        
        judgeViewUI.setVisible(true);
    }

    /**
     * Call to addActionListener method to activate listener for various
     * buttons.
     */
    public void addActionListenersButtons() {
        judgeViewUI.btnQuit.addActionListener(this);
        judgeViewUI.btnJudgeMainMenu.addActionListener(this);
        judgeViewUI.btnView.addActionListener(this);
        judgeViewUI.btnNext.addActionListener(this);
        judgeViewUI.btnPrevious.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The PREVIOUS button was pressed
        if (obj.equals(judgeViewUI.btnPrevious)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals 0, then loop around to the last element in the 
            array list.
             */
            indexOfCurrentCourtCase = judgeViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }

            judgeViewUI.errorMessage.setText("");
            judgeViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            judgeViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(judgeViewUI.btnNext)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals the last element in the array list, then loop 
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = judgeViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }

            judgeViewUI.errorMessage.setText("");
            judgeViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            judgeViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(judgeViewUI.btnQuit)) {
            System.exit(0);
        }

        //The View button was pressed
        if (obj.equals(judgeViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            judgeViewUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(judgeViewUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                judgeViewUI.parseCourtCases(courtCases);
                judgeViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                judgeViewUI.errorMessage.setText("Case Number: " + judgeViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                judgeViewUI.errorMessage.setText("Case Number: " + judgeViewUI.getCaseNumberTextField() + " was NOT found. !!!");
                judgeViewUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Judge Main Menu button was pressed.	
        if (obj.equals(judgeViewUI.btnJudgeMainMenu)) {
            JudgeMainMenuCntl judgeMainMenuCntl = new JudgeMainMenuCntl();
            judgeViewUI.dispose();
        }

    }
}
