package com.sagar.Demojunit;

public class Calculator {

    CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int perform(int a, int b) {
        return calculatorService.add(a, b)*a;
    }
}
