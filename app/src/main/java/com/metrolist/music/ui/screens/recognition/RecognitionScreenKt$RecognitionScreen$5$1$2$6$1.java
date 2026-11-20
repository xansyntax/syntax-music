package com.metrolist.music.ui.screens.recognition;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.recognition.MusicRecognitionService;
import com.metrolist.shazamkit.models.RecognitionResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecognitionScreenKt$RecognitionScreen$5$1$2$6$1 extends FunctionReferenceImpl implements Function1 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MusicDatabase $database;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecognitionScreenKt$RecognitionScreen$5$1$2$6$1(CoroutineScope coroutineScope, MusicDatabase musicDatabase) {
        super(1, Intrinsics.Kotlin.class, "saveToHistory", "RecognitionScreen$saveToHistory(Lkotlinx/coroutines/CoroutineScope;Lcom/metrolist/music/db/MusicDatabase;Lcom/metrolist/shazamkit/models/RecognitionResult;)V", 0);
        this.$coroutineScope = coroutineScope;
        this.$database = musicDatabase;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RecognitionResult recognitionResult = (RecognitionResult) obj;
        recognitionResult.getClass();
        if (!MusicRecognitionService.resultSavedExternally) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(this.$coroutineScope, DefaultIoScheduler.INSTANCE, null, new InterruptibleKt$runInterruptible$2(this.$database, recognitionResult, null, (byte) 5), 2);
        }
        return Unit.INSTANCE;
    }
}
