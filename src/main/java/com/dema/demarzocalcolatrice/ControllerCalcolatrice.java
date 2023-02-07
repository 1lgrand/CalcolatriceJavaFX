package com.dema.demarzocalcolatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ControllerCalcolatrice {

    final int NOPERANDI = 10;
    final char NOPERATORI = 8;

    private int[] operandi = new int[NOPERANDI];
    private char[] operatori = new char[NOPERATORI];

    @FXML
    private Label espressione;

    @FXML
    private Button uno,due,tre,quattro,cinque,sei,sette,otto,nove,piu,meno,diviso,per;


    /*
    Questa funzione consente all'utente di cancellare l'ultimo numero dell'espressione
    Per evitare di dover cancellare tutta l'espressione
    */

    @FXML
    protected void cancellaUltimoNumero(){
        int i;
        String sEspressione = espressione.getText();
        System.out.println(sEspressione.length());
        StringBuilder nuovaEspressione = new StringBuilder();
        for(i=0;i<sEspressione.length()-1;i++){
            nuovaEspressione.append(sEspressione.charAt(i));
        }
        espressione.setText(nuovaEspressione.toString());
    }


    /*
    Questa funzione consente al display della calcolatrice di
    Non superare un certo limite di caratteri
    per evitare di andare in "overflow"
     */
    private Boolean maxCaratteri(){

        String s = espressione.getText();

        return s.length() + 1 > 16;
    }

    @FXML
    private void risultato(){
        double risultato;
        inserisciOperandiOperatori();

    }


    private void inserisciOperandiOperatori(){
        String display = espressione.getText();

        char trovaOperatore;

        int counterOperatori;

        int i,j = 0;

        for(i=0;i<display.length();i++){
            trovaOperatore = display.charAt(i);
            if(trovaOperatore == '+' || trovaOperatore == '-' || trovaOperatore == '*' || trovaOperatore == '/'){
                operatori[j] = display.charAt(i);
                j++;
            }
        }

        operatori = ordinaOperatori(operatori);



    }


    private char[] ordinaOperatori(char[] operatori){

        char[] sortedOperatori = new char[NOPERATORI];
        char[] menoPiu = new char[NOPERATORI];
        char[] divisoPer = new char[NOPERATORI];

        int i;

        for(i=0; i<operatori.length; i++){

        }




    }

// Gestione Dei Bottoni
    @FXML
    protected void clickZero(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"0");
        }

    }

    @FXML
    protected void clickUno(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"1");
        }
    }

    @FXML
    protected void clickDue(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"2");
        }
    }

    @FXML
    protected void clickTre(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"3");
        }
    }

    @FXML
    protected void clickQuattro(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"4");
        }
    }

    @FXML
    protected void clickCinque(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"5");
        }
    }

    @FXML
    protected void clickSei(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"6");
        }
    }

    @FXML
    protected void clickSette(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"7");
        }
    }

    @FXML
    protected void clickOtto(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"8");
        }
    }

    @FXML
    protected void clickNove(){
        if(!maxCaratteri()){
            espressione.setText(espressione.getText()+"9");
        }
    }

    @FXML
    protected void clickPiu(){

        String s = espressione.getText();

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
            espressione.setText(espressione.getText());
        }else{
            if(!maxCaratteri()){
                espressione.setText(espressione.getText()+"+");
            }
        }


    }

    @FXML
    protected void clickPer(){
        String s = espressione.getText();

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
            espressione.setText(espressione.getText());
        }else{
            if(!maxCaratteri()){
                espressione.setText(espressione.getText()+"*");
            }
        }
    }

    @FXML
    protected void clickDiviso(){
        String s = espressione.getText();

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
            espressione.setText(espressione.getText());
        }else{
            if(!maxCaratteri()){
                espressione.setText(espressione.getText()+"/");
            }
        }
    }

    @FXML
    protected void clickMeno(){
        String s = espressione.getText();

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
            espressione.setText(espressione.getText());
        }else{
            if(!maxCaratteri()){
                espressione.setText(espressione.getText()+"-");
            }
        }
    }

    @FXML
    protected void deleteAll(){
        espressione.setText("");
    }


}