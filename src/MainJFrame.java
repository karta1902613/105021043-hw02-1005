import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainJFrame extends JFrame {
    private Container cp;
    private JButton jbtnExam = new JButton("範例文");
    private JButton jbtnAddpw = new JButton("加密");
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnClear = new JButton("清除");
    private JButton jbtnSpw = new JButton("解密");
    private JLabel  jlab = new JLabel("Key");
    private JTextField jtf = new JTextField();
    private JTextArea jtaP = new JTextArea();
    private JTextArea jtaA = new JTextArea();
    private JScrollPane jspL = new JScrollPane(jtaP);
    private JScrollPane jspR = new JScrollPane(jtaA);

    private JPanel janC = new JPanel(new GridLayout(7,1,3,3));
    public MainJFrame(){
        init();
    }
    public void init(){
        setBounds(400,300,400,300);
        jtaA.setLineWrap(true);
        jtaP.setLineWrap(true);
        jspL.setPreferredSize(new Dimension(150,80));
        jspR.setPreferredSize(new Dimension(150,80));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        janC.add(jbtnExam);
        janC.add(jbtnAddpw);
        janC.add(jlab);
        janC.add(jtf);
        janC.add(jbtnClear);
        janC.add(jbtnSpw);
        janC.add(jbtnExit);



        cp.add(jspR,BorderLayout.EAST);
        cp.add(janC,BorderLayout.CENTER);
        cp.add(jspL,BorderLayout.WEST);
        jlab.setHorizontalAlignment(JLabel.CENTER);
        jbtnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                jtaP.setText("");
                jtaA.setText("");
            }
        });
        jbtnExam.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaP.setText("Prior to the 2017 League of Legends World Championship Play-In Stage, Group D was viewed as a tricky group due to the looming threat of Team WE." +
                        "Two weeks later, and Group D is now looking like a near-impossible miss for North America's Team SoloMid.");
            }
        });
        jbtnAddpw.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaA.setText("");
                char data[]=jtaP.getText().toCharArray();
                char dataKey[]=jtf.getText().toCharArray();
                int len = data.length;
                int lenK = dataKey.length;
                int ascii;
                int v;
                int nK=0;
                char p;
                int DKbinary[]=new int[8];
                int Dbinary[] =new int[8];
                int binary[]  =new int[8];
                for(int i=0;i<7;i++){
                    Dbinary[i]=0;
                    DKbinary[i]=0;
                    binary[i]=0;
                }

                for(int i =0;i<len;i++){
                       ascii=data[i];
                      for(int j=7;ascii>0;j--){
                          v=ascii%2;
                           ascii/=2;
                          Dbinary[j]=v;
                       }
                   ascii=dataKey[nK];
                    nK++;
                       if(nK>=lenK){
                           nK=0;
                       }
                       for(int j=7;ascii>0;j--){
                          v=ascii%2;
                           ascii/=2;
                          DKbinary[j]=v;
                       }
                       for(int j=7;j>=0;j--){
                           if(DKbinary[j]==Dbinary[j]){
                               binary[j]=0;
                           }else{
                               binary[j]=1;
                           }
                       }
                    for(int k=0;k<=7;k++){
                       System.out.print(Dbinary[k]);
                  }
                        System.out.println("");

                    ascii=binary[0]*(int) Math.pow(2,7)+binary[1]*(int) Math.pow(2,6)+binary[2]*(int) Math.pow(2,5)+binary[3]*(int) Math.pow(2,4)+binary[4]*(int) Math.pow(2,3)+binary[5]*(int) Math.pow(2,2)+binary[6]*(int) Math.pow(2,1)+binary[7]*(int) Math.pow(2,0);
                    p =(char) ascii;
                    jtaA.append(p+"");

                }
            }
        });
        jbtnSpw.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaP.setText(jtaA.getText());
                jtaA.setText("");
                char data[]=jtaP.getText().toCharArray();
                char dataKey[]=jtf.getText().toCharArray();
                int len = data.length;
                int lenK = dataKey.length;
                int ascii;
                int v;
                int nK=0;
                char p;
                int DKbinary[]=new int[8];
                int Dbinary[] =new int[8];
                int binary[]  =new int[8];
                for(int i=0;i<7;i++){
                    Dbinary[i]=0;
                    DKbinary[i]=0;
                    binary[i]=0;
                }

                for(int i =0;i<len;i++){
                    ascii=data[i];
                    for(int j=7;ascii>0;j--){
                        v=ascii%2;
                        ascii/=2;
                        Dbinary[j]=v;
                    }
                    ascii=dataKey[nK];
                    nK++;
                    if(nK>=lenK){
                        nK=0;
                    }
                    for(int j=7;ascii>0;j--){
                        v=ascii%2;
                        ascii/=2;
                        DKbinary[j]=v;
                    }
                    for(int j=7;j>=0;j--){
                        if(DKbinary[j]==Dbinary[j]){
                            binary[j]=0;
                        }else{
                            binary[j]=1;
                        }
                    }
                    ascii=binary[0]*(int) Math.pow(2,7)+binary[1]*(int) Math.pow(2,6)+binary[2]*(int) Math.pow(2,5)+binary[3]*(int) Math.pow(2,4)+binary[4]*(int) Math.pow(2,3)+binary[5]*(int) Math.pow(2,2)+binary[6]*(int) Math.pow(2,1)+binary[7]*(int) Math.pow(2,0);
                    p =(char) ascii;
                    jtaA.append(p+"");

                }
            }
        });
    }
}