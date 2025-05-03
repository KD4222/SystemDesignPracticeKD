package com.expenseTracker.Expense;

import com.expenseTracker.Expense.Split.EqualExpenseSplit;
import com.expenseTracker.Expense.Split.Split;
import com.expenseTracker.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails=new ArrayList<>();

    public Expense(String expenseId, double expenseAmount, String description, User paidBy, ExpenseSplitType splitType,List<Split> splitDetails){
        this.expenseId=expenseId;
        this.expenseAmount=expenseAmount;
        this.description=description;
        this.paidByUser=paidBy;
        this.splitType=splitType;
        this.splitDetails.addAll(splitDetails);
    }
}
