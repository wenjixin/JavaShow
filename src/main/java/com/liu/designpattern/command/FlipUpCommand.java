package com.liu.designpattern.command;

public class FlipUpCommand implements Command {
	private Light theLight;

	public FlipUpCommand(Light light) {
		theLight = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLight.turnOn();
	}

}
