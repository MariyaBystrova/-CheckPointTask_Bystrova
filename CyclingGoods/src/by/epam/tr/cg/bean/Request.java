package by.epam.tr.cg.bean;

import by.epam.tr.cg.command.CommandName;

public class Request {
	private CommandName commandName;

	public CommandName getCommandName() {
		return commandName;
	}

	public void setCommandName(CommandName commandName) {
		this.commandName = commandName;
	}
}
