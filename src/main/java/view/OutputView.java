package view;

import constant.OutputMessage;
import domain.MainOptions;
import domain.Menu;
import domain.Payment;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMainOption() {
        System.out.println(OutputMessage.MAIN_OPTION);
        System.out.println(MainOptions.printValues());
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderHistory(final Table table) {
        System.out.println(OutputMessage.ORDER_HISTORY);
        System.out.println(table.printMenu());
        System.out.println();
    }

    public static void printPayment(final Table table) {
        System.out.printf(OutputMessage.PAYMENT_START.toString(), table);
        System.out.println();
        System.out.println(OutputMessage.PAYMENT_METHOD);
    }

    public static void printTotalPrice(Payment payment) {
        System.out.println(OutputMessage.TOTAL_PRICE);
        System.out.println(payment);
        System.out.println();
    }
}
