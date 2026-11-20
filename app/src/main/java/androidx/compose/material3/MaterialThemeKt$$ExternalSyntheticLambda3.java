package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.ColorKt;
import io.ktor.network.sockets.DatagramKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MaterialThemeKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ColorScheme f$0;
    public final /* synthetic */ MotionScheme f$1;
    public final /* synthetic */ Shapes f$2;
    public final /* synthetic */ Typography f$3;
    public final /* synthetic */ Function2 f$4;

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda3(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i) {
        this.$r8$classId = (byte) 1;
        this.f$0 = colorScheme;
        this.f$1 = motionScheme;
        this.f$2 = shapes;
        this.f$3 = typography;
        this.f$4 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ColorScheme colorSchemeM285lightColorScheme_VG5OTI$default = this.f$0;
                    if (colorSchemeM285lightColorScheme_VG5OTI$default == null) {
                        colorSchemeM285lightColorScheme_VG5OTI$default = ColorSchemeKt.m285lightColorScheme_VG5OTI$default(0L, 0L, 0L, ColorKt.Color$default(79, 55, 139), 0L, 0L, 0L, 0L, ColorKt.Color$default(74, 68, 88), 0L, 0L, 0L, ColorKt.Color$default(99, 59, 72), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.Color$default(140, 29, 24), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -33558793, DatagramKt.MAX_DATAGRAM_SIZE);
                    }
                    ColorScheme colorScheme = colorSchemeM285lightColorScheme_VG5OTI$default;
                    MotionScheme motionScheme = this.f$1;
                    if (motionScheme == null) {
                        motionScheme = MotionScheme.ExpressiveMotionSchemeImpl.INSTANCE;
                    }
                    MotionScheme motionScheme2 = motionScheme;
                    Shapes shapes = this.f$2;
                    if (shapes == null) {
                        shapes = new Shapes();
                    }
                    Shapes shapes2 = shapes;
                    Typography typography = this.f$3;
                    if (typography == null) {
                        typography = new Typography();
                    }
                    MaterialThemeKt.MaterialTheme(colorScheme, motionScheme2, shapes2, typography, this.f$4, gapComposer, 0);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                MaterialThemeKt.MaterialExpressiveTheme(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    MaterialThemeKt.MaterialExpressiveTheme(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda3(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = colorScheme;
        this.f$1 = motionScheme;
        this.f$2 = shapes;
        this.f$3 = typography;
        this.f$4 = function2;
    }
}
