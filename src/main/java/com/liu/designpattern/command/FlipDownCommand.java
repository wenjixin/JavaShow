package com.liu.designpattern.command;

public class FlipDownCommand implements Command {
	private Light theLight;

	public FlipDownCommand(Light light) {
		theLight = light;
	}

	@Override
	public void execute() {
		theLight.turnOff();
	}

}
