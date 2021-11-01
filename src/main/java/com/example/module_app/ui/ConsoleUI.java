package com.example.module_app.ui;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ConsoleUI {

    public String getFileName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла (с расширением) или директории: ");
        return in.nextLine();
    }

    public void showMsgFormatNotSupport(){
        System.out.println("Формат не поддерживается");
    }

    public void showMsgModuleNotSupport(){
        System.out.println("Модуль не поддерживается");
    }

    public void showMsgFunctionNotSupport(){
        System.out.println("Функция не поддерживается");
    }

    public void showSomeString(String description){
        System.out.println(description);
    }

    public int getNumber(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер: ");
        return in.nextInt();
    }

    public <T> void showListOfItem(List<T> items){
        for(T item : items){
            System.out.println(item.toString());
        }
    }

    public <T, E> void showMap(Map<T, E> map){
        for(var m : map.entrySet()){
            System.out.println(m.getKey().toString() + " - " + m.getValue());
        }
    }
}
