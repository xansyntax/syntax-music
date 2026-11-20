package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModel;
import com.metrolist.music.db.MusicDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/BackupRestoreViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class BackupRestoreViewModel extends ViewModel {
    public final MusicDatabase database;

    public BackupRestoreViewModel(MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.database = musicDatabase;
    }

    public static String extractCookieFromPrefs(String str) {
        int iIndexOf$default = StringsKt.indexOf$default(str, "innerTubeCookie", 0, false, 6);
        int i = -1;
        if (iIndexOf$default == -1) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf$default + 15);
        Iterator it = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"__Secure-", "HSID=", "SSID=", "SID=", "SAPISID="}).iterator();
        int i2 = -1;
        while (it.hasNext()) {
            int iIndexOf$default2 = StringsKt.indexOf$default(strSubstring, (String) it.next(), 0, false, 6);
            if (iIndexOf$default2 != -1 && (i2 == -1 || iIndexOf$default2 < i2)) {
                i2 = iIndexOf$default2;
            }
        }
        if (i2 == -1) {
            return null;
        }
        String strSubstring2 = strSubstring.substring(i2);
        int length = strSubstring2.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = strSubstring2.charAt(i3);
            if (cCharAt < ' ' && cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
                i = i3;
                break;
            }
        }
        String strSubstring3 = i > 0 ? strSubstring2.substring(0, i) : StringsKt.take(5000, strSubstring2);
        Pattern patternCompile = Pattern.compile("[\\x00-\\x1F\\x7F]");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strSubstring3).replaceAll("");
        strReplaceAll.getClass();
        return StringsKt.trim(strReplaceAll).toString();
    }

    public static ArrayList parseCsvLine(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                z = !z;
            } else if (cCharAt != ',' || z) {
                sb.append(cCharAt);
            } else {
                arrayList.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        arrayList.add(sb.toString());
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            arrayList2.add(StringsKt.trim(StringsKt.trim((String) obj).toString(), '\"'));
        }
        return arrayList2;
    }
}
