package com.gr.jiang;

import com.gr.jiang.po.Person;
import com.gr.jiang.remoting.CommonSender;
import com.gr.jiang.util.JsonUtils;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jiang on 2017/1/4.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    public static void main(String [] args){
//        org.springframework.beans.BeanUtils
        SpringApplication.run(Application.class);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Autowired
    private CommonSender commonSender;
    @Value("${spring.rabbitmq.queueName}")
    private String queueName;
    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("jiang");
        person.setAge(27);
        person.setUrl("www.baidu.com");
        long start = System.currentTimeMillis() ;
        for(int i = 0 ; i < 10000 ; i ++) {
            commonSender.notify(queueName, "testPo", "handleObj", person);
            commonSender.notify(queueName, "testPo", "handle", JsonUtils.obj2Json(person));
        }
        long end = System.currentTimeMillis() ;
        System.out.println(end-start);
    }
}
