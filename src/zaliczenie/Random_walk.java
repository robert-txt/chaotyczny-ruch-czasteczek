package zaliczenie;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Random_walk extends Applet implements ActionListener{
	int applet_size=500;
	Moving_Particle mp1= new
	Moving_Particle(applet_size/4,applet_size/4,applet_size);
	Moving_Particle mp2= new
	Moving_Particle(applet_size/2,applet_size/2,applet_size);
	Moving_Particle mp3= new
	Moving_Particle(applet_size/3,applet_size/3,applet_size);
	Button p1 = new Button("GENERUJ");
	int l_krokow;
	TextField tf_l_krokow = new TextField(6);
	
	public void init(){
		setSize(applet_size,applet_size);
		setBackground(Color.white);
		add(tf_l_krokow);
		add(p1);
		p1.setEnabled(false);
		tf_l_krokow.addActionListener(this);
		p1.addActionListener(this);
	}
	
	public void paint(Graphics g){
		if(l_krokow>0){
		
		for (int i=0;i<l_krokow;i++){
			g.setColor(Color.blue);
			g.drawRect(mp1.get_x(), mp1.get_y(), 1,1);
			g.setColor(Color.red);
			g.drawRect(mp2.get_x(), mp2.get_y(), 1,1);
			g.setColor(Color.green);
			g.drawRect(mp3.get_x(), mp3.get_y(), 1,1);
			
			mp1.move();
			mp2.move();
			mp3.move();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==tf_l_krokow){
		l_krokow=Integer.parseInt(tf_l_krokow.getText());
		p1.setEnabled(true);
		}
		else{
		repaint();
		}
	}
}

class Particle {
private int x,y;
public Particle (int size)
{x=(int)(size*Math.random());y=(int)(size*Math.random());}
	int get_x(){return x;}
	int get_y(){return y;}
	void set_x(int xx){x=xx;}
	void set_y(int yy){y=yy;}
}

class Moving_Particle extends Particle{
	public Moving_Particle(int size){
		super(size);
}
	public Moving_Particle(int x, int y,int size){
		super(size);
		set_x(x);
		set_y(y);
}
	void move(){
		int x=get_x();
		int y=get_y();
		double p=Math.random();
		
		if(p<0.25) {set_x(x+1); if(x >= 500){set_x(0);}}
		else if(p<0.5) {set_x(x-1); if(x <= -1){set_x(499);}}
		else if(p<0.75) {set_y(y+1); if(y >= 500){set_y(0);}}
		else {set_y(y-1); if(y <= -1){set_y(500);}}
}
	
}
