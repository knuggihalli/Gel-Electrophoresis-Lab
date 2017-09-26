package mainPack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class projectTitle extends BasicGameState{
	
	Animation twizletanimation;
	int[] twizletanimationduration = {150,150,150,150,150,150,150,150,150,150,150,150,150,150,2100,100,100,100,100,100,100,100,100,100,100,9000000};
	int mousex, mousey;
	boolean play = true;
	Image nextbutton;
	Sound introsong,nextsound;


	public projectTitle(int state) {}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		Image[] twizletimages = {new Image("res/Intro/Twizlet/1.png"), new Image("res/Intro/Twizlet/2.png"), new Image("res/Intro/Twizlet/3.png"), new Image("res/Intro/Twizlet/4.png"), new Image("res/Intro/Twizlet/5.png"), new Image("res/Intro/Twizlet/6.png"), new Image("res/Intro/Twizlet/7.png"), new Image("res/Intro/Twizlet/8.png"), new Image("res/Intro/Twizlet/9.png"), new Image("res/Intro/Twizlet/10.png"), new Image("res/Intro/Twizlet/11.png"), new Image("res/Intro/Twizlet/12.png"), new Image("res/Intro/Twizlet/13.png"), new Image("res/Intro/Twizlet/14.png"), new Image("res/Intro/Twizlet/15.png"), new Image ("res/Intro/GelLab/1.png"), new Image("res/Intro/GelLab/2.png"), new Image("res/Intro/GelLab/3.png"), new Image("res/Intro/GelLab/4.png"), new Image("res/Intro/GelLab/5.png"), new Image("res/Intro/GelLab/6.png"), new Image("res/Intro/GelLab/7.png"), new Image("res/Intro/GelLab/8.png"), new Image("res/Intro/GelLab/9.png"), new Image("res/Intro/GelLab/10.png"), new Image("res/Intro/GelLab/11.png")};
		twizletanimation = new Animation (twizletimages, twizletanimationduration, true);
		introsong = new Sound("res/Sounds/monstermunch.wav");
		nextsound = new Sound("res/Sounds/nextsound.wav");
		nextbutton = new Image("res/Menu/next.png");	
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
	// Draw graphics here put anything you want on the screen
		twizletanimation.draw(0,0);
		
		if(!introsong.playing() && play==true){
		       introsong.loop(1,.3f);
		   }
		
		nextbutton.draw(830,540);
		
		gc.setShowFPS(false);
		//g.drawString("Hit L to learn game", 300, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
	// put your inputs here provide actions
		@SuppressWarnings("unused")
		Input input = gc.getInput();
		
		mousex = Mouse.getX();
		mousey = Mouse.getY();
		
		if(Mouse.isButtonDown(0) && mousex>=830 && mousex<=865 && mousey<=60 && mousey>=25){
			nextsound.play(1,.2f);
			sbg.enterState(1);
			introsong.stop();
			play = false;
		}
		
	}
	// makes this game state 0
	@Override
	public int getID() {return 0;}
}
