package com.expenseTracker.Expense;

import com.expenseTracker.Expense.Split.EqualExpenseSplit;
import com.expenseTracker.Expense.Split.ExpenseSplit;
import com.expenseTracker.Expense.Split.PercentageExpenseSplit;
import com.expenseTracker.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch(splitType){
            case EQUAL :
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
