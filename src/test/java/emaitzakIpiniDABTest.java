
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;

public class emaitzakIpiniDABTest {

private static DataAccess sut = new DataAccess();
	
	private Event eve1;
	private Event eve2;
	private Question q1;
	private Question q2;
	private Quote quo1;
	private Quote quo2;

	
	@Before
	public void initialize() {
		
		eve1 = sut.getEventsAll().get(0);
		q1 = eve1.getQuestions().get(0);
		quo1 = q1.getQuotes().get(0);
		
		eve2 = sut.getEventsAll().get(0);
		q2 =  eve2.getQuestions().get(1);		
		quo2 = q2.getQuotes().get(0);	
	}
	
	@Test /* Camino en el que la cuota pasada por parametro no esta en BD **/
	public void test0() {
		
		Quote quo = new Quote(1.5, "X", q1);

		try {
			sut.EmaitzakIpini(quo);
		}catch(Exception e) {
			assertTrue(true);
			System.out.println("Esa cuota no esta en la base de datos ");
		}
	}
	
	@Test /* Camino para comprobar que el resultado de la pregunta se pone correctamente  **/
	public void test1() {
		
		Date fecha = eve2.getEventDate();
		eve2.setEventDate(UtilDate.newDate(2021,8,7));
		
		try {
			sut.EmaitzakIpini(quo2);
		}catch(Exception EventNotFinished) {
			
			System.out.println("EventNotFinished");
			//assertTrue(true);
		}
		
		String expected = quo2.getForecast();
		String obtained = q2.getResult();
		
		assertEquals(expected, obtained);


		try {
			eve2.setEventDate(fecha);
			quo2.getQuestion().setResult("");
		} catch (Exception e) {
			fail("No es posible");
		}
	}
	
	@Test  /* Camino salta excepcion por fecha del evento todavia no finalizada **/
	public void test2() {
		
		Date fecha  = eve1.getEventDate();
		eve1.setEventDate(UtilDate.newDate(2023,11,23));


		try {
			
			sut.EmaitzakIpini(quo1);
			
		}catch(Exception EventNotFinished) {
			
			System.out.println("EventNotFinished");
			assertTrue(true);
		}
		
		try {
			eve1.setEventDate(fecha);	
		} catch (Exception e) {	
			fail("No es posible");
		}
		
	}
	
	
	
}