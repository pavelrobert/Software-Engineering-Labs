package isp.lab3.exercise6;

import isp.lab3.exercise6.VendingMachine2;

public final class VmachineNew extends VendingMachine2 {
    private static VmachineNew vM = new VmachineNew();
    private VmachineNew(){
    }
    public static VmachineNew getInstance(){
        if(vM == null) {
            vM = new VmachineNew();
        }
        return vM;
    }
    public static void main(String[] args) {
        VmachineNew vM = VmachineNew.getInstance();
    }