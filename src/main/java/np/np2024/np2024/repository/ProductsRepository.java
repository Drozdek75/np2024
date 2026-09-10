package np.np2024.np2024.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import np.np2024.np2024.models.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM products, products_ingredients WHERE products_ingredients.cod_ingredient = :cod_ingredient AND products.id = products_ingredients.cod_product")
    List<Products> findProductByIngredient(@Param("cod_ingredient") long cod_ingredient);

}
