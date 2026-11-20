package com.metrolist.music.ui.screens.library;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Uri $uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$1$1(Context context, Uri uri, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$context = context;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$1$1(this.$context, this.$uri, continuation, (byte) 0);
            default:
                return new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$1$1(this.$context, this.$uri, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Uri uri = this.$uri;
        Context context = this.$context;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ContentResolver contentResolver = context.getContentResolver();
                contentResolver.getClass();
                return StringsKt__IndentKt.fileNameAndSize(contentResolver, uri);
            default:
                ResultKt.throwOnFailure(obj);
                ContentResolver contentResolver2 = context.getContentResolver();
                contentResolver2.getClass();
                return StringsKt__IndentKt.fileNameAndSize(contentResolver2, uri);
        }
    }
}
