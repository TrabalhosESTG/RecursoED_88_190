package recursoed_8210190_8210088.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import recursoed_8210190_8210088.Map;

/*
 * Created by JFormDesigner on Tue Feb 21 20:35:27 WET 2023
 */



/**
 * @author guilherme
 */
public class GestaoLocais {
	JFrame contentPane= new JFrame("Gestão de jogadores");
	Map map;
	public GestaoLocais(Map mapa) {
		map = mapa;
		initComponents();
	}

	private void portais(ActionEvent e) {
		new GestaoPortal(map);
	}

	private void conectores(ActionEvent e) {
		new GestaoConector(map);
	}

	private void rotas(ActionEvent e) {
		new GestaoRotas(map);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - guilherme
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label1 = new JLabel();

		//---- button1 ----
		button1.setText("Gest\u00e3o de Portais");
		button1.addActionListener(e -> portais(e));
		contentPane.add(button1);
		button1.setBounds(50, 115, 210, 40);

		//---- button2 ----
		button2.setText("Gest\u00e3o de Conectores");
		button2.addActionListener(e -> conectores(e));
		contentPane.add(button2);
		button2.setBounds(50, 170, 210, 40);

		//---- button3 ----
		button3.setText("Gest\u00e3o de Rotas");
		button3.addActionListener(e -> rotas(e));
		contentPane.add(button3);
		button3.setBounds(50, 225, 210, 40);

		//---- label1 ----
		label1.setText("Gest\u00e3o de Locais");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Liberation Sans", Font.BOLD, 20));
		contentPane.add(label1);
		label1.setBounds(40, 15, 240, 60);

		contentPane.setSize(300,330);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - guilherme
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
