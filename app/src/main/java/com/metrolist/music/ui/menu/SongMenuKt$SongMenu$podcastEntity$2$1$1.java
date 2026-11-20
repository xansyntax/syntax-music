package com.metrolist.music.ui.menu;

import androidx.compose.runtime.ProduceStateScopeImpl;
import com.metrolist.music.db.entities.PodcastEntity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$podcastEntity$2$1$1 implements FlowCollector {
    public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SongMenuKt$SongMenu$podcastEntity$2$1$1(ProduceStateScopeImpl produceStateScopeImpl, byte b) {
        this.$r8$classId = b;
        this.$$this$produceState = produceStateScopeImpl;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ProduceStateScopeImpl produceStateScopeImpl = this.$$this$produceState;
        switch (b) {
            case 0:
                produceStateScopeImpl.setValue((PodcastEntity) obj);
                break;
            case 1:
                produceStateScopeImpl.setValue(obj);
                break;
            case 2:
                produceStateScopeImpl.setValue(obj);
                break;
            default:
                produceStateScopeImpl.setValue(obj);
                break;
        }
        return unit;
    }
}
