package view;

import contoller.PredmetiController;
import model.BazaPredmeta;

public class MainApp {

	public static void main(String[] args) {
		BazaPredmeta.getInstance();
		PredmetiController.getInstance();
		MainFrame.getInstance();
	}

}
