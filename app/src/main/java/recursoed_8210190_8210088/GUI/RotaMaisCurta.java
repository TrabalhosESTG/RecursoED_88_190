package recursoed_8210190_8210088.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Wed Feb 22 15:08:37 WET 2023
 */

import recursoed_8210190_8210088.Connector;
import recursoed_8210190_8210088.Local;
import recursoed_8210190_8210088.Map;
import recursoed_8210190_8210088.Portal;



/**
 * @author David Francisco
 */
public class RotaMaisCurta  {
	public JFrame contentPane= new JFrame("Rota mais curta");
	Map map;

	public RotaMaisCurta(Map mapa) {
		map = mapa;
		initComponents();
	}

	/**
	* Gera a rota mais curtas entre dois locais
	*/
	private void Adicionar(ActionEvent e) {
		String de = (String) DeCombo.getSelectedItem();
		String ate = (String) AteCombo.getSelectedItem();
		String passar = (String) PassarCombo.getSelectedItem();
		if(passar.equals("")){
			Local from = map.getLocalByID(Integer.parseInt(de));
			Local to = map.getLocalByID(Integer.parseInt(ate));
			new Popup("<html>Caminho mais curto: " + map.shortestPath(from, to) + "</html>");
		}else{
			Local from = map.getLocalByID(Integer.parseInt(de));
			Local to = map.getLocalByID(Integer.parseInt(ate));
			Local pass = map.getLocalByID(Integer.parseInt(passar));
			new Popup("<html>Caminho mais curto: " + map.shortestPathBetweenAnother(from, to, pass) + "</html>");
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		RotaCurtaLabel = new JLabel();
		DeCombo = new JComboBox<>();
		AteCombo = new JComboBox<>();
		Delabel = new JLabel();
		AteLabel = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		GerarBtn = new JButton();
		TitloLabel = new JLabel();
		PassarLabel = new JLabel();
		PassarCombo = new JComboBox<>();

		String[] locais = new String[map.getLocals().size()];
		Object[][] dadosTabela = new Object [map.getLocals().size()][2];
		int j = 0;
		for (Local local : map.getLocals()) {
			locais[j] = String.valueOf(local.getId());
			dadosTabela[j][0] = local.getId();
			if(local instanceof Portal){
				dadosTabela[j][1] = "Portal";
			}else if(local instanceof Connector){
				dadosTabela[j][1] = "Connector";
			}
			j++;
		}

		{
			//---- RotaCurtaLabel ----
			RotaCurtaLabel.setText("Rota mais curta");
			RotaCurtaLabel.setHorizontalAlignment(SwingConstants.CENTER);
			RotaCurtaLabel.setFont(RotaCurtaLabel.getFont().deriveFont(RotaCurtaLabel.getFont().getSize() + 10f));
			contentPane.add(RotaCurtaLabel);
			RotaCurtaLabel.setBounds(155, 55, 195, 65);

			//---- DeCombo ----
			DeCombo.setModel(new DefaultComboBoxModel<>(locais));
			contentPane.add(DeCombo);
			DeCombo.setBounds(55, 145, 110, 45);

			//---- AteCombo ----
			AteCombo.setModel(new DefaultComboBoxModel<>(locais));
			contentPane.add(AteCombo);
			AteCombo.setBounds(215, 145, 110, 45);

			//---- Delabel ----
			Delabel.setText("De:");
			Delabel.setHorizontalAlignment(SwingConstants.CENTER);
			Delabel.setFont(Delabel.getFont().deriveFont(Delabel.getFont().getSize() + 5f));
			contentPane.add(Delabel);
			Delabel.setBounds(0, 145, 65, 40);

			//---- AteLabel ----
			AteLabel.setText("At\u00e9");
			AteLabel.setHorizontalAlignment(SwingConstants.CENTER);
			AteLabel.setFont(AteLabel.getFont().deriveFont(AteLabel.getFont().getSize() + 5f));
			contentPane.add(AteLabel);
			AteLabel.setBounds(165, 145, 65, 40);

			//======== scrollPane1 ========
			{

				//---- table1 ----
				table1.setModel(new DefaultTableModel(
					dadosTabela,
					new String[] {
						"Local", "Tipo"
					}
				));
				scrollPane1.setViewportView(table1);
			}
			contentPane.add(scrollPane1);
			scrollPane1.setBounds(0, 255, 505, 220);

			//---- GerarBtn ----
			GerarBtn.setText("Gerar Rota");
			GerarBtn.setFont(GerarBtn.getFont().deriveFont(GerarBtn.getFont().getSize() + 5f));
			GerarBtn.addActionListener(e -> Adicionar(e));
			contentPane.add(GerarBtn);
			GerarBtn.setBounds(160, 205, 180, 37);

			//---- TitloLabel ----
			TitloLabel.setText("Gest\u00e3o de Rotas");
			TitloLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TitloLabel.setFont(TitloLabel.getFont().deriveFont(TitloLabel.getFont().getSize() + 15f));
			contentPane.add(TitloLabel);
			TitloLabel.setBounds(80, 5, 355, 51);

			//---- PassarLabel ----
			PassarLabel.setText("Passar");
			PassarLabel.setHorizontalAlignment(SwingConstants.CENTER);
			PassarLabel.setFont(PassarLabel.getFont().deriveFont(PassarLabel.getFont().getSize() + 5f));
			contentPane.add(PassarLabel);
			PassarLabel.setBounds(325, 145, 65, 40);

			//---- PassarCombo ----
			PassarCombo.setModel(new DefaultComboBoxModel<>(locais));
			contentPane.add(PassarCombo);
			PassarCombo.setBounds(390, 145, 110, 45);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < contentPane.getComponentCount(); i++) {
					Rectangle bounds = contentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = contentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				contentPane.setMinimumSize(preferredSize);
				contentPane.setPreferredSize(preferredSize);
			}
			contentPane.setSize(505,505);
			contentPane.setLayout(null);
			contentPane.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JLabel RotaCurtaLabel;
	private JComboBox<String> DeCombo;
	private JComboBox<String> AteCombo;
	private JLabel Delabel;
	private JLabel AteLabel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton GerarBtn;
	private JLabel TitloLabel;
	private JLabel PassarLabel;
	private JComboBox<String> PassarCombo;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
