package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Fboss extends Personaje implements NPC, Disparable {

	public Fboss(int x, int y, Texture tx, int vidas, int xSpeed, int ySpeed, int size) {
		super(x, y, tx, vidas);
		vidas = 3;
		x = Gdx.graphics.getWidth() / 2 ;
		y = 500;
		spr.setPosition(x, y);
		
	}

	@Override
	public void Disparar() {
		
		
	}
	
	@Override
	public void movimiento() {
		if (vidas == 3) {
			
		}
		
		if (vidas == 2) {
			
		}
		
		if (vidas == 1) {
			
		}
		
	}
	

	@Override
	public int getVidas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
