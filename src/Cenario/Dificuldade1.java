package Cenario;


public class Dificuldade1 implements Cenario {

	@Override
	public boolean geraCenario(int dificulade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] random(int tamanho) {
		int numeros[] = new int[tamanho];
		
		for (int i = 0, j=((tamanho/2)-1); i < (tamanho); i+=2, j--) {
			numeros[i] = i;
			numeros[i+1] = j;
		}

		return numeros;
	}
	
//	@Override
//	public int[] random(int tamanho) {
//		Random r = new Random();
//		int numeros[] = null;
//		for (int i = 0; i < tamanho; i++) {
//			int numero = r.nextInt(tamanho / 2);
//			while (buscaReptido(numero, numeros) == 2) {
//				numero = r.nextInt(tamanho / 2);
//			}
//			numeros[i] = numero;
//		}
//
//		return numeros;
//	}

	@Override
	public int buscaReptido(int numero, int[] numeros) {
//		if (numeros == null){
//			return 0;
//		}
		
		int cont = 0;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == numero){
				cont++;
			}
			System.out.println("cont"+cont + " "+numero);
		}
		return cont;
	}
	
	

}
