class GumballMachineTestDrive{
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine("Beijing");
        GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
        gumballMonitor.report();
    }
}

class GumballMonitor{
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine){
        this.machine = machine;
    }

    public void report(){
        System.out.println("Gumball Machine: " + machine.getLocation());
    }
}

class GumballMachine{
    String location;
    public GumballMachine(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}