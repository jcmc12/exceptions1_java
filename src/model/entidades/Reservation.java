package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//static é utilizado para evitar que tenha uma nova instância quando o objeto
	//Reservation é instanciado
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {

		if(!checkOut.after(checkIn)) { //verifica se a data de saída é após a data de entrada
			throw new DomainException("ckeck-out date must be after ckeck-in date");
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //fazer a diferença em milissegundos
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
		
		//getTime() = converte a data para milissegundos 
		//TimeUnit.Days.convert() converter os milissegundos para Dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future");
			//faz a comparação da data atual com a data informada pelo usuário
		}
		
		if(!checkOut.after(checkIn)) { //verifica se a data de saída é após a data de entrada
			throw new DomainException("ckeck-out date must be after ckeck-in date");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	
	}
	
	@Override
	public String toString() {
		return "Room"
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	

}
