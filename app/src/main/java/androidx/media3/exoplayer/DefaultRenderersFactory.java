package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import androidx.navigation.internal.NavContext;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import okio.FileMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DefaultRenderersFactory {
    public final NavContext codecAdapterFactory;
    public final Context context;

    public DefaultRenderersFactory(Context context) {
        this.context = context;
        this.codecAdapterFactory = new NavContext(context, 0);
    }

    public void buildAudioRenderers(Context context, AudioSink audioSink, Handler handler, ExoPlayerImpl.ComponentListener componentListener, ArrayList arrayList) {
        arrayList.add(new MediaCodecAudioRenderer(context, this.codecAdapterFactory, handler, componentListener, audioSink));
    }

    public DefaultAudioSink buildAudioSink(Context context) {
        FileMetadata fileMetadata = new FileMetadata(context);
        fileMetadata.isRegularFile = false;
        return fileMetadata.build();
    }

    public final BaseRenderer[] createRenderers(Handler handler, ExoPlayerImpl.ComponentListener componentListener, ExoPlayerImpl.ComponentListener componentListener2, ExoPlayerImpl.ComponentListener componentListener3, ExoPlayerImpl.ComponentListener componentListener4) {
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        MediaCodecVideoRenderer.Builder builder = new MediaCodecVideoRenderer.Builder(context);
        builder.codecAdapterFactory = this.codecAdapterFactory;
        builder.allowedJoiningTimeMs = (short) 5000;
        builder.eventHandler = handler;
        builder.eventListener = componentListener;
        builder.maxDroppedFramesToNotify = (byte) 50;
        UtilsKt.checkState(!builder.buildCalled);
        Handler handler2 = builder.eventHandler;
        UtilsKt.checkState((handler2 == null && builder.eventListener == null) || !(handler2 == null || builder.eventListener == null));
        builder.buildCalled = true;
        arrayList.add(new MediaCodecVideoRenderer(builder));
        buildAudioRenderers(this.context, buildAudioSink(context), handler, componentListener2, arrayList);
        arrayList.add(new TextRenderer(componentListener3, handler.getLooper()));
        Looper looper = handler.getLooper();
        for (int i = 0; i < 4; i++) {
            arrayList.add(new MetadataRenderer(componentListener4, looper));
        }
        arrayList.add(new CameraMotionRenderer());
        arrayList.add(new ImageRenderer(new NavContext(context, (byte) 3)));
        return (BaseRenderer[]) arrayList.toArray(new BaseRenderer[0]);
    }
}
