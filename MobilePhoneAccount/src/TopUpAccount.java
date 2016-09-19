public class TopUpAccount {
	private String mobilePhoneNumber;
	private double creditBalance;
	private String packageType;
	public TopUpAccount (String number, String type) throws AccountExceptionHandler
	{
		if (!(number.substring(0,3).equals("085") || number.substring(0,3).equals("086") || number.substring(0,3).equals("087") || number.substring(0,3).equals("088") ||number.substring(0,3).equals("089")))
			throw new AccountExceptionHandler("Operator is Invalid.");
		else if (!(number.length()==10))
			throw new AccountExceptionHandler("Phone number is Invalid.");
		else if (!(number.matches("[0-9]+")))
			throw new AccountExceptionHandler("Phone number involves letters.");
		if (!(type.equals("PhoneOnly") || type.equals("TextOnly") || type.equals("Mixed") ))
			throw new AccountExceptionHandler("Package Type Invalid");
		else
		{
			mobilePhoneNumber = number;
			creditBalance = 0;
			packageType = type;
		}
		
	}
	public void setMobilePhoneNumber(String number) {
		mobilePhoneNumber = number;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setCreditBalance (int amount) {
		creditBalance = amount;
	}
	public double getCreditBalance () {
		return creditBalance;
	}
	public void setPackageType (String type) {
		packageType = type;
	}
	public String getPackageType () {
		return packageType;
	}
	public void makeCall(String destinationNumber, int lengthOfCall) throws AccountExceptionHandler
	{
		double callCost =0.0;
		if (!(destinationNumber.substring(0,3).equals("085") || destinationNumber.substring(0,3).equals("086") || destinationNumber.substring(0,3).equals("087") || destinationNumber.substring(0,3).equals("088") ||destinationNumber.substring(0,3).equals("089")))
			throw new AccountExceptionHandler("Operator is Invalid.");
		//if (!(type.equals("PhoneOnly") || type.equals("TextOnly") || type.equals("Mixed") ))
		if (lengthOfCall <= 0)
			throw new AccountExceptionHandler("Length of call is invalid");
		
		if (packageType.equals("PhoneOnly"))
			callCost = lengthOfCall * 0.25 ;
		
		if (packageType.equals("TextOnly"))
			callCost = lengthOfCall * 0.50 ;
		
		if (packageType.equals("Mixed"))
			callCost = lengthOfCall * 0.20 ; 
		
		if (callCost > creditBalance)
			throw new AccountExceptionHandler("Balance is too low");
		
		if (!(destinationNumber.length()==10))
			throw new AccountExceptionHandler("Phone number is Invalid");
		else if (!(destinationNumber.matches("[0-9]+")))
			throw new AccountExceptionHandler("Phone number involves letters.");
		else
		{
			creditBalance -= callCost;
		}
	}
	public void sendText(String destinationNumber) throws AccountExceptionHandler
	{
		double textCost =0.0;
		if (!(destinationNumber.substring(0,3).equals("085") || destinationNumber.substring(0,3).equals("086") || destinationNumber.substring(0,3).equals("087") || destinationNumber.substring(0,3).equals("088") ||destinationNumber.substring(0,3).equals("089")))
			throw new AccountExceptionHandler("Operator is Invalid.");
		//if (!(type.equals("PhoneOnly") || type.equals("TextOnly") || type.equals("Mixed") ))
		
		if (packageType.equals("PhoneOnly"))
			textCost = 0.45 ;
		
		if (packageType.equals("TextOnly"))
			textCost =  0.10 ;
		
		if (packageType.equals("Mixed"))
			textCost =  0.05 ; 
		
		if (textCost > creditBalance)
			throw new AccountExceptionHandler("Balance is too low");
		
		if (!(destinationNumber.length()==10))
			throw new AccountExceptionHandler("Phone number is Invalid");
		else if (!(destinationNumber.matches("[0-9]+")))
			throw new AccountExceptionHandler("Phone number involves letters.");
		else
		{
			creditBalance -= textCost;
		}
	}
}