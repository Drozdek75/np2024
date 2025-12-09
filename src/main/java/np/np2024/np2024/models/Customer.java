package np.np2024.np2024.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import np.np2024.np2024.models.order.Orders;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String first_name;

    public String last_name;

    public String short_name;

    public String telephone_number;

    public String address;

    public String cf;

    public String piva;

    public String note;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    public Customer() {
    }

    public Customer(String shortName) {
        this.short_name = shortName;
    }

    public Customer(String first_name, String last_name, String short_name, String telephone_number, String address,
            String cf, String piva, String note) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.short_name = short_name;
        this.telephone_number = telephone_number;
        this.address = address;
        this.cf = cf;
        this.piva = piva;
        this.note = note;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getTelephone_number() {
        return this.telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
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
