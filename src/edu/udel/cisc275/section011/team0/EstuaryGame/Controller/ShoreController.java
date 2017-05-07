package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.Timer;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.ShoreView;

public class ShoreController extends MouseAdapter implements Controller {

	private ShoreModel model;
	private ShoreView view;
	private ShoreItem clicked;
	
	public ShoreController(){
		
		model = new ShoreModel();
		view = new ShoreView(model);
		view.addMouseListener(this);
		
	}
	
	@Override
	public void tick(){
		model.onTick();
		view.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		for(ShoreItem item: model.getItems()){
				int BOX_X = (int) item.getContainedWithin().getTileOrigin().getShoreX();
				int BOX_Y = (int) item.getContainedWithin().getTileOrigin().getShoreY();
				if(e.getX() > BOX_X && e.getX() < BOX_X + model.getTileWidth()
				&& e.getY() > BOX_Y && e.getY() < BOX_Y + model.getTileHeight()){
					clicked = item;
				}
				//&& model.getTiles().get(i).get(j).getTileContents() instanceof ShoreItem);
					//Object o = model.getTiles().get(i).get(j).getTileContents();
					//model.onClick((ShoreItem)o);
			}
		model.onClick(clicked);
		
		if(model.isBuildDefense()){
			for(int i = 0; i < model.getTilesInRow(); i++){
				for(int j = model.getTilesInColumn()/2 ; j < model.getTilesInColumn(); j++){
					int TILE_X = (int) model.getTiles().get(i).get(j).getTileOrigin().getShoreX();
					int TILE_Y = (int) model.getTiles().get(i).get(j).getTileOrigin().getShoreY();
					if(e.getX() > TILE_X && e.getX() < TILE_X + model.getTileWidth()
					&& e.getY() > TILE_Y && e.getY() < TILE_Y + model.getTileHeight()){
						model.buildDefense(i,j);
						model.setBuildDefense(false);
					}
				}
			}
		}
		}

	@Override
	public JComponent getView() {
		return view;
	}
	
	
}
