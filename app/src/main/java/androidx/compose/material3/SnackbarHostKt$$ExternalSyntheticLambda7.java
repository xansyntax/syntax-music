package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.pager.PagerLazyLayoutItemProvider;
import androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$3;

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda7(int i, LazyLayoutItemProvider lazyLayoutItemProvider, Object obj) {
        this.$r8$classId = (byte) 4;
        this.f$0 = lazyLayoutItemProvider;
        this.f$3 = i;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ScrimKt.FadeInFadeOutWithScale((SnackbarHostState.SnackbarDataImpl) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                ((Integer) obj2).intValue();
                ((Transition) obj4).animateTo$animation_core(obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                ((LazyListItemProviderImpl) obj4).Item(i, obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                ((LazyGridItemProviderImpl) obj4).Item(i, obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 4:
                LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) obj4;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    lazyLayoutItemProvider.Item(i, obj3, gapComposer, 0);
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                ((PagerLazyLayoutItemProvider) obj4).Item(i, obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                AnnotatedStringResolveInlineContentKt.InlineChildren((AnnotatedString) obj4, (List) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 7:
                ((Integer) obj2).intValue();
                Stack.CompositionLocalProvider((ProvidedValue) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 8:
                ((Integer) obj2).intValue();
                Stack.CompositionLocalProvider((ProvidedValue[]) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                ((ComposableLambdaImpl) obj4).invoke(obj3, (Composer) obj, Stack.updateChangedFlags(i) | 1);
                break;
        }
        return unit;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda7(LazyLayoutItemProvider lazyLayoutItemProvider, int i, Object obj, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyLayoutItemProvider;
        this.f$3 = i;
        this.f$1 = obj;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda7(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$3 = i;
    }
}
