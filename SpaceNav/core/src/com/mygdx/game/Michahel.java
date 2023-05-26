package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Michahel extends Personaje{
	private Sound soundBala;
    private Texture txBala;
    private int tiempoHerido;
    private int tiempoHeridoMax = 50;
	
	public Michahel(int x, int y, Texture tx, int vidas,boolean herido,boolean muerto, Texture txBala, Sound soundBala) {
		super (x,y,tx,vidas);
		this.soundBala = soundBala;
    	this.txBala = txBala;
	}
	public boolean estaMuerto(){
		return !herido && muerto;
 	}
	public boolean estaHerido() {
	   return herido;
   }
	
	public int getVidas(){
		return vidas;
	}
    public  int getX() {
    	return (int) spr.getX(); 
    }
    public  int getY() {
    	return (int) spr.getY();
    }
    public  void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public void draw(SpriteBatch batch, PantallaJuego juego){
        float x =  spr.getX();
        float y =  spr.getY();
        if (!herido) {
	        // que se mueva con teclado
        	if (Gdx.input.isKeyPressed(Input.Keys.A) && x>0)
        		x-=4;
	        if (Gdx.input.isKeyPressed(Input.Keys.D) && x+spr.getWidth() < Gdx.graphics.getWidth()) 
	        	x+=4;
        	if (Gdx.input.isKeyPressed(Input.Keys.S)  && y>0 ) 
        		y-=4;     
	        if (Gdx.input.isKeyPressed(Input.Keys.W) && y+spr.getHeight() < Gdx.graphics.getHeight()) 
	        	y+=4;
	        
	        spr.setPosition(x, y);   
         
 		    spr.draw(batch);
        } else {
 		   spr.draw(batch); 
 		  spr.setX(x);
 		 tiempoHerido--;
		   if (tiempoHerido<=0) herido = false;
 		 }
        // disparo
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {         
          Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,0,10,txBala);
	      juego.agregarBala(bala);
	      soundBala.play();
        }
       
    }
	
	public boolean checkCollision(Demonio b) {
        if(!herido && b.getArea().overlaps(spr.getBoundingRectangle())){
        	
        	//actualizar vidas y herir
            vidas--;
            herido = true;
  		    tiempoHerido=tiempoHeridoMax;
  		    
            if (vidas<=0) 
          	    muerto = true; 
            return true;
        }
        return false;
    }
	
}

	