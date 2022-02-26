package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;
    private ReportAll reportAll;

    public ReportEngine(Store store, ReportAll reportAll) {
        this.store = store;
        this.reportAll = reportAll;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        return reportAll.report(list);
    }
}
