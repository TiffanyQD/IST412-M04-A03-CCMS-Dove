package ccms_mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This the class for the Login Information
 * @author Tiffany Dove
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
