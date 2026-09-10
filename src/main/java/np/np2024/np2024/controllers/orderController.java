package np.np2024.np2024.controllers;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import np.np2024.np2024.models.Customer;
import np.np2024.np2024.models.OrderDetail;
import np.np2024.np2024.models.Orders;
import np.np2024.np2024.models.orderDetailFF;
import np.np2024.np2024.repository.CustomerRepository;
import np.np2024.np2024.repository.IngredientsRepository;
import np.np2024.np2024.repository.OrderDetailFFRepository;
import np.np2024.np2024.repository.ProductsRepository;
import np.np2024.np2024.repository.orderDetailRepsitory;
import np.np2024.np2024.repository.orderRepository;

@RestController
@RequestMapping("/api/orders")
public class orderController {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ProductsRepository productRepo;

    @Autowired
    private IngredientsRepository ingredientRepo;

    @Autowired
    private orderRepository orderRepo;

    @Autowired
    private OrderDetailFFRepository orderFFRepo;

    @Autowired
    private orderDetailRepsitory orderDetailRepo;

    @Autowired
    private EntityManager enityManager;

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable long id) {

        Orders order = orderRepo.findById(id).get();

        order.getOrderDet().forEach((orderDetail) -> {
            orderDetail.getOdd().forEach((detailFF) -> {
                System.out.println("" + detailFF.getIngredient().getName() + " type: " + (detailFF.getType() == 1 ? "+" : "-"));
            });
        });

        return ResponseEntity.ok().body(order);

    }

    @GetMapping("/halo")
    public String halo() {
        return "halo WD";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addOrd")
    public String addOrderPost(@RequestBody Orders order) {
        System.out.println(order.getCustomer().shortName);

        return "str";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    @Transactional
    public void addOrder(@RequestBody Orders order1) {

        List<OrderDetail> orderDetList = new ArrayList<>();

        /*  order.getOrderDet().forEach((orderDetail) -> {
            orderDetail.getOdd().forEach((detailFF) -> {
                orderFFRepo.save(detailFF);
            });
        });  */
 /*  Orders ord = new Orders();
        ord.setCreation_time(new GregorianCalendar().getTimeInMillis());
        ord.setOrder_time(order1.getOrder_time());
        ord.setCustomer(order1.getCustomer());*/

 /*  List<OrderDetail> orderDet_list = order.getOrderDet();

        orderDet_list.forEach((orderDetail) -> {
            orderDetailRepo.save(orderDetail);

        });*/
        //Customer costumer = customerRepo.findByShortName("BORTOLATO").get();

        /*  Orders order = new Orders();
        order.setCreation_time(new GregorianCalendar().getTimeInMillis());
        order.setOrder_time(order1.getOrder_time());
        order.setCustomer(order1.getCustomer());*/
        //enityManager.getTransaction().begin();
        // orderRepo.save(order1);
        //enityManager.getTransaction().commit();
        /* OrderDetail det = new OrderDetail();
        det.setName(costumer.getShort_name());
        det.setPrgressivo(4547542422l);
        det.setPrice(256.32);
        det.setQt(7);
        det.setTotale(54545.2);
        det.setCodProduct(productRepo.findById(5l).get());

        List<orderDetailFF> lst = new ArrayList<>();

        orderDetailFF ff1 = new orderDetailFF(1, ingredientRepo.findById(7l).get());
        orderFFRepo.save(ff1);
        lst.add(ff1);
        orderDetailFF ff2 = new orderDetailFF(-1, ingredientRepo.findById(2l).get());
        orderFFRepo.save(ff2);
        lst.add(ff2);
        orderDetailFF ff3 = new orderDetailFF(1, ingredientRepo.findById(22l).get());
        orderFFRepo.save(ff3);
        lst.add(ff3);

        det.setOdd(lst);

        orderDetailRepo.save(det);

        OrderDetail det2 = new OrderDetail();
        det2.setName(costumer.getShort_name());
        det2.setPrgressivo(4547542422l);
        det2.setPrice(256.32);
        det2.setQt(7);
        det2.setTotale(54545.2);
        det2.setCodProduct(productRepo.findById(8l).get());

        orderDetailRepo.save(det2);

        orderDetList.add(det);
        orderDetList.add(det2);
        order.setOrderDet(orderDetList);
         */
        // System.out.println(order.getCustomer().getShort_name());
        orderRepo.save(order1);
    }

}
