package com.company.pages;

import com.company.RegexConstant;
import com.company.models.PageName;
import com.company.models.User;
import com.company.models.UserType;
import com.company.pages.components.Input;
import com.company.services.OrderService;
import com.company.services.UserService;

/**
 * Müşterilerlin siparişlerinin satış işlemi yapar
 */
public class OrderViewPage extends PageBase {
    private UserService userService;
    private OrderService orderService;

    public OrderViewPage(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public boolean isRequiredAuth() {
        return true;
    }

    @Override
    public PageName render() {

        System.out.println("--------------SİPARİŞ SAYFASI-------------");
        System.out.println(orderService.getAllOrderConvertToString());

        String labelCommand = "Satış=1\nGeri Dön=0";
        boolean isRequiredCommand = true;
        Input inCommand = new Input(labelCommand, RegexConstant.ORDER_PAGE_VIEW_COMMAND_LIST, isRequiredCommand);
        String command = inCommand.renderAndGetText();

        if (command.equals("1")) {
            this.renderSaleCommandContent();
        } else {
            boolean isAdminLoginedUser = userService.getLoggedUser().getUserType() == UserType.ADMIN;
            if (isAdminLoginedUser)
                return PageName.HOME;
            else
                return PageName.LOGIN;

        }

        return PageName.ORDER_VIEW;
    }

    /**
     * Satış komutu ile alakalı işlemler ekrana basar
     */
    void renderSaleCommandContent() {
        boolean isEmptyOrder = orderService.getAllOrder().isEmpty();
        if (isEmptyOrder) {
            System.out.println("Sepet boş satış yapılamaz");
            return;
        }

        String labelUserID = "Kullanıcının ID'sini girin";
        boolean isRequiredID = true;
        Input inputID = new Input(labelUserID, RegexConstant.ONLY_DIGIT, isRequiredID);
        inputID.renderAndGetText();
        int customerID = inputID.getTextAfterConvertToInt();

        User user = userService.getUser(customerID);
        if (user == null || user.getUserType() != UserType.CUSTOMER) {
            System.out.println("Uygun kullanıcı bulunamadı !!!");
            return;
        }

        String msjSale = String.format("%s ID'li %s İsimli ---- siparişi onaylamak için evet iptal için hayır giriniz",
                user.getId(), user.getNameSurname());
        boolean isRequiredCommand = true;
        Input inputCommand = new Input(msjSale, RegexConstant.COMMAND_YES_NO, isRequiredCommand);
        String command = inputCommand.renderAndGetText();

        if (command.equals("evet")) {
            orderService.saleOrder(user.getId());
            System.out.println("Satış yapıldı");
        } else {
            System.out.println("Satış iptal");
        }
    }
}
