package ccms_mvc.model;

import java.util.ArrayList;

public class PersonList {

    ArrayList<Person> personArrayList;
    Person person;

    public PersonList() {
        this.personArrayList = new ArrayList<>();
        if (personArrayList.isEmpty()){
            createPersonArrayList();
        }
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private void createPersonArrayList() {
        person = new Person(0, "Mickey Mouse", "1675 North Buena Vista Drive", "Lake Buena Vista", "FL", 32830);
        personArrayList.add(person);
        person = new Person(1, "Donald Duck", "156 Rusty Ln", "Waxahachie", "TX", 75165);
        personArrayList.add(person);
        person = new Person(2, "Bugs Bunny", "405 Reo St", "Tampa", "FL", 33609);
        personArrayList.add(person);
    }

}
