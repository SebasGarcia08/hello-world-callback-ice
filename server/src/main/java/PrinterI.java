public class PrinterI implements Demo.Printer
{
    public void printString(String s, Demo.CallbackPrx  cl, com.zeroc.Ice.Current current)
    {
	new Thread(()->{

	System.out.println(s);
	try{
	Thread.sleep(2000);
	cl.response("rutina terminada");
}catch(Exception e){
}
      }).start();        
         

    }
}
