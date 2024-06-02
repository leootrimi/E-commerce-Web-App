package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Models.AccountDelete;

import com.eCommerce.eCommerceApp.Services.Service.AccountDeleteService;
import com.eCommerce.eCommerceApp.Services.Service.CartService;
import com.eCommerce.eCommerceApp.Services.Service.OrderService;
import com.eCommerce.eCommerceApp.Services.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delete")
@SecurityRequirement(name = "bearerAuth")
public class AccountDeleteController {
@Autowired
    private final AccountDeleteService accountDeleteService;
    private final UserService userService;
    private final OrderService orderService;
    private final CartService cartService;
    @Autowired
    public AccountDeleteController(AccountDeleteService accountDeleteService, UserService userService, OrderService orderService, CartService cartService) {
        this.accountDeleteService = accountDeleteService;
        this.userService = userService;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<AccountDelete> createAccountDelete(@RequestBody AccountDelete accountDelete, @PathVariable String username) {
        if (accountDelete == null || accountDelete.getUsername() == null) {
            System.out.println("AccountDelete request body or username is null");
            return ResponseEntity.badRequest().build();
        }
        AccountDelete createdAccountDelete = accountDeleteService.createAccountDelete(accountDelete);
        userService.deleteUser(username);
        cartService.deleteByUsername(username);
        return ResponseEntity.ok(createdAccountDelete);
    }

    @GetMapping
    public ResponseEntity<List<AccountDelete>> getAllDeletedAccounts() {
        List<AccountDelete> deletedAccounts = accountDeleteService.getAllDeletedAccounts();
        return ResponseEntity.ok(deletedAccounts);
    }

}
