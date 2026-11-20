package com.metrolist.music.ui.player;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.PlayerMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda43 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda43(MediaMetadata mediaMetadata, boolean z, Function0 function0, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
        this.f$1 = z;
        this.f$2 = function0;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        Function0 function0 = this.f$2;
        boolean z = this.f$1;
        MediaMetadata mediaMetadata = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                num.intValue();
                QueueKt.InlineLyricsView(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
            case 1:
                num.getClass();
                PlayerMenuKt.ListenTogetherDialog(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
            case 2:
                num.getClass();
                PlayerMenuKt.ListenTogetherDialog(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
            case 3:
                num.getClass();
                PlayerMenuKt.ListenTogetherDialog(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
            case 4:
                num.getClass();
                PlayerMenuKt.ListenTogetherDialog(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
            default:
                num.intValue();
                QueueKt.InlineLyricsView(Stack.updateChangedFlags(i | 1), composer, mediaMetadata, function0, z);
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda43(boolean z, MediaMetadata mediaMetadata, Function0 function0, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = z;
        this.f$0 = mediaMetadata;
        this.f$2 = function0;
        this.f$3 = i;
    }
}
