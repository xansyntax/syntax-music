package androidx.compose.foundation.text.selection;

import android.os.Build;
import androidx.compose.foundation.MagnifierElement;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.foundation.PlatformMagnifierFactoryApi29Impl;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Density f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4(Density density, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = density;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.f$1;
        Density density = this.f$0;
        switch (b) {
            case 0:
                AppBarKt$$ExternalSyntheticLambda8 appBarKt$$ExternalSyntheticLambda8 = new AppBarKt$$ExternalSyntheticLambda8((Function0) obj, (byte) 2);
                TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 = new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4(density, mutableState, (byte) 1);
                if (Magnifier_androidKt.isPlatformMagnifierSupported$default()) {
                    return Magnifier_androidKt.isPlatformMagnifierSupported$default() ? new MagnifierElement(appBarKt$$ExternalSyntheticLambda8, textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4, Build.VERSION.SDK_INT == 28 ? PlatformMagnifierFactoryApi28Impl.INSTANCE : PlatformMagnifierFactoryApi29Impl.INSTANCE) : Modifier.Companion.$$INSTANCE;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$2("Magnifier is only supported on API level 28 and higher.");
                return null;
            default:
                ((DpSize) obj).getClass();
                mutableState.setValue(new IntSize((((long) density.mo75roundToPx0680j_4(DpSize.m801getHeightD9Ej5fM(0L))) & 4294967295L) | (((long) density.mo75roundToPx0680j_4(DpSize.m802getWidthD9Ej5fM(0L))) << 32)));
                return Unit.INSTANCE;
        }
    }
}
