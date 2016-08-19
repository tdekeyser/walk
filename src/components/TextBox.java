package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import core.Game;
import core.Settings;

public class TextBox {
	
	private final int BOX_WIDTH = Settings.DIMENSION_X * 19/20;
	private final int BOX_HEIGHT = Settings.DIMENSION_Y * 1/3;
	private int x = (Settings.DIMENSION_X - BOX_WIDTH) / 2; // position at bottom of screen
	private int y = (Settings.DIMENSION_Y - BOX_HEIGHT) - ((Settings.DIMENSION_Y - BOX_HEIGHT) / 10);
	
	private String text;
	private int partI = 0;
	private String part = "";
	
	private boolean ready = false;
	
	public TextBox(String text) {
		setText(text);
	}
	
	public void update() {
		// simulate loop over the text
		if (Game.LOOP_KEEP % 2 == 0) {
			simulateTextLoop();
		}
	}
	
	public void render(Graphics2D g) {
		Font f = new Font("Courier New", 1, 25);
		g.setFont(f);
		
		// draw rectangle
		g.setColor(Color.WHITE);
		g.fillRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		
		// draw text
		g.setColor(Color.BLACK);
		g.drawRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		
		drawString(g, part, Settings.DIMENSION_X/8, y + 1*BOX_HEIGHT/3);
	}
	
	public void drawString(Graphics2D g, String text, int x, int y) {
		for (String line : text.split("/")) {
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}
	}
	
	public void simulateTextLoop() {
		// iterate over the text character per character
		if (partI < text.length()) {
			part += text.charAt(partI);
			partI++;
		} else {
			partI = 0;
			ready = true;
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isReady() {
		return ready;
	}
	
}
