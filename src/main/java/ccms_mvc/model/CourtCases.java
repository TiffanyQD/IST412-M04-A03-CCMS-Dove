/*
 * Filename: Person.java
 * @author  Tiffany Dove
 * @version Jan 29, 2023
 */

package ccms_mvc.model;


public class CourtCases {
    public String caseNumber;
    public String partyName;

    public CourtCases() {
        this.caseNumber = "CaseNumber";
        this.partyName = "partyName";
    }

    public CourtCases(String caseNumber, String partyName) {
        this.caseNumber = caseNumber;
        this.partyName = partyName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

}
