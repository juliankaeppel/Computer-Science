package lecture2.medium;
/**
 * 
 * @author Julian Kaeppel
 *
 */

public class Validation {

	public static void main(String[] args) {
		Validation v = new Validation();
		
		if(args.length != 1 || args[0].equals("-h") 
				|| args[0].equals("--help")) {
			System.out.println("This program tells you information"
					+ "about a given credit card number."
					+ "\nusage: Validation card\noptions:"
					+ "\n\t{card} The number of the card to check.");
			return;
		}
		
		if(v.isValid(args[0])) {
			v.type(args[0]);
			v.iid(args[0]);
			v.account(args[0]);
		} else System.out.println("Not valid");
	}
	
	/**
	 * Prints the type of credit card.
	 * @param card The card number in <CODE>String</CODE> format 
	 * to check the type of.
	 */
	void type(String card) {
		System.out.print("Card type: ");
		
		switch(Character.getNumericValue(card.charAt(0))) {
		case 1:
			System.out.println("1 - Airlines");
			break;
		case 2:
			System.out.println("2 - Airlines & Financial");
			break;
		case 3:
			System.out.println("3 - Travel & Entertainment");
			break;
		case 4:
			System.out.println("4 - Banking & Financial (VISA)");
			break;
		case 5:
			System.out.println("5 - Banking & Financial (Mastercard)");
			break;
		case 6:
			System.out.println("6 - Merchandising and Banking");
			break;
		case 7:
			System.out.println("7 - Petroleum");
			break;
		case 8:
			System.out.println("8 - Health Care & Telecommunications");
			break;
		case 9:
			System.out.println("9 - Open for Assignment");
		}
	}
	
	/**
	 * Prints the Issuer Identification number of a credit card, as
	 * well as a description of what that number means, if it is
	 * recognized.
	 * @param card The card number in <CODE>String</CODE> format to
	 * check the iid of.
	 */
	void iid(String card) {
		String iid = card.substring(0, 6);
		System.out.print("IID: " + iid);
		
		if(iid.equals("414720"))
			System.out.print(" - Chase Signature Visa");
		if(iid.equals("480011"))
			System.out.print(" - Bank of America Visa Gold");
		if(iid.equals("379741"))
			System.out.print(" - American Express Credit");
		if(iid.equals("542418"))
			System.out.print(" - Citibank Platinum Mastercard");
		if(iid.equals("414709"))
			System.out.print(" - Capital One Signature Visa");
		if(iid.equals("601101"))
			System.out.print(" - Discover Rewards");
		if(iid.equals("446542"))
			System.out.print(" - Wells Fargo Platinum Visa");
		if(iid.equals("403766"))
			System.out.print(" - U.S. Bank Visa");
		if(iid.equals("559309"))
			System.out.print(" - Barclays World Mastercard");
		if(iid.equals("549123"))
			System.out.print(" - USAA Platinum Mastercard");
		
		System.out.println();
	}
	
	/**
	 * Prints the account number of the given credit card.
	 * @param card The card number in <CODE>String</CODE> format to
	 * check the account number of.
	 */
	void account(String card) {
		System.out.println("Account #: " + 
				card.substring(6, card.length() - 1));
	}
	
	
	/**
	 * Checks if a credit card number is valid using the Luhn algorithm.
	 * @param card The credit card number in <CODE>String</CODE> format.
	 * @return <CODE>true</CODE> if the card number is valid,
	 * <CODE>false</CODE> otherwise.
	 */
	boolean isValid(String card) {
		int sum = 0;
		
		//Going in reverse order, performs the Luhn algorithm on card.
		for(int i = card.length() - 1; i >= 0; i--) {
			int n = Character.getNumericValue(card.charAt(i));
			
			if(((card.length() - i + 1) & 1) == 0) sum += n;
			else sum += n * 2 < 10 ? n * 2 : n * 2 - 9;
		}
		
		return sum % 10 == 0;
	}
}
