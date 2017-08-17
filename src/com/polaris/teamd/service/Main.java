package com.polaris.teamd.service;

import java.util.Collection;

import com.polaris.teamd.bean.CReservation;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CSReservationImpl impl=new CSReservationImpl();
		Collection<CReservation> reservations=impl.getAllReservation1();
		
	}

}
