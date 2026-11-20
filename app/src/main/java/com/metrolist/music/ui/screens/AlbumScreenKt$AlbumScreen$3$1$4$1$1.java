package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$3$1$4$1$1 implements Function0 {
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AlbumScreenKt$AlbumScreen$3$1$4$1$1(HapticFeedback hapticFeedback, Function1 function1, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$onCheckedChange = function1;
        this.$inSelectMode$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.$onCheckedChange;
        HapticFeedback hapticFeedback = this.$haptic;
        MutableState mutableState = this.$inSelectMode$delegate;
        switch (b) {
            case 0:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool = Boolean.TRUE;
                    mutableState.setValue(bool);
                    function1.invoke(bool);
                }
                break;
            case 1:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool2 = Boolean.TRUE;
                    mutableState.setValue(bool2);
                    function1.invoke(bool2);
                }
                break;
            default:
                if (!AlbumScreenKt.HistoryScreen$lambda$4(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool3 = Boolean.TRUE;
                    mutableState.setValue(bool3);
                    function1.invoke(bool3);
                }
                break;
        }
        return unit;
    }
}
