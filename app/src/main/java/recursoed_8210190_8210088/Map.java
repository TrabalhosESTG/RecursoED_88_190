package recursoed_8210190_8210088;

import Lists.ArrayList;
import Lists.LinearNode;
import Lists.Network;

/**
 * Classe que representa o mapa do jogo.
 *
 * @author David Francisco (8210088)
 * @author Guilherme Silva (8210190)
 */
public class Map {
    private Network<Local> network;
    private PlayerList players;
    private int totalLocals;
    private int totalRoutes;
    private ArrayList<ArrayList<Local>> giantsPath;
    private ArrayList<ArrayList<Local>> sparksPath;

    /**
     * Construtor da classe Map.
     */
    public Map() {
        this.network = new Network<Local>();
        this.totalLocals = 0;
        this.totalRoutes = 0;
        this.players = new PlayerList();
        this.giantsPath = new ArrayList<ArrayList<Local>>();
        this.sparksPath = new ArrayList<ArrayList<Local>>();
    }

    /**
     * Retorna o número de locais do mapa.
     *
     * @return Número de locais do mapa.
     */
    public int getTotalLocals() {
        return totalLocals;
    }

    /**
    * Retorna os jogadores do mapa.
    *
    */
	public PlayerList getPlayers() {
		return players;
	}

    /**
    * Retorna o número de rotas do mapa.
    *
    * @return Número de rotas do mapa.
    */
    public int getTotalRoutes() {
        return totalRoutes;
    }

    /**
    *Adiciona um local ao mapa.
    *@param local Local a ser adicionado.
    */
    public void addLocal(Local local) {
        this.network.addVertex(local);
        this.totalLocals++;
        network.getWeights().add(new ArrayList<Double>());
        giantsPath.add(new ArrayList<Local>());
        sparksPath.add(new ArrayList<Local>());
    }

    /**
    *Adiciona uma conexão entre dois locais.
    *@param local1 Primeiro local.
    *@param local2 Segundo local.
    *@param weight Peso da conexão.
    */
    public void addConnection(Local local1, Local local2, double weight) {
        this.network.addEdge(local1, local2, weight);
        this.totalRoutes++;
    }

    /**
    *Adiciona um jogador ao mapa.
    *@param player Jogador a ser adicionado.
    */
    public void addPlayer(Player player) {
        this.players.addPlayer(player);
        player.setLocal(this.network.getVertices().get(0));
    }

    /**
    *Método que retorna as conexões de um local da equipe Giants.
    *@param local Local a ser verificado.
    */
    public ArrayList<Local> getGiantsPath(Local local) {
        int index = this.network.indexOf(local);
        return giantsPath.get(index);
    }

    /**
    *Método que retorna as conexões de um local da equipe Sparks.
    *@param local Local a ser verificado.
    */
    public ArrayList<Local> getSparksPath(Local local) {
        int index = this.network.indexOf(local);
        return sparksPath.get(index);
    }

    /**
    *Método que adiciona uma conexão entre dois locais da equipe Giants.
    *@param local1 Primeiro local.
    *@param local2 Segundo local.
    */
    public void addGiantsTunel(Local local1, Local local2) {
        int index1 = this.network.indexOf(local1);
        int index2 = this.network.indexOf(local2);
        giantsPath.get(index1).add(local2);
        giantsPath.get(index2).add(local1);
    }

    /**
    *Método que adiciona uma conexão entre dois locais da equipe Sparks.
    *@param local1 Primeiro local.
    *@param local2 Segundo local.
    */
    public void addSparksTunel(Local local1, Local local2) {
        int index1 = this.network.indexOf(local1);
        int index2 = this.network.indexOf(local2);
        sparksPath.get(index1).add(local2);
        sparksPath.get(index2).add(local1);
    }

    /**
    *Método que remove um local do mapa.
    *@param local Local a ser removido.
    */
    public void removeLocal(Local local) {
        this.network.removeVertex(local);
        this.totalLocals--;
    }

    /**
    *Método que remove uma conexão entre dois locais.
    *@param local1 Primeiro local.
    *@param local2 Segundo local.
    */
    public void removeConnection(Local local1, Local local2) {
        this.network.removeEdge(local1, local2);
        this.totalRoutes--;
    }

    /**
    *Método que retorna todos os Portais do mapa.
    */
    public ArrayList<Portal> getPortals() {
        ArrayList<Portal> portals = new ArrayList<Portal>();
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i) instanceof Portal) {
                portals.add((Portal) this.network.getVertices().get(i));
            }
        }
        return portals;
    }

    /**
    *Método que retorna todos os locais do mapa.
    */
    public ArrayList<Local> getLocals() {
        return this.network.getVertices();
    }

    /**
    *Método que retorna todos os Conectores do mapa.
    */
    public ArrayList<Connector> getConnectors() {
        ArrayList<Connector> connectors = new ArrayList<Connector>();
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i) instanceof Connector) {
                connectors.add((Connector) this.network.getVertices().get(i));
            }
        }
        return connectors;
    }

    /**
    *Método que ativa as minas de 25% dos conectores do mapa.
    */
    public void getConnectors25() {
        ArrayList<Connector> connectors = getConnectors();
        for (int i = 0; i < connectors.size()*0.25; i++) {
            int randomIndex = (int) (Math.random() * connectors.size());
            connectors.get(randomIndex).setMine(true);
        }
    }

    /**
    *Método que define o local de um jogador.
    *@param player Jogador a ser definido.
    *@param local Local a ser definido.
    */
    public void playerSetLocal(Player player, Local local) {
        player.setLocal(local);
        if(local instanceof Connector) {
            Player otherPlayer = null;
            LinearNode<Player> node = players.getList().getHead();
            if(((Connector) local).isMine()) {
                player.removeEnergy((player.getEnergy()*0.5));
                ((Connector) local).setMine(false);
            }
            while(node != null) {
                if(node.getElement().getLocal() == local && node.getElement() != player) {
                    otherPlayer = node.getElement();
                }
                node = node.getNext();
            }
            LinearNode<TimeControl> node2 = ((Connector) local).getTimeControl().getHead();
            if(otherPlayer == null)
                return;
            if(otherPlayer.getEnergy() > player.getEnergy()) {
                while(node2 != null) {
                    if(node2.getElement().getPlayer().equals(player)) {
                        node2.getElement().setTime(System.currentTimeMillis());
                        break;
                    }
                    node2 = node2.getNext();
                }
            }
            else if(otherPlayer.getEnergy() < player.getEnergy()) {
                while(node2 != null) {
                    if(node2.getElement().getPlayer().equals(otherPlayer)) {
                        node2.getElement().setTime(System.currentTimeMillis());
                        break;
                    }
                    node2 = node2.getNext();
                }
            }
        }
    }

    /**
    *Método que retorna um local pelo seu id.
    *@param id Id do local.
    */
    public Local getLocalByID(int id) {
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i).getId() == id) {
                return this.network.getVertices().get(i);
            }
        }
        return null;
    }

    /**
    *Método que retorna os caminhos possíveis de um jogador a partir de um local.
    *@param player Jogador a ser definido.
    */
    public ArrayList<Integer> nextLocation(Player player) {
        ArrayList<Integer> nextLocation = new ArrayList<Integer>();
        ArrayList<Local> neighbors = this.network.getNeighbors(player.getLocal());
        for (int i = 0; i < neighbors.size(); i++) {
            nextLocation.add(neighbors.get(i).getId());
        }
        if(player.getTeam().equals("Giants")) {
            ArrayList<Local> giantsPath = getGiantsPath(player.getLocal());
            for(int i = 0; i < giantsPath.size(); i++) {
                if(!(nextLocation.contains(giantsPath.get(i).getId()))){
                    nextLocation.add(giantsPath.get(i).getId());
                }
            }
        }else if(player.getTeam().equals("Sparks")) {
            ArrayList<Local> sparksPath = getSparksPath(player.getLocal());
            for(int i = 0; i < sparksPath.size(); i++) {
                if(!(nextLocation.contains(sparksPath.get(i).getId()))){
                    nextLocation.add(sparksPath.get(i).getId());
                }
            }
        }
        return nextLocation;
    }

    /**
    *Método que retorna o caminho mais curto entre dois locais passando por um terceiro.
    *@param local1 Local de partida.
    *@param local2 Local de chegada.
    *@param local3 Local que deve ser passado.
    */
    public String shortestPathBetweenAnother(Local local1, Local local2, Local local3){
        if(network.getEdges().get(network.indexOf(local1)).size() == 0 || network.getEdges().get(network.indexOf(local3)).size() == 0 || network.getEdges().get(network.indexOf(local2)).size() == 0)
            return "Não existe caminho entre os locais";
        String path = " ";
        ArrayList<Integer> path1 = network.shortestPath(network.indexOf(local1), network.indexOf(local3));
        ArrayList<Integer> path2 = network.shortestPath(network.indexOf(local3), network.indexOf(local2));
        Double weight = network.shortestPathWeight(local1, local3) + network.shortestPathWeight(local3, local2);
        for(int i = 0; i < path1.size(); i++) {
            path +=   " --> " + network.getVertex(path1.get(i)).getId();
        }
        for(int i = 0; i < path2.size(); i++) {
            path +=   " --> " + network.getVertex(path2.get(i)).getId();
        }
        path += " Peso total: " + weight;
        return path;
    }

    /**
    *Método que retorna o caminho mais curto entre dois locais.
    *@param local1 Local de partida.
    *@param local2 Local de chegada.
    */
    public String shortestPath(Local local1, Local local2){
        String path = " ";
        ArrayList<Integer> path1 = network.shortestPath(network.indexOf(local1), network.indexOf(local2));
        Double weight = network.shortestPathWeight(local1, local2);
        for(int i = 0; i < path1.size(); i++) {
            path +=   " --> " + network.getVertex(path1.get(i)).getId();
        }
        path += " Peso total: " + weight;
        return path;
    }

    /**
    *Método que retorna o id do próximo local a ser adicionado.
    */
    public int getNextId() {
        int id = 0;
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i).getId() > id) {
                id = this.network.getVertices().get(i).getId();
            }
        }
        return id + 1;
    }

    /**
    *Método que retorna todos os caminhos do mapa.
    *@return String[][] com todos os caminhos do mapa.
    */
	public String[][] getRoutes(){
        String[][] routes = new String[(network.getEdges().size() * 6)][3];
        ArrayList<ArrayList<Local>> rotas = network.getEdges();
        ArrayList<ArrayList<Double>> pesos = network.getWeights();
        int k = 0;
        for(int i = 0; i < rotas.size(); i++) {
            if(!(rotas.get(i).size() < 1)) {
                for(int j = 0; j < rotas.get(i).size(); j++) {
                    routes[k][0] = "" + network.getVertex(i).getId();
                    routes[k][1] = "" + rotas.get(i).get(j).getId();
                    routes[k][2] = "" + pesos.get(i).get(j);
                    k++;
                }
            }
            if(getGiantsPath(network.getVertex(i)).size() > 0) {
                for(int j = 0; j < getGiantsPath(network.getVertex(i)).size(); j++) {
                    routes[k][0] = "" + network.getVertex(i).getId();
                    routes[k][1] = "" + getGiantsPath(network.getVertex(i)).get(j).getId();
                    routes[k][2] = "Giants";
                    k++;
                }
            }
            if(getSparksPath(network.getVertex(i)).size() > 0) {
                for(int j = 0; j < getSparksPath(network.getVertex(i)).size(); j++) {
                    routes[k][0] = "" + network.getVertex(i).getId();
                    routes[k][1] = "" + getSparksPath(network.getVertex(i)).get(j).getId();
                    routes[k][2] = "Sparks";
                    k++;
                }
            }

        }
        return routes;
    }

    /**
    *Metodo que permite atacar um portal
    *@param player Jogador que ataca o portal.
    *@param attackEnergy Energia do ataque.
    */
    public void attackPortal(Player player, double attackEnergy){
        if(player.getLocal() instanceof Portal){
            Portal portal = (Portal) player.getLocal();
            portal.attackPortal(player, attackEnergy);
            if(portal.getEnergy() == 0){
                LinearNode<Player> current = getPlayers().getList().getHead();
                while(current != null){
                    if(current.getElement().getName().equals(portal.getPlayer())){
                        current.getElement().portalLost();
                    }
                    current = current.getNext();
                }
                portal.release();
            }
        }
    }

    /**
    *Método que remove todas as minas do mapa.
    */
    public void removeMines(){
        ArrayList<Connector> connectors = getConnectors();
        for(int i = 0; i < connectors.size(); i++) {
            if(connectors.get(i).isMine()) {
                connectors.get(i).setMine(false);
            }
        }
    }
}
