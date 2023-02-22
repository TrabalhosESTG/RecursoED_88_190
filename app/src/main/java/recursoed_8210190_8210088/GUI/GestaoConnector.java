package recursoed_8210190_8210088.GUI;

import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Feb 22 16:47:41 WET 2023
 */

import recursoed_8210190_8210088.Connector;
import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Player;



/**
 * @author David Francisco
 */
public class GestaoConnector {
	JFrame contentPane= new JFrame("Connector");
	Map map;
	Connector connector;
	int idPlayer  = -1;
	public GestaoConnector(Map mapa, Connector connectorA, int jogador) {
		map = mapa;
		connector = connectorA;
		idPlayer = jogador;
		initComponents();
	}

    /**
    * Carrega a energia do jogador
    */
	private void carregarEnergia(ActionEvent e) {
		Player player = map.getPlayers().getPlayer(idPlayer);
		Boolean sucesso = connector.loadPlayerEnergy(player);
		if(sucesso == true){
			new Popup("Energia carregada");
		}else{
			new Popup("<html>Energia não carregada. <br> O tempo de cooldown ainda não acabou</html>");
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		ConnectorLabel = new JLabel();
		EnergiaConnectorlabel = new JLabel();
		TitloLabel = new JLabel();
		labelEnergiaConnector = new JLabel();
		AddEnergyBtn = new JButton();
		Cooldownlabel = new JLabel();
		PlayerEnergylabel = new JLabel();
		labelCooldown = new JLabel();
		labelPlayerEnergy = new JLabel();

		//======== this2 ========
		{

			//---- ConnectorLabel ----
			ConnectorLabel.setText("Connector");
			ConnectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ConnectorLabel.setFont(ConnectorLabel.getFont().deriveFont(ConnectorLabel.getFont().getSize() + 10f));
			contentPane.add(ConnectorLabel);
			ConnectorLabel.setBounds(90, 50, 195, 65);

			//---- EnergiaConnectorlabel ----
			EnergiaConnectorlabel.setText("Energia do Connector");
			EnergiaConnectorlabel.setHorizontalAlignment(SwingConstants.CENTER);
			EnergiaConnectorlabel.setFont(EnergiaConnectorlabel.getFont().deriveFont(EnergiaConnectorlabel.getFont().getSize() + 5f));
			contentPane.add(EnergiaConnectorlabel);
			EnergiaConnectorlabel.setBounds(0, 145, 175, 40);

			//---- TitloLabel ----
			TitloLabel.setText("Gest\u00e3o de Jogo");
			TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
			contentPane.add(TitloLabel);
			TitloLabel.setBounds(5, 5, 355, 51);

			//---- labelEnergiaConnector ----
			labelEnergiaConnector.setText(String.valueOf(connector.getEnergy()));
			contentPane.add(labelEnergiaConnector);
			labelEnergiaConnector.setBounds(250, 145, 80, 40);

			//---- AddEnergyBtn ----
			AddEnergyBtn.setText("Carregar Energia");
			AddEnergyBtn.setFont(AddEnergyBtn.getFont().deriveFont(AddEnergyBtn.getFont().getSize() + 5f));
			AddEnergyBtn.addActionListener(e -> carregarEnergia(e));
			contentPane.add(AddEnergyBtn);
			AddEnergyBtn.setBounds(90, 275, 180, 37);

			//---- Cooldownlabel ----
			Cooldownlabel.setText("Tempo de cooldown restante");
			Cooldownlabel.setHorizontalAlignment(SwingConstants.CENTER);
			Cooldownlabel.setFont(Cooldownlabel.getFont().deriveFont(Cooldownlabel.getFont().getSize() + 5f));
			contentPane.add(Cooldownlabel);
			Cooldownlabel.setBounds(0, 185, 230, 40);

			//---- PlayerEnergylabel ----
			PlayerEnergylabel.setText("A sua energia \u00e9");
			PlayerEnergylabel.setFont(PlayerEnergylabel.getFont().deriveFont(PlayerEnergylabel.getFont().getSize() + 5f));
			PlayerEnergylabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(PlayerEnergylabel);
			PlayerEnergylabel.setBounds(0, 225, 155, 40);

			//---- labelCooldown ----
			labelCooldown.setText(String.valueOf(connector.getTimeLeft(map.getPlayers().getPlayer(idPlayer))));
			contentPane.add(labelCooldown);
			labelCooldown.setBounds(250, 185, 80, 40);

			//---- labelPlayerEnergy ----
			labelPlayerEnergy.setText(String.valueOf(map.getPlayers().getPlayer(idPlayer).getEnergy()));
			contentPane.add(labelPlayerEnergy);
			labelPlayerEnergy.setBounds(250, 225, 80, 40);

			contentPane.setSize(500,765);
			contentPane.setLayout(null);
			contentPane.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel ConnectorLabel;
	private JLabel EnergiaConnectorlabel;
	private JLabel TitloLabel;
	private JLabel labelEnergiaConnector;
	private JButton AddEnergyBtn;
	private JLabel Cooldownlabel;
	private JLabel PlayerEnergylabel;
	private JLabel labelCooldown;
	private JLabel labelPlayerEnergy;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
