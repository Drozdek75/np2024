package np.np2024.np2024.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long order_time;

    private long creation_time;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderDetail> orderDet = new ArrayList<>();

    public Orders() {
    }

    public Orders(long order_time, long creation_time, Customer customer, List<OrderDetail> det) {

        this.order_time = order_time;
        this.creation_time = creation_time;
        this.orderDet = det;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public long getOrder_time() {
        return this.order_time;
    }

    public void setOrder_time(long order_time) {
        this.order_time = order_time;
    }

    public long getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(long creation_time) {
        this.creation_time = creation_time;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDet() {
        return orderDet;
    }

    public void setOrderDet(List<OrderDetail> orderDet) {
        this.orderDet = orderDet;
    }

}
