package seven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        JFrame firstpage=new JFrame();
        firstpage.setBounds(100,100,600,600);

        JPanel panel=new JPanel();
        panel.setBackground(Color.cyan);



        JTextField jid=new JTextField(10);
        jid.setToolTipText("only number");
        JTextField jname=new JTextField(10);

        JLabel idlabel=new JLabel("شناسه");
        JLabel namelabel=new JLabel("نام");
        JLabel passlabel=new JLabel("رمز عبور");
        JLabel userlabel=new JLabel("نام کاربری");

        JPasswordField passfield=new JPasswordField(10);
        JTextField juser=new JTextField(10);

        JButton register=new JButton("ثبت");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentBL studentBL=new StudentBL();
                Student st=new Student();
                st.setName(jname.getText());
                st.setId(Long .parseLong(jid.getText()));

                studentBL.register(st);

                JFrame peygham=new JFrame();
                peygham.setBounds(200,200,400,400);
                JPanel panel1=new JPanel();
                JLabel label=new JLabel("ok shod");

                panel1.add(label);
                peygham.add(panel1);
                peygham.setVisible(true);

            }
        });

        JMenuBar menubar=new JMenuBar();

        JMenu profile=new JMenu("profile");
        JMenuItem newstudent=new JMenuItem("newstudent");
        JMenuItem Exit=new JMenuItem("Exit");

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                firstpage.dispose();
            }
        });
        profile.add(newstudent);
        profile.add(Exit);

        JMenu help=new JMenu("help");
        JMenuItem help1=new JMenuItem("help1");
        JMenuItem help2=new JMenuItem("help2");
        help.add(help1);
        help.add(help2);

        menubar.add(profile);
        menubar.add(help);


        panel.add(userlabel);
        panel.add(juser);

        panel.add(passlabel);
        panel.add(passfield);

        panel.add(idlabel);
        panel.add(jid);

        panel.add(namelabel);
        panel.add(jname);

        panel.add(register);

        firstpage.add(panel);
        firstpage.setJMenuBar(menubar);






        firstpage.setVisible(true);
    }
}
