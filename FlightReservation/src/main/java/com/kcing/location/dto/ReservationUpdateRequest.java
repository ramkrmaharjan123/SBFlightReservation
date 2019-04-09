package com.kcing.location.dto;

public class ReservationUpdateRequest {
	
	private Long reservationId;
	private Boolean checkedin;
	private int numOfBags;
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public Boolean getCheckedin() {
		return checkedin;
	}
	public void setCheckedin(Boolean checkedin) {
		this.checkedin = checkedin;
	}
	public int getNumOfBags() {
		return numOfBags;
	}
	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}
	

}
