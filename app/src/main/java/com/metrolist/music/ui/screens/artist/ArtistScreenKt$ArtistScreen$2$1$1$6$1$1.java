package com.metrolist.music.ui.screens.artist;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$3$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistScreenKt$ArtistScreen$2$1$1$6$1$1 implements Function0 {
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song $song;

    public /* synthetic */ ArtistScreenKt$ArtistScreen$2$1$1$6$1$1(HapticFeedback hapticFeedback, MenuState menuState, Song song, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$menuState = menuState;
        this.$song = song;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Song song = this.$song;
        MenuState menuState = this.$menuState;
        HapticFeedback hapticFeedback = this.$haptic;
        switch (b) {
            case 0:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, -1702552890, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(song, menuState, (byte) 2)));
                break;
            default:
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                menuState.show(new ComposableLambdaImpl(true, 1695950428, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(song, menuState, (byte) 5)));
                break;
        }
        return unit;
    }
}
