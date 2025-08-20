package com.example.expensetracker.model;

public enum Category {
    FOOD("Food & Dining", "🍽️"),
    TRANSPORT("Transportation", "🚗"),
    ENTERTAINMENT("Entertainment", "🎬"),
    UTILITIES("Utilities", "💡"),
    HEALTHCARE("Healthcare", "🏥"),
    SHOPPING("Shopping", "🛍️"),
    EDUCATION("Education", "📚"),
    TRAVEL("Travel", "✈️"),
    INVESTMENT("Investment", "📈"),
    OTHER("Other", "📦");

    private final String displayName;
    private final String emoji;

    Category(String displayName, String emoji) {
        this.displayName = displayName;
        this.emoji = emoji;
    }

    public String getDisplayName() { return displayName; }
    public String getEmoji() { return emoji; }

    public static Category fromString(String input) {
        for (Category cat : values()) {
            if (cat.name().equalsIgnoreCase(input) ||
                    cat.displayName.equalsIgnoreCase(input)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("Invalid category: " + input);
    }

}
