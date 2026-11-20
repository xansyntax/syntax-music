package io.ktor.http;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\t0\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "rangeSpec", "Lio/ktor/http/RangesSpecifier;", "parseRangesSpecifier", "(Ljava/lang/String;)Lio/ktor/http/RangesSpecifier;", "", "Lio/ktor/http/ContentRange;", "", "contentLength", "Lkotlin/ranges/LongRange;", "toLongRanges", "(Ljava/util/List;J)Ljava/util/List;", "mergeRangesKeepOrder", "(Ljava/util/List;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RangesKt {
    public static final List<LongRange> mergeRangesKeepOrder(List<LongRange> list) {
        list.getClass();
        List<LongRange> listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: io.ktor.http.RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return Long.valueOf(((LongRange) t).first).compareTo(Long.valueOf(((LongRange) t2).first));
            }
        });
        ArrayList arrayList = new ArrayList(list.size());
        for (LongRange longRange : listSortedWith) {
            if (arrayList.isEmpty()) {
                arrayList.add(longRange);
            } else if (((LongRange) CollectionsKt.last(arrayList)).last < longRange.first - 1) {
                arrayList.add(longRange);
            } else {
                LongRange longRange2 = (LongRange) CollectionsKt.last(arrayList);
                arrayList.set(arrayList.size() - 1, new LongRange(longRange2.first, Math.max(longRange2.last, longRange.last)));
            }
        }
        LongRange[] longRangeArr = new LongRange[list.size()];
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            LongRange longRange3 = (LongRange) next;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (io.ktor.util.RangesKt.contains(longRange3, list.get(i))) {
                    longRangeArr[i] = longRange3;
                    break;
                }
            }
        }
        return ArraysKt.filterNotNull(longRangeArr);
    }

    public static final RangesSpecifier parseRangesSpecifier(String str) {
        ContentRange bounded;
        str.getClass();
        try {
            int iIndexOf$default = StringsKt.indexOf$default(str, "=", 0, false, 6);
            if (iIndexOf$default != -1) {
                String strSubstring = str.substring(0, iIndexOf$default);
                List listSplit$default = StringsKt.split$default(str.substring(iIndexOf$default + 1), new char[]{','});
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    String strTrim = StringsKt.trim((String) it.next(), ' ', '\t');
                    if (StringsKt__StringsJVMKt.startsWith(strTrim, "-", false)) {
                        bounded = new ContentRange.Suffix(Long.parseLong(StringsKt.removePrefix(strTrim, "-")));
                    } else {
                        int iIndexOf$default2 = StringsKt.indexOf$default(strTrim, "-", 0, false, 6);
                        Pair pair = iIndexOf$default2 == -1 ? new Pair("", "") : new Pair(strTrim.substring(0, iIndexOf$default2), strTrim.substring(iIndexOf$default2 + 1));
                        String str2 = (String) pair.first;
                        String str3 = (String) pair.second;
                        bounded = str3.length() > 0 ? new ContentRange.Bounded(Long.parseLong(str2), Long.parseLong(str3)) : new ContentRange.TailFrom(Long.parseLong(str2));
                    }
                    arrayList.add(bounded);
                }
                if (!arrayList.isEmpty() && strSubstring.length() != 0) {
                    RangesSpecifier rangesSpecifier = new RangesSpecifier(strSubstring, arrayList);
                    if (RangesSpecifier.isValid$default(rangesSpecifier, null, 1, null)) {
                        return rangesSpecifier;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static final List<LongRange> toLongRanges(List<? extends ContentRange> list, long j) {
        LongRange longRange;
        LongRange longRange2;
        LongRange longRange3;
        list.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ContentRange contentRange : list) {
            if (contentRange instanceof ContentRange.Bounded) {
                ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                long from = bounded.getFrom();
                long to = bounded.getTo();
                long j2 = j - 1;
                if (to > j2) {
                    to = j2;
                }
                longRange3 = new LongRange(from, to);
            } else if (contentRange instanceof ContentRange.TailFrom) {
                long from2 = ((ContentRange.TailFrom) contentRange).getFrom();
                if (j <= Long.MIN_VALUE) {
                    longRange2 = LongRange.EMPTY;
                    longRange3 = longRange2;
                } else {
                    longRange = new LongRange(from2, j - 1);
                    longRange3 = longRange;
                }
            } else {
                if (!(contentRange instanceof ContentRange.Suffix)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                long lastCount = j - ((ContentRange.Suffix) contentRange).getLastCount();
                if (lastCount < 0) {
                    lastCount = 0;
                }
                if (j <= Long.MIN_VALUE) {
                    longRange2 = LongRange.EMPTY;
                    longRange3 = longRange2;
                } else {
                    longRange = new LongRange(lastCount, j - 1);
                    longRange3 = longRange;
                }
            }
            arrayList.add(longRange3);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (!((LongRange) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
