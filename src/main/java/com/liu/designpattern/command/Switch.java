package com.liu.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Switch {
	private List<Command> history = new ArrayList<>();

	public void storeAndExecute(Command command) {
		history.add(command);
		command.execute();
	}

	public List<?> getHistory() {
		return history;
	}
}
