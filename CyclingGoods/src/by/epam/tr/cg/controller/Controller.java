package by.epam.tr.cg.controller;

import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;
import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.command.CommandName;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public Response doAction(Request request) {
		CommandName commandName = request.getCommandName();

		Command command = provider.getCommand(commandName);

		Response response = command.execute(request);

		return response;

	}
}
