package recursoed_8210190_8210088.GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Tue Feb 21 21:39:58 WET 2023
 */

import recursoed_8210190_8210088.Connector;
import recursoed_8210190_8210088.Map;



/**
 * @author David Francisco
 */
public class GestaoConector  {
	JFrame contentPane= new JFrame("Gestão de jogadores");
	Map map;
	public GestaoConector(Map mapa){
		map = mapa;
		initComponents();
	}

	/**
	* Adiciona um conector ao mapa
	*/
	private void Adicionar(ActionEvent e) {
		if(textCooldownAdd.getText().equals("")|| textLatitudeAdd.getText().equals("")|| textLongitudeAdd.getText().equals("")|| textEnergiaAdd.getText().equals("")){
			new Popup("<html>Preencha todos os campos!</html>");
			return;
		}else if(!textCooldownAdd.getText().matches("[0-9]+") || !textLatitudeAdd.getText().matches("-?[0-9]+(\\.[0-9]+)?") || !textLongitudeAdd.getText().matches("-?[0-9]+(\\.[0-9]+)?") || !textEnergiaAdd.getText().matches("[0-9]+(\\.[0-9]+)?")){
			new Popup("<html>Os campos Latitude, Longitude e Max Energy devem ser números e energia máxima deve ser positiva!</html>");
			return;
		}
		Connector Connector = new Connector(map.getNextId(), Double.parseDouble(textLongitudeAdd.getText()), Double.parseDouble(textLatitudeAdd.getText()), Double.parseDouble(textEnergiaAdd.getText()), Integer.parseInt(textCooldownAdd.getText()));
		map.addLocal(Connector);
		new Popup("<html>Conector adicionado com sucesso!</html>");
	}

	/**
	* Edita um conector do mapa
	*/
	private void Editar(ActionEvent e) {
		if((!textCooldownEd.getText().matches("[0-9]+") && !textCooldownEd.getText().equals("")) ||
		 (!textLatitudeEd.getText().matches("-?[0-9]+(\\.[0-9]+)?") && !textLatitudeEd.getText().equals("")) ||
		 (!textLongitudeEd.getText().matches("-?[0-9]+(\\.[0-9]+)?") && !textLongitudeEd.getText().equals("")) ||
		 (!textEnergiaEd.getText().matches("[0-9]+(\\.[0-9]+)?") && !textEnergiaEd.getText().equals(""))){
			new Popup("<html>Os campos Colldown, Latitude, Longitude e Max Energy devem ser números e energia máxima deve ser positiva!</html>");
			return;
		}
		if( map.getLocalByID(Integer.parseInt(String.valueOf(EdCombo.getSelectedItem()))) instanceof Connector){
			Connector connector = (Connector) map.getLocalByID(Integer.parseInt(String.valueOf(EdCombo.getSelectedItem())));
			if(!textCooldownEd.getText().equals("")) connector.setCooldown(Integer.parseInt(textCooldownEd.getText()));
			if(!textLatitudeEd.getText().equals("")) connector.setLatitude(Double.parseDouble(textLatitudeEd.getText()));
			if(!textLongitudeEd.getText().equals("")) connector.setLongitude(Double.parseDouble(textLongitudeEd.getText()));
			if(!textEnergiaEd.getText().equals("")) connector.setEnergy(Double.parseDouble(textEnergiaEd.getText()));
			new Popup("<html>Conector editado com sucesso!</html>");
		}
	}

	/**
	* Remove um conector do mapa
	*/
	private void Remover(ActionEvent e) {
		map.removeLocal(map.getLocalByID(Integer.parseInt(String.valueOf(RemoveCombo.getSelectedItem()))));
		new Popup("<html>Connector removido com sucesso!</html>");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		AdicionarLabel = new JLabel();
		EditarLabel = new JLabel();
		textCooldownAdd = new JTextField();
		CooldownAddLabel = new JLabel();
		TitloLabel = new JLabel();
		AdicionarBtn = new JButton();
		EditarBtn = new JButton();
		RemoverLabel = new JLabel();
		RemoverBtn = new JButton();
		EdCombo = new JComboBox<>();
		LongitudeAddLabel = new JLabel();
		LatitudeAddLabel = new JLabel();
		MaxEnergyAddLabel = new JLabel();
		textLongitudeAdd = new JTextField();
		textLatitudeAdd = new JTextField();
		textEnergiaAdd = new JTextField();
		textCooldownEd = new JTextField();
		textLongitudeEd = new JTextField();
		textLatitudeEd = new JTextField();
		textEnergiaEd = new JTextField();
		MaxEnergyEdLabel = new JLabel();
		LatitudeEdLabel = new JLabel();
		LongitudeEdLabel = new JLabel();
		CooldownEdLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		RemoveCombo = new JComboBox<>();

		String[] conectores = new String[map.getConnectors().size()];
		Object[][] dadosTabela = new Object [map.getConnectors().size()][3];
		int i = 0;
		for (Connector conector : map.getConnectors()) {
			conectores[i] = String.valueOf(conector.getId());
			dadosTabela[i][0] = conector.getId();
			dadosTabela[i][1] = conector.getLatitude() + " - " + conector.getLongitude();
			dadosTabela[i][2] = conector.getCooldown();
			i++;
		}
		//======== Portal ========
		{
			//---- AdicionarLabel ----
			AdicionarLabel.setText("Adicionar Conector");
			AdicionarLabel.setHorizontalAlignment(SwingConstants.CENTER);
			AdicionarLabel.setFont(AdicionarLabel.getFont().deriveFont(AdicionarLabel.getFont().getSize() + 10f));
			contentPane.add(AdicionarLabel);
			AdicionarLabel.setBounds(35, 60, 195, 65);

			//---- EditarLabel ----
			EditarLabel.setText("Editar Conector");
			EditarLabel.setHorizontalAlignment(SwingConstants.CENTER);
			EditarLabel.setFont(EditarLabel.getFont().deriveFont(EditarLabel.getFont().getSize() + 10f));
			contentPane.add(EditarLabel);
			EditarLabel.setBounds(330, 55, 195, 65);
			contentPane.add(textCooldownAdd);
			textCooldownAdd.setBounds(135, 150, 135, 35);

			//---- CooldownAddLabel ----
			CooldownAddLabel.setText("Cooldown");
			CooldownAddLabel.setFont(CooldownAddLabel.getFont().deriveFont(CooldownAddLabel.getFont().getSize() + 5f));
			contentPane.add(CooldownAddLabel);
			CooldownAddLabel.setBounds(10, 150, 125, 35);

			//---- TitloLabel ----
			TitloLabel.setText("Gest\u00e3o de Conectores");
			TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
			contentPane.add(TitloLabel);
			TitloLabel.setBounds(125, 5, 355, 51);

			//---- AdicionarBtn ----
			AdicionarBtn.setText("Adicionar");
			AdicionarBtn.setFont(AdicionarBtn.getFont().deriveFont(AdicionarBtn.getFont().getSize() + 5f));
			AdicionarBtn.addActionListener(e -> Adicionar(e));
			contentPane.add(AdicionarBtn);
			AdicionarBtn.setBounds(60, 330, 180, 37);

			//---- EditarBtn ----
			EditarBtn.setText("Editar");
			EditarBtn.setFont(EditarBtn.getFont().deriveFont(EditarBtn.getFont().getSize() + 5f));
			EditarBtn.addActionListener(e -> Editar(e));
			contentPane.add(EditarBtn);
			EditarBtn.setBounds(360, 330, 180, 37);

			//---- RemoverLabel ----
			RemoverLabel.setText("Remover Conector");
			RemoverLabel.setHorizontalAlignment(SwingConstants.CENTER);
			RemoverLabel.setFont(RemoverLabel.getFont().deriveFont(RemoverLabel.getFont().getSize() + 10f));
			contentPane.add(RemoverLabel);
			RemoverLabel.setBounds(200, 395, 200, 51);

			//---- RemoverBtn ----
			RemoverBtn.setText("Remover");
			RemoverBtn.setFont(RemoverBtn.getFont().deriveFont(RemoverBtn.getFont().getSize() + 5f));
			RemoverBtn.addActionListener(e -> Remover(e));
			contentPane.add(RemoverBtn);
			RemoverBtn.setBounds(215, 520, 180, 40);

			//---- EdCombo ----
			EdCombo.setModel(new DefaultComboBoxModel<>(conectores));
			contentPane.add(EdCombo);
			EdCombo.setBounds(360, 105, 205, 45);

			//---- LongitudeAddLabel ----
			LongitudeAddLabel.setText("Longitude");
			LongitudeAddLabel.setFont(LongitudeAddLabel.getFont().deriveFont(LongitudeAddLabel.getFont().getSize() + 5f));
			contentPane.add(LongitudeAddLabel);
			LongitudeAddLabel.setBounds(10, 190, 125, 35);

			//---- LatitudeAddLabel ----
			LatitudeAddLabel.setText("Latitude");
			LatitudeAddLabel.setFont(LatitudeAddLabel.getFont().deriveFont(LatitudeAddLabel.getFont().getSize() + 5f));
			contentPane.add(LatitudeAddLabel);
			LatitudeAddLabel.setBounds(10, 230, 125, 35);

			//---- MaxEnergyAddLabel ----
			MaxEnergyAddLabel.setText("Energia ");
			MaxEnergyAddLabel.setFont(MaxEnergyAddLabel.getFont().deriveFont(MaxEnergyAddLabel.getFont().getSize() + 5f));
			contentPane.add(MaxEnergyAddLabel);
			MaxEnergyAddLabel.setBounds(10, 270, 125, 35);
			contentPane.add(textLongitudeAdd);
			textLongitudeAdd.setBounds(135, 190, 135, 35);
			contentPane.add(textLatitudeAdd);
			textLatitudeAdd.setBounds(135, 230, 135, 35);
			contentPane.add(textEnergiaAdd);
			textEnergiaAdd.setBounds(135, 270, 135, 35);
			contentPane.add(textCooldownEd);
			textCooldownEd.setBounds(430, 150, 135, 35);
			contentPane.add(textLongitudeEd);
			textLongitudeEd.setBounds(430, 190, 135, 35);
			contentPane.add(textLatitudeEd);
			textLatitudeEd.setBounds(430, 230, 135, 35);
			contentPane.add(textEnergiaEd);
			textEnergiaEd.setBounds(430, 270, 135, 35);

			//---- MaxEnergyEdLabel ----
			MaxEnergyEdLabel.setText("Energia ");
			MaxEnergyEdLabel.setFont(MaxEnergyEdLabel.getFont().deriveFont(MaxEnergyEdLabel.getFont().getSize() + 5f));
			contentPane.add(MaxEnergyEdLabel);
			MaxEnergyEdLabel.setBounds(305, 270, 125, 35);

			//---- LatitudeEdLabel ----
			LatitudeEdLabel.setText("Latitude");
			LatitudeEdLabel.setFont(LatitudeEdLabel.getFont().deriveFont(LatitudeEdLabel.getFont().getSize() + 5f));
			contentPane.add(LatitudeEdLabel);
			LatitudeEdLabel.setBounds(305, 230, 125, 35);

			//---- LongitudeEdLabel ----
			LongitudeEdLabel.setText("Longitude");
			LongitudeEdLabel.setFont(LongitudeEdLabel.getFont().deriveFont(LongitudeEdLabel.getFont().getSize() + 5f));
			contentPane.add(LongitudeEdLabel);
			LongitudeEdLabel.setBounds(305, 190, 125, 35);

			//---- CooldownEdLabel ----
			CooldownEdLabel.setText("Cooldown");
			CooldownEdLabel.setFont(CooldownEdLabel.getFont().deriveFont(CooldownEdLabel.getFont().getSize() + 5f));
			contentPane.add(CooldownEdLabel);
			CooldownEdLabel.setBounds(305, 150, 125, 35);

			//======== scrollPane1 ========
			{

				//---- table1 ----
				table1.setModel(new DefaultTableModel(
					dadosTabela,
					new String[] {
						"Id", "Localiza\u00e7\u00e3o", "Cooldown"
					}
				));
				scrollPane1.setViewportView(table1);
			}
			contentPane.add(scrollPane1);
			scrollPane1.setBounds(0, 565, 590, 215);

			//---- RemoveCombo ----
			RemoveCombo.setModel(new DefaultComboBoxModel<>(conectores));
			contentPane.add(RemoveCombo);
			RemoveCombo.setBounds(200, 450, 205, 45);

			contentPane.setSize(590,810);
			contentPane.setLayout(null);
			contentPane.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel AdicionarLabel;
	private JLabel EditarLabel;
	private JTextField textCooldownAdd;
	private JLabel CooldownAddLabel;
	private JLabel TitloLabel;
	private JButton AdicionarBtn;
	private JButton EditarBtn;
	private JLabel RemoverLabel;
	private JButton RemoverBtn;
	private JComboBox<String> EdCombo;
	private JLabel LongitudeAddLabel;
	private JLabel LatitudeAddLabel;
	private JLabel MaxEnergyAddLabel;
	private JTextField textLongitudeAdd;
	private JTextField textLatitudeAdd;
	private JTextField textEnergiaAdd;
	private JTextField textCooldownEd;
	private JTextField textLongitudeEd;
	private JTextField textLatitudeEd;
	private JTextField textEnergiaEd;
	private JLabel MaxEnergyEdLabel;
	private JLabel LatitudeEdLabel;
	private JLabel LongitudeEdLabel;
	private JLabel CooldownEdLabel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JComboBox<String> RemoveCombo;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
