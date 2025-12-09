package np.np2024.np2024.models.order.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail {

    private long prgressivo;
    private long id;
    private String name;
    private double price;
    private int qt;
    private double totale;
    private List<orderDetailFF> odd = new ArrayList<>();

    public OrderDetail() {
    }

    public OrderDetail(long prgressivo, long id, String name, double price, int qt, double totale,
            List<orderDetailFF> odd) {
        this.prgressivo = prgressivo;
        this.id = id;
        this.name = name;
        this.price = price;
        this.qt = qt;
        this.totale = totale;
        this.odd = odd;
    }

    public long getPrgressivo() {
        return this.prgressivo;
    }

    public void setPrgressivo(long prgressivo) {
        this.prgressivo = prgressivo;
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

}
