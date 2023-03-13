package project.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import project.dao.OwnerMyPageDAO;
import project.vo.OwnerMyPageVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buildingOwner_mypage2 extends JPanel {
	private JTextField idText;
	private JTextField pwText;
	private JTextField nameText;
	private JTextField telText;
	private JTextField addrText;
	private JTextField binumText;
	String ids;
	OwnerMyPageDAO dao;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public buildingOwner_mypage2(String id) throws Exception {
		this.ids = id;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uB9C8\uC774\uD398\uC774\uC9C0(\uAC74\uBB3C\uC8FC)", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("아이디 : ");
		panel.add(lblNewLabel);

		idText = new JTextField();
		idText.setEditable(false);
		panel.add(idText);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		panel.add(lblNewLabel_1);

		pwText = new JTextField();
		pwText.setEditable(false);
		panel.add(pwText);
		pwText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("이름 : ");
		panel.add(lblNewLabel_2);

		nameText = new JTextField();
		panel.add(nameText);
		nameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("전화번호 : ");
		panel.add(lblNewLabel_3);

		telText = new JTextField();
		panel.add(telText);
		telText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("주소 : ");
		panel.add(lblNewLabel_4);

		addrText = new JTextField();
		panel.add(addrText);
		addrText.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("사업자 번호 : ");
		panel.add(lblNewLabel_5);

		binumText = new JTextField();
		panel.add(binumText);
		binumText.setColumns(10);

		// 추출 한것 가지고 오기
		dao = new OwnerMyPageDAO();
		OwnerMyPageVO vo = dao.returnOwnerMyPage(id);
		
		System.out.println(vo.getBusinessNum());
		idText.setText(vo.getId());
		pwText.setText(vo.getPw());
		nameText.setText(vo.getName());
		telText.setText(vo.getTel());
		addrText.setText(vo.getAddr());
		binumText.setText(vo.getBusinessNum());

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText();
				String pw = pwText.getText();
				String name = nameText.getText();
				String tel = telText.getText();
				String addr = addrText.getText();
				String binum = binumText.getText();
				
				OwnerMyPageVO vo2 = new OwnerMyPageVO(id, pw, name, tel, addr, binum);
				try {
					dao = new OwnerMyPageDAO();
					dao.updateOwner(vo2, ids);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("회원탈퇴");
		panel_1.add(btnNewButton_1);
		setVisible(true);

	}

}
