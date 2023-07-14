package principal;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static JFrame frame;
	
	private final int ALTURA = 120;
	private final int LARGURA = 160;
	private final int ESCALA = 3;
	
	public Game() {
		this.setPreferredSize(new Dimension(LARGURA*ESCALA, ALTURA*ESCALA));
		frame = new JFrame("Meu Primeiro Jogo em Java");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Game g = new Game();
		

	}

	@Override
	public void run() {
		
		
	}

}
