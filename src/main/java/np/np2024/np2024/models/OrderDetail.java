package np.np2024.np2024.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long progressivo;
    private String name;
    private double price;
    private int qt;
    private double totale;

    @ManyToOne()
    @JoinColumn(name = "cod_product")
    private Products codProduct;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id")
    private List<orderDetailFF> odd = new ArrayList<>();

    @ManyToOne
    private Orders orderCod;

    public OrderDetail() {
    }

    public OrderDetail(long prgressivo, long id, String name, double price, int qt, double totale,
            List<orderDetailFF> odd, Products prod) {
        this.progressivo = prgressivo;
        this.id = id;
        this.name = name;
        this.price = price;
        this.qt = qt;
        this.totale = totale;
        this.odd = odd;
        this.codProduct = prod;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQt() {
        return this.qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public double getTotale() {
        return this.totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public List<orderDetailFF> getOdd() {
        return this.odd;
    }

    public void setOdd(List<orderDetailFF> odd) {
        this.odd = odd;
    }

    public Orders getOrderCod() {
        return orderCod;
    }

    public void setOrderCod(Orders orderCod) {
        this.orderCod = orderCod;
    }

    public Products getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(Products codProduct) {
        this.codProduct = codProduct;
    }

    public long getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(long progressivo) {
        this.progressivo = progressivo;
    }

}
