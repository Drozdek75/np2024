package np.np2024.np2024.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import np.np2024.np2024.models.Customer;
import np.np2024.np2024.models.IngredientType;
import np.np2024.np2024.models.Ingredient;
import np.np2024.np2024.models.Orders;
import np.np2024.np2024.models.Products;
import np.np2024.np2024.repository.CustomerRepository;
import np.np2024.np2024.repository.IngredientTypeRepository;
import np.np2024.np2024.repository.IngredientsRepository;
import np.np2024.np2024.repository.ProductsRepository;
import np.np2024.np2024.repository.orderRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;

import np.np2024.np2024.models.massive.massiveAlias;

@RestController
@RequestMapping("/env")
public class env {

    @Autowired
    private IngredientsRepository ingredient_repo;

    @Autowired
    private ProductsRepository productsRepo;

    @Autowired
    private CustomerRepository custonerRepo;

    @Autowired
    private orderRepository orderRepo;

    @Autowired
    private IngredientTypeRepository ingredient_type_repo;

    @GetMapping(value = "/saluto")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String saluto() {

        return "Ciao, sei dentro a np2024";
    }

    @GetMapping(value = "/addIngredient")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addIngredient() {

    }

    // restituisce le pizze che contngono il prodotto passato per chiave primaria
    @GetMapping("/getProductByIngredient/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Products>> geProductsByIngredient(@PathVariable Long id) {
        List<Products> lst = new ArrayList();
        List<Products> prod_list = productsRepo.findProductByIngredient(id);
        prod_list.forEach((e) -> {
            System.out.println(e.getName());
            lst.add(e);
        });
        return ResponseEntity.ok().body(lst);
    }

    // restituisce tutti i prodotti nel sistema
    @GetMapping("/getAllProducts")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> lst = new ArrayList<Products>();
        productsRepo.findAll().forEach((e) -> {
            lst.add(e);
        });
        return ResponseEntity.ok().body(lst);
    }

    // restituisce il prodotto in base alla chiave primaria
    @GetMapping("/getProduct/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Products> getProduct(@PathVariable Long id) {
        Optional<Products> op_product = productsRepo.findById(id);

        if (op_product.isPresent()) {
            Products prod = op_product.get();
            System.out.println(prod.getName());

            for (Ingredient ing : prod.getIngredientsList()) {
                System.out.println(ing.name);
            }
            return ResponseEntity.ok().body(prod);
        }
        return ResponseEntity.notFound().build();
    }

    // INGREDIENTS
    @GetMapping("/getAllIngredients")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Ingredient>> getAllIngrediets() {
        List<Ingredient> ret = ingredient_repo.findAll();
        return ResponseEntity.ok().body(ret);
    }

    @GetMapping("/getAllIngredientType")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<IngredientType>> getAllIngredientType() {
        List<IngredientType> types = ingredient_type_repo.findAll();

        return ResponseEntity.ok().body(types);
    }

    // *************************************************************** */
    // ORDINI
    @GetMapping(value = "/addOrder")
    public ResponseEntity<Long> addOrder() {
        Orders order1 = new Orders();
        order1.setCreation_time(new GregorianCalendar().getTimeInMillis());
        order1.setOrder_time(new GregorianCalendar().getTimeInMillis());
        return ResponseEntity.ok().body(-1l);
    }

    @GetMapping(value = "/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> lst = orderRepo.findAll();
        return ResponseEntity.ok().body(lst);
    }

    @GetMapping(value = "/getOrderById/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        HttpStatusCode statusCode;
        Orders orderRet = null;

        Optional<Orders> optional = orderRepo.findById(id);

        if (optional.isPresent()) {
            statusCode = HttpStatus.OK;
            orderRet = optional.get();
        } else {
            statusCode = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(statusCode).body(orderRet);

    }

    // ****************************************************************** */
    // * ADD COUSTOMER *****************************************************/
    @GetMapping("/getAllCustomer")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Customer>> getAllCostumer() {

        List<Customer> lstOp = custonerRepo.findAll();

        return ResponseEntity.ok().body(lstOp);

    }

    @PostMapping("/addMassiveAlias")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addMassiveAlias(@RequestBody() massiveAlias aliasList) {
        aliasList.alias.forEach((el) -> {
            System.out.println(el);
            custonerRepo.save(new Customer(el));
        });

    }

    @GetMapping("/addNewCustomerAlias/{alias}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void addNewCustomerAlias(@PathVariable String alias
    ) {

        Customer customer = new Customer(alias);
        custonerRepo.save(customer);

        // return ResponseEntity.ok().body(true);
    }

    /**
     * *********************************************************************
     */
    /**
     * ORDERS***************************************************************
     */
    /**
     * ********************************************************************
     */
}
