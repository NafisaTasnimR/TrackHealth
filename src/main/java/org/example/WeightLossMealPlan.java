package org.example;

public class WeightLossMealPlan implements MealPlanStrategy{
    @Override
    public String[] getMealSuggestions(String mealType) {
        return switch (mealType) {
            case "Breakfast" -> new String[]{"Eggs, Whole Grain Bread, Oats, Rice Porridge, Yogurt",
                    "Fruits, Avocado, Nuts (Almonds, Walnuts), Coffee, Tea"};
            case "Lunch" -> new String[]{"Brown Rice, Whole Wheat Bread, Fish, Lentils",
                    "Grilled Chicken, Steamed Veggies, Salad, Olive Oil"};
            case "Dinner" -> new String[]{"Rice or Bread, Vegetables, Soup, Tofu, Beans",
                    "Grilled Fish or Chicken, Stir-Fried Veggies with Olive Oil"};
            case "Mid-Morning Snack" -> new String[]{"Greek Yogurt, Nuts, Fruits (Berries, Orange, Banana)",
                    "Dark Chocolate(At least 70% cocoa), Cottage Cheese"};
            case "Afternoon Snack" -> new String[]{"Boiled Egg, Trail Mix, Low-Fat Cheese",
                    "Fruit Salad, Protein Bar"};
            default -> new String[]{};
        };
    }
}
