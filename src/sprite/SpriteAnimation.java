package sprite;

public class SpriteAnimation {
	/*
	 * Specific methods for Sprite movement animation
	 */
	
	private MovingSprite sprite;
	
	private String[] animationImages;
	private boolean imgSwitch = false; // boolean to change image into gif-like behaviour
	
	public SpriteAnimation(MovingSprite sprite, String[] animationImages) {
		this.sprite = sprite;
		this.animationImages = animationImages;
	}
	
	public void animate() {
		/* Loop over the images, setting different images when having moved a particular distance
		 * 
		 * String[] animationImages should be set up as follows:
		 * 		0: moveLeft,
		 * 		1: staticLeft,
		 * 		2: moveRight,
		 * 		3: staticRight,
		 * 		4: staticDown,
		 * 		5: moveDown1,
		 * 		6: moveDown2,
		 * 		7: staticUp,
		 * 		8: moveUp1,
		 * 		9: moveUp2
		 */
		
		if (sprite.goLeft()) {
			loopImages(animationImages[0], animationImages[1]);
		} else if (sprite.goRight()) {
			loopImages(animationImages[2], animationImages[3]);
		} else if (sprite.goDown()) {
			loopImages(animationImages[5], animationImages[6]);
		} else if (sprite.goUp()) {
			loopImages(animationImages[8], animationImages[9]);	
		}

	}
	
	public void resetAnimation() {
		// set image to static left/right/down/up image
		if (sprite.stoppedLeft()) {
			sprite.setImage(animationImages[1]);
		} else if (sprite.stoppedRight()) {
			sprite.setImage(animationImages[3]);
		} else if (sprite.stoppedDown()) {
			sprite.setImage(animationImages[4]);
		} else if (sprite.stoppedUp()) {
			sprite.setImage(animationImages[7]);	
		}
	}
	
	private void loopImages(String first, String second) {
		// changes which image is painted
		if (!switchImage()) {
			sprite.setImage(first);
			setImgSwitch(true);
		} else {
			sprite.setImage(second);
			setImgSwitch(false);
		}
	}
	
	public boolean switchImage() { return this.imgSwitch; }
	public void setImgSwitch(boolean s) { this.imgSwitch = s; }
	
}
