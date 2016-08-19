package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class BotKeyAdapter {
	/*
	 * Robot key adapter that simulates Player key presses
	 */
	
	private Robot robot;
	private int key;
	
	public BotKeyAdapter() throws AWTException {
		robot = new Robot();
	}
	
	public void keyPress() {
		robot.keyPress(key);
		System.out.println(KeyEvent.getKeyText(key) + " pressed.");
	}
	
	public void keyRelease() {
		robot.keyRelease(key);
		System.out.println(KeyEvent.getKeyText(key) + " released.");
	}
	
	// robot movement
	public void moveInDirection(String dir) {
		switch (dir) {
			case "left": left(); break;
			case "right": right(); break;
			case "up": up(); break;
			case "down": down(); break;
		}
	}
	
	public void left() {
		key = KeyEvent.VK_LEFT;
		keyPress();
	}
	
	public void right() {
		key = KeyEvent.VK_RIGHT;
		keyPress();
	}
	
	public void down() {
		key = KeyEvent.VK_DOWN;
		keyPress();
	}
	
	public void up() {
		key = KeyEvent.VK_UP;
		keyPress();
	}
	
	// robot interaction
	public void read() {
		key = KeyEvent.VK_A;
		keyPress();
		// press key only once
		keyRelease();
	}

}
