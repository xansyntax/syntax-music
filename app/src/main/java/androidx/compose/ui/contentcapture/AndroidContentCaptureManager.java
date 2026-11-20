package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.room.RoomDatabase$closeBarrier$1;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator;
import kotlinx.coroutines.channels.ChannelIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidContentCaptureManager implements DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public boolean checkingForSemanticsChanges;
    public final ActivityCompat$$ExternalSyntheticLambda0 contentCaptureChangeChecker;
    public ContentCaptureSessionWrapper contentCaptureSession;
    public MutableIntObjectMap currentSemanticsNodes;
    public long currentSemanticsNodesSnapshotTimestampMillis;
    public final RoomDatabase$closeBarrier$1 onContentCaptureSession;
    public final MutableIntObjectMap previousSemanticsNodes;
    public SemanticsNodeCopy previousSemanticsRoot;
    public final AndroidComposeView view;
    public final ArrayList bufferedEvents = new ArrayList();
    public TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    public boolean currentSemanticsNodesInvalidated = true;
    public final BufferedChannel boundsUpdateChannel = EntryPoints.Channel$default(1, 6, null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TranslateStatus {
        public static final /* synthetic */ TranslateStatus[] $VALUES;
        public static final TranslateStatus SHOW_ORIGINAL;
        public static final TranslateStatus SHOW_TRANSLATED;

        static {
            TranslateStatus translateStatus = new TranslateStatus("SHOW_ORIGINAL", 0);
            SHOW_ORIGINAL = translateStatus;
            TranslateStatus translateStatus2 = new TranslateStatus("SHOW_TRANSLATED", 1);
            SHOW_TRANSLATED = translateStatus2;
            $VALUES = new TranslateStatus[]{translateStatus, translateStatus2};
        }

        public static TranslateStatus valueOf(String str) {
            return (TranslateStatus) Enum.valueOf(TranslateStatus.class, str);
        }

        public static TranslateStatus[] values() {
            return (TranslateStatus[]) $VALUES.clone();
        }
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1) {
        this.view = androidComposeView;
        this.onContentCaptureSession = roomDatabase$closeBarrier$1;
        new Handler(Looper.getMainLooper());
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        this.currentSemanticsNodes = mutableIntObjectMap;
        this.previousSemanticsNodes = new MutableIntObjectMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), mutableIntObjectMap);
        this.contentCaptureChangeChecker = new ActivityCompat$$ExternalSyntheticLambda0((byte) 5, (Object) this);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[PHI: r1 r8
      0x0052: PHI (r1v2 kotlinx.coroutines.channels.ChannelIterator) = (r1v13 kotlinx.coroutines.channels.ChannelIterator), (r1v14 kotlinx.coroutines.channels.ChannelIterator) binds: [B:19:0x004f, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r8v3 java.lang.Object) = (r8v11 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x004f, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:33:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(100, r0) == r4) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:13:0x002b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui(ContinuationImpl continuationImpl) throws Throwable {
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 androidContentCaptureManager$boundsUpdatesEventLoop$1;
        ChannelIterator channelIterator;
        Handler handler;
        ChannelIterator bufferedChannelIterator;
        ChannelIterator channelIterator2;
        if (continuationImpl instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1) {
            androidContentCaptureManager$boundsUpdatesEventLoop$1 = (AndroidContentCaptureManager$boundsUpdatesEventLoop$1) continuationImpl;
            int i = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = i - Integer.MIN_VALUE;
            } else {
                androidContentCaptureManager$boundsUpdatesEventLoop$1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, continuationImpl);
            }
        } else {
            androidContentCaptureManager$boundsUpdatesEventLoop$1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, continuationImpl);
        }
        Object objHasNext = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
        int i2 = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objHasNext);
            bufferedChannelIterator = this.boundsUpdateChannel.new BufferedChannelIterator();
            androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = bufferedChannelIterator;
            androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator;
            objHasNext = bufferedChannelIterator2.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
            channelIterator = bufferedChannelIterator2;
            if (objHasNext != coroutineSingletons) {
                if (!((Boolean) objHasNext).booleanValue()) {
                    return Unit.INSTANCE;
                }
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) channelIterator;
                bufferedChannelIterator3.next();
                if (isEnabled$ui()) {
                    notifyContentCaptureChanges();
                }
                handler = this.view.getHandler();
                if (!this.checkingForSemanticsChanges) {
                    this.checkingForSemanticsChanges = true;
                    handler.post(this.contentCaptureChangeChecker);
                }
                androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = bufferedChannelIterator3;
                androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
                channelIterator2 = bufferedChannelIterator3;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ChannelIterator channelIterator3 = androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
            ResultKt.throwOnFailure(objHasNext);
            channelIterator = channelIterator3;
            if (!((Boolean) objHasNext).booleanValue()) {
                return Unit.INSTANCE;
            }
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator4 = (BufferedChannel.BufferedChannelIterator) channelIterator;
            bufferedChannelIterator4.next();
            if (isEnabled$ui()) {
                notifyContentCaptureChanges();
            }
            handler = this.view.getHandler();
            if (!this.checkingForSemanticsChanges && handler != null) {
                this.checkingForSemanticsChanges = true;
                handler.post(this.contentCaptureChangeChecker);
            }
            androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = bufferedChannelIterator4;
            androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
            channelIterator2 = bufferedChannelIterator4;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ChannelIterator channelIterator4 = androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
            ResultKt.throwOnFailure(objHasNext);
            channelIterator2 = channelIterator4;
        }
        bufferedChannelIterator = channelIterator2;
        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = bufferedChannelIterator;
        androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
        BufferedChannel.BufferedChannelIterator bufferedChannelIterator5 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator;
        objHasNext = bufferedChannelIterator5.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
        channelIterator = bufferedChannelIterator5;
        if (objHasNext != coroutineSingletons) {
            if (!((Boolean) objHasNext).booleanValue()) {
                return Unit.INSTANCE;
            }
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator6 = (BufferedChannel.BufferedChannelIterator) channelIterator;
            bufferedChannelIterator6.next();
            if (isEnabled$ui()) {
                notifyContentCaptureChanges();
            }
            handler = this.view.getHandler();
            if (!this.checkingForSemanticsChanges) {
                this.checkingForSemanticsChanges = true;
                handler.post(this.contentCaptureChangeChecker);
            }
            androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = bufferedChannelIterator6;
            androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
            channelIterator2 = bufferedChannelIterator6;
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0173 A[EDGE_INSN: B:105:0x0173->B:80:0x0173 BREAK  A[LOOP:4: B:48:0x00e9->B:79:0x016c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb A[LOOP:2: B:21:0x006f->B:42:0x00cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x016a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x016c A[LOOP:4: B:48:0x00e9->B:79:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x00d4 A[EDGE_INSN: B:99:0x00d4->B:44:0x00d4 BREAK  A[LOOP:2: B:21:0x006f->B:42:0x00cb], SYNTHETIC] */
    public final void checkForContentCapturePropertyChanges(IntObjectMap intObjectMap) {
        int[] iArr;
        int[] iArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        IntObjectMap intObjectMap2 = intObjectMap;
        int[] iArr3 = intObjectMap2.keys;
        long[] jArr = intObjectMap2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j5 = jArr[i3];
            char c2 = 7;
            long j6 = -9187201950435737472L;
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j5 & 255) < 128) {
                        int i7 = iArr3[(i3 << 3) + i6];
                        c = c2;
                        SemanticsNodeCopy semanticsNodeCopy = (SemanticsNodeCopy) this.previousSemanticsNodes.get(i7);
                        AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) intObjectMap2.get(i7);
                        SemanticsNode semanticsNode = adjustedSemanticsNode != null ? adjustedSemanticsNode.semanticsNode : null;
                        if (semanticsNode == null) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m$2("no value for specified key");
                        }
                        j2 = j6;
                        int i8 = semanticsNode.id;
                        MutableScatterMap mutableScatterMap = semanticsNode.unmergedConfig.props;
                        if (semanticsNodeCopy == null) {
                            Object[] objArr = mutableScatterMap.keys;
                            long[] jArr2 = mutableScatterMap.metadata;
                            int length2 = jArr2.length - 2;
                            iArr2 = iArr3;
                            if (length2 >= 0) {
                                int i9 = i4;
                                int i10 = 0;
                                while (true) {
                                    long j7 = jArr2[i10];
                                    j = j5;
                                    if ((((~j7) << c) & j7 & j2) != j2) {
                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                        for (int i12 = 0; i12 < i11; i12++) {
                                            if ((j7 & 255) < 128) {
                                                j4 = j7;
                                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) objArr[(i10 << 3) + i12];
                                                SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.Text;
                                                if (Intrinsics.areEqual(semanticsPropertyKey, semanticsPropertyKey2)) {
                                                    Object obj = mutableScatterMap.get(semanticsPropertyKey2);
                                                    if (obj == null) {
                                                        obj = null;
                                                    }
                                                    List list = (List) obj;
                                                    sendContentCaptureTextUpdateEvent(i8, String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                                }
                                            } else {
                                                j4 = j7;
                                            }
                                            j7 = j4 >> i9;
                                        }
                                        if (i11 != i9) {
                                            break;
                                        }
                                        if (i10 != length2) {
                                            break;
                                        }
                                        i10++;
                                        j5 = j;
                                        i9 = 8;
                                    } else if (i10 != length2) {
                                        break;
                                        break;
                                    } else {
                                        i10++;
                                        j5 = j;
                                        i9 = 8;
                                    }
                                }
                            } else {
                                j = j5;
                            }
                        } else {
                            iArr2 = iArr3;
                            j = j5;
                            Object[] objArr2 = mutableScatterMap.keys;
                            long[] jArr3 = mutableScatterMap.metadata;
                            int length3 = jArr3.length - 2;
                            if (length3 >= 0) {
                                long[] jArr4 = jArr3;
                                int i13 = 0;
                                while (true) {
                                    long j8 = jArr4[i13];
                                    long[] jArr5 = jArr4;
                                    i = i6;
                                    if ((((~j8) << c) & j8 & j2) != j2) {
                                        int i14 = 8 - ((~(i13 - length3)) >>> 31);
                                        int i15 = 0;
                                        while (i15 < i14) {
                                            if ((j8 & 255) < 128) {
                                                j3 = j8;
                                                SemanticsPropertyKey semanticsPropertyKey3 = (SemanticsPropertyKey) objArr2[(i13 << 3) + i15];
                                                SemanticsPropertyKey semanticsPropertyKey4 = SemanticsProperties.Text;
                                                if (Intrinsics.areEqual(semanticsPropertyKey3, semanticsPropertyKey4)) {
                                                    Object obj2 = semanticsNodeCopy.unmergedConfig.props.get(semanticsPropertyKey4);
                                                    if (obj2 == null) {
                                                        obj2 = null;
                                                    }
                                                    List list2 = (List) obj2;
                                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                                    Object obj3 = mutableScatterMap.get(semanticsPropertyKey4);
                                                    if (obj3 == null) {
                                                        obj3 = null;
                                                    }
                                                    List list3 = (List) obj3;
                                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                                        sendContentCaptureTextUpdateEvent(i8, String.valueOf(annotatedString2));
                                                    }
                                                }
                                            } else {
                                                j3 = j8;
                                            }
                                            i15++;
                                            j8 = j3 >> 8;
                                        }
                                        if (i14 != 8) {
                                            break;
                                        }
                                        if (i13 != length3) {
                                            break;
                                        }
                                        i13++;
                                        i6 = i;
                                        jArr4 = jArr5;
                                    } else if (i13 != length3) {
                                        break;
                                        break;
                                    } else {
                                        i13++;
                                        i6 = i;
                                        jArr4 = jArr5;
                                    }
                                }
                            }
                            i2 = 8;
                        }
                        i = i6;
                        i2 = 8;
                    } else {
                        iArr2 = iArr3;
                        j = j5;
                        c = c2;
                        j2 = j6;
                        i = i6;
                        i2 = i4;
                    }
                    j5 = j >> i2;
                    i6 = i + 1;
                    i4 = i2;
                    c2 = c;
                    j6 = j2;
                    iArr3 = iArr2;
                    intObjectMap2 = intObjectMap;
                }
                iArr = iArr3;
                if (i5 != i4) {
                    return;
                }
            } else {
                iArr = iArr3;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            intObjectMap2 = intObjectMap;
            iArr3 = iArr;
        }
    }

    public final IntObjectMap getCurrentSemanticsNodes$ui() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsNodeKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 2));
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    public final boolean isEnabled$ui() {
        return this.contentCaptureSession != null;
    }

    public final void notifyContentCaptureChanges() {
        ContentCaptureSessionWrapper contentCaptureSessionWrapper = this.contentCaptureSession;
        if (contentCaptureSessionWrapper != null && Build.VERSION.SDK_INT >= 29) {
            ArrayList arrayList = this.bufferedEvents;
            if (arrayList.isEmpty()) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) arrayList.get(i);
                int iOrdinal = contentCaptureEvent.type.ordinal();
                if (iOrdinal == 0) {
                    DrawResult drawResult = contentCaptureEvent.structureCompat;
                    if (drawResult != null) {
                        ((ContentCaptureSessionCompat) contentCaptureSessionWrapper).notifyViewAppeared((ViewStructure) drawResult.block);
                    }
                } else {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return;
                    }
                    ContentCaptureSessionCompat contentCaptureSessionCompat = (ContentCaptureSessionCompat) contentCaptureSessionWrapper;
                    AutofillId autofillIdNewAutofillId = contentCaptureSessionCompat.newAutofillId(contentCaptureEvent.id);
                    if (autofillIdNewAutofillId != null) {
                        contentCaptureSessionCompat.notifyViewDisappeared(autofillIdNewAutofillId);
                    }
                }
            }
            ((ContentCaptureSessionCompat) contentCaptureSessionWrapper).flush();
            arrayList.clear();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        this.contentCaptureSession = (ContentCaptureSessionWrapper) this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(-1, this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        Handler handler = this.view.getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.contentCaptureChangeChecker);
        }
        this.contentCaptureSession = null;
    }

    public final void sendContentCaptureAppearEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1 = new ButtonKt$$ExternalSyntheticLambda1(semanticsNodeCopy, this, (byte) 27);
        semanticsNode.getClass();
        List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
        int size = children$ui.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = children$ui.get(i2);
            if (getCurrentSemanticsNodes$ui().containsKey(((SemanticsNode) obj).id)) {
                buttonKt$$ExternalSyntheticLambda1.invoke(Integer.valueOf(i), obj);
                i++;
            }
        }
        List children$ui2 = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
        int size2 = children$ui2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) children$ui2.get(i3);
            IntObjectMap currentSemanticsNodes$ui = getCurrentSemanticsNodes$ui();
            int i4 = semanticsNode2.id;
            if (currentSemanticsNodes$ui.containsKey(i4)) {
                MutableIntObjectMap mutableIntObjectMap = this.previousSemanticsNodes;
                if (mutableIntObjectMap.containsKey(i4)) {
                    Object obj2 = mutableIntObjectMap.get(i4);
                    if (obj2 == null) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m$2("node not present in pruned tree before this change");
                    }
                    sendContentCaptureAppearEvents(semanticsNode2, (SemanticsNodeCopy) obj2);
                } else {
                    continue;
                }
            }
        }
    }

    public final void sendContentCaptureTextUpdateEvent(int i, String str) {
        ContentCaptureSessionWrapper contentCaptureSessionWrapper;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionWrapper = this.contentCaptureSession) != null) {
            ContentCaptureSessionCompat contentCaptureSessionCompat = (ContentCaptureSessionCompat) contentCaptureSessionWrapper;
            AutofillId autofillIdNewAutofillId = contentCaptureSessionCompat.newAutofillId(i);
            if (autofillIdNewAutofillId == null) {
                throw Fragment$5$$ExternalSyntheticOutline0.m$2("Invalid content capture ID");
            }
            contentCaptureSessionCompat.notifyViewTextChanged(autofillIdNewAutofillId, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0181  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x009a A[PHI: r5
      0x009a: PHI (r5v6 android.view.autofill.AutofillId) = (r5v5 android.view.autofill.AutofillId), (r5v19 android.view.autofill.AutofillId) binds: [B:39:0x008b, B:41:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:72:0x0111  */
    /* JADX WARN: Code duplicated, block: B:75:0x0116  */
    /* JADX WARN: Code duplicated, block: B:78:0x0126  */
    /* JADX WARN: Code duplicated, block: B:81:0x012b  */
    /* JADX WARN: Code duplicated, block: B:84:0x013a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0150  */
    /* JADX WARN: Code duplicated, block: B:95:0x0171  */
    /* JADX WARN: Code duplicated, block: B:97:0x0179  */
    /* JADX WARN: Code duplicated, block: B:99:0x017c  */
    public final void updateBuffersOnAppeared(int i, SemanticsNode semanticsNode) {
        Function1 function1;
        DrawResult drawResultNewVirtualViewStructure;
        ViewStructure viewStructure;
        SemanticsConfiguration semanticsConfiguration;
        SemanticsPropertyKey semanticsPropertyKey;
        MutableScatterMap mutableScatterMap;
        Bundle extras;
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        List list;
        Object obj4;
        AnnotatedString annotatedString;
        Object obj5;
        List list2;
        Object obj6;
        Role role;
        TextLayoutResult textLayoutResult;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui;
        Rect rectBoundsInImportantForBoundsAncestor;
        DrawResult drawResult;
        NodeCoordinator nodeCoordinator;
        String strM713toLegacyClassNameV4PA4sw;
        Function1 function2;
        if (isEnabled$ui()) {
            MutableScatterMap mutableScatterMap2 = semanticsNode.unmergedConfig.props;
            Object obj7 = mutableScatterMap2.get(SemanticsProperties.IsShowingTextSubstitution);
            if (obj7 == null) {
                obj7 = null;
            }
            Boolean bool = (Boolean) obj7;
            if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual(bool, Boolean.TRUE)) {
                Object obj8 = mutableScatterMap2.get(SemanticsActions.ShowTextSubstitution);
                if (obj8 == null) {
                    obj8 = null;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj8;
                if (accessibilityAction != null && (function2 = (Function1) accessibilityAction.action) != null) {
                }
            } else if (this.translateStatus == TranslateStatus.SHOW_TRANSLATED && Intrinsics.areEqual(bool, Boolean.FALSE)) {
                Object obj9 = mutableScatterMap2.get(SemanticsActions.ShowTextSubstitution);
                if (obj9 == null) {
                    obj9 = null;
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj9;
                if (accessibilityAction2 != null && (function1 = (Function1) accessibilityAction2.action) != null) {
                }
            }
            int i2 = semanticsNode.id;
            ContentCaptureSessionWrapper contentCaptureSessionWrapper = this.contentCaptureSession;
            if (contentCaptureSessionWrapper != null && Build.VERSION.SDK_INT >= 29) {
                AutofillId autofillId = this.view.getAutofillId();
                SemanticsNode parent = semanticsNode.getParent();
                int i3 = semanticsNode.id;
                if (parent != null) {
                    autofillId = ((ContentCaptureSessionCompat) contentCaptureSessionWrapper).newAutofillId(parent.id);
                    if (autofillId == null) {
                        drawResult = null;
                    } else {
                        drawResultNewVirtualViewStructure = ((ContentCaptureSessionCompat) contentCaptureSessionWrapper).newVirtualViewStructure(autofillId, i3);
                        if (drawResultNewVirtualViewStructure == null) {
                            drawResult = null;
                        } else {
                            viewStructure = (ViewStructure) drawResultNewVirtualViewStructure.block;
                            semanticsConfiguration = semanticsNode.unmergedConfig;
                            semanticsPropertyKey = SemanticsProperties.Password;
                            mutableScatterMap = semanticsConfiguration.props;
                            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                drawResult = null;
                            } else {
                                extras = viewStructure.getExtras();
                                if (extras != null) {
                                    extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
                                    extras.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", i);
                                }
                                obj = mutableScatterMap.get(SemanticsProperties.TestTag);
                                if (obj == null) {
                                    obj = null;
                                }
                                str = (String) obj;
                                if (str != null) {
                                    viewStructure.setId(i3, null, null, str);
                                }
                                obj2 = mutableScatterMap.get(SemanticsProperties.IsTraversalGroup);
                                if (obj2 == null) {
                                    obj2 = null;
                                }
                                if (((Boolean) obj2) != null) {
                                    viewStructure.setClassName("android.widget.ViewGroup");
                                }
                                obj3 = mutableScatterMap.get(SemanticsProperties.Text);
                                if (obj3 == null) {
                                    obj3 = null;
                                }
                                list = (List) obj3;
                                if (list != null) {
                                    viewStructure.setClassName("android.widget.TextView");
                                    viewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, 62));
                                }
                                obj4 = mutableScatterMap.get(SemanticsProperties.EditableText);
                                if (obj4 == null) {
                                    obj4 = null;
                                }
                                annotatedString = (AnnotatedString) obj4;
                                if (annotatedString != null) {
                                    viewStructure.setClassName("android.widget.EditText");
                                    viewStructure.setText(annotatedString);
                                }
                                obj5 = mutableScatterMap.get(SemanticsProperties.ContentDescription);
                                if (obj5 == null) {
                                    obj5 = null;
                                }
                                list2 = (List) obj5;
                                if (list2 != null) {
                                    viewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, 62));
                                }
                                obj6 = mutableScatterMap.get(SemanticsProperties.Role);
                                if (obj6 == null) {
                                    obj6 = null;
                                }
                                role = (Role) obj6;
                                if (role != null && (strM713toLegacyClassNameV4PA4sw = InvertMatrixKt.m713toLegacyClassNameV4PA4sw(role.value)) != null) {
                                    viewStructure.setClassName(strM713toLegacyClassNameV4PA4sw);
                                }
                                textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration);
                                if (textLayoutResult != null) {
                                    TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
                                    TextStyle textStyle = textLayoutInput.style;
                                    Density density = textLayoutInput.density;
                                    viewStructure.setTextStyle(density.getFontScale() * density.getDensity() * TextUnit.m814getValueimpl(textStyle.spanStyle.fontSize), 0, 0, 0);
                                }
                                nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
                                if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                                    rectBoundsInImportantForBoundsAncestor = Rect.Zero;
                                } else {
                                    nodeCoordinator = nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached ? nodeCoordinatorFindCoordinatorToGetBounds$ui : null;
                                    if (nodeCoordinator != null) {
                                        rectBoundsInImportantForBoundsAncestor = semanticsNode.boundsInImportantForBoundsAncestor(nodeCoordinator);
                                    } else {
                                        rectBoundsInImportantForBoundsAncestor = Rect.Zero;
                                    }
                                }
                                float f = rectBoundsInImportantForBoundsAncestor.left;
                                float f2 = rectBoundsInImportantForBoundsAncestor.top;
                                viewStructure.setDimens((int) f, (int) f2, 0, 0, (int) (rectBoundsInImportantForBoundsAncestor.right - f), (int) (rectBoundsInImportantForBoundsAncestor.bottom - f2));
                                drawResult = drawResultNewVirtualViewStructure;
                            }
                        }
                    }
                } else {
                    drawResultNewVirtualViewStructure = ((ContentCaptureSessionCompat) contentCaptureSessionWrapper).newVirtualViewStructure(autofillId, i3);
                    if (drawResultNewVirtualViewStructure == null) {
                        drawResult = null;
                    } else {
                        viewStructure = (ViewStructure) drawResultNewVirtualViewStructure.block;
                        semanticsConfiguration = semanticsNode.unmergedConfig;
                        semanticsPropertyKey = SemanticsProperties.Password;
                        mutableScatterMap = semanticsConfiguration.props;
                        if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                            drawResult = null;
                        } else {
                            extras = viewStructure.getExtras();
                            if (extras != null) {
                                extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
                                extras.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", i);
                            }
                            obj = mutableScatterMap.get(SemanticsProperties.TestTag);
                            if (obj == null) {
                                obj = null;
                            }
                            str = (String) obj;
                            if (str != null) {
                                viewStructure.setId(i3, null, null, str);
                            }
                            obj2 = mutableScatterMap.get(SemanticsProperties.IsTraversalGroup);
                            if (obj2 == null) {
                                obj2 = null;
                            }
                            if (((Boolean) obj2) != null) {
                                viewStructure.setClassName("android.widget.ViewGroup");
                            }
                            obj3 = mutableScatterMap.get(SemanticsProperties.Text);
                            if (obj3 == null) {
                                obj3 = null;
                            }
                            list = (List) obj3;
                            if (list != null) {
                                viewStructure.setClassName("android.widget.TextView");
                                viewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, 62));
                            }
                            obj4 = mutableScatterMap.get(SemanticsProperties.EditableText);
                            if (obj4 == null) {
                                obj4 = null;
                            }
                            annotatedString = (AnnotatedString) obj4;
                            if (annotatedString != null) {
                                viewStructure.setClassName("android.widget.EditText");
                                viewStructure.setText(annotatedString);
                            }
                            obj5 = mutableScatterMap.get(SemanticsProperties.ContentDescription);
                            if (obj5 == null) {
                                obj5 = null;
                            }
                            list2 = (List) obj5;
                            if (list2 != null) {
                                viewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, 62));
                            }
                            obj6 = mutableScatterMap.get(SemanticsProperties.Role);
                            if (obj6 == null) {
                                obj6 = null;
                            }
                            role = (Role) obj6;
                            if (role != null) {
                                viewStructure.setClassName(strM713toLegacyClassNameV4PA4sw);
                            }
                            textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration);
                            if (textLayoutResult != null) {
                                TextLayoutInput textLayoutInput2 = textLayoutResult.layoutInput;
                                TextStyle textStyle2 = textLayoutInput2.style;
                                Density density2 = textLayoutInput2.density;
                                viewStructure.setTextStyle(density2.getFontScale() * density2.getDensity() * TextUnit.m814getValueimpl(textStyle2.spanStyle.fontSize), 0, 0, 0);
                            }
                            nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                                rectBoundsInImportantForBoundsAncestor = Rect.Zero;
                            } else {
                                if (nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                                }
                                if (nodeCoordinator != null) {
                                    rectBoundsInImportantForBoundsAncestor = semanticsNode.boundsInImportantForBoundsAncestor(nodeCoordinator);
                                } else {
                                    rectBoundsInImportantForBoundsAncestor = Rect.Zero;
                                }
                            }
                            float f3 = rectBoundsInImportantForBoundsAncestor.left;
                            float f4 = rectBoundsInImportantForBoundsAncestor.top;
                            viewStructure.setDimens((int) f3, (int) f4, 0, 0, (int) (rectBoundsInImportantForBoundsAncestor.right - f3), (int) (rectBoundsInImportantForBoundsAncestor.bottom - f4));
                            drawResult = drawResultNewVirtualViewStructure;
                        }
                    }
                }
            } else {
                drawResult = null;
            }
            if (drawResult != null) {
                this.bufferedEvents.add(new ContentCaptureEvent(i2, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_APPEAR, drawResult));
            }
            List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
            int size = children$ui.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Object obj10 = children$ui.get(i5);
                if (getCurrentSemanticsNodes$ui().containsKey(((SemanticsNode) obj10).id)) {
                    updateBuffersOnAppeared(i4, (SemanticsNode) obj10);
                    i4++;
                }
            }
        }
    }

    public final void updateBuffersOnDisappeared(SemanticsNode semanticsNode) {
        if (isEnabled$ui()) {
            this.bufferedEvents.add(new ContentCaptureEvent(semanticsNode.id, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_DISAPPEAR, null));
            List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
            int size = children$ui.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnDisappeared((SemanticsNode) children$ui.get(i));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005b A[LOOP:0: B:5:0x0017->B:15:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005e A[EDGE_INSN: B:19:0x005e->B:16:0x005e BREAK  A[LOOP:0: B:5:0x0017->B:15:0x005b], SYNTHETIC] */
    public final void updateSemanticsCopy() {
        MutableIntObjectMap mutableIntObjectMap = this.previousSemanticsNodes;
        mutableIntObjectMap.clear();
        IntObjectMap currentSemanticsNodes$ui = getCurrentSemanticsNodes$ui();
        int[] iArr = currentSemanticsNodes$ui.keys;
        Object[] objArr = currentSemanticsNodes$ui.values;
        long[] jArr = currentSemanticsNodes$ui.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            mutableIntObjectMap.set(iArr[i4], new SemanticsNodeCopy(((AdjustedSemanticsNode) objArr[i4]).semanticsNode, getCurrentSemanticsNodes$ui()));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui());
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
