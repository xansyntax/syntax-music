package com.google.common.collect;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.core.view.DisplayCompat;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import androidx.media3.session.MediaSessionService;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.primitives.ImmutableIntArray;
import java.util.Map;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Maps$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Maps$$ExternalSyntheticLambda1(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                return new AbstractMapEntry() { // from class: com.google.common.collect.Maps.9
                    public final /* synthetic */ Map.Entry val$entry;
                    public final /* synthetic */ Splitter$$ExternalSyntheticLambda0 val$transformer;

                    public AnonymousClass9() {
                        entry = entry;
                        splitter$$ExternalSyntheticLambda0 = splitter$$ExternalSyntheticLambda0;
                    }

                    @Override // java.util.Map.Entry
                    public final Object getKey() {
                        return entry.getKey();
                    }

                    @Override // java.util.Map.Entry
                    public final Object getValue() {
                        Map.Entry entry2 = entry;
                        return splitter$$ExternalSyntheticLambda0.transformEntry(entry2.getKey(), entry2.getValue());
                    }
                };
            case 1:
                RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) obj2;
                StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
                NetworkTypeObserver.Receiver receiver = (NetworkTypeObserver.Receiver) rulerTrackingMap.newRulers;
                if (receiver != null) {
                    try {
                        ((Context) rulerTrackingMap.rulers).unregisterReceiver(receiver);
                    } catch (RuntimeException e) {
                        Log.w("StreamVolumeManager", "Error unregistering stream volume receiver", e);
                    }
                    rulerTrackingMap.newRulers = null;
                    break;
                }
                return streamVolumeManager$StreamVolumeState;
            case 2:
                int i = MediaSessionService.$r8$clinit;
                ((MediaSessionService) obj2).lambda$onUpdateNotification$3((RuntimeException) obj);
                return null;
            case 3:
                Bitmap bitmap = (Bitmap) obj;
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                ImmutableIntArray immutableIntArray = (ImmutableIntArray) ((Splitter) obj2).strategy;
                if (!immutableIntArray.contains(Math.max(height, width))) {
                    return bitmap;
                }
                if (immutableIntArray.contains(height)) {
                    height--;
                }
                if (immutableIntArray.contains(width)) {
                    width--;
                }
                return DisplayCompat.makeShared(Bitmap.createScaledBitmap(bitmap, width, height, true));
            default:
                Bitmap bitmapCreateScaledBitmap = (Bitmap) obj;
                int width2 = bitmapCreateScaledBitmap.getWidth();
                int i2 = ((PriorityQueue) obj2).size;
                if (width2 > i2 || bitmapCreateScaledBitmap.getHeight() > i2) {
                    float f = i2;
                    float width3 = bitmapCreateScaledBitmap.getWidth();
                    float height2 = bitmapCreateScaledBitmap.getHeight();
                    float fMin = Math.min(f / width3, f / height2);
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, (int) (width3 * fMin), (int) (height2 * fMin), true);
                }
                return DisplayCompat.makeShared(bitmapCreateScaledBitmap);
        }
    }
}
