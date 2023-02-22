package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;

/**
 * Classe que representa um conector
 * @author David Francisco (8210088)
 * @author Guilherme Silva (8210190)
 */
public class Connector extends Local{
    private int cooldown;
    private LinkedList<TimeControl> timeControl;
    private boolean mine;

    /**
     * Construtor da classe Connector
     * @param id Identificador do conector
     * @param longitude Longitude do conector
     * @param latitude Latitude do conector
     * @param energy Energia que o conector fornece
     * @param cooldown  Cooldown do conector
     */
    public Connector(int id, double longitude, double latitude, double energy, int cooldown) {
        super(id, longitude, latitude, energy);
        this.cooldown = cooldown;
        this.timeControl = new LinkedList<TimeControl>();
        this.mine = false;
    }

    /**
    * Método que retorna o cooldown do conector
    * @return Cooldown do conector
    */
    public int getCooldown() {
        return cooldown;
    }

    /**
    * Método que verifica se existe uma mina no conector
    * @return True se existir uma mina no conector, false caso contrário
    */
    public boolean isMine() {
        return mine;
    }

    /**
    * Método que define se existe uma mina no conector
    * @param mine True se existir uma mina no conector, false caso contrário
    */
    public void setMine(boolean mine) {
        this.mine = mine;
    }

    /**
    * Método que define o cooldown do conector
    * @param cooldown Cooldown do conector
    */
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    /**
    * Método que retorna a lista de controlo de tempo
    * @return Lista de controlo de tempo
    */
    public LinkedList<TimeControl> getTimeControl() {
        return timeControl;
    }

    /**
    * Método que adiciona um elemento à lista de controlo de tempo
    * @param timeControl Elemento a adicionar
    */
    public void addTimeControl(TimeControl timeControl) {
        this.timeControl.add(timeControl);
    }

    /**
    * Método que carrega a energia do jogador
    * @param player Jogador a carregar a energia
    */
    public boolean loadPlayerEnergy(Player player) {
        LinearNode<TimeControl> node = this.timeControl.getHead();
        while(node != null && !(player.getId() == node.getElement().getPlayer().getId())) {
            node = node.getNext();
        }
        if(node == null){
            timeControl.add(new TimeControl(player, System.currentTimeMillis()));
            player.loadEnergy(this.getEnergy());
            return true;
        }else{
            int diff = (int) ((System.currentTimeMillis() - node.getElement().getTime()) / 60000);
            if(diff >= this.cooldown){
                player.loadEnergy(this.getEnergy());
                node.getElement().setTime(System.currentTimeMillis());
                return true;
            }else{
				return false;
            }
        }
    }

    public double getTimeLeft(Player player){
        LinearNode<TimeControl> node = this.timeControl.getHead();
        while(node != null && !(player.getId() == node.getElement().getPlayer().getId())) {
            node = node.getNext();
        }
        if(node == null){
            return 0;
        }else{
            int diff = (int) ((System.currentTimeMillis() - node.getElement().getTime()) / 60000);
            if(diff >= this.cooldown){
                return 0;
            }else{
                return this.cooldown - diff;
            }
        }
    }
}
