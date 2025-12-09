package np.np2024.np2024.models.order;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import np.np2024.np2024.models.Ingredients;

@Entity
public class orderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_product_id")
    private OrderProduct order_product_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredient;

    private int type;

    public orderDetail() {
    }   

    public orderDetail(OrderProduct order_product_id, int type) {
        this.order_product_id = order_product_id;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public OrderProduct getOrder_product_id() {
        return this.order_product_id;
    }

    public void setOrder_product_id(OrderProduct order_product_id) {
        this.order_product_id = order_product_id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Ingredients getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

}
