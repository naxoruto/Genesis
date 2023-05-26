package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Demonio extends Personaje implements NPC {

    private int xSpeed;
    private int ySpeed;
    
	public Demonio(int x, int y, Texture tx, int vidas, int xSpeed, int ySpeed,int size) {
		super(x, y, tx, vidas);
		spr = new Sprite(tx);

        //validar que borde de esfera no quede fuera
    	if (x-size < 0) x = x+size;
    	if (x+size > Gdx.graphics.getWidth()) x = x-size;
    	this.x = x;
         
        //validar que borde de esfera no quede fuera
    	if (y-size < 0) y = y+size;
    	if (y+size > Gdx.graphics.getHeight()) y = y-size;
    	this.y=y;
    	
    	spr.setPosition(x, y);
    	
    	this.setXSpeed(xSpeed);
        this.setySpeed(ySpeed);
	}


	public int getVidas() {
		return this.vidas;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	

	 public Rectangle getArea() {
	    	return spr.getBoundingRectangle();
	    }
	 
	 @Override
	 public void movimiento() {
	        this.x += getXSpeed();
	        this.y += getySpeed();


			if (this.x < 0) {
				this.x = Gdx.graphics.getWidth();
			}
			if (this.x > Gdx.graphics.getWidth()) {
				this.x = 0;
			}

			if (this.y < 0) {
				this.y = Gdx.graphics.getHeight();
			}
			if (this.y > Gdx.graphics.getHeight()) {
				this.y = 0;
			} 
			System.out.print(Gdx.graphics.getWidth());
			
			spr.setPosition(x, y);
	  }
	 
	 public int getXSpeed() {
			return xSpeed;
		}
	 public int getySpeed() {
			return ySpeed;
		}
	 public void setXSpeed(int xSpeed) {
			this.xSpeed = xSpeed;
		}
	 public void setySpeed(int ySpeed) {
			this.ySpeed = ySpeed;
		}
	 public void draw(SpriteBatch batch) {
	    	spr.draw(batch);
	 }
	


	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
}
