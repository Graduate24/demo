package edu.tsinghua.demo;

import edu.tsinghua.demo.aop.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {
     @Autowired
     ShipmentService shipmentService;

     @Test
     void testBeforeLog() {
         shipmentService.shipStuff();
     }
}
