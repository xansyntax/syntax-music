package kotlinx.coroutines.selects;

import com.google.common.base.Joiner;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SelectKt {
    public static final Joiner STATE_REG = new Joiner("STATE_REG", (byte) 5);
    public static final Joiner STATE_COMPLETED = new Joiner("STATE_COMPLETED", (byte) 5);
    public static final Joiner STATE_CANCELLED = new Joiner("STATE_CANCELLED", (byte) 5);
    public static final Joiner NO_RESULT = new Joiner("NO_RESULT", (byte) 5);
    public static final Joiner PARAM_CLAUSE_0 = new Joiner("PARAM_CLAUSE_0", (byte) 5);
}
