package ru.job4j.ood.ocp;

import org.junit.Test;

import java.util.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;

import static org.junit.Assert.*;

public class ReportJsonTest {

    @Test
    public void reportJsonTest() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Gson gson = new GsonBuilder().create();
        Employee employee = new Employee("Misha", now, now, 200);
        store.add(employee);
        Report engine = new ReportJson(store);
        String rsl = engine.generate(employee1 -> true);
        StringBuilder expected = new StringBuilder()
                .append("[{")
                .append("\"name\":").append("\"").append(employee.getName()).append("\",")
                .append("\"hired\":").append(gson.toJson(employee.getHired())).append(",")
                .append("\"fired\":").append(gson.toJson(employee.getFired())).append(",")
                .append("\"salary\":").append(employee.getSalary())
                .append("}]");
        assertEquals(expected.toString(), rsl);
    }
}