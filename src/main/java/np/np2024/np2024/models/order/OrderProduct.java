package np.np2024.np2024.models.order;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import np.np2024.np2024.models.Products;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Products product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")  
    private Orders orders;

    //@JsonIgnore
    @OneToMany(mappedBy = "order_product_id", cascade = CascadeType.ALL)    
    private Set<orderDetail> orderDetailList = new HashSet<>();

    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(Products product, Orders orders, int quantity) {
        this.product = product;
        this.orders = orders;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public Products getProduct() {
        return this.product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<orderDetail> getOrderDetailList() {
        return this.orderDetailList;
    }

    public void setOrderDetailList(Set<orderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

}
