package model;

import model.interfaces.Die;

import java.util.Random;

public class DieImpl implements Die {

    private int diceNum, value;
    private String textNumber;
    private int numFaces;
    private boolean check = false;

    // constructor
    public DieImpl(int number, int value, int numFaces) throws IllegalArgumentException{
        this.diceNum = number;
        this.value = value;
        this.numFaces = numFaces;
    }

    // returns random number
    public int getDieNumber(){
        Random math = new Random();
        return math.nextInt((numFaces - 1) + 1) + 1;
    }

    // return die id
    @Override
    public int getNumber() {
        return diceNum;
    }

    // return die number
    @Override
    public int getValue() {
        return value;
    }

    //return highest number from die
    @Override
    public int getNumFaces() {
        return numFaces;
    }

    @Override
    public boolean equals(Die die) {
        if (die.getValue() == value && die.getNumFaces() == NUM_FACES) {
            check =  true;
        } else {
            check = false;
        }
        return check;
    }

    @Override
    public boolean equals(Object die) {
        DieImpl dice = (DieImpl) die;
        return equals(dice);
    }

    // return hash number
    public int hashCode() {
        Integer valueNumber = value;
        Integer dieNumFaces = NUM_FACES;
        return valueNumber.hashCode() + dieNumFaces.hashCode();
    }

    // return message
    @Override
    public String toString() {
        textNumber = textNum(value);
        return textNumber;
    }

    // change number to text
    private String textNum(int number){
        String text = "";
        switch(number){
            case 1:
                text = "One";
                break;
            case 2:
                text = "Two";
                break;
            case 3:
                text = "Three";
                break;
            case 4:
                text = "Four";
                break;
            case 5:
                text = "Five";
                break;
            case 6:
                text = "Six";
                break;
            case 7:
                text = "Seven";
                break;
            case 8:
                text = "Eight";
                break;
            case 9:
                text = "Nine";
                break;
            default:
                text = "> Nine";
                break;
        }
        return text;
    }
}
