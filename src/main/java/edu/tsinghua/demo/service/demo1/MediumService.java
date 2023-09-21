package edu.tsinghua.demo.service.demo1;
import org.springframework.stereotype.Service;

@Service("medium")
public class MediumService implements Demo1Service {
    @Override
    public String serviceOne() {
        return "Medium : service one";
    }

    @Override
    public String serviceTwo() {
        return "Medium : service two";
    }
}
