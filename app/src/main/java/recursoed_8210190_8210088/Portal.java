package recursoed_8210190_8210088;

import Lists.LinkedList;
public class Portal  extends Local{
    private String name;
    private String team;
    private Player player;
    private double maxEnergy;
    private LinkedList<PortalData> portalData;

    public Portal(int id, double longitude, double latitude, double energy, String team, Player player, double maxEnergy, String name, LinkedList<PortalData> portalData) {
        super(id, longitude, latitude, energy);
        this.team = team;
        this.player = player;
        this.maxEnergy = maxEnergy;
        this.name = name;
        this.portalData = portalData;
    }

    public Portal(int id, double longitude, double latitude, double energy, double maxEnergy, String name) {
        super(id, longitude, latitude, energy);
        this.team = "None";
        this.maxEnergy = maxEnergy;
        this.name = name;
        this.portalData = new LinkedList<PortalData>();
    }
    
    public void loadEnergy(double energy) {
        setEnergy((getEnergy() + energy));
		if (getEnergy() > this.maxEnergy) {
			setEnergy(maxEnergy);
		}
	}

    public LinkedList<PortalData> getPortalData() {
        return portalData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public Player getPlayer() {
        return player;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void deloadEnergy(double energy) {
        setEnergy((getEnergy() - energy));
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }

    public void conquer(Player player1){
        setPlayer(player1);
        setTeam(player1.getTeam());
        player.portalConquered();
        setEnergy(player1.getMaxEnergy()*0.25);
    }

    public void release(){
        player.portalLost();
        setPlayer(null);
        setTeam("None");
    }

    public void fortifyPortal(Player player1, double energyLoaded) {
		if(this.getEnergy() == this.maxEnergy) {
			System.out.println("This portal is already full of energy.");
			return;
		}
        if(energyLoaded > player1.getEnergy()) {
            System.out.println("You don't have enough energy to fortify this portal.");
            return;
        }
        loadEnergy(energyLoaded);
        player1.removeEnergy(energyLoaded);
        player1.gainExp(4);
        portalData.add(new PortalData(player1, "Fortified the portal"));
    }

    public void attackPortal(Player player1, double energyDeloaded) {
		if(this.getEnergy() == 0) {
			System.out.println("This portal is already empty of energy.");
			return;
		}
        if(player1.getEnergy() < energyDeloaded) {
            System.out.println("You don't have enough energy to attack this portal.");
            return;
        }
        deloadEnergy(energyDeloaded);
        player1.removeEnergy(energyDeloaded);
        player1.gainExp(4);
        portalData.add(new PortalData(player1, "Attacked the portal"));
        if(getEnergy() == 0){
            release();
        }
	}

    public void conquerPortal(Player player1, double energyLoaded) {
		if (energyLoaded < (player1.getMaxEnergy() * 0.25)) {
			System.out.println("You need to load at least 25% of your energy to conquer this portal");
			return;
		}
        if (player1.getEnergy() < energyLoaded) {
            System.out.println("You don't have enough energy to conquer this portal.");
            return;
        }
        player1.removeEnergy(energyLoaded);
        conquer(player1);
        player1.gainExp(2);
        portalData.add(new PortalData(player1, "Conquered the portal"));
        System.out.println("You have conquered" + this.name + "!");
	}
}
