public class Client
{
    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args,"config.client"))
        {
            com.zeroc.Ice.ObjectPrx base = communicator.propertyToProxy("Printer");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

	    com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Callback");
            com.zeroc.Ice.Object object = new CallbackI();
            com.zeroc.Ice.ObjectPrx objPrx= adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("callback"));
            adapter.activate();
            if(printer == null)
            {
                throw new Error("Invalid proxy");
            }

	    Demo.CallbackPrx callPrx = Demo.CallbackPrx.uncheckedCast(objPrx);
            printer.printString("Hello World!",callPrx);

            communicator.waitForShutdown();
		
        }
    }
}
