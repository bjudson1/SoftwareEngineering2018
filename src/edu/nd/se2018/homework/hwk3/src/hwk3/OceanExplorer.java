package hwk3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	private ImageView shipImageView;
	private ImageView pirateShipImageView1;
	private ImageView pirateShipImageView2;
	private int scale = 23;
	private Ship columbusShip;
	private PirateShip pShip1;
	private PirateShip pShip2;
	
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		AnchorPane rootNode = new AnchorPane();
		
		Scene scene = new Scene(rootNode,600,600);
		
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean Game");
		
		//create and draw map
		OceanMap oceanMap = new OceanMap();
		oceanMap.addIslands();
		oceanMap.drawMap(rootNode.getChildren(), scale);
		
		//create CC ship at random location
		columbusShip = new Ship(oceanMap);
		columbusShip.setLocation((int)(Math.random() * 25),(int)(Math.random() * 25));
		
		//load ship image and add to map
		Image ccShipImage = new Image("ship.png",25,25,true,true);
		shipImageView = new ImageView(ccShipImage);
		shipImageView.setX(columbusShip.getLocation().x * scale);
		shipImageView.setY(columbusShip.getLocation().y * scale);
		rootNode.getChildren().add(shipImageView);
		
		//create pirate ship at random location
		pShip1 = new PirateShip(oceanMap,columbusShip);
		pShip1.setLocation((int)(Math.random() * 25),(int)(Math.random() * 25));
		
		//load ship image and add to map
		Image pirateShipImage = new Image("pirateship.gif",25,25,true,true);
		pirateShipImageView1 = new ImageView(pirateShipImage);
		pirateShipImageView1.setX(pShip1.getLocation().x * scale);
		pirateShipImageView1.setY(pShip1.getLocation().y * scale);
		rootNode.getChildren().add(pirateShipImageView1);
		
		pShip2 = new PirateShip(oceanMap,columbusShip);
		pShip2.setLocation((int)(Math.random() * 25),(int)(Math.random() * 25));
		
		//load ship image and add to map
		pirateShipImageView2 = new ImageView(pirateShipImage);
		pirateShipImageView2.setX(pShip2.getLocation().x * scale);
		pirateShipImageView2.setY(pShip2.getLocation().y * scale);
		rootNode.getChildren().add(pirateShipImageView2);
		
		oceanStage.show();
		startSailing(scene,oceanMap,columbusShip,pShip1,pShip2);
	}
	
	private void startSailing(Scene scene,OceanMap oceanMap,Ship ship,PirateShip pship1,PirateShip pShip2){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				} 
				
				shipImageView.setX(ship.getLocation().x*scale);
				shipImageView.setY(ship.getLocation().y*scale);
				
				pirateShipImageView1.setX(pship1.getLocation().x*scale);
				pirateShipImageView1.setY(pship1.getLocation().y*scale);
				
				pirateShipImageView2.setX(pShip2.getLocation().x*scale);
				pirateShipImageView2.setY(pShip2.getLocation().y*scale);
			}
		});
	}


}
