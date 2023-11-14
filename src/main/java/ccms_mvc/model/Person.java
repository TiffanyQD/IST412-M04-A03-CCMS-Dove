/*
 * Filename: Person.java
 * @author  Tiffany Dove
 * @version Jan 29, 2023
 */

package ccms_mvc.model;


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

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNum=" + idNum +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
