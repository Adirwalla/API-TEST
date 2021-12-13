package com.jhonbryce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OrderSystem {

	private Set<Order> orders;
	private OrderTask task;

	public OrderSystem() {
		orders = new TreeSet<Order>();
		task = new OrderTask(orders);
		new Thread(task).start();
		orderMenu();

	}

	public boolean addOrder(Order order) {
		if (!orders.contains(order)) {
			if (order.getReadyON().after(Calendar.getInstance())) {
				orders.add(order);
				return true;

			}

		}
		return false;

	}

	public List<Order> getOrders() {
		List<Order> l1 = new ArrayList<>(orders);
		return l1;
	}

	public void orderMenu() {
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.println("Please insert a number according to the menu");
			System.out.println("\"1: add order \\n2: view orders \\n3: exit\"");

			int choice = s1.nextInt();
			s1.nextLine();

			switch (choice) {
			case 1:
				Order newOrder = new Order();
				System.out.println("Please insert order description");
				newOrder.setText(s1.nextLine());

				Calendar c1 = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				System.out.println("please insert date in this format: dd-mm-yyyy");
				String date = s1.nextLine();

				System.out.println("please insert time in this format: hh:mm:ss");
				String time = s1.nextLine();

				try {
					c1.setTime(sdf.parse(date + " " + time));
				} catch (ParseException e) {

					e.printStackTrace();
				}

				newOrder.setReadyON(c1);
				System.out.println("Is this an important order? pliz insert: Y/N");
				String isImportant = s1.nextLine();
				if (isImportant.trim().equalsIgnoreCase("Y")) {
					newOrder.setImportant(true);
				}
//				System.out.println("is this an important order?");
//				if (isImportant.isBlank()) {
//					newOrder.setImportant(true);
//				}
				if (addOrder(newOrder)) {
					System.out.println("your order added successfuly");
				} else {
					System.out.println("order allrady exsist");
				}
				break;
			case 2:
				System.out.println(getOrders());
				break;
			case 3:
				System.exit(0);
				return;

			default:
				System.out.println("worng input Please try again /n please Follow the instructions above");
			}

		}
	}

}
