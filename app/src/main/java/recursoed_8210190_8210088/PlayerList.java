package recursoed_8210190_8210088;

import Lists.LinearNode;
import Lists.LinkedList;

public class PlayerList {
    private LinkedList<Player> list;
    private int size;

    public PlayerList() {
        list = new LinkedList<Player>();
        size = 0;
    }

    public int getSize() {
        return size;
    }

	public LinkedList<Player> getList() {
		return list;
	}

    public void addPlayer(Player player) {
        list.add(player);
        size++;
    }

    public void removePlayer(Player player) {
        list.remove(player);
        size--;
    }


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

    public void getTeamPlayer(String teamName) {
		if (list.isEmpty()) {
			System.out.println("There are no players");
			return;
		} else {
			LinearNode<Player> current = list.getHead();
			while (current != null) {
				if (current.getElement().getTeam().equals(teamName)) {
					System.out.println(current.getElement().getName());
				}
				current = current.getNext();
			}
		}
	}

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
