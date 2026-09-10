package np.np2024.np2024.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class orderDetailFF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_ingredient")
    private Ingredient ingredient;

    @ManyToOne()
    
    private OrderDetail codOrderDetail;

    public orderDetailFF() {
    }

    public orderDetailFF(int type, Ingredient ingredient, OrderDetail orderDetail) {
        this.type = type;
        this.ingredient = ingredient;
        this.codOrderDetail = orderDetail;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public OrderDetail getCodOrderDetail() {
        return codOrderDetail;
    }

    public void setCodOrderDetail(OrderDetail codOrderDetail) {
        this.codOrderDetail = codOrderDetail;
    }
}
