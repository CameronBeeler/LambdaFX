package cambeeler.controller;

import javafx.fxml.FXML;

public class Controller {

    @FXML public void iGotPushed()
    {
        System.out.println("You pushed the Button!");
        new Thread(()->
                   {
                       System.out.println("This is the lambda execute of the thread - iGotPushed");
                       System.out.println("This is line 2 of the inner lambda method");
                   }
                   ).start();
//        new Thread(new Runnable(){
//
//            @Override
//            public
//            void run()
//            {
//                System.out.println("Printing from Runnable thread - iGotPushed");
//            }
//        }).start();
    }
}
