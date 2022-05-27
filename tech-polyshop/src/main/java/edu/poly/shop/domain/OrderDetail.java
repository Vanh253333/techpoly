package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderDetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	
//	@Column(nullable = false)
//	private int orderId;
//	@Column(nullable = false)
//	
//	private int productId;
//	@Column(nullable = false)
	
	private int quantity;
	@Column(nullable = false)
	private double unitPrice;
	
	@ManyToOne
	@JoinColumn(name = "productId", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "orderId", nullable=false)
	private Order order;
}
