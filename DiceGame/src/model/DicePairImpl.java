package model;

import model.interfaces.DicePair;
import model.interfaces.Die;

import java.util.Random;

public class DicePairImpl implements DicePair {

    //Give die random starting number
    private DieImpl number = new DieImpl(1, 2, 6);

    private DieImpl die1, die2;
    private int a, b;

    Random math = new Random();

    //Place holder for the text version of number
    private String textDie1, textDie2;

    public DicePairImpl() {
        die1 = new DieImpl(1, math.nextInt((Die.NUM_FACES - 1) + 1) + 1, Die.NUM_FACES);
        die2 = new DieImpl(2, math.nextInt((Die.NUM_FACES - 1) + 1) + 1, Die.NUM_FACES);
    }

    @Override
    public Die getDie1() {
        a = die1.getValue();
        textDie1 = textNum(a);
        return die1;
    }

    @Override
    public Die getDie2() {
        b = die2.getValue();
        textDie2 = textNum(b);
        return die2;
    }

    @Override
    public int getTotal() {
        return die1.getValue() + die2.getValue();
    }

    @Override
    public boolean equals(DicePair dicePair) {
        if (die1.getValue() == dicePair.getDie1().getValue() && die2.getValue() == dicePair.getDie2().getValue()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object dicePair) {
        DicePairImpl dicePair1 = (DicePairImpl) dicePair;
        return equals(dicePair1);
    }

    public int hashCode() {
        Integer dieNumber1 = die1.getValue();
        Integer dieNumber2 = die2.getValue();
        return dieNumber1.hashCode() + dieNumber2.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Dice %s" + ": %s, Dice %s" +": %s .. Total: %d",
                die1.getNumber(), die1.toString(), die2.getNumber(), die2.toString(), getTotal());
    }

    @Override
    public int compareTo(DicePair dicePair) {
        Integer firstTotal = getTotal();
        Integer secondTotal = dicePair.getTotal();
        return firstTotal.compareTo(secondTotal);
    }

    //Change number to text
    private String textNum(int number) {
        String text = "";
        switch (number) {
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
