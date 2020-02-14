package com.suyog.loglib;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FileSink extends Init implements MyLogger{
	public List<String> msgList = new LinkedList<String>();
	ListIterator<String> it = msgList.listIterator();
	
	protected String namespace = "";
	public String level="";
	public String message="";
	public Thread t = Thread.currentThread();
	FileSink(){
	}
	public void setNamespace(String ns) {
		namespace = ns;
	}
	
	public String getNamespace() {
		return namespace;
	}
	private void toFile(String message1, String level1) {
		message = message1;
		level = level1;
		
		String dateFormatStr = properties.getProperty(level.toLowerCase().trim()+".ts_format");
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
	    Calendar cal = Calendar.getInstance();
	    String s = dateFormat.format(cal.getTime())+" "+level.trim()+" "+"["+t.getName()+"]"+namespace+" "+message+System.lineSeparator();
	      
	    it.add(s);
	       
	}
	public void closeLog() throws IOException {
		FileOutputStream fout = new FileOutputStream(properties.getProperty("info.file_location"), true);
		
		for(int i=0; i<msgList.size(); i++) {
			byte b[]=this.msgList.get(i).getBytes();//converting string into byte array
			fout.write(b);
		}
		fout.close();
		this.msgList.removeAll(msgList);
	}

	@Override
	public void debug(String message) {
		if(super.getPriority()<=DEBUG)
			this.toFile(message, "DEBUG");
	}

	@Override
	public void info(String message) {
		if(super.getPriority()<=INFO)
			this.toFile(message, "INFO ");
	}

	@Override
	public void warn(String message) {
		if(super.getPriority()<=WARN)
			this.toFile(message, "WARN ");
	}

	@Override
	public void error(String message) {
		if(super.getPriority()<=ERROR)
			this.toFile(message, "ERROR");
	}

	@Override
	public void fatal(String message) {
		if(super.getPriority()<=FATAL)
			this.toFile(message, "FATAL");
	}
}
