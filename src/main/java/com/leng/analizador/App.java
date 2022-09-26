package com.leng.analizador;

import java.io.IOException;

import com.leng.analizador.analyzer.controller.AnalyzerController;
import com.leng.analizador.analyzer.controller.parser.ParserFactory;
import com.leng.analizador.analyzer.controller.scanner.ScannerFactory;
import com.leng.analizador.utils.ManagedFiles;

/**
 * Hello world!
 *
 */
public class App 
{

    private final String firstPath = "/home/oliver/workspace-public/test/file1.js";

    public static void main( String[] args )
    {
        new App().executeTestAnalysis();
    }

    public void executeTestAnalysis(){
        AnalyzerController firstTest = new AnalyzerController(ScannerFactory.JSSTACKAUTOMAT , ParserFactory.JSFINITAUTOMAT);
        if (!firstTest.setSource(firstPath)){
            System.out.println("error en el analisis, intente de nuevo");
            return;
        }
        
        if (!firstTest.doAnalysis()){
            System.out.println("no se pudo completar el analisis");
            return;
        }

        if (firstTest.areErrors()){
            System.err.println("El archivo tenia errores");
            System.err.println("mostrando errores");
            System.err.println(firstTest.areErrors());
            
            showAnalysisResult(firstTest);
            return;
        }

        showAnalysisResult(firstTest);
        //           continuar con las otras fases
        //           de compilación
    }

    public void showAnalysisResult(AnalyzerController analyzer){
        System.out.println("Syntax tree");
        System.out.println(analyzer.getSyntaxTree());
        System.out.println(analyzer.getSymbolTable());

    }

}
