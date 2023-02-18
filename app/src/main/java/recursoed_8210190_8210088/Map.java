package recursoed_8210190_8210088;

import Exceptions.InvalidValue;
import Lists.ArrayList;
import Lists.Network;

public class Map {
    private Network<Local> Network;
    private int totalLocals;

    public Map() {
        this.Network = new Network<Local>();
        this.totalLocals = 0;
    }

    public int getTotalLocals() {
        return totalLocals;
    }

    public void addLocal(Local local) {
        this.Network.addVertex(local);
        this.totalLocals++;
    }

    public void addConnection(Local local1, Local local2, double weight) {
        this.Network.addEdge(local1, local2, weight);
    }

    public void editLatLong(Local local, double latitude, double longitude) throws InvalidValue {
        if(latitude < -90 || latitude > 90)
            throw new InvalidValue("Latitude out of bounds");
        else
            local.setLatitude(latitude);
        if(longitude < -180 || longitude > 180)
            throw new InvalidValue("Longitude out of bounds");
        else
            local.setLongitude(longitude);
   }

    public void editEnergy(Local local, double energy) throws InvalidValue{
         if(energy >= 0)
              local.setEnergy(energy);
         else
              throw new InvalidValue("Energy cannot be negative");
    }

    public void editMaxEnergy(Portal portal, double maxEnergy) throws InvalidValue{
        if(maxEnergy >= 0)
            portal.setMaxEnergy(maxEnergy);
        else
            throw new InvalidValue("Max Energy cannot be negative");
    }

    public void editName(Portal portal, String name) {
        portal.setName(name);
    }

    public void editCooldown(Connector connector, int cooldown) throws InvalidValue{
        if(cooldown >= 0)
            connector.setCooldown(cooldown);
        else
            throw new InvalidValue("Cooldown cannot be negative");
    }

    public void removeLocal(Local local) {
        this.Network.removeVertex(local);
        this.totalLocals--;
    }

    public void removeConnection(Local local1, Local local2) {
        this.Network.removeEdge(local1, local2);
    }

    public ArrayList<Portal> getPortals() {
        ArrayList<Portal> portals = new ArrayList<Portal>();
        for (int i = 0; i < this.Network.getVertices().size(); i++) {
            if (this.Network.getVertices().get(i) instanceof Portal) {
                portals.add((Portal) this.Network.getVertices().get(i));
            }
        }
        return portals;
    }

    public ArrayList<Local> getLocals() {
        return this.Network.getVertices();
    }

    public ArrayList<Connector> getConnectors() {
        ArrayList<Connector> connectors = new ArrayList<Connector>();
        for (int i = 0; i < this.Network.getVertices().size(); i++) {
            if (this.Network.getVertices().get(i) instanceof Connector) {
                connectors.add((Connector) this.Network.getVertices().get(i));
            }
        }
        return connectors;
    }
}
