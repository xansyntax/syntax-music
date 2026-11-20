package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.screens.settings.AboutScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda35 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda35(Modifier modifier, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier modifier = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                TimePickerKt.DisplaySeparator(modifier, composer, Stack.updateChangedFlags(1));
                break;
            case 1:
                StringsKt__IndentKt.ButtonPlaceholder(modifier, composer, Stack.updateChangedFlags(7));
                break;
            default:
                AboutScreenKt.DevBannerVideo(modifier, composer, Stack.updateChangedFlags(7));
                break;
        }
        return unit;
    }
}
