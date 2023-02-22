package recursoed_8210190_8210088;

/**
* Classe que representa o histórico de um portal
* @author David Francisco (8210088)
* @author Guilherme Silva (8210190)
*/
public class PortalData {
    private int playerId;
    private String action;

    /**
    * Construtor da classe
    * @param playerId Jogador que realizou a ação
    * @param action Ação realizada
    */
    public PortalData(int playerId, String action) {
        this.playerId = playerId;
        this.action = action;
    }

    /**
    * Retorna o id do jogador que realizou a ação
    * @return Jogador que realizou a ação
    */
    public int getPlayer() {
        return playerId;
    }

    /**
    * Retorna a ação realizada
    * @return Ação realizada
    */
    public String getAction() {
        return action;
    }

    /**
    * Define a ação realizada
    * @param action Ação realizada
    */
    public void setAction(String action) {
        this.action = action;
    }

}
