package com.nicollet.rmiclient;

import com.nicollet.rmiclient.models.Student;
import com.nicollet.rmiclient.services.HelloWorldRMI;
import com.nicollet.rmiclient.services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class RmiClientApplication {
    @Bean
    RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
//        bean.setServiceInterface(HelloWorldRMI.class);
//        bean.setServiceUrl("rmi://localhost:1099/helloworldrmi");

        bean.setServiceInterface(StudentService.class);
        bean.setServiceUrl("rmi://localhost:1099/studentrmi");

        return bean;
    }

    public static void main(String[] args)
    {
//        HelloWorldRMI helloWorldRMI = SpringApplication.run(RmiClientApplication.class, args)
//                .getBean(HelloWorldRMI.class);
//        System.out.println("================Client Side ========================");
//
//        System.out.println(helloWorldRMI.sayHelloRmi("Sajal"));

        StudentService studentRMI = SpringApplication.run(RmiClientApplication.class, args)
                .getBean(StudentService.class);

        System.out.println("================Client Side ========================");

        System.out.println(studentRMI.getStudentFullName("Nicollet", "Njora"));
    }
}
