package edu.tsinghua.demo;

import edu.tsinghua.demo.entity.MyBean;
import edu.tsinghua.demo.entity.MyBeanConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BeanTest {
    @Autowired
    private MyBean myBean;
    @Autowired
    private MyBeanConsumer myBeanConsumer;

    @Test
    public void test1() {
        assertThat(myBean).isNotNull();
        assertThat(myBeanConsumer).isNotNull();
        assertThat(myBean).isEqualTo(myBeanConsumer.getMyBean());
    }
}
