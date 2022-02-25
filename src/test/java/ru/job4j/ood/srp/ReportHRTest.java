package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void reportHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee employee1 = new Employee("Dima", now, now, 900);
        Employee employee2 = new Employee("Misha", now, now, 700);
        store.add(employee1);
        store.add(employee2);
        ReportHR reportHR = new ReportHR();
        Report engine = new ReportEngine(store, reportHR);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(employee2.getName()).append(";")
                .append(employee2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}