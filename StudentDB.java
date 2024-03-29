import java.io.IOException;
import java.util.Scanner;

void main() throws IOException, InterruptedException {

    final Scanner SCANNER = new Scanner(System.in);

    String records = "";
    int studentID = 0;

    String stdID = STR."S%03d";

    main:
    while (true) {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        // System.out.println("\033[H\033[2J");
        System.out.println("=====================================");
        System.out.println("       Welcome to Student DB");
        System.out.println("""
                1. Add New Student
                2. Delete Student
                3. Search Student
                4. View All Student
                5. Exit
                """);
        System.out.println("=====================================");

        System.out.print("Enter Your Command :");

        switch (SCANNER.nextInt()) {
            case 1 -> {

                //new ProcessBuilder()
                addNewStudent:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    //System.out.println("\033[H\033[2J");
                    //System.flush
                    System.out.println("======== Add New Student==========");
                    System.out.println("");
                    System.out.print("Enter Student Name :");

                    SCANNER.skip("\n");
                    String studentName = SCANNER.nextLine();

                    int studentPFmarks = 0, studentOSmarks = 0;
                    if (studentName.isBlank()) {
                        System.out.println("\033[34mInvalid Name or PF marks or OS marks\033[0m");
                        continue addNewStudent;
                    } else {
                        System.out.print("Enter P.F Marks :");
                        studentPFmarks = SCANNER.nextInt();

                        if (0 > studentPFmarks && studentPFmarks > 100) {
                            System.out.println("\033[34mPF marks\033[0m");
                            continue addNewStudent;
                        } else {

                            System.out.print("Enter O.S Marks :");
                            studentOSmarks = SCANNER.nextInt();

                            if (0 > studentOSmarks && studentOSmarks > 100) {
                                System.out.println("\033[34mPF marks\033[0m");
                                continue addNewStudent;
                            }
                        }
                    }

                    studentID++;

                    String studentFinalID = String.format(stdID, studentID);

                    int totalMarks = studentPFmarks + studentOSmarks;
                    double avgMarks = (studentPFmarks + studentOSmarks) / 2.0;
                    String status = "";

                    if (avgMarks >= 90) status = "A+";
                    else if (avgMarks >= 75) status = "A";
                    else if (avgMarks >= 65) status = "B+";
                    else if (avgMarks >= 60) status = "B";
                    else if (avgMarks >= 55) status = "C";
                    else if (avgMarks >= 45) status = "S";
                    else status = "F";

                    String studentRecord = STR."\{studentFinalID}-\{studentName}-\{studentPFmarks}-\{studentOSmarks}-\{totalMarks}-\{avgMarks}-\{status}";
                    System.out.println(studentRecord);
                    records += STR."\{studentRecord},";
                    System.out.println("Added Successfully");

                    addAnotherStudent:
                    while (true) {
                        System.out.println();
                        System.out.print("Do you want to add another student (y/n) ? ");

                        switch (SCANNER.next().toUpperCase()) {
                            case "Y" -> {
                                continue addNewStudent;
                            }
                            case "N" -> {
                                continue main;
                            }
                            default -> {
                                continue addAnotherStudent;
                            }
                        }
                    }
                }

            }
            case 2 -> {
                //new ProcessBuilder()
                deleteStudent:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    //System.out.println("\033[H\033[2J");
                    //System.flush
                    System.out.println("======== Delete Student ==========");
                    System.out.println();

                    System.out.println("1. Delete Student");
                    System.out.println("2. Go Back");

                    while (true) {
                        System.out.print("Enter your Option :");
                        switch (SCANNER.nextInt()) {
                            case 1 -> {
                                System.out.print("Enter Student ID To Delete :");

                                String deleteStudentID = SCANNER.next();

                                if (deleteStudentID.isBlank()) {
                                    System.out.println("\033[34mInvalid Name\033[0m");
                                    continue deleteStudent;
                                } else {

                                    if (records.indexOf(deleteStudentID) == -1) {
                                        System.out.println("Student Not Found");
                                        continue deleteStudent;
                                    } else {


                                        confirmDeleteStudent:
                                        while (true) {
                                            System.out.print("Student Found, Are you sure that you want to delete (y/n) ?");
                                            switch (SCANNER.next().toUpperCase()) {
                                                case "Y" -> {

                                                    String deleteRecord = records.substring(records.indexOf(deleteStudentID), records.indexOf(",", records.indexOf(deleteStudentID)));
                                                    records = records.replace(STR."\{deleteRecord},", "");
                                                    System.out.println(STR."Student \{deleteStudentID} Deleted");
                                                    //System.out.println(STR."Student Record \{records} ");

                                                    DeleteAnotherStudent:
                                                    while (true) {
                                                        System.out.print("Do you want to Delete another student (y/n) ? ");

                                                        switch (SCANNER.next().toUpperCase()) {
                                                            case "Y" -> {
                                                                continue;
                                                            }
                                                            case "N" -> {
                                                                continue main;
                                                            }
                                                            default -> {
                                                                continue DeleteAnotherStudent;
                                                            }
                                                        }
                                                    }
                                                }
                                                case "N" -> {
                                                    continue deleteStudent;
                                                }
                                                default -> {
                                                    continue confirmDeleteStudent;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            case 2 -> {
                                continue main;
                            }
                            default -> {
                                System.out.println("\033[31mInvalid command\033[0m");
                                continue deleteStudent;
                            }
                        }
                    }
                }
            }
            case 3 -> {
                //new ProcessBuilder()
                SearchStudent:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    //System.out.println("\033[H\033[2J");
                    //System.flush
                    System.out.println("======== Search Student ==========");
                    System.out.println();

                    System.out.println("1. Search Student");
                    System.out.println("2. Go Back");

                    while (true) {
                        System.out.print("Enter your Option :");
                        switch (SCANNER.nextInt()) {
                            case 1 -> {
                                System.out.print("Enter Student ID To Search :");

                                String searchStudentID = SCANNER.next();

                                if (searchStudentID.isBlank()) {
                                    System.out.println("\033[34mInvalid ID\033[0m");
                                    continue SearchStudent;
                                } else {

                                    if (records.indexOf(searchStudentID) == -1) {
                                        System.out.println("Student Not Found");
                                        continue SearchStudent;
                                    } else {
                                        int studentCount = records.length() - records.replace(",", "").length();

                                        int studentIndex = 0;
                                        for (int i = 0; i < studentCount; i++) {

                                            String studentDetail = records.substring(studentIndex, records.indexOf(",", studentIndex));
                                            studentIndex = records.indexOf(",", studentIndex) + 1;

                                            if (studentDetail.contains(searchStudentID)) {
                                                int firsthypenIndex = studentDetail.indexOf("-");
                                                String id = studentDetail.substring(0, firsthypenIndex);
                                                String remain = studentDetail.substring(firsthypenIndex + 1);

                                                firsthypenIndex = remain.indexOf("-");
                                                String name = remain.substring(0, firsthypenIndex);
                                                remain = remain.substring(firsthypenIndex + 1);

                                                firsthypenIndex = remain.indexOf("-");
                                                String PFMarks = remain.substring(0, firsthypenIndex);
                                                remain = remain.substring(firsthypenIndex + 1);

                                                firsthypenIndex = remain.indexOf("-");
                                                String OSMarks = remain.substring(0, firsthypenIndex);
                                                remain = remain.substring(firsthypenIndex + 1);

                                                firsthypenIndex = remain.indexOf("-");
                                                String total = remain.substring(0, firsthypenIndex);
                                                remain = remain.substring(firsthypenIndex + 1);

                                                firsthypenIndex = remain.indexOf("-");
                                                String avg = remain.substring(0, firsthypenIndex);
                                                remain = remain.substring(firsthypenIndex + 1);

                                                String stat = remain;

                                                System.out.printf("""
                                                        Student ID  : %s
                                                        Name        : %s
                                                        P.F Marks   : %s
                                                        O.S Marks   : %s
                                                        Total Marks : %s
                                                        Avg Marks   : %s
                                                        Status      : %s
                                                        """, id, name, PFMarks, OSMarks, total, avg, stat);
                                                break;
                                            }
                                        }
                                        SearchAnotherStudent:
                                        while (true) {
                                            System.out.print("Do you want to Search another student (y/n) ? ");

                                            switch (SCANNER.next().toUpperCase()) {
                                                case "Y" -> {
                                                    continue SearchStudent;
                                                }
                                                case "N" -> {
                                                    continue main;
                                                }
                                                default -> {
                                                    continue SearchAnotherStudent;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            case 2 -> {
                                continue main;
                            }
                            default -> {
                                System.out.println("\033[31mInvalid command\033[0m");
                                continue SearchStudent;
                            }
                        }
                    }
                }
            }
            case 4 -> {
                //new ProcessBuilder()
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                //System.out.println("\033[H\033[2J");
                //System.flush
                System.out.println("======== View All Students==========");
                System.out.println();

                int studentCount = records.length() - records.replace(",", "").length();

                int studentIndex = 0;
                for (int i = 0; i < studentCount; i++) {

                    String studnetName = records.substring(studentIndex, records.indexOf(",", studentIndex));
                    System.out.println(studnetName);
                    studentIndex = records.indexOf(",", studentIndex) + 1;
                }

                {
                    final String BLUE = "\033[34;1m";
                    final String YELLOW = "\033[33;1m";
                    final String RED = "\033[31;1m";
                    final String GREEN = "\033[32;1m";
                    final String RESET = "\033[0m";

                    int maxNameLength = 0;
                    double maxAvgValue = 0;
                    String bestStudentID = "";

                    double minAvgValue = 0;
                    String worstStudentID = "";

                    int commaIndex = 0;
                    int dotIdIndex = 0, dotNameIndex = 0, dotTotalIndex = 0, dotAvgIndex = 0, dotStatusIndex = 0;

                    String data = records;
                    int count = studentCount;

                    String ids = "", names = "", totals = "", avgs = "", status = "";

                    System.out.println(data);

                    for (int i = 0; i < count; i++) {

                        String studentDetail = data.substring(commaIndex, data.indexOf(",", commaIndex));

                        int firsthypenIndex = studentDetail.indexOf("-");
                        String id = studentDetail.substring(0, firsthypenIndex);
                        String remain = studentDetail.substring(firsthypenIndex + 1);

                        firsthypenIndex = remain.indexOf("-");
                        String name = remain.substring(0, firsthypenIndex);
                        remain = remain.substring(firsthypenIndex + 1);

                        firsthypenIndex = remain.indexOf("-");
                        remain = remain.substring(firsthypenIndex + 1);

                        firsthypenIndex = remain.indexOf("-");
                        remain = remain.substring(firsthypenIndex + 1);

                        firsthypenIndex = remain.indexOf("-");
                        String total = remain.substring(0, firsthypenIndex);
                        remain = remain.substring(firsthypenIndex + 1);

                        firsthypenIndex = remain.indexOf("-");
                        String avg = remain.substring(0, firsthypenIndex);
                        remain = remain.substring(firsthypenIndex + 1);

                        String stat = remain;

                        if (maxNameLength < name.length()) maxNameLength = name.length();

                        double avgValue = Double.parseDouble(avg);

                        if (i != 0) {
                            if (maxAvgValue < avgValue) {
                                maxAvgValue = avgValue;
                                bestStudentID = id;
                            } else if (minAvgValue > avgValue) {
                                minAvgValue = avgValue;
                                worstStudentID = id;
                            }

                        } else {
                            maxAvgValue = minAvgValue = avgValue;
                            bestStudentID = worstStudentID = id;
                        }

                        ids += STR."\{id}+";
                        names += STR."\{name}+";
                        totals += STR."\{total}+";
                        avgs += STR."\{avg}+";
                        status += STR."\{stat}+";
                        commaIndex = data.indexOf(",", commaIndex) + 1;

                    }

                    String firstLine = STR."+\{"-".repeat(5)}+\{"-".repeat(maxNameLength)}+\{"-".repeat(5)}+\{"-".repeat(6)}+\{"-".repeat(7)}+";
                    String topic = STR."|\{BLUE}%-\{5}s\{RESET}|\{BLUE}%-\{maxNameLength}s\{RESET}|\{BLUE}%-\{5}s\{RESET}|\{BLUE}%-\{6}s\{RESET}|\{BLUE}%-\{7}s\{RESET}|";
                    String row = STR."|%1$s%2$-\{5}s\{RESET}|%1$s%3$-\{maxNameLength}s\{RESET}|%1$s%4$-\{5}s\{RESET}|%1$s%5$-\{6}s\{RESET}|%1$s%6$-\{7}s\{RESET}|\n";

                    System.out.println(firstLine);
                    System.out.printf(topic, "ID", "NAME", "TOTAL", "AVG", "STATUS");
                    System.out.println("\n" + firstLine);


                    for (int i = 0; i < count; i++) {

                        String id = ids.substring(dotIdIndex, ids.indexOf('+', dotIdIndex));
                        String name = names.substring(dotNameIndex, names.indexOf('+', dotNameIndex));
                        String total = totals.substring(dotTotalIndex, totals.indexOf('+', dotTotalIndex));
                        String avg = avgs.substring(dotAvgIndex, avgs.indexOf('+', dotAvgIndex));
                        String stat = status.substring(dotStatusIndex, status.indexOf('+', dotStatusIndex));

                        if (id.equals(bestStudentID)) System.out.printf(row, RED, id, name, total, avg, stat);
                        else if (id.equals(worstStudentID)) System.out.printf(row, GREEN, id, name, total, avg, stat);
                        else System.out.printf(row, YELLOW, id, name, total, avg, stat);

                        dotIdIndex = ids.indexOf('+', dotIdIndex) + 1;
                        dotNameIndex = names.indexOf('+', dotNameIndex) + 1;
                        dotTotalIndex = totals.indexOf('+', dotTotalIndex) + 1;
                        dotAvgIndex = avgs.indexOf('+', dotAvgIndex) + 1;
                        dotStatusIndex = status.indexOf('+', dotStatusIndex) + 1;
                    }

                    System.out.println(firstLine);
                    System.out.println(STR."\{RED}Best Student\{RESET}");
                    System.out.println(STR."\{GREEN}Worst Student\{RESET}");
                }

                System.out.println("=====================================");

                System.out.println("1. Go Back");
                System.out.println("2. Exit");

                while (true) {
                    System.out.print("Enter your Option :");
                    switch (SCANNER.nextInt()) {
                        case 1 -> {
                            continue main;
                        }
                        case 2 -> System.exit(0);
                        default -> System.out.println("\033[31mInvalid command\033[0m");
                    }
                }
            }
            case 5 -> {
                System.exit(0);
            }
            default -> System.out.println("Invalid");
        }
    }
}