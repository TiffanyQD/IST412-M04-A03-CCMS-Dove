package ccms_mvc.controller.Judge;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Judge.JudgeViewUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This controller class that is used in conjunction with the JudgeViewUI to
 * display/view Court Case details.
 */
public class JudgeViewCntl implements ActionListener {

    //Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Call CourCases object
    private CourtCases courtCases;

    //ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Call to JudgeViewUI object
    private JudgeViewUI judgeViewUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * Constructor for JudgeViewCntl
     */
    public JudgeViewCntl() {

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

        //Instantiate JudgeViewUI
        judgeViewUI = new JudgeViewUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the JudgeViewUI to be visible (true)        
        judgeViewUI.setVisible(true);
    }

    /**
     * Call to addActionListener method to activiate listener for various
     * buttons.
     */
    public void addActionListenersButtons() {
        judgeViewUI.btnQuit.addActionListener(this);
        judgeViewUI.btnJudgeMainMenu.addActionListener(this);
        judgeViewUI.btnView.addActionListener(this);

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
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(judgeViewUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
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
