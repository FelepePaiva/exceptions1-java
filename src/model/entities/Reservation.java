package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void dataAtualizada(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Quarto " +
				numeroQuarto +
				", check-in: " +
				sdf.format(checkIn) +
				", check-out: " +
				sdf.format(checkOut) +
				", " +
				duracao() +
				" noites";
	}

}
	
	
	
	

