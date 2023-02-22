package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;

/**
* Classe que representa uma lista de jogadores
* @author David Francisco (8210088)
* @author Guilherme Silva (8210190)
*/
public class PlayerList {
    private LinkedList<Player> list;
    private int size;


	/**
	* Construtor da classe PlayerList
	*/
    public PlayerList() {
        list = new LinkedList<Player>();
        size = 0;
    }

	/**
	* Retorna o tamanho da lista
	* @return int - tamanho da lista
	*/
    public int getSize() {
        return size;
    }

	/**
	* Retorna a lista de jogadores
	* @return LinkedList<Player> - lista de jogadores
	*/
	public LinkedList<Player> getList() {
		return list;
	}

	/**
	* Adiciona um jogador a lista
	* @param player - jogador a ser adicionado
	*/
    public void addPlayer(Player player) {
        list.add(player);
        size++;
    }

	/**
	* Remove um jogador da lista
	* @param player - jogador a ser removido
	*/
    public void removePlayer(Player player) {
        list.remove(player);
        size--;
    }


	/**
	* Retorna um jogador da lista a partir do seu id
	* @param id - id do jogador a ser retornado
	* @return Player - jogador
	*/
    public Player getPlayer(int id) {
		if (list.isEmpty()) {
            System.out.println("There are no players");
			return null;
		} else {
			LinearNode<Player> current = list.getHead();
			while (current != null && !(current.getElement().getId() == id)) {
				current = current.getNext();
			}
			if (current != null) {
				return current.getElement();
			} else {
				return null;
			}
		}
	}

	/**
	* Retorna todos os jogadores da lista a partir da sua equipa
	* @param teamName - nome da equipa
	* @return Player[] - array de jogadores
	*/
    public Player[] getTeamPlayer(String teamName) {
		if (list.isEmpty()) {
			System.out.println("There are no players");
			return null;
		}
		Player[] players = new Player[size];
		int i = 0;
		LinearNode<Player> current = list.getHead();
		while (current != null) {
			if (current.getElement().getTeam().equals(teamName)) {
				players[i] = current.getElement();
				i++;
			}
			current = current.getNext();
		}

		return players;
	}

	/**
	* Ordena os jogadores da lista por nível
	*/
    public void sortPlayersByLevel() {
		LinearNode<Player> current = list.getHead();
		LinearNode<Player> next = current.getNext();
		while (current != null) {
			while (next != null) {
				if (current.getElement().getLevel() < next.getElement().getLevel()) {
					Player temp = current.getElement();
					current.setElement(next.getElement());
					next.setElement(temp);
				}
				next = next.getNext();
			}
			current = current.getNext();
			next = current;
		}
		printPlayers();
	}

	/**
	* Ordena os jogadores da lista por número de portais conquistados
	*/
    public void sortPlayersByPortals() {
		LinearNode<Player> current = list.getHead();
		LinearNode<Player> next = current.getNext();
		while (current != null) {
			while (next != null) {
				if (current.getElement().getConqueredPortals() < next.getElement().getConqueredPortals()) {
					Player temp = current.getElement();
					current.setElement(next.getElement());
					next.setElement(temp);
				}
				next = next.getNext();
			}
			current = current.getNext();
			next = current;
		}
		printPlayers();
	}

	/**
	* Imprime os jogadores da lista
	*/
    public void printPlayers() {
		if (list.isEmpty()) {
			System.out.println("There are no players");
			return;
		} else {
			LinearNode<Player> current = list.getHead();
			while (current != null) {
				System.out.println(current.getElement().getName());
				current = current.getNext();
			}
		}
	}

	/**
	* Retorna todos os jogadores da lista
	* @return Player[] - array de jogadores
	*/
	public Player[] getPlayers(){
		Player[] players = new Player[size];
		LinearNode<Player> current = list.getHead();
		int i = 0;
		while (current != null) {
			players[i] = current.getElement();
			current = current.getNext();
			i++;
		}
		return players;
	}

	/**
	* Retorna o id do próximo jogador a ser adicionado
	* @return int - id do próximo jogador
	*/
	public int getNextID(){
		int id = 0;
		LinearNode<Player> current = list.getHead();
		while (current != null) {
			if (current.getElement().getId() > id) {
				id = current.getElement().getId();
			}
			current = current.getNext();
		}
		return id + 1;
	}
}
