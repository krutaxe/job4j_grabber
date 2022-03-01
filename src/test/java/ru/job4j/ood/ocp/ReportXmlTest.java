package ru.job4j.ood.ocp;

import org.junit.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.ReportEngine;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportXmlTest {

    @Test
    public void reportXmlTest() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String date = dateFormat.format(calendar.getTime());
        Employee employee = new Employee("Roma", calendar, calendar, 300);
        store.add(employee);
        ReportXml report = new ReportXml();
        Report engine = new ReportEngine(store, report);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<employees>"
                + "\n"
                + "    <employees>"
                + "\n"
                + "        <fired>" + date + "</fired>"
                + "\n"
                + "        <hired>" + date + "</hired>"
                + "\n"
                + "        <name>" + employee.getName() + "</name>"
                + "\n"
                + "        <salary>" + employee.getSalary() + "</salary>"
                + "\n"
                + "    </employees>"
                + "\n</employees>\n";
        assertThat(engine.generate(e -> true), is(expected));
    }
}