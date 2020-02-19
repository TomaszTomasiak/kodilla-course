package com.kodilla.rps;

public class Paper implements Move {
    @Override
    public String name() {
        return "paper";
    }

    @Override
    public RoundResult winsWith(Move otherPlayer) {
        if (otherPlayer instanceof Scissors){
            return new RoundResult(false, false);
        } else if (otherPlayer instanceof Rock){
            return new RoundResult(true, false);
        } else if (otherPlayer instanceof Spock){
            return new RoundResult(true, false);
        } else if (otherPlayer instanceof Lizard){
            return new RoundResult(false, false);
        } else {
            return new RoundResult(false, true);
        }
    }
}
