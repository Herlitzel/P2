package ludo.square;

import ludo.Token;

public class InvalidSquare implements ISquare {

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void enter(Token enterToken) {

    }

    @Override
    public ISquare getNextSquare(Token token) {
        return this;
    }

    @Override
    public void setNextSquare(ISquare nextSquare) {

    }

    @Override
    public void leave(Token token) {

    }

    @Override
    public void setCouloirEnter(CouloirSquare square) {

    }

    @Override
    public Token getToken() {
        return null;
    }
}
