package br.edu.infnet.appvenda;

import java.io.IOException;
import java.util.logging.*;

public class FileLogger {
	private static final Logger logger = Logger.getLogger(FileLogger.class.getName());

	private static void initializeLogger(String logFileName) throws IOException {
		FileHandler fileHandler = new FileHandler(logFileName);
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
	}

	public static void logException(String mensagem) throws IOException {
		initializeLogger("files/log.txt");
		logger.log(Level.SEVERE, mensagem);
	}
}
