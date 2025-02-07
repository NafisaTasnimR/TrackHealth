package org.example;

import java.util.Objects;

public class WeightLossGoal extends Goal implements WeightChangeCalculator,BMRCalculator,CalorieCalculator{
    public WeightLossGoal(double currentWeight, double height, int durationInWeek,
                          String exercisePlace) {
        super(currentWeight, height,
                durationInWeek, exercisePlace);
    }

    @Override
    public double calculateWeeklyWeightChange() {
        double weeklyWeightChange, weightChangeRation;
        if(getDurationInWeek() > 12)
        {
            weightChangeRation = 0.0020;
        }
        else {
            weightChangeRation = 0.0040;
        }
        weeklyWeightChange = getCurrentWeight()*weightChangeRation;
        return weeklyWeightChange;
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
        return (TDEE-625);
    }

    @Override
    public double calculateCalorieForBreakfast(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.25;
    }

    @Override
    public double calculateCalorieForLunch(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.35;
    }

    @Override
    public double calculateCalorieForDinner(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.30;
    }

    @Override
    public double calculateCalorieForSnack(double dailyCalorieNeed) {
        return dailyCalorieNeed*0.10;
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
            System.out.printf("| %-94s |\n","Your Weekly Weight Loss Target Is " + calculateWeeklyWeightChange() + "kg");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8s |\n", "Meal", "Food Items", "Calories");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Morning",
                    "Eggs, Whole Grain Bread, Oats, Rice Porridge, Yogurt,", breakfastCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Fruits, Avocado, Nuts (Almonds, Walnuts), Coffee, Tea", "");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Mid-Morning Snack",
                    "Greek Yogurt, Nuts, Fruits (Berries, Orange, Banana),", snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Dark Chocolate(At least 70% cocoa), Cottage Cheese","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Lunch",
                    "Brown Rice, Whole Wheat Bread, Fish, Lentils,",lunchCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Grilled Chicken, Steamed Veggies, Salad, Olive Oil","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Afternoon Snack",
                    "Boiled Egg, Trail Mix, Low-Fat Cheese,",snackCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Fruit Salad, Protein Bar","");
            System.out.println("----------------------------------------------------------------------------------" +
                    "----------------");
            System.out.printf("| %-20s | %-60s | %-8.2f |\n", "Dinner",
                    "Rice or Bread, Vegetables, Soup, Tofu, Beans,",dinnerCalories);
            System.out.printf("| %-20s | %-60s | %-8s |\n", "",
                    "Grilled Fish or Chicken, Stir-Fried Veggies with Olive Oil","");
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
