package np.np2024.np2024.models.order.pojo;

import np.np2024.np2024.models.order.Orders;

public class OrderStream {

    OrderDetail orderDet;
    Orders order;

    public OrderStream() {
    }

    public OrderStream(OrderDetail orderDet, Orders order) {
        this.orderDet = orderDet;
        this.order = order;
    }

    public OrderDetail getOrderDet() {
        return this.orderDet;
    }

    public void setOrderDet(OrderDetail orderDet) {
        this.orderDet = orderDet;
    }

    public Orders getOrder() {
        return this.order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

}
