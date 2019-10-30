package corejava;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadLocalRandom;

public class BlockingQueueDemo {
	static LinkedTransferQueue<Integer> ltq=new LinkedTransferQueue<>();
	
	
	public static void main(String[] args){
		
		Runnable r1=()->{
		while(true){
			try {
			Thread.sleep(10);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} try {
			
			if(ltq.size()>=10)
			{
				int i=ThreadLocalRandom.current().nextInt(100);
				System.out.println("TRANSFERRED ITEM TO COLLECTION "+i);
				ltq.transfer(i);
			}
			else
			{	int i=ThreadLocalRandom.current().nextInt(100);
				System.out.println("ADDED ITEM TO COLLECTION "+i);
				ltq.put(i);
			}
			
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		};
		
		Runnable r2=()->{ while(true){
			try {
				Thread.sleep(1000);
				System.out.println(ltq.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
		
		
		
	}
	
}
