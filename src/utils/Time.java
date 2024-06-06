package utils;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    private int getTotalInSecond() {
        return this.hour * 3600 + this.minute * 60 + second;
    }

    public String geString() {
        String hour = (this.hour < 10) ? "0" + this.hour : "" + this.hour;
        String minute = (this.minute < 10) ? "0" + this.minute : "" + this.minute;
        String second = (this.second < 10) ? "0" + this.second : "" + this.second;
        return String.format("(%s:%s:%s)", hour, minute, second);
    }

    public int getTimeDiffInSecond(Time oldTime) {
        int oldSecond = oldTime.getTotalInSecond();
        return Math.abs(this.getTotalInSecond() - oldSecond);
    }
}
