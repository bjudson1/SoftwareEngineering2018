package hwk6;

import java.awt.Point;

public interface LevelStrategy {
	public void buildLevel();
	public int getTile(int i,int j);
	public Point getChipStart();
	public int getChipsCount();
	public Point getBugStart();
}
