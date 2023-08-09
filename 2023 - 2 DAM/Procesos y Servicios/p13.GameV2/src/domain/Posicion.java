package domain;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Posicion(Posicion posi) {
		this(posi.getX(),posi.getY());
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incX() {
		x++;
		
	}

	public void incY() {
		y++;
		
	}
	public void decX() {
		x--;
		
	}

	public void decY() {
		y--;
		
	}
	public void setX(int i) {
		x=i;
		
	}
	
	public void setY(int i) {
		y=i;
		
	}

	public boolean esMisma(Posicion posi) {
		
		return (x==posi.getX()) && (y==posi.getY());
	}

}
