package com.uniovi.entities;
import java.util.HashSet;
import java.util.Set; //A collection that contains no duplicate elements

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue

	private long id;
//	: email, nombre, apellidos y una
//	contraseñ
	@Column(unique=true)

	private String email;
	private String name;
	private String lastName;
	private double money;

	private String role;
	private String password;

	@Transient //propiedad que no se almacena e la tabla.
	private String passwordConfirm;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Offer> offers = new HashSet<Offer>();
	
	@OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
	private Set<Offer> buyedOffers = new HashSet<Offer>();
	
//	@OneToMany(mappedBy = "owner")
//	private Set<Conversation> conversations = new HashSet<Conversation>();
	
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	private Set<Conversation> conversationsBuyer = new HashSet<Conversation>();
	
	
	public User(String email, String name, String lastName) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.money = 100.0;
	}

	public User() {
	}

	public Set<Offer> getBuyedOffers() {
		return buyedOffers;
	}

//	public Set<Conversation> getConversations() {
//		return conversations;
//	}
//
//	public void setConversations(Set<Conversation> conversations) {
//		this.conversations = conversations;
//		this.conversationsBuyer = conversations;
//	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = Math.round(money * 100.0) / 100.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}
	
	public Set<Conversation> getConversationsBuyer() {
		return conversationsBuyer;
	}

	public void setConversationsBuyer(Set<Conversation> conversationsBuyer) {
		this.conversationsBuyer = conversationsBuyer;
	}
	
//	public void addConversation(Conversation conver) {
//		this.conversations.add(conver);
//		
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name 
				+ ", lastName=" + lastName + ", money=" + money
				+ ", role=" + role + "]";
	}

}