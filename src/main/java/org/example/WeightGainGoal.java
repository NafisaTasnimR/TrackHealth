package org.example;

import java.util.Objects;

public class WeightGainGoal extends Goal implements WeightChangeCalculator,BMRCalculator,CalorieCalculator,BMICalculator{
    public WeightGainGoal(double currentWeight, double height,
                          int durationInWeek, String exercisePlace) {
        super(currentWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    public double calculateWeeklyWeightChange() {
        double weeklyWeightChange, weightChangeRation;
        if(getDurationInWeek() >= 12)
        {
            weightChangeRation = 0.0025;
        }
        else {
            weightChangeRation = 0.005;
        }
        weeklyWeightChange = getCurrentWeight()*weightChangeRation;
        return weeklyWeightChange;
    }

    @Override
    public double calculateBMI(double currentWeight, double height) {
        return (currentWeight/Math.sqrt((height/100)));
    }

    @Override
    public String getWeightCategory(double BMI) {
        if(BMI < 18.5)
        {
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

    @Override
    public double calculateBMR(double weightInKg, double heightIncm, int age, String gender) {
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

    @Override
    public double calculateTDEE(double BMR, String activityLevel) {
        double tdee,activityFactor;
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
        tdee = BMR*activityFactor;
        return tdee;
    }

    @Override
    public double calculateDailyCalorieNeed(double TDEE) {
        return TDEE + 350;
    }

    @Override
    public double calculateCalorieForBreakfast(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.2;
    }

    @Override
    public double calculateCalorieForLunch(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.3;
    }

    @Override
    public double calculateCalorieForDinner(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.3;
    }

    @Override
    public double calculateCalorieForSnack(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.1;
    }

    @Override
    public boolean setDietPlan(String gender,int age,String activityLevel) {
        double bmr = calculateBMR(getCurrentWeight(), getHeight(), age, gender);
        double tdee = calculateTDEE(bmr, activityLevel);
        double dailyCalorieNeed = calculateDailyCalorieNeed(tdee);
        double breakfastCalories = calculateCalorieForBreakfast(dailyCalorieNeed);
        double lunchCalories = calculateCalorieForLunch(dailyCalorieNeed);
        double dinnerCalories = calculateCalorieForDinner(dailyCalorieNeed);
        double snackCalories = calculateCalorieForSnack(dailyCalorieNeed);
        if(tdee != 0.00) {
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-94s |\n","Your Weekly Weight Gain Target Is " + calculateWeeklyWeightChange() + "kg");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8s |\n", "Meal", "Food Items", "Calories");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Morning",
                    "Oats, Rice Porridge, Whole Wheat Bread, Roti, Milk, Yogurt,",
                    breakfastCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                            "Nuts, Honey, Butter, Cheese, Peanut Butter, Eggs", "");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Mid-Morning Snack",
                    "Bananas, Dates, Nuts, Almonds, Smoothies,", snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Dark Chocolate, Cheese, Boiled Eggs","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Lunch",
                    "Rice, Whole Wheat Bread, Potatoes, Chicken, Lentils, Beans,",lunchCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Avocado, Olive Oil, Fish, Tofu, Vegetables","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Afternoon Snack",
                    "Yogurt, Trail Mix, Peanut Butter Toast,",snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Fruit Salad, Nuts, Milkshake","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Dinner",
                    "Whole Wheat Bread, Rice, Potatoes, Meat, Fish, Eggs,",dinnerCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Lentils, Butter, Vegetables, Olive Oil, Soup","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            return true;
        }
        return false;
    }

    @Override
    public String setWorkoutPlan() {
        return null;
    }

    @Override
    public String trackProgress() {
        return null;
    }
}
