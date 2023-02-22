package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;
import recursoed_8210190_8210088.GUI.Popup;


/**
* Classe que representa um portal
* @author David Francisco (8210088)
* @author Guilherme Silva (8210190)
*/
public class Portal  extends Local{
    private String name;
    private String team;
    private String player;
    private double maxEnergy;
    private LinkedList<PortalData> portalData;

    /**
     * Construtor da classe Portal
     * @param id Identificador do portal
     * @param longitude Longitude do portal
     * @param latitude Latitude do portal
     * @param energy Energia do portal
     * @param team Equipa do portal
     * @param player Jogador que conquistou o portal
     * @param maxEnergy Energia máxima do portal
     * @param name Nome do portal
     * @param portalData Lista de dados do portal
     */
    public Portal(int id, double longitude, double latitude, double energy, String team, String player, double maxEnergy, String name, LinkedList<PortalData> portalData) {
        super(id, longitude, latitude, energy);
        this.team = team;
        this.player = player;
        this.maxEnergy = maxEnergy;
        this.name = name;
        this.portalData = portalData;
    }

    /**
     * Construtor da classe Portal
     * @param id Identificador do portal
     * @param longitude Longitude do portal
     * @param latitude Latitude do portal
     * @param energy Energia do portal
     * @param maxEnergy Energia máxima do portal
     * @param name Nome do portal
     */
    public Portal(int id, double longitude, double latitude, double energy, double maxEnergy, String name) {
        super(id, longitude, latitude, energy);
        this.team = "None";
        this.maxEnergy = maxEnergy;
        this.name = name;
        this.portalData = new LinkedList<PortalData>();
    }

    /**
    * Método que carrega energia no portal
    * @param energy Energia a carregar
    */
    public void loadEnergy(double energy) {
        setEnergy((getEnergy() + energy));
		if (getEnergy() > this.maxEnergy) {
			setEnergy(maxEnergy);
		}
	}

    /**
    * Método que devolve o histórico do portal
    * @return Histórico do portal
    */
    public LinkedList<PortalData> getPortalData() {
        return portalData;
    }

    /**
    * Método que devolve o nome do portal
    * @return Nome do portal
    */
    public String getName() {
        return name;
    }

    /**
    * Método que define o nome do portal
    * @param name Nome do portal
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Método que devolve a equipa do portal
    * @return Equipa do portal
    */
    public String getTeam() {
        return team;
    }

    /**
    * Método que devolve o jogador que conquistou o portal
    * @return Jogador que conquistou o portal
    */
    public String getPlayer() {
        return player;
    }

    /**
    * Método que devolve a energia máxima do portal
    * @return Energia máxima do portal
    */
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
    * Método que define a equipa do portal
    * @param team Equipa do portal
    */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
    * Método que define o jogador que conquistou o portal
    * @param player Jogador que conquistou o portal
    */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
    * Método que define a energia máxima do portal
    * @param maxEnergy Energia máxima do portal
    */
    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    /**
    * Método que descarrega energia do portal
    * @param energy Energia a descarregar
    */
    public void deloadEnergy(double energy) {
        setEnergy((getEnergy() - energy));
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }

    /**
    * Método que conquista o portal
    * @param player1 Jogador que conquistou o portal
    */
    public void conquer(Player player1){
        setPlayer(player1.getName());
        setTeam(player1.getTeam());
        player1.portalConquered();
        setEnergy(player1.getMaxEnergy()*0.25);
    }

    /**
    * Método que liberta o portal
    */
    public void release(){
        setPlayer(null);
        setTeam("None");
    }

    /**
    * Método que verifica se é possível fortificar o portal
    * @param player1 Jogador que fortifica o portal
    * @param energyLoaded Energia a carregar no portal
    */
    public void fortifyPortal(Player player1, double energyLoaded) {
        if(this.getTeam() != player1.getTeam()) {
            new Popup("<html>You can't fortify a portal that is not yours.</html>");
            return;
        }
		if(this.getEnergy() == this.maxEnergy) {
			new Popup("<html>This portal is already full of energy.</html>");
			return;
		}
        if(energyLoaded > player1.getEnergy()) {
            new Popup("<html>You don't have enough energy to fortify this portal.</html>");
            return;
        }
        loadEnergy(energyLoaded);
        player1.removeEnergy(energyLoaded);
        player1.gainExp(4);
        new Popup("<html>You have fortified the portal.</html>");
        LinearNode<PortalData> node = portalData.getHead();
        while(node != null){
            if(node.getElement().getPlayer() == player1.getId()){
                node.getElement().setAction("Fortified the portal");
                return;
            }
            node = node.getNext();
        }
        if(node == null){
        portalData.add(new PortalData(player1.getId(), "Fortified the portal"));
        }
    }

    /**
    * Método que verifica se é possível atacar o portal
    * @param player1 Jogador que ataca o portal
    * @param energyDeloaded Energia a descarregar do portal
    */
    public void attackPortal(Player player1, double energyDeloaded) {
        if(this.getTeam() == player1.getTeam()) {
            new Popup("<html>You can't attack a portal that is yours.</html>");
            return;
        }
		if(this.getEnergy() == 0) {
			new Popup("<html>This portal is already empty of energy.</html>");
			return;
		}
        if(player1.getEnergy() < energyDeloaded) {
            new Popup("<html>You don't have enough energy to attack this portal.</html>");
            return;
        }
        deloadEnergy(energyDeloaded);
        player1.removeEnergy(energyDeloaded);
        player1.gainExp(4);
        LinearNode<PortalData> node = portalData.getHead();
        new Popup("<html>You attacked the portal and it lost " + energyDeloaded + " energy.</html>");
        while(node != null){
            if(node.getElement().getPlayer() == player1.getId()){
                node.getElement().setAction("Attacked the portal");
                return;
            }
            node = node.getNext();
        }
        if(node == null){
        portalData.add(new PortalData(player1.getId(), "Attacked the portal"));
        }
	}

    /**
    * Método que verifica se é possível conquistar o portal
    * @param player1 Jogador que conquista o portal
    * @param energyLoaded Energia a carregar no portal
    */
    public void conquerPortal(Player player1, double energyLoaded) {
        if(this.getTeam() != "None") {
            new Popup("<html>You can't conquer a portal that is not free.</html>");
            return;
        }
        if(this.getEnergy() != 0) {
            new Popup("<html>You can't conquer a portal that is not empty.</html>");
            return;
        }
		if (energyLoaded < (player1.getMaxEnergy() * 0.25)) {
			new Popup("<html>You need to load at least 25% of your energy to conquer this portal</html>");
			return;
		}
        if (player1.getEnergy() < energyLoaded) {
            new Popup("<html>You don't have enough energy to conquer this portal.</html>");
            return;
        }
        player1.removeEnergy(energyLoaded);
        conquer(player1);
        player1.gainExp(2);
        new Popup("<html>You have conquered the portal!</html>");
        LinearNode<PortalData> node = portalData.getHead();
        while(node != null){
            if(node.getElement().getPlayer() == player1.getId()){
                node.getElement().setAction("Conquered the portal");
                return;
            }
            node = node.getNext();
        }
        if(node == null){
            portalData.add(new PortalData(player1.getId(), "Conquered the portal"));
        }
	}
}
