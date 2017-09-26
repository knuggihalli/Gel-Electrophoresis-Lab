package mainPack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class AppMenu extends BasicGameState{
	
	Image table,microwave,flask,agarose,gelmold,comb,buffer;
	boolean play = true;
	Music song;
	int mousex, mousey;


	public AppMenu(int state) {}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		table = new Image("res/Menu/menu.png");
		song = new Music("res/Sounds/kidsfun.wav");
		agarose = new Image("res/Materials/Agrose.png");
		gelmold = new Image("res/Materials/gelmold.png");
		comb = new Image("res/Materials/comb.png");
		buffer = new Image("res/Materials/buffer.png");
		microwave = new Image("res/Materials/microwave.png");
		flask = new Image("res/Materials/flask.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
	// Draw graphics here put anything you want on the screen
		table.draw(0,0);
		microwave.draw(10,200,300,200);
		flask.draw(340,240,80,150);
		agarose.draw(440,240,80, 150);
		buffer.draw(380,300,80, 150);
		gelmold.draw(550,280, 200, 150);
		comb.draw(750,330, 100, 50);
		if(!song.playing() && play==true){
		      song.loop(1,1f);
		   } 

			/** USE THIS WHEN THE MOUSE HOVERS OVER EACH SELECTION**/
					
			mousex = Mouse.getX();
			mousey = Mouse.getY();
					
			g.drawString("Gel Electrophoresis", 300, 10);
			g.drawString("Start Lab", 300, 30);
			
			//START GAME
			if(mousex > 319 && mousex < 570 && mousey < 267 && mousey > 197){
				if(Mouse.isButtonDown(0)){
					sbg.enterState(2);
				}
			}
			//SETTINGS
		gc.setShowFPS(false);
		//g.drawString("Hit L to learn game", 300, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
	// put your inputs here provide actions
		@SuppressWarnings("unused")
		Input input = gc.getInput();
	
		
	}
	// makes this game state 0
	@Override
	public int getID() {return 1;}
}
