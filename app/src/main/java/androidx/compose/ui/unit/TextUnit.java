package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnit {
    public static final TextUnitType[] TextUnitTypes = {new TextUnitType(0), new TextUnitType(4294967296L), new TextUnitType(8589934592L)};
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m812equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m813getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) ((j & 1095216660480L) >>> 32)].type;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m814getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m815toStringimpl(long j) {
        long jM813getTypeUIouoOA = m813getTypeUIouoOA(j);
        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 0L)) {
            return "Unspecified";
        }
        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
            return m814getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
            return "Invalid";
        }
        return m814getValueimpl(j) + ".em";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnit) {
            return this.packedValue == ((TextUnit) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m815toStringimpl(this.packedValue);
    }
}
