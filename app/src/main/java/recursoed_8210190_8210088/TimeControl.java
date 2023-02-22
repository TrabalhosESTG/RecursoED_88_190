package recursoed_8210190_8210088;

/**
 * Classe que representa o tempo de cooldown de um jogador
 * @author David Francisco (8210088)
 * @author Guilherme Silva (8210190)
 */
public class TimeControl {
    private long time;
    private Player player;

    /**
     * Construtor da classe TimeControl
     * @param player Jogador
     * @param time Tempo de cooldown
     */
    public TimeControl(Player player, long time) {
        this.player = player;
        this.time = time;
    }

    /**
     * Método que retorna o tempo em que o jogador pode usou o recurso
     * @return Tempo de cooldown
     */
    public long getTime() {
        return this.time;
    }

    /**
     * Método que retorna o jogador
     * @return Jogador
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Método que define o tempo em que o jogador usou o recurso
     * @param time Tempo de cooldown
     */
    public void setTime(long time) {
        this.time = time;
    }

}
