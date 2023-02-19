package recursoed_8210190_8210088test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import recursoed_8210190_8210088.Player;
import recursoed_8210190_8210088.Portal;
import recursoed_8210190_8210088.PortalData;
import Lists.LinkedList;
public class PortalTest {

    @Test
    void testLoadEnergy() {
        Portal portal = new Portal(1, 1, 1, 1,10, "Portal");
        portal.loadEnergy(2);
        portal.loadEnergy(10);
        assertEquals(10, portal.getEnergy());
    }

    @Test
    void testRemoveEnergy() {
        Portal portal = new Portal(1, 1, 1, 1,10, "Portal");
        portal.loadEnergy(10);
        portal.deloadEnergy(2);
        portal.deloadEnergy(10);
        assertEquals(0, portal.getEnergy());
    }

    @Test
    void testGetPortalData(){
        Player player1 = new Player("Player1", "Giants", 1,1,99.9,10,100,0,null);
        LinkedList<PortalData> portalData = new LinkedList<PortalData>();
        portalData.add(new PortalData(player1, "Conquered the portal"));
        Portal portal = new Portal(1, 1, 1, 1, "Giants", player1, 10, "Portal", portalData);
        portalData.getHead().getElement().getPlayer();
        assertEquals(portalData.getHead().getElement().getAction(), portal.getPortalData().getHead().getElement().getAction());
    }

    @Test
    void testGetName(){
        Portal portal = new Portal(1, 1, 1, 1, 10, "Portal");
        portal.setName("Portals");
        assertEquals("Portals", portal.getName());
    }

    @Test
    void testGetTeam(){
        Portal portal = new Portal(1, 1, 1, 1, 10, "Portal");
        portal.setTeam("Giants");
        assertEquals("Giants", portal.getTeam());
    }

    @Test
    void testGetPlayer(){
        Player player1 = new Player("Player1", "Giants", 1,1,99.9,10,100,0,null);
        Portal portal = new Portal(1, 1, 1, 1, "Giants", player1, 10, "Portal", null);
        assertEquals(player1, portal.getPlayer());
    }

    @Test
    void testGetMaxEnergy(){
        Portal portal = new Portal(1, 1, 1, 1, 10, "Portal");
        portal.setMaxEnergy(11);
        assertEquals(11, portal.getMaxEnergy());
    }

    @Test
    void testConquer(){
        Player player1 = new Player("Player1", "Giants", 1,1,99.9,10,100,1,null);
        Player player2 = new Player("Player2", "Giants", 2,1,99.9,10,100,0,null);
        Portal portal = new Portal(1, 1, 1, 1, 10, "Portal");    
        portal.conquer(player2);
        assertEquals(player2, portal.getPlayer());
    }

    @Test
    void testFortifyPortal(){
        Player player1 = new Player("Player1", "Giants", 1,1,99.9,10,100,1,null);
        Player player2 = new Player("Player2", "Giants", 2,1,99.9,10,100,0,null);
        Portal portal = new Portal(1, 1, 1, 1, 100, "Portal");        
        portal.fortifyPortal(player2, 20);
        portal.setEnergy(100);
        portal.fortifyPortal(player2, 2);
        portal.setEnergy(10);
        portal.fortifyPortal(player2, 2);
        assertEquals(12, portal.getEnergy());

    }

    @Test
    void testAttackPortal(){
        Player player1 = new Player("Player1", "Giants", 1,1,99.9,10,100,1,null);
        Player player2 = new Player("Player2", "Giants", 2,1,99.9,10,100,0,null);
        Portal portal = new Portal(1, 1, 1, 1, 10, "Portal");
        portal.conquer(player2);
        portal.attackPortal(player2, 2);
        portal.setEnergy(0);
        portal.attackPortal(player2, 2);
        portal.setEnergy(10);
        portal.attackPortal(player2, 11);
        player2.loadEnergy(80);
        portal.attackPortal(player2, 50);
        assertEquals(0, portal.getEnergy());
    }

    @Test
    void testConquerPortal(){
        Player player2 = new Player("Player2", "Sparks", 2,1,99.9,10,100,0,null);
        Portal portal = new Portal(1, 1, 1, 0, 100, "Portal");
        portal.conquerPortal(player2, 2);
        portal.conquerPortal(player2, 50);
        player2.loadEnergy(80);
        portal.conquerPortal(player2, 50);
        assertEquals("Sparks", portal.getTeam());
    }
}
