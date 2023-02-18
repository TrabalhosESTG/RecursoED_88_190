package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;

public class Connector extends Local{
    private int cooldownn;
    private LinkedList<TimeControl> timeControl;

    public Connector(int id, double longitude, double latitude, double energy, int cooldownn) {
        super(id, longitude, latitude, energy);
        this.cooldownn = cooldownn;
        this.timeControl = new LinkedList<TimeControl>();
    }

    public int getCooldownn() {
        return cooldownn;
    }

    public void setCooldownn(int cooldownn) {
        this.cooldownn = cooldownn;
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
            if(diff >= this.cooldownn){
                player.loadEnergy(this.getEnergy());
                node.getElement().setTime(System.currentTimeMillis());
            }else{
                System.out.println("You can't load energy yet");
            }
        }
    }
}
