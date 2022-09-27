package com.leng.analizador.analyzer.controller.scanner;

import java.util.function.Supplier;

public enum ScannerFactory {
    JSSTACKAUTOMAT(ScannerTmp::new)
    ;

    private final Supplier<Scannable> scanner;

    ScannerFactory(Supplier<Scannable> scanner){
        this.scanner = scanner;
    }

    public Scannable getScanner() {
        return scanner.get();
    }
    
}
