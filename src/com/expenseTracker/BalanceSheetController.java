package com.expenseTracker;

import com.expenseTracker.Expense.Split.Split;
import com.expenseTracker.User.User;

import java.util.List;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidBy, List<Split> splitDetails, double expenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet=paidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment()+expenseAmount);

        for (Split split: splitDetails){
            User userOwe=split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet=userOwe.getUserExpenseBalanceSheet();
            double oweAmount=split.getAmountOwe();

            if(paidBy.getUserId().equals(userOwe.getUserId())){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }else{
                //update balance of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack()+oweAmount);
                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance=paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }else{
                    userOweBalance=new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(),userOweBalance);
                }

                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount);

                //update balance sheet of owe user
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe()+oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense()+oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(paidBy.getUserId())){
                    userPaidBalance=oweUserExpenseSheet.getUserVsBalance().get(paidBy.getUserId());
                }else{
                    userPaidBalance=new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(paidBy.getUserId(),userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe()+oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){
        System.out.println("--------------------------------------------");
        System.out.println("Balance sheet of user: "+ user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet=user.getUserExpenseBalanceSheet();
        System.out.println(userExpenseBalanceSheet);
        //print map of user vs balance




        System.out.println("--------------------------");
    }
}
