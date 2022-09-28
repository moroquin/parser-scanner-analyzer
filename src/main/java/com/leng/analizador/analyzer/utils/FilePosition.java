package com.leng.analizador.analyzer.utils;

/**
 * FilePosition
 */
public class FilePosition {

    final private int line;
    final private int column;
    final private String filePath;
    /**
     * @param line
     * @param column
     * @param filePath
     */
    public FilePosition(int line, int column, String filePath) {
        this.line = line;
        this.column = column;
        this.filePath = filePath;
    }
    
    /**
     * @return the line
     */
    public int getLine() {
        return line;
    }
    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }
    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    
}