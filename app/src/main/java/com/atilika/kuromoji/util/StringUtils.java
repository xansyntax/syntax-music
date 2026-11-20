package com.atilika.kuromoji.util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    public static String join(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
