package com.metrolist.music.ui.screens.playlist;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $from;
    public final /* synthetic */ int $to;
    public final /* synthetic */ LocalPlaylistViewModel $viewModel;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1(LocalPlaylistViewModel localPlaylistViewModel, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.$viewModel = localPlaylistViewModel;
        this.$from = i;
        this.$to = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1 localPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1 = new LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1(this.$viewModel, this.$from, this.$to, continuation);
        localPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1.L$0 = obj;
        return localPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1 localPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1 = (LocalPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1) create((MusicDatabase) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        localPlaylistScreenKt$LocalPlaylistScreen$12$1$1$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
        ResultKt.throwOnFailure(obj);
        musicDatabase.move(this.$from, this.$to, this.$viewModel.playlistId);
        return Unit.INSTANCE;
    }
}
