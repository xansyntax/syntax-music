package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import java.net.Proxy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentSettingsKt$$ExternalSyntheticLambda110 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda110(Function1 function1, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$1;
        Function1 function1 = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    for (Proxy.Type type : CollectionsKt__IterablesKt.listOf((Object[]) new Proxy.Type[]{Proxy.Type.HTTP, Proxy.Type.SOCKS})) {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-764486927, new URLParserKt$$ExternalSyntheticLambda0(b2, type), gapComposer);
                        boolean zChanged = gapComposer.changed(function1) | gapComposer.changed(type.ordinal());
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new QueueKt$$ExternalSyntheticLambda24((Object) function1, (Object) type, (Object) mutableState, (byte) 12);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        CardKt.DropdownMenuItem(composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue, null, null, null, false, null, null, gapComposer, 6, 508);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState, (byte) 16);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AiSettingsKt.f465lambda$1307720281, gapComposer2, 805306374, 510);
                    boolean zChanged2 = gapComposer2.changed(function1);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda16(function1, mutableState, (byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AiSettingsKt.lambda$1564158736, gapComposer2, 805306368, 510);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }
}
