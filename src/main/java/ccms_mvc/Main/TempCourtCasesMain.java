/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccms_mvc.Main;

import ccms_mvc.model.CaseStatus;
import ccms_mvc.model.CaseType;
import ccms_mvc.model.CourtCases;
import ccms_mvc.model.CourtSystem;
import ccms_mvc.model.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tiffa
 */
public class TempCourtCasesMain {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        
        ZonedDateTime fillingDate = ZonedDateTime.of(2015, 11, 20, 23, 45, 59, 1234, ZoneId.of ("UTC"));

        CourtCases courtCase1 = new CourtCases();
        courtCase1.setCourtSystem(CourtSystem.CIRCUIT);
        courtCase1.setLocation(Location.BALTIMORE);
        courtCase1.setCaseNumber("11111");
        courtCase1.setPartyName("Benjamin vs. Franklin");
        courtCase1.setCaseType(CaseType.CIVIL);
        courtCase1.setFillingDate(fillingDate.plusYears(1).minusMonths(1));
        courtCase1.setCaseStatus(CaseStatus.OPEN);
        courtCase1.setPlantiff("Benjamin");
        courtCase1.setDefendant("Franklin");
        courtCase1.setJudgeInformation("This is a free-form field that the judge would enter information about the case.");
        courtCase1.setLawyerInformation("This is a free-form field that the lawyer would enter information about the case.");
        
        
        CourtCases courtCase2 = new CourtCases();
        courtCase2.setCourtSystem(CourtSystem.DISTRICT);
        courtCase2.setLocation(Location.BALTIMORE_CITY);
        courtCase2.setCaseNumber("22222");
        courtCase2.setPartyName("Mosby vs. Mosby et al");
        courtCase2.setCaseType(CaseType.CIVIL_ACTION);
        courtCase2.setFillingDate(fillingDate.plusDays(7).minusMonths(6));
        courtCase2.setCaseStatus(CaseStatus.CLOSED);
        courtCase2.setPlantiff("Mosby");
        courtCase2.setDefendant("Mosby et al");
        courtCase2.setJudgeInformation("Let the judge enter some information about the Mosby vs. Mosby case.");
        courtCase2.setLawyerInformation("Let the lawyer enter some information about the Mosby vs. Mosby case.");
        
        
        
        CourtCases courtCase3 = new CourtCases();
        courtCase3.setCourtSystem(CourtSystem.CIRCUIT);
        courtCase3.setLocation(Location.MONTGOMERY);
        courtCase3.setCaseNumber("33333");
        courtCase3.setPartyName("Good vs. Bad");
        courtCase3.setCaseType(CaseType.CRIMINIAL);
        courtCase3.setFillingDate(fillingDate.minusWeeks(5).minusHours(5));
        courtCase3.setCaseStatus(CaseStatus.POSTPONED);
        courtCase3.setPlantiff("Good");
        courtCase3.setDefendant("Bad");
        courtCase3.setJudgeInformation("This is a free-form field that the judge would enter information about the case concerning Good vs. Bad.");
        courtCase3.setLawyerInformation("This is a free-form field that the lawyer would enter information about the case concerning Good vs. Bad.");
        
        
        CourtCases courtCase4 = new CourtCases();
        courtCase4.setCourtSystem(CourtSystem.CIRCUIT);
        courtCase4.setLocation(Location.BALTIMORE);
        courtCase4.setCaseNumber("44444");
        courtCase4.setPartyName("Ravens vs. Browns");
        courtCase4.setCaseType(CaseType.TRAFFIC);
        courtCase4.setFillingDate(fillingDate.plusYears(6));
        courtCase4.setCaseStatus(CaseStatus.OPEN);
        courtCase4.setPlantiff("Ravens");
        courtCase4.setDefendant("Browns");
        courtCase4.setJudgeInformation("The Judge had something to say about the Ravens vs. Browns cases.");
        courtCase4.setLawyerInformation("The Lawyer had something to say about the Ravens vs. Browns cases.");
        
        
        CourtCases courtCase5 = new CourtCases();
        courtCase5.setCourtSystem(CourtSystem.CIRCUIT);
        courtCase5.setLocation(Location.BALTIMORE);
        courtCase5.setCaseNumber("55555");
        courtCase5.setPartyName("Jackson vs. Watson");
        courtCase5.setCaseType(CaseType.CIVIL);
        courtCase5.setFillingDate(fillingDate.minusHours(7).minusMinutes(7).minusSeconds(7));
        courtCase5.setCaseStatus(CaseStatus.OPEN);
        courtCase5.setPlantiff("Jackson");
        courtCase5.setDefendant("Watson");
        courtCase5.setJudgeInformation("The Judge had something to say about the Jackson vs. Watson cases.");
        courtCase5.setLawyerInformation("The Lawyer had something to say about the Jackson vs. Watson cases.");
        
        List<CourtCases> asList = Arrays.asList(courtCase1, courtCase2, courtCase3, courtCase4, courtCase5);

        try {
            mapper.writeValue(new File("src/resources/courtCases.json"), asList);
            String jsonString = mapper.writeValueAsString(asList);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
