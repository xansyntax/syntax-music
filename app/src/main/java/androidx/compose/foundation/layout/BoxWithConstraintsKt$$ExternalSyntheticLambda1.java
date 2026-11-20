package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.MenuKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BoxWithConstraintsKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ byte f$5;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BoxWithConstraintsKt$$ExternalSyntheticLambda1(Modifier modifier, Alignment alignment, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = modifier;
        this.f$1 = alignment;
        this.f$3 = composableLambdaImpl;
        this.f$4 = i;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$4;
        Object obj3 = this.f$3;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                OffsetKt.BoxWithConstraints(this.f$0, (Alignment) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags, this.f$5);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                MenuKt.Material3SettingsGroup((String) obj4, (List) obj3, this.f$0, (Composer) obj, iUpdateChangedFlags2, this.f$5);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BoxWithConstraintsKt$$ExternalSyntheticLambda1(String str, List list, Modifier modifier, int i, int i2) {
        this.f$1 = str;
        this.f$3 = list;
        this.f$0 = modifier;
        this.f$4 = i;
        this.f$5 = i2;
    }
}
