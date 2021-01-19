package com.company.pages;

import com.company.models.PageName;
import com.company.services.ProductService;
import com.company.services.UserService;

import java.util.Scanner;

public abstract class PageBase {
    protected UserService userService;
    protected ProductService productService;
    protected Scanner in = new Scanner(System.in);

    public PageBase(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    public abstract boolean requiredAuth();
    public abstract PageName render();
}