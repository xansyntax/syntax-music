package com.materialkolor.ktx;

import com.materialkolor.temperature.TemperatureCache;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\r*\u00020\u0003H\u0007b\u0002\b\u0010¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0011\u001a\u00020\r*\u00020\u0003H\u0007b\u0002\b\u0010¢\u0006\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"TemperatureCache", "Lcom/materialkolor/temperature/TemperatureCache;", "input", "Landroidx/compose/ui/graphics/Color;", "TemperatureCache-8_81llA", "(J)Lcom/materialkolor/temperature/TemperatureCache;", "temperature", "", "Lcom/materialkolor/temperature/TemperatureCache$Companion;", "color", "temperature-4WTKRHQ", "(Lcom/materialkolor/temperature/TemperatureCache$Companion;J)D", "isWarm", "", "isWarm-8_81llA", "(J)Z", "Landroidx/compose/runtime/Stable;", "isCool", "isCool-8_81llA", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class TemperatureKt {
    /* JADX INFO: renamed from: TemperatureCache-8_81llA, reason: not valid java name */
    public static final TemperatureCache m980TemperatureCache8_81llA(long j) {
        return new TemperatureCache(HctKt.m973toHct8_81llA(j));
    }

    /* JADX INFO: renamed from: isCool-8_81llA, reason: not valid java name */
    public static final boolean m981isCool8_81llA(long j) {
        return m983temperature4WTKRHQ(TemperatureCache.Companion, j) < 0.0d;
    }

    /* JADX INFO: renamed from: isWarm-8_81llA, reason: not valid java name */
    public static final boolean m982isWarm8_81llA(long j) {
        return m983temperature4WTKRHQ(TemperatureCache.Companion, j) > 0.0d;
    }

    /* JADX INFO: renamed from: temperature-4WTKRHQ, reason: not valid java name */
    public static final double m983temperature4WTKRHQ(TemperatureCache.Companion companion, long j) {
        companion.getClass();
        return TemperatureCache.Companion.rawTemperature(HctKt.m973toHct8_81llA(j));
    }
}
