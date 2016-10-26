package by.epam.tr.cg.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.tr.cg.command.Command;
import by.epam.tr.cg.command.CommandName;
import by.epam.tr.cg.command.impl.AddProduct;
import by.epam.tr.cg.command.impl.DeleteProduct;
import by.epam.tr.cg.command.impl.ShowAllProducts;
import by.epam.tr.cg.command.impl.ShowProductsByCategory;
import by.epam.tr.cg.command.impl.ShowReport;
import by.epam.tr.cg.command.impl.UpdateProduct;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	CommandProvider() {// в public-классе единственный friendly конструктор - зачем?
		commands.put(CommandName.ADD_PRODUCT, new AddProduct());
		commands.put(CommandName.DELETE_PRODUCT_BY_ID, new DeleteProduct());
		commands.put(CommandName.UPDATE_PRODUCT_BY_ID, new UpdateProduct());
		commands.put(CommandName.SHOW_ALL_PRODUCTS, new ShowAllProducts());
		commands.put(CommandName.SHOW_PRODUCTS_BY_CATEGORY, new ShowProductsByCategory());
		commands.put(CommandName.SHOW_COUNT_MIN_MAX_PRICE_FOR_CATEGORY, new ShowReport());
	}

	public Command getCommand(CommandName commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}
}
