package ua.bryzhatov.junit;

public class Calculator {

    public double div(double numerator, double denominator) {
        if (denominator == 0) {
            return -0;
        }
        return numerator / denominator;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double sub(double a, double b) {
        return a - b;
    }
}
