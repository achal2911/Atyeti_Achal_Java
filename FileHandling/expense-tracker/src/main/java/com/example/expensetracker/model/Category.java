package com.example.expensetracker.model;

public enum Category {
    FOOD("Food & Dining"),
    TRANSPORT("Transportation"),
    ENTERTAINMENT("Entertainment"),
    UTILITIES("Utilities"),
    HEALTHCARE("Healthcare"),
    SHOPPING("Shopping"),
    EDUCATION("Education"),
    TRAVEL("Travel"),
    INVESTMENT("Investment"),
    OTHER("Other");

    private final String displayName;


    Category(String displayName) {
        this.displayName = displayName;

    }

    public String getDisplayName() {
        return displayName;
    }


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
