package io.ktor.http.header;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "", "values", "", "separator", "", "splitInsideQuotes", "splitHeaderValues", "(Ljava/util/List;CZ)Ljava/util/List;", "value", "splitHeaderValue", "(Ljava/lang/String;CZ)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    private static final List<String> splitHeaderValue(String str, char c, boolean z) {
        int i = 0;
        if (z) {
            List listSplit$default = StringsKt.split$default(str, new char[]{c});
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (z2) {
                if (z3) {
                    z3 = false;
                } else if (cCharAt == '\\') {
                    z3 = true;
                } else if (cCharAt == '\"') {
                    z2 = false;
                }
            } else if (cCharAt == '\"') {
                i2++;
                z2 = true;
            } else if (cCharAt == c) {
                splitHeaderValue$emit(str, arrayList3, i3, i2);
                i3 = i2 + 1;
                i2 = i3;
            }
            i2++;
        }
        splitHeaderValue$emit(str, arrayList3, i3, str.length());
        return arrayList3;
    }

    private static final void splitHeaderValue$emit(String str, List<String> list, int i, int i2) {
        String string = StringsKt.trim(str.substring(i, i2)).toString();
        if (string.length() > 0) {
            list.add(string);
        }
    }

    public static final List<String> splitHeaderValues(List<String> list, char c, boolean z) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(splitHeaderValue((String) it.next(), c, z), arrayList);
        }
        return arrayList;
    }
}
