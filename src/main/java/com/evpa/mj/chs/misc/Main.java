package com.evpa.mj.chs.misc;

import static com.evpa.mj.chs.misc.Main.ReportSpecificationType.TABLE_OF_CONTENTS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String TABLE_OF_CONTENTS_ID = "TableofContentsReport";

    public static void main(String[] args) {

        Main main = new Main();

        main.getReportSpecifications().forEach(System.out::println);

        main.getReportSpecifications().stream()
                .filter(reportSpecification -> TABLE_OF_CONTENTS_ID.equalsIgnoreCase(reportSpecification.getReportId()))
                .findFirst()
                .map(reportSpecification -> {
                    reportSpecification.setType(TABLE_OF_CONTENTS);
                    return reportSpecification;
                });

        main.getReportSpecifications().forEach(System.out::println);
    }

    public List<ReportSpecification> getReportSpecifications() {

        List<ReportSpecification> list = new ArrayList<>();
        list.add(new ReportSpecification("TableofContentsReport", "/uri", true, 1, ReportSpecificationType.REPORT));
        list.add(new ReportSpecification("2", "/uri", true, 1, TABLE_OF_CONTENTS));
        list.add(new ReportSpecification("3", "/uri", true, 1, ReportSpecificationType.ADDITIONAL_CONTENTS));

        return list;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    class ReportSpecification {

        private String reportId;
        private String reportURI;
        private boolean includedPageNumber;
        private int reportOrder;
        private ReportSpecificationType type;
    }

    enum ReportSpecificationType {

        REPORT,
        DISCLOSURE,
        TABLE_OF_CONTENTS,
        ADDITIONAL_CONTENTS;

    }
}
