package edu.tsinghua.demo;

import edu.tsinghua.demo.config.ConfigProperties;
import edu.tsinghua.demo.config.FieldValueTestBean;
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

    @Autowired
    private ConfigProperties mail;

    @Autowired
    private FieldValueTestBean fieldValueTestBean;

    @Test
    public void test1() {
        assertThat(myBean).isNotNull();
        assertThat(myBeanConsumer).isNotNull();
        assertThat(myBean).isEqualTo(myBeanConsumer.getMyBean());
    }

    @Test
    public void test2() {
        assertThat(mail).isNotNull();
        assertThat(mail.getHostName()).isEqualTo("host@mail.com");
        assertThat(mail.getPort()).isEqualTo(9000);

        assertThat(mail.getDefaultRecipients().get(0)).isEqualTo("admin@mail.com");
        assertThat(mail.getDefaultRecipients().get(1)).isEqualTo("owner@mail.com");

        assertThat(mail.getAdditionalHeaders().get("redelivery")).isEqualTo("true");
        assertThat(mail.getAdditionalHeaders().get("secure")).isEqualTo("true");

        assertThat(mail.getCredentials().getPassword()).isEqualTo("password");
        assertThat(mail.getCredentials().getUsername()).isEqualTo("john");

    }

    @Test
    public void test3() throws InstantiationException, IllegalAccessException {
        assertThat(fieldValueTestBean).isNotNull();
        assertThat(fieldValueTestBean.getFiledValue()).isEqualTo("Test");

        assertThat(fieldValueTestBean.getMyBean()).isEqualTo(myBean);
        assertThat(fieldValueTestBean.getCredentials()).isEqualTo(mail.getCredentials());

        System.out.println(fieldValueTestBean.getRandomInt());

        assertThat(fieldValueTestBean.getFile().getPath()).isEqualTo("home");
    }
}
