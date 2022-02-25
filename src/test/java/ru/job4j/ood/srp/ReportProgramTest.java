package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportProgramTest {

    @Test
    public void reportProgram() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Dima", now, now, 900);
        store.add(employee);
        ReportProgram reportProgram = new ReportProgram();
        Report engine = new ReportEngine(store, reportProgram);
        StringBuilder expect = new StringBuilder()
                .append("<html lang=\"ru\">")
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
                .append(System.lineSeparator())
                .append(employee.getName()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}