package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicDetailHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicDetailHeaderRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Runs description;
    public final Menu menu;
    public final Runs secondSubtitle;
    public final Runs subtitle;
    public final ThumbnailRenderer thumbnail;
    public final Runs title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicDetailHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicDetailHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicDetailHeaderRenderer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MusicDetailHeaderRenderer(int i, Runs runs, Runs runs2, Runs runs3, Runs runs4, ThumbnailRenderer thumbnailRenderer, Menu menu) {
        if (63 != (i & 63)) {
            EnumsKt.throwMissingFieldException(MusicDetailHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 63);
            throw null;
        }
        this.title = runs;
        this.subtitle = runs2;
        this.secondSubtitle = runs3;
        this.description = runs4;
        this.thumbnail = thumbnailRenderer;
        this.menu = menu;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicDetailHeaderRenderer)) {
            return false;
        }
        MusicDetailHeaderRenderer musicDetailHeaderRenderer = (MusicDetailHeaderRenderer) obj;
        return Intrinsics.areEqual(this.title, musicDetailHeaderRenderer.title) && Intrinsics.areEqual(this.subtitle, musicDetailHeaderRenderer.subtitle) && Intrinsics.areEqual(this.secondSubtitle, musicDetailHeaderRenderer.secondSubtitle) && Intrinsics.areEqual(this.description, musicDetailHeaderRenderer.description) && Intrinsics.areEqual(this.thumbnail, musicDetailHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.menu, musicDetailHeaderRenderer.menu);
    }

    public final int hashCode() {
        int iHashCode = (this.secondSubtitle.hashCode() + ((this.subtitle.hashCode() + (this.title.hashCode() * 31)) * 31)) * 31;
        Runs runs = this.description;
        return this.menu.menuRenderer.hashCode() + ((this.thumbnail.hashCode() + ((iHashCode + (runs == null ? 0 : runs.hashCode())) * 31)) * 31);
    }

    public final String toString() {
        return "MusicDetailHeaderRenderer(title=" + this.title + ", subtitle=" + this.subtitle + ", secondSubtitle=" + this.secondSubtitle + ", description=" + this.description + ", thumbnail=" + this.thumbnail + ", menu=" + this.menu + ")";
    }
}
