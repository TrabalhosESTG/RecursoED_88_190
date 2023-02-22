package recursoed_8210190_8210088.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Player;
import recursoed_8210190_8210088.PlayerList;
import java.awt.event.ActionEvent;

/*
 * Created by JFormDesigner on Tue Feb 21 19:46:44 WET 2023
 */
public class GestaoPlayers{
	PlayerList playerList;
	JFrame contentPane= new JFrame("Gestão de jogadores");
	Map map;
	public GestaoPlayers(Map mapa) {
		map = mapa;
		playerList = map.getPlayers();
		initComponents();
	}

	/**
	* Adiciona um jogador ao mapa
	*/
	private void addPlayer(ActionEvent e) {
		if(textNomeAdd.getText().equals("")){
			new Popup("<html>Nome inválido!</html>");
			return;
		}
		if(map.getTotalLocals() == 0){
			new Popup("<html>Não existe nenhum local criado, impossível criar player</html>");
			return;
		}
		Player jogador = new Player(textNomeAdd.getText(), String.valueOf(AddCombo.getSelectedItem()), playerList.getNextID());
		map.addPlayer(jogador);
		new Popup("<html>Jogador criado! ID:" + jogador.getId() + "</html>");
	}

	/**
	* Edita um jogador do mapa
	*/
	private void editarPlayer(ActionEvent e) {
		if(textNomeEd.getText().equals("")){
			new Popup("<html>Nome inválido!</html>");
			return;
		}
		playerList.getPlayer(Integer.parseInt(String.valueOf(PlayerEdCombo.getSelectedItem()))).editPlayer(textNomeEd.getText(), String.valueOf(EdCombo.getSelectedItem()));
		new Popup("<html>Jogador editado!</html>");
	}

