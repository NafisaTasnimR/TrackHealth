package org.example;

public interface BMICalculator {
    double calculateBMI(double currentWeight,double height);
    String getWeightCategory(double BMI);
}
