package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;

public class Connector extends Local{
    private int cooldown;
    private LinkedList<TimeControl> timeControl;
    private boolean mine;

    public Connector(int id, double longitude, double latitude, double energy, int cooldown) {
        super(id, longitude, latitude, energy);
        this.cooldown = cooldown;
        this.timeControl = new LinkedList<TimeControl>();
        this.mine = false;
    }

    public int getCooldownn() {
        return cooldown;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public LinkedList<TimeControl> getTimeControl() {
        return timeControl;
    }

    public void addTimeControl(TimeControl timeControl) {
        this.timeControl.add(timeControl);
    }
    
    public void loadPlayerEnergy(Player player) {
        LinearNode<TimeControl> node = this.timeControl.getHead();
        while(node != null && player.equals(node.getElement().getPlayer())) {
            node = node.getNext();
        }
        if(node == null){
            timeControl.add(new TimeControl(player, System.currentTimeMillis()));
            player.loadEnergy(this.getEnergy());
        }else{
            int diff = (int) ((System.currentTimeMillis() - node.getElement().getTime()) / 60000);
            if(diff >= this.cooldown){
                player.loadEnergy(this.getEnergy());
                node.getElement().setTime(System.currentTimeMillis());
            }else{
                System.out.println("You can't load energy yet");
            }
        }
    }
}
