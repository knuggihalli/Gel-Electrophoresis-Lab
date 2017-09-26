package mainPack;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class projectHandler extends StateBasedGame{
	
		//Name of Application
		public static final String appname = "GEL ELECTROPHORESIS LAB";
		
		//State holder like Menu level one and stuff, holder of states
		//game handler extends state based game and these are those states
		//each state is given a number to switch to
		public static final int projecttitle = 0;
		public static final int appmenu = 1;
		public static final int materials = 2;
		public static final int makinggel = 3;
		
		
		//in the comments below there is a section that shows the screen width
		//and the screen height these are those unset variables
		public static int width;
		public static int height;
		
		//this is where i add the states to the actual game
		//the game handler takes in  the string gamename above
		// the game name is the title of the game

		public projectHandler(String appname) {
			super(appname);
			//create a level and add to the game
			//new gamename and integer of its state
			this.addState(new projectTitle(projecttitle));
			this.addState(new AppMenu(appmenu));
			this.addState(new Materials(materials));
			this.addState(new MakingGel(makinggel));
		}
		
		public void initStatesList(GameContainer gc) throws SlickException {
			//have to add the gamestate number to the game container
			//allows the game to jump between game states.
			this.getState(projecttitle).init(gc, this);
			//this is the menu the first thing that happens when 
			//the game starts is that it goes to the menu.
			this.enterState(projecttitle);
		}

		public static void main(String[] args) {
			//creates the game container and starts the game
			//the comments below are if it should be full screen
			//or should be larger in size
			AppGameContainer appgc;
			try{
				// the new game handler should be the name of this class
				appgc = new AppGameContainer(new projectHandler(appname));
				appgc.setDisplayMode(900, 600, false);
				//appgc.setVSync(true); 
				//appgc.setDisplayMode(appgc.getScreenWidth()/2 , appgc.getScreenHeight()/2, false);
				//width = appgc.getScreenWidth();
				//height = appgc.getScreenHeight();
				//System.out.println(" " +width +height);
				appgc.start();
			}catch(SlickException e){e.printStackTrace();}
		}
}