package org.example.currencyconverter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class CurrencyConverterController implements Initializable {
    // declare all elements
    @FXML
    private TextField srcValue;

    @FXML
    private TextField targetValue;

    @FXML
    private ComboBox<String> srcCurrency;

    @FXML
    private ComboBox<String> targetCurrency;

    @FXML
    private Button covertButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add currencies
        srcCurrency.getItems().addAll("CAD/Dollar", "USD/Dollar", "JPN/Yen", "EUR/Euro", "GBP/Pound");
        targetCurrency.getItems().addAll("CAD/Dollar", "USD/Dollar", "JPN/Yen", "EUR/Euro", "GBP/Pound");
    }


    // a method that handles the convert button click event
    @FXML
    public void convert(){

        // Retrieve the input amount and selected currencies
        String selectedSrcCurrency = srcCurrency.getValue();
        String selectedTargetCurrency = targetCurrency.getValue();

        double inputAmount = Double.parseDouble(srcValue.getText());

        // perform the conversion using exchange rate
        double result = inputAmount * getExchangeRate(selectedSrcCurrency, selectedTargetCurrency);
        // display the converted amount
        targetValue.setText(String.format("%.2f %s",result, selectedTargetCurrency));
    }

    // a method to get exchange rate of each source currencies
    public double getExchangeRate(String source, String target){

        double exRate;

        // when source and target currency are the same ones
        if(source.equals(target)){
            exRate = 1;
        }

        if(source.equals("CAD/Dollar") ){
            switch(target){
                case "USD/Dollar" -> exRate = 0.75;
                case "JPN/Yen" -> exRate = 108.83;
                case "EUR/Euro" -> exRate = 0.68;
                case "GBP/Pound" -> exRate = 0.59;
                default -> throw new IllegalArgumentException("Invalid target currency type");
            }
        } else if(source.equals("USD/Dollar")){
            switch(target){
                case "CAD/Dollar" -> exRate = 1.34;
                case "JPN/Yen" -> exRate = 145.54;
                case "EUR/Euro" -> exRate = 0.91;
                case "GBP/Pound" -> exRate = 0.78;
                default -> throw new IllegalArgumentException("Invalid target currency type");
            }
        } else if(source.equals("JPN/Yen")) {
            switch (target) {
                case "CAD/Dollar" -> exRate = 0.0092;
                case "USD/Dollar" -> exRate = 0.0068;
                case "EUR/Euro" -> exRate = 0.0062;
                case "GBP/Pound" -> exRate = 0.0053;
                default -> throw new IllegalArgumentException("Invalid target currency type");
            }
        } else if(source.equals("EUR/Euro")){
            switch (target) {
                case "CAD/Dollar" -> exRate = 1.46;
                case "USD/Dollar" -> exRate = 1.09;
                case "JPN/Yen" -> exRate = 159.71;
                case "GBP/Pound" -> exRate = 0.85;
                default -> throw new IllegalArgumentException("Invalid target currency type");
            }
        } else if (source.equals("GBP/Pound")) {
            switch (target) {
                case "CAD/Dollar" -> exRate = 1.70;
                case "USD/Dollar" -> exRate = 1.27;
                case "JPN/Yen" -> exRate = 185.73;
                case "EUR/Euro" -> exRate = 1.16;
                default -> throw new IllegalArgumentException("Invalid target currency type");
            }
        } else {
            throw new IllegalArgumentException("Invalid source currency type");
        }

        return exRate;
    }

    // a method that handles the clear/reset button event
    @FXML
    public void clear(){
        srcValue.clear();
        targetValue.clear();
    }






















}