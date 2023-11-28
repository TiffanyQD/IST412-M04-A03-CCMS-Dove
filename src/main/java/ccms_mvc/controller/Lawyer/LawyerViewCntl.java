package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Lawyer.LawyerViewUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This controller class that is used in conjunction with the LawyerViewUI to
 * display/view Court Case details.
 */
public class LawyerViewCntl implements ActionListener {

    //Array of CourtCases
    private CourtCases[] arrayCourtCases;

    //Call CourCases object
    private CourtCases courtCases;

    //ArrayList of CourtCases
    private List<CourtCases> listCourtCases;

    //Call to LawyerViewUI object
    private LawyerViewUI lawyerViewUI;

    //Index of the Current Court Case
    private int indexOfCurrentCourtCase;

    /**
     * Constructor for LawyerViewCntl
     */
    public LawyerViewCntl() {

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

        //Instantiate LawyerViewUI
        lawyerViewUI = new LawyerViewUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the LawyerViewUI to be visible (true)
        lawyerViewUI.setVisible(true);
    }

    public void addActionListenersButtons() {
        lawyerViewUI.btnQuit.addActionListener(this);
        lawyerViewUI.btnLawyerMainMenu.addActionListener(this);
        lawyerViewUI.btnView.addActionListener(this);
        lawyerViewUI.btnNext.addActionListener(this);
        lawyerViewUI.btnPrevious.addActionListener(this);

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
        if (obj.equals(lawyerViewUI.btnPrevious)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals 0, then loop around to the last element in the
            array list.
             */
            indexOfCurrentCourtCase = lawyerViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == 0) {
                indexOfCurrentCourtCase = arrayCourtCases.length - 1;
            } else {
                indexOfCurrentCourtCase--;
            }

            lawyerViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            lawyerViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The NEXT button was pressed
        if (obj.equals(lawyerViewUI.btnNext)) {
            /*
            So that you don't have problems with out of bounds, if the current
            position equals the last element in the array list, then loop
            around to the first element in the array list.
             */
            indexOfCurrentCourtCase = lawyerViewUI.getIndexOfCurrentCourtCase();
            if (indexOfCurrentCourtCase == arrayCourtCases.length - 1) {
                indexOfCurrentCourtCase = 0;
            } else {
                indexOfCurrentCourtCase++;
            }
            lawyerViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            lawyerViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(lawyerViewUI.btnQuit)) {
            System.exit(0);
        }

        //The View button was pressed
        if (obj.equals(lawyerViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            lawyerViewUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayCourtCases.length; i++) {
                if (arrayCourtCases[i].getCaseNumber().equals(lawyerViewUI.getCaseNumberTextField())) {
                    courtCases = arrayCourtCases[i];
                    indexOfCurrentCourtCase = i;
                    caseNumberFound = true;
                    break;
                }
            }

            if (caseNumberFound) {
                lawyerViewUI.parseCourtCases(courtCases);
                lawyerViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
                lawyerViewUI.errorMessage.setText("Case Number: " + lawyerViewUI.getCaseNumberTextField() + " was found. !!!");
            } else {
                lawyerViewUI.errorMessage.setText("Case Number: " + lawyerViewUI.getCaseNumberTextField() + " was NOT found. !!!");
                lawyerViewUI.clearTheFieldsInCourtCasesUI();
            }

        }

        //The Lawyer Main Menu button was pressed.
        if (obj.equals(lawyerViewUI.btnLawyerMainMenu)) {
            LawyerMainMenuCntl lawyerMainMenuCntl = new LawyerMainMenuCntl();
            lawyerViewUI.dispose();
        }

    }
}
