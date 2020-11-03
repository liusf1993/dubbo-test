import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import org.apache.dubbo.common.threadlocal.InternalThreadLocal;
import org.apache.dubbo.common.threadlocal.InternalThreadLocalMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        // Obtaining a remote service proxy
        IDemoService demoService = (IDemoService) context.getBean("demoService");
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executeTest(executorService,demoService);
        new Semaphore(0).acquire();

    }

    private static void executeTest(ExecutorService executorService, IDemoService demoService) {
        for (int i = 0; i < 200; i++) {
            executorService.execute(()->{
                demoService.getData();
                //uncomment line below, memory kept by InternalThreadLocalMap will be freed
                //InternalThreadLocal.removeAll();
            });

        }

    }

}