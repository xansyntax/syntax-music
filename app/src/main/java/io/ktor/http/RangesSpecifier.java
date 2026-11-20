package io.ktor.http;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\nJ#\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u001c*\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J*\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001b\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lio/ktor/http/RangesSpecifier;", "", "", "unit", "", "Lio/ktor/http/ContentRange;", "ranges", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lio/ktor/http/RangeUnits;", "(Lio/ktor/http/RangeUnits;Ljava/util/List;)V", "Lkotlin/Function1;", "", "rangeUnitPredicate", "isValid", "(Lkotlin/jvm/functions/Function1;)Z", "", "length", "", "maxRangeCount", "Lkotlin/ranges/LongRange;", "merge", "(JI)Ljava/util/List;", "(J)Ljava/util/List;", "mergeToSingle", "(J)Lkotlin/ranges/LongRange;", "toString", "()Ljava/lang/String;", "T", "toList", "(Ljava/lang/Object;)Ljava/util/List;", "component1", "component2", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/RangesSpecifier;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getUnit", "Ljava/util/List;", "getRanges", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RangesSpecifier {
    private final List<ContentRange> ranges;
    private final String unit;

    /* JADX WARN: Multi-variable type inference failed */
    public RangesSpecifier(String str, List<? extends ContentRange> list) {
        str.getClass();
        list.getClass();
        this.unit = str;
        this.ranges = list;
        if (list.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("It should be at least one range");
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RangesSpecifier copy$default(RangesSpecifier rangesSpecifier, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rangesSpecifier.unit;
        }
        if ((i & 2) != 0) {
            list = rangesSpecifier.ranges;
        }
        return rangesSpecifier.copy(str, list);
    }

    public static /* synthetic */ boolean isValid$default(RangesSpecifier rangesSpecifier, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 2);
        }
        return rangesSpecifier.isValid(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isValid$lambda$0(String str) {
        str.getClass();
        return str.equals(RangeUnits.Bytes.getUnitToken());
    }

    public static /* synthetic */ List merge$default(RangesSpecifier rangesSpecifier, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 50;
        }
        return rangesSpecifier.merge(j, i);
    }

    private final <T> List<T> toList(T t) {
        return t == null ? EmptyList.INSTANCE : CollectionsKt__IterablesKt.listOf(t);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    public final List<ContentRange> component2() {
        return this.ranges;
    }

    public final RangesSpecifier copy(String unit, List<? extends ContentRange> ranges) {
        unit.getClass();
        ranges.getClass();
        return new RangesSpecifier(unit, ranges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RangesSpecifier)) {
            return false;
        }
        RangesSpecifier rangesSpecifier = (RangesSpecifier) other;
        return Intrinsics.areEqual(this.unit, rangesSpecifier.unit) && Intrinsics.areEqual(this.ranges, rangesSpecifier.ranges);
    }

    public final List<ContentRange> getRanges() {
        return this.ranges;
    }

    public final String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        return this.ranges.hashCode() + (this.unit.hashCode() * 31);
    }

    public final boolean isValid(Function1 rangeUnitPredicate) {
        rangeUnitPredicate.getClass();
        if (((Boolean) rangeUnitPredicate.invoke(this.unit)).booleanValue()) {
            List<ContentRange> list = this.ranges;
            if (list != null && list.isEmpty()) {
                return true;
            }
            for (ContentRange contentRange : list) {
                if (contentRange instanceof ContentRange.Bounded) {
                    ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                    if (bounded.getFrom() < 0 || bounded.getTo() < bounded.getFrom()) {
                    }
                } else if (!(contentRange instanceof ContentRange.TailFrom)) {
                    if (!(contentRange instanceof ContentRange.Suffix)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return false;
                    }
                    if (((ContentRange.Suffix) contentRange).getLastCount() < 0) {
                    }
                } else if (((ContentRange.TailFrom) contentRange).getFrom() < 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final List<LongRange> merge(long length, int maxRangeCount) {
        return this.ranges.size() > maxRangeCount ? toList(mergeToSingle(length)) : merge(length);
    }

    public final LongRange mergeToSingle(long length) {
        Object next;
        List<LongRange> longRanges = RangesKt.toLongRanges(this.ranges, length);
        Object next2 = null;
        if (longRanges.isEmpty()) {
            return null;
        }
        Iterator<T> it = longRanges.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long j = ((LongRange) next).first;
                do {
                    Object next3 = it.next();
                    long j2 = ((LongRange) next3).first;
                    if (j > j2) {
                        next = next3;
                        j = j2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        next.getClass();
        long j3 = ((LongRange) next).first;
        Iterator<T> it2 = longRanges.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                long j4 = ((LongRange) next2).last;
                do {
                    Object next4 = it2.next();
                    long j5 = ((LongRange) next4).last;
                    if (j4 < j5) {
                        next2 = next4;
                        j4 = j5;
                    }
                } while (it2.hasNext());
            }
        }
        next2.getClass();
        long j6 = ((LongRange) next2).last;
        long j7 = length - 1;
        if (j6 > j7) {
            j6 = j7;
        }
        return new LongRange(j3, j6);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.ranges, ",", Format$$ExternalSyntheticOutline0.m(new StringBuilder(), this.unit, '='), null, null, 60);
    }

    public final List<LongRange> merge(long length) {
        return RangesKt.mergeRangesKeepOrder(RangesKt.toLongRanges(this.ranges, length));
    }

    public /* synthetic */ RangesSpecifier(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RangeUnits.Bytes.getUnitToken() : str, (List<? extends ContentRange>) list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RangesSpecifier(RangeUnits rangeUnits, List<? extends ContentRange> list) {
        this(rangeUnits.getUnitToken(), list);
        rangeUnits.getClass();
        list.getClass();
    }
}
