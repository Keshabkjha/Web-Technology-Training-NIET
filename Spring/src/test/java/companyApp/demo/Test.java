package companyApp.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // create object for POJO Company class OR instantiating
//        Company coj = new Company();
//        coj.setCompany_name("MaithiliMahaan");
//        coj.setCompany_city("Greater Noida");
//        coj.setMD_name("Keshab Kumar");
//        // call or execute the show mehhtod
//        coj.show();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Company ok = (Company) context.getBean("msub");
//        ok.show();
        Product some = (Product) context.getBean("prod");
        some.show();
    }
}



