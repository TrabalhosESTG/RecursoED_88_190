package recursoed_8210190_8210088.GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Tue Feb 21 21:50:11 WET 2023
 */

import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Portal;



/**
 * @author David Francisco
 */
public class GestaoPortal {
	JFrame contentPane= new JFrame("Gestão de jogadores");
	Map map;
	public GestaoPortal(Map mapa) {
		map = mapa;
		initComponents();
	}
	private void Adicionar(ActionEvent e) {
		if(textNomeAdd.getText().equals("")|| textLatitudeAdd.getText().equals("")|| textLongitudeAdd.getText().equals("")|| textMaxEnergyAdd.getText().equals("")){
			new Popup("<html>Preencha todos os campos!</html>");
			return;
		}else if(!textLatitudeAdd.getText().matches("-?[0-9]+(\\.[0-9]+)?") || !textLongitudeAdd.getText().matches("-?[0-9]+(\\.[0-9]+)?") || !textMaxEnergyAdd.getText().matches("[0-9]+(\\.[0-9]+)?")){
			new Popup("<html>Os campos Latitude, Longitude e Max Energy devem ser números e energia máxima deve ser positiva!</html>");
			return;
		}
		Portal portal = new Portal(map.getNextId(), Double.parseDouble(textLongitudeAdd.getText()), Double.parseDouble(textLatitudeAdd.getText()),0, Double.parseDouble(textMaxEnergyAdd.getText()), textNomeAdd.getText());
		map.addLocal(portal);
		new Popup("<html>Portal adicionado com sucesso!</html>");
	}

	private void Editar(ActionEvent e) {
		if((!textLatitudeEd.getText().matches("-?[0-9]+(\\.[0-9]+)?") && !textLatitudeEd.getText().equals("")) || (!textLongitudeEd.getText().matches("-?[0-9]+(\\.[0-9]+)?") && !textLongitudeEd.getText().equals("")) || (!textMaxEnergyEd.getText().matches("[0-9]+(\\.[0-9]+)?") && !textMaxEnergyEd.getText().equals(""))){
			new Popup("<html>Os campos Latitude, Longitude e Max Energy devem ser números e energia máxima deve ser positiva!</html>");
			return;
		}
		if( map.getLocalByID(Integer.parseInt(String.valueOf(PortalEdCombo.getSelectedItem()))) instanceof Portal){
			Portal portal = (Portal) map.getLocalByID(Integer.parseInt(String.valueOf(PortalEdCombo.getSelectedItem())));
			if(!textNomeEd.getText().equals("")) portal.setName(textNomeEd.getText());
			if(!textLatitudeEd.getText().equals("")) portal.setLatitude(Double.parseDouble(textLatitudeEd.getText()));
			if(!textLongitudeEd.getText().equals("")) portal.setLongitude(Double.parseDouble(textLongitudeEd.getText()));
			if(!textMaxEnergyEd.getText().equals("")) portal.setMaxEnergy(Double.parseDouble(textMaxEnergyEd.getText()));
			new Popup("<html>Portal editado com sucesso!</html>");
		}
	}

