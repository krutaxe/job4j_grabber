package ru.job4j.ood.srp;

import java.util.List;

public class ReportProgram implements ReportAll {
    @Override
    public String report(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("<html lang=\"ru\">")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">")
                .append(System.lineSeparator())
                .append("<title>First Report HTML</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee e : list) {
            text.append(e.getName()).append(";")
                    .append(e.getHired()).append(";")
                    .append(e.getFired()).append(";")
                    .append(e.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>")
                .append("</html>");
        return text.toString();
    }
}
