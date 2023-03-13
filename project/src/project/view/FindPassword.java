package project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

import project.dao.FindIDDAO;
import project.dao.FindPasswordDAO;
import project.vo.customerVO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FindPassword extends JFrame {
	
	FindPasswordDAO dao;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final JPasswordField textField_2 = new JPasswordField();

	public FindPassword() {
		setVisible(true);
		setBounds(100, 100, 500, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC815\uBCF4 \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("아이디 입력 : ");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(25);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호 입력 : ");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
	
		JButton btnNewButton = new JButton("pw변경");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String tel = textField_1.getText();
				String pw = textField_2.getText();
				
				try {
					dao = new FindPasswordDAO();
					dao.searchIdTel(pw,id,tel);
					System.out.println("pw변경 성공");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "PW 변경 실패");
					// TODO: handle exception
				}
			}});
					

		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		contentPane.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		setVisible(true);
//		
		try {
			dao = new FindPasswordDAO();
			System.out.println("비밀번호찾기 디비 연결 성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "비밀번호찾기 DB연결실패:" + e.getMessage());

	}
		
	}

}
