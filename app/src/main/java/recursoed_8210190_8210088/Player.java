package recursoed_8210190_8210088;

public class Player {
    private String name;
    private String team;
    private int id;
    private int level;
    private double energy;
    private double maxEnergy;
    private double exp;
    private int conqueredPortals;
    private Local local;

    public Player(String name, String team, int id, int level, double exp, double energy, double maxEnergy, int conqueredPortals, Local local) {
        this.name = name;
        this.team = team;
        this.level = level;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.exp = exp;
        this.conqueredPortals = conqueredPortals;
        this.local = local;
        this.id = id;
    }

    public Player(String name, String team, int id) {
        this.name = name;
        this.team = team;
        this.id = id;
        this.level = 1;
        this.energy = 100;
        this.maxEnergy = 100;
        this.exp = 0;
        this.conqueredPortals = 0;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getLevel() {
        return level;
    }

    public double getEnergy() {
        return energy;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public double getExp() {
        return exp;
    }

    public int getConqueredPortals() {
        return conqueredPortals;
    }

    public Local getLocal() {
        return local;
    }

    public int getId() {
        return id;
    }

    public void setTeam(String team) {
        if(team.equals("Sparks") || team.equals("Giants")) {
            this.team = team;
        } else {
            this.team = "None";
        }
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void levelUp() {
		this.level++;
		this.maxEnergy += 10;
		this.exp = 0;
	}

    public void gainExp(double x) {
		this.exp += Math.pow((this.level/x), 2);
		if (this.exp > 100) {
			levelUp();
		}
	}

    public void portalConquered() {
        this.conqueredPortals++;
    }

    public void portalLost() {
        this.conqueredPortals--;
    }

    public void loadEnergy(double energy) {
		this.energy += energy;
		if (this.energy > this.maxEnergy) {
			this.energy = this.maxEnergy;
		}
	}

    public void removeEnergy(double energy) {
		this.energy -= energy;
		if (this.energy < 0) {
			this.energy = 0;
		}
	}
}
