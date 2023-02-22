package recursoed_8210190_8210088.GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Wed Feb 22 00:21:42 WET 2023
 */

import recursoed_8210190_8210088.Local;
import recursoed_8210190_8210088.Map;



/**
 * @author David Francisco
 */
public class GestaoRotas {
	public JFrame contentPane= new JFrame("Gestão de Rotas");
	Map map;
	public GestaoRotas(Map mapa) {
		map = mapa;
		initComponents();
	}

	/**
	* Adiciona uma rota ao mapa
	*/
	private void Adicionar(ActionEvent e) {
		String de = (String) DeCombo.getSelectedItem();
		String para = (String) ParaCombo.getSelectedItem();
		String valor = (String) textPesoAdd.getText();
		String tipo = (String) ValorCombo.getSelectedItem();
		if(tipo.equals("Global") && !valor.equals(""))
			map.addConnection(map.getLocalByID(Integer.parseInt(de)), map.getLocalByID(Integer.parseInt(para)), Double.parseDouble(valor));
		else if(tipo.equals("Tunel Giants"))
			map.addGiantsTunel(map.getLocalByID(Integer.parseInt(de)), map.getLocalByID(Integer.parseInt(para)));
		else if(tipo.equals("Tunel Sparks"))
			map.addSparksTunel(map.getLocalByID(Integer.parseInt(de)), map.getLocalByID(Integer.parseInt(para)));
		else
			new Popup("O valor do peso não pode ser vazio");
	}

	private void initComponents() {
	// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		AdicionarLabel = new JLabel();
		DeCombo = new JComboBox<>();
		ParaCombo = new JComboBox<>();
		Delabel = new JLabel();
		ParaLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		AdicionarBtn = new JButton();
		TitloLabel = new JLabel();
		ValorCombo = new JComboBox<>();
		tipoLabel = new JLabel();
		PesoLabel = new JLabel();
		textPesoAdd = new JTextField();

		//---- AdicionarLabel ----
		AdicionarLabel.setText("Adicionar Rota");
		AdicionarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AdicionarLabel.setFont(AdicionarLabel.getFont().deriveFont(AdicionarLabel.getFont().getSize() + 10f));
		contentPane.add(AdicionarLabel);
		AdicionarLabel.setBounds(130, 45, 195, 65);

		String[] locais = new String[map.getLocals().size()];
		int i = 0;
		for (Local local : map.getLocals()) {
			locais[i] = String.valueOf(local.getId());
			i++;
		}
		Object[][] dadosTabela = map.getRoutes();

		//---- DeCombo ----
		DeCombo.setModel(new DefaultComboBoxModel<>(locais));
		contentPane.add(DeCombo);
		DeCombo.setBounds(55, 145, 110, 45);

		//---- ParaCombo ----
		ParaCombo.setModel(new DefaultComboBoxModel<>(locais));
		contentPane.add(ParaCombo);
		ParaCombo.setBounds(215, 145, 110, 45);

		//---- Delabel ----
		Delabel.setText("De:");
		Delabel.setHorizontalAlignment(SwingConstants.CENTER);
		Delabel.setFont(Delabel.getFont().deriveFont(Delabel.getFont().getSize() + 5f));
		contentPane.add(Delabel);
		Delabel.setBounds(0, 145, 65, 40);

		//---- ParaLabel ----
		ParaLabel.setText("Para");
		ParaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ParaLabel.setFont(ParaLabel.getFont().deriveFont(ParaLabel.getFont().getSize() + 5f));
		contentPane.add(ParaLabel);
		ParaLabel.setBounds(165, 145, 65, 40);

		//======== scrollPane1 ========
		{

			//---- table1 ----
			table1.setModel(new DefaultTableModel(
				dadosTabela,
				new String[] {
					"De", "Para", "Peso"
				}
			));
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(0, 255, 505, 220);

		//---- AdicionarBtn ----
		AdicionarBtn.setText("Adicionar");
		AdicionarBtn.setFont(AdicionarBtn.getFont().deriveFont(AdicionarBtn.getFont().getSize() + 5f));
		AdicionarBtn.addActionListener(e -> Adicionar(e));
		contentPane.add(AdicionarBtn);
		AdicionarBtn.setBounds(130, 205, 180, 37);

		//---- TitloLabel ----
		TitloLabel.setText("Gest\u00e3o de Rotas");
		TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
		contentPane.add(TitloLabel);
		TitloLabel.setBounds(45, 5, 355, 51);

		//---- ValorCombo ----
		ValorCombo.setModel(new DefaultComboBoxModel<>(new String[] {
			"Global",
			"Tunel Giants",
			"Tunel Sparks"
		}));
		contentPane.add(ValorCombo);
		ValorCombo.setBounds(135, 105, 210, 30);

		//---- tipoLabel ----
		tipoLabel.setText("Tipo de rota");
		tipoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tipoLabel.setFont(tipoLabel.getFont().deriveFont(tipoLabel.getFont().getSize() + 5f));
		contentPane.add(tipoLabel);
		tipoLabel.setBounds(10, 105, 110, 25);

		//---- PesoLabel ----
		PesoLabel.setText("Peso");
		PesoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PesoLabel.setFont(PesoLabel.getFont().deriveFont(PesoLabel.getFont().getSize() + 5f));
		contentPane.add(PesoLabel);
		PesoLabel.setBounds(325, 145, 65, 40);
		contentPane.add(textPesoAdd);
		textPesoAdd.setBounds(375, 145, 125, 40);

		contentPane.setSize(590,810);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel AdicionarLabel;
	private JComboBox<String> DeCombo;
	private JComboBox<String> ParaCombo;
	private JLabel Delabel;
	private JLabel ParaLabel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton AdicionarBtn;
	private JLabel TitloLabel;
	private JComboBox<String> ValorCombo;
	private JLabel tipoLabel;
	private JLabel PesoLabel;
	private JTextField textPesoAdd;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
