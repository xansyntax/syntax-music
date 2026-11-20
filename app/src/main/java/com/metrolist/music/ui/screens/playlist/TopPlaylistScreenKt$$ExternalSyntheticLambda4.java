package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda36;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ FocusOwner f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ NavHostController f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$5;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda4(byte b, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, FocusOwner focusOwner, NavHostController navHostController, Function0 function0) {
        this.$r8$classId = b;
        this.f$0 = focusOwner;
        this.f$1 = mutableState;
        this.f$2 = function0;
        this.f$3 = navHostController;
        this.f$4 = mutableState2;
        this.f$5 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        MutableState mutableState;
        MutableState mutableState2;
        NavHostController navHostController;
        MutableState mutableState3;
        MutableState mutableState4;
        NavHostController navHostController2;
        MutableState mutableState5;
        MutableState mutableState6;
        NavHostController navHostController3;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        byte b2 = 2;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final FocusOwner focusOwner = this.f$0;
                    boolean zChangedInstance = gapComposer.changedInstance(focusOwner);
                    final MutableState mutableState7 = this.f$1;
                    boolean zChanged = zChangedInstance | gapComposer.changed(mutableState7);
                    final Function0 function0 = this.f$2;
                    boolean zChanged2 = zChanged | gapComposer.changed(function0);
                    final NavHostController navHostController4 = this.f$3;
                    boolean zChangedInstance2 = zChanged2 | gapComposer.changedInstance(navHostController4);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    final MutableState mutableState8 = this.f$4;
                    if (zChangedInstance2 || objRememberedValue == neverEqualPolicy) {
                        final byte b3 = 0;
                        final MutableState mutableState9 = this.f$5;
                        Function0 function1 = new Function0() { // from class: com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState10 = mutableState7;
                                MutableState mutableState11 = mutableState9;
                                MutableState mutableState12 = mutableState8;
                                NavHostController navHostController5 = navHostController4;
                                Function0 function2 = function0;
                                FocusOwner focusOwner2 = focusOwner;
                                switch (b4) {
                                    case 0:
                                        if (((Boolean) mutableState12.getValue()).booleanValue()) {
                                            mutableState12.setValue(Boolean.FALSE);
                                            mutableState11.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState10)) {
                                            navHostController5.navigateUp();
                                        } else {
                                            function2.invoke();
                                        }
                                        break;
                                    case 1:
                                        if (((Boolean) mutableState12.getValue()).booleanValue()) {
                                            mutableState12.setValue(Boolean.FALSE);
                                            mutableState11.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState10)) {
                                            navHostController5.navigateUp();
                                        } else {
                                            function2.invoke();
                                        }
                                        break;
                                    default:
                                        if (((Boolean) mutableState12.getValue()).booleanValue()) {
                                            mutableState12.setValue(Boolean.FALSE);
                                            mutableState11.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState10)) {
                                            navHostController5.navigateUp();
                                        } else {
                                            function2.invoke();
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        mutableState = mutableState8;
                        mutableState2 = mutableState7;
                        navHostController = navHostController4;
                        gapComposer.updateRememberedValue(function1);
                        objRememberedValue = function1;
                    } else {
                        mutableState2 = mutableState7;
                        navHostController = navHostController4;
                        mutableState = mutableState8;
                    }
                    Function0 function2 = (Function0) objRememberedValue;
                    boolean zChanged3 = gapComposer.changed(mutableState2) | gapComposer.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController, mutableState, mutableState2, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.IconButton(function2, (Function0) objRememberedValue2, null, false, null, null, Expect_jvmKt.rememberComposableLambda(1460732254, new QueueKt$$ExternalSyntheticLambda39(mutableState2, (byte) 15), gapComposer), gapComposer, 1572864);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final FocusOwner focusOwner2 = this.f$0;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(focusOwner2);
                    final MutableState mutableState10 = this.f$1;
                    boolean zChanged4 = zChangedInstance3 | gapComposer2.changed(mutableState10);
                    final Function0 function3 = this.f$2;
                    boolean zChanged5 = zChanged4 | gapComposer2.changed(function3);
                    final NavHostController navHostController5 = this.f$3;
                    boolean zChangedInstance4 = zChanged5 | gapComposer2.changedInstance(navHostController5);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    final MutableState mutableState11 = this.f$4;
                    if (zChangedInstance4 || objRememberedValue3 == neverEqualPolicy) {
                        final byte b4 = 1;
                        final MutableState mutableState12 = this.f$5;
                        Function0 function4 = new Function0() { // from class: com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState13 = mutableState10;
                                MutableState mutableState14 = mutableState12;
                                MutableState mutableState15 = mutableState11;
                                NavHostController navHostController6 = navHostController5;
                                Function0 function5 = function3;
                                FocusOwner focusOwner3 = focusOwner2;
                                switch (b5) {
                                    case 0:
                                        if (((Boolean) mutableState15.getValue()).booleanValue()) {
                                            mutableState15.setValue(Boolean.FALSE);
                                            mutableState14.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner3).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState13)) {
                                            navHostController6.navigateUp();
                                        } else {
                                            function5.invoke();
                                        }
                                        break;
                                    case 1:
                                        if (((Boolean) mutableState15.getValue()).booleanValue()) {
                                            mutableState15.setValue(Boolean.FALSE);
                                            mutableState14.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner3).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState13)) {
                                            navHostController6.navigateUp();
                                        } else {
                                            function5.invoke();
                                        }
                                        break;
                                    default:
                                        if (((Boolean) mutableState15.getValue()).booleanValue()) {
                                            mutableState15.setValue(Boolean.FALSE);
                                            mutableState14.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner3).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState13)) {
                                            navHostController6.navigateUp();
                                        } else {
                                            function5.invoke();
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        mutableState3 = mutableState11;
                        mutableState4 = mutableState10;
                        navHostController2 = navHostController5;
                        gapComposer2.updateRememberedValue(function4);
                        objRememberedValue3 = function4;
                    } else {
                        mutableState4 = mutableState10;
                        navHostController2 = navHostController5;
                        mutableState3 = mutableState11;
                    }
                    Function0 function5 = (Function0) objRememberedValue3;
                    boolean zChanged6 = gapComposer2.changed(mutableState4) | gapComposer2.changedInstance(navHostController2);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged6 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController2, mutableState3, mutableState4, b2);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.IconButton(function5, (Function0) objRememberedValue4, null, false, null, null, Expect_jvmKt.rememberComposableLambda(382650188, new QueueKt$$ExternalSyntheticLambda39(mutableState4, (byte) 11), gapComposer2), gapComposer2, 1572864);
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    final FocusOwner focusOwner3 = this.f$0;
                    boolean zChangedInstance5 = gapComposer3.changedInstance(focusOwner3);
                    final MutableState mutableState13 = this.f$1;
                    boolean zChanged7 = zChangedInstance5 | gapComposer3.changed(mutableState13);
                    final Function0 function6 = this.f$2;
                    boolean zChanged8 = zChanged7 | gapComposer3.changed(function6);
                    final NavHostController navHostController6 = this.f$3;
                    boolean zChangedInstance6 = zChanged8 | gapComposer3.changedInstance(navHostController6);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    final MutableState mutableState14 = this.f$4;
                    if (zChangedInstance6 || objRememberedValue5 == neverEqualPolicy) {
                        final byte b5 = 2;
                        final MutableState mutableState15 = this.f$5;
                        Function0 function7 = new Function0() { // from class: com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b6 = b5;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState16 = mutableState13;
                                MutableState mutableState17 = mutableState15;
                                MutableState mutableState18 = mutableState14;
                                NavHostController navHostController7 = navHostController6;
                                Function0 function8 = function6;
                                FocusOwner focusOwner4 = focusOwner3;
                                switch (b6) {
                                    case 0:
                                        if (((Boolean) mutableState18.getValue()).booleanValue()) {
                                            mutableState18.setValue(Boolean.FALSE);
                                            mutableState17.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner4).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState16)) {
                                            navHostController7.navigateUp();
                                        } else {
                                            function8.invoke();
                                        }
                                        break;
                                    case 1:
                                        if (((Boolean) mutableState18.getValue()).booleanValue()) {
                                            mutableState18.setValue(Boolean.FALSE);
                                            mutableState17.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner4).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState16)) {
                                            navHostController7.navigateUp();
                                        } else {
                                            function8.invoke();
                                        }
                                        break;
                                    default:
                                        if (((Boolean) mutableState18.getValue()).booleanValue()) {
                                            mutableState18.setValue(Boolean.FALSE);
                                            mutableState17.setValue(new TextFieldValue(7, 0L, (String) null));
                                            ((FocusOwnerImpl) focusOwner4).m409clearFocusI7lrPNg(8, false, true);
                                        } else if (!TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState16)) {
                                            navHostController7.navigateUp();
                                        } else {
                                            function8.invoke();
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        mutableState5 = mutableState14;
                        mutableState6 = mutableState13;
                        navHostController3 = navHostController6;
                        gapComposer3.updateRememberedValue(function7);
                        objRememberedValue5 = function7;
                    } else {
                        mutableState6 = mutableState13;
                        navHostController3 = navHostController6;
                        mutableState5 = mutableState14;
                    }
                    Function0 function8 = (Function0) objRememberedValue5;
                    boolean zChanged9 = gapComposer3.changed(mutableState6) | gapComposer3.changedInstance(navHostController3);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged9 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController3, mutableState5, mutableState6, (byte) 3);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.IconButton(function8, (Function0) objRememberedValue6, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-888608149, new QueueKt$$ExternalSyntheticLambda39(mutableState6, (byte) 12), gapComposer3), gapComposer3, 1572864);
                }
                break;
        }
        return unit;
    }
}
