package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.Timer;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreGameMode;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.ShoreView;

public class ShoreController extends MouseAdapter implements Controller {

	private ShoreModel model;
	private ShoreView view;
	private ShoreItem clicked;
	private int countWait;
	
	public ShoreController(){
		
		model = new ShoreModel();
		view = new ShoreView(model);
		view.addMouseListener(this);
		
	}
	
	@Override
	public void tick(){
		model.onTick();
		view.repaint();
		if(model.getGameMode() == ShoreGameMode.TUTORIAL){
			view.displayTextbox();
			if(model.getTutorialStage() == 8 && view.getTutorialCountdown() > 0 ){
				if((int) (model.getTickCount() % 70) == (int)(countWait % 70)){
					view.setTutorialCountdown();
					if(view.getTutorialCountdown() == 0){
						model.setGameMode(ShoreGameMode.NORMAL);
						model.setTutorialStage(-3);
					}
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		if(model.getGameMode() == ShoreGameMode.TUTORIAL){
			if(model.getTutorialStage() > 0 && model.getTutorialStage() < 8){
				int CONTINUE_X = (int) (model.getTiles().get(model.getTilesInRow()-4).get((int)(model.getTilesInColumn()-3)).getTileOrigin().getShoreX());
				int CONTINUE_Y = (int) (model.getTiles().get(model.getTilesInRow()-4).get((int)(model.getTilesInColumn()-3)).getTileOrigin().getShoreY());
				if(e.getX() > CONTINUE_X && e.getX() < CONTINUE_X + model.getTileWidth()*4
				&& e.getY() > CONTINUE_Y && e.getY() < CONTINUE_Y +model.getTileHeight()*2){
					model.setTutorialStage(model.getTutorialStage()+1);
					if(model.getTutorialStage() == 8){
						countWait = model.getTickCount();
					}
				}
			}	
		}
		if(model.getGameMode() == ShoreGameMode.NORMAL){	
			for(ShoreItem item: model.getItems()){
					int BOX_X = (int) item.getContainedWithin().getTileOrigin().getShoreX();
					int BOX_Y = (int) item.getContainedWithin().getTileOrigin().getShoreY();
					if(e.getX() > BOX_X && e.getX() < BOX_X + model.getTileWidth()
					&& e.getY() > BOX_Y && e.getY() < BOX_Y + model.getTileHeight()){
						clicked = item;
					}
				}
			if(clicked != null){
				model.onClick(clicked);
			}
			if(model.isBuildDefense()){
				for(int i = 0; i < model.getTilesInRow(); i++){
					for(int j = model.getTilesInColumn()/2 ; j < model.getTilesInColumn(); j++){
						int TILE_X = (int) model.getTiles().get(i).get(j).getTileOrigin().getShoreX();
						int TILE_Y = (int) model.getTiles().get(i).get(j).getTileOrigin().getShoreY();
						if(e.getX() > TILE_X && e.getX() < TILE_X + model.getTileWidth()
						&& e.getY() > TILE_Y && e.getY() < TILE_Y + model.getTileHeight()){
							model.buildDefense(i,j);
						}
					}
				}
			}
			clicked = null;
			}
		
		int EXIT_X = (int) (model.getTiles().get(model.getTilesInRow()-2).get(0).getTileOrigin().getShoreX());
		if(e.getX() > EXIT_X && e.getX() < EXIT_X + model.getTileWidth()*2
		&& e.getY() > 0 && e.getY() < model.getTileHeight()){
			Main.getInstance().setController(new MenuController());
			return;
		}
	}
	@Override
	public JComponent getView() {
		return view;
	}
	
	
}
