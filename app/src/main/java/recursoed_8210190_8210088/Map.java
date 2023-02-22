package recursoed_8210190_8210088;

import Lists.ArrayList;
import Lists.LinearNode;
import Lists.Network;

public class Map {
    private Network<Local> network;
    private PlayerList players;
    private int totalLocals;
    private ArrayList<ArrayList<Local>> giantsPath;
    private ArrayList<ArrayList<Local>> sparksPath;

    public Map() {
        this.network = new Network<Local>();
        this.totalLocals = 0;
        this.players = new PlayerList();
        this.giantsPath = new ArrayList<ArrayList<Local>>();
        this.sparksPath = new ArrayList<ArrayList<Local>>();
    }

    public int getTotalLocals() {
        return totalLocals;
    }

	public PlayerList getPlayers() {
		return players;
	}

    public void addLocal(Local local) {
        this.network.addVertex(local);
        this.totalLocals++;
        network.getWeights().add(new ArrayList<Double>());
        giantsPath.add(new ArrayList<Local>());
        sparksPath.add(new ArrayList<Local>());
    }

    public void addConnection(Local local1, Local local2, double weight) {
        this.network.addEdge(local1, local2, weight);
    }

    public void addPlayer(Player player) {
        this.players.addPlayer(player);
    }

    public ArrayList<Local> getGiantsPath(Local local) {
        int index = this.network.indexOf(local);
        return giantsPath.get(index);
    }

    public ArrayList<Local> getSparksPath(Local local) {
        int index = this.network.indexOf(local);
        return sparksPath.get(index);
    }

    public void addGiantsTunel(Local local1, Local local2) {
        int index1 = this.network.indexOf(local1);
        int index2 = this.network.indexOf(local2);
        giantsPath.get(index1).add(local2);
        giantsPath.get(index2).add(local1);
    }

    public void addSparksTunel(Local local1, Local local2) {
        int index1 = this.network.indexOf(local1);
        int index2 = this.network.indexOf(local2);
        sparksPath.get(index1).add(local2);
        sparksPath.get(index2).add(local1);
    }

    public void removeLocal(Local local) {
        this.network.removeVertex(local);
        this.totalLocals--;
    }

    public void removeConnection(Local local1, Local local2) {
        this.network.removeEdge(local1, local2);
    }

    public ArrayList<Portal> getPortals() {
        ArrayList<Portal> portals = new ArrayList<Portal>();
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i) instanceof Portal) {
                portals.add((Portal) this.network.getVertices().get(i));
            }
        }
        return portals;
    }

    public ArrayList<Local> getLocals() {
        return this.network.getVertices();
    }

    public ArrayList<Connector> getConnectors() {
        ArrayList<Connector> connectors = new ArrayList<Connector>();
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i) instanceof Connector) {
                connectors.add((Connector) this.network.getVertices().get(i));
            }
        }
        return connectors;
    }


    public void getConnectors25() {
        ArrayList<Connector> connectors = getConnectors();
        for (int i = 0; i < connectors.size()*0.25; i++) {
            int randomIndex = (int) (Math.random() * connectors.size());
            connectors.get(randomIndex).setMine(true);
        }
    }

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

    public Local getLocalByID(int id) {
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i).getId() == id) {
                return this.network.getVertices().get(i);
            }
        }
        return null;
    }

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

    public String shortestPathBetweenAnother(Local local1, Local local2, Local local3){
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

    public int getNextId() {
        int id = 0;
        for (int i = 0; i < this.network.getVertices().size(); i++) {
            if (this.network.getVertices().get(i).getId() > id) {
                id = this.network.getVertices().get(i).getId();
            }
        }
        return id + 1;
    }

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
                    routes[k][2] = "0";
                    k++;
                }
            }
            if(getSparksPath(network.getVertex(i)).size() > 0) {
                for(int j = 0; j < getSparksPath(network.getVertex(i)).size(); j++) {
                    routes[k][0] = "" + network.getVertex(i).getId();
                    routes[k][1] = "" + getSparksPath(network.getVertex(i)).get(j).getId();
                    routes[k][2] = "0";
                    k++;
                }
            }

        }


        return routes;
    }
}
