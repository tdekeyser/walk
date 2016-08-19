package core;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private int width;
	private int height;
	private String title;
	
	public GameWindow(int width, int height, String title) {
		
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	public void setupFrame() {
		
		this.setTitle(title);
		this.setSize(width,height);	
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
