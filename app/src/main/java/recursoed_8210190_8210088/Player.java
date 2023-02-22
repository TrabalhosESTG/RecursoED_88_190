package recursoed_8210190_8210088;


/**
* Classe que representa um jogador.
* @author David Francisco(8210088)
* @author Guilherme Silva(8210190)
*/
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


    /**
    * Construtor da classe Player.
    * @param name Nome do jogador.
    * @param team Equipa do jogador.
    * @param id Id do jogador.
    * @param level Nivel do jogador.
    * @param exp Experiencia do jogador.
    * @param energy Energia do jogador.
    * @param maxEnergy Energia maxima do jogador.
    * @param conqueredPortals Portais conquistados pelo jogador.
    * @param local Local onde se encontra o jogador.
    */
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

    /**
    * Construtor da classe Player.
    * @param name Nome do jogador.
    * @param team Equipa do jogador.
    * @param id Id do jogador.
    */
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

    /**
    * Método que retorna o nome do jogador.
    * @return Nome do jogador.
    */
    public String getName() {
        return name;
    }

    /**
    * Método que retorna a equipa do jogador.
    * @return Equipa do jogador.
    */
    public String getTeam() {
        return team;
    }

    /**
    * Método que retorna o nivel do jogador.
    * @return Nivel do jogador.
    */
    public int getLevel() {
        return level;
    }

    /**
    * Método que retorna a energia do jogador.
    * @return Energia do jogador.
    */
    public double getEnergy() {
        return energy;
    }

    /**
    * Método que retorna a energia maxima do jogador.
    * @return Energia maxima do jogador.
    */
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
    * Método que retorna a experiencia do jogador.
    * @return Experiencia do jogador.
    */
    public double getExp() {
        return exp;
    }

    /**
    * Método que retorna o numero de portais conquistados pelo jogador.
    * @return Numero de portais conquistados pelo jogador.
    */
    public int getConqueredPortals() {
        return conqueredPortals;
    }

    /**
    * Método que retorna o local onde se encontra o jogador.
    * @return Local onde se encontra o jogador.
    */
    public Local getLocal() {
        return local;
    }

    /**
    * Método que retorna o id do jogador.
    * @return Id do jogador.
    */
    public int getId() {
        return id;
    }

    /**
    * Método que altera o nome do jogador.
    * @param name Novo nome do jogador.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Método que altera a equipa do jogador.
    * @param team Nova equipa do jogador.
    */
    public void setTeam(String team) {
        if(team.equals("Sparks") || team.equals("Giants")) {
            this.team = team;
        } else {
            this.team = "None";
        }
    }

    /**
    * Método que altera o local onde se encontra o jogador.
    * @param local Novo local onde se encontra o jogador.
    */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
    * Método que aumenta o nível do jogador.
    */
    public void levelUp() {
		this.level++;
		this.maxEnergy += 10;
		this.exp = 0;
	}

    /**
    * Método que aumenta a experiencia do jogador.
    * @param x Valor que define quanta experiencia o jogador ganha.
    */
    public void gainExp(double x) {
		this.exp += Math.pow((this.level/x), 2);
		if (this.exp > 100) {
			levelUp();
		}
	}

    /**
    * Método que aumenta o numero de portais conquistados pelo jogador.
    */
    public void portalConquered() {
        this.conqueredPortals++;
    }

    /**
    * Método que diminui o numero de portais conquistados pelo jogador.
    */
    public void portalLost() {
        this.conqueredPortals--;
    }

    /**
    * Método que aumenta a energia do jogador.
    * @param energia Valor que define quanta energia o jogador ganha.
    */
    public void loadEnergy(double energia) {
		this.energy += energia;
		if (this.energy > this.maxEnergy) {
			this.energy = this.maxEnergy;
		}
	}

    /**
    * Método que diminui a energia do jogador.
    * @param energia Valor que define quanta energia o jogador perde.
    */
    public void removeEnergy(double energia) {
		this.energy -= energia;
		if (this.energy < 0) {
			this.energy = 0;
		}
	}

    /**
    * Método que altera o nome e a equipa do jogador.
    * @param name Novo nome do jogador.
    * @param team Nova equipa do jogador.
    */
    public void editPlayer(String name, String team) {
        setName(name);
        setTeam(team);
	}
}
