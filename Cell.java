public class Cell {
    long x;
    long y;
   
    Cell(long x, long y){
        this.x = x;
        this.y = y;
    }

    //we need to override to use the attributes x and y to compare elements
    @Override
    public boolean equals(Object object) {
        Cell cellToCompare = (Cell) object;
        return this.x == cellToCompare.x && this.y == cellToCompare.y;
    }

    //we need to override to use the attributes x and y to generate the hashCode
    @Override
    public int hashCode() {
        return Long.hashCode(x) * 31 + Long.hashCode(y);
    }

}
