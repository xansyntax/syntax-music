package com.atilika.kuromoji.compile;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.sse.ServerSentEventKt;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ProgressLog {
    private static boolean atEOL = false;
    private static int indent;
    private static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static Map<Integer, Long> startTimes = new HashMap();

    public static void begin(String str) {
        newLine();
        System.out.print(leader() + str + "... ");
        System.out.flush();
        atEOL = true;
        int i = indent + 1;
        indent = i;
        startTimes.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
    }

    public static void end() {
        newLine();
        Long l = startTimes.get(Integer.valueOf(indent));
        indent = Math.max(0, indent - 1);
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(leader());
        sb.append("done");
        sb.append(l != null ? IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(" ["), (System.currentTimeMillis() - l.longValue()) / 1000, "s]") : "");
        printStream.println(sb.toString());
        System.out.flush();
    }

    private static String leader() {
        return "[KUROMOJI] " + dateFormat.format(new Date()) + ": " + new String(new char[indent * 4]).replace("\u0000", ServerSentEventKt.SPACE);
    }

    private static void newLine() {
        if (atEOL) {
            System.out.println();
        }
        atEOL = false;
    }

    public static void println(String str) {
        newLine();
        System.out.println(leader() + str);
        System.out.flush();
    }
}
