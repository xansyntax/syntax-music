package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1 implements Function0 {
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $song$delegate;

    public /* synthetic */ HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(HapticFeedback hapticFeedback, MenuState menuState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$menuState = menuState;
        this.$song$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$song$delegate;
        MenuState menuState = this.$menuState;
        HapticFeedback hapticFeedback = this.$haptic;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -1729039321, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState, mutableState, (byte) 3)));
                break;
            case 1:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -101900277, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState, mutableState, (byte) 1)));
                break;
            default:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -756443409, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState, mutableState, (byte) 2)));
                break;
        }
        return unit;
    }
}
