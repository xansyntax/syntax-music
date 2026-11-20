package androidx.navigation.compose;

import android.content.Context;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavHostKt$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda13(State state, String str, String str2, String str3, Context context, String str4, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = state;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
        this.f$5 = context;
        this.f$6 = str4;
        this.f$7 = mutableState;
        this.f$8 = mutableState2;
        this.f$10 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$10;
        Object obj4 = this.f$8;
        Object obj5 = this.f$7;
        Object obj6 = this.f$6;
        Object obj7 = this.f$5;
        Object obj8 = this.f$3;
        Object obj9 = this.f$2;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                FileSystemsKt.NavHost((NavHostController) obj10, this.f$1, (Modifier) obj9, (Alignment) obj8, (Function1) obj7, (Function1) obj6, (Function1) obj5, (Function1) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(115015681));
                break;
            default:
                State state = (State) obj10;
                String str = (String) obj9;
                String str2 = (String) obj8;
                Context context = (Context) obj7;
                String str3 = (String) obj6;
                MutableState mutableState = (MutableState) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(SizeKt.fillMaxWidth(OffsetKt.m135padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16.0f), 0.85f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).shapes.medium, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface, 0L, gapComposer, 14), CardKt.m268cardElevationaqJV_2Y(8.0f), null, Expect_jvmKt.rememberComposableLambda(-30009056, new LyricsMenuKt$$ExternalSyntheticLambda0(state, this.f$1, str, str2, context, str3, mutableState, mutableState2, mutableState3), gapComposer), gapComposer, 196614, 16);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda13(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i) {
        this.f$0 = navHostController;
        this.f$1 = str;
        this.f$2 = modifier;
        this.f$3 = alignment;
        this.f$5 = function1;
        this.f$6 = function2;
        this.f$7 = function3;
        this.f$8 = function4;
        this.f$10 = function5;
    }
}
