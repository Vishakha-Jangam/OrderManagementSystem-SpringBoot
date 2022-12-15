package com.OMS.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Customer {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customer_id;
	    
	    private String name;
	    
		private String userName;
		
		private String email;
		
		private String password;
		
		private String category="Regular";
		
		@NotNull
		@OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Orders> orders;

		
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Customer(Long customer_id, String name, String userName, String email, String password, String category,
				List<Orders> orders) {
			super();
			this.customer_id = customer_id;
			this.name = name;
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.category = category;
			this.orders = orders;
		}


		public Long getCustomer_id() {
			return customer_id;
		}


		public void setCustomer_id(Long customer_id) {
			this.customer_id = customer_id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public List<Orders> getOrders() {
			return orders;
		}


		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}
		
		

		
}
