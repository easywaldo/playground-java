public class Officer {
    private double salary;

    private final double basicAmt;
    public Officer() {
        this.basicAmt = 0;
    }

    public Officer(double basicAmt) {
        this.basicAmt = basicAmt;
    }

    public void setSalary(double salary) {
        this.salary = salary + this.basicAmt;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getRole() {
        return "working at office";
    }
}
