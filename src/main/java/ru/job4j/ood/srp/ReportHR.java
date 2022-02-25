package ru.job4j.ood.srp;

import java.util.List;

public class ReportHR implements ReportAll {
    @Override
    public String report(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        list.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee e : list) {
            text.append(e.getName()).append(";")
                    .append(e.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
