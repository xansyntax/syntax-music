package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import com.metrolist.music.recognition.MusicRecognitionService;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Transition$animateTo$lambda$2$0$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ byte $r8$classId;

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                MusicRecognitionService.reset();
                break;
        }
    }

    private final void dispose$androidx$compose$animation$core$Transition$animateTo$lambda$2$0$$inlined$onDispose$1() {
    }
}
