package control;

import app.FoodItem;
import app.Main;
import gui.CustomerPage;
import gui.PaymentPage;
import gui.RatePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PaymentControl {

    public PaymentControl(PaymentPage paymentPage){

        paymentPage.getButtonMakePayment().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean checkPayment = checkPaymentMethod(paymentPage);
                if (checkPayment) {
                    RatePage ratePage = new RatePage(paymentPage.getFoodItem(), paymentPage.getMainPage()); // Opens the RatePage
                    new RateControl(ratePage);
                    paymentPage.setNonVisible();
                }
            }
        });

    }


    public boolean checkPaymentMethod(PaymentPage paymentPage) {
        String password = new String(paymentPage.getPasswordFieldCardPassword().getPassword());
        String cardNumber = paymentPage.getTextFieldCardNumber().getText();

        //databaseden çekilmeli. Şimdilik deneme olarak yazdım.
        String dataPassword = "1111";
        String dataCardNumber = "1111";

        boolean checkPassword = (Objects.equals(password, dataPassword)) ;
        boolean checkNumber = (Objects.equals(cardNumber, dataCardNumber)) ;

        if(checkPassword & checkNumber){
            return true;
        }else{
            System.out.println("wrong");
            return false;
        }

    }

}



