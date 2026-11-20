package com.atilika.kuromoji.util;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DictionaryEntryLineParser {
    private static final char COMMA = ',';
    private static final char QUOTE = '\"';
    private static final String QUOTE_ESCAPED = "\"\"";

    public static String escape(String str) {
        boolean z = str.indexOf(34) >= 0;
        boolean z2 = str.indexOf(44) >= 0;
        if (!z && !z2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '\"') {
                    sb.append(QUOTE_ESCAPED);
                } else {
                    sb.append(cCharAt);
                }
            }
        } else {
            sb.append(str);
        }
        if (z2) {
            sb.insert(0, QUOTE);
            sb.append(QUOTE);
        }
        return sb.toString();
    }

    public static String[] parseLine(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\"') {
                z = !z;
                i++;
            }
            if (cCharAt != ',' || z) {
                sb.append(cCharAt);
            } else {
                arrayList.add(unescape(sb.toString()));
                sb = new StringBuilder();
            }
        }
        arrayList.add(sb.toString());
        if (i % 2 == 0) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        throw new RuntimeException("Unmatched quote in entry: ".concat(str));
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((i != 0 || cCharAt != '\"') && (i != str.length() - 1 || cCharAt != '\"')) {
                if (cCharAt != '\"') {
                    sb.append(cCharAt);
                } else if (z) {
                    sb.append(QUOTE);
                } else {
                    z = true;
                }
                z = false;
            }
        }
        return sb.toString();
    }
}
