package org.example;

import java.util.Objects;

public class WeightMaintenanceGoal extends Goal implements WeightChangeCalculator,BMRCalculator,CalorieCalculator,BMICalculator{
    public WeightMaintenanceGoal(double currentWeight, double height, int durationInWeek, String exercisePlace) {
        super(currentWeight, height, durationInWeek, exercisePlace);
    }

    @Override
    public double calculateWeeklyWeightChange() {
        return 0;
    }

    @Override
    public double calculateBMI(double currentWeight, double height) {
        return (currentWeight/Math.sqrt((height/100)));
    }

    @Override
    public String getWeightCategory(double BMI) {
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

    @Override
    public double calculateDailyCalorieNeed(double TDEE) {
        return TDEE;
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
            System.out.printf("| %-94s |\n","You Are Maintaining Your Current Weight");
            System.out.printf("| %-94s |\n","Tips: Avoid Overeating & Stick to your TDEE");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8s |\n", "Meal", "Food Items", "Calories");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Morning",
                    "Eggs, Whole Grain Bread, Oats, Rice Porridge,", breakfastCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Yogurt, Coffee, Tea, Milk", "");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Mid-Morning Snack",
                    "Greek Yogurt, Nuts,", snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    " Fruits (Berries, Orange, Banana)","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Lunch",
                    "Brown Rice, Whole Wheat Bread, Fish, Lentils,",lunchCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Chicken, Veggies, Salad","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Afternoon Snack",
                    "Boiled Egg, Trail Mix, Milkshake",snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Fruit Salad, Protein Bar","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Dinner",
                    "Rice or Bread, Vegetables, Soup, Potatoes, Beans,",dinnerCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    " Fish or Chicken, Vegetables","");
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
