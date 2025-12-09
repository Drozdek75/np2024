package np.np2024.np2024.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class IngredientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredientType")
    private List<Ingredients> listIngredients = new ArrayList<>();

    public IngredientType() {
    }

    public IngredientType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredients> getListIngredients() {
        return this.listIngredients;
    }

    public void setListIngredients(List<Ingredients> listIngredients) {
        this.listIngredients = listIngredients;
    }

}
