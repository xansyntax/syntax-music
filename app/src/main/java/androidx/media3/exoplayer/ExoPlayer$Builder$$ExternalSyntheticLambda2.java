package androidx.media3.exoplayer;

import android.content.Context;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.base.Supplier;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda2 implements Supplier {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda2(Context context, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        DefaultBandwidthMeter defaultBandwidthMeter;
        byte b = this.$r8$classId;
        Context context = this.f$0;
        switch (b) {
            case 0:
                return new DefaultRenderersFactory(context);
            case 1:
                return HandlerCompat$Api28Impl.getAudioManager(context);
            case 2:
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                defaultExtractorsFactory.subtitleParserFactory = new CueDecoder((byte) 15);
                defaultExtractorsFactory.textTrackTranscodingEnabled = true;
                defaultExtractorsFactory.codecsToParseWithinGopSampleDependencies = (byte) 3;
                return new DefaultMediaSourceFactory(new WeakCache(context), defaultExtractorsFactory);
            case 3:
                return new DefaultTrackSelector(context);
            default:
                RegularImmutableList regularImmutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
                synchronized (DefaultBandwidthMeter.class) {
                    defaultBandwidthMeter = DefaultBandwidthMeter.singletonInstance;
                    if (defaultBandwidthMeter == null) {
                        Context applicationContext = context == null ? null : context.getApplicationContext();
                        HashMap map = new HashMap(8);
                        map.put(0, 1000000L);
                        map.put(2, -9223372036854775807L);
                        map.put(3, -9223372036854775807L);
                        map.put(4, -9223372036854775807L);
                        map.put(5, -9223372036854775807L);
                        map.put(10, -9223372036854775807L);
                        map.put(9, -9223372036854775807L);
                        map.put(7, -9223372036854775807L);
                        defaultBandwidthMeter = new DefaultBandwidthMeter(applicationContext, map);
                        DefaultBandwidthMeter.singletonInstance = defaultBandwidthMeter;
                    }
                    break;
                }
                return defaultBandwidthMeter;
        }
    }
}
