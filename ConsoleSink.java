package com.suyog.loglib;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleSink extends Init implements MyLogger{
	private String namespace = "";
	public Thread t = Thread.currentThread();
	
	ConsoleSink(){
		//namespace = ns;
		///System.out.println(Thread.currentThread().getName()+"yehar");
	}
	public void setNamespace(String ns) {
		namespace = ns;
	}
	public String getNamespace() {
		return namespace;
	}
	public void closeLog() {
		//
	}
	private void toConsole(String message, String level) {
		try {	
			String dateFormatStr = properties.getProperty(level.toLowerCase().trim()+".ts_format");
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
			
			Calendar cal = Calendar.getInstance();
			System.out.println(dateFormat.format(cal.getTime())+" "+level.trim()+" "+"["+t.getName()+"]"+namespace+" "+message);
          
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void debug(String message) {
		if(super.getPriority()<=DEBUG)
			this.toConsole(message, "DEBUG");
	}

	@Override
	public void info(String message) {
		if(super.getPriority()<=INFO)
			this.toConsole(message, "INFO ");
	}

	@Override
	public void warn(String message) {
		if(super.getPriority()<=WARN)
			this.toConsole(message, "WARN ");
	}
	@Override
	public void error(String message) {
		if(super.getPriority()<=ERROR)
			this.toConsole(message, "ERROR");
	}

	@Override
	public void fatal(String message) {
		if(super.getPriority()<=FATAL)
			this.toConsole(message, "FATAL");
	}
}
