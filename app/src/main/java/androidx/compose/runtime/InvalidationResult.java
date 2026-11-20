package androidx.compose.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InvalidationResult {
    public static final /* synthetic */ InvalidationResult[] $VALUES;
    public static final InvalidationResult DEFERRED;
    public static final InvalidationResult IGNORED;
    public static final InvalidationResult IMMINENT;
    public static final InvalidationResult SCHEDULED;

    static {
        InvalidationResult invalidationResult = new InvalidationResult("IGNORED", 0);
        IGNORED = invalidationResult;
        InvalidationResult invalidationResult2 = new InvalidationResult("SCHEDULED", 1);
        SCHEDULED = invalidationResult2;
        InvalidationResult invalidationResult3 = new InvalidationResult("DEFERRED", 2);
        DEFERRED = invalidationResult3;
        InvalidationResult invalidationResult4 = new InvalidationResult("IMMINENT", 3);
        IMMINENT = invalidationResult4;
        $VALUES = new InvalidationResult[]{invalidationResult, invalidationResult2, invalidationResult3, invalidationResult4};
    }

    public static InvalidationResult valueOf(String str) {
        return (InvalidationResult) Enum.valueOf(InvalidationResult.class, str);
    }

    public static InvalidationResult[] values() {
        return (InvalidationResult[]) $VALUES.clone();
    }
}
