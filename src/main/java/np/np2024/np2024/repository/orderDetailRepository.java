package np.np2024.np2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.np2024.np2024.models.order.orderDetail;

@Repository
public interface orderDetailRepository extends JpaRepository<orderDetail, Long>{

}
