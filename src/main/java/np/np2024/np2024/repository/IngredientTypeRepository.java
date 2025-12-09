package np.np2024.np2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.np2024.np2024.models.IngredientType;

@Repository
public interface IngredientTypeRepository extends JpaRepository<IngredientType, Integer>{

}
