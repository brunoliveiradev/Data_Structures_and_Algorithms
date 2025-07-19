package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

public class TimeConversion {

    /**
     * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
     * @param s time in 12-hour AM/PM format
     * @return time in military (24-hour) format
     */
    public static String Conversion(String s) {
        try {
            String[] parts = s.split(":");
            if (parts.length != 3 || parts[2].length() < 4) {
                throw new IllegalArgumentException("Formato de hora inválido");
            }

            int hour = Integer.parseInt(parts[0]);
            String minutes = parts[1];
            String seconds = parts[2].substring(0, 2);
            String period = parts[2].substring(2);

            // Validações
            if (hour < 1 || hour > 12) {
                throw new IllegalArgumentException("Hora deve estar entre 1 e 12 no formato 12 horas");
            }

            if (!("AM".equals(period) || "PM".equals(period))) {
                throw new IllegalArgumentException("Período deve ser AM ou PM");
            }

            if ("AM".equals(period)) {
                if (hour == 12) {
                    hour = 0;
                }
            } else if (hour != 12) {
                hour += 12;
            }

            return String.format("%02d:%s:%s", hour, minutes, seconds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de hora inválido", e);
        }
    }
}
