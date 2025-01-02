public class Temporary extends Employee{
    private int time;
    private int pay;

    public Temporary(String name, int time, int pay) {
        super(name);
        this.time = time;
        this.pay = pay;
    }

    @Override
    public String toString() {
        String str = String.format("%s \t %d \t %d", name, time, pay);
        return str;
    }

    public int getPay() {
        return time * pay;
    }
}


