package iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.FactoryBusinessLogic;
import domain.Event;

public class main {

	public static void main(String[] args) {	
		BLFacade blFacade = new FactoryBusinessLogic().getBusinessLogic(false);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse("17/12/2022");
			ExtendedIterator<Event> i = blFacade.getEventsIterator(date);
			Event e;
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ATRÁS");
			i.goLast(); // Hacia atrás
			while (i.hasPrevious()) {
				e = i.previous();
				System.out.println(e.toString());
			}
			System.out.println();
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ADELANTE");
			i.goFirst(); // Hacia adelante
			while (i.hasNext()) {
				e = i.next();
				System.out.println(e.toString());
			}
		} catch (ParseException e1) {
			System.out.println("Problems	with	date??	" + "17/12/2020");
		}

	}

}
