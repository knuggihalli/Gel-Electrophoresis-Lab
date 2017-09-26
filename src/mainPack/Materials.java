package mainPack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Materials extends BasicGameState {
	
	Image table,microwave,flask,agarose,gelmold,comb,buffer;
	Image backbutton,savebutton,homebutton,hintbutton; 
	Image blackboard,nextbutton,cleared,star;
	
	public int score;
	public int objectives = 6;
	public int objComp = 0;
	public int total;
	public int xpos = 380, ypos= 300;
	public int mousex, mousey;
	
	public boolean microwaveadded = false;
	public boolean flaskadded = false;
	public boolean bufferadded = false;
	public boolean agaroseadded = false;
	public boolean gelmoldadded = false;
	public boolean combadded = false;
	public boolean clicked = false;
	public boolean stilllearning = false;
	public boolean canlearn = true;
	

	public Materials(int state) {}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		table = new Image("res/Menu/menu.png");
		agarose = new Image("res/Materials/Agrose.png");
		gelmold = new Image("res/Materials/gelmold.png");
		comb = new Image("res/Materials/comb.png");
		buffer = new Image("res/Materials/buffer.png");
		microwave = new Image("res/Materials/microwave.png");
		flask = new Image("res/Materials/flask.png");
		
		blackboard = new Image("res/Menu/blackboard.jpg");
		backbutton = new Image("res/Menu/back.png");
		nextbutton = new Image("res/Menu/next.png");
		savebutton = new Image("res/Menu/save.png");
		homebutton = new Image("res/Menu/home.png");
		hintbutton = new Image("res/Menu/hint.png");
		cleared = new Image("res/Menu/levelcleared.png");
		star = new Image("res/Menu/star.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
	// Draw graphics here put anything you want on the screen
		Input input = gc.getInput();
		table.draw(0,0);
		
		microwave.draw(10,200,300,200);
		flask.draw(340,240,80,150);
		agarose.draw(440,240,80, 150);
		buffer.draw(xpos,ypos,80, 150);
		
		g.setColor(Color.darkGray);
		g.fillRect(540,0,400,302);
		g.setColor(Color.lightGray);
		g.fillRect(0,550,900,300);
		
		backbutton.draw(10,560);
		savebutton.draw(60,560);
		homebutton.draw(110,564);
		hintbutton.draw(160,564);
		
		gelmold.draw(550,280, 200, 150);
		comb.draw(750,330, 100, 50);
		
		
		
		g.setColor(Color.white);
		
		g.drawString("Gel Electrophoresis [ Materials ] ", 10, 5);
		g.drawString("Click on each object to learn about it...", 10, 25);
		
		g.drawString("Material Description - ", 620, 5);
		
		 mousex = Mouse.getX();
		 mousey = Mouse.getY();

				
		//g.drawString("mousex:" + mousex , 780, 555);
		//g.drawString("mousey:" +mousey , 780, 575);
		
		if(Mouse.isButtonDown(0)){
		if(mousey<=400 && mousey>=200 && mousex<=300 && mousex>=15){
			microwave.drawFlash(10,200,300,200);
			
			g.drawString("The Microwave", 550, 40);
			g.drawString("an electrically operated oven", 550, 70);
			g.drawString("using high-frequency electromagnetic", 550, 90);
			g.drawString("waves that penetrate food, causing", 550, 110);
			g.drawString("its molecules to vibrate and", 550, 130);
			g.drawString("generating heat within the food", 550, 150);
			g.drawString("to cook it in a very short time.", 550, 170);
			
			if(microwaveadded == false){
				objComp = objComp+1;
				microwaveadded = true;
			}
		}
		if(mousey<=375 && mousey>=285 && mousex<=390 && mousex>=365 || mousex>=340 && mousex<=380 && mousey<=270 && mousey>=220 || mousex>=360 && mousex<=380 && mousey<=285 && mousey>=270 ){
			flask.drawFlash(340,240,80,150);
			
			g.drawString("The Flask", 550, 40);
			g.drawString("A narrow-necked glass container,", 550, 70);
			g.drawString("typically conical or spherical,", 550, 90);
			g.drawString("used in a laboratory to hold reagents", 550, 110);
			g.drawString("or samples.", 550, 130);
			
			if(flaskadded == false){
				objComp = objComp+1;
				flaskadded = true;
			}
		}
		if(mousey>=350 && mousey<=370 && mousex>=455 && mousex<=505 || mousey>=300 && mousey<=340 && mousex>=440 && mousex<=515 || mousey>=285 && mousey<=320 && mousex>=440 && mousex<=515 || mousey>=215 && mousey<=285 && mousex>=460 && mousex<=515 ){
			agarose.drawFlash(440,240,80, 150);
			 
			g.drawString("The Agarose", 550, 40);
			g.drawString("Agar or agar-agar is a gelatinous", 550, 70);
			g.drawString("substance derived from red algae", 550, 90);
			g.drawString("", 550, 110);
			
			if(agaroseadded == false){
				objComp = objComp+1;
				agaroseadded = true;
			}
			
		}
		if(mousey<=285 && mousey>=170 && mousex<=458 && mousex>=385 ){
			buffer.drawFlash(xpos,ypos,80, 150);
			
			g.drawString("The Buffer", 550, 40);
			g.drawString("The buffer contains ions which allow", 550, 70);
			g.drawString("for the electricity to actually", 550, 90);
			g.drawString("pass through the apparatus.", 550, 110);
			
			AppMenu obj = new AppMenu(1);
			obj.play = false;
			
			if(bufferadded == false){
				objComp = objComp+1;
				bufferadded = true;
			}
			
		}
		if(mousey>=180 && mousey<=220 && mousex>=555 && mousex<=746 || mousey>=220 && mousey<=270 && mousex>=550 && mousex<=743 || mousey>=270 && mousey<=305 && mousex>=560 && mousex<=720 ){
			gelmold.drawFlash(550,280, 200, 150);
			
			g.drawString("The Gel Mold", 550, 40);
			g.drawString("The gel mold is a container for the", 550, 70);
			g.drawString("gel to sit in it allows the gel to ", 550, 90);
			g.drawString("settle and harden.", 550, 110);
			
			if(gelmoldadded == false){
				objComp = objComp+1;
				gelmoldadded = true;
			}
			
		}
	
		if(mousey>=246 && mousey<=260 && mousex>=754 && mousex<=842 || mousey>=224 && mousey<=246 && mousex>=768 && mousex<=830 ){
			comb.drawFlash(750,330, 100, 50);
			
			g.drawString("The Comb", 550, 40);
			g.drawString("The comb is a device used to carve ", 550, 70);
			g.drawString("equal size holes in the gel agarose", 550, 90);
			g.drawString("this is where you place the dna", 550, 110);
			
			if(combadded == false){
				objComp = objComp+1;
				combadded = true;
			}
			
		}
		}
		
		total = objectives *25;
		score = objComp *25;
		
		g.setColor(Color.black);
		g.drawString("Objectives ", 220, 555);
			g.drawString(" " +objComp +'/' +objectives, 330, 555);
		g.drawString("Total Score ", 220, 575);
			g.drawString(" " +score +'/' +total, 330, 575);
			
			if(objComp == objectives && score == total && stilllearning == false){
				g.setColor(Color.black);
				g.fillRect(0,0,900,550);
				blackboard.draw(150,70,600,400);
					nextbutton.draw(680,410);
					backbutton.draw(180,410);
					//cleared.draw(270,100);
						g.setColor(Color.white);
						g.drawString("Gel Electrophoresis [Materials] COMPLETE! ", 300, 200);
						g.drawString("Making the Gel [Gel Agarose] *", 300, 220);
						g.drawString("Score - " +score +"/" +score , 350, 250);
						g.drawString("Total - " +score +"/" +total , 350, 270);
						g.drawString("Objectives - " +objectives +"/" +objectives , 350, 290);
						g.drawString("Click the next button to continue!", 400, 500);

				canlearn = false;
				if(Mouse.isButtonDown(0)){
					if(mousex > 681 && mousex < 715 && mousey < 186 && mousey > 156){
							sbg.enterState(3);
					}
				}
			}
			
			if(mousex>=162 && mousex<=190 && mousey<=45 && mousey>=10){
				if(input.isMousePressed(0)){
					 clicked = true;
				}
			}
			
			if(clicked == true && canlearn == true){
				blackboard.draw(150,100,600,400);
			}
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
	// put your inputs here provide actions
		int mousex = Mouse.getX();
		int mousey = Mouse.getY();
		
		if(canlearn == true){

		if(mousey>=246 && mousey<=260 && mousex>=754 && mousex<=842 || 
				mousey>=224 && mousey<=246 && mousex>=768 && mousex<=830 || 
				mousey>=180 && mousey<=220 && mousex>=555 && mousex<=746 || 
				mousey>=220 && mousey<=270 && mousex>=550 && mousex<=743 || 
				mousey>=270 && mousey<=305 && mousex>=560 && mousex<=720 || 
				mousey<=285 && mousey>=170 && mousex<=458 && mousex>=385 || 
				mousey>=350 && mousey<=370 && mousex>=455 && mousex<=505 || 
				mousey>=300 && mousey<=340 && mousex>=440 && mousex<=515 || 
				mousey>=285 && mousey<=320 && mousex>=440 && mousex<=515 || 
				mousey>=215 && mousey<=285 && mousex>=460 && mousex<=515 || 
				mousey<=375 && mousey>=285 && mousex<=390 && mousex>=365 || 
				mousex>=340 && mousex<=380 && mousey<=270 && mousey>=220 || 
				mousex>=360 && mousex<=380 && mousey<=285 && mousey>=270 || 
				mousey<=400 && mousey>=200 && mousex<=300 && mousex>=15 ){
			stilllearning = true;
		}
		else{
			stilllearning = false;
		}
		}
		
	}
	// makes this game state 0
	@Override
	public int getID() {return 2;}
}

