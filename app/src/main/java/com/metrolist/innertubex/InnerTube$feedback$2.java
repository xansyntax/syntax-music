package com.metrolist.innertubex;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.gestures.DragGestureNode;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.TrackpadScrollingLogicImpl;
import androidx.compose.material3.SliderState$dragScope$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharingCommand;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$feedback$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $client;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $tokens;
    public /* synthetic */ Object L$0;
    public boolean label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$feedback$2(PodcastEntity podcastEntity, OnlinePodcastViewModel onlinePodcastViewModel, PodcastItem podcastItem, String str, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 18;
        this.L$0 = podcastEntity;
        this.this$0 = onlinePodcastViewModel;
        this.$client = podcastItem;
        this.$tokens = str;
        this.label = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$tokens;
        Object obj3 = this.$client;
        switch (b) {
            case 0:
                InnerTube$feedback$2 innerTube$feedback$2 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 0);
                innerTube$feedback$2.L$0 = obj;
                return innerTube$feedback$2;
            case 1:
                InnerTube$feedback$2 innerTube$feedback$3 = new InnerTube$feedback$2((Ref$ObjectRef) obj3, (DragGestureNode) obj2, continuation, (byte) 1);
                innerTube$feedback$3.L$0 = obj;
                return innerTube$feedback$3;
            case 2:
                InnerTube$feedback$2 innerTube$feedback$4 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 2);
                innerTube$feedback$4.L$0 = obj;
                return innerTube$feedback$4;
            case 3:
                InnerTube$feedback$2 innerTube$feedback$5 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 3);
                innerTube$feedback$5.L$0 = obj;
                return innerTube$feedback$5;
            case 4:
                InnerTube$feedback$2 innerTube$feedback$6 = new InnerTube$feedback$2((TrackpadScrollingLogicImpl) obj3, (Ref$ObjectRef) obj2, continuation, (byte) 4);
                innerTube$feedback$6.L$0 = obj;
                return innerTube$feedback$6;
            case 5:
                InnerTube$feedback$2 innerTube$feedback$7 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 5);
                innerTube$feedback$7.L$0 = obj;
                return innerTube$feedback$7;
            case 6:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 6);
            case 7:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 7);
            case 8:
                InnerTube$feedback$2 innerTube$feedback$8 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 8);
                innerTube$feedback$8.L$0 = obj;
                return innerTube$feedback$8;
            case 9:
                InnerTube$feedback$2 innerTube$feedback$9 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 9);
                innerTube$feedback$9.L$0 = obj;
                return innerTube$feedback$9;
            case 10:
                InnerTube$feedback$2 innerTube$feedback$10 = new InnerTube$feedback$2((String) obj3, (String) obj2, continuation, (byte) 10);
                innerTube$feedback$10.L$0 = obj;
                return innerTube$feedback$10;
            case 11:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 12);
            case 13:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 13);
            case 14:
                InnerTube$feedback$2 innerTube$feedback$11 = new InnerTube$feedback$2((Song) this.this$0, (String) obj3, this.label, (List) obj2, continuation);
                innerTube$feedback$11.L$0 = obj;
                return innerTube$feedback$11;
            case 15:
                return new InnerTube$feedback$2(this.label, (CoroutineScope) this.L$0, (ManagedActivityResultLauncher) this.this$0, (MutableState) obj3, (Context) obj2, continuation);
            case 16:
                InnerTube$feedback$2 innerTube$feedback$12 = new InnerTube$feedback$2(this.this$0, obj3, obj2, continuation, (byte) 16);
                innerTube$feedback$12.L$0 = obj;
                return innerTube$feedback$12;
            case 17:
                InnerTube$feedback$2 innerTube$feedback$13 = new InnerTube$feedback$2((List) obj2, (List) obj3, continuation);
                innerTube$feedback$13.L$0 = obj;
                return innerTube$feedback$13;
            case 18:
                return new InnerTube$feedback$2((PodcastEntity) this.L$0, (OnlinePodcastViewModel) this.this$0, (PodcastItem) obj3, (String) obj2, this.label, continuation);
            case 19:
                return new InnerTube$feedback$2(this.L$0, this.this$0, obj3, obj2, continuation, (byte) 19);
            case 20:
                InnerTube$feedback$2 innerTube$feedback$14 = new InnerTube$feedback$2((Ref$ObjectRef) obj3, (FlowCollector) obj2, continuation, (byte) 20);
                innerTube$feedback$14.L$0 = ((ChannelResult) obj).holder;
                return innerTube$feedback$14;
            default:
                InnerTube$feedback$2 innerTube$feedback$15 = new InnerTube$feedback$2(this.this$0, obj3, this.$tokens, continuation, (byte) 21);
                innerTube$feedback$15.L$0 = obj;
                return innerTube$feedback$15;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((InnerTube$feedback$2) create((InnerTube.SessionSnapshot) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((InnerTube$feedback$2) create((Function1) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((InnerTube$feedback$2) create((SliderState$dragScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((InnerTube$feedback$2) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 5:
                ((InnerTube$feedback$2) create((AndroidPlatformTextInputSession) obj, (Continuation) obj2)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 6:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 7:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 8:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 9:
                return ((InnerTube$feedback$2) create((InnerTube.SessionSnapshot) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 10:
                return ((InnerTube$feedback$2) create((QuickJs) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 11:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 13:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 14:
                ((InnerTube$feedback$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 15:
                ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 16:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 17:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 18:
                ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 19:
                return ((InnerTube$feedback$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 20:
                Object obj3 = ((ChannelResult) obj).holder;
                InnerTube$feedback$2 innerTube$feedback$2 = new InnerTube$feedback$2((Ref$ObjectRef) this.$client, (FlowCollector) this.$tokens, (Continuation) obj2, (byte) 20);
                innerTube$feedback$2.L$0 = obj3;
                return innerTube$feedback$2.invokeSuspend(unit);
            default:
                return ((InnerTube$feedback$2) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:269:0x06be  */
    /* JADX WARN: Code duplicated, block: B:271:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:272:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:275:0x0714  */
    /* JADX WARN: Code duplicated, block: B:313:0x080d  */
    /* JADX WARN: Code duplicated, block: B:412:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0202 -> B:102:0x0206). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:272:0x06d5 -> B:273:0x06d7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:326:0x0835 -> B:327:0x0837). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:328:0x083b -> B:329:0x083e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.InnerTube$feedback$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$feedback$2(Song song, String str, boolean z, List list, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 14;
        this.this$0 = song;
        this.$client = str;
        this.label = z;
        this.$tokens = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$feedback$2(Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$0 = obj;
        this.this$0 = obj2;
        this.$client = obj3;
        this.$tokens = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$feedback$2(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$client = obj2;
        this.$tokens = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$feedback$2(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$client = obj;
        this.$tokens = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$feedback$2(List list, List list2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 17;
        this.$tokens = list;
        this.$client = list2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$feedback$2(boolean z, CoroutineScope coroutineScope, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, Context context, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 15;
        this.label = z;
        this.L$0 = coroutineScope;
        this.this$0 = managedActivityResultLauncher;
        this.$client = mutableState;
        this.$tokens = context;
    }
}
