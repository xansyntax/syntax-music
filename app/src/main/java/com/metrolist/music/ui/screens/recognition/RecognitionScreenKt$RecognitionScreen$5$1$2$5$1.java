package com.metrolist.music.ui.screens.recognition;

import com.metrolist.music.recognition.MusicRecognitionService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecognitionScreenKt$RecognitionScreen$5$1$2$5$1 extends FunctionReferenceImpl implements Function0 {
    public static final RecognitionScreenKt$RecognitionScreen$5$1$2$5$1 INSTANCE = new RecognitionScreenKt$RecognitionScreen$5$1$2$5$1(0, Intrinsics.Kotlin.class, "resetToReady", "RecognitionScreen$resetToReady()V", 0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
        MusicRecognitionService.reset();
        return Unit.INSTANCE;
    }
}
