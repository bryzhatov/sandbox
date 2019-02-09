package ua.bryzhatov.entity;

/**
 * @author Dmitry Bryzhatov
 * @since 07.12.2018
 */
public class Meta {
    private int column;
    private int row;
    private int startIndex;

    public Meta(int column, int row, int startIndex) {
        this.column = column;
        this.row = row;
        this.startIndex = startIndex;
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return "[column: " + column + "; row: " + row + "; start: " + startIndex + "]";
    }
}
