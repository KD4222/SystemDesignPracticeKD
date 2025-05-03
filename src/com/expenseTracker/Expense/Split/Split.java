package com.expenseTracker.Expense.Split;

import com.expenseTracker.User.User;

public class Split {
    User user;

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    double amountOwe;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
