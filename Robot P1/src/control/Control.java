package control;

import robot.Robot;

//Control interface by Caspar and Ross (used internally by Robot)
//do not modify this code!
public interface Control
{
	public static final int MIN_HEIGHT = 2;
	public static final int MIN_WIDTH = 1;
	public static final int MIN_DEPTH = 0;
	
	public static final int MAX_HEIGHT = 13;
	public static final int MAX_WIDTH = 10;
	public static final int MAX_DEPTH = MAX_HEIGHT - 1;
	
	public static final int MIN_BARS = 0;
	public static final int MAX_BARS = 8;
	public static final int MIN_BAR_HEIGHT = 1;
	public static final int MAX_BAR_HEIGHT = 6;

	public static final int MIN_BLOCKS = 1;
	public static final int MIN_BLOCK_HEIGHT = 1;
	public static final int MAX_BLOCK_HEIGHT = 3;
	public static final int MAX_SRC_STACK_HEIGHT = 12;
	public static final int MAX_TOTAL_BLOCK_HEIGHT = 24;
	public static final int MAX_BLOCKS = MAX_TOTAL_BLOCK_HEIGHT / MIN_BLOCK_HEIGHT;
	
	public static final int ARM_COLUMN = 0;
	public static final int SRC_COLUMN = -1; // currently unused	
	public static final int SRC1_COLUMN = 1;
	public static final int SRC2_COLUMN = MAX_WIDTH;
	public static final int FIRST_BAR_COLUMN = 2;
	public static final int LAST_BAR_COLUMN = MAX_WIDTH-1;
	
	public static final int INITIAL_HEIGHT = MAX_HEIGHT;
	public static final int INITIAL_WIDTH = 1;
	public static final int INITIAL_DEPTH = 0;
	
	public void control(Robot robot, int barHeights[], int blockHeights[]);
}
