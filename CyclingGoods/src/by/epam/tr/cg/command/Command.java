package by.epam.tr.cg.command;

import by.epam.tr.cg.bean.Request;
import by.epam.tr.cg.bean.Response;

public interface Command {
	Response execute(Request request);
}
