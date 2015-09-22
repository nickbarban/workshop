package supply;

import javax.swing.JFrame;

import utils.Parser;



/**
 * Hello world!
 *
 */
public class SupplyClient {
	
	public final static boolean DEBUG = true;
	
	public static JFrame mainFrame; 
	
    public static void main( String[] args ) {
    	
    	Parser.readAuda();
    	
    	mainFrame = new SupplyMainFrame("Razbor 0.1 - Supply");
    	
    	
    	
        System.out.println( "Hello World!" );
    }

	
}
