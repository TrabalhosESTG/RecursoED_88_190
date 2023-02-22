package recursoed_8210190_8210088;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Lists.LinkedList;
import Lists.ArrayList;
import Lists.LinearNode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import recursoed_8210190_8210088.Map;

/**
 * Classe que importa e exporta o Json
 *
 * @author David Francisco (8210088)
 * @author Guilherme Silva (8210190)
 */
public class Json {
	/**
	 * Método que experta as informações do jogo para um ficheiro JSON
	 * @param map mapa do jogo
	 * @return obj com as informações do jogo
	 */
	public JSONObject exportarJson(Map map){
		JSONObject obj = new JSONObject();

		JSONArray locais = new JSONArray();
		JSONArray jogadores = new JSONArray();
		JSONArray rotas = new JSONArray();

		//Locais
		for(Local local : map.getLocals()){
			JSONObject localJson = new JSONObject();
			JSONObject gameSettings = new JSONObject();
			localJson.put("id", local.getId());
			if(local instanceof Portal){
				Portal portal = (Portal) local;
				localJson.put("nome", portal.getName());
				localJson.put("type", "Portal");
				gameSettings.put("energy", portal.getEnergy());
				gameSettings.put("maxEnergy", portal.getMaxEnergy());
				JSONObject owner = new JSONObject();
				if(portal.getPlayer() == null){
					owner.put("player", "None");
				}else{
					owner.put("player", portal.getPlayer());
				}
				owner.put("team", portal.getTeam());
				gameSettings.put("owner", owner);
				localJson.put("gameSettings", gameSettings);
				JSONObject portalData = new JSONObject();
				JSONArray portalDataArray = new JSONArray();
				for(PortalData data : portal.getPortalData()){
					JSONObject portalDataJson = new JSONObject();
					portalDataJson.put("player", data.getPlayer());
					portalDataJson.put("action", data.getAction());
					portalDataArray.add(portalDataJson);
				}
			}else{
				Connector connector = (Connector) local;
				localJson.put("type", "Connector");
				gameSettings.put("energy", connector.getEnergy());
				gameSettings.put("cooldown", connector.getCooldown());
				localJson.put("gameSettings", gameSettings);
			}
			JSONObject coordinates = new JSONObject();
			coordinates.put("latitude", local.getLatitude());
			coordinates.put("longitude", local.getLongitude());
			localJson.put("coordinates", coordinates);
			locais.add(localJson);
		}

		//Jogadores
        LinearNode<Player> current = map.getPlayers().getList().getHead();
        while(current != null){
            JSONObject playerJson = new JSONObject();
			playerJson.put("id", current.getElement().getId());
            playerJson.put("name", current.getElement().getName());
			playerJson.put("team", current.getElement().getTeam());
			playerJson.put("level", current.getElement().getLevel());
			playerJson.put("currentEnergy", current.getElement().getEnergy());
			playerJson.put("experiencePoints", current.getElement().getExp());
			playerJson.put("local", current.getElement().getLocal().getId());
			playerJson.put("maxEnergy", current.getElement().getMaxEnergy());
			playerJson.put("conqueredPortals", current.getElement().getConqueredPortals());
			jogadores.add(playerJson);
			current = current.getNext();
		}

		//Rotas
		for(String[] rota : map.getRoutes()){
			if(rota[0] != null){
				JSONObject rotaJson = new JSONObject();
				rotaJson.put("from", rota[0]);
				rotaJson.put("to", rota[1]);
				if(rota[2].equals("Giants")){
					rotaJson.put("equipa", rota[2]);
				}else if(rota[2].equals("Sparks")){
					rotaJson.put("equipa", rota[2]);
				}else{
					rotaJson.put("peso", rota[2]);
				}
				rotas.add(rotaJson);
			}
		}

		obj.put("locals", locais);
		obj.put("players", jogadores);
		obj.put("routes", rotas);
		return obj;
	}

	/**
	 * Método que importa as informações do jogo a partir de um ficheiro JSON
	 * @param map mapa do jogo
	 * @param jsonString JSon a ser importado
	 */
	public void importarJson(Map map, String jsonString){
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject) parser.parse(jsonString);
			JSONArray locais = (JSONArray) obj.get("locals");
			JSONArray jogadores = (JSONArray) obj.get("players");
			JSONArray rotas = (JSONArray) obj.get("routes");

			//Locais
			for(Object local : locais){
				JSONObject localJson = (JSONObject) local;
				if(localJson.get("type").equals("Portal")){
					JSONObject gameSettings = (JSONObject) localJson.get("gameSettings");
					JSONObject owner = (JSONObject) gameSettings.get("owner");
					JSONArray portalData = (JSONArray) localJson.get("portalData");
					JSONObject cordenadas = (JSONObject) localJson.get("coordinates");
					LinkedList<PortalData> portalDataList = new LinkedList<PortalData>();
					if(portalData != null){
						for(Object data : portalData){
							JSONObject dataJson = (JSONObject) data;
							portalDataList.add(new PortalData(Integer.parseInt(String.valueOf(dataJson.get("player"))), String.valueOf(dataJson.get("action"))));
						}
					}
					Portal portal = new Portal(Integer.parseInt(String.valueOf(localJson.get("id"))), Double.parseDouble(String.valueOf(cordenadas.get("longitude"))), Double.parseDouble(String.valueOf(cordenadas.get("latitude"))), Double.parseDouble(String.valueOf(gameSettings.get("energy"))), String.valueOf(owner.get("team")), String.valueOf(owner.get("player")), Double.parseDouble(String.valueOf(gameSettings.get("maxEnergy"))), String.valueOf(localJson.get("nome")), portalDataList);
					map.addLocal(portal);
				}else{
					JSONObject gameSettings = (JSONObject) localJson.get("gameSettings");
					JSONObject cordenadas = (JSONObject) localJson.get("coordinates");
					Connector connector = new Connector(Integer.parseInt(String.valueOf(localJson.get("id"))),  Double.parseDouble(String.valueOf(cordenadas.get("longitude"))), Double.parseDouble(String.valueOf(cordenadas.get("latitude"))), Double.parseDouble(String.valueOf(gameSettings.get("energy"))), Integer.parseInt(String.valueOf(gameSettings.get("cooldown"))));
					map.addLocal(connector);
				}
			}

			//Jogadores
			for(Object jogador : jogadores){
				JSONObject jogadorJson = (JSONObject) jogador;
				Local local = map.getLocalByID(Integer.parseInt(String.valueOf(jogadorJson.get("local"))));
				Player player = new Player(String.valueOf(jogadorJson.get("name")),
					String.valueOf(jogadorJson.get("team")),
					Integer.parseInt(String.valueOf(jogadorJson.get("id"))),
					Integer.parseInt(String.valueOf(jogadorJson.get("level"))),
					Double.parseDouble(String.valueOf(jogadorJson.get("experiencePoints"))),
					Double.parseDouble(String.valueOf(jogadorJson.get("currentEnergy"))),
					Double.parseDouble(String.valueOf(jogadorJson.get("maxEnergy"))),
					Integer.parseInt(String.valueOf(jogadorJson.get("conqueredPortals"))),
					local);
				map.addPlayer(player);
			}

			//Rotas
			for(Object rota : rotas){
				JSONObject rotaJson = (JSONObject) rota;
				if(rotaJson.get("equipa") == "Giants"){
					map.addGiantsTunel(map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("from")))), map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("to")))));
				}else if(rotaJson.get("equipa") == "Sparks")
				{
					map.addSparksTunel(map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("from")))), map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("to")))));
				}else if(rotaJson.get("equipa") == null)
				{
					map.addConnection(map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("from")))), map.getLocalByID(Integer.parseInt(String.valueOf(rotaJson.get("to")))), Double.parseDouble(String.valueOf(rotaJson.get("peso"))));
				}
			}
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
