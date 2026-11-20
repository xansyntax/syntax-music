package com.metrolist.music.ui.screens;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.ui.component.MenuState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1 implements Function0 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ YTItem $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1(HapticFeedback hapticFeedback, MenuState menuState, YTItem yTItem, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$menuState = menuState;
        this.$item = yTItem;
        this.$coroutineScope = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = this.$coroutineScope;
        YTItem yTItem = this.$item;
        MenuState menuState = this.$menuState;
        HapticFeedback hapticFeedback = this.$haptic;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, 974359972, new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1.AnonymousClass1((byte) 1, yTItem, menuState, coroutineScope)));
                break;
            case 1:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -874636463, new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1.AnonymousClass1((byte) 4, yTItem, menuState, coroutineScope)));
                break;
            default:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, 1096585400, new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1.AnonymousClass1((byte) 5, yTItem, menuState, coroutineScope)));
                break;
        }
        return unit;
    }
}
