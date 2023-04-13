package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o número do quarto: ");
		int number = sc.nextInt();
		System.out.println("Data do Check-In (DD/MM/AAAA):  ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do Check-Out (DD/MM/AAAA):  ");
		Date checkOut = sdf.parse(sc.next());
			
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva. A data de checkOut precisa ser posterior a data de checkIn");
		}
		else {
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.println("Data do Check-In (DD/MM/AAAA):  ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-Out (DD/MM/AAAA):  ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva. As datas precisam sem futuras");
			}
			else if (!checkOut.after(checkIn)) {
					System.out.println("Erro na reserva. A data de checkOut precisa ser posterior a data de checkIn");
				}
			else {
				reserva.dataAtualizada(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
				
			}					
		}
		sc.close();
	}

}
