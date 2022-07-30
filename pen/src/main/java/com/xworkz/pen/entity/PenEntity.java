package com.xworkz.pen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@NamedQuery(name = "PenEntity.findPenByName", query = "from PenEntity where penName=:NAME")
@NamedQuery(name = "PenEntity.delete", query = "delete from PenEntity where penName=:NAME")
@NamedQuery(name = "PenEntity.getAllDetails", query = "from PenEntity")
@NamedQuery(name = "PenEntity.updatePenByName", query = "update PenEntity set penName=:PENNAME, penColor=:PENCOLOR, penPrice=:PENPRICE where penName=:PENName")
@Table(name = "pen_table")
@Entity
public class PenEntity {

	@GenericGenerator(name = "id", strategy = "increment")
	@GeneratedValue(generator = "id")
	@Id
	@Column(name = "ID")
	private int penId;

	@Column(name = "PEN_NAME")
	private String penName;

	@Column(name = "PEN_COLOR")
	private String penColor;

	@Column(name = "PEN_PRICE")
	private int penPrice;

	public PenEntity() {

	}

	public PenEntity(String penName, String penColor, int penPrice) {
		super();
		this.penName = penName;
		this.penColor = penColor;
		this.penPrice = penPrice;
	}

	

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getPenColor() {
		return penColor;
	}

	public void setPenColor(String penColor) {
		this.penColor = penColor;
	}

	public int getPenPrice() {
		return penPrice;
	}

	public void setPenPrice(int penPrice) {
		this.penPrice = penPrice;
	}

	@Override
	public String toString() {
		return "PenEntity [ penName=" + penName + ", penColor=" + penColor + ", penPrice=" + penPrice + "]";
	}

}
