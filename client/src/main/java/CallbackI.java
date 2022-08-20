public class CallbackI implements Demo.Callback
{
    public void response(String msg, com.zeroc.Ice.Current current){

		System.out.println(msg);
	}
}
