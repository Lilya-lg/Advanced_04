package advanced02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MainFrame extends JFrame{
	ImageIcon iconF = new ImageIcon("images/France.png");
	ImageIcon iconIt = new ImageIcon("images/Italy.png");
	ImageIcon iconUs = new ImageIcon("images/USA.png");
	ImageIcon icon1 = new ImageIcon("images/pudge.jpg");


	private JButton Fr = new JButton(iconF);
	private JButton It = new JButton(iconIt);
	private JButton Us = new JButton(iconUs);
	private JPanel panel;
	private JTable table;
	private String phrase = "Someone needed a Butcher";
	private String phrase2 = "Make room for Pudge";
	private String phrase3 = "Butcher's in business";
	private JLabel result = new JLabel(phrase);
	private JLabel result1 = new JLabel(phrase2);
	private JLabel result2 = new JLabel(phrase3);
	private JButton LoadBase = new JButton("Load from base");
	private JButton SaveBase = new JButton("Save to base");
	private JTextField name;
	private JTextField agility;
	private Pudge pudge;
	private Pudge newPudge;
    private JLabel BasePudge = new JLabel("");
	
	public  MainFrame() {
		super("Pudge International");
		final JFrame frame = new JFrame("Demo buttons");
		name = new JTextField();
		agility = new JTextField();
		JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        buttonPanel.add(Fr);
        buttonPanel.add(It);
        buttonPanel.add(Us);
        buttonPanel.add(result);
        buttonPanel.add(result1);
        buttonPanel.add(result2);
        buttonPanel.add(name);
        buttonPanel.add(agility);
        buttonPanel.add(LoadBase);
        buttonPanel.add(SaveBase);
        buttonPanel.add(BasePudge);
        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        east.add(buttonPanel, gbc);

        JPanel center = new JPanel(){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }    
        };
        JLabel label1 = new JLabel(icon1);
        center.add(label1);
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.add(east, BorderLayout.EAST);
        frame.add(center);

        frame.pack();
        frame.setVisible(true);
        initListener();
	}
	//listeners	
	private void initListener() {
		Fr.addActionListener(e->{
				String delimiter = " ";
				String[] subStr;
				String[] subStr1;
				String[] subStr2;
				StringBuilder trString = new StringBuilder();
				subStr = phrase.split(delimiter);
				subStr1 = phrase2.split(delimiter);
				subStr2 = phrase3.split(delimiter);
				Locale locale = new Locale("fr","FR");
				ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);
				for(int i = 0; i<subStr.length;i++) {
					trString.append(bundle.getString(subStr[i]));
					trString.append(" ");
					
				}
				result.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr1.length;i++) {
					trString.append(bundle.getString(subStr1[i]));
					trString.append(" ");
					
				}
				result1.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr2.length;i++) {
					trString.append(bundle.getString(subStr2[i]));
					trString.append(" ");
					
				}
				result2.setText(trString.toString());
		});
		It.addActionListener(e-> {
				String delimiter = " ";
				String[] subStr;
				String[] subStr1;
				String[] subStr2;
				StringBuilder trString = new StringBuilder();
				subStr = phrase.split(delimiter);
				subStr1 = phrase2.split(delimiter);
				subStr2 = phrase3.split(delimiter);
				Locale locale = new Locale("it","IT");
				ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);
				for(int i = 0; i<subStr.length;i++) {
					trString.append(bundle.getString(subStr[i]));
					trString.append(" ");
					
				}
				result.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr1.length;i++) {
					trString.append(bundle.getString(subStr1[i]));
					trString.append(" ");
					
				}
				result1.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr2.length;i++) {
					trString.append(bundle.getString(subStr2[i]));
					trString.append(" ");
					
				}
				result2.setText(trString.toString());
			
		});
		Us.addActionListener(e-> {
				String delimiter = " ";
				String[] subStr;
				String[] subStr1;
				String[] subStr2;
				StringBuilder trString = new StringBuilder();
				subStr = phrase.split(delimiter);
				subStr1 = phrase2.split(delimiter);
				subStr2 = phrase3.split(delimiter);
				Locale locale = new Locale("us","US");
				ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);
				for(int i = 0; i<subStr.length;i++) {
					trString.append(bundle.getString(subStr[i]));
					trString.append(" ");
					
				}
				result.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr1.length;i++) {
					trString.append(bundle.getString(subStr1[i]));
					trString.append(" ");
					
				}
				result1.setText(trString.toString());
				trString.setLength(0);
				for(int i = 0; i<subStr2.length;i++) {
					trString.append(bundle.getString(subStr2[i]));
					trString.append(" ");
					
				}
				result2.setText(trString.toString());
		});
		
		SaveBase.addActionListener(e-> {
				pudge = new Pudge(name.getText(),Integer.parseInt(agility.getText()));
				try {
		            FileOutputStream fo
		                = new FileOutputStream("pudge.txt");
		            ObjectOutputStream so
		                = new ObjectOutputStream(fo);
		            so.writeObject(pudge);
		            so.flush();
		        }
		        catch (Exception l) {
		            System.out.println(l);
		        }
				
		});
		LoadBase.addActionListener(e-> {
				
				try {
		            FileInputStream fi
		                = new FileInputStream("pudge.txt");
		            ObjectInputStream si
		                = new ObjectInputStream(fi);
		            newPudge = (Pudge)si.readObject();
		            BasePudge.setText(newPudge.toString());
		        }
		        catch (Exception l) {
		            System.out.println(l);
		        }
		});
	}
}

