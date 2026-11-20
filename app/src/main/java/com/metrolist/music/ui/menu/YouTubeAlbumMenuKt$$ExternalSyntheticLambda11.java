package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$$ExternalSyntheticLambda29;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeAlbumMenuKt$$ExternalSyntheticLambda11 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MusicDatabase f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ YouTubeAlbumMenuKt$$ExternalSyntheticLambda11(MusicDatabase musicDatabase, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = musicDatabase;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final MutableState mutableState = this.f$1;
        final MusicDatabase musicDatabase = this.f$0;
        boolean z = false;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer.changedInstance(musicDatabase) | gapComposer.changed(mutableState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        final byte b3 = z ? (byte) 1 : (byte) 0;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                MusicDatabase musicDatabase2 = musicDatabase;
                                switch (b4) {
                                    case 0:
                                        musicDatabase2.query(new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 20));
                                        break;
                                    case 1:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 14));
                                        break;
                                    default:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 13));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, Expect_jvmKt.rememberComposableLambda(112375689, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 24), gapComposer), gapComposer, 1572864, 62);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PlayerSettingsKt$$ExternalSyntheticLambda29(mutableState, (byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AiSettingsKt.lambda$891867812, gapComposer2, 805306374, 510);
                    boolean zChangedInstance2 = gapComposer2.changedInstance(musicDatabase);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                MusicDatabase musicDatabase2 = musicDatabase;
                                switch (b4) {
                                    case 0:
                                        musicDatabase2.query(new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 20));
                                        break;
                                    case 1:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 14));
                                        break;
                                    default:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 13));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AiSettingsKt.f540lambda$270681139, gapComposer2, 805306368, 510);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerSettingsKt$$ExternalSyntheticLambda29(mutableState, (byte) 7);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AiSettingsKt.f511lambda$1947162291, gapComposer3, 805306374, 510);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(musicDatabase);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue5 == neverEqualPolicy) {
                        final byte b4 = 2;
                        objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                MusicDatabase musicDatabase2 = musicDatabase;
                                switch (b5) {
                                    case 0:
                                        musicDatabase2.query(new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 20));
                                        break;
                                    case 1:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 14));
                                        break;
                                    default:
                                        mutableState2.setValue(Boolean.FALSE);
                                        musicDatabase2.query(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 13));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AiSettingsKt.lambda$1829760054, gapComposer3, 805306368, 510);
                }
                break;
        }
        return unit;
    }
}
