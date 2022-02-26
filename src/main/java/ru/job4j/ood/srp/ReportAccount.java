package ru.job4j.ood.srp;

import java.util.List;

public class ReportAccount implements ReportAll {

    public static final double COEFFICIENT = 1.7;

    @Override
    public String report(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee e : list) {
            text.append(e.getName()).append(";")
                    .append(e.getHired()).append(";")
                    .append(e.getFired()).append(";")
                    .append("$").append(e.getSalary() * COEFFICIENT)
                    .append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
