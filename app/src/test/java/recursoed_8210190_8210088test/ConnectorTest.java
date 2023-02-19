package recursoed_8210190_8210088test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Lists.LinkedList;
import recursoed_8210190_8210088.Connector;
import recursoed_8210190_8210088.Player;
import recursoed_8210190_8210088.TimeControl;
public class ConnectorTest {

    @Test
    void testGetId() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        assertEquals(1, connector.getId());
    }

    @Test
    void testGetLongitude() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.setLongitude(2);
        assertEquals(2, connector.getLongitude());
    }

    @Test
    void testGetLatitude() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.setLatitude(2);
        assertEquals(2, connector.getLatitude());
    }

    @Test
    void testGetEnergy() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.setEnergy(2);
        assertEquals(2, connector.getEnergy());
    }

    @Test
    void testGetCooldown() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.setCooldown(2);
        assertEquals(2, connector.getCooldown());
    }

    @Test
    void testIsMine() {
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.setMine(true);
        assertEquals(true, connector.isMine());
    }

    @Test
    void testGetTimeControl() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        LinkedList<TimeControl> timeControl = new LinkedList<TimeControl>();
        TimeControl timeControl2 = new TimeControl(player, 1);
        timeControl.add(timeControl2);
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.addTimeControl(timeControl2);
        assertEquals(timeControl.getHead().getElement(), connector.getTimeControl().getHead().getElement());
    }

    @Test
    void testLoadPlayerEnergy() {
        Player player = new Player("Player", "Giants", 1,1,99.9,10,100,0,null);
        Player player2 = new Player("Player", "Giants", 2,1,99.9,10,100,0,null);
        Connector connector = new Connector(1, 1, 1, 1,10);
        connector.loadPlayerEnergy(player);
        connector.loadPlayerEnergy(player2);
        connector.loadPlayerEnergy(player);
        connector.getTimeControl().getHead().getElement().setTime(System.currentTimeMillis() - 600000);
        connector.loadPlayerEnergy(player);
        assertEquals(12, player.getEnergy());
    }
    
}
