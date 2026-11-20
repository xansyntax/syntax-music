package com.metrolist.music.ui.screens.search;

import com.metrolist.music.db.MusicDatabase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchScreenKt$SearchScreen$handleSearch$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $searchQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchScreenKt$SearchScreen$handleSearch$1(MusicDatabase musicDatabase, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$searchQuery = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$searchQuery;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                return new SearchScreenKt$SearchScreen$handleSearch$1(musicDatabase, str, continuation, (byte) 0);
            default:
                return new SearchScreenKt$SearchScreen$handleSearch$1(musicDatabase, str, continuation, (byte) 1);
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
                ((SearchScreenKt$SearchScreen$handleSearch$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((SearchScreenKt$SearchScreen$handleSearch$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$searchQuery;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                musicDatabase.query(new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 15));
                break;
            default:
                ResultKt.throwOnFailure(obj);
                musicDatabase.query(new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 14));
                break;
        }
        return unit;
    }
}
