
public class Sudoku {
	//private int[][] tablero = new int[9][9];
	private int[][] tablero = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
							   {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0},
	                           {0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	public Sudoku() {
		
	}
	
	private int[] encontrarDisponible() {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if (tablero[i][j] == 0) {
					int[] disponible = new int[] {i, j};
					return disponible;
				}
			}
		}
		
		return null;
	}
	
	public boolean resolver(){ 
		// resuelve el sudoku con backtracking
		
		// buscamos un espacio disponible para poner un número guardando la fila y columna de este
		int[] disponible = encontrarDisponible();
		
		// si disponible es null significa que se terminó de resolver el sudoku correctamente
		if(disponible == null) {
			return true;
		}
		
		
		
		return true;
	}
}
