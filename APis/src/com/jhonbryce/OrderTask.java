package com.jhonbryce;

import java.util.Calendar;
import java.util.Set;

public class OrderTask implements Runnable {

	private Set<Order> orders;

	public OrderTask(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void run() {
		while (true) {
			for (Order order : orders) {
				if (!order.isPopped() && order.getReadyON().before(Calendar.getInstance())) {
					order.setPopped(true);

					if (order.isImportant()) {
						Thread t1 = new Thread(new ImportantOrderTask(order), "t1");
						t1.start();
					} else {
						System.out.println(order);
					}
				}
			}

			try {
				Thread.sleep(1000 * 5);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
