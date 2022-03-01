package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.ReportAll;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class ReportXml implements ReportAll {
    @Override
    public String report(List<Employee> list) {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(list), writer);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}
