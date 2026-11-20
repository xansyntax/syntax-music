package androidx.compose.runtime;

import android.view.Choreographer;
import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi25;
import androidx.compose.ui.text.input.TextInputService;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda30;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda36;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Latch$await$2$2 implements Function1 {
    public final /* synthetic */ Object $co;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ Latch$await$2$2(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$co = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long j;
        RecordingInputConnection recordingInputConnection;
        boolean z = false;
        zM412moveFocusaToIllA = false;
        zM412moveFocusaToIllA = false;
        zM412moveFocusaToIllA = false;
        zM412moveFocusaToIllA = false;
        zM412moveFocusaToIllA = false;
        boolean zM412moveFocusaToIllA = false;
        z = false;
        z = false;
        switch (this.$r8$classId) {
            case 0:
                Latch latch = (Latch) this.this$0;
                Object obj2 = latch.lock;
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.$co;
                synchronized (obj2) {
                    ((ArrayList) latch.awaiters).remove(cancellableContinuationImpl);
                }
                return Unit.INSTANCE;
            case 1:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                if (((LegacyTextFieldState) this.this$0).getHandleState() == HandleState.Selection && keyEvent.getKeyCode() == 4 && Key.m581getTypeZmokQxo(keyEvent) == 1) {
                    ((TextFieldSelectionManager) this.$co).m231deselect_kEHs6E$foundation(null);
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                KeyEvent keyEvent2 = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                FocusOwner focusOwner = (FocusOwner) this.this$0;
                InputDevice device = keyEvent2.getDevice();
                if (device != null && device.supportsSource(513) && ((!device.isVirtual() || keyEvent2.getSource() == 33554433) && Key.m581getTypeZmokQxo(keyEvent2) == 2 && keyEvent2.getSource() != 257)) {
                    if (BasicTextKt.m192isKeyCodeYhN2O0w(19, keyEvent2)) {
                        zM412moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m412moveFocusaToIllA(5, true);
                    } else if (BasicTextKt.m192isKeyCodeYhN2O0w(20, keyEvent2)) {
                        zM412moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m412moveFocusaToIllA(6, true);
                    } else if (BasicTextKt.m192isKeyCodeYhN2O0w(21, keyEvent2)) {
                        zM412moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m412moveFocusaToIllA(3, true);
                    } else if (BasicTextKt.m192isKeyCodeYhN2O0w(22, keyEvent2)) {
                        zM412moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m412moveFocusaToIllA(4, true);
                    } else if (BasicTextKt.m192isKeyCodeYhN2O0w(23, keyEvent2)) {
                        SoftwareKeyboardController softwareKeyboardController = ((LegacyTextFieldState) this.$co).keyboardController;
                        if (softwareKeyboardController != null) {
                            ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                        }
                        zM412moveFocusaToIllA = true;
                    }
                }
                return Boolean.valueOf(zM412moveFocusaToIllA);
            case 3:
                SnapshotIdSet snapshotIdSet = (SnapshotIdSet) obj;
                synchronized (SnapshotKt.lock) {
                    j = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = 1 + j;
                }
                return new MutableSnapshot(j, snapshotIdSet, (Function1) this.this$0, (Function1) this.$co);
            case 4:
                InputMethodSession inputMethodSession = (InputMethodSession) this.this$0;
                synchronized (inputMethodSession.lock) {
                    try {
                        inputMethodSession.disposed = true;
                        MutableVector mutableVector = inputMethodSession.connections;
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            NullableInputConnectionWrapperApi25 nullableInputConnectionWrapperApi25 = (NullableInputConnectionWrapperApi25) ((WeakReference) objArr[i2]).get();
                            if (nullableInputConnectionWrapperApi25 != null && (recordingInputConnection = nullableInputConnectionWrapperApi25.delegate) != null) {
                                recordingInputConnection.closeConnection();
                                nullableInputConnectionWrapperApi25.delegate = null;
                            }
                        }
                        inputMethodSession.connections.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                TextInputService textInputService = ((AndroidPlatformTextInputSession) this.$co).textInputService;
                textInputService._currentInputSession.set(null);
                textInputService.platformTextInputService.stopInput();
                return Unit.INSTANCE;
            case 5:
                AndroidUiDispatcher androidUiDispatcher = (AndroidUiDispatcher) this.this$0;
                AndroidUiFrameClock$withFrameNanos$2$callback$1 androidUiFrameClock$withFrameNanos$2$callback$1 = (AndroidUiFrameClock$withFrameNanos$2$callback$1) this.$co;
                synchronized (androidUiDispatcher.lock) {
                    androidUiDispatcher.toRunOnFrame.remove(androidUiFrameClock$withFrameNanos$2$callback$1);
                }
                return Unit.INSTANCE;
            case 6:
                ((Choreographer) ((BroadcastFrameClock) this.this$0).onNewAwaiters).removeFrameCallback((AndroidUiFrameClock$withFrameNanos$2$callback$1) this.$co);
                return Unit.INSTANCE;
            case 7:
                int iIntValue = ((Number) obj).intValue();
                return ((MainActivity$$ExternalSyntheticLambda30) this.this$0).invoke(Integer.valueOf(iIntValue), ((List) this.$co).get(iIntValue));
            case 8:
                int iIntValue2 = ((Number) obj).intValue();
                return ((MainActivity$$ExternalSyntheticLambda30) this.this$0).invoke(Integer.valueOf(iIntValue2), ((List) this.$co).get(iIntValue2));
            case 9:
                return ((AlbumMenuKt$$ExternalSyntheticLambda13) this.this$0).invoke(((List) this.$co).get(((Number) obj).intValue()));
            case 10:
                return ((AlbumMenuKt$$ExternalSyntheticLambda13) this.this$0).invoke(((List) this.$co).get(((Number) obj).intValue()));
            case 11:
                return ((AlbumMenuKt$$ExternalSyntheticLambda13) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                String str = ((MediaMetadata) this.this$0).id;
                LyricsResult lyricsResult = (LyricsResult) this.$co;
                musicDatabase.$$delegate_0.upsert(new LyricsEntity(str, lyricsResult.lyrics, lyricsResult.providerName));
                return Unit.INSTANCE;
            case 13:
                return ((SongMenuKt$$ExternalSyntheticLambda16) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 14:
                return ((SongMenuKt$$ExternalSyntheticLambda16) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 15:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Timeline.Window window = (Timeline.Window) this.$co;
                List list = (List) this.this$0;
                MediaItem mediaItem = window.mediaItem;
                if (zBooleanValue) {
                    String str2 = mediaItem.mediaId;
                    str2.getClass();
                    list.add(str2);
                } else {
                    list.remove(mediaItem.mediaId);
                }
                return Unit.INSTANCE;
            case 16:
                int iIntValue3 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda36) this.this$0).invoke(Integer.valueOf(iIntValue3), ((List) this.$co).get(iIntValue3));
            case 17:
                int iIntValue4 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda3) this.this$0).invoke(Integer.valueOf(iIntValue4), ((List) this.$co).get(iIntValue4));
            case 18:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 19:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 20:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 21:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 22:
                int iIntValue5 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda3) this.this$0).invoke(Integer.valueOf(iIntValue5), ((List) this.$co).get(iIntValue5));
            case 23:
                int iIntValue6 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda3) this.this$0).invoke(Integer.valueOf(iIntValue6), ((List) this.$co).get(iIntValue6));
            case 24:
                int iIntValue7 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda3) this.this$0).invoke(Integer.valueOf(iIntValue7), ((List) this.$co).get(iIntValue7));
            case 25:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 26:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
            case 27:
                ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
                return "grid_item";
            case 28:
                int iIntValue8 = ((Number) obj).intValue();
                return ((QueueKt$$ExternalSyntheticLambda3) this.this$0).invoke(Integer.valueOf(iIntValue8), ((ArrayList) this.$co).get(iIntValue8));
            default:
                return ((QueueKt$$ExternalSyntheticLambda4) this.this$0).invoke(((ArrayList) this.$co).get(((Number) obj).intValue()));
        }
    }
}
