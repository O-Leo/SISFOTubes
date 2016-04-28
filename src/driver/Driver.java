/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import Console.Console;
import controller.ControllerB;
import model.*;


public class Driver {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        ControllerB b = new ControllerB(app);
        Console view1 = new Console(app);
        view1.mainMenu();
    }
}
