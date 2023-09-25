package edu.tsinghua.demo.aop;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String orderStuff() {
        System.out.println("Ordering stuff");
		return "Order";
    }
    public void cancelStuff() {
        System.out.println("Canceling stuff");
    }
}
