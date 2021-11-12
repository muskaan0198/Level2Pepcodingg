public class Main
{
	public static void main(String[] args) {
		int n = 4, m = 4, tq = 4;
		boolean board[][] = new boolean[n][n];
		boolean[] row = new boolean[n];
	    boolean[] col = new boolean[m];
	    boolean[] diag = new boolean[n + m - 1];
	    boolean[] antiDiag = new boolean[n +m - 1];
		System.out.print(queenPermutation2D(board,row,col, diag, antiDiag, tq, ""));
	}
	
	public static int queenPermutation2D(boolean[][] board,boolean[] row, boolean[] col, boolean[] diag, boolean[] antiDiag,int tq, String asf){
	    if (tq == 0){
        System.out.println(asf);
        return 1;
    }  

    int count = 0, n = board.length, m = board[0].length;
    for (int i = 0; i < n * m; i++)
    {
        int r = i / m, c = i % m;
        if(!row[r] && !col[c] && !diag[r + c] && !antiDiag[r - c + m - 1])
        { 
            row[r] = col[c] = diag[r + c] = antiDiag[r - c + m - 1] = true;
            board[r][c] = !board[r][c];
            count += queenPermutation2D(board, row, col, diag, antiDiag,tq - 1, asf + "(" + r + "," + c + ") ");
            board[r][c] = !board[r][c];
            row[r] = col[c] = diag[r + c] = antiDiag[r - c + m - 1] = false;
        }
    }

    return count;
	}
}

