package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import project.dao.LoginDAO;
import project.vo.LoginVO;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextField textField;
	private JPasswordField textField_1;
	LoginDAO dao;

	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("아이디 : ");
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		panel_1.add(lblNewLabel_1);

		textField_1 = new JPasswordField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("고객 로그인");
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubs

				String id = textField.getText();
				String pass = textField_1.getText();

				try {
					dao = new LoginDAO();
					LoginVO vo = new LoginVO(id, pass);
					String ids = dao.customerLogin(vo);
					new customermain(ids);
					dispose();

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "로그인 실패 : " + e2.getMessage());
				}
			}
		});

		JButton btnNewButton_4 = new JButton("건물주 로그인");
		panel_3.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = textField.getText();
				String pass = textField_1.getText();

				try {
					dao = new LoginDAO();
					LoginVO vo = new LoginVO(id, pass);
					String ids = dao.ownerLogin(vo);
					new Ownermain(ids);
					dispose();

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "로그인 실패 : " + e2.getMessage());
				}
			}
		});

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton = new JButton("회원가입");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new logintype();
			}
		});

		JButton btnNewButton_2 = new JButton("ID 찾기");
		panel_2.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindID();
			}
		});

		JButton btnNewButton_3 = new JButton("PW 변경");
		panel_2.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindPassword();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
