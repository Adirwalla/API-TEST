package com.jhonbryce;

public class ImportantOrderTask implements Runnable {

	private Order order;

	public ImportantOrderTask(Order order) {
		this.order = order;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(order);

			try {
				Thread.sleep(1000 * 60);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
	
	
}


