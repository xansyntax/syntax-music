package com.metrolist.music.eq;

import com.metrolist.music.eq.audio.BiquadFilter;
import com.metrolist.music.eq.audio.CustomEqualizerAudioProcessor;
import com.metrolist.music.eq.data.ParametricEQ;
import com.metrolist.music.eq.data.SavedEQProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EqualizerService {
    public final ArrayList audioProcessors = new ArrayList();
    public SavedEQProfile pendingProfile;
    public boolean shouldDisable;

    public static void applyProfileToProcessor(CustomEqualizerAudioProcessor customEqualizerAudioProcessor, SavedEQProfile savedEQProfile) {
        double d = savedEQProfile.preamp;
        List list = savedEQProfile.bands;
        ParametricEQ parametricEQ = new ParametricEQ(d, list, EmptyMap.INSTANCE);
        synchronized (customEqualizerAudioProcessor) {
            if (customEqualizerAudioProcessor.sampleRate == 0) {
                Timber.Forest.tag("CustomEqualizerAudioProcessor");
                list.size();
                ConnectionPool.d(new Object[0]);
                customEqualizerAudioProcessor.pendingProfile = parametricEQ;
                return;
            }
            customEqualizerAudioProcessor.preampGain = Math.pow(10.0d, d / 20.0d);
            customEqualizerAudioProcessor.createFilters(list);
            customEqualizerAudioProcessor.equalizerEnabled = true;
            Iterator it = customEqualizerAudioProcessor.filters.iterator();
            while (it.hasNext()) {
                ((BiquadFilter) it.next()).reset();
            }
            Timber.Forest.tag("CustomEqualizerAudioProcessor");
            customEqualizerAudioProcessor.filters.size();
            ConnectionPool.d(new Object[0]);
        }
    }

    /* JADX INFO: renamed from: applyProfile-IoAF18A, reason: not valid java name */
    public final Object m1068applyProfileIoAF18A(SavedEQProfile savedEQProfile) {
        ArrayList arrayList = this.audioProcessors;
        boolean zIsEmpty = arrayList.isEmpty();
        Unit unit = Unit.INSTANCE;
        if (zIsEmpty) {
            Timber.Forest.tag("EqualizerService");
            ConnectionPool.w(new Object[0]);
            this.pendingProfile = savedEQProfile;
            this.shouldDisable = false;
            return unit;
        }
        this.pendingProfile = savedEQProfile;
        this.shouldDisable = false;
        int size = arrayList.size();
        boolean z = true;
        Exception exc = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                applyProfileToProcessor((CustomEqualizerAudioProcessor) obj, savedEQProfile);
            } catch (Exception e) {
                exc = e;
                z = false;
            }
        }
        if (z) {
            return unit;
        }
        if (exc == null) {
            exc = new Exception("Unknown error");
        }
        return new Result.Failure(exc);
    }

    public final void disable() {
        ArrayList arrayList = this.audioProcessors;
        if (arrayList.isEmpty()) {
            Timber.Forest.tag("EqualizerService");
            ConnectionPool.w(new Object[0]);
            this.shouldDisable = true;
            this.pendingProfile = null;
            return;
        }
        this.shouldDisable = true;
        this.pendingProfile = null;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((CustomEqualizerAudioProcessor) obj).disable();
            } catch (Exception e) {
                Timber.Forest.tag("EqualizerService");
                e.getMessage();
                ConnectionPool.e(new Object[0]);
            }
        }
        Timber.Forest.tag("EqualizerService");
        ConnectionPool.d(new Object[0]);
    }
}
