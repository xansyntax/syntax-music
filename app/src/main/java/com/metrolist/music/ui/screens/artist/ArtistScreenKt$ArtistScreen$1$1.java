package com.metrolist.music.ui.screens.artist;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LyricsEntity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistScreenKt$ArtistScreen$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $libraryArtist$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $showLocal$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistScreenKt$ArtistScreen$1$1(MutableState mutableState, MutableState mutableState2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$libraryArtist$delegate = mutableState;
        this.$showLocal$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$showLocal$delegate;
        MutableState mutableState2 = this.$libraryArtist$delegate;
        switch (b) {
            case 0:
                return new ArtistScreenKt$ArtistScreen$1$1(mutableState2, mutableState, continuation, (byte) 0);
            case 1:
                return new ArtistScreenKt$ArtistScreen$1$1(mutableState2, mutableState, continuation, (byte) 1);
            default:
                return new ArtistScreenKt$ArtistScreen$1$1(mutableState2, mutableState, continuation, (byte) 2);
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
                ((ArtistScreenKt$ArtistScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((ArtistScreenKt$ArtistScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((ArtistScreenKt$ArtistScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$showLocal$delegate;
        MutableState mutableState2 = this.$libraryArtist$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Artist artist = (Artist) mutableState2.getValue();
                boolean z = false;
                if (artist != null && artist.artist.isLocal) {
                    z = true;
                }
                mutableState.setValue(Boolean.valueOf(z));
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                if (((LyricsEntity) mutableState2.getValue()) != null) {
                    mutableState.setValue((LyricsEntity) mutableState2.getValue());
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue("Unexpected error occurred");
                break;
        }
        return unit;
    }
}
