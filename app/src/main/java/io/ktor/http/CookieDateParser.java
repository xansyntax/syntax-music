package io.ktor.http;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/http/CookieDateParser;", "", "<init>", "()V", "T", "", "source", ContentDisposition.Parameters.Name, "field", "", "checkFieldNotNull", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "", "requirement", "Lkotlin/Function0;", "msg", "checkRequirement", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Lio/ktor/util/date/GMTDate;", "parse", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CookieDateParser {
    private final <T> void checkFieldNotNull(String source, String name, T field) {
        if (field == null) {
            throw new InvalidCookieDateException(source, Fragment$5$$ExternalSyntheticOutline0.m("Could not find ", name));
        }
    }

    private final void checkRequirement(String source, boolean requirement, Function0 msg) {
        if (!requirement) {
            throw new InvalidCookieDateException(source, (String) msg.invoke());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$4() {
        return "day-of-month not in [1,31]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$5() {
        return "year >= 1601";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$6() {
        return "hours > 23";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$7() {
        return "minutes > 59";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$8() {
        return "seconds > 59";
    }

    public final GMTDate parse(String source) {
        source.getClass();
        StringLexer stringLexer = new StringLexer(source);
        CookieDateBuilder cookieDateBuilder = new CookieDateBuilder();
        stringLexer.acceptWhile(new Events$$ExternalSyntheticLambda0((byte) 23));
        while (stringLexer.getHasRemaining()) {
            if (stringLexer.test(new Events$$ExternalSyntheticLambda0((byte) 24))) {
                int index = stringLexer.getIndex();
                stringLexer.acceptWhile(new Events$$ExternalSyntheticLambda0((byte) 25));
                CookieUtilsKt.handleToken(cookieDateBuilder, stringLexer.getSource().substring(index, stringLexer.getIndex()));
                stringLexer.acceptWhile(new Events$$ExternalSyntheticLambda0((byte) 26));
            }
        }
        Integer year = cookieDateBuilder.getYear();
        IntRange intRange = new IntRange(70, 99, 1);
        if (year == null || !intRange.contains(year.intValue())) {
            IntRange intRange2 = new IntRange(0, 69, 1);
            if (year != null && intRange2.contains(year.intValue())) {
                Integer year2 = cookieDateBuilder.getYear();
                year2.getClass();
                cookieDateBuilder.setYear(Integer.valueOf(year2.intValue() + 2000));
            }
        } else {
            Integer year3 = cookieDateBuilder.getYear();
            year3.getClass();
            cookieDateBuilder.setYear(Integer.valueOf(year3.intValue() + 1900));
        }
        checkFieldNotNull(source, "day-of-month", cookieDateBuilder.getDayOfMonth());
        checkFieldNotNull(source, "month", cookieDateBuilder.getMonth());
        checkFieldNotNull(source, "year", cookieDateBuilder.getYear());
        checkFieldNotNull(source, "time", cookieDateBuilder.getHours());
        checkFieldNotNull(source, "time", cookieDateBuilder.getMinutes());
        checkFieldNotNull(source, "time", cookieDateBuilder.getSeconds());
        IntRange intRange3 = new IntRange(1, 31, 1);
        Integer dayOfMonth = cookieDateBuilder.getDayOfMonth();
        checkRequirement(source, dayOfMonth != null && intRange3.contains(dayOfMonth.intValue()), new Cookie$$ExternalSyntheticLambda1((byte) 9));
        Integer year4 = cookieDateBuilder.getYear();
        year4.getClass();
        checkRequirement(source, year4.intValue() >= 1601, new Cookie$$ExternalSyntheticLambda1((byte) 10));
        Integer hours = cookieDateBuilder.getHours();
        hours.getClass();
        checkRequirement(source, hours.intValue() <= 23, new Cookie$$ExternalSyntheticLambda1((byte) 11));
        Integer minutes = cookieDateBuilder.getMinutes();
        minutes.getClass();
        checkRequirement(source, minutes.intValue() <= 59, new Cookie$$ExternalSyntheticLambda1((byte) 12));
        Integer seconds = cookieDateBuilder.getSeconds();
        seconds.getClass();
        checkRequirement(source, seconds.intValue() <= 59, new Cookie$$ExternalSyntheticLambda1((byte) 13));
        return cookieDateBuilder.build();
    }
}
