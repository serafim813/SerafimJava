package ru.intensive.dz5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorDemo {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        int i = 0;
        while (true) {
            objects.add(new Object());
            objects.add(new Integer(i));
            objects.add(new String("String " + i));
            i++;
            System.out.println(LocalDateTime.now());
            // Get current size of heap in bytes
            long heapSize = Runtime.getRuntime().totalMemory();
            // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
            long heapMaxSize = Runtime.getRuntime().maxMemory();
            // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
            long heapFreeSize = Runtime.getRuntime().freeMemory();
            System.out.println("heap size: " + heapSize);
            System.out.println("heap max size: " + heapMaxSize);
            System.out.println("heap free size: " + heapFreeSize);
        }
    }
}
// -Xmx12m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/mac/Downloads/SerafimJava/src/main/java/ru/intensive/dz5/Tools/OOME.hprof