package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.DialogKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProgressIndicatorKt$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ long f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ float f$6;
    public final /* synthetic */ int f$7;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ProgressIndicatorKt$$ExternalSyntheticLambda13(Function0 function0, Modifier modifier, long j, float f, long j2, int i, float f2, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = j;
        this.f$3 = f;
        this.f$4 = j2;
        this.f$5 = i;
        this.f$6 = f2;
        this.f$7 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                Function0 function0 = this.f$0;
                Modifier modifier = this.f$1;
                long j = this.f$2;
                float f = this.f$3;
                long j2 = this.f$4;
                boolean z = this.f$5;
                float f2 = this.f$6;
                ProgressIndicatorKt.m308CircularProgressIndicatorIyT6zlY(function0, modifier, j, f, j2, z ? 1 : 0, f2, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                Function0 function1 = this.f$0;
                Modifier modifier2 = this.f$1;
                long j3 = this.f$2;
                float f3 = this.f$3;
                long j4 = this.f$4;
                boolean z2 = this.f$5;
                float f4 = this.f$6;
                DialogKt.m1463CircularProgressIndicatorIyT6zlY(function1, modifier2, j3, f3, j4, z2 ? 1 : 0, f4, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
