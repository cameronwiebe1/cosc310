package intro;

import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;

public class HexView {
    public static void main(String[] args) {
        System.out.println("Enter a filename:");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        try (InputStream in = new FileInputStream(filename)) {
            int offset = 0;
            int b;
            while ((b = in.read()) != -1) {
                if (offset % 16 == 0) {
                    System.out.printf("%08x: ", offset);
                }
                System.out.printf("%02x ", b);
                offset++;
                if (offset % 16 == 0) {
                    System.out.println();
                }
            }
            if (offset % 16 != 0) {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
