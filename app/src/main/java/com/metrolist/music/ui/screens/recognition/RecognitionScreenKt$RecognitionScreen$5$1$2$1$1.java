package com.metrolist.music.ui.screens.recognition;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecognitionScreenKt$RecognitionScreen$5$1$2$1$1 extends FunctionReferenceImpl implements Function0 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MutableState $hasPermission$delegate;
    public final /* synthetic */ ManagedActivityResultLauncher $permissionLauncher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecognitionScreenKt$RecognitionScreen$5$1$2$1$1(CoroutineScope coroutineScope, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, Context context) {
        super(0, Intrinsics.Kotlin.class, "startRecognition", "RecognitionScreen$startRecognition(Lkotlinx/coroutines/CoroutineScope;Landroidx/activity/compose/ManagedActivityResultLauncher;Landroidx/compose/runtime/MutableState;Landroid/content/Context;)V", 0);
        this.$coroutineScope = coroutineScope;
        this.$permissionLauncher = managedActivityResultLauncher;
        this.$hasPermission$delegate = mutableState;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        RecognitionScreenKt.RecognitionScreen$startRecognition(this.$coroutineScope, this.$permissionLauncher, this.$hasPermission$delegate, this.$context);
        return Unit.INSTANCE;
    }
}
