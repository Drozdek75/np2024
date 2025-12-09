package np.np2024.np2024.models;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import np.np2024.np2024.models.order.OrderProduct;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String type;

    private double price;

    private double cost;

    private String notes;

    private long version;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "products_ingredients", joinColumns = {
            @JoinColumn(name = "cod_product") }, inverseJoinColumns = { @JoinColumn(name = "cod_ingredient") })
    private Set<Ingredients> ingredientsList = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderProduct> product_order = new HashSet<>();

    public Products() {
    }

    public Products(String name, String description, double price, double cost, String notes, long version, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.notes = notes;
        this.version = version;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<Ingredients> getIngredientsList() {
        return this.ingredientsList;
    }

    public void setIngredientsList(Set<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Set<OrderProduct> getProduct_order() {
        return this.product_order;
    }

    public void setProduct_order(Set<OrderProduct> product_order) {
        this.product_order = product_order;
    }
  
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }



}