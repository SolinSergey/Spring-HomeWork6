package HomeWorkSpring;


import HomeWorkSpring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Magazine {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        //System.out.println("Создана поликлиника");
       // HomeWorkSpring.Registry registry=context.getBean(Registry.class);
        //HomeWorkSpring.Patient patient= context.getBean("patient",Patient.class);
        //System.out.println();
        //System.out.println("В поликлинику пришел пациент");
        //System.out.println();
        //registry.setRequestFromPatient(patient);
    }
}
