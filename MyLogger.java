package com.suyog.loglib;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MyLogger{
	public void debug(String message);
	public void info(String message);
	public void warn(String message);
	public void error(String message);
	public void fatal(String message);
	public void closeLog() throws FileNotFoundException, IOException;
	public void setNamespace(String ns);
	public String getNamespace() ;
	public static final int DEFAULT = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int FATAL = 7;
}
