/*
 * Filename: Person.java
 * @author  Tiffany Dove
 * @version Jan 29, 2023
 */
package ccms_mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourtCases {

    public CourtSystem courtSystem;
    public CourtLocation location;
    public String caseNumber;
    public String partyName;
    public CaseType caseType;
    public String filingDate;
    public CaseStatus caseStatus;
    public String plantiff;
    public String defendant;
    public String judgeInformation;
    public String lawyerInformation;

}
