package project.view;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project.dao.customerDAO;
import project.vo.customerVO;

public class customer extends JFrame implements ActionListener {

	customerDAO dao;

	private JPanel contentPane;

	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1;
	JButton btnNewButton_1;
	JButton btnNewButton;

	public customer() {
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uD68C\uC6D0\uAC00\uC785(\uACE0\uAC1D)", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel = new JLabel("아이디 :");
		panel.add(lblNewLabel);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = textField.getText();

				try {
					dao = new customerDAO();
					String custID = dao.idcheck(ID);
					if (!ID.equals(custID)) {
						JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.");
					} else {
						System.out.println("중복된 ID입니다.");
						JOptionPane.showMessageDialog(null, "중복된 ID입니다:");
						textField.setText("");
					}
				} catch (Exception e3) {
					System.out.println("error");
					System.out.println(e3.getCause());
					System.out.println(e3.getStackTrace());
					JOptionPane.showMessageDialog(null, "중복된 ID입니다:" + e3.getMessage());

				}
			}
		});
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		panel.add(lblNewLabel_1);

		textField_1 = new JPasswordField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("");
		panel.add(label);

		JLabel lblNewLabel_2 = new JLabel("비밀번호 확인 :");
		panel.add(lblNewLabel_2);

		textField_2 = new JPasswordField();
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_2 = new JButton("비밀번호 확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PW = textField_1.getText();
				String pwCheck = textField_2.getText();
				try {
					if (PW.equals(pwCheck)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						textField_2.setText("");
					}
				} catch (Exception e7) {
					// TODO: handle exception
				}
			}
		});
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_3 = new JLabel("전화번호");
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_1 = new JLabel("");
		panel.add(label_1);

		JLabel lblNewLabel_4 = new JLabel("이름 : ");
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_2 = new JLabel("");
		panel.add(label_2);

		JLabel lblNewLabel_5 = new JLabel("성별 : ");
		panel.add(lblNewLabel_5);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("남자");
		panel.add(rdbtnNewRadioButton_2);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("여자");
		panel_1.add(rdbtnNewRadioButton_1_1, BorderLayout.CENTER);

		JLabel lblNewLabel_6 = new JLabel("나이 : ");
		panel.add(lblNewLabel_6);

		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel label_3 = new JLabel("");
		panel.add(label_3);

		JLabel label_4 = new JLabel("");
		panel.add(label_4);

		JButton btnNewButton_1_1 = new JButton("회원 가입");
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = textField.getText();
				String PW = textField_1.getText();
				String pwCheck = textField_2.getText();

				String tel = textField_3.getText();
				String name = textField_4.getText();
				String sex = null;
				if (rdbtnNewRadioButton_2.isSelected()) {
					sex = "남자";
				} else if (rdbtnNewRadioButton_1_1.isSelected()) {
					sex = "여자";
				}
				int age = Integer.parseInt(textField_5.getText());

				customerVO vo = new customerVO(tel, ID, PW, name, sex, age);
				try {
					dao.regist(vo);
					System.out.println("회원가입 성공");

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "회원가입 실패:" + e2.getMessage());
				}
			}

		});

		JLabel label_6 = new JLabel("");
		panel.add(label_6);

		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		setVisible(true);

		try {
			dao = new customerDAO();
			System.out.println("회원가입 디비 연결 성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "회원가입 DB연결실패:" + e.getMessage());

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
