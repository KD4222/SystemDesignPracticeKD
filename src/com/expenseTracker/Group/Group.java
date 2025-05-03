package com.expenseTracker.Group;

import com.expenseTracker.Expense.Expense;
import com.expenseTracker.Expense.ExpenseController;
import com.expenseTracker.Expense.ExpenseSplitType;
import com.expenseTracker.Expense.Split.Split;
import com.expenseTracker.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;

    ExpenseController expenseController;

    Group(){
        groupMembers=new ArrayList<>();
        expenseList=new ArrayList<>();
        expenseController=new ExpenseController();
    }

    public void addMember(User member){
        groupMembers.add(member);
    }

    public String getGroupId(){
        return groupId;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidBy){
        Expense expense=expenseController.createExpense(expenseId,description,expenseAmount,splitDetails,splitType,paidBy);
        expenseList.add(expense);
        return expense;
    }
}
