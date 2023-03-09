package com.YohannesApp.BankApplication.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.YohannesApp.BankApplication.model.Account;
import com.YohannesApp.BankApplication.model.Transaction;
import com.YohannesApp.BankApplication.model.User;
import com.YohannesApp.BankApplication.service.AccountService;
import com.YohannesApp.BankApplication.service.TransactionService;
import com.fasterxml.jackson.core.sym.Name;
import com.YohannesApp.BankApplication.service.UserService;

import java.util.List;
import jakarta.servlet.http.HttpSession;


@Controller()
@RequestMapping("/accounts")
public class AccountController {
  
@Autowired
private AccountService accountService;
@Autowired
private UserService userService;

@Autowired
private TransactionService transService;

@GetMapping("/createNewAccount")
public String createNewAccount(Model model) {
 //create model attribute to bind form data
	Account account= new Account();
	model.addAttribute("account", account);
	return "new_account";
}

@PostMapping("/createAccount")
public String saveAccount(@ModelAttribute("account") Account account,HttpSession session) {
//save employee to database
	User  user= (User) session.getAttribute("user");
	if(user==null) {
		return "redirect:/accounts/login";
	}

	account.setUser(user);
	accountService.saveAccount(account);
	return "redirect:/accounts/account";
}

@GetMapping("/account")
public String getUserAccounts(Model model,HttpSession session) {
//save employee to database
	User  user= (User) session.getAttribute("user");
	User u1 =userService.getUserById(user.getId());
	model.addAttribute("listAccounts",u1.getAccounts());
	return "accounts";
}
@GetMapping("/sendMoney")
public String sendMoney(jakarta.servlet.http.HttpServletRequest  request, Model model,HttpSession session) {
    Long id = Long.parseLong(request.getParameter("id").toString());
    
    Account account = accountService.getAccountById(id);
    model.addAttribute("account", account);
	User  user= (User) session.getAttribute("user");
	User u1 =userService.getUserById(user.getId());
	if(user!=null) {
	   model.addAttribute("accounts", u1.getAccounts());
	}else {
		 model.addAttribute("accounts",null);
	}

    return "sendMoney";
}

@PostMapping("/transfer")
public String transferMoney(jakarta.servlet.http.HttpServletRequest  request, Model model,HttpSession session) {
    Long id = Long.parseLong(request.getParameter("id").toString());
    Long toId = Long.parseLong(request.getParameter("sendto").toString());
    double transfer = Double.parseDouble(request.getParameter("amounttosend").toString());
    Account account = accountService.getAccountById(id);
    if(account == null) {
    	  return "sendMoney";
    }
    
    Account account1 = accountService.getAccountById(toId);
    
    if(account1 == null) {
  	  return "sendMoney";
  }
    
    account.setBalance(account.getBalance()-transfer);
    account1.setBalance(account1.getBalance()+transfer);
	
    accountService.saveAccount(account1) ;
    accountService.saveAccount(account);
    
    Transaction trans= new Transaction();
    trans.setAmount(transfer);
    trans.setAccount(account);
    trans.setType("transfer");
    transService.saveTransaction(trans);
    
    Transaction trans1= new Transaction();
    trans1.setAmount(transfer);
    trans1.setAccount(account1);
    trans1.setType("Lodge");
    transService.saveTransaction(trans1);
	

    return "redirect:/accounts/account";
}


@GetMapping("/viewTransaction")

public String getTransactionView(jakarta.servlet.http.HttpServletRequest  request, Model model,HttpSession session) {
//save employee to database
	 Long id = Long.parseLong(request.getParameter("id").toString());
	
	Account acc =accountService.getAccountById(id);
	model.addAttribute("listTransactions",acc.getTransactions());
	return "transaction";
}

}
