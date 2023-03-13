package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class logintype extends JFrame {

	private JPanel contentPane;

	public logintype() {
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD68C\uC6D0 \uAC00\uC785", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("가입하실 유형을 선택하세요");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("세입자");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customer();
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("건물주");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Owner();
			}
		});
		setVisible(true);
	}

}
