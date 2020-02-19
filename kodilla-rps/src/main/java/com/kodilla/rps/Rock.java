package com.kodilla.rps;

public class Rock implements Move{

    @Override
    public String name() {
        return "rock";
    }

    @Override
    public RoundResult winsWith(Move otherPlayer) {
        if (otherPlayer instanceof Scissors){
            return new RoundResult(true, false);
        } else if (otherPlayer instanceof Paper){
            return new RoundResult(false, false);
        } else if (otherPlayer instanceof Spock){
            return new RoundResult(false, false);
        } else if (otherPlayer instanceof Lizard){
            return new RoundResult(true, false);
        } else {
            return new RoundResult(false, true);
        }
    }
}
