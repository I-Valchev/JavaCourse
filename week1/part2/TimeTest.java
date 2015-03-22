package part2;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	Time t;
	
	@Before
	public void setUp(){
		t = new Time();
	}

	
	
	@Test
	public void setAndGetYear(){
		t.setYear(2016);
		assertEquals(2016, t.getYear());
	}
	
	@Test
	public void dayAndMonth(){
		t.setMonth(1);
		t.setDay(31);
		assertEquals(1, t.getMonth());
		assertEquals(31, t.getDay());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void monthException(){
		t.setMonth(14);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void dayException(){
		t.setMonth(2);
		t.setDay(29);
	}
	
	@Test
	public void hours(){
		t.setHours(5);
		assertEquals(5, t.getHours());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hoursException(){
		t.setHours(26);
	}
	
	@Test
	public void minutes(){
		t.setMinutes(5);
		assertEquals(5, t.getMinutes());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void minutesException(){
		t.setMinutes(65);
	}
	
	@Test
	public void seconds(){
		t.setSeconds(5);
		assertEquals(5, t.getSeconds());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void secondsException(){
		t.setSeconds(65);
	}
	
	@Test
	public void millisecodns(){
		t.setMilliseconds(500);
		assertEquals(500, t.getMilliseconds());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void millisecondsException(){
		t.setMilliseconds(1005);
	}
	
	@Test
	public void constructionWithTimeObject(){
		t.setYear(2016);
		assertEquals(2016, new Time(t).getYear());
	}

}
