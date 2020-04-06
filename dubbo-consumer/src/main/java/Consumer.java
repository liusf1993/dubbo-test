import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        // Obtaining a remote service proxy
        IDemoService demoService = (IDemoService) context.getBean("demoService");
        // Executing remote methods
        int[] hello = demoService.sayHello();
        // Display the call result
        System.err.println(hello.length);
    }
}