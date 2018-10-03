package hwk6;


import hwk6.Map;
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

public class ChipController extends Application{
	private int scale = 24;
	private Chip chip;
	private ImageView chipImageView;
	private Image chipDownImage;
	private Image chipUpImage;
	private Image chipRightImage;
	private Image chipLeftImage;

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane rootNode = new AnchorPane();

		Scene scene = new Scene(rootNode,600,600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chip's Challenge");
		
		
		//create and 
		Map map = new Map();
		map.drawMap();
		int dimension = map.getDimension();
		
		//add blank tiles
		Image blankTileImage = new Image("BlankTile.png",25,25,true,true);
		Image wallImage = new Image("wall.png",25,25,true,true);
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				ImageView tileImageView;
				switch(map.getValue(i,j)) {
					case 0:
						tileImageView = new ImageView(blankTileImage);
					break;
					
					case 1:
						tileImageView = new ImageView(wallImage);
					break;
					
					default:
						tileImageView = new ImageView(blankTileImage);
				}
				tileImageView.setX(i * scale);
				tileImageView.setY(j * scale);
				rootNode.getChildren().add(tileImageView);
			}
		}
		
		//instantiate chip character
		chip = new Chip(map);
		
		//load chip images
		chipDownImage = new Image("chipDown.png",25,25,true,true);
		chipUpImage = new Image("chipUp.png",25,25,true,true);
		chipLeftImage = new Image("chipLeft.png",25,25,true,true);
		chipRightImage = new Image("chipRight.png",25,25,true,true);
		
		
		chipImageView = new ImageView(chipDownImage);
		chipImageView.setX(chip.getLocation().x * scale);
		chipImageView.setY(chip.getLocation().y * scale);
		rootNode.getChildren().add(chipImageView);

		
		primaryStage.show();
		readInput(scene,map);
	}
	
	private void readInput(Scene scene,Map map){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						chip.goEast();
						chipImageView.setImage(chipRightImage);
						break;
					case LEFT:
						chip.goWest();
						chipImageView.setImage(chipLeftImage);
						break;
					case UP:
						chip.goNorth();
						chipImageView.setImage(chipUpImage);
						break;
					case DOWN:
						chip.goSouth();
						chipImageView.setImage(chipDownImage);
						break;
					default:
						break;
				} 
				
				chipImageView.setX(chip.getLocation().x*scale);
				chipImageView.setY(chip.getLocation().y*scale);
				
			}
		});
	}
}
