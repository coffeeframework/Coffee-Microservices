package com.coffee.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * For executing calls in the console
 * 
 * @author Angela Villota
 * @version coffee V1 January 2019
 */

@Component
public class CmdExecutor {
	private static final String EXECUTION_PATH = "COFFEE_EXECUTION_PATH";
	private boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	public String directory;
	private ProcessBuilder processBuilder;

	private String debugLog;

	public String getDebugLog() {
		return debugLog;
	}

	public void initialize(String executionPath) {
		debugLog = "";
		debugLog += "initialize:" + executionPath + "\n";
		processBuilder = new ProcessBuilder();
		File f = new File(executionPath);
		processBuilder.directory(f);
	}

	public void setCommandInConsole(List<String> params) {
		if (isWindows) {
			params.add(0, "cmd.exe");
			params.add(1, "/c");
		} else {
			params.add(0, "sh");
			params.add(1, "-c");
		}
		debugLog += "setCommandInConsole:" + params + "\n";
		processBuilder.command(params);
	}

	public void addCmd(List<String> params) {
		processBuilder.command(params);
		debugLog += "addCmd:" + params + "\n";
	}

	public int runCmd() throws InterruptedException, IOException {
		Process process = processBuilder.start();

		int exitCode = process.waitFor();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		String line;
		String inputStr = "";
		String errStr = "";
		while ((line = stdInput.readLine()) != null) {
			inputStr += line + "\n";
		}
		while ((line = stdError.readLine()) != null) {
			errStr += line + "\n";
		}

		debugLog += "*** Command Input ***\n" + inputStr;
		debugLog += "*** Command Error Output ***\n" + errStr;

		// assert exitCode == 0;
		return exitCode;
	}

}
