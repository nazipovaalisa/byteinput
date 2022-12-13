import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        try(FileInputStream fin=new FileInputStream("file.txt"))
        {
            System.out.printf("File size: %d bytes \n", fin.available());
            byte[] buffer = new byte[fin.available()];
            // считаем файл в буфер
            fin.read(buffer, 0, fin.available());
            TreeSet<Integer> tree = new TreeSet<Integer>();
            System.out.println("File data:");
            for (byte b : buffer) {
                System.out.printf("%d ", b);
                tree.add((int) b);
            }
            TreeSet<Integer> reverseTree = new TreeSet<>(Comparator.reverseOrder());
            reverseTree.addAll(tree);
            System.out.print("\n"+reverseTree);

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}