package uo.sdi.tests;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.Before;
import org.junit.Test;

public class TestNav {

	  private WebTester john;


		@Before
	    public void prepare() {
	    	john=new WebTester();
	    	john.setBaseUrl("http://localhost:8280/TaskManager/");
	    }


	  @Test 
	    public void adminTest(){
	    	WebTester browser=new WebTester();
	    	browser.setBaseUrl("http://localhost:8280/TaskManager/");        
	    	WebTester admin = new WebTester();
	    	admin.setTextField("nombreUsuario", "admin");
	    	admin.setTextField("userPass", "admin123");
	    	browser.submit();
	    	browser.assertTitleEquals("TaskManager - Página principal del administrador");
	    }
}
