package com.expenseTracker.User;

import com.expenseTracker.UserExpenseBalanceSheet;

public class User {
    public String getUserId() {
        return userId;
    }

    String userId;
    String userName;

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId=id;
        this.userName=userName;
        userExpenseBalanceSheet=new UserExpenseBalanceSheet();
    }
}
