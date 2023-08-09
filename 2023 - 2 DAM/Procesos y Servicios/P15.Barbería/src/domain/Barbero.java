package domain;

public class Barbero extends Thread{

	private int id;
	private GestorSillas gestorSillas;
	private boolean barberiaFuncionando;
	
	public Barbero(int id, GestorSillas gestorSillas) {
		this.id = id;
		this.gestorSillas = gestorSillas;
		this.barberiaFuncionando = true;
		this.start();
	}

	public void run() {
		int siguienteSilla;
		while (barberiaFuncionando) {
			siguienteSilla = gestorSillas.getSiguienteCliente();
			if (siguienteSilla == -1) {
				//no hay clientes sin atender
				//esperamos antes de intentarlo
				try {
					System.out.println("Barbero "+id+" esperando clientes");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Barbero "+id+" atendiendo la silla "+siguienteSilla);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//liberamos la silla
				this.gestorSillas.liberar(siguienteSilla);
			}
		}
	}
	
	public void cerrarBarberia() {
		barberiaFuncionando = false;
	}
}
