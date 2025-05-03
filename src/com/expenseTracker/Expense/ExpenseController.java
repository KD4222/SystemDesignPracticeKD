package com.expenseTracker.Expense;

import com.expenseTracker.BalanceSheetController;
import com.expenseTracker.Expense.Split.ExpenseSplit;
import com.expenseTracker.Expense.Split.Split;
import com.expenseTracker.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(){
        balanceSheetController= new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidBy) {
        ExpenseSplit expenseSplit=SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails,expenseAmount);

        Expense expense=new Expense(expenseId,expenseAmount,description,paidBy,splitType,splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy,splitDetails,expenseAmount);

        return expense;
    }
}
