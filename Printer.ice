module Demo
{
    interface Callback{
	void response(string rs );
    }
    interface Printer
    {
        void printString(string s, Callback* cl);
    }

    
}
