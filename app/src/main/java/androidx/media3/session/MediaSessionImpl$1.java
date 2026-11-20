package androidx.media3.session;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.selection.CrossStatus;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import com.google.common.util.concurrent.FutureCallback;
import com.materialkolor.quantize.QuantizerWu;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionImpl$1 implements MediaCodecAdapter.Factory, FutureCallback {
    public final /* synthetic */ byte $r8$classId;
    public final Object this$0;
    public boolean val$callOnPlayerInteractionFinished;
    public Object val$controllerForRequest;

    public MediaSessionImpl$1(AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0 asynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0, AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0 asynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda1) {
        this.$r8$classId = (byte) 3;
        this.val$controllerForRequest = asynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0;
        this.this$0 = asynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda1;
        this.val$callOnPlayerInteractionFinished = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public AsynchronousMediaCodecAdapter createAdapter(QuantizerWu quantizerWu) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        MediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer;
        int i;
        String str = ((MediaCodecInfo) quantizerWu.weights).name;
        AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                if (!this.val$callOnPlayerInteractionFinished || Build.VERSION.SDK_INT < 36) {
                    asynchronousMediaCodecBufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodecCreateByCodecName, (HandlerThread) ((AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0) this.this$0).get());
                    i = 0;
                } else {
                    asynchronousMediaCodecBufferEnqueuer = new AtomicInt(mediaCodecCreateByCodecName);
                    i = 4;
                }
                AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, (HandlerThread) ((AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0) this.val$controllerForRequest).get(), asynchronousMediaCodecBufferEnqueuer, (LoudnessCodecController) quantizerWu.cubes);
                try {
                    Trace.endSection();
                    Surface surface = (Surface) quantizerWu.momentsB;
                    if (surface == null && ((MediaCodecInfo) quantizerWu.weights).detachedSurfaceSupported && Build.VERSION.SDK_INT >= 35) {
                        i |= 8;
                    }
                    asynchronousMediaCodecAdapter2.initialize((MediaFormat) quantizerWu.momentsR, surface, (MediaCrypto) quantizerWu.moments, i);
                    return asynchronousMediaCodecAdapter2;
                } catch (Exception e) {
                    e = e;
                    asynchronousMediaCodecAdapter = asynchronousMediaCodecAdapter2;
                    if (asynchronousMediaCodecAdapter != null) {
                        asynchronousMediaCodecAdapter.release();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    public CrossStatus getCrossStatus() {
        GapBuffer gapBuffer = (GapBuffer) this.this$0;
        int i = gapBuffer.capacity;
        int i2 = gapBuffer.gapStart;
        if (i < i2) {
            return CrossStatus.NOT_CROSSED;
        }
        return i > i2 ? CrossStatus.CROSSED : CrossStatus.COLLAPSED;
    }

    public void onDragDone() {
        if (this.val$callOnPlayerInteractionFinished) {
            ((TextFieldSelectionManager) this.this$0).m234maybeSuggestSelectionOEnZFl4((TextRange) this.val$controllerForRequest);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.this$0;
        if (th instanceof UnsupportedOperationException) {
            Log.w("MediaSessionImpl", "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
        } else {
            Log.e("MediaSessionImpl", "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
        }
        Util.handlePlayButtonAction(mediaLibrarySessionImpl.playerWrapper);
        if (this.val$callOnPlayerInteractionFinished) {
            mediaLibrarySessionImpl.onPlayerInteractionFinishedOnHandler((MediaSession$ControllerInfo) this.val$controllerForRequest);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(Object obj) {
        MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.val$controllerForRequest;
        boolean z = this.val$callOnPlayerInteractionFinished;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.this$0;
        MediaUtils.setMediaItemsWithStartIndexAndPosition(mediaLibrarySessionImpl.playerWrapper, (MediaSession$MediaItemsWithStartPosition) obj);
        Util.handlePlayButtonAction(mediaLibrarySessionImpl.playerWrapper);
        if (z) {
            mediaLibrarySessionImpl.onPlayerInteractionFinishedOnHandler(mediaSession$ControllerInfo);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return "SingleSelectionLayout(isStartHandle=" + this.val$callOnPlayerInteractionFinished + ", crossed=" + getCrossStatus() + ", info=\n\t" + ((GapBuffer) this.this$0) + ")";
            default:
                return super.toString();
        }
    }

    public long updateMouseSelection(TextFieldValue textFieldValue, long j, boolean z, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0) {
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
        long jM236updateSelectionjSglsI8 = textFieldSelectionManager.m236updateSelectionjSglsI8(textFieldValue, j, z, false, marqueeSpacing$Companion$$ExternalSyntheticLambda0, false, null);
        if (!TextRange.m739equalsimpl(jM236updateSelectionjSglsI8, (TextRange) this.val$controllerForRequest)) {
            this.val$callOnPlayerInteractionFinished = false;
        }
        textFieldSelectionManager.setHandleState(TextRange.m741getCollapsedimpl(jM236updateSelectionjSglsI8) ? HandleState.Cursor : HandleState.Selection);
        return jM236updateSelectionjSglsI8;
    }

    public MediaSessionImpl$1(boolean z, Selection selection, GapBuffer gapBuffer) {
        this.$r8$classId = (byte) 1;
        this.val$callOnPlayerInteractionFinished = z;
        this.val$controllerForRequest = selection;
        this.this$0 = gapBuffer;
    }

    public MediaSessionImpl$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.$r8$classId = (byte) 2;
        this.this$0 = textFieldSelectionManager;
        this.val$callOnPlayerInteractionFinished = true;
    }

    public MediaSessionImpl$1(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, boolean z, Player.Commands commands) {
        this.$r8$classId = (byte) 0;
        this.this$0 = mediaLibrarySessionImpl;
        this.val$controllerForRequest = mediaSession$ControllerInfo;
        this.val$callOnPlayerInteractionFinished = z;
    }
}
