/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccms_mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author tiffa
 */
@Getter
@Setter
@ToString
public class LoginInformation {
    
    private String loginId;
    private String password;
    private String firstName; 
    private String lastName;
    
}
