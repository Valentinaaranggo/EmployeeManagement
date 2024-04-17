package Employee_Functions;
import Address;

public class Employee {
    String _name;
    String _sex;
    String _pronouns;
    String _phoneNumber;
    String _race;
    String _dateOfBirth;
    Address _address;

    public Employee(){
        
    }


    public String get_name() {
        return _name;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public String get_sex() {
        return _sex;
    }

    public void set_sex(String sex) {
        this._sex = sex;
    }

    public String get_pronouns() {
        return _pronouns;
    }

    public void set_pronouns(String pronouns) {
        this._pronouns = pronouns;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String phoneNumber) {
        this._phoneNumber = phoneNumber;
    }

    public String get_race() {
        return _race;
    }

    public void set_race(String race) {
        this._race = race;
    }

    public String get_dateOfBirth() {
        return _dateOfBirth;
    }

    public void set_dateOfBirth(String dateOfBirth) {
        this._dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return _address;
    }

    public void setAddress(Address address) {
        this._address = address;
    }
}