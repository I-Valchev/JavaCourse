package part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class week1Test{

	@Test
	public void test() {
		assertEquals(4, new week1().getNumberOfDigits(1444));
	}
	
	@Test
	public void joinStringsTest(){
		assertEquals("I join strings", new week1().joinStrings(" ","I","join", "strings"));
	}
	
	@Test
	public void reduceFilePathTest(){
		assertEquals("/", new week1().reduceFilePath("/"));
		
		assertEquals("/", new week1().reduceFilePath("/srv/../"));
		assertEquals("/srv/www/htdocs/wtf", new week1().reduceFilePath("/srv/www/htdocs/wtf/"));
		assertEquals("/srv/www/htdocs/wtf", new week1().reduceFilePath("/srv/www/htdocs/wtf"));
		assertEquals("/srv", new week1().reduceFilePath("/srv/./././././"));
		assertEquals("/etc/wtf", new week1().reduceFilePath("/etc//wtf/"));
		assertEquals("/", new week1().reduceFilePath("/etc/../etc/../etc/../"));
		assertEquals("/", new week1().reduceFilePath("//////////////"));
		assertEquals("/", new week1().reduceFilePath("/../"));
	}

}
