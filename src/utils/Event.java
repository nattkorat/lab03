package utils;

public class Event {
    private Time time;
    private char code;
    private int numOfPeople;

    public Event(Time time, char code, int numOfPeople) {
        this.time = time;
        this.code = code;
        this.numOfPeople = numOfPeople;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String geString() {
        return String.format(
                "- at %s, %d %s arrived at the bus stop",
                this.time.geString(),
                this.numOfPeople,
                (this.code == 'b') ? "available seats bus" : "people");
    }

}
