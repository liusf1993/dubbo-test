import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        new ClassPathXmlApplicationContext("classpath:provider.xml").start();
        System.out.println("Provider started.");
        System.in.read(); // press any key to exit
    }
}