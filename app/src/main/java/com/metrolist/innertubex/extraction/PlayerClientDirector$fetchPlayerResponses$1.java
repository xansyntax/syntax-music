package com.metrolist.innertubex.extraction;

import androidx.navigation.NavDeepLinkRequest;
import com.metrolist.innertubex.extraction.strategy.ClientHealthScope;
import com.metrolist.innertubex.extraction.strategy.SelectedClient;
import com.metrolist.innertubex.models.YouTubeClient;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerClientDirector$fetchPlayerResponses$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public int I$2;
    public int I$3;
    public int I$5;
    public long J$0;
    public String L$0;
    public PlayerConfig L$1;
    public Ref$ObjectRef L$10;
    public ClientHealthScope L$11;
    public List L$14;
    public List L$16;
    public List L$17;
    public List L$18;
    public NavDeepLinkRequest L$19;
    public ContentHints L$2;
    public Set L$20;
    public Iterator L$21;
    public SelectedClient L$23;
    public YouTubeClient L$24;
    public Set L$3;
    public Deferred L$5;
    public String L$9;
    public boolean Z$0;
    public boolean Z$1;
    public boolean Z$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PlayerClientDirector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerClientDirector$fetchPlayerResponses$1(PlayerClientDirector playerClientDirector, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = playerClientDirector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchPlayerResponses$com_github_MetrolistGroup_innertubex(null, null, null, null, false, false, false, null, null, this);
    }
}
