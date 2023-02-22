package recursoed_8210190_8210088.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Feb 22 15:19:12 WET 2023
 */

import recursoed_8210190_8210088.Connector;
import recursoed_8210190_8210088.Local;
import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Player;
import recursoed_8210190_8210088.Portal;



/**
 * @author guilherme
 */
public class GestaoJogo{
	public JFrame contentPane= new JFrame("Gestão de Jogo");
	Map map;
	int idPlayer  = -1;
	int localAtual = -1;
	public GestaoJogo(Map mapa) {
		map = mapa;
		initComponents();
	}

	/**
	* Seleciona o jogador e atualiza a informação
	*/
	private void comboSelectJogador(ActionEvent e) {
		if(comboSelectJogador.getSelectedItem() == null)
			return;
		idPlayer = Integer.parseInt(String.valueOf(comboSelectJogador.getSelectedItem()));
		Player jogador = map.getPlayers().getPlayer(idPlayer);
		labelLocalizacao.setText(String.valueOf(jogador.getLocal().getId()));
		updateInfo();
	}

	/**
	* Acede ao local do jogador
	*/
	private void aceder(ActionEvent e) {
		if(map.getPlayers().getPlayer(idPlayer).getLocal() instanceof Connector){
			Connector connector = (Connector) map.getPlayers().getPlayer(idPlayer).getLocal();
			new ConectorUI(map, connector, idPlayer);
		}
		else if(map.getPlayers().getPlayer(idPlayer).getLocal() instanceof Portal){
			Portal portal = (Portal) map.getPlayers().getPlayer(idPlayer).getLocal();
			new PortalUI(map, portal, idPlayer);
		}
		else{
			new Popup("Local não reconhecido");
		}
	}

	/**
	* Faz update da informação do jogador
	*/
	private void updateInfo() {
		idPlayer = Integer.parseInt(String.valueOf(comboSelectJogador.getSelectedItem()));
		Player jogador = map.getPlayers().getPlayer(idPlayer);
		labelLocalizacao.setText(String.valueOf(jogador.getLocal().getId()));
		localAtual = jogador.getLocal().getId();
		atualizarPara();
		updatePlayers();
	}

	/**
	* Atualiza a lista de locais para onde o jogador pode se mover
	*/
	private void atualizarPara(){
		comboMover.removeAllItems();
		for (int local : map.nextLocation(map.getPlayers().getPlayer(idPlayer))) {
			comboMover.addItem(String.valueOf(local));
		}
	}

	/**
	* Move o jogador para o local selecionado
	*/
	private void mover(ActionEvent e) {
		Local local = map.getLocalByID(Integer.parseInt(comboMover.getSelectedItem().toString()));
		map.getPlayers().getPlayer(idPlayer).setLocal(local);
		localAtual = local.getId();
		updateInfo();
	}

	/**
	* Atualiza a lista de jogadores
	*/
	private void updatePlayers()
	{
		comboSelectJogador.removeAllItems();
		for (Player player : map.getPlayers().getPlayers()) {
			comboSelectJogador.addItem(String.valueOf(player.getId()));
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		label1 = new JLabel();
		comboSelectJogador = new JComboBox<String>();
		label2 = new JLabel();
		label3 = new JLabel();
		labelLocalizacao = new JLabel();
		buttonAceder = new JButton();
		label4 = new JLabel();
		comboMover = new JComboBox<String>();
		buttonMover = new JButton();


		updatePlayers();
		//---- label1 ----
		label1.setText("JOGO");
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(230, 30), label1.getPreferredSize()));

		//---- comboSelectJogador ----
		comboSelectJogador.addActionListener(e -> comboSelectJogador(e));
		contentPane.add(comboSelectJogador);
		comboSelectJogador.setBounds(165, 80, 165, comboSelectJogador.getPreferredSize().height);

		//---- label2 ----
		label2.setText("Selecione o jogador:");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(185, 60), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Localiza\u00e7\u00e3o atual:");
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(335, 120), label3.getPreferredSize()));

		//---- labelLocalizacao ----
		labelLocalizacao.setText("Localiza\u00e7ao");
		contentPane.add(labelLocalizacao);
		labelLocalizacao.setBounds(new Rectangle(new Point(355, 150), labelLocalizacao.getPreferredSize()));

		//---- buttonAceder ----
		buttonAceder.setText("Aceder a localiza\u00e7\u00e3o");
		buttonAceder.addActionListener(e -> aceder(e));
		contentPane.add(buttonAceder);
		buttonAceder.setBounds(new Rectangle(new Point(315, 180), buttonAceder.getPreferredSize()));

		//---- label4 ----
		label4.setText("Mover para:");
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(65, 120), label4.getPreferredSize()));

		//---- comboMover ----
		contentPane.add(comboMover);
		comboMover.setBounds(55, 150, 100, comboMover.getPreferredSize().height);

		//---- buttonMover ----
		buttonMover.setText("Mover");
		buttonMover.addActionListener(e -> mover(e));
		contentPane.add(buttonMover);
		buttonMover.setBounds(20, 180, 165, 24);

		contentPane.setSize(500,280);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		updateInfo();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel label1;
	private JComboBox<String> comboSelectJogador;
	private JLabel label2;
	private JLabel label3;
	private JLabel labelLocalizacao;
	private JButton buttonAceder;
	private JLabel label4;
	private JComboBox<String> comboMover;
	private JButton buttonMover;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
