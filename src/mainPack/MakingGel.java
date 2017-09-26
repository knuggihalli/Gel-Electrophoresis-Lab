package mainPack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MakingGel extends BasicGameState {
	
	Image flask,agarose,table, spoon, buffer,cap,microwave;
	
	public int xpos = 380, ypos= 300;
	public int a = 5;
	public int mousex, mousey;
	public int fwidth = 80, fheight = 150;
	
	public float cxpos = 450, cypos = 240;
	public float sxpos = 540, sypos = 300;
	public float axpos = 440, aypos = 240;
	public float bxpos = 250, bypos = 240;
	public float mxpos = 900, mypos = 200;
	public float fxpos = 340, fypos = 240;
	
	
	public String updatebar = "Remove the cap from the Agarose container";
	public String materialbar = "No material choosen";
	
	public boolean capispicked = false;
	public boolean caprect = false;
	public boolean capdown = false;
	public boolean capispickable = true;
	public boolean spoonispicked = false;
	public boolean agaroseinspoon = false;
	public boolean agaroseinflask = false;
	public boolean spoonispickable = true;
	public boolean buffercanbeseen = true;
	public boolean bufferispicked = false;
	public boolean bufferinflask = false;
	public boolean bufferispickable = true;
	public boolean spillnoise = false;
	public boolean microwavepresent = false;
	public boolean microwaveisopen = false;
	public boolean flaskcanbepicked = false;
	public boolean flaskispicked = false;
	public boolean flaskisinmicrowave = false;
	
	Sound capsound,spillsound,microwavesound;
	

	public MakingGel(int state) {}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		table = new Image("res/Menu/menu.png");
		agarose = new Image("res/Materials/Agrose.png");
		flask = new Image("res/Materials/flask.png");
		spoon = new Image("res/Materials/Spoon.png");
		buffer = new Image("res/Materials/buffer.png");
		cap = new Image("res/Materials/AgaroseCap.png");
		microwave = new Image("res/Materials/microwave.png");
		
		capsound = new Sound("res/Sounds/bottleopen.wav");
		spillsound = new Sound("res/Sounds/pourbuffer.wav");
		microwavesound = new Sound("res/Sounds/microwave.wav");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g )throws SlickException{
	// Draw graphics here put anything you want on the screen
		@SuppressWarnings("unused")
		Input input = gc.getInput();
		mousey = 600-Mouse.getY();
		mousex = Mouse.getX();
		
		table.draw(0,0);
		spoon.draw(sxpos,sypos,120,120);
		agarose.draw(axpos,aypos,80, 150);
		buffer.draw(bxpos,bypos,80, 150);
		microwave.draw(mxpos,mypos,300,200);
		flask.draw(fxpos,fypos,fwidth,fheight);
		cap.draw(cxpos,cypos,60,20);
		
		g.setColor(Color.darkGray);
		g.fillRect(0,550,900,300);	
		g.setColor(Color.white);
		//g.drawString( "MOUSEX- "+mousex+" MOUSEY- "+mousey, 650, 555);
		g.drawString( updatebar , 10, 565);
		g.drawString( "Material Description -", 10, 10);
		g.drawString( materialbar , 10, 30);
		
		if(capispicked == true){
			capispickable = false;
			cxpos = mousex;
			cypos = mousey;
			caprect = true;
			if(caprect == true){
				updatebar = "Now place the cap in the rectangle";
				g.setColor(Color.red);
				g.drawRect(200, 350, 90, 100);	
				if(mousex>=200 && mousex<=230 && mousey<=430 && mousey>=350 && Mouse.isButtonDown(0)){
					capdown = true;
				}
			}
		}
		if(capdown == true){
			capispicked = false;
			caprect = false;
			cxpos = 216;
			cypos = 410;
			updatebar = "Use the spoon to remove some agarose";
			g.setColor(Color.red);
			g.drawRect(620, 380, 20, 20);	
		}
		if(spoonispicked == true){
			materialbar = "A spoon is an object use to scoop material";
			spoonispickable = false;
			sxpos = (mousex-100);
			sypos = mousey-100;
			spoon.rotate((float) -.5);	
			float rot = spoon.getRotation();
			if(rot <= -90){
				spoon.rotate((float) .5);	
			}
			g.setColor(Color.red);
			g.drawRect(455, 240, 50, 50);
			if(mousex>=526 && mousex<=537 && mousey<=235 && mousey>=216 && Mouse.isButtonDown(0)){
				agaroseinspoon = true;
			}
		}
		if(agaroseinspoon == true){
			spoonispicked = false;
			spoon = new Image("res/Materials/spoonAgarose.png");
			materialbar = "\n The Agarose" +
					"\n Agar or agar-agar is a gelatinous" +
					"\n substance derived from red algae";
			updatebar = "Now put the Agarose in the flask";
			sxpos = mousex-90;
			sypos = mousey-20;
			spoon.rotate((float) -.5);	
			float rot = spoon.getRotation();
			if(rot <= -90){
				spoon.rotate((float) .5);	
			}
			g.setColor(Color.red);
			g.drawRect(354, 220, 50, 50);
			if(mousex>=427 && mousex<=438 && mousey<=203 && mousey>=186 && Mouse.isButtonDown(0)){
				agaroseinflask = true;
			}
		}
		if(agaroseinflask == true){
			agaroseinspoon = false;
			sxpos = 999999;
			sypos = 999999;
			axpos = 999999;
			aypos = 999999;
			cxpos = 999999;
			cypos = 999999;
			flask = new Image("res/Materials/flaskAgarose.png");
			materialbar = "\n The Flask" +
					"\n A narrow-necked glass container," +
					"\n typically conical or spherical," +
					"\n used in a laboratory to hold reagents" +
					"\n or samples.";
			updatebar = "Pick up the buffer and spill it into the flask";
			buffercanbeseen = true;
		}
	
		if(bufferispicked == true){
			bxpos = mousex-30;
			bypos = mousey-100;
			buffer.rotate((float) -.5);
			float rot = buffer.getRotation();
			if(rot <= -90){
				buffer.rotate((float) .5);	
			}
			g.setColor(Color.red);
			g.drawRect(mousex-70, mousey+20, 25, 25);
			g.drawRect(368, 230, 25, 25);
			if(mousex>=435 && mousex<=442 && mousey<=213 && mousey>=207 && Mouse.isButtonDown(0)){
				bufferinflask = true;
			}
			updatebar = "Pour the buffer into the flask";
			materialbar = "\n The Buffer" +
					"\n The buffer contains ions which allow" +
					"\n for the electricity to actually" +
					"\n pass through the apparatus.";
		}
		if(bufferinflask == true){
			bxpos = 999999;
			bypos = 999999;
			bufferispicked = false;
			bufferispickable = false;
			spillnoise = true;
			flask = new Image("res/Materials/flaskBuffer.png");
			updatebar = "Great now open the microwave";
			materialbar = "No Materials Selected";
			flaskcanbepicked = false;
			microwavepresent = true;
		}
		if(microwavepresent == true){
			mxpos -= 2 * .2f;
			if(mxpos <= 500){
				mxpos = 500;
			}
			g.setColor(Color.red);
			g.drawRect(742, 347, 25, 25);
			if(mousex>=744 && mousex<=765 && mousey<=372 && mousey>=345 && Mouse.isButtonDown(0)){
				microwaveisopen = true;
			}
		}
		if(microwaveisopen == true){
			mxpos = 500;
			microwavepresent = false;
			microwave = new Image("res/Materials/microwaveOpen.png");
			updatebar = "Pick up the flask and place it in the microwave";
			flaskcanbepicked = true;
		}
		if(flaskispicked == true){
			microwavepresent = false;
			fxpos = mousex-40;
			fypos = mousey-100;
			if(mousex>=504 && mousex<=786 && mousey>=203 && mousey<=390 && Mouse.isButtonDown(0)){
				flaskisinmicrowave = true;
			}
			materialbar = "\n The Flask" +
					"\n A narrow-necked glass container," +
					"\n typically conical or spherical," +
					"\n used in a laboratory to hold reagents" +
					"\n or samples.";
		}
		if(flaskisinmicrowave == true){
			fxpos = 590;
			fypos = 260;
			fwidth = 50;
			fheight = 100;
			microwave = new Image("res/Materials/microwaveOn.png");
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
	// put your inputs here provide actions
		@SuppressWarnings("unused")
		Input input = gc.getInput();
		
		if(mousex>=447 && mousex<=511 && mousey>=245 && mousey<=262 && Mouse.isButtonDown(0) && capispickable == true){
			capispicked = true;
			capsound.play();
		}
		if(mousex>=621 && mousex<=640 && mousey>=383 && mousey<=400 && Mouse.isButtonDown(0) && capdown == true && spoonispickable == true){
			capdown = false;
			spoonispicked = true;
		}
		if(mousex>=250 && mousex<=330 && mousey>=260 && mousey<=360 && Mouse.isButtonDown(0) && spoonispickable == false && bufferispickable == true){
			bufferispicked = true;
		}
		if(mousex>=370 && mousex<=385 && mousey>=257 && mousey<=309  && Mouse.isButtonDown(0) && flaskcanbepicked == true || mousex>=344 && mousex<=411 && mousey>=309 && mousey<=386 && Mouse.isButtonDown(0) && flaskcanbepicked == true){
			flaskispicked = true;
		}
		if(spillnoise == true){
			spillnoise = false;
		}
		if(flaskisinmicrowave == true){
			//microwavesound.play((float) 1, 4);
		}
	}
		
	// makes this game state 0
	@Override
	public int getID() {return 3;}
}

