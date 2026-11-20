package okhttp3.internal.concurrent;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskQueue$execute$1 extends Task {
    public final /* synthetic */ Function0 $block;
    public final /* synthetic */ byte $r8$classId = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, Function0 function0) {
        super(str, true);
        this.$block = function0;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        byte b = this.$r8$classId;
        Function0 function0 = this.$block;
        switch (b) {
            case 0:
                function0.invoke();
                return -1L;
            default:
                return ((Number) function0.invoke()).longValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, boolean z, Function0 function0) {
        super(str, z);
        this.$block = function0;
    }
}
