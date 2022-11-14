/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.usermanagment;

import java.util.Scanner;

/**
 *
 * @author acabezam
 */
public class UserManagment {
    
    public static void showMenuLogIn() {
        System.out.println("---------------------------");
        System.out.println("""
                           Estás con la sesión iniciada
                           | 1. Modificar email
                           | 2. Modificar contraseña
                           | 3. Cerrar sesión
                           | 0. CERRAR PROGRAMA """);
        System.out.println("---------------------------");
    }
    
    public static void showMenuLogOut(){
        System.out.println("---------------------------");
        System.out.println("""
                           QUÉ QUIERES REALIZAR EN EL SISTEMA
                           | 1. Iniciar sesión
                           | 2. Registrarse
                           | 0. CERRAR PROGRAMA """);
        System.out.println("---------------------------"); 
    }

    public static void main(String[] args) {   
    
        Scanner sc = new Scanner(System.in);
        DataBase auth = new DataBase();

        int selectOption;
        String selectLine1 = "";
        String selectLine2 = "";
        String selectLine3 = "";
        
        do {
            System.out.println(auth.isLoggedIn());
            if (!auth.isLoggedIn()) {
                showMenuLogOut();
                selectOption = Integer.parseInt(sc.nextLine());
                switch (selectOption) {
                    case 1 -> {
                        System.out.println("Introduce tu email");
                        selectLine1 = sc.nextLine();
                        System.out.println("Introduce tu contraseña");
                        selectLine2 = sc.nextLine();
                        auth.login(selectLine1, selectLine2);
                        break;
                    }
                    case 2 -> {
                        System.out.println("REGISTRO\nIntroduce tu nombre");
                        selectLine1 = sc.nextLine();
                        System.out.println("Introduce tu email");
                        selectLine2 = sc.nextLine();
                        System.out.println("Introduce tu contraseña");
                        selectLine3 = sc.nextLine();
                        auth.register(selectLine2, selectLine1,selectLine3);
                        break;
                    }
                }
            } else {
                showMenuLogIn();
                selectOption = Integer.parseInt(sc.nextLine());
                switch (selectOption) {
                    case 1 -> {
                        System.out.println("CAMBIAR EMAIL\nIntroduce tu contraseña para comprobar que eres tú");
                        selectLine1 = sc.nextLine();
                        if (auth.checkHasSamePswd(selectLine2, selectLine3)) {
                            System.out.println("Introduce tu nuevo email");
                            selectLine1 = sc.nextLine();
                            auth.changeEmail(selectLine1);
                        } else {
                            System.out.println("La contraseña introducida no es correcta");
                        }
                        break;
                    }
                    case 2 -> {
                        System.out.println("CAMBIAR CONTRASEÑA\nIntroduce tu actual contraseña");
                        selectLine1 = sc.nextLine();
                        if (auth.checkHasSamePswd(selectLine2, selectLine3)) {
                            System.out.println("Introduce tu contraseña nueva");
                            selectLine1 = sc.nextLine();
                            auth.changePassword(selectLine1);
                        } else {
                            System.out.println("La contraseña introducida no es correcta");
                        }
                        break;
                    }
                    case 3 -> {
                        auth.logOut();
                    }
                }
            }

        } while (selectOption != 0);
    }
}
