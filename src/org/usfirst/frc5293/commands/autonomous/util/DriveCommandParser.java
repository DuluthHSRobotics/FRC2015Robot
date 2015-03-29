package org.usfirst.frc5293.commands.autonomous.util;

import java.util.*;
import java.util.function.Consumer;

public class DriveCommandParser {
    @SuppressWarnings("SuspiciousNameCombination")
    public static List<DriveCommandParams> parse(String input) {
        final List<DriveCommandParams> result = new ArrayList<>();
        final Scanner scanner = new Scanner(input);

        exit:
        while (scanner.hasNext()) {
            final DriveCommandParams params = new DriveCommandParams();

            List<Consumer<Double>> funcs = new ArrayList<>();
            funcs.add(x -> params.seconds = x);
            funcs.add(x -> params.movement.x = x);
            funcs.add(x -> params.movement.y = x);
            funcs.add(x -> params.movement.r = x);

            for (Consumer<Double> func : funcs) {
                if (!tryWithNext(scanner, func)) break exit;
            }

            result.add(params);
        }

        return result;
    }

    private static boolean tryWithNext(Scanner scanner, Consumer<Double> func) {
        OptionalDouble next;
        if ((next = trySkippingUtilDouble(scanner)).isPresent()) {
            func.accept(next.getAsDouble());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Skips tokens until the Scanner reaches a double
     * @return {@code true} if the double was double, {@code false} otherwise if the end of input
     *         was reached
     */
    private static OptionalDouble trySkippingUtilDouble(Scanner scanner) {
        while (true) {
            if (!scanner.hasNext()) {
                return OptionalDouble.empty();
            }

            if (scanner.hasNextDouble()) {
                return OptionalDouble.of(scanner.nextDouble());
            } else {
                // Skip this token
                scanner.next();
            }
        }
    }
}
