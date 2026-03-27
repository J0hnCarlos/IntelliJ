package control;

import robot.Robot;
import robot.RobotMovement;

//Robot Assignment for Programming 1 s2 2019
//Adapted by Caspar and Ross from original Robot code written by Dr Charles Thevathayan
public class RobotControl implements Control {
    // we need to internally track where the arm is
    private int height = Control.INITIAL_HEIGHT;
    private int width = Control.INITIAL_WIDTH;
    private int depth = Control.INITIAL_DEPTH;

    private int[] barHeights;
    private int[] blockHeights;

    private Robot robot;

    int x = 2; //bar x
    int barNumber = 0;
    int t = 1;
    int n = 1;
    int change = 1;
    int inverted = 7;

    int lefty, righty = 0;


    // called by RobotImpl
    @Override
    public void control(Robot robot, int barHeightsDefault[], int blockHeightsDefault[]) {
        this.robot = robot;

        // some hard coded init values you can change these for testing
        this.barHeights = new int[]{3, 4, 1, 5, 2, 3, 2, 6};
        this.blockHeights = new int[]{3, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 2, 3};
        int blockNumber = blockHeights.length;

        // FOR SUBMISSION: uncomment following 2 lines
        //	this.barHeights = barHeightsDefault;
        //	this.blockHeights = blockHeightsDefault;

        // initialise the robot
        robot.init(this.barHeights, this.blockHeights, height, width, depth);

        while (x <= LAST_BAR_COLUMN) {
            moveUp();
            contractToWidth(Control.MIN_WIDTH);
            moveDown(lefty);
            robot.pick();
            moveUp();
            moveToPosition(x);
            dropBlockLeft();
            moveUp();
            extendToWidth(Control.MAX_WIDTH);
            moveDown(righty);
            robot.pick();
            moveUp();
            moveToPosition(x);
            dropBlockRight();
        }

        x--;
        change = -1;

        while (x >= MIN_BARS + 2){
            moveUp();
            contractToWidth(Control.MIN_WIDTH);
            moveDown(lefty);
            robot.pick();
            moveUp();
            moveToPosition(x);
            dropBlockLeftInvert();
            moveUp();
            extendToWidth(Control.MAX_WIDTH);
            moveDown(righty);
            robot.pick();
            moveUp();
            moveToPosition(x);
            dropBlockRightInvert();
        }

        moveUp();
        contractToWidth(Control.MIN_WIDTH);

        //	while (depth > MIN_DEPTH)
        //	robot.raise();
        // a simple private method to demonstrate how to control robot
        // note use of constant from Control interface
        // You should remove this method call once you start writing your code


        // ADD ASSIGNMENT PART A METHOD CALL(S) HERE

    }

    // simple example method to help get you started
    private void extendToWidth(int width) {
        while (this.width < width) {
            robot.extend();
            this.width++;
        }
    }

    private void contractToWidth(int width) {
        while (this.width > width) {
            robot.contract();
            this.width--;
        }
    }

    private void moveDown(int depth) {
        while (this.depth < depth) {
            robot.lower();
            this.depth++;
        }
    }

    private void moveUp() {
        while (depth > MIN_DEPTH) {
            robot.raise();
            depth--;
        }
    }

    private void moveToPosition(int width) {

        while (this.width > width) {
            robot.contract();
            this.width--;
        }

        x += change;

        while (this.width < width) {
            robot.extend();
            this.width++;
        }
    }

    private void dropBlockLeft() {
        while (depth < MAX_DEPTH - barHeights[barNumber] - blockHeights[blockHeights.length - 2 * t]) {
            robot.lower();
            depth++;
        }
        lefty = lefty + blockHeights[blockHeights.length - 2 * t];
        robot.drop();
        barNumber += change;
        t++;
    }

    private void dropBlockRight() {
        while (depth < MAX_DEPTH - barHeights[barNumber] - blockHeights[blockHeights.length - n]) {
            robot.lower();
            depth++;
        }
        righty = righty + blockHeights[blockHeights.length - n];
        robot.drop();
        barNumber += change;
        n = n + 2;
    }

    private void dropBlockLeftInvert(){
        while (depth < MAX_DEPTH - barHeights[inverted] - blockHeights[blockHeights.length - 2 * t] - blockHeights[inverted]) {
            robot.lower();
            depth++;
        }
        lefty = lefty + blockHeights[blockHeights.length - 2 * t];
        robot.drop();
        barNumber += change;
        t += change;
        inverted--;
    }

    private void dropBlockRightInvert(){
        while (depth < MAX_DEPTH - barHeights[inverted] - blockHeights[blockHeights.length - n] - blockHeights[inverted]) {
            robot.lower();
            depth++;
        }
        righty = righty + blockHeights[blockHeights.length - n];
        robot.drop();
        barNumber += change;
        n = n + 2;
        inverted--;
        t += change;
    }
}