package recursoed_8210190_8210088test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import recursoed_8210190_8210088.Local;
import recursoed_8210190_8210088.Player;
public class PlayerTest {
    
    @Test
    void testGetName() {
        Player player = new Player("Player", "Giants", 1);
        assertEquals("Player", player.getName());
    }

    @Test
    void testGetLevel() {
        Player player = new Player("Player", "Giants", 1,1,99.9,100,100,0,null);
        player.gainExp(0.07);
        assertEquals(2, player.getLevel());
    }

    @Test
    void testGetId() {
        Player player = new Player("Player", "Giants", 1);
        assertEquals(1, player.getId());
    }

    @Test
    void testGetTeam() {
        Player player = new Player("Player", "Giants", 1);
        player.setTeam("lll");
        player.setTeam("Sparks");
        player.setTeam("Giants");
        assertEquals("Giants", player.getTeam());
    }

    @Test
    void testGetEnergy() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        player.loadEnergy(91);
        player.removeEnergy(101);
        assertEquals(0,player.getEnergy());
    }

    @Test
    void testGetEnergy2() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        player.loadEnergy(90);
        player.removeEnergy(1);
        assertEquals(99,player.getEnergy());
    }

    @Test
    void testGetTotalEnergy() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        assertEquals(100, player.getMaxEnergy());
    }

    @Test
    void testGetConqueredPortal() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        player.portalConquered();
        player.portalLost();
        assertEquals(0, player.getConqueredPortals());
    }

    @Test
    void testGetLocal() {
        Local local = new Local(0, 0, 0, 0);
        Local local1 = new Local(1, 1, 1, 1);
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,local);
        player.setLocal(local1);
        assertEquals(local1, player.getLocal());
    }

    @Test
    void testGetExp() {
        Player player = new Player("Player", "Giants", 1,1,98,10,100,0,null);
        player.gainExp(1);
        assertEquals(99, player.getExp());
    }
}
