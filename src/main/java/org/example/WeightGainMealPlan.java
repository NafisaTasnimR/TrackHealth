package org.example;

public class WeightGainMealPlan implements MealPlanStrategy{

    @Override
    public String[] getMealSuggestions(String mealType) {
        return switch (mealType) {
            case "Breakfast" -> new String[]{"Oats, Rice Porridge, Whole Wheat Bread, Roti, Milk,Yogurt",
                    "Nuts, Honey, Butter, Cheese, Peanut Butter, Eggs"};
            case "Lunch" -> new String[]{"Rice, Whole Wheat Bread, Potatoes, Chicken, Lentils, Beans",
                    "Avocado, Olive Oil, Fish, Tofu, Vegetables"};
            case "Dinner" -> new String[]{"Whole Wheat Bread, Rice, Potatoes, Meat, Fish, Eggs",
                    "Lentils, Butter, Vegetables, Olive Oil, Soup"};
            case "Mid-Morning Snack" -> new String[]{"Bananas, Dates, Nuts, Almonds, Smoothies",
                    "Dark Chocolate, Cheese, Boiled Eggs"};
            case "Afternoon Snack" -> new String[]{"Yogurt, Trail Mix, Peanut Butter Toast",
                    "Fruit Salad, Nuts, Milkshake"};
            default -> new String[]{};
        };
    }
}
