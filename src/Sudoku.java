import java.util.Arrays;

public class Sudoku {
	public int[][] tablero = new int[9][9];
	
	public static int posiblesNumeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public Sudoku(int tablero[][]) {
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9;j++) {
				this.tablero[i][j] = tablero[i][j];
			}
		}
	}
	
	public void mostrar() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print("["+tablero[i][j]+"]");
			}
			System.out.println("");
		}
	}
	
	private int[] encontrarDisponible() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if (tablero[i][j] == 0) {
					int[] disponible = new int[] {i, j};
					return disponible;
				}
			}
		}
		
		int[] disponible = new int[] {-1, -1};
		return disponible;
	}
	
	private boolean esValido(int numPosible, int[] disponible) {
		// revisar si esta el numero en la misma fila
		for(int number: tablero[disponible[0]]) {
			if(number == numPosible)
				return false;
		}
		// revisar si el numero esta en la misma columna
		for(int i = 0; i < 9; i++) {
			if(numPosible == tablero[i][disponible[1]]) {
				return false;
			}
		}
		// revisar si el numero esta en la misma submatriz
		int inicioFila = (disponible[0] / 3) * 3;
		int inicioColu = (disponible[1] / 3) * 3;
		
		for(int f = inicioFila; f < inicioFila + 3; f++) {
			for(int c = inicioColu; c < inicioColu + 3; c++) {
				if(numPosible == tablero[f][c])
					return false;
			}
		}
		
		return true;
	}
	
	public boolean resolver(){
		// resuelve el sudoku con backtracking
		
		// buscamos un espacio disponible para poner un número guardando la fila y columna de este
		int[] disponible = encontrarDisponible();
		int fila = disponible[0];
		int colu = disponible[1];
		
		// si disponible es null significa que se terminó de resolver el sudoku correctamente
		int termino[] = {-1, -1};
		if(Arrays.equals(disponible, termino)) {
			System.out.println("TERMINADO");
			return true;
		}
		
		// como encontramos un espacio disponible ahora debemos ver si el numero que pusimos es valido
		for(int numPosible: posiblesNumeros) {
			if(esValido(numPosible, disponible)) {
				// si el numero que probamos es valido, lo ponemos en el tablero
				tablero[fila][colu] = numPosible;
				// llamamos a la funcion recursivamente
				if(resolver()) {
					return true;
				}
			
			tablero[fila][colu] = 0;
			}
		}
		
		return false;
	}
	
}
