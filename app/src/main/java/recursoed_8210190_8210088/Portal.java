package recursoed_8210190_8210088;

public class Portal  extends Local{
    private String name;
    private String team;
    private Player player;
    private double maxEnergy;

    public Portal(int id, double longitude, double latitude, double energy, String team, Player player, double maxEnergy, String name) {
        super(id, longitude, latitude, energy);
        this.team = team;
        this.player = player;
        this.maxEnergy = maxEnergy;
        this.name = name;
    }

    public Portal(int id, double longitude, double latitude, double energy, double maxEnergy, String name) {
        super(id, longitude, latitude, energy);
        this.team = "None";
        this.maxEnergy = maxEnergy;
        this.name = name;
    }
    
    public void loadEnergy(double energy) {
        setEnergy((getEnergy() + energy));
		if (getEnergy() > this.maxEnergy) {
			setEnergy(maxEnergy);
		}
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
            player.portalLost();
            release();
        }
    }

    public void conquer(Player player1){
        setPlayer(player1);
        setTeam(player1.getTeam());
        player.portalConquered();
        setEnergy(player1.getMaxEnergy()*0.25);
    }

    public void release(){
        setPlayer(null);
        setTeam("None");
    }

    public void askToLoadEnergy(Player player1) {
		if(getEnergy() == this.maxEnergy) {
			System.out.println("This portal is already full of energy.");
			return;
		}
		System.out.println("Do you want to load energy? (Y/N)");
		String answer = System.console().readLine();
		if (answer.equals("Y")) {
			System.out.println("You have " + player1.getEnergy() + " energy.");
			System.out.println("How much energy do you want to load?");
			double energy = Double.parseDouble(System.console().readLine());
			loadEnergy(energy);
            player1.gainExp(0.07);
		}
	}

    public void askToDeloadEnergy(Player player1) {
		if(getEnergy() == 0) {
			System.out.println("This portal is already empty of energy.");
			return;
		}
		String answer;
		do{
		System.out.println("Do you want to deload energy? (Y/N)");
		answer = System.console().readLine();
		if (answer.equals("Y")) {
			System.out.println("You have " + player1.getEnergy() + " energy.");
			System.out.println("How much energy do you want to deload?");
			double energy = Double.parseDouble(System.console().readLine());
			deloadEnergy(energy);
            player1.gainExp(0.07);
		}
	}while(answer.equals("Y"));
	}

    public void askToConquer(Player player1) {
		if (player1.getEnergy() < (player1.getMaxEnergy() * 0.25)) {
			System.out.println("You don't have enough energy to conquer this portal.");
			return;
		}
		System.out.println("Do you want to conquer this portal? (Y/N)");
		String answer = System.console().readLine();
		if (answer.equals("Y")) {
			if (player1.getEnergy() < (player.getMaxEnergy() * 0.25)) {
				System.out.println("You don't have enough energy to conquer this portal.");
				return;
			}
			System.out.println("The minimum energy to conquer this portal is" + (player1.getMaxEnergy() * 0.25) + "energy. You have " + player1.getEnergy() + "energy.");
			System.out.println("How much energy do you want to use to conquer this portal?");
			double energy = Double.parseDouble(System.console().readLine());
			player1.removeEnergy(energy);
			conquer(player1);
            player1.gainExp(0.1);
			System.out.println("You have conquered" + this.name + "!");
		}
	}
}
