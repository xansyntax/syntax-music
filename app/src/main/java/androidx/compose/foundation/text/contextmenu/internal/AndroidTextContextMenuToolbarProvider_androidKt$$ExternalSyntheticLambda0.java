package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = composableLambdaImpl;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        Modifier modifier = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$1(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
            case 2:
                DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
            case 3:
                AndroidTextContextMenuToolbarProvider_androidKt.ProvideDefaultPlatformTextContextMenuProviders(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
            default:
                AndroidTextContextMenuToolbarProvider_androidKt.ProvideBothDefaultProviders(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }
}
