import java.io.FileNotFoundException;
import java.io.IOException;

import com.suyog.loglib.LoggerManager;
import com.suyog.loglib.MyLogger;

/*
class MultithreadingDemo extends Pac implements Runnable {
	
    public void run(){
    	System.out.println(super.temp);
    	/*final MyLogger log = LoggerManager.getInstance(MultithreadingDemo.class.getName());
        try{
        	
         	log.debug("threads debugging");
         	log.info("Info in thread");
         	System.out.println(Thread.currentThread().getName());
        }
        catch (Exception e){
            // Throwing an exception
            System.out.println ("Exception is caught");
        }*/
  //  }
//}

public class Pac {
	
	//static Thread t = Thread.currentThread();
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		
		//Pac2 pa = new Pac2();
		//System.out.println(t.getName());
		//Thread object = new Thread(new MultithreadingDemo());
		//object.start();
		/*try {
			t.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*t.sleep(1000);
		System.out.println("Main is running..");
		System.out.println("Main is running..");
		System.out.println("Main is running..");*/
		
			
		final MyLogger log = LoggerManager.getInstance(Pac.class.getName());//This will create one object for one class
		//final MyLogger log = LoggerManager.getInstance();//This will create one object for entire application
		log.debug("This is debugg!!");
		//Pac2 pa = new Pac2();
		//System.out.println(Thread.currentThread().getName());
		log.info("This is info info !!");
		log.info("This is info info !!");
		log.info("This is info info !!");
		log.info("This is info info !!");
		log.closeLog();
		
		//log.info("This is info info !!");
		//if(pa.getClass().getName() == null)
		//System.out.println("yooo");
	}
};
