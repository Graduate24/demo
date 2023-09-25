package edu.tsinghua.demo;

import edu.tsinghua.demo.aop.BillService;
import edu.tsinghua.demo.aop.OrderService;
import edu.tsinghua.demo.aop.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {
    @Autowired
    ShipmentService shipmentService;
    @Autowired
    BillService billService;

    @Test
    void testBeforeLog() {
        shipmentService.shipStuff();
    }

    @Test
    void testBeforeLogWithBill() {
        shipmentService.shipStuffWithBill();
    }

    @Test
    void testBillService() {
        billService.bill();
    }

    @Autowired
    OrderService orderService;

    @Test
    void testOrderWithLogicalOperator() {
        orderService.orderStuff();
    }

    @Test
    void testCancelWithLogicalOperator() {
        orderService.cancelStuff();
    }
    @Test
    void test() {
        billService.sendBill("beijing", 100.00);
    }

}
