package project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

import project.dao.FindIDDAO;
import project.dao.customerDAO;
import project.vo.customerVO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FindID extends JFrame {

	FindIDDAO dao;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public FindID() {

		setBounds(100, 100, 450, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC544\uC774\uB514 \uCC3E\uAE30", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("전화번호 입력 : ");
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);

		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(25);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("찾기");
		panel_4.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tel = textField.getText();

				try {
					dao = new FindIDDAO();
					String custid = dao.searchTel(tel);
					textField_1.setText(custid);

					System.out.println("ID검색 성공");
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "ID검색 실패");
				}
			}
		});

		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(25);
		setVisible(true);

		try {
			dao = new FindIDDAO();
			System.out.println("아이디찾기 디비 연결 성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "아이디찾기 DB연결실패:" + e.getMessage());

		}

	}
	}



