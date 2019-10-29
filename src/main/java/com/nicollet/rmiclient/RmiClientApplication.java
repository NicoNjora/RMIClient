package com.nicollet.rmiclient;

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
        bean.setServiceInterface(StudentService.class);
        bean.setServiceUrl("rmi://localhost:1099/studentrmi");

        return bean;
    }

    public static void main(String[] args)
    {
        StudentService studentRMI = SpringApplication.run(RmiClientApplication.class, args)
                .getBean(StudentService.class);

        System.out.println("================Client Side ========================");

        System.out.println(studentRMI.getStudentFullName("Nicollet", "Njora"));
    }
}
