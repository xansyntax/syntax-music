package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.MenuKt;
import com.yalantis.ucrop.R;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerSettingsKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda7(boolean z, boolean z2, Function1 function1) {
        this.$r8$classId = (byte) 1;
        this.f$0 = z;
        this.f$2 = z2;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Function1 function1 = this.f$1;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(function1);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 16);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    boolean z = this.f$0;
                    MenuKt.Switch(z, (Function1) objRememberedValue, null, Expect_jvmKt.rememberComposableLambda(-1364466408, new PlayerSettingsKt$$ExternalSyntheticLambda14((byte) 8, z), gapComposer), this.f$2, null, gapComposer, 3072, 100);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final boolean z2 = this.f$0;
                    final boolean z3 = this.f$2;
                    MenuKt.Switch(z2 ? false : z3, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1248501862, new Function2() { // from class: com.metrolist.music.ui.screens.settings.PlayerSettingsKt$$ExternalSyntheticLambda98
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Composer composer3 = (Composer) obj3;
                            int iIntValue3 = ((Integer) obj4).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer3;
                            if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                IconKt.m290Iconww6aTOc(IntMath.painterResource((z2 || !z3) ? R.drawable.close : R.drawable.check, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 16.0f), 0L, gapComposer3, 56, 8);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer2), !z2, null, gapComposer2, 3072, 100);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    boolean z4 = this.f$0;
                    MenuKt.Switch(z4, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1725550811, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 12, z4), gapComposer3), this.f$2, null, gapComposer3, 3072, 100);
                }
                break;
            default:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean zChanged2 = gapComposer4.changed(function1);
                    Object objRememberedValue2 = gapComposer4.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 17);
                        gapComposer4.updateRememberedValue(objRememberedValue2);
                    }
                    boolean z5 = this.f$0;
                    MenuKt.Switch(z5, (Function1) objRememberedValue2, null, Expect_jvmKt.rememberComposableLambda(912308228, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 13, z5), gapComposer4), this.f$2, null, gapComposer4, 3072, 100);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda7(boolean z, Function1 function1, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function1;
        this.f$2 = z2;
    }
}
