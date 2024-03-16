package vn.funix.FX18409.java.asm02;

import vn.funix.FX18409.java.asm02.controllers.ProgramController;
import vn.funix.FX18409.java.asm02.models.Bank;

public class Asm02 {
    public static final Bank bank = new Bank();  //  set public because other class will use this bank object
    public static void main(String[] args) {
        ProgramController program = new ProgramController();
        program.run();  // CitizenId to test: 037153000257
    }
}