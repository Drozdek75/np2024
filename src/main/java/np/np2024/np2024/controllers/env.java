package np.np2024.np2024.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import np.np2024.np2024.models.Customer;
import np.np2024.np2024.models.IngredientType;
import np.np2024.np2024.models.Ingredients;
import np.np2024.np2024.models.Products;
import np.np2024.np2024.models.order.OrderProduct;
import np.np2024.np2024.models.order.Orders;
import np.np2024.np2024.models.order.orderDetail;
import np.np2024.np2024.models.order.pojo.OrderStream;
import np.np2024.np2024.repository.CustomerRepository;
import np.np2024.np2024.repository.IngredientTypeRepository;
import np.np2024.np2024.repository.IngredientsRepository;
import np.np2024.np2024.repository.ProductsRepository;
import np.np2024.np2024.repository.orderDetailRepository;
import np.np2024.np2024.repository.orderProductRepository;
import np.np2024.np2024.repository.orderRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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
    private orderProductRepository orderProductRepo;

    @Autowired
    private orderDetailRepository orderDetailRepo;

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

            for (Ingredients ing : prod.getIngredientsList()) {
                System.out.println(ing.name);
            }
            return ResponseEntity.ok().body(prod);
        }
        return ResponseEntity.notFound().build();
    }

    // INGREDIENTS

    @GetMapping("/getAllIngredients")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Ingredients>> getAllIngrediets() {
        List<Ingredients> ret = ingredient_repo.findAll();
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

    @PostMapping(value = "/saveOrder", produces = "application/json")
    public ResponseEntity<OrderStream> saveOrder(@RequestBody OrderStream os) {

        return ResponseEntity.ok().body(null);

    }

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

    @GetMapping("/addNewCustomerAlias/{alias}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<boolean> addNewCustomerAlias(@PathVariable("alias") String alias) {
        
       return ResponseEntity.ok().body(true);
    }


    @GetMapping("/addNewAlias/{alias}")
    public void addNewCoustomerAlias(@PathVariable String alias) {
        Customer cust = custonerRepo.findById(2L).get();
        // System.out.println(cust.short_name);

        /*
         * Products p1 = productsRepo.findById(14l).get();
         * Ingredients ing1 = ingredient_repo.findById(8l).get();
         * Ingredients ing2 = ingredient_repo.findById(9l).get();
         * Ingredients ing3 = ingredient_repo.findById(10l).get();
         * 
         * Orders ord1 = new Orders();
         * ord1.setCreation_time(new GregorianCalendar().getTimeInMillis());
         * ord1.setOrder_time(new GregorianCalendar().getTimeInMillis());
         * ord1.setCustomer(cust);
         * 
         * orderRepo.save(ord1);
         * 
         * // Orders orderSe= orderRepo.findById(3l).get();
         * 
         * OrderProduct op =new OrderProduct();
         * op.setOrders(ord1);
         * op.setProduct(p1);
         * op.setQuantity(4);
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * orderDetail od1 = new orderDetail();
         * od1.setIngredient(ing1);
         * od1.setType(1);
         * od1.setOrder_product_id(op);
         * 
         * orderDetailRepo.save(od1);
         * orderDetail od2 = new orderDetail();
         * od2.setIngredient(ing2);
         * od2.setType(-1);
         * od2.setOrder_product_id(op);
         * orderDetailRepo.save(od2);
         * 
         * orderDetail od3 = new orderDetail();
         * od3.setIngredient(ing3);
         * od3.setType(1);
         * od3.setOrder_product_id(op);
         * orderDetailRepo.save(od3);
         * 
         * Set<orderDetail> setOrder = new HashSet<>();
         * setOrder.add(od1);
         * setOrder.add(od2);
         * setOrder.add(od3);
         * op.setOrderDetailList(setOrder);
         * 
         * orderProductRepo.save(op);
         */

        List<Orders> lstOrder = orderRepo.findAll();

        lstOrder.forEach((order) -> {
            System.out.println(order.getCustomer().short_name);
            System.out.println("---------------------------------");
            order.getOrder_product().forEach((e) -> {

                System.out.println(e.getQuantity() + ") " + e.getProduct().getName());

                // System.out.println(e.getOrderDetailList().size());

                e.getOrderDetailList().forEach((ing) -> {
                    System.out.println("    " + ing.getType() + " " + ing.getIngredient().getName());
                });

            }

            );
            System.out.println("---------------------------------");

        });

        /*
         * Orders ord2 = orderRepo.findById(3l).get();
         * 
         * ord2.getOrder_product().forEach((e)-> {
         * System.out.println(e.getQuantity()+") "+ e.getProduct().getName());
         * 
         * // System.out.println(e.getOrderDetailList().size());
         * 
         * e.getOrderDetailList().forEach((ing)-> {
         * System.out.println("    "+ing.getType()+" "+ing.getIngredient().getName());
         * });
         * 
         * }
         * 
         * );
         */

    }

    /*********************************************************************** */

    /** ORDERS*************************************************************** */

    /**********************************************************************  */

}
