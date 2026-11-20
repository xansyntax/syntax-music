package coil3;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ScrollObservationScope;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.viewinterop.FocusTargetInteropNode;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.DialogNavigator;
import coil3.compose.AsyncImagePainter;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.fetch.Fetcher;
import coil3.size.SizeKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.AvailableUpdate;
import com.metrolist.music.MainActivity;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda42;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda74;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentRegistry$Builder$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda2(NavController$NavControllerNavigatorState navController$NavControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z) {
        this.$r8$classId = (byte) 4;
        this.f$0 = navController$NavControllerNavigatorState;
        this.f$1 = navBackStackEntry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v14, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r5v20 */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        SemanticsNode semanticsNode;
        LayoutNode layoutNode;
        Rect rect;
        ViewGroup viewGroup;
        String str;
        byte b = this.$r8$classId;
        float intValue = CropImageView.DEFAULT_ASPECT_RATIO;
        byte b2 = 3;
        int i = 0;
        ?? r5 = 0;
        switch (b) {
            case 0:
                return CollectionsKt__IterablesKt.listOf(new Pair((Fetcher.Factory) this.f$0, (ClassReference) this.f$1));
            case 1:
                ScrollObservationScope scrollObservationScope = (ScrollObservationScope) this.f$0;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) this.f$1;
                ScrollAxisRange scrollAxisRange = scrollObservationScope.horizontalScrollAxisRange;
                ScrollAxisRange scrollAxisRange2 = scrollObservationScope.verticalScrollAxisRange;
                Float f = scrollObservationScope.oldXValue;
                Float f2 = scrollObservationScope.oldYValue;
                float fFloatValue = (scrollAxisRange == null || f == null) ? 0.0f : ((Number) scrollAxisRange.value.invoke()).floatValue() - f.floatValue();
                float fFloatValue2 = (scrollAxisRange2 == null || f2 == null) ? 0.0f : ((Number) scrollAxisRange2.value.invoke()).floatValue() - f2.floatValue();
                if (fFloatValue != CropImageView.DEFAULT_ASPECT_RATIO || fFloatValue2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                    int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.semanticsNodeId);
                    AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId);
                    if (adjustedSemanticsNode != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                            if (accessibilityNodeInfoCompat != null) {
                                accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(adjustedSemanticsNode));
                            }
                            break;
                        } catch (IllegalStateException unused) {
                        }
                    }
                    AdjustedSemanticsNode adjustedSemanticsNode2 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId);
                    if (adjustedSemanticsNode2 != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI;
                            if (accessibilityNodeInfoCompat2 != null) {
                                accessibilityNodeInfoCompat2.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(adjustedSemanticsNode2));
                            }
                            break;
                        } catch (IllegalStateException unused2) {
                        }
                    }
                    androidComposeViewAccessibilityDelegateCompat.view.invalidate();
                    AdjustedSemanticsNode adjustedSemanticsNode3 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId);
                    if (adjustedSemanticsNode3 != null && (semanticsNode = adjustedSemanticsNode3.semanticsNode) != null && (layoutNode = semanticsNode.layoutNode) != null) {
                        if (scrollAxisRange != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange);
                        }
                        if (scrollAxisRange2 != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange2);
                        }
                        androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    }
                }
                if (scrollAxisRange != null) {
                    scrollObservationScope.oldXValue = (Float) scrollAxisRange.value.invoke();
                }
                if (scrollAxisRange2 != null) {
                    scrollObservationScope.oldYValue = (Float) scrollAxisRange2.value.invoke();
                }
                return Unit.INSTANCE;
            case 2:
                Function0 function0 = (Function0) this.f$0;
                NodeCoordinator nodeCoordinator = (NodeCoordinator) this.f$1;
                if (function0 != null && (rect = (Rect) function0.invoke()) != null) {
                    return rect;
                }
                if (!nodeCoordinator.getTail().isAttached) {
                    nodeCoordinator = null;
                }
                if (nodeCoordinator != null) {
                    return IntMath.m896Recttz77jQw(0L, SizeKt.m876toSizeozmzZPI(nodeCoordinator.measuredSize));
                }
                return null;
            case 3:
                ((Ref$ObjectRef) this.f$0).element = HitTestResultKt.currentValueOf((FocusTargetInteropNode) this.f$1, PinnableContainerKt.LocalPinnableContainer);
                return Unit.INSTANCE;
            case 4:
                NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.f$0;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f$1;
                synchronized (navController$NavControllerNavigatorState.backStackLock) {
                    try {
                        StateFlowImpl stateFlowImpl = navController$NavControllerNavigatorState._backStack;
                        Iterable iterable = (Iterable) stateFlowImpl.getValue();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : iterable) {
                            if (Intrinsics.areEqual((NavBackStackEntry) obj, navBackStackEntry)) {
                                stateFlowImpl.updateState(null, arrayList);
                            } else {
                                arrayList.add(obj);
                            }
                        }
                        stateFlowImpl.updateState(null, arrayList);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            case 5:
                ((DialogNavigator) this.f$0).popBackStack((NavBackStackEntry) this.f$1, false);
                return Unit.INSTANCE;
            case 6:
                ComposeView composeView = (ComposeView) this.f$0;
                MutableState mutableState = (MutableState) this.f$1;
                int i2 = MainActivity.$r8$clinit;
                mutableState.setValue(Boolean.FALSE);
                ViewParent parent = composeView.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                }
                if (r5 != 0) {
                    r5 = viewGroup;
                    r5.removeView(composeView);
                }
                r5 = viewGroup;
                return Unit.INSTANCE;
            case 7:
                MainActivity mainActivity = (MainActivity) this.f$0;
                MutableState mutableState2 = (MutableState) this.f$1;
                int i3 = MainActivity.$r8$clinit;
                mutableState2.setValue(null);
                AwaitKt.launch$default(ViewModelKt.getCoroutineScope(mainActivity.getLifecycle()), null, null, new MainActivity.AnonymousClass1(mainActivity, (AvailableUpdate) null, (Continuation) null), 3);
                return Unit.INSTANCE;
            case 8:
                Function0 function1 = (Function0) this.f$0;
                MainActivity mainActivity2 = (MainActivity) this.f$1;
                int i4 = MainActivity.$r8$clinit;
                function1.invoke();
                mainActivity2.startActivity(new Intent("android.intent.action.VIEW", android.net.Uri.parse(null)));
                return Unit.INSTANCE;
            case 9:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) this.f$0;
                PlayerConnection playerConnection = (PlayerConnection) this.f$1;
                try {
                    if (listenTogetherManager.isHost() && !listenTogetherManager.isSyncing) {
                        MediaItem currentMediaItem = playerConnection.getPlayerSafe().getCurrentMediaItem();
                        String str2 = currentMediaItem != null ? currentMediaItem.mediaId : null;
                        Timber.Forest.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        ListenTogetherClient.sendPlaybackAction$default(listenTogetherManager.client, "seek", str2, 1L, null, null, null, null, 248);
                    }
                    break;
                } catch (Exception unused3) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
                return Unit.INSTANCE;
            case 10:
                VelocityTracker velocityTracker = (VelocityTracker) this.f$0;
                BottomSheetState bottomSheetState = (BottomSheetState) this.f$1;
                velocityTracker.resetTracking();
                AwaitKt.launch$default(bottomSheetState.coroutineScope, null, null, new MusicService.AnonymousClass14(bottomSheetState, bottomSheetState.collapsedBound, r5, b2), 3);
                return Unit.INSTANCE;
            case 11:
                FocusOwner focusOwner = (FocusOwner) this.f$0;
                MenuState menuState = (MenuState) this.f$1;
                ((FocusOwnerImpl) focusOwner).m409clearFocusI7lrPNg(8, false, true);
                menuState.setVisible(false);
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                FocusOwner focusOwner2 = (FocusOwner) this.f$0;
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) this.f$1;
                ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                bottomSheetPageState.isVisible$delegate.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 13:
                TimePickerState timePickerState = (TimePickerState) this.f$0;
                ((Function1) this.f$1).invoke(StringsKt.padStart(2, String.valueOf(timePickerState.getHour())) + ServerSentEventKt.COLON + StringsKt.padStart(2, String.valueOf(timePickerState.getMinute())));
                return Unit.INSTANCE;
            case 14:
                ((MusicDatabase) this.f$0).query(new AlbumMenuKt$$ExternalSyntheticLambda42((Album) this.f$1, false ? 1 : 0));
                return Unit.INSTANCE;
            case 15:
                ((MusicDatabase) this.f$0).transaction(new DiskLruCache$$ExternalSyntheticLambda0((byte) 28, (Artist) this.f$1));
                return Unit.INSTANCE;
            case 16:
                Context context = (Context) this.f$0;
                Listentogether.RoomState roomState = (Listentogether.RoomState) this.f$1;
                Object systemService = context.getSystemService("clipboard");
                systemService.getClass();
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Room Code", roomState.getRoomCode()));
                Toast.makeText(context, R.string.copied_to_clipboard, 0).show();
                return Unit.INSTANCE;
            case 17:
                PlayerConnection playerConnection2 = (PlayerConnection) this.f$0;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.f$1;
                playerConnection2.getPlayerSafe().setPlaybackParameters(new PlaybackParameters(parcelableSnapshotMutableFloatState.getFloatValue(), parcelableSnapshotMutableFloatState.getFloatValue()));
                return Unit.INSTANCE;
            case 18:
                Function0 function2 = (Function0) this.f$0;
                ((ParcelableSnapshotMutableFloatState) this.f$1).setFloatValue(1.0f);
                function2.invoke();
                return Unit.INSTANCE;
            case 19:
                PlayerConnection playerConnection3 = (PlayerConnection) this.f$0;
                Function0 function3 = (Function0) this.f$1;
                try {
                    MusicService musicService = playerConnection3.service;
                    AwaitKt.launch$default(musicService.scope, null, null, new AsyncImagePainter.AnonymousClass1(musicService, r5, (byte) 13), 3);
                    break;
                } catch (Exception unused4) {
                    Timber.Forest.tag("PlayerConnection");
                    ConnectionPool.e$1(new Object[0]);
                }
                function3.invoke();
                return Unit.INSTANCE;
            case 20:
                NavHostController navHostController = (NavHostController) this.f$0;
                Function0 function4 = (Function0) this.f$1;
                NavHostController.navigate$default(navHostController, "equalizer");
                function4.invoke();
                return Unit.INSTANCE;
            case 21:
                ((MusicDatabase) this.f$0).query(new AppBarKt$$ExternalSyntheticLambda3((State) this.f$1, (byte) 9));
                return Unit.INSTANCE;
            case 22:
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.f$0;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) this.f$1;
                if (parcelableSnapshotMutableIntState.getIntValue() > 0) {
                    intValue = parcelableSnapshotMutableIntState2.getIntValue() / parcelableSnapshotMutableIntState.getIntValue();
                }
                return Float.valueOf(intValue);
            case 23:
                ArrayList arrayList2 = (ArrayList) this.f$0;
                DownloadUtil downloadUtil = (DownloadUtil) this.f$1;
                int size = arrayList2.size();
                while (i < size) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    downloadUtil.download((Song) obj2);
                }
                return Unit.INSTANCE;
            case 24:
                ((DownloadUtil) this.f$0).download((Song) this.f$1);
                return Unit.INSTANCE;
            case 25:
                DownloadUtil downloadUtil2 = (DownloadUtil) this.f$0;
                SongItem songItem = (SongItem) this.f$1;
                songItem.getClass();
                downloadUtil2.download(HexFormatKt.toMediaMetadata(songItem));
                return Unit.INSTANCE;
            case 26:
                ((PlayerConnection) this.f$0).getPlayerSafe().setShuffleModeEnabled(!((Boolean) ((State) this.f$1).getValue()).booleanValue());
                return Unit.INSTANCE;
            case 27:
                ((BottomSheetPageState) this.f$0).show(new ComposableLambdaImpl(true, -1483232708, new PlayerKt$$ExternalSyntheticLambda74((State) this.f$1, false ? 1 : 0)));
                return Unit.INSTANCE;
            case 28:
                ((BottomSheetPageState) this.f$1).show(new ComposableLambdaImpl(true, 1630300101, new MainActivity$$ExternalSyntheticLambda7(((MediaMetadata) this.f$0).id, (byte) 6)));
                return Unit.INSTANCE;
            default:
                State state = (State) this.f$0;
                Context context2 = (Context) this.f$1;
                MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                if (mediaMetadata != null && (str = mediaMetadata.id) != null) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/watch?v=".concat(str));
                    context2.startActivity(Intent.createChooser(intent, null));
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda2(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda2(Object obj, Object obj2, AvailableUpdate availableUpdate, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
