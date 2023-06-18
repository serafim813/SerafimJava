package ru.intensive.dz5;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class GarbageCollector {
    private List<Object> objects = new ArrayList<>();
    private int gcCount = 0;

    public void addObject(Object obj) {
        objects.add(obj);
        log("Added object " + obj);
    }

    public void runGC() {
        gcCount++;
        int objectsCount = objects.size();
        objects.removeIf(obj -> obj == null);
        int removedCount = objectsCount - objects.size();
        log("GC #" + gcCount + " removed " + removedCount + " objects");
    }

    private void log(String message) {
        try {
            FileWriter writer = new FileWriter("gc.log", true);
            writer.write(LocalDateTime.now() + ": " + message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GarbageCollector gc = new GarbageCollector();
        gc.addObject(new Object());
        gc.addObject(new Object());
        gc.addObject(null);
        gc.runGC();
        gc.addObject(new Object());
        gc.runGC();
    }
}