	private void Remover(ActionEvent e) {
		map.removeLocal(map.getLocalByID(Integer.parseInt(String.valueOf(RemoveCombo.getSelectedItem()))));
		new Popup("<html>Portal removido com sucesso!</html>");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		AdicionarLabel = new JLabel();
		EditarLabel = new JLabel();
		textNomeAdd = new JTextField();
		NomeAddLabel = new JLabel();
		TitloLabel = new JLabel();
		AdicionarBtn = new JButton();
		EditarBtn = new JButton();
		RemoverLabel = new JLabel();
		RemoverBtn = new JButton();
		RemoveCombo = new JComboBox<>();
		LongitudeAddLabel = new JLabel();
		LatitudeAddLabel = new JLabel();
		MaxEnergyAddLabel = new JLabel();
		textLongitudeAdd = new JTextField();
		textLatitudeAdd = new JTextField();
		textMaxEnergyAdd = new JTextField();
		textNomeEd = new JTextField();
		textLongitudeEd = new JTextField();
		textLatitudeEd = new JTextField();
		textMaxEnergyEd = new JTextField();
		MaxEnergyEdLabel = new JLabel();
		LatitudeEdLabel = new JLabel();
		LongitudeEdLabel = new JLabel();
		NomeEdLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		PortalEdCombo = new JComboBox<>();

		String[] portais = new String[map.getPortals().size()];
		Object[][] dadosTabela = new Object [map.getPortals().size()][4];
		int i = 0;
		for (Portal portal : map.getPortals()) {
			portais[i] = String.valueOf(portal.getId());
			dadosTabela[i][0] = portal.getId();
			dadosTabela[i][1] = portal.getName();
			dadosTabela[i][2] = portal.getLatitude() + " - " + portal.getLongitude();
			dadosTabela[i][3] = portal.getTeam();
			i++;
		}
		//======== Portal ========
		{

			//---- AdicionarLabel ----
			AdicionarLabel.setText("Adicionar Portal");
			AdicionarLabel.setHorizontalAlignment(SwingConstants.CENTER);
			AdicionarLabel.setFont(AdicionarLabel.getFont().deriveFont(AdicionarLabel.getFont().getSize() + 10f));
			contentPane.add(AdicionarLabel);
			AdicionarLabel.setBounds(35, 60, 195, 65);

			//---- EditarLabel ----
			EditarLabel.setText("Editar Portal");
			EditarLabel.setHorizontalAlignment(SwingConstants.CENTER);
			EditarLabel.setFont(EditarLabel.getFont().deriveFont(EditarLabel.getFont().getSize() + 10f));
			contentPane.add(EditarLabel);
			EditarLabel.setBounds(330, 55, 195, 65);
			contentPane.add(textNomeAdd);
			textNomeAdd.setBounds(135, 150, 135, 35);

			//---- NomeAddLabel ----
			NomeAddLabel.setText("Nome:");
			NomeAddLabel.setFont(NomeAddLabel.getFont().deriveFont(NomeAddLabel.getFont().getSize() + 5f));
			contentPane.add(NomeAddLabel);
			NomeAddLabel.setBounds(10, 150, 125, 35);

			//---- TitloLabel ----
			TitloLabel.setText("Gest\u00e3o de Portais");
			TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
			contentPane.add(TitloLabel);
			TitloLabel.setBounds(125, 5, 355, 51);

			//---- AdicionarBtn ----
			AdicionarBtn.setText("Adicionar");
			AdicionarBtn.setFont(AdicionarBtn.getFont().deriveFont(AdicionarBtn.getFont().getSize() + 5f));
			AdicionarBtn.addActionListener(e -> Adicionar(e));
			contentPane.add(AdicionarBtn);
			AdicionarBtn.setBounds(75, 340, 180, 37);

			//---- EditarBtn ----
			EditarBtn.setText("Editar");
			EditarBtn.setFont(EditarBtn.getFont().deriveFont(EditarBtn.getFont().getSize() + 5f));
			EditarBtn.addActionListener(e -> Editar(e));
			contentPane.add(EditarBtn);
			EditarBtn.setBounds(370, 335, 180, 37);

			//---- RemoverLabel ----
			RemoverLabel.setText("Remover Portal");
			RemoverLabel.setHorizontalAlignment(SwingConstants.CENTER);
			RemoverLabel.setFont(RemoverLabel.getFont().deriveFont(RemoverLabel.getFont().getSize() + 10f));
			contentPane.add(RemoverLabel);
			RemoverLabel.setBounds(185, 410, 200, 51);

			//---- RemoverBtn ----
			RemoverBtn.setText("Remover");
			RemoverBtn.setFont(RemoverBtn.getFont().deriveFont(RemoverBtn.getFont().getSize() + 5f));
			RemoverBtn.addActionListener(e -> Remover(e));
			contentPane.add(RemoverBtn);
			RemoverBtn.setBounds(205, 555, 180, 40);

			//---- RemoveCombo ----
			RemoveCombo.setModel(new DefaultComboBoxModel<>(portais));
			contentPane.add(RemoveCombo);
			RemoveCombo.setBounds(190, 465, 205, 45);

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
			MaxEnergyAddLabel.setText("Energia m\u00e1xima");
			MaxEnergyAddLabel.setFont(MaxEnergyAddLabel.getFont().deriveFont(MaxEnergyAddLabel.getFont().getSize() + 5f));
			contentPane.add(MaxEnergyAddLabel);
			MaxEnergyAddLabel.setBounds(10, 270, 125, 35);
			contentPane.add(textLongitudeAdd);
			textLongitudeAdd.setBounds(135, 190, 135, 35);
			contentPane.add(textLatitudeAdd);
			textLatitudeAdd.setBounds(135, 230, 135, 35);
			contentPane.add(textMaxEnergyAdd);
			textMaxEnergyAdd.setBounds(135, 270, 135, 35);
			contentPane.add(textNomeEd);
			textNomeEd.setBounds(430, 150, 135, 35);
			contentPane.add(textLongitudeEd);
			textLongitudeEd.setBounds(430, 190, 135, 35);
			contentPane.add(textLatitudeEd);
			textLatitudeEd.setBounds(430, 230, 135, 35);
			contentPane.add(textMaxEnergyEd);
			textMaxEnergyEd.setBounds(430, 270, 135, 35);

			//---- MaxEnergyEdLabel ----
			MaxEnergyEdLabel.setText("Energia m\u00e1xima");
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

			//---- NomeEdLabel ----
			NomeEdLabel.setText("Nome:");
			NomeEdLabel.setFont(NomeEdLabel.getFont().deriveFont(NomeEdLabel.getFont().getSize() + 5f));
			contentPane.add(NomeEdLabel);
			NomeEdLabel.setBounds(305, 150, 125, 35);

			//======== scrollPane1 ========
			{

				//---- table1 ----
				table1.setModel(new DefaultTableModel(
					dadosTabela,
					new String[] {
						"Id", "Nome", "Localiza\u00e7\u00e3o", "Equipa"
					}
				));

				scrollPane1.setViewportView(table1);
			}
			contentPane.add(scrollPane1);
			scrollPane1.setBounds(0, 605, 590, 215);
			//---- PortalEdCombo ----
			PortalEdCombo.setModel(new DefaultComboBoxModel<>(portais));
			contentPane.add(PortalEdCombo);
			PortalEdCombo.setBounds(350, 100, 205, 45);


			contentPane.setSize(590,850);
			contentPane.setLayout(null);
			contentPane.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel AdicionarLabel;
	private JLabel EditarLabel;
	private JTextField textNomeAdd;
	private JLabel NomeAddLabel;
	private JLabel TitloLabel;
	private JButton AdicionarBtn;
	private JButton EditarBtn;
	private JLabel RemoverLabel;
	private JButton RemoverBtn;
	private JComboBox<String> RemoveCombo;
	private JLabel LongitudeAddLabel;
	private JLabel LatitudeAddLabel;
	private JLabel MaxEnergyAddLabel;
	private JTextField textLongitudeAdd;
	private JTextField textLatitudeAdd;
	private JTextField textMaxEnergyAdd;
	private JTextField textNomeEd;
	private JTextField textLongitudeEd;
	private JTextField textLatitudeEd;
	private JTextField textMaxEnergyEd;
	private JLabel MaxEnergyEdLabel;
	private JLabel LatitudeEdLabel;
	private JLabel LongitudeEdLabel;
	private JLabel NomeEdLabel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JComboBox<String> PortalEdCombo;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
