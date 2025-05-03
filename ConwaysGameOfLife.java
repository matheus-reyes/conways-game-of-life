import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConwaysGameOfLife {
    public static void main(String[] args) throws IOException {
        Set<Cell> aliveCells = new HashSet<Cell>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        String[] coordinates = new String[2];

        while ((inputLine = bufferedReader.readLine()) != null) {
            if(inputLine.startsWith("#") || inputLine.isEmpty()) continue;
            coordinates = inputLine.trim().split("\\s+");
            aliveCells.add(new Cell(Long.parseLong(coordinates[0]), Long.parseLong(coordinates[1])));
        };

        for (int iterationOfGameOfLife = 0; iterationOfGameOfLife < 10; iterationOfGameOfLife++) {
            aliveCells = runGameOfLifeIteration(aliveCells);
        }

        for (Cell aliveCell : aliveCells) {
            System.out.println(aliveCell.x + " " + aliveCell.y);
        }
    }

    private static Set<Cell> runGameOfLifeIteration(Set<Cell> currentCells){
        Map<Cell, Integer> neighborsCount = new HashMap<Cell, Integer>();

        for(Cell cell: currentCells){
            for(long differenceXCoordinate = -1; differenceXCoordinate <= 1; differenceXCoordinate++){
                for(long differenceYCoordinate = -1; differenceYCoordinate <= 1; differenceYCoordinate++){
                    if (differenceXCoordinate == 0 && differenceYCoordinate == 0) continue; // Current Cell, we want to check just the neighbors
                    Cell neighborCell = new Cell(cell.x + differenceXCoordinate, cell.y + differenceYCoordinate);
                    neighborsCount.put(neighborCell, neighborsCount.getOrDefault(neighborCell, 0) + 1);
                }
            }
        }

        Set<Cell> nextCells = new HashSet<Cell>();

        for(Map.Entry<Cell, Integer> neighborsCountEntry: neighborsCount.entrySet()){
            Cell neighborCell = neighborsCountEntry.getKey();
            Integer neighborCount = neighborsCountEntry.getValue();
            if(neighborCount == 3 || neighborCount == 2 && currentCells.contains(neighborCell)){
                nextCells.add(neighborCell);
            }
        }

        return nextCells;
    }
}
