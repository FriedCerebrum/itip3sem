package labFifth;

public class IPAddressValidator {
    public static void main(String[] args) {
        // IP-адрес, который мы хотим проверить.
        String ipAddress = "192.168.1.1";

        // Проверяем IP-адрес на корректность и выводим результат на экран.
        if (isValidIPAddress(ipAddress)) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("IP-адрес некорректен.");
        }
    }

    // Метод для проверки корректности IP-адреса.
    public static boolean isValidIPAddress(String ipAddress) {
        // Регулярное выражение для проверки IP-адреса.
        String regex = "^(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|" +
                "[0-1]?[0-9][0-9]?)$";

        // Проверяем, соответствует ли IP-адрес заданному регулярному выражению.
        return ipAddress.matches(regex);
    }
}
