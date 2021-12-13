package com.jhonbryce;

import java.util.Calendar;
import java.util.Objects;

public class Order implements Comparable<Order> {
	private Calendar readyON;
	private String text;
	private boolean important;
	private boolean popped;

	public Calendar getReadyON() {
		return readyON;
	}

	public void setReadyON(Calendar readyON) {
		this.readyON = readyON;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isPopped() {
		return popped;
	}

	public void setPopped(boolean popped) {
		this.popped = popped;
	}

	@Override
	public int hashCode() {
		return Objects.hash(important, popped, readyON, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return important == other.important && popped == other.popped && Objects.equals(readyON, other.readyON)
				&& Objects.equals(text, other.text);
	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return o.getReadyON().compareTo(this.readyON);
	}

	@Override
	public String toString() {
		return "Order [readyON=" + readyON + ", text=" + text + ", important=" + important + ", popped=" + popped + "]";
	}

}
