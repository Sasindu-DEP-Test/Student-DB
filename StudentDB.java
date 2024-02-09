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
                3. View All Student
                4. Exit
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

                    //System.out.printf(studentFinalID);
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
                                System.out.print("Enter Student Name To Delete :");

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
                                                    System.out.println(STR."Student Record \{records} ");

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

            //System.out.println(names);

            case 3 -> {
                //new ProcessBuilder()
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                //System.out.println("\033[H\033[2J");
                //System.flush
                System.out.println("======== View All Students==========");
                System.out.println();
                // System.out.println(names);

                int studentCount = records.length() - records.replace(",", "").length();

                int studentIndex = 0;
                for (int i = 0; i < studentCount; i++) {

                    String studnetName = records.substring(studentIndex, records.indexOf(",", studentIndex));
                    System.out.println(studnetName);
                    studentIndex = records.indexOf(",", studentIndex) + 1;
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
            case 4 -> {
                System.exit(0);
            }
            default -> System.out.println("Invalid");
        }
    }
}