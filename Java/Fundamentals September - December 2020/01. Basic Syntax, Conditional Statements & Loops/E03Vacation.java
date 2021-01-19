import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int group = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;

//                    Friday	Saturday	Sunday
//        Students	    8.45	9.80	    10.46
//        Business	    10.90	15.60	    16
//        Regular	    15	    20	        22.50

//        •	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
//        •	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
//        •	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%


        switch (typePeople) {
            case "Students":
                if (group >= 30) {
                    switch (day) {
                        case "Friday":
                            totalPrice = group * 8.45 * 0.85;
                            break;
                        case "Saturday":
                            totalPrice = group * 9.80 * 0.85;
                            break;
                        case "Sunday":
                            totalPrice = group * 10.46 * 0.85;
                            break;
                    }

                } else {
                    switch (day) {
                        case "Friday":
                            totalPrice = group * 8.45;
                            break;
                        case "Saturday":
                            totalPrice = group * 9.80;
                            break;
                        case "Sunday":
                            totalPrice = group * 10.46;
                            break;

                    }
                }
                    break;
                    case "Business":
                        if (group >= 100) {
                            switch (day) {
                                case "Friday":
                                    totalPrice = (group - 10) * 10.90;
                                    break;
                                case "Saturday":
                                    totalPrice = (group - 10) * 15.60;
                                    break;
                                case "Sunday":
                                    totalPrice = (group - 10) * 16;
                                    break;
                            }

                        } else {
                            switch (day) {
                                case "Friday":
                                    totalPrice = group * 10.90;
                                    break;
                                case "Saturday":
                                    totalPrice = group * 15.60;
                                    break;
                                case "Sunday":
                                    totalPrice = group * 16;
                                    break;

                            }
                        }
                        break;
                    case "Regular":
                        if (10 <= group && group <= 20) {
                            switch (day) {
                                case "Friday":
                                    totalPrice = group * 15 * 0.95;
                                    break;
                                case "Saturday":
                                    totalPrice = group * 20 * 0.95;
                                    break;
                                case "Sunday":
                                    totalPrice = group * 22.50 * 0.95;
                                    break;
                            }

                        } else {
                            switch (day) {
                                case "Friday":
                                    totalPrice = group * 15;
                                    break;
                                case "Saturday":
                                    totalPrice = group * 20;
                                    break;
                                case "Sunday":
                                    totalPrice = group * 22.50;
                                    break;

                            }
                        }
                        break;
                }

        System.out.printf("Total price: %.2f", totalPrice);

        }
    }