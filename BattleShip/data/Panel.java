import java.util.Random;

public class Panel {
    private int rows;
    private int columns;
    private String[][] cells;
    private Random random = new Random();

    Panel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new String[rows][columns];
        createPanel();
    }

    private void createPanel() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                char column = (char)('A' + j);
                cells[i][j] = column + String.valueOf(i + 1);
            }
        }
    }

    public String getCell(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return cells[row][column];
        } else {
            throw new IndexOutOfBoundsException("La posición está fuera del rango del tablero.");
        }
    }

    public String getRandomCell() {
        return cells[random.nextInt(rows)][random.nextInt(columns)];
    }

    public int selectDirection() {
        return random.nextInt(2);   //retorna 0 para horizontal y 1 para vertical
    }

    public int[] cellCoordinate(String point) {    //Devuelve los coordenadas de un punto
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(cells[i][j].equals(point)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;    //Si el punto no existe retorna un valor nulo
    }

    public void printPanel() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cells[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
