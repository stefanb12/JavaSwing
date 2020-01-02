package view;

import contoller.PredmetiController;
import contoller.ProfesoriContoller;
import model.BazaPredmeta;
import model.BazaProfesora;

public class MainApp {

	public static void main(String[] args) {
		MainFrame.getInstance();
		
		BazaPredmeta.getInstance();
		PredmetiController.getInstance();
		
		BazaProfesora.getInstance();
		ProfesoriContoller.getInstance();
	}

}
