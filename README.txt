# IST-412-CCMS
IST-412 Court Case Management System

<b><u>Requisite:</u></B>
<ol>
<li>You must have maven install (because the project uses this structure)</li>
<li>You must change directory into the IST412-M04-A03-CCMS-Dove.</li>
<li>The following command must be run: mvn clean install</li>
<li>You must the "src" directory as Sources Root and the "test" directory marked as "Test Sources Root"</li>
<li>The source code was compiled in Java 19.</li>
</ol>

<b><u>Valid Input:</u></b>
<p>
For the authentication use case, you will need to enter "<b>admin</b>" for username field and "<b>password</b>" for password filed.
If this information is not entered, then you will receive an error of "Authentication Failed."
</p>
<p>
In this week's M04-A03 exercise, the Civilian Use Case was developed.  
1.) To test the modules, enter '11111' for valid input for Case Number for "Search Specific Case".
Because "1111" is a valid case number, it will display a message that "11111" was found. 
</P>
<p>
If 'aaaaa; is entered, an error message will be displayed that "aaaaa was not found".
2.) For View Case Details, if you once again enter '1111', the Party Name field will be populated with the 
Party Name that is associated with that case Number. If you enter 'aaaaa', the party name field will not 
be populated because there the input is invalid. 
</p>

<p>
<b><u>To Execute the Program:</u></b>
<ol>
<li>Navigate to the following path: src/main/java/ccms_mvc/Main/Main.java and run main.</li>
<li>The main navigational page is the first page to render.</li>
<li>If you click on Judge Main Menu, the Judge Main Menu page will show.</li>
<li>From there, if you click on Search Specific Cases, this will eventually allow the judge to "Search Specific Case"
or View Case Details. Again, enter '11111' for the Case Number field for valid input.</li>
<li>Repeat the same exercise for Clerk, Civilian, or Lawyer.</li>
<li>Each one of the buttons (Clerk Main Menu, Civilian Main Menu (worked on this week), Judge Main Menu (previous
exercise, and Lawyer are functional.
</ol>




