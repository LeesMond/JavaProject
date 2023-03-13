package project.view;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import project.vo.customer_mypage2VO;
import project.dao.customer_mypage2DAO;

public class customer_mypage2 extends JPanel implements ActionListener {

	customer_mypage2DAO dao;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	String ids;

	/**
	 * Create the panel.
	 */
	public customer_mypage2(String id) {
		this.ids = id;

		// 화면에 정보출력
		// dao.printpage(id);

		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uB9C8\uC774\uD398\uC774\uC9C0(\uACE0\uAC1D)", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("아이디 : ");
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		panel_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("이름 : ");
		panel_1.add(lblNewLabel_2);

		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("전화번호 : ");
		panel_1.add(lblNewLabel_3);

		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("성별 : ");
		panel_1.add(lblNewLabel_4);

		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("나이 : ");
		panel_1.add(lblNewLabel_5);

		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("차량보유여부 : ");
		panel_1.add(lblNewLabel_6);

		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		try {
			dao = new customer_mypage2DAO();
			customer_mypage2VO vo = dao.printpage(ids);
			textField.setText(vo.getId());
			textField_1.setText(vo.getPw());
			textField_2.setText(vo.getName());
			textField_3.setText(vo.getTel());
			textField_4.setText(vo.getSex());
			String a = Integer.toString(vo.getAge());
			textField_5.setText(a);
			textField_6.setText(vo.getVehicle());
			System.out.println("마이페이지 정보출력 성공");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "마이페이지 정보출력실패:" + e2.getMessage());
	}
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   String name = textField_2.getText();
		            String tel = textField_3.getText();
		            String sex = textField_4.getText();
		            int age = Integer.parseInt(textField_5.getText());
		            String vehicle = textField_6.getText();

		            customer_mypage2VO vo = new customer_mypage2VO(name, tel, sex, age, vehicle, ids);
		            try {
		               dao.modify(vo,ids);
		               System.out.println("정보수정 성공");
		            } catch (Exception e1) {
		               // TODO: handle exception
		               JOptionPane.showMessageDialog(null, "마이페이지 정보수정실패:" + e1.getMessage());
		            }

		         }

		      });

//				String name = textField_2.getText();
//				String tel = textField_3.getText();
//				String sex = textField_4.getText();
//				System.out.println("sk");
//				int age = Integer.parseInt(textField_5.getText());
//				System.out.println("sk2");
//				String vehicle = textField_6.getText();
//				System.out.println("SK3");
//				customer_mypage2VO vo = new customer_mypage2VO(name, tel, sex, age, vehicle);
//				System.out.println("SK4");
//				
//				try {
//					
//					dao = new customer_mypage2DAO();
//					
//					System.out.println("SK5");
//					dao.modify(vo);
//					 System.out.println("SK6");
//					System.out.println("정보수정 성공");
//				} catch (Exception e1) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(null, "마이페이지 정보수정실패:" + e1.getMessage());
//				}
//
//			}
//
//		});

		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("회원탈퇴");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					dao.delete(id);
					System.out.println("회원탈퇴 성공");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "회원탈퇴 실패:" + e1.getMessage());
				}
			}

		});

		panel_2.add(btnNewButton_1);
		setVisible(true);

		try {
			dao = new customer_mypage2DAO();
			System.out.println("마이페이지 디비 연결 성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "마이페이지 DB연결실패:" + e.getMessage());

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}