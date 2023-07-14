package principal;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static JFrame frame;
	
	private Thread thread;
	private boolean isRunner;
	
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
		g.start();
		

	}
	
	public synchronized void start(){
		
	    thread = new Thread(this);
	    thread.start();
	    isRunner = true;
	    
	}
	
	public synchronized void stop(){

		
	}
	
	public void tick() {
		
	}
	
	public void render(){
		
	}
	
	@Override
	public void run() {
		

		long lastTime = System.nanoTime();
		double emountOfTicks = 60.0;
		double ns = 1000000000 / emountOfTicks;
		double delta = 0;
		int frames = 0;
		
		double timer = System.currentTimeMillis();
			while(isRunner){
			    long now = System.nanoTime();
			    delta += (now - lastTime) / ns;
			    lastTime = now;
			    
			    if(delta >= 1){
			        tick();
			        render();
			
			        frames++;
			        delta--;
			    }
		
		    if(System.currentTimeMillis() - timer >= 1000){
		        System.out.println("FPS: "+ frames);
		        frames = 0;
		        timer += 1000;
		    }
		}// Fecha o loop
			
		
	}// Fecha o metodo

	
	
}// Fim da classe Game
