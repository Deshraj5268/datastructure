package javapractice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

abstract class BaseHealthCheckUp implements Runnable{

    private CountDownLatch latch;
    private String serviceName;
    private boolean isServiceUp;

    public BaseHealthCheckUp(String serviceName,CountDownLatch latch){
        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public void run(){
        try {
            verifyService();
            isServiceUp = true;
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
            isServiceUp = false;
        }finally {
            if(latch != null) {
                latch.countDown(); //while exception latch should be down otherwise deadlock can occur
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return isServiceUp;
    }

    public abstract void verifyService();
}

class NetworkHealthCheckUp extends BaseHealthCheckUp {


    public NetworkHealthCheckUp(CountDownLatch latch){
        super("networkService",latch);
    }

    @Override
    public void verifyService(){

        System.out.println("checking status for : "+this.getServiceName());
        try{
            Thread.sleep(100);
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(this.getServiceName()+" service is up now ...");
    }
}

class ApplicationStartUpUtil{

    private static CountDownLatch latch;

    private static List<BaseHealthCheckUp> healthListServices;

    private ApplicationStartUpUtil(){

    }

    private final static ApplicationStartUpUtil INSTANCE = new ApplicationStartUpUtil();

    public static ApplicationStartUpUtil getSingleTonInstance(){
        return INSTANCE;
    }

    public static boolean externalServiceStatusCheck() throws Exception{
        latch = new CountDownLatch(1);
        healthListServices = new ArrayList<>();
        healthListServices.add(new NetworkHealthCheckUp(latch));

        Executor executor = Executors.newFixedThreadPool(healthListServices.size());
        if(healthListServices != null && healthListServices.size()>0 ) {
            for (final BaseHealthCheckUp service : healthListServices) {
                executor.execute(service);
            }
        }
        latch.await();
        if(healthListServices != null && healthListServices.size()>0 ) {
            for (final BaseHealthCheckUp service : healthListServices) {
                if (!service.isServiceUp()) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class CountDownLatchDriver {

    public static void main(String[] args) {
        boolean result = false;
        try{
          result = ApplicationStartUpUtil.externalServiceStatusCheck();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("status : "+result);
    }


}
