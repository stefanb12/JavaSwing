package view;

import contoller.PredmetiController;
import contoller.ProfesoriContoller;
import contoller.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class MainApp {

	public static void main(String[] args) {
		MainFrame.getInstance();
		
		BazaPredmeta.getInstance();
		PredmetiController.getInstance();
		
		BazaProfesora.getInstance();
		ProfesoriContoller.getInstance();
		
		BazaStudenata.getInstance();
		StudentiController.getInstance();
	}

}