	/**
	* Remove um jogador do mapa
	*/
	private void removerPlayer(ActionEvent e) {
		playerList.removePlayer(playerList.getPlayer(Integer.parseInt(String.valueOf(RemoveCombo.getSelectedItem()))));
		new Popup("<html>Jogador removido</html>");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		AdicionarLabel = new JLabel();
		EditarLabel = new JLabel();
		textNomeAdd = new JTextField();
		NomeAddLabel = new JLabel();
		AddCombo = new JComboBox<>();
		EquipaAddLabel = new JLabel();
		textNomeEd = new JTextField();
		NomeEdLabel = new JLabel();
		EdCombo = new JComboBox<>();
		EquipaEdLabel = new JLabel();
		TitloLabel = new JLabel();
		AdicionarBtn = new JButton();
		EditarBtn = new JButton();
		PlayerEdCombo = new JComboBox<>();
		RemoverLabel = new JLabel();
		RemoverBtn = new JButton();
		RemoveCombo = new JComboBox<>();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();

		String[] jogadores = new String[playerList.getSize()];
		Object[][] dadosTabela = new Object [playerList.getSize()][3];
		int i = 0;
		for (Player jogador : playerList.getPlayers()) {
			jogadores[i] = String.valueOf(jogador.getId());
			dadosTabela[i][0] = jogador.getId();
			dadosTabela[i][1] = jogador.getName();
			dadosTabela[i][2] = jogador.getTeam();
			i++;
		}
		//---- AdicionarLabel ----
		AdicionarLabel.setText("Adicionar Jogador");
		AdicionarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AdicionarLabel.setFont(AdicionarLabel.getFont().deriveFont(AdicionarLabel.getFont().getSize() + 5f));
		contentPane.add(AdicionarLabel);
		AdicionarLabel.setBounds(15, 50, 195, 65);

		//---- EditarLabel ----
		EditarLabel.setText("Editar Jogador");
		EditarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EditarLabel.setFont(EditarLabel.getFont().deriveFont(EditarLabel.getFont().getSize() + 5f));
		contentPane.add(EditarLabel);
		EditarLabel.setBounds(280, 50, 195, 65);
		contentPane.add(textNomeAdd);
		textNomeAdd.setBounds(95, 140, 135, 40);

		//---- NomeAddLabel ----
		NomeAddLabel.setText("Nome:");
		NomeAddLabel.setFont(NomeAddLabel.getFont().deriveFont(NomeAddLabel.getFont().getSize()));
		contentPane.add(NomeAddLabel);
		NomeAddLabel.setBounds(10, 140, 85, 35);

		//---- AddCombo ----
		AddCombo.setModel(new DefaultComboBoxModel<>(new String[] {
			"Giants",
			"Sparks"
		}));
		contentPane.add(AddCombo);
		AddCombo.setBounds(115, 220, 105, 50);

		//---- EquipaAddLabel ----
		EquipaAddLabel.setText("Equipa");
		EquipaAddLabel.setFont(EquipaAddLabel.getFont().deriveFont(EquipaAddLabel.getFont().getSize()));
		contentPane.add(EquipaAddLabel);
		EquipaAddLabel.setBounds(10, 220, 105, 50);
		contentPane.add(textNomeEd);
		textNomeEd.setBounds(350, 160, 135, 40);

		//---- NomeEdLabel ----
		NomeEdLabel.setText("Nome:");
		NomeEdLabel.setFont(NomeEdLabel.getFont().deriveFont(NomeEdLabel.getFont().getSize()));
		contentPane.add(NomeEdLabel);
		NomeEdLabel.setBounds(265, 160, 85, 35);

		//---- EdCombo ----
		EdCombo.setModel(new DefaultComboBoxModel<>(new String[] {
			"Giants",
			"Sparks"
		}));
		contentPane.add(EdCombo);
		EdCombo.setBounds(360, 220, 105, 50);

		//---- EquipaEdLabel ----
		EquipaEdLabel.setText("Equipa");
		EquipaEdLabel.setFont(EquipaEdLabel.getFont().deriveFont(EquipaEdLabel.getFont().getSize()));
		contentPane.add(EquipaEdLabel);
		EquipaEdLabel.setBounds(270, 220, 90, 50);

		//---- TitloLabel ----
		TitloLabel.setText("Gest\u00e3o de Jogadores");
		TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
		contentPane.add(TitloLabel);
		TitloLabel.setBounds(75, 5, 355, 51);

		//---- AdicionarBtn ----
		AdicionarBtn.setText("Adicionar");
		AdicionarBtn.setFont(AdicionarBtn.getFont().deriveFont(AdicionarBtn.getFont().getSize() + 5f));
		AdicionarBtn.addActionListener(e -> addPlayer(e));
		contentPane.add(AdicionarBtn);
		AdicionarBtn.setBounds(35, 310, 180, 37);

		//---- EditarBtn ----
		EditarBtn.setText("Editar");
		EditarBtn.setFont(EditarBtn.getFont().deriveFont(EditarBtn.getFont().getSize() + 5f));
		EditarBtn.addActionListener(e -> editarPlayer(e));
		contentPane.add(EditarBtn);
		EditarBtn.setBounds(295, 310, 180, 37);

		//---- PlayerEdCombo ----
		PlayerEdCombo.setModel(new DefaultComboBoxModel<>(jogadores));
		contentPane.add(PlayerEdCombo);
		PlayerEdCombo.setBounds(280, 110, 205, 45);

		//---- RemoverLabel ----
		RemoverLabel.setText("Remover Jogador");
		RemoverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RemoverLabel.setFont(RemoverLabel.getFont().deriveFont(RemoverLabel.getFont().getSize() + 10f));
		contentPane.add(RemoverLabel);
		RemoverLabel.setBounds(140, 360, 200, 51);

		//---- RemoverBtn ----
		RemoverBtn.setText("Remover");
		RemoverBtn.setFont(RemoverBtn.getFont().deriveFont(RemoverBtn.getFont().getSize() + 5f));
		RemoverBtn.addActionListener(e -> removerPlayer(e));
		contentPane.add(RemoverBtn);
		RemoverBtn.setBounds(160, 465, 180, 40);

		//---- RemoveCombo ----
		RemoveCombo.setModel(new DefaultComboBoxModel<>(jogadores));
		contentPane.add(RemoveCombo);
		RemoveCombo.setBounds(145, 405, 205, 45);


		//======== scrollPane1 ========
		{
			//---- table1 ----
			table1.setModel(new DefaultTableModel(
				dadosTabela	,
				new String[] {
					"Id", "Nome", "Equipa"
				}
			));

			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(0, 515, 500, 210);

		contentPane.setSize(500,765);
		contentPane.setLayout(null);
		contentPane.setVisible(true);

		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel AdicionarLabel;
	private JLabel EditarLabel;
	private JTextField textNomeAdd;
	private JLabel NomeAddLabel;
	private JComboBox<String> AddCombo;
	private JLabel EquipaAddLabel;
	private JTextField textNomeEd;
	private JLabel NomeEdLabel;
	private JComboBox<String> EdCombo;
	private JLabel EquipaEdLabel;
	private JLabel TitloLabel;
	private JButton AdicionarBtn;
	private JButton EditarBtn;
	private JComboBox<String> PlayerEdCombo;
	private JLabel RemoverLabel;
	private JButton RemoverBtn;
	private JComboBox<String> RemoveCombo;
	private JScrollPane scrollPane1;
	private JTable table1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
