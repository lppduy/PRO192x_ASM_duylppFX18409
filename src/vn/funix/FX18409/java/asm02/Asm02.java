package vn.funix.FX18409.java.asm02;

import vn.funix.FX18409.java.asm02.controllers.ProgramController;
import vn.funix.FX18409.java.asm02.models.Bank;

public class Asm02 {

    //  set public because other class will use this bank object
    public static final Bank bank = new Bank();
    public static void main(String[] args) {
        ProgramController program = new ProgramController();
        program.run();
    }
}