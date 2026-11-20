package com.metrolist.music.constants;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatPeriod {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ StatPeriod[] $VALUES;
    public static final StatPeriod MONTH_1;
    public static final StatPeriod WEEK_1;

    static {
        StatPeriod statPeriod = new StatPeriod("WEEK_1", 0);
        WEEK_1 = statPeriod;
        StatPeriod statPeriod2 = new StatPeriod("MONTH_1", 1);
        MONTH_1 = statPeriod2;
        StatPeriod[] statPeriodArr = {statPeriod, statPeriod2, new StatPeriod("MONTH_3", 2), new StatPeriod("MONTH_6", 3), new StatPeriod("YEAR_1", 4), new StatPeriod("ALL", 5)};
        $VALUES = statPeriodArr;
        $ENTRIES = new EnumEntriesList(statPeriodArr);
    }

    public static StatPeriod valueOf(String str) {
        return (StatPeriod) Enum.valueOf(StatPeriod.class, str);
    }

    public static StatPeriod[] values() {
        return (StatPeriod[]) $VALUES.clone();
    }

    public final LocalDateTime toLocalDateTime() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            LocalDateTime localDateTimeMinusWeeks = LocalDateTime.now().minusWeeks(1L);
            localDateTimeMinusWeeks.getClass();
            return localDateTimeMinusWeeks;
        }
        if (iOrdinal == 1) {
            LocalDateTime localDateTimeMinusMonths = LocalDateTime.now().minusMonths(1L);
            localDateTimeMinusMonths.getClass();
            return localDateTimeMinusMonths;
        }
        if (iOrdinal == 2) {
            LocalDateTime localDateTimeMinusMonths2 = LocalDateTime.now().minusMonths(3L);
            localDateTimeMinusMonths2.getClass();
            return localDateTimeMinusMonths2;
        }
        if (iOrdinal == 3) {
            LocalDateTime localDateTimeMinusMonths3 = LocalDateTime.now().minusMonths(6L);
            localDateTimeMinusMonths3.getClass();
            return localDateTimeMinusMonths3;
        }
        if (iOrdinal == 4) {
            LocalDateTime localDateTimeMinusMonths4 = LocalDateTime.now().minusMonths(12L);
            localDateTimeMinusMonths4.getClass();
            return localDateTimeMinusMonths4;
        }
        if (iOrdinal != 5) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        LocalDateTime localDateTimeOf = LocalDateTime.of(1970, 1, 1, 0, 0);
        localDateTimeOf.getClass();
        return localDateTimeOf;
    }
}
