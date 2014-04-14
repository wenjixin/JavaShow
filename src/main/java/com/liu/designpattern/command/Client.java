package com.liu.designpattern.command;

public class Client {
	public static void main(String[] args) {
		Light light = new Light();
		Command turnOnCommand = new FlipUpCommand(light);
		Command turnOffCommand = new FlipDownCommand(light);
		Switch commandHsitory = new Switch();
		commandHsitory.storeAndExecute(turnOnCommand);
		commandHsitory.storeAndExecute(turnOffCommand);
		System.out.println(commandHsitory.getHistory());
	}
}
