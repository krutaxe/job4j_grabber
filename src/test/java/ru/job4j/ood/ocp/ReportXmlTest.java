package ru.job4j.ood.ocp;

import org.junit.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class ReportXmlTest {

    @Test
    public void reportXmlTest() {
        MemStore store = new MemStore();
        Calendar calendar = new GregorianCalendar(2022, Calendar.FEBRUARY, 26);
        calendar.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee employee = new Employee("Roma", calendar, calendar, 300);
        store.add(employee);
        Report engine = new ReportXml(store);
        String rsl = engine.generate(e -> true);
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employee>\n")
                .append("    <name>").append(employee.getName()).append("</name>\n")
                .append("    <hired>").append("2022-02-26T00:00:00").append("+03:00").append("</hired>\n")
                .append("    <fired>").append("2022-02-26T00:00:00").append("+03:00").append("</fired>\n")
                .append("    <salary>").append(employee.getSalary()).append("</salary>\n")
                .append("</employee>\n");
        assertEquals(expected.toString(), rsl);
    }
}