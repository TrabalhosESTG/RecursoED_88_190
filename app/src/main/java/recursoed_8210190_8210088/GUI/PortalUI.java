package recursoed_8210190_8210088.GUI;

import java.awt.event.*;
import javax.swing.*;

import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Portal;

/*
 * Created by JFormDesigner on Wed Feb 22 16:55:09 WET 2023
 */



/**
 * @author David Francisco
 */
public class PortalUI  {
	JFrame contentPane= new JFrame("Gestão de jogadores");
	Map map;
	Portal portal;
	int idPlayer  = -1;
	public PortalUI(Map mapa, Portal portalA, int jogador) {
		map = mapa;
		portal = portalA;
		idPlayer = jogador;
		initComponents();
	}

	/**
	* Ataca o portal
	*/
	private void atacarPortal(ActionEvent e) {
		map.attackPortal(map.getPlayers().getPlayer(idPlayer), Integer.parseInt(EnergyField.getText()));
	}

	/**
	* Fortalece o portal
	*/
	private void fortalecerPortal(ActionEvent e) {
		portal.fortifyPortal(map.getPlayers().getPlayer(idPlayer), Integer.parseInt(EnergyField.getText()));
	}

	/**
	* Conquista o portal
	*/
	private void conquistarPortal(ActionEvent e) {
		portal.conquerPortal(map.getPlayers().getPlayer(idPlayer), Integer.parseInt(EnergyField.getText()));
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		ConnectorLabel = new JLabel();
		EnergiaPortallabel = new JLabel();
		TitloLabel = new JLabel();
		labelEnergiaPortal = new JLabel();
		AtacarBtn = new JButton();
		EquipaLabel = new JLabel();
		DonoLabel = new JLabel();
		labelEquipa = new JLabel();
		labelDono = new JLabel();
		FortalecerBtn = new JButton();
		ConquistarBtn = new JButton();
		PlayerEnergylabel = new JLabel();
		labelPlayerEnergy = new JLabel();
		EnergyTolabel = new JLabel();
		EnergyField = new JTextField();


		{
			//---- ConnectorLabel ----
			ConnectorLabel.setText("Portal");
			ConnectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ConnectorLabel.setFont(ConnectorLabel.getFont().deriveFont(ConnectorLabel.getFont().getSize() + 10f));
			contentPane.add(ConnectorLabel);
			ConnectorLabel.setBounds(165, 50, 195, 65);

			//---- EnergiaPortallabel ----
			EnergiaPortallabel.setText("Energia do Portal");
			EnergiaPortallabel.setHorizontalAlignment(SwingConstants.CENTER);
			EnergiaPortallabel.setFont(EnergiaPortallabel.getFont().deriveFont(EnergiaPortallabel.getFont().getSize() + 5f));
			contentPane.add(EnergiaPortallabel);
			EnergiaPortallabel.setBounds(0, 145, 230, 40);

			//---- TitloLabel ----
			TitloLabel.setText("Gest\u00e3o de Jogo");
			TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
			contentPane.add(TitloLabel);
			TitloLabel.setBounds(85, 5, 355, 51);

			//---- labelEnergiaPortal ----
			labelEnergiaPortal.setText(String.valueOf(portal.getEnergy()));
			contentPane.add(labelEnergiaPortal);
			labelEnergiaPortal.setBounds(350, 140, 80, 40);

			//---- AtacarBtn ----
			AtacarBtn.setText("Atacar Portal");
			AtacarBtn.setFont(AtacarBtn.getFont().deriveFont(AtacarBtn.getFont().getSize() + 5f));
			AtacarBtn.addActionListener(e -> atacarPortal(e));
			contentPane.add(AtacarBtn);
			AtacarBtn.setBounds(30, 375, 180, 37);


			//---- EquipaLabel ----
			EquipaLabel.setText("Equipa");
			EquipaLabel.setHorizontalAlignment(SwingConstants.CENTER);
			EquipaLabel.setFont(EquipaLabel.getFont().deriveFont(EquipaLabel.getFont().getSize() + 5f));
			contentPane.add(EquipaLabel);
			EquipaLabel.setBounds(0, 185, 230, 40);

			//---- DonoLabel ----
			DonoLabel.setText("Dono do Portal");
			DonoLabel.setFont(DonoLabel.getFont().deriveFont(DonoLabel.getFont().getSize() + 5f));
			DonoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(DonoLabel);
			DonoLabel.setBounds(0, 225, 230, 40);

			//---- labelEquipa ----
			labelEquipa.setText(String.valueOf(portal.getTeam()));
			contentPane.add(labelEquipa);
			labelEquipa.setBounds(350, 180, 80, 40);

			//---- labelDono ----
			labelDono.setText(String.valueOf(portal.getPlayer()));
			contentPane.add(labelDono);
			labelDono.setBounds(350, 220, 80, 40);

			//---- FortalecerBtn ----
			FortalecerBtn.setText("Fortalecer Portal");
			FortalecerBtn.setFont(FortalecerBtn.getFont().deriveFont(FortalecerBtn.getFont().getSize() + 5f));
			FortalecerBtn.addActionListener(e -> fortalecerPortal(e));
			contentPane.add(FortalecerBtn);
			FortalecerBtn.setBounds(270, 375, 180, 37);

			//---- ConquistarBtn ----
			ConquistarBtn.setText("Conquistar Portal");
			ConquistarBtn.setFont(ConquistarBtn.getFont().deriveFont(ConquistarBtn.getFont().getSize() + 5f));
			ConquistarBtn.addActionListener(e -> conquistarPortal(e));
			contentPane.add(ConquistarBtn);
			ConquistarBtn.setBounds(145, 430, 205, 37);

			//---- PlayerEnergylabel ----
			PlayerEnergylabel.setText("A sua energia \u00e9:");
			PlayerEnergylabel.setFont(PlayerEnergylabel.getFont().deriveFont(PlayerEnergylabel.getFont().getSize() + 5f));
			PlayerEnergylabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(PlayerEnergylabel);
			PlayerEnergylabel.setBounds(0, 265, 230, 40);

			//---- labelPlayerEnergy ----
			labelPlayerEnergy.setText(String.valueOf(map.getPlayers().getPlayer(idPlayer).getEnergy()));
			contentPane.add(labelPlayerEnergy);
			labelPlayerEnergy.setBounds(350, 260, 80, 40);

			//---- EnergyTolabel ----
			EnergyTolabel.setText("Energia para atacar/conquistar/fortalecer");
			EnergyTolabel.setFont(EnergyTolabel.getFont().deriveFont(EnergyTolabel.getFont().getSize() + 5f));
			EnergyTolabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(EnergyTolabel);
			EnergyTolabel.setBounds(0, 315, 325, 40);
			contentPane.add(EnergyField);
			EnergyField.setBounds(335, 315, 135, 40);

			contentPane.setSize(500,765);
			contentPane.setLayout(null);
			contentPane.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel ConnectorLabel;
	private JLabel EnergiaPortallabel;
	private JLabel TitloLabel;
	private JLabel labelEnergiaPortal;
	private JButton AtacarBtn;
	private JLabel EquipaLabel;
	private JLabel DonoLabel;
	private JLabel labelEquipa;
	private JLabel labelDono;
	private JButton FortalecerBtn;
	private JButton ConquistarBtn;
	private JLabel PlayerEnergylabel;
	private JLabel labelPlayerEnergy;
	private JLabel EnergyTolabel;
	private JTextField EnergyField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
