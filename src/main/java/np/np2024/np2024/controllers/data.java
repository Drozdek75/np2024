package np.np2024.np2024.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import np.np2024.np2024.models.DTO.massiveID;
import np.np2024.np2024.models.Ingredient;
import np.np2024.np2024.models.IngredientType;
import np.np2024.np2024.repository.IngredientTypeRepository;
import np.np2024.np2024.repository.IngredientsRepository;

@RestController
@RequestMapping("/data")
public class data {

    @Autowired
    IngredientTypeRepository typeRepo;
    @Autowired
    IngredientsRepository ingredientRepo;

    public data(IngredientTypeRepository repo) {
        this.typeRepo = repo;
    }

    @GetMapping("/allType")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<IngredientType>> getAllIngredientType() {
        List<IngredientType> lst = typeRepo.findAll();
        return ResponseEntity.ok().body(lst);

    }

    @PostMapping("/addType")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> addType(@RequestBody IngredientType type) {
        if (type != null) {
            typeRepo.save(type);
        }
        return ResponseEntity.ok(null);

    }

    @DeleteMapping("/removeType")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Integer> removeType(@RequestBody massiveID ids) {

        List<IngredientType> deleteList = new ArrayList<>();
        ids.getIds().forEach((id) -> {
            Optional<IngredientType> ing = typeRepo.findById(id);
            if (ing.isPresent()) {
                deleteList.add(ing.get());
            }
        });
        typeRepo.deleteAll(deleteList);
        return ResponseEntity.ok().body(Integer.valueOf(deleteList.size()));
    }

    @DeleteMapping("/removeIngredientById/{id}")
    public ResponseEntity<Long> removeIngredientById(@PathVariable long id) {        
        ingredientRepo.findById(id).ifPresentOrElse((ingredient) -> {
           ingredientRepo.delete(ingredient);
        }, () -> {
            ResponseEntity.badRequest().body(-1);
        });

        return ResponseEntity.ok().body(id);

    }


    @GetMapping("/getAllIngredient")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Ingredient>> getAllIngredient() {
        List<Ingredient> ingredientList = ingredientRepo.findAll();       
        return ResponseEntity.ok().body(ingredientList);
    }

    @PostMapping("/addNewIngredient")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Ingredient> addNewIngredient(@RequestBody Ingredient ingredient) {
        Ingredient ret = ingredientRepo.save(ingredient);
        return ResponseEntity.ok().body(ret);
    }

   

    @GetMapping("/halo")
    public String halo() {
        return "halo";
    }

}
