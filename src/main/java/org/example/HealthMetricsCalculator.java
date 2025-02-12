package org.example;

import java.util.Objects;

public class HealthMetricsCalculator {
    public static double calculateBMI(double currentWeight, double height) {
        return (currentWeight/Math.sqrt((height/100)));
    }

    public static String getWeightCategory(double BMI) {
        if(BMI < 18.5) {
            return "BMI Category: Underweight";
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            return "BMI Category: Normal";
        } else if (BMI >= 25.00 && BMI <= 29.9) {
            return "BMI Category: Overweight";
        } else if (BMI >= 30.00) {
            return "BMI Category: Obesity";
        }
        return null;
    }

    public static double calculateBMR(double weightInKg, double heightIncm, int age, String gender) {
        double BMRValue;
        if(Objects.equals(gender, "male"))
        {
            BMRValue = 88.362 + (13.397*weightInKg) + (4.799*heightIncm) - (5.677*age);
        }
        else {
            BMRValue = 447.593 + (9.247*weightInKg) + (3.098*heightIncm) - (4.330*age);
        }
        return BMRValue;
    }

    public static double calculateTDEE(double BMR, String activityLevel) {
        double activityFactor;
        if(Objects.equals(activityLevel,"Sedentary"))
        {
            activityFactor = 1.2;
        } else if (Objects.equals(activityLevel,"Light Activity")) {
            activityFactor = 1.375;
        } else if (Objects.equals(activityLevel,"Moderate Activity")) {
            activityFactor = 1.55;
        } else if (Objects.equals(activityLevel,"Very Active")) {
            activityFactor = 1.725;
        } else if (Objects.equals(activityLevel,"Super Active")) {
            activityFactor = 1.9;
        }else {
            System.out.println("Choose correct activity level");
            activityFactor = 0.0;
        }
        return BMR*activityFactor;
    }
}
