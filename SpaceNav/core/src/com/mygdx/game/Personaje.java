package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Personaje {
	protected int x;
	protected int y;
	protected boolean muerto = false;
	protected int vidas;
	protected Sprite spr;
    protected boolean herido = false;

    public Personaje(int x, int y, Texture tx, int vidas) {
    	this.vidas = vidas;
    	spr = new Sprite(tx);
    	this.x = x;
    	this.y=y;
    	spr.setPosition(x, y);
    }
    
     public abstract int getVidas(); 
     public abstract int getX();
     public abstract int getY(); 
}
