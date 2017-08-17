package com.polaris.teamd.bean;

import java.util.Date;

public class CPNRCancellation {
	
	private long PNRNumber;
	private Date cancellationDate = new Date();
	private int cancellationType;
	private Date cancellationTime = new Date();
	private int cancelledTicketCount;
	private double refundAmount;
	private int cancelledAdultCount, cancelledChildCount, cancelledMaleCount,
			cancelledFemaleCount;

	public CPNRCancellation() {
		super();
	}

	public CPNRCancellation(long PNRNumber, Date cancellationDate,
			int cancellationType, Date cancellationTime,
			int cancelledTicketCount, double refundAmount,
			int cancelledAdultCount, int cancelledChildCount,
			int cancelledMaleCount, int cancelledFemaleCount) {
		super();
		this.PNRNumber = PNRNumber;
		this.cancellationDate = cancellationDate;
		this.cancellationType = cancellationType;
		this.cancellationTime = cancellationTime;
		this.cancelledTicketCount = cancelledTicketCount;
		this.refundAmount = refundAmount;
		this.cancelledAdultCount = cancelledAdultCount;
		this.cancelledChildCount = cancelledChildCount;
		this.cancelledMaleCount = cancelledMaleCount;
		this.cancelledFemaleCount = cancelledFemaleCount;
	}

	public long getPNRNumber() {
		return PNRNumber;
	}

	public void setPNRNumber(long PNRNumber) {
		this.PNRNumber = PNRNumber;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public int getCancellationType() {
		return cancellationType;
	}

	public void setCancellationType(int cancellationType) {
		this.cancellationType = cancellationType;
	}

	public Date getCancellationTime() {
		return cancellationTime;
	}

	public void setCancellationTime(Date cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public int getCancelledTicketCount() {
		return cancelledTicketCount;
	}

	public void setCancelledTicketCount(int cancelledTicketCount) {
		this.cancelledTicketCount = cancelledTicketCount;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public int getCancelledAdultCount() {
		return cancelledAdultCount;
	}

	public void setCancelledAdultCount(int cancelledAdultCount) {
		this.cancelledAdultCount = cancelledAdultCount;
	}

	public int getCancelledChildCount() {
		return cancelledChildCount;
	}

	public void setCancelledChildCount(int cancelledChildCount) {
		this.cancelledChildCount = cancelledChildCount;
	}

	public int getCancelledMaleCount() {
		return cancelledMaleCount;
	}

	public void setCancelledMaleCount(int cancelledMaleCount) {
		this.cancelledMaleCount = cancelledMaleCount;
	}

	public int getCancelledFemaleCount() {
		return cancelledFemaleCount;
	}

	public void setCancelledFemaleCount(int cancelledFemaleCount) {
		this.cancelledFemaleCount = cancelledFemaleCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (PNRNumber ^ (PNRNumber >>> 32));
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
		CPNRCancellation other = (CPNRCancellation) obj;
		if (PNRNumber != other.PNRNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PNRCancellation [PNRNumber=" + PNRNumber
				+ ", cancellationDate=" + cancellationDate
				+ ", cancellationType=" + cancellationType
				+ ", cancellationTime=" + cancellationTime
				+ ", cancelledTicketCount=" + cancelledTicketCount
				+ ", refundAmount=" + refundAmount + ", cancelledAdultCount="
				+ cancelledAdultCount + ", cancelledChildCount="
				+ cancelledChildCount + ", cancelledMaleCount="
				+ cancelledMaleCount + ", cancelledFemaleCount="
				+ cancelledFemaleCount + "]";
	}

}
