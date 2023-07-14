package principal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static JFrame frame;
	
	private Thread thread;
	private boolean isRunner;
	
	private final int ALTURA = 120;
	private final int LARGURA = 160;
	private final int ESCALA = 3;
	
	private BufferedImage image;
	
	public Game() {
		this.setPreferredSize(new Dimension(LARGURA*ESCALA, ALTURA*ESCALA));
		frame = new JFrame("Meu Primeiro Jogo em Java");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		image = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_RGB);
		
	}
	
	public static void main(String[] args) {
		
		Game g = new Game();
		g.start();
		

	}
	
	// Iniciando o jogo com esse metodo
	public synchronized void start(){
		
	    thread = new Thread(this);
	    thread.start();
	    isRunner = true;
	    
	}
	// stop função muito importante
	public synchronized void stop(){

		
		
	}
	// tick função muito importante
	public void tick() {
		
		
	}
	
	public void render(){
		
		// Utilizando BufferStrategy para otimizar a 
		// renderização do jogo para rodar mais rapido.
		BufferStrategy bs = this.getBufferStrategy();
	    if(bs == null){
	        this.createBufferStrategy(3);
	        return;
	    }
	    Graphics g = image.getGraphics();

	    g.setColor(new Color(255, 255, 255));
	    g.fillRect(0, 0, LARGURA, ALTURA);
	    
	    // Adicionando um texto na tela com a cor preta
	    g.setFont(new Font("Arial", Font.BOLD, 10));
	    g.setColor(new Color(0, 0, 0));
	    g.drawString("Meu nome é João Paulo", 0, 50);

	    // Desenhando na tela
	    g = bs.getDrawGraphics();
	    g.drawImage(image, 0, 0, LARGURA*ESCALA, ALTURA*ESCALA, null);
	    bs.show();
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
