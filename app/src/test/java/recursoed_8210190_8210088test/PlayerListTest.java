package recursoed_8210190_8210088test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import recursoed_8210190_8210088.Player;
import recursoed_8210190_8210088.PlayerList;
public class PlayerListTest {

    @Test
    public void testAddPlayer() {
        PlayerList playerList = new PlayerList();
        Player player = new Player("Juan", "Giants", 1);
        playerList.addPlayer(player);
        assertEquals(1, playerList.getSize());
    }

    @Test
    public void testRemovePlayer() {
        PlayerList playerList = new PlayerList();
        Player player = new Player("Juan", "Giants", 1);
        playerList.addPlayer(player);
        playerList.removePlayer(player);
        assertEquals(0, playerList.getSize());
    }

    @Test
    public void testGetPlayer() {
        PlayerList playerList = new PlayerList();
        Player player = new Player("Juan", "Giants", 1);
        Player player2 = new Player("Pedro", "Giants", 2);
        playerList.getPlayer(2);
        playerList.addPlayer(player);
        playerList.getPlayer(2);
        playerList.addPlayer(player2);
        assertEquals(player2, playerList.getPlayer(2));
    }

    @Test
    public void testGetTeamPlayer() {
        PlayerList playerList = new PlayerList();
        Player player = new Player("Juan", "Giants", 1);
        Player player2 = new Player("Pedro", "Giants", 2);
        Player player3 = new Player("Maria", "Sparks", 3);
        playerList.getTeamPlayer("Giants");
        playerList.addPlayer(player);
        playerList.addPlayer(player2);
        playerList.addPlayer(player3);
        playerList.getTeamPlayer("Giants");
        playerList.sortPlayersByLevel();
        playerList.sortPlayersByPortals();
    }


    
}
