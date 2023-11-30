package ccms_mvc.controller.Lawyer;

import ccms_mvc.model.CourtCases;
import ccms_mvc.view.Lawyer.LawyerViewUI;
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
 * This controller class that is used in conjunction with the LawyerViewUI to
 * display/view Court Case details.
 */
@Getter
@Setter
public class LawyerViewCntl implements ActionListener {

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

    //Call to LawyerViewUI object
    private LawyerViewUI lawyerViewUI;

    /**
     * Constructor for LawyerViewCntl
     */
    public LawyerViewCntl() {

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

            lawyerViewUI.errorMessage.setText("");
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

            lawyerViewUI.errorMessage.setText("");
            lawyerViewUI.setIndexOfCurrentCourtCase(indexOfCurrentCourtCase);
            lawyerViewUI.parseCourtCases(arrayCourtCases[indexOfCurrentCourtCase]);
        }

        //The QUIT button was pressed
        if (obj.equals(lawyerViewUI.btnQuit)) {
            System.exit(0);
        }

        //The VIEW button was pressed
        if (obj.equals(lawyerViewUI.btnView)) {
            //Enable all of the buttons except for Save button
            lawyerViewUI.enableButtons(true);

            boolean caseNumberFound = false;
            for (int i = 0; i < arrayListCourtCases.size(); i++) {
                if (arrayListCourtCases.get(i).getCaseNumber().equals(lawyerViewUI.getCaseNumberTextField())) {
                    courtCases = arrayListCourtCases.get(i);
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
