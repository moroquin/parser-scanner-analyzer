package com.leng.analizador.analyzer.models;

import javax.swing.text.Position;

import com.leng.analizador.analyzer.utils.FilePosition;

public class Token {
    private final TokenType tokenType;
    private final FilePosition filePosition;
    private final String lexeme;

    public Token(TokenType tokenType, FilePosition filePosition, String lexeme) {
        this.tokenType = tokenType;
        this.filePosition = filePosition;
        this.lexeme = lexeme;
    }   

    public TokenType getTokenType() {
        return this.tokenType;
    }


    public FilePosition getFilePosition() {
        return this.filePosition;
    }


    public String getLexeme() {
        return this.lexeme;
    }


    @Override
    public String toString() {
        return "{" +
            " tokenType='" + getTokenType() + "'" +
            ", filePosition='" + getFilePosition() + "'" +
            ", lexeme='" + getLexeme() + "'" +
            "}";
    }

    public int getLine(){
        return filePosition.getLine();
    }

    public int getColumn(){
        return filePosition.getColumn();
    }

    public String getFilePath(){
        return filePosition.getFilePath();
    }



}
