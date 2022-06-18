/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author m.rhouma
 */
public class UserNotAuzorithedException extends Exception{
    public UserNotAuzorithedException(){
        super("Vous avez pas les droits d'accès");
    }
}
