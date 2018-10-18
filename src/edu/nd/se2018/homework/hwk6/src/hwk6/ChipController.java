package hwk6;



import hwk6.Map;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChipController extends Application{
	private int scale = 24;
	private Chip chip;
	private ImageView chipImageView;
	private Image chipDownImage;
	private Image chipUpImage;
	private Image chipRightImage;
	private Image chipLeftImage;
	private LevelStrategy level;
	private AnchorPane rootNode;
	private int curLevel;
	private GraphicsContext gc;
	private Canvas consoleCanvas;
	
	private Image blankTileImage;
	private Image wallImage;
	private Image keyImage;
	private Image doorImage;
	private Image chipItemImage;
	

	public static void main(String[] args){
		launch(args);
	}

	public Map createMap(LevelStrategy level) {
		rootNode.getChildren().clear();
		
		
	
		
		
		//create and build map 
		Map map = new Map();
		map.drawMap(level);
		int dimension = map.getDimension();
		
		//add tile images
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
					
					case 2:
						tileImageView = new ImageView(keyImage);
					break;
					
					case 3:
						tileImageView = new ImageView(doorImage);
					break;
					
					case 4:
						tileImageView = new ImageView(chipItemImage);
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
		chip = new Chip(map,level.getChipStart());
				
		//load chip images
		chipDownImage = new Image("chipDown.png",25,25,true,true);
		chipUpImage = new Image("chipUp.png",25,25,true,true);
		chipLeftImage = new Image("chipLeft.png",25,25,true,true);
		chipRightImage = new Image("chipRight.png",25,25,true,true);
				
		//add chip to map
		chipImageView = new ImageView(chipDownImage);
		chipImageView.setX(chip.getLocation().x * scale);
		chipImageView.setY(chip.getLocation().y * scale);
		rootNode.getChildren().add(chipImageView);
		
		
		//set up side console
		consoleCanvas = new Canvas(800,600);
		gc = consoleCanvas.getGraphicsContext2D();
				 
		gc.setFill(Color.BLUE);
		gc.fillRect(600,0,200,600);
		writeText(20,"Level: " + curLevel,620,50,Color.DARKGRAY);
		writeText(20,"Keys: 0",620,100,Color.DARKGRAY);
		writeText(20,"Chips: 0",620,150,Color.DARKGRAY);
		
		rootNode.getChildren().add(consoleCanvas);
		
		return map;		
	}
	
	
	public void start(Stage primaryStage) throws Exception {
		rootNode = new AnchorPane();

		Scene scene = new Scene(rootNode,800,600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chip's Challenge");
		

		
		//load images once for performance
		blankTileImage = new Image("BlankTile.png",25,25,true,true);
		wallImage = new Image("wall.png",25,25,true,true);
		keyImage = new Image("redKey.png",25,25,true,true);
		doorImage = new Image("redKeyWall.png",25,25,true,true);
		chipItemImage = new Image("chipItem.png",25,25,true,true);
		
		//set level
		level = new Level1();
		level.buildLevel();
		curLevel = 1;
		
		Map map = createMap(level);
		

		
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
					case ESCAPE:
						 System.exit(0);
						break;
					default:
						break;
						
				} 
		
				//if land on key remove and give chip key
				if(map.getValue(chip.getLocation().x,chip.getLocation().y) == 2) {
					Image blankTileImage = new Image("BlankTile.png",25,25,true,true);
						
					ImageView tileImageView = new ImageView(blankTileImage);
					tileImageView.setX(chip.getLocation().x * scale);
					tileImageView.setY(chip.getLocation().y * scale);					
					
					rootNode.getChildren().set((chip.getLocation().x*25)+chip.getLocation().y,tileImageView);
					map.setValue(chip.getLocation().x,chip.getLocation().y,0);
				
					chip.giveKey();
					
					//update console
					gc.setFill(Color.BLUE);
					gc.fillRect(670,75,100,50);
					writeText(20,"Keys: " + chip.getKeys(),620,100,Color.DARKGRAY);
				}
				
				//if open door remove
				else if(map.getValue(chip.getLocation().x,chip.getLocation().y) == 3) {
					Image blankTileImage = new Image("BlankTile.png",25,25,true,true);
						
					ImageView tileImageView = new ImageView(blankTileImage);
					tileImageView.setX(chip.getLocation().x * scale);
					tileImageView.setY(chip.getLocation().y * scale);					
					
					rootNode.getChildren().set((chip.getLocation().x*25)+chip.getLocation().y,tileImageView);
					map.setValue(chip.getLocation().x,chip.getLocation().y,0);
					
					//update console
					gc.setFill(Color.BLUE);
					gc.fillRect(670,75,100,50);
					writeText(20,"Keys: " + chip.getKeys(),620,100,Color.DARKGRAY);
				}
				
				//if collect chip
				else if(map.getValue(chip.getLocation().x,chip.getLocation().y) == 4) {
					Image blankTileImage = new Image("BlankTile.png",25,25,true,true);
						
					ImageView tileImageView = new ImageView(blankTileImage);
					tileImageView.setX(chip.getLocation().x * scale);
					tileImageView.setY(chip.getLocation().y * scale);					
					
					rootNode.getChildren().set((chip.getLocation().x*25)+chip.getLocation().y,tileImageView);
					map.setValue(chip.getLocation().x,chip.getLocation().y,0);
					
					chip.giveChip();
					
					//update console
					gc.setFill(Color.BLUE);
					gc.fillRect(670,125,100,50);
					writeText(20,"Chips: " + chip.getChips(),620,150,Color.DARKGRAY);
					
					//check if won
					if(chip.getChips() == level.getChipsCount()) {
						//if on 1st level go to second
						if(curLevel == 1) {
							level = new Level2();
							level.buildLevel();
							curLevel = 2;
							Map map = createMap(level);
							readInput(scene,map);
						}
						
						//if on 2nd level you won
						else if(curLevel == 2) {
							writeText(40,"You Won!",200,300,Color.RED);
						}
					}
				}
				
				chipImageView.setX(chip.getLocation().x*scale);
				chipImageView.setY(chip.getLocation().y*scale);
				
			}
		});
	}
	
	private void writeText(int fontSize, String text, int x, int y,Color color){
		gc.setFill(color);
		gc.setFont(javafx.scene.text.Font.font("Arial",fontSize));
		gc.fillText(text, x, y);
	}
}
