package ccms_mvc.controller;

import ccms_mvc.model.LoginInformation;
import ccms_mvc.view.LoginUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * This is the LoginIdCntl class. It responsible for see whether or not the user
 * has the right credentials to log into the Court Case Management System.
 *
 * The class checks the loginID and password. If the user is not authorized,
 * then an error message is conveyed to the user that there is an invalid ID and
 * password combination.
 *
 * The LoginIdCntrl class uses ObjectMapper which is a good tool for reading and
 * writing Json. The class will read the file, loginInformation.json, and assign
 * the values to a LoginInformation array.
 */
public class LoginIdCntl implements ActionListener {

    //Call to LoginUI object
    private LoginUI loginUI;

    //Create an Array of LoginInformation 
    private LoginInformation[] listLoginInformation;

    /**
     * LoginIdCntl Constructor
     */
    public LoginIdCntl() {

        //Instantiate ObjectMapper and use the variable mapper
        ObjectMapper mapper = new ObjectMapper();

        try {
            //Read the json file, loginInformation, and assign the results to the array, LoginInformation
            listLoginInformation = mapper.readValue(new File("src/resources/loginInformation.json"), LoginInformation[].class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Instantiate LoginUI
        loginUI = new LoginUI(this);

        //Call to addActionListernerButtons to activate listener for various
        //buttons.
        addActionListenersButtons();

        //set the Login UI to be visible (true)
        loginUI.setVisible(true);
    }

    /**
     * This method will add the ActionListeners for the various buttons that are
     * on the LoginUI.
     */
    public void addActionListenersButtons() {
        loginUI.btnQuit.addActionListener(this);
        loginUI.btnSubmit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //e.source will let you know what button was pushed. 
        Object obj = e.getSource();

        //The QUIT button was pressed
        if (obj.equals(loginUI.btnQuit)) {
            System.exit(0);
        }

        //The ADD button was pressed
        if (obj.equals(loginUI.btnSubmit)) {
            //Enable all of the buttons except for Save button
            loginUI.enableButtons(true);

            boolean blnFound = false;
            for (LoginInformation loginInfo : listLoginInformation) {
                if (loginInfo.getLoginId().equals(loginUI.getLoginIdTextField())
                        && loginInfo.getPassword().equals(loginUI.getPasswordTextField())) {
                    blnFound = true;
                    break;
                }
            }

            if (blnFound) {
                MainMenuCntl mainMenuCntl = new MainMenuCntl();
                loginUI.dispose(); //Close the loginUI
            } else {
                //Set Error Message Label
                loginUI.setErrorMessageLabel("Invalid Login ID and password combination.");

                //Clear the fields in the Login UI
                loginUI.clearTheFieldsInLoginUI();
            }
        }

    }
}
