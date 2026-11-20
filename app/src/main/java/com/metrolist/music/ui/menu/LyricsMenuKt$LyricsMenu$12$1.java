package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsMenuKt$LyricsMenu$12$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $isChecked$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 $songProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LyricsMenuKt$LyricsMenu$12$1(Function0 function0, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$songProvider = function0;
        this.$isChecked$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$isChecked$delegate;
        Function0 function0 = this.$songProvider;
        switch (b) {
            case 0:
                return new LyricsMenuKt$LyricsMenu$12$1(function0, mutableState, continuation, (byte) 0);
            default:
                return new LyricsMenuKt$LyricsMenu$12$1(function0, mutableState, continuation, (byte) 1);
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
                ((LyricsMenuKt$LyricsMenu$12$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((LyricsMenuKt$LyricsMenu$12$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.$songProvider;
        MutableState mutableState = this.$isChecked$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SongEntity songEntity = (SongEntity) function0.invoke();
                mutableState.setValue(Boolean.valueOf(songEntity != null ? songEntity.romanizeLyrics : true));
                break;
            default:
                ResultKt.throwOnFailure(obj);
                if (((WizardState) mutableState.getValue()).isComplete) {
                    function0.invoke();
                }
                break;
        }
        return unit;
    }
}
