package player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayAdapter extends KeyAdapter {
	
	private Player player;
	public static int speed = 2;
	
	public PlayAdapter(Player player) {
		this.player = player;
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	
    	int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			player.setMoveBoolean("left");
	        player.setDirX(speed);
	        player.setDirY(0);
	    } else if (key == KeyEvent.VK_RIGHT) {
	    	player.setMoveBoolean("right");
	        player.setDirX(-speed);
	        player.setDirY(0);
	    } else if (key == KeyEvent.VK_UP) {
	    	player.setMoveBoolean("up");
	    	player.setDirX(0);
	        player.setDirY(speed);
	    } else if (key == KeyEvent.VK_DOWN) {
	    	player.setMoveBoolean("down");
	    	player.setDirX(0);
	        player.setDirY(-speed);
	    } else if (key == KeyEvent.VK_A) {
	    	player.isReading(true);
	    }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    	
    	int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	player.setStopBoolean("stopLeft");
        	player.setDirX(0);
	        player.setDirY(0);
        } else if (key == KeyEvent.VK_RIGHT) {
        	player.setStopBoolean("stopRight");
        	player.setDirX(0);
	        player.setDirY(0);
        } else if (key == KeyEvent.VK_UP) {
        	player.setStopBoolean("stopUp");
        	player.setDirX(0);
	        player.setDirY(0);
        } else if (key == KeyEvent.VK_DOWN) {
        	player.setStopBoolean("stopDown");
        	player.setDirX(0);
	        player.setDirY(0);
        }
    }
}