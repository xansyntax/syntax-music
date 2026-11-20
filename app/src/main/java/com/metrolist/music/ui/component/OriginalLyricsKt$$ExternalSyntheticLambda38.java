package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OriginalLyricsKt$$ExternalSyntheticLambda38 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LyricsBackgroundStyle f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ OriginalLyricsKt$$ExternalSyntheticLambda38(LyricsBackgroundStyle lyricsBackgroundStyle, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = lyricsBackgroundStyle;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        LyricsBackgroundStyle lyricsBackgroundStyle = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(lyricsBackgroundStyle);
                break;
            default:
                mutableState.setValue(lyricsBackgroundStyle);
                break;
        }
        return unit;
    }
}
