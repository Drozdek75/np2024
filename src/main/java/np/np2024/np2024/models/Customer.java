package np.np2024.np2024.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String firstName;

    public String lastName;

    public String shortName;

    public String telephoneNumber;

    public String address;

    public String cf;

    public String piva;

    public String note;

    @OneToOne()
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    public Customer() {
    }

    public Customer(String shortName) {
        this.shortName = shortName;
    }

    public Customer(String first_name, String last_name, String short_name, String telephone_number, String address,
            String cf, String piva, String note) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.shortName = short_name;
        this.telephoneNumber = telephone_number;
        this.address = address;
        this.cf = cf;
        this.piva = piva;
        this.note = note;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirst_name() {
        return this.firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return this.lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getShort_name() {
        return this.shortName;
    }

    public void setShort_name(String short_name) {
        this.shortName = short_name;
    }

    public String getTelephone_number() {
        return this.telephoneNumber;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephoneNumber = telephone_number;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCf() {
        return this.cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getPiva() {
        return this.piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
