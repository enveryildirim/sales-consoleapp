package com.company.pages;

import com.company.Constant;
import com.company.models.PageName;
import com.company.pages.components.Input;
import com.company.services.ProductService;
import com.company.services.UserService;

/**
 *
 */
public class LoginPage extends PageBase {

    public LoginPage(UserService userService, ProductService productService) {
        super(userService, productService);
    }

    @Override
    public boolean isRequiredAuth() {
        return false;
    }


    @Override
    public PageName render() {

        String labelUsernameInput = "Kullanıcı Adı";
        boolean isRequiredUsername = true;
        Input inUsername = new Input(labelUsernameInput, Constant.USERNAME, isRequiredUsername);
        String username = inUsername.renderAndGetText();

        String labelPassword = "Parola";
        boolean isRequiredPassword = true;
        Input inPassword = new Input(labelPassword, Constant.PASSWORD, isRequiredPassword);
        String password = inPassword.renderAndGetText();

        boolean isSuccessLogin = this.userService.login(username, password);
        if (isSuccessLogin)
            return PageName.HOME;

        System.out.println("!!!! Lütfen bilgilerinizi doğru giriniz Bilgilerinizi unuttuysanız Adminle görüşün\n " +
                "Devam etmek için bir tuşa basın");
        in.nextLine();

        return PageName.LOGIN;
    }
}
