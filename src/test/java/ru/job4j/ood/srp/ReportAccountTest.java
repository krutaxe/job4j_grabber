package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportAccountTest {

    @Test
    public void ReportAccount() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee employee1 = new Employee("Dima", now, now, 900);
        Employee employee2 = new Employee("Misha", now, now, 700);
        store.add(employee1);
        store.add(employee2);
        ReportAccount reportAccount = new ReportAccount();
        Report engine = new ReportEngine(store, reportAccount);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getHired()).append(";")
                .append(employee1.getFired()).append(";").append("$")
                .append(employee1.getSalary() * reportAccount.getCoefficient())
                .append("$").append(";")
                .append(System.lineSeparator())
                .append(employee2.getName()).append(";")
                .append(employee2.getHired()).append(";")
                .append(employee2.getFired()).append(";").append("$")
                .append(employee2.getSalary() * reportAccount.getCoefficient())
                .append("$").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}