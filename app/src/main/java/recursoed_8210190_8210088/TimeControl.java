package recursoed_8210190_8210088;

public class TimeControl {
    private long time;
    private Player player;

    public TimeControl(Player player, long time) {
        this.player = player;
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
}
