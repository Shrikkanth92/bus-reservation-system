package com.polaris.teamd.bean;

public class CBusType {
	private int id, numberOfSeats;
	private String name = new String(), description = new String();

	public CBusType() {
		super();
	}

	public CBusType(int id, int numberOfSeats, String name, String description) {
		super();
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CBusType other = (CBusType) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CBusType [id=" + id + ", numberOfSeats=" + numberOfSeats
				+ ", name=" + name + ", description=" + description + "]";
	}

}
