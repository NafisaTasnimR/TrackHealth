package org.example;

public class WeightMaintenanceMealPlan implements MealPlanStrategy{
    @Override
    public String[] getMealSuggestions(String mealType) {
        return switch (mealType) {
            case "Breakfast" -> new String[]{"Eggs,Whole Grain Bread,Oats,Rice Porridge",
                    "Yogurt, Coffee, Tea, Milk"};
            case "Lunch" -> new String[]{"Brown Rice, Whole Wheat Bread, Fish, Lentils",
                    "Chicken, Veggies, Salad"};
            case "Dinner" -> new String[]{"Rice or Bread, Vegetables, Soup, Potatoes, Beans",
                    "Fish or Chicken, Vegetables"};
            case "Mid-Morning Snack" -> new String[]{"Greek Yogurt, Nuts","Fruits (Berries, Orange, Banana)"};
            case "Afternoon Snack" -> new String[]{"Boiled Egg, Trail Mix, Milkshake",
                    "Fruit Salad, Protein Bar"};
            default -> new String[]{};
        };
    }
}
