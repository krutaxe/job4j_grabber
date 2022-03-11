package ru.job4j.ood.srp;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface ReportAll {
    String report(List<Employee> list);
}
