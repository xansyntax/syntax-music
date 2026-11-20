package io.ktor.util.date;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002FGBO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b%\u0010&Jj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010'J\u001b\u0010*\u001a\u00020)2\b\u0010\u0015\u001a\u0004\u0018\u00010(HÖ\u0083\u0004¢\u0006\u0004\b*\u0010+J\u0011\u0010,\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b,\u0010\u001bJ\u0011\u0010.\u001a\u00020-HÖ\u0081\u0004¢\u0006\u0004\b.\u0010/J'\u00108\u001a\u0002052\u0006\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b<\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b?\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\b@\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bB\u0010#R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\bC\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\bE\u0010&¨\u0006H"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "", "seconds", "minutes", "hours", "Lio/ktor/util/date/WeekDay;", "dayOfWeek", "dayOfMonth", "dayOfYear", "Lio/ktor/util/date/Month;", "month", "year", "", "timestamp", "<init>", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IIIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "other", "compareTo", "(Lio/ktor/util/date/GMTDate;)I", "copy", "()Lio/ktor/util/date/GMTDate;", "component1", "()I", "component2", "component3", "component4", "()Lio/ktor/util/date/WeekDay;", "component5", "component6", "component7", "()Lio/ktor/util/date/Month;", "component8", "component9", "()J", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)Lio/ktor/util/date/GMTDate;", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_utils", "(Lio/ktor/util/date/GMTDate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "I", "getSeconds", "getMinutes", "getHours", "Lio/ktor/util/date/WeekDay;", "getDayOfWeek", "getDayOfMonth", "getDayOfYear", "Lio/ktor/util/date/Month;", "getMonth", "getYear", "J", "getTimestamp", "Companion", "$serializer", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class GMTDate implements Comparable<GMTDate> {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GMTDate START;
    private final int dayOfMonth;
    private final WeekDay dayOfWeek;
    private final int dayOfYear;
    private final int hours;
    private final int minutes;
    private final Month month;
    private final int seconds;
    private final long timestamp;
    private final int year;

    static {
        SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda0 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 1);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, ResultKt.lazy(lazyThreadSafetyMode, sourcesJvmKt$$ExternalSyntheticLambda0), null, null, ResultKt.lazy(lazyThreadSafetyMode, new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 2)), null, null};
        START = DateJvmKt.GMTDate(0L);
    }

    public /* synthetic */ GMTDate(int i, int i2, int i3, int i4, WeekDay weekDay, int i5, int i6, Month month, int i7, long j, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i & 511)) {
            EnumsKt.throwMissingFieldException(GMTDate$$serializer.INSTANCE.getDescriptor(), i, 511);
            throw null;
        }
        this.seconds = i2;
        this.minutes = i3;
        this.hours = i4;
        this.dayOfWeek = weekDay;
        this.dayOfMonth = i5;
        this.dayOfYear = i6;
        this.month = month;
        this.year = i7;
        this.timestamp = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer _childSerializers$_anonymous_() {
        WeekDay[] weekDayArrValues = WeekDay.values();
        weekDayArrValues.getClass();
        return new EnumSerializer("io.ktor.util.date.WeekDay", weekDayArrValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer _childSerializers$_anonymous_$0() {
        Month[] monthArrValues = Month.values();
        monthArrValues.getClass();
        return new EnumSerializer("io.ktor.util.date.Month", monthArrValues);
    }

    public static /* synthetic */ GMTDate copy$default(GMTDate gMTDate, int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month, int i6, long j, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = gMTDate.seconds;
        }
        if ((i7 & 2) != 0) {
            i2 = gMTDate.minutes;
        }
        if ((i7 & 4) != 0) {
            i3 = gMTDate.hours;
        }
        if ((i7 & 8) != 0) {
            weekDay = gMTDate.dayOfWeek;
        }
        if ((i7 & 16) != 0) {
            i4 = gMTDate.dayOfMonth;
        }
        if ((i7 & 32) != 0) {
            i5 = gMTDate.dayOfYear;
        }
        if ((i7 & 64) != 0) {
            month = gMTDate.month;
        }
        if ((i7 & 128) != 0) {
            i6 = gMTDate.year;
        }
        if ((i7 & 256) != 0) {
            j = gMTDate.timestamp;
        }
        long j2 = j;
        Month month2 = month;
        int i8 = i6;
        int i9 = i4;
        int i10 = i5;
        return gMTDate.copy(i, i2, i3, weekDay, i9, i10, month2, i8, j2);
    }

    public static final /* synthetic */ void write$Self$ktor_utils(GMTDate self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.seconds);
        output.encodeIntElement(serialDesc, 1, self.minutes);
        output.encodeIntElement(serialDesc, 2, self.hours);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.dayOfWeek);
        output.encodeIntElement(serialDesc, 4, self.dayOfMonth);
        output.encodeIntElement(serialDesc, 5, self.dayOfYear);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.month);
        output.encodeIntElement(serialDesc, 7, self.year);
        output.encodeLongElement(serialDesc, 8, self.timestamp);
    }

    @Override // java.lang.Comparable
    public int compareTo(GMTDate other) {
        other.getClass();
        return Intrinsics.compare(this.timestamp, other.timestamp);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSeconds() {
        return this.seconds;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMinutes() {
        return this.minutes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHours() {
        return this.hours;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Month getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final GMTDate copy(int seconds, int minutes, int hours, WeekDay dayOfWeek, int dayOfMonth, int dayOfYear, Month month, int year, long timestamp) {
        dayOfWeek.getClass();
        month.getClass();
        return new GMTDate(seconds, minutes, hours, dayOfWeek, dayOfMonth, dayOfYear, month, year, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) other;
        return this.seconds == gMTDate.seconds && this.minutes == gMTDate.minutes && this.hours == gMTDate.hours && this.dayOfWeek == gMTDate.dayOfWeek && this.dayOfMonth == gMTDate.dayOfMonth && this.dayOfYear == gMTDate.dayOfYear && this.month == gMTDate.month && this.year == gMTDate.year && this.timestamp == gMTDate.timestamp;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    public final int getHours() {
        return this.hours;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final Month getMonth() {
        return this.month;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + IntIntPair$$ExternalSyntheticOutline0.m(this.year, (this.month.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.dayOfYear, IntIntPair$$ExternalSyntheticOutline0.m(this.dayOfMonth, (this.dayOfWeek.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.hours, IntIntPair$$ExternalSyntheticOutline0.m(this.minutes, Integer.hashCode(this.seconds) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.seconds + ", minutes=" + this.minutes + ", hours=" + this.hours + ", dayOfWeek=" + this.dayOfWeek + ", dayOfMonth=" + this.dayOfMonth + ", dayOfYear=" + this.dayOfYear + ", month=" + this.month + ", year=" + this.year + ", timestamp=" + this.timestamp + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDate$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/util/date/GMTDate;", "serializer", "()Lkotlinx/serialization/KSerializer;", "START", "Lio/ktor/util/date/GMTDate;", "getSTART", "()Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GMTDate getSTART() {
            return GMTDate.START;
        }

        public final KSerializer serializer() {
            return GMTDate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public final GMTDate copy() {
        return DateJvmKt.GMTDate$default(null, 1, null);
    }

    public GMTDate(int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month, int i6, long j) {
        weekDay.getClass();
        month.getClass();
        this.seconds = i;
        this.minutes = i2;
        this.hours = i3;
        this.dayOfWeek = weekDay;
        this.dayOfMonth = i4;
        this.dayOfYear = i5;
        this.month = month;
        this.year = i6;
        this.timestamp = j;
    }
}
