package np.np2024.np2024.models.order;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import np.np2024.np2024.models.Customer;
import np.np2024.np2024.models.Products;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long order_time;

    private long creation_time;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

   
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<OrderProduct> order_product = new HashSet<>();

    public Orders() {
    }

    public Orders(long order_time, long creation_time, Customer customer) {

        this.order_time = order_time;
        this.creation_time = creation_time;
        // this.customer = customer;
    }


    public void addProductInOrder(OrderProduct order_product) {
        this.order_product.add(order_product);
    }

    public void removeProductInOrder(OrderProduct order_product) {
        this.order_product.remove(order_product);
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

    public Set<OrderProduct> getOrder_product() {
        return this.order_product;
    }

    public void setOrder_product(Set<OrderProduct> order_product) {
        this.order_product = order_product;
    }

}
