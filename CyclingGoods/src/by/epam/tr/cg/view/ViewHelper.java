package by.epam.tr.cg.view;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.cg.entity.Product;
import by.epam.tr.cg.entity.ReportLine;

public class ViewHelper {
	
	private final static Logger rootLogger = LogManager.getRootLogger();
	
	private ViewHelper(){}
	
	public static void printProductsList(List<Product> list){
		for(Product p:list){
			rootLogger.info(p.toString());
		}
	}
	public static void printReport(List<ReportLine> list){
		for(ReportLine rl:list){
			rootLogger.info(rl.toString());
		}
	}
}
