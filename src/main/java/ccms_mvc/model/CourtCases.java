/*
 * Filename: Person.java
 * @author  Tiffany Dove
 * @version Jan 29, 2023
 */

package ccms_mvc.model;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourtCases {
    public CourtSystem courtSystem;
    public Location location;
    public String caseNumber;
    public String partyName;
    public CaseType caseType;
    public String fillingDate;
    public CaseStatus caseStatus; 
    public String plantiff;
    public String defendant;
    public String judgeInformation; 
    public String lawyerInformation;

}
