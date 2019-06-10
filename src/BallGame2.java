import java.awt.*; 
import javax.swing.*; //窗口类

public class BallGame2 extends JFrame { //继承JFrame
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg"); //加载图片
	
	double x=100; //小球的横坐标
	double y=100; //小球的纵坐标
	
	double degree = 3.14/3; //弧度，此处是60度
	
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("画窗口的方法");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null); //球动
		
		x = x+10*Math.cos(degree);
		y = y+10*Math.sin(degree);
		
		//上下边界
		if(y>500-40-30 || y<40+40) { //500是窗口高度，40是桌子边框，30是球直径；最后一个40是标题栏的高度
			degree = -degree;
		}
		//左右边界
		if(x<40||x>856-40-30) {
			degree = 3.14-degree;
		}
		
	}
	
	//窗口加载
	void launchFrame() {
		setSize(856,500); //窗口的宽和高
		setLocation(50,50); //窗口在屏幕中的初始位置
		setVisible(true);  //出现
		
		//重画窗口
		while(true) {
			repaint();
			//异常处理机制
			try {
				Thread.sleep(40); // 40ms,1秒等于1000毫秒，大约一秒画20次窗口
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//main方法是程序执行的入口
	public static void main(String[] args) {
		System.out.println("有梦的远方随处可栖，未去的山河依旧等我！");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}

}
