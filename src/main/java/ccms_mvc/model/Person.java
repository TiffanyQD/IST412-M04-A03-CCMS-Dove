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
public class Person {

    public int idNum;
    public String name;
    public String address;
    public String city;
    public String state;
    public int zipCode;

    public Person() {
        this.idNum = 0;
        this.name = "name";
        this.address = "address";
        this.city = "city";
        this.state = "state";
        this.zipCode = 99999;
    }

    public Person(int idNum, String name, String address, String city, String state, int zipCode) {
        this.idNum = idNum;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}
