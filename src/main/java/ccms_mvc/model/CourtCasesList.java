package ccms_mvc.model;

import java.util.ArrayList;

public class CourtCasesList {

    ArrayList<CourtCases> courtCasesArrayList;
    CourtCases courtCases;

    public CourtCasesList() {
        this.courtCasesArrayList = new ArrayList<>();
        if (courtCasesArrayList.isEmpty()){
            createCourtCasesArrayList();
        }
    }

    public ArrayList<CourtCases> getCourtCasesArrayList() {
        return courtCasesArrayList;
    }

    public void setCasesArrayList(ArrayList<CourtCases> courtCasesArrayLists) {
        this.courtCasesArrayList = courtCasesArrayLists;
    }

    public CourtCases getCourtCases() {
        return courtCases;
    }

    public void setCases(CourtCases cases) {
        this.courtCases = cases;
    }

    private void createCourtCasesArrayList() {
//        courtCases = new CourtCases("11111", "Benjamin vs. Franklin");
//        courtCasesArrayList.add(courtCases);
//        courtCases = new CourtCases("22222", "Mosby vs. Mosby");
//        courtCasesArrayList.add(courtCases);
//        courtCases = new CourtCases("33333", "Good vs. Bad");
//        courtCasesArrayList.add(courtCases);
//        courtCases = new CourtCases("44444", "Ravens vs. Browns");
//        courtCasesArrayList.add(courtCases);
//        courtCases = new CourtCases("55555", "Jackson vs. Watson");
//        courtCasesArrayList.add(courtCases);
//        courtCases = new CourtCases("66666", "Steelers vs. Bengals");
//        courtCasesArrayList.add(courtCases);
    }

}
