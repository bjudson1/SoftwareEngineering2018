package application.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * 
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle {
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private boolean direction;

	public Train(int x, int y, boolean directionIn) {
		this.currentX = x;
		this.currentY = y;
		originalX = x;

		direction = directionIn;
		if (direction) {
			img = new Image("TrainReverse.png", 120, trainLength, false, false);
		} else {
			System.out.println(direction);
			img = new Image("Train.PNG", 120, trainLength, false, false);
		}

		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);

	}

	public double getVehicleX() {
		return currentX;
	}

	public double getVehicleY() {
		return currentY;
	}

	public void move() {
		if (direction == true) {
			currentX += 2;
			imgView.setX(currentX);
		} else {
			currentX -= 2;
			imgView.setX(currentX);
		}

		setChanged();
		notifyObservers();
	}

	public boolean offScreen() {
		if (currentX < -200)
			return true;
		else if (currentX > 1400)
			return true;
		else
			return false;
	}

	public void reset() {
		currentX = originalX;
	}

	// @Override
	public Node getImageView() {
		return imgView;
	}

	public boolean getDirection() {
		return direction;
	}
}