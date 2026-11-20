package kotlinx.serialization.json;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DecodeSequenceMode {
    public static final /* synthetic */ DecodeSequenceMode[] $VALUES;
    public static final DecodeSequenceMode ARRAY_WRAPPED;
    public static final DecodeSequenceMode WHITESPACE_SEPARATED;

    static {
        DecodeSequenceMode decodeSequenceMode = new DecodeSequenceMode("WHITESPACE_SEPARATED", 0);
        WHITESPACE_SEPARATED = decodeSequenceMode;
        DecodeSequenceMode decodeSequenceMode2 = new DecodeSequenceMode("ARRAY_WRAPPED", 1);
        ARRAY_WRAPPED = decodeSequenceMode2;
        $VALUES = new DecodeSequenceMode[]{decodeSequenceMode, decodeSequenceMode2, new DecodeSequenceMode("AUTO_DETECT", 2)};
    }

    public static DecodeSequenceMode valueOf(String str) {
        return (DecodeSequenceMode) Enum.valueOf(DecodeSequenceMode.class, str);
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) $VALUES.clone();
    }
}
