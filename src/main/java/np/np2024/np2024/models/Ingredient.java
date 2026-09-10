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
import jakarta.persistence.ManyToOne;
import np.np2024.np2024.models.app.NutritionalValues;
import np.np2024.np2024.models.app.allergens;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    public double price;

    public double cost;

    public String notes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
        CascadeType.MERGE}, mappedBy = "ingredientsList")
    @JsonIgnore
    private Set<Products> productsList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "ingredients_allergens", joinColumns = {
        @JoinColumn(name = "cod_ingredient")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_allergen")})
    private Set<allergens> allergenList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "ingredients_nutritional_value", joinColumns = {
        @JoinColumn(name = "cod_ingredient")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_nutritional_values")})
    private Set<NutritionalValues> nutritionalValuesList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ingredientTypeID")
    private IngredientType ingredientType;

    //@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    //private Set<orderDetail> orderDetailF = new HashSet<>();
    public Ingredient() {
    }

    public Ingredient(String name, String description, double price, double cost, String notes,
            Set<allergens> listAllergens, Set<NutritionalValues> listNutritional) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.notes = notes;
        this.allergenList = listAllergens;
        this.nutritionalValuesList = listNutritional;
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

    public Set<Products> getProductsList() {
        return this.productsList;
    }

    public void setProductsList(Set<Products> productsList) {
        this.productsList = productsList;
    }

    public Set<allergens> getAllergenList() {
        return this.allergenList;
    }

    public void setAllergenList(Set<allergens> allergenList) {
        this.allergenList = allergenList;
    }

    public Set<NutritionalValues> getNutritionalValuesList() {
        return this.nutritionalValuesList;
    }

    public void setNutritionalValuesList(Set<NutritionalValues> nutritionalValuesList) {
        this.nutritionalValuesList = nutritionalValuesList;
    }

    /*public Set<orderDetail> getOrderDetailF() {
        return this.orderDetailF;
    }

    public void setOrderDetailF(Set<orderDetail> orderDetailF) {
        this.orderDetailF = orderDetailF;
    }*/
    public IngredientType getIngredientType() {
        return this.ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

}
