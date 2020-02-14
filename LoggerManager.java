package com.suyog.loglib;

public class LoggerManager extends Init{
	
	private static MyLogger l = null;
	static Init it = new Init();
	
	private static void setSinkObj(String namespace) {
		if(it.getSinkType().equals("File")) {
			l = new FileSink();
			l.setNamespace(namespace);
		}
		else if(it.getSinkType().equals("Console")) {
			l = new ConsoleSink();
			l.setNamespace(namespace);
		}
	}
	
	public static MyLogger getInstance(){
		setSinkObj("");
		return l;
	}	
	public static MyLogger getInstance(String namespace){
		if(l==null) {
			setSinkObj(namespace);
		}
		else if(l != null) {
			if(l.getClass().getName()==namespace)
				return l;
			else {
				setSinkObj(namespace);
			}
		}
		return l;
	}	
	
}