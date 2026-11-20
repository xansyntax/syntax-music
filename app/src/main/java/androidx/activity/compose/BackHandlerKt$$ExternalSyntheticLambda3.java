package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ boolean f$3;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda3(boolean z, Function function, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$3;
        int i = this.f$2;
        Function function = this.f$1;
        boolean z2 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                UtilsKt.BackHandler(z2, (Function0) function, (Composer) obj, Stack.updateChangedFlags(i | 1), z ? 1 : 0);
                break;
            default:
                ((Integer) obj2).getClass();
                SQLite.PredictiveBackHandler(z2, (Function2) function, (Composer) obj, Stack.updateChangedFlags(i | 1), z ? 1 : 0);
                break;
        }
        return unit;
    }
}
