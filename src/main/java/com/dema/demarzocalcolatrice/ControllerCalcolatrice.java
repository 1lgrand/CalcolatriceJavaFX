package com.dema.demarzocalcolatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerCalcolatrice {


    //Flags
    Boolean operatoreInserito = false;
    char operatoreCliccato = 'z';


    @FXML
    private Label espressione;



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
        String stringEspressione = espressione.getText();

        //La classe StringBuilder consente di lavorare meglio con le stringhe
        StringBuilder op1 = new StringBuilder();
        StringBuilder op2 = new StringBuilder();
        float iop1,iop2;

        int opIndex;

        float risultato;

        opIndex = stringEspressione.indexOf(operatoreCliccato);

        for(int i = 0;i<opIndex;i++){
            op1.append(stringEspressione.charAt(i));
        }

        for (int i=opIndex+1;i<stringEspressione.length();i++){
            op2.append(stringEspressione.charAt(i));
        }

        iop1 = Float.parseFloat(op1.toString());
        iop2 = Float.parseFloat(op2.toString());

        switch (operatoreCliccato){
            case '+':
                risultato=iop1 + iop2;
                espressione.setText(String.valueOf(risultato));
                break;
            case '-':
                risultato=iop1 - iop2;
                espressione.setText(String.valueOf(risultato));
                break;

            case '*':
                risultato=iop1 * iop2;
                espressione.setText(String.valueOf(risultato));
                break;

            case '/':
                risultato=iop1 / iop2;
                espressione.setText(String.valueOf(risultato));
                break;

            case 'z':
                espressione.setText(espressione.getText());
                break;
        }

        operatoreInserito = false;

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
        if(operatoreInserito){
                risultato();
        }else{
            if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
                espressione.setText(espressione.getText());
            }else{
                if(!maxCaratteri()){
                    operatoreCliccato = '+';
                    espressione.setText(espressione.getText()+"+");
                    operatoreInserito = true;
                }
            }
        }
    }

    @FXML
    protected void clickPer(){
        String s = espressione.getText();

        if(operatoreInserito){
            risultato();
        }else{
            if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
                espressione.setText(espressione.getText());
            }else{
                if(!maxCaratteri()){
                    operatoreCliccato = '*';
                    espressione.setText(espressione.getText()+"*");
                    operatoreInserito = true;
                }
            }
        }
    }

    @FXML
    protected void clickDiviso(){
        String s = espressione.getText();
        if(operatoreInserito){
            risultato();
        }else{
            if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
                espressione.setText(espressione.getText());
            }else{
                if(!maxCaratteri()){
                    operatoreCliccato = '/';
                    espressione.setText(espressione.getText()+"/");
                    operatoreInserito = true;
                }
            }
        }
    }

    @FXML
    protected void clickMeno(){
        String s = espressione.getText();

        if(operatoreInserito){
            risultato();
        }else{
            if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '*'){
                espressione.setText(espressione.getText());
            }else{
                if(!maxCaratteri()){
                    operatoreCliccato = '-';
                    espressione.setText(espressione.getText()+"-");
                    operatoreInserito = true;
                }
            }
        }
    }

    @FXML
    protected void deleteAll(){
        espressione.setText("");
        operatoreInserito = false;
    }

}