import junit.framework.TestCase;
public class TopUpAccountTest extends TestCase {
	
	//TESTS THE COSNTRUCTOR METHOD
	
	//Test #: test TopUpAccount001
	//Objective: Test with valid number and package type
	//Inputs : Number ="0871234567", type = "PhoneOnly"
	//Expected Output : Object Created with number = "0871234567", type = "PhoneOnly" , CB =0
	
	public void testTopUpAccount0001 () throws AccountExceptionHandler {
		try{
			TopUpAccount temp = new TopUpAccount("0871234567", "PhoneOnly");
		
			assertEquals(temp.getMobilePhoneNumber(),"0871234567" );
			assertEquals(temp.getPackageType(),"PhoneOnly" );
			assertEquals(temp.getCreditBalance(), 0.0);
		}
		catch (AccountExceptionHandler e) {
			
			fail("Exception Handler should not be called");
		}			
	}
	
	//Test #: test TopUpAccount002
	//Objective: Test with phone number missing a digit and package type correct
	//Inputs : Number ="086123456", type = "TextOnly"
	//Expected Output : Error
	public void testTopUpAccount0002 () throws AccountExceptionHandler{
		
		try {
		 TopUpAccount temp = new TopUpAccount("086123456"  , "TextOnly"); 
		 fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Phone number is Invalid." );
		}
	}
	
	//Test #: test TopUpAccount003
	//Objective: Test with phone number one too many digits and package type correct
	//Inputs : Number ="08512345678", type = "Mixed"
	//Expected Output : Error
	public void testTopUpAccount0003 () throws AccountExceptionHandler{
			
			try {
			 TopUpAccount temp = new TopUpAccount("08512345678"  , "Mixed"); 
			 fail("Should not get here ... exception expected"); 
			}
			catch (AccountExceptionHandler e) {
				assertSame(e.getMessage(),"Phone number is Invalid." );
			}
		}
		
	//Test #: test TopUpAccount004
	//Objective: Test with phone number having a letter in it and package type correct
	//Inputs : Number ="088A32B091", type = "Mixed"
	//Expected Output : Error
	public void testTopUpAccount0004 () throws AccountExceptionHandler{
			try {
			 TopUpAccount temp = new TopUpAccount("088A32B091"  , "Mixed"); 
			 fail("Should not get here ... exception expected"); 
			}
			catch (AccountExceptionHandler e) {
				assertSame(e.getMessage(),"Phone number involves letters." );
			}
		}
		
	//Test #: test TopUpAccount005
	//Objective: Test with phone number has a wrong start and package type correct
	//Inputs : Number ="0901234567", type = "Mixed"
	//Expected Output : Error
	public void testTopUpAccount0005 () throws AccountExceptionHandler{
			try {
			 TopUpAccount temp = new TopUpAccount("0901234567"  , "Mixed"); 
			 fail("Should not get here ... exception expected"); 
			}
			catch (AccountExceptionHandler e) {
				assertSame(e.getMessage(),"Operator is Invalid." );
			}
		}
		
	//Test #: test TopUpAccount005
	//Objective: Test with phone number correct and packageType incorrect
	//Inputs : Number ="0891234567", type = "PhoneAndText"
	//Expected Output : Error
	public void testTopUpAccount0006 () {
			try {
				TopUpAccount temp = new TopUpAccount("0891234567"  , "PhoneAndText"); 
				fail("Should not get here ... exception expected"); 
			}
			catch (AccountExceptionHandler e) {
				assertSame(e.getMessage(),"Package Type Invalid" );
			}
		}
	
	
	
	//TESTS THE MAKE A CALL METHOD
	
	
	
	//Test #: test makeCall2001
	//Objective: Test with all valid values
	//Inputs : Number ="0871234567", type = "PhoneOnly" ,ReceiverNumber ="0877654321", Credit Balance = 20, Call duration =10
	//Expected Output : Object Created with number = "0871234567", type = "PhoneOnly" , Call made, credit balance updated to =17.50
	public void testmakeCall2001 () throws AccountExceptionHandler {
		try{
			TopUpAccount temp = new TopUpAccount("0871234567", "PhoneOnly");
			temp.setCreditBalance(20);
			temp.makeCall("0877654321", 10);
			assertEquals(temp.getCreditBalance(),17.5);
		}
		catch (AccountExceptionHandler e) {
			
			fail("Exception Handler should not be called");
		}			
	}
	
	//Test #: test makeCall2002
	//Objective: Invalid operator
	//Inputs : Number ="0901234567", type = "PhoneOnly" ,Credit =20 ,  Duration =10
	//Expected Output : Error
	public void testmakeCall2002() {
				try {
					TopUpAccount temp = new TopUpAccount("0861234567"  , "PhoneOnly"); 
					temp.setCreditBalance(20);
					temp.makeCall("0901234567", 10);
					fail("Should not get here ... exception expected"); 
				}
				catch (AccountExceptionHandler e) {
					assertSame(e.getMessage(),"Operator is Invalid." );
				}
			}

	//Test #: test makeCall2003
	//Objective: Phone number too short
	//Inputs : Number ="0891234567", type = "Mixed" ,Credit =20 ,  Duration =10
	//Expected Output : Error
	public void testmakeCall2003() {
				try {
					TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
					temp.setCreditBalance(20);
					temp.makeCall("086123456", 10);
					fail("Should not get here ... exception expected"); 
				}
				catch (AccountExceptionHandler e) {
					assertSame(e.getMessage(),"Phone number is Invalid" );
				}
			}
	
		
	//Test #: test makeCall2004
	//Objective: Test with negative credit
	//Inputs : Number ="0861234567", type = "TextOnly" ,Credit =-2 ,  Duration =10
	//Expected Output : Error
		public void testmakeCall2004() {
					try {
						TopUpAccount temp = new TopUpAccount("0861234567"  , "TextOnly");
						temp.setCreditBalance(-2);
						temp.makeCall("0861234567", 10);
						fail("Should not get here ... exception expected"); 
					}
					catch (AccountExceptionHandler e) {
						assertSame(e.getMessage(),"Balance is too low" );
					}
				}
	
	//Test #: test makeCall2005
	//Objective: Mobile phone with letters
	//Inputs : Number ="08612A3456", type = "Mixed" ,Credit =20 ,  Duration =10
	//Expected Output : Error
		public void testmakeCall2005() {
					try {
						TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
						temp.setCreditBalance(20);
						temp.makeCall("08612A3456", 10);
						fail("Should not get here ... exception expected"); 
					}
					catch (AccountExceptionHandler e) {
						assertSame(e.getMessage(),"Phone number involves letters." );
					}
				}		
		
	//Test #: test makeCall2006
	//Objective: Duration of call negative
	//Inputs : Number ="0851234567", type = "Mixed" ,Credit =20 ,  Duration =-5
	//Expected Output : Error
	public void testmakeCall2006() {
				try {
					TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
					temp.setCreditBalance(20);
					temp.makeCall("0861234567", -5);
					fail("Should not get here ... exception expected"); 
				}
				catch (AccountExceptionHandler e) {
					assertSame(e.getMessage(),"Length of call is invalid" );
				}
		}
		
	//Test #: test makeCall2007
	//Objective: Duration of call at 0
	//Inputs : Number ="0861234567", type = "Mixed" ,Credit =20 ,  Duration =0
	//Expected Output : Error
	public void testmakeCall2007() {
				try {
					TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
					temp.setCreditBalance(20);
					temp.makeCall("0851234567", 0);
					fail("Should not get here ... exception expected"); 
				}
				catch (AccountExceptionHandler e) {
					assertSame(e.getMessage(),"Length of call is invalid" );
				}
		}	
					
	//Test #: test makeCall2008
	//Objective: Phone number is too long
	//Inputs : Number ="08812345678", type = "Mixed" ,Credit =20 ,  Duration =10
	//Expected Output : Error
		public void testmakeCall2008() {
					try {
						TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
						temp.setCreditBalance(20);
						temp.makeCall("08812345678", 10);
						fail("Should not get here ... exception expected"); 
					}
					catch (AccountExceptionHandler e) {
						assertSame(e.getMessage(),"Phone number is Invalid" );
					}
			}	
		
	//Test #: test makeCall2009
	//Objective: Credit balance at zero
	//Inputs : Number ="0891234567", type = "Mixed" ,Credit =0 ,  Duration =10
	//Expected Output : Error
		public void testmakeCall2009() {
					try {
						TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
						temp.setCreditBalance(0);
						temp.makeCall("0891234567", 10);
						fail("Should not get here ... exception expected"); 
					}
					catch (AccountExceptionHandler e) {
						assertSame(e.getMessage(),"Balance is too low" );
					}
		}
		
		
		//send Text method
		
		
	//Test #: test sendText 3001
	//Objective: All valid values, object created
	//Inputs : Number ="0861234567", type = "TextOnly" ,Credit =20
	//Expected Output : Object created, text sent, balance updated accordingly
	public void testsendText3001 () throws AccountExceptionHandler {
		try{
			TopUpAccount temp = new TopUpAccount("0871234567", "TextOnly");
			temp.setCreditBalance(20);
			temp.sendText("0861234567");
			assertEquals(temp.getCreditBalance(), 19.90);
		}
		catch (AccountExceptionHandler e) {
			
			fail("Exception Handler should not be called");
		}			
	}

	//Test #: test sendText3002
	//Objective: Phone number is too short
	//Inputs : Number ="085123456", type = "PhoneOnly,Credit =20 ,
	//Expected Output : Error
	public void testsendText3002() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "PhoneOnly");
			temp.setCreditBalance(20);
			temp.sendText("085123456");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Phone number is Invalid" );
		}
	}

	//Test #: test sendText3003
	//Objective: Phone number is too long
	//Inputs : Number ="08712345678", type = "Mixed" ,Credit = 20 ,
	//Expected Output : Error
	public void testsendText3003() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
			temp.setCreditBalance(20);
			temp.sendText("08712345678");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Phone number is Invalid" );
		}
	}	
	
	//Test #: test sendText3004
	//Objective:No credit
	//Inputs : Number ="08912345678", type = "Mixed" ,Credit = 0,
	//Expected Output : Error
	public void testsendText3004() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed");
			temp.setCreditBalance(0);
			temp.sendText("08912345678");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Balance is too low" );
		}
	}
	
	//Test #: test sendText3005
	//Objective:Wrong package type
	//Inputs : Number ="0881234567", type = "PhoneAndText" ,Credit = 20,
	//Expected Output : Error
	public void testsendText3005() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "PhoneAndText");
			temp.setCreditBalance(20);
			temp.sendText("0861234567");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Package Type Invalid" );
		}
	}
	

	//Test #: test sendText3006
	//Objective:Negative credit
	//Inputs : Number ="0861234567", type = "Mixed" ,Credit = -5
	//Expected Output : Error
	public void testsendText3006() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed" );
			temp.setCreditBalance(-5);
			temp.sendText("0881234567");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Balance is too low" );
		}
	}


	//Test #: test sendText3007
	//Objective: Invalid operator
	//Inputs : Number ="0901234567", type = "Mixed" ,Credit = 20
	//Expected Output : Error
	public void testsendText3007() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed" );
			temp.setCreditBalance(20);
			temp.sendText("0901234567");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Operator is Invalid." );
		}
	}


	//Test #: test sendText3008
	//Objective:Phone number has letters
	//Inputs : Number ="086A765432", type = "Mixed" ,Credit = 20,
	//Expected Output : Error
	public void testsendText3008() {
		try {
			TopUpAccount temp = new TopUpAccount("0861234567"  , "Mixed" );
			temp.setCreditBalance(20);
			temp.sendText("086A765432");
			fail("Should not get here ... exception expected"); 
		}
		catch (AccountExceptionHandler e) {
			assertSame(e.getMessage(),"Phone number involves letters." );
		}
	}





}