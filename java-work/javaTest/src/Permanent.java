public class Permanent extends Employee{
    private int salary;
    private int bonus;

    public Permanent(String name, int salary, int bonus) {
        super(name);
        this.salary = salary;
        this.bonus = bonus;
    }
    public String toString() {
        String str = String.format("%s \t %d \t %d", name, salary, bonus);
        return str;
    }

    @Override
    public int getPay() {
        return salary + bonus;
    }
}
