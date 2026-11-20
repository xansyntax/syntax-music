package com.metrolist.music;

import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda14 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ String f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda14(DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, boolean z, PlayerConnection playerConnection, MainActivity mainActivity, MusicDatabase musicDatabase, DownloadUtil downloadUtil, SyncUtils syncUtils, MutableState mutableState, MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, String str, MutableState mutableState2) {
        this.f$0 = dataStoreKt$rememberPreference$1$1;
        this.f$1 = dataStoreKt$rememberPreference$1$2;
        this.f$2 = z;
        this.f$3 = playerConnection;
        this.f$4 = mainActivity;
        this.f$5 = musicDatabase;
        this.f$6 = downloadUtil;
        this.f$7 = syncUtils;
        this.f$8 = mutableState;
        this.f$9 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
        this.f$10 = str;
        this.f$11 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$9;
        Object obj4 = this.f$7;
        Object obj5 = this.f$6;
        Object obj6 = this.f$5;
        Object obj7 = this.f$4;
        Object obj8 = this.f$3;
        Object obj9 = this.f$11;
        Object obj10 = this.f$8;
        Object obj11 = this.f$1;
        Object obj12 = this.f$0;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj12;
                MutableState mutableState2 = (MutableState) obj11;
                PlayerConnection playerConnection = (PlayerConnection) obj8;
                MainActivity mainActivity = (MainActivity) obj7;
                MusicDatabase musicDatabase = (MusicDatabase) obj6;
                DownloadUtil downloadUtil = (DownloadUtil) obj5;
                SyncUtils syncUtils = (SyncUtils) obj4;
                MutableState mutableState3 = (MutableState) obj10;
                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) obj3;
                MutableState mutableState4 = (MutableState) obj9;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalDensity;
                    Density density = (Density) gapComposer.consume(staticProvidableCompositionLocal);
                    long jM714getContainerDpSizeMYxV2XQ = ((LazyWindowInfo) ((WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo))).m714getContainerDpSizeMYxV2XQ();
                    Dp dp = new Dp(DpSize.m802getWidthD9Ej5fM(jM714getContainerDpSizeMYxV2XQ));
                    Dp dp2 = new Dp(DpSize.m801getHeightD9Ej5fM(jM714getContainerDpSizeMYxV2XQ));
                    if (dp.compareTo(dp2) > 0) {
                        dp = dp2;
                    }
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    float f = dp.value;
                    boolean zChanged = gapComposer.changed(zBooleanValue) | gapComposer.changed(f);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        float f2 = 1.0f;
                        if (((Boolean) mutableState.getValue()).booleanValue()) {
                            if (Dp.m795compareTo0680j_4(f, 840.0f) >= 0) {
                                f2 = 1.15f;
                            } else if (Dp.m795compareTo0680j_4(f, 720.0f) >= 0) {
                                f2 = 1.1f;
                            } else if (Dp.m795compareTo0680j_4(f, 600.0f) >= 0) {
                                f2 = 1.05f;
                            }
                        }
                        objRememberedValue = Float.valueOf(f2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    float fFloatValue = ((Number) objRememberedValue).floatValue();
                    boolean zChanged2 = gapComposer.changed(((Number) mutableState2.getValue()).floatValue()) | gapComposer.changed(density) | gapComposer.changed(fFloatValue);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new DensityImpl(((Number) mutableState2.getValue()).floatValue() * density.getDensity() * fFloatValue, density.getFontScale());
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime((Density) objRememberedValue2), Expect_jvmKt.rememberComposableLambda(-2050689397, new ChipKt$$ExternalSyntheticLambda1(this.f$2, playerConnection, mainActivity, musicDatabase, downloadUtil, syncUtils, mutableState3, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, this.f$10, mutableState4), gapComposer), gapComposer, 56);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.JoinCreateRoomSection(this.f$10, (Function1) obj12, (String) obj11, (Function1) obj10, (String) obj9, this.f$2, (String) obj8, (String) obj7, (BringIntoViewRequesterImpl) obj6, (Function0) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda14(String str, Function1 function1, String str2, Function1 function2, String str3, boolean z, String str4, String str5, BringIntoViewRequesterImpl bringIntoViewRequesterImpl, Function0 function0, Function0 function3, Function0 function4, int i) {
        this.f$10 = str;
        this.f$0 = function1;
        this.f$1 = str2;
        this.f$8 = function2;
        this.f$11 = str3;
        this.f$2 = z;
        this.f$3 = str4;
        this.f$4 = str5;
        this.f$5 = bringIntoViewRequesterImpl;
        this.f$6 = function0;
        this.f$7 = function3;
        this.f$9 = function4;
    }
}
