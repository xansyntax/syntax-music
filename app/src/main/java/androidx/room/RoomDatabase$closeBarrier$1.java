package androidx.room;

import android.os.Build;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusInvalidationManager;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.core.os.BuildCompat;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.tracing.TraceApi29Impl;
import coil3.compose.AsyncImagePainter;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuState;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.internal.ContextScope;
import okio.FileMetadata;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RoomDatabase$closeBarrier$1 extends FunctionReferenceImpl implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoomDatabase$closeBarrier$1(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
        super(i, obj, cls, str, str2, i2);
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x022d A[LOOP:4: B:122:0x01ff->B:132:0x022d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x016f A[LOOP:0: B:72:0x013d->B:82:0x016f, LOOP_END] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        Unit unit;
        NodeChain nodeChain;
        ContentCaptureSession contentCaptureSession;
        byte b = this.$r8$classId;
        byte b2 = 13;
        Continuation continuation = null;
        Unit unit2 = Unit.INSTANCE;
        switch (b) {
            case 0:
                RoomDatabase roomDatabase = (RoomDatabase) this.receiver;
                ContextScope contextScope = roomDatabase.coroutineScope;
                if (contextScope == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    throw null;
                }
                AwaitKt.cancel(contextScope, (CancellationException) null);
                roomDatabase.getInvalidationTracker();
                FileMetadata fileMetadata = roomDatabase.connectionManager;
                if (fileMetadata == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                    throw null;
                }
                ((ConnectionPool) fileMetadata.lastModifiedAtMillis).close();
                SupportSQLiteOpenHelper supportSQLiteOpenHelper = (SupportSQLiteOpenHelper) fileMetadata.lastAccessedAtMillis;
                if (supportSQLiteOpenHelper != null) {
                    supportSQLiteOpenHelper.close();
                }
                return unit2;
            case 1:
                return Boolean.valueOf(((FocusableNode) this.receiver).focusTargetNode.m418requestFocus3ESFkO8(7));
            case 2:
                return ((TextContextMenuDataProvider) this.receiver).data();
            case 3:
                FocusInvalidationManager focusInvalidationManager = (FocusInvalidationManager) this.receiver;
                MutableScatterSet mutableScatterSet = focusInvalidationManager.focusTargetNodes;
                MutableScatterSet mutableScatterSet2 = focusInvalidationManager.focusEventNodes;
                FocusOwnerImpl focusOwnerImpl = focusInvalidationManager.focusOwner;
                FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
                if (activeFocusTargetNode == null) {
                    Object[] objArr = mutableScatterSet2.elements;
                    long[] jArr = mutableScatterSet2.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            unit = unit2;
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((j & 255) < 128) {
                                        ((FocusEventModifierNode) objArr[(i << 3) + i3]).onFocusEvent(focusStateImpl);
                                    }
                                    j >>= 8;
                                }
                                if (i2 == 8) {
                                    if (i != length) {
                                        i++;
                                        unit2 = unit;
                                    }
                                }
                            } else if (i != length) {
                                i++;
                                unit2 = unit;
                            }
                        }
                    } else {
                        unit = unit2;
                    }
                } else {
                    unit = unit2;
                    if (activeFocusTargetNode.isAttached) {
                        if (mutableScatterSet.contains(activeFocusTargetNode)) {
                            activeFocusTargetNode.invalidateFocus$ui();
                        }
                        FocusStateImpl focusState$1 = activeFocusTargetNode.getFocusState$1();
                        if (!activeFocusTargetNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        Modifier.Node node = activeFocusTargetNode.node;
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                        int i4 = 0;
                        while (layoutNodeRequireLayoutNode != null) {
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 5120) != 0) {
                                while (node != null) {
                                    int i5 = node.kindSet;
                                    if ((i5 & 5120) != 0) {
                                        if ((i5 & 1024) != 0) {
                                            i4++;
                                        }
                                        if ((node instanceof FocusEventModifierNode) && mutableScatterSet2.contains(node)) {
                                            if (i4 <= 1) {
                                                ((FocusEventModifierNode) node).onFocusEvent(focusState$1);
                                            } else {
                                                ((FocusEventModifierNode) node).onFocusEvent(FocusStateImpl.ActiveParent);
                                            }
                                            mutableScatterSet2.remove(node);
                                        }
                                    }
                                    node = node.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                        }
                        Object[] objArr2 = mutableScatterSet2.elements;
                        long[] jArr2 = mutableScatterSet2.metadata;
                        int length2 = jArr2.length - 2;
                        if (length2 >= 0) {
                            int i6 = 0;
                            while (true) {
                                long j2 = jArr2[i6];
                                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                    for (int i8 = 0; i8 < i7; i8++) {
                                        if ((j2 & 255) < 128) {
                                            ((FocusEventModifierNode) objArr2[(i6 << 3) + i8]).onFocusEvent(focusStateImpl);
                                        }
                                        j2 >>= 8;
                                    }
                                    if (i7 == 8) {
                                        if (i6 != length2) {
                                            i6++;
                                        }
                                    }
                                } else if (i6 != length2) {
                                    i6++;
                                }
                            }
                        }
                    }
                }
                if (focusOwnerImpl.getActiveFocusTargetNode() == null || focusOwnerImpl.rootFocusNode.getFocusState$1() == focusStateImpl) {
                    focusOwnerImpl.clearOwnerFocus();
                }
                mutableScatterSet.clear();
                mutableScatterSet2.clear();
                focusInvalidationManager.isInvalidationScheduled = false;
                return unit;
            case 4:
                View view = (View) this.receiver;
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 30) {
                    BuildCompat.Api30Impl.setImportantForContentCapture(view);
                }
                if (i9 < 29 || (contentCaptureSession = TraceApi29Impl.getContentCaptureSession(view)) == null) {
                    return null;
                }
                return new ContentCaptureSessionCompat(contentCaptureSession, view);
            case 5:
                ((Runnable) this.receiver).run();
                return unit2;
            case 6:
                ((MusicService) this.receiver).toggleLike();
                return unit2;
            case 7:
                ((MusicService) this.receiver).startRadioSeamlessly();
                return unit2;
            case 8:
                MusicService musicService = (MusicService) this.receiver;
                AwaitKt.launch$default(musicService.scope, null, null, new AsyncImagePainter.AnonymousClass1(musicService, continuation, b2), 3);
                return unit2;
            case 9:
                MusicService musicService2 = (MusicService) this.receiver;
                AwaitKt.launch$default(musicService2.scope, null, null, new SimpleActor$offer$2(musicService2, continuation, b2), 3);
                return unit2;
            case 10:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 11:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 13:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 14:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 15:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 16:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 17:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 18:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 19:
                PlayerConnection playerConnection = (PlayerConnection) this.receiver;
                playerConnection.getClass();
                try {
                    playerConnection.service.toggleLike();
                    break;
                } catch (Exception unused) {
                    Timber.Forest.tag("PlayerConnection");
                    okhttp3.ConnectionPool.e$1(new Object[0]);
                }
                return unit2;
            case 20:
                ((PlayerConnection) this.receiver).seekToPrevious();
                return unit2;
            case 21:
                ((PlayerConnection) this.receiver).seekToNext();
                return unit2;
            case 22:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 23:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 24:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 25:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            case 26:
                IntMath.toggleRepeatMode((ExoPlayerImpl) this.receiver);
                return unit2;
            case 27:
                ((ExoPlayerImpl) this.receiver).prepare();
                return unit2;
            case 28:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
            default:
                ((MenuState) this.receiver).setVisible(false);
                return unit2;
        }
    }
}
