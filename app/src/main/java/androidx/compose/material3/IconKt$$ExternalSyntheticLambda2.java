package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.text.TextStyle;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ byte f$5;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ IconKt$$ExternalSyntheticLambda2(Painter painter, String str, Modifier modifier, long j, int i, int i2) {
        this.f$0 = painter;
        this.f$1 = str;
        this.f$2 = modifier;
        this.f$3 = j;
        this.f$4 = i;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$4 | 1);
                IconKt.m290Iconww6aTOc((Painter) obj4, (String) obj3, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags, this.f$5);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(24625);
                com.metrolist.music.ui.component.MenuKt.ClickableArtistTextEntities((List) obj4, this.f$2, (TextStyle) obj3, this.f$3, this.f$4, this.f$5, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ IconKt$$ExternalSyntheticLambda2(List list, Modifier modifier, TextStyle textStyle, long j, int i, int i2, int i3) {
        this.f$0 = list;
        this.f$2 = modifier;
        this.f$1 = textStyle;
        this.f$3 = j;
        this.f$4 = i;
        this.f$5 = i2;
    }
}
