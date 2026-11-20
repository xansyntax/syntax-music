package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeSequenceableLoader implements SequenceableLoader {
    public long lastAudioVideoBufferedPositionUs;
    public final RegularImmutableList loadersWithTrackTypes;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {
        public final SequenceableLoader loader;
        public final ImmutableList trackTypes;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List list) {
            this.loader = sequenceableLoader;
            this.trackTypes = ImmutableList.copyOf((Collection) list);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean continueLoading(LoadingInfo loadingInfo) {
            return this.loader.continueLoading(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long getBufferedPositionUs() {
            return this.loader.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long getNextLoadPositionUs() {
            return this.loader.getNextLoadPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean isLoading() {
            return this.loader.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final void reevaluateBuffer(long j) {
            this.loader.reevaluateBuffer(j);
        }
    }

    public CompositeSequenceableLoader(List list, List list2) {
        ImmutableList.Builder builder = ImmutableList.builder();
        UtilsKt.checkArgument(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            builder.add((Object) new SequenceableLoaderWithTrackTypes((SequenceableLoader) list.get(i), (List) list2.get(i)));
        }
        this.loadersWithTrackTypes = builder.build();
        this.lastAudioVideoBufferedPositionUs = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean continueLoading(LoadingInfo loadingInfo) {
        boolean zContinueLoading;
        boolean z = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return z;
            }
            int i = 0;
            zContinueLoading = false;
            while (true) {
                RegularImmutableList regularImmutableList = this.loadersWithTrackTypes;
                if (i >= regularImmutableList.size) {
                    break;
                }
                long nextLoadPositionUs2 = ((SequenceableLoaderWithTrackTypes) regularImmutableList.get(i)).loader.getNextLoadPositionUs();
                boolean z2 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= loadingInfo.playbackPositionUs;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z2) {
                    zContinueLoading |= ((SequenceableLoaderWithTrackTypes) regularImmutableList.get(i)).loader.continueLoading(loadingInfo);
                }
                i++;
            }
            z |= zContinueLoading;
        } while (zContinueLoading);
        return z;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            RegularImmutableList regularImmutableList = this.loadersWithTrackTypes;
            if (i >= regularImmutableList.size) {
                break;
            }
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = (SequenceableLoaderWithTrackTypes) regularImmutableList.get(i);
            long bufferedPositionUs = sequenceableLoaderWithTrackTypes.loader.getBufferedPositionUs();
            ImmutableList immutableList = sequenceableLoaderWithTrackTypes.trackTypes;
            if ((immutableList.contains(1) || immutableList.contains(2) || immutableList.contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, bufferedPositionUs);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.lastAudioVideoBufferedPositionUs = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.lastAudioVideoBufferedPositionUs;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            RegularImmutableList regularImmutableList = this.loadersWithTrackTypes;
            if (i >= regularImmutableList.size) {
                break;
            }
            long nextLoadPositionUs = ((SequenceableLoaderWithTrackTypes) regularImmutableList.get(i)).loader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean isLoading() {
        int i = 0;
        while (true) {
            RegularImmutableList regularImmutableList = this.loadersWithTrackTypes;
            if (i >= regularImmutableList.size) {
                return false;
            }
            if (((SequenceableLoaderWithTrackTypes) regularImmutableList.get(i)).loader.isLoading()) {
                return true;
            }
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        int i = 0;
        while (true) {
            RegularImmutableList regularImmutableList = this.loadersWithTrackTypes;
            if (i >= regularImmutableList.size) {
                return;
            }
            ((SequenceableLoaderWithTrackTypes) regularImmutableList.get(i)).reevaluateBuffer(j);
            i++;
        }
    }
}
