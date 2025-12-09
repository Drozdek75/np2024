package np.np2024.np2024.models.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NutritionalValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cal;
    private double kj;
    private double fats;
    private double saturatedFat;
    private double carbohydrates;
    private double sugars;
    private double fibers;
    private double proteins;
    private double salt;

    public NutritionalValues() {
    }

    public NutritionalValues(double cal, double kj, double fats, double saturatedFat, double carbohydrates,
            double sugars, double fibers, double proteins, double salt) {
        this.cal = cal;
        this.kj = kj;
        this.fats = fats;
        this.saturatedFat = saturatedFat;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fibers = fibers;
        this.proteins = proteins;
        this.salt = salt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCal() {
        return this.cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    public double getKj() {
        return this.kj;
    }

    public void setKj(double kj) {
        this.kj = kj;
    }

    public double getFats() {
        return this.fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getSaturatedFat() {
        return this.saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getCarbohydrates() {
        return this.carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugars() {
        return this.sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getFibers() {
        return this.fibers;
    }

    public void setFibers(double fibers) {
        this.fibers = fibers;
    }

    public double getProteins() {
        return this.proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getSalt() {
        return this.salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

}
