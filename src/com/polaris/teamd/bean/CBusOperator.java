package com.polaris.teamd.bean;

public class CBusOperator {
	private int operatorId;
	private String operatorName = new String(), officeAddress = new String(),
			phoneNumber1 = new String(), phoneNumber2 = new String(),
			emailId = new String(), contactPerson = new String();
	private boolean hasService;

	public CBusOperator() {
		super();
	}

	public CBusOperator(int operatorId, String operatorName,
			String officeAddress, String phoneNumber1, String phoneNumber2,
			String emailId, String contactPerson, boolean hasService) {
		super();
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.officeAddress = officeAddress;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.emailId = emailId;
		this.contactPerson = contactPerson;
		this.hasService = hasService;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public boolean isHasService() {
		return hasService;
	}

	public void setHasService(boolean hasService) {
		this.hasService = hasService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + operatorId;
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
		CBusOperator other = (CBusOperator) obj;
		if (operatorId != other.operatorId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusOperator [operatorId=" + operatorId + ", operatorName="
				+ operatorName + ", officeAddress=" + officeAddress
				+ ", phoneNumber1=" + phoneNumber1 + ", phoneNumber2="
				+ phoneNumber2 + ", emailId=" + emailId + ", contactPerson="
				+ contactPerson + ", hasService=" + hasService + "]";
	}

}
