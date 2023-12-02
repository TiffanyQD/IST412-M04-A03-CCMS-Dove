/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccms_mvc.Main;

import ccms_mvc.model.LoginInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tiffa
 */
public class RenameLoginInformation {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        LoginInformation loginInformation1 = new LoginInformation();
        loginInformation1.setFirstName("Admin");
        loginInformation1.setLastName("The Administrator");
        loginInformation1.setLoginId("admin");
        loginInformation1.setPassword("password");

        LoginInformation loginInformation2 = new LoginInformation();
        loginInformation2.setFirstName("Civil");
        loginInformation2.setLastName("The Civilian");
        loginInformation2.setLoginId("civil1");
        loginInformation2.setPassword("civilian1");

        LoginInformation loginInformation3 = new LoginInformation();
        loginInformation3.setFirstName("Judge");
        loginInformation3.setLastName("De' Jury");
        loginInformation3.setLoginId("judge1");
        loginInformation3.setPassword("judge1");

        LoginInformation loginInformation4 = new LoginInformation();
        loginInformation4.setFirstName("Lawyer");
        loginInformation4.setLastName("The Scumbag");
        loginInformation4.setLoginId("lawyer1");
        loginInformation4.setPassword("lawyer1");

        List<LoginInformation> asList = Arrays.asList(loginInformation1, loginInformation2, loginInformation3, loginInformation4);

        try {
            mapper.writeValue(new File("src/resources/loginInformation.json"), asList);
            String jsonString = mapper.writeValueAsString(asList);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
