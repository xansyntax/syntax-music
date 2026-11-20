package sh.calvin.reorderable;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.LazyListState;
import com.metrolist.innertubex.cipher.EjsChallengeSolver;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Scroller {
    public final ScrollerKt$rememberScroller$3$1 pixelPerSecondProvider;
    public StandaloneCoroutine programmaticScrollJob;
    public final CoroutineScope scope;
    public final BufferedChannel scrollInfoChannel = EntryPoints.Channel$default(-1, 6, null);
    public final LazyListState scrollableState;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Direction {
        public static final /* synthetic */ Direction[] $VALUES;
        public static final Direction BACKWARD;
        public static final Direction FORWARD;

        static {
            Direction direction = new Direction("BACKWARD", 0);
            BACKWARD = direction;
            Direction direction2 = new Direction("FORWARD", 1);
            FORWARD = direction2;
            $VALUES = new Direction[]{direction, direction2};
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ScrollInfo {
        public static final ScrollInfo Null = new ScrollInfo(Direction.FORWARD, CropImageView.DEFAULT_ASPECT_RATIO, Scroller$ScrollInfo$Companion$Null$1.INSTANCE, new EjsChallengeSolver.AnonymousClass2(1, null, 2));
        public final Direction direction;
        public final Function0 maxScrollDistanceProvider;
        public final Function1 onScroll;
        public final float speedMultiplier;

        public ScrollInfo(Direction direction, float f, Function0 function0, Function1 function1) {
            this.direction = direction;
            this.speedMultiplier = f;
            this.maxScrollDistanceProvider = function0;
            this.onScroll = function1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScrollInfo)) {
                return false;
            }
            ScrollInfo scrollInfo = (ScrollInfo) obj;
            return this.direction == scrollInfo.direction && Float.compare(this.speedMultiplier, scrollInfo.speedMultiplier) == 0 && this.maxScrollDistanceProvider.equals(scrollInfo.maxScrollDistanceProvider) && this.onScroll.equals(scrollInfo.onScroll);
        }

        public final int hashCode() {
            return this.onScroll.hashCode() + ((this.maxScrollDistanceProvider.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.speedMultiplier, this.direction.hashCode() * 31, 31)) * 31);
        }

        public final String toString() {
            return "ScrollInfo(direction=" + this.direction + ", speedMultiplier=" + this.speedMultiplier + ", maxScrollDistanceProvider=" + this.maxScrollDistanceProvider + ", onScroll=" + this.onScroll + ')';
        }
    }

    /* JADX INFO: renamed from: sh.calvin.reorderable.Scroller$scrollLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public Scroller L$0;
        public ScrollInfo L$1;
        public Direction L$2;
        public Function0 L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Scroller.this.scrollLoop(this);
        }
    }

    public Scroller(LazyListState lazyListState, CoroutineScope coroutineScope, ScrollerKt$rememberScroller$3$1 scrollerKt$rememberScroller$3$1) {
        this.scrollableState = lazyListState;
        this.scope = coroutineScope;
        this.pixelPerSecondProvider = scrollerKt$rememberScroller$3$1;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:35:0x00af  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00db  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object scrollLoop(kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sh.calvin.reorderable.Scroller.scrollLoop(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean start$reorderable_release(Direction direction, float f, Function0 function0, Function1 function1) {
        boolean canScrollBackward;
        int iOrdinal = direction.ordinal();
        LazyListState lazyListState = this.scrollableState;
        if (iOrdinal == 0) {
            canScrollBackward = lazyListState.getCanScrollBackward();
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return false;
            }
            canScrollBackward = lazyListState.getCanScrollForward();
        }
        if (!canScrollBackward) {
            return false;
        }
        if (this.programmaticScrollJob == null) {
            this.programmaticScrollJob = AwaitKt.launch$default(this.scope, null, null, new Scroller$start$3(this, null, (byte) 0), 3);
        }
        this.scrollInfoChannel.mo1712trySendJP2dKIU(new ScrollInfo(direction, f, function0, function1));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r8 == r6) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stop$reorderable_release(ContinuationImpl continuationImpl) {
        Scroller$stop$1 scroller$stop$1;
        if (continuationImpl instanceof Scroller$stop$1) {
            scroller$stop$1 = (Scroller$stop$1) continuationImpl;
            int i = scroller$stop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scroller$stop$1.label = i - Integer.MIN_VALUE;
            } else {
                scroller$stop$1 = new Scroller$stop$1(this, continuationImpl);
            }
        } else {
            scroller$stop$1 = new Scroller$stop$1(this, continuationImpl);
        }
        Object obj = scroller$stop$1.result;
        int i2 = scroller$stop$1.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollInfo scrollInfo = ScrollInfo.Null;
            scroller$stop$1.L$0 = this;
            scroller$stop$1.label = 1;
            if (this.scrollInfoChannel.send(scrollInfo, scroller$stop$1) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            this = scroller$stop$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            this = scroller$stop$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.programmaticScrollJob = null;
        return unit;
        StandaloneCoroutine standaloneCoroutine = this.programmaticScrollJob;
        if (standaloneCoroutine != null) {
            scroller$stop$1.L$0 = this;
            scroller$stop$1.label = 2;
            standaloneCoroutine.cancel(null);
            Object objJoin = standaloneCoroutine.join(scroller$stop$1);
            if (objJoin != coroutineSingletons) {
                objJoin = unit;
            }
        }
        this.programmaticScrollJob = null;
        return unit;
    }
}
