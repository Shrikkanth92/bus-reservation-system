package com.polaris.teamd.ui.custom;

public class Contacts {
	private String name, phone;

	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contacts(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public final String getName() {
		return name;
	}

	public final String getPhone() {
		return phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contacts [name=" + name + ", phone=" + phone + "]";
	}

}
