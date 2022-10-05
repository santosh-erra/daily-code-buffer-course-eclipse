package com.dailycodebuffer.orderservice.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	@Column
	private long productId;
	@Column
	private long quantity;
	@Column
	private Instant orderDate;
	@Column
	private String orderStatus;
	@Column
	private long amount;

	public Order() {
	}

	public Order(long orderId, long productId, long quantity, Instant orderDate, String orderStatus, long amount) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.amount = amount;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Instant getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
