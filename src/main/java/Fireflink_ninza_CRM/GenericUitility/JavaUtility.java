package Fireflink_ninza_CRM.GenericUitility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains generic methods which is related to java operations
 * @author Tushar Jadhav
 */
public class JavaUtility {

	/**
	 * It will return random number
	 * @param limit
	 * @return int
	 */
	public int getRandomNumber() {
		Random rn = new Random();
		return rn.nextInt(10000);
	}
	
	/**
	 * It will return system date
	 * @return String
	 */
	public String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		return s.format(d);
	}
}
