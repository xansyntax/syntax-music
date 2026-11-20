package androidx.compose.animation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutationPhase {
    public static final /* synthetic */ MutationPhase[] $VALUES;
    public static final MutationPhase Handoff;
    public static final MutationPhase Idle;
    public static final MutationPhase Mutating;
    public static final MutationPhase MutatingCatchingUp;
    public static final MutationPhase MutatingPendingCatchUp;

    static {
        MutationPhase mutationPhase = new MutationPhase("Idle", 0);
        Idle = mutationPhase;
        MutationPhase mutationPhase2 = new MutationPhase("MutatingPendingCatchUp", 1);
        MutatingPendingCatchUp = mutationPhase2;
        MutationPhase mutationPhase3 = new MutationPhase("MutatingCatchingUp", 2);
        MutatingCatchingUp = mutationPhase3;
        MutationPhase mutationPhase4 = new MutationPhase("Mutating", 3);
        Mutating = mutationPhase4;
        MutationPhase mutationPhase5 = new MutationPhase("Handoff", 4);
        Handoff = mutationPhase5;
        $VALUES = new MutationPhase[]{mutationPhase, mutationPhase2, mutationPhase3, mutationPhase4, mutationPhase5};
    }

    public static MutationPhase valueOf(String str) {
        return (MutationPhase) Enum.valueOf(MutationPhase.class, str);
    }

    public static MutationPhase[] values() {
        return (MutationPhase[]) $VALUES.clone();
    }
}
