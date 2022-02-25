package ru.job4j.ood.srp;

import java.util.List;

public class ReportAccount implements ReportAll {

    private double coefficient = 1.7;

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public String report(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        list.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee e : list) {
            text.append(e.getName()).append(";")
                    .append(e.getHired()).append(";")
                    .append(e.getFired()).append(";")
                    .append("$").append(e.getSalary() * coefficient)
                    .append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
