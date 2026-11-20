package com.metrolist.music.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeSourceNode;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetManager {
    public final CoroutineScope applicationScope;
    public volatile Bitmap cachedAlbumArt;
    public volatile String cachedArtworkUri;
    public volatile Bitmap cachedRoundedAlbumArt;
    public volatile Bitmap cachedRoundedSource;
    public final List cardSlots;
    public final Context context;
    public final MusicDatabase database;
    public final ConcurrentHashMap fallbackArtworkCache;
    public volatile WidgetState lastWidgetState;
    public final ConcurrentHashMap roundedAppIconCache;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CardSlot {
        public final int artworkId;
        public final int containerId;
        public final int playContainerId;
        public final int playIconId;
        public final int titleId;

        public CardSlot(int i, int i2, int i3, int i4, int i5) {
            this.containerId = i;
            this.artworkId = i2;
            this.playContainerId = i3;
            this.playIconId = i4;
            this.titleId = i5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CardSlot)) {
                return false;
            }
            CardSlot cardSlot = (CardSlot) obj;
            return this.containerId == cardSlot.containerId && this.artworkId == cardSlot.artworkId && this.playContainerId == cardSlot.playContainerId && this.playIconId == cardSlot.playIconId && this.titleId == cardSlot.titleId;
        }

        public final int hashCode() {
            return Integer.hashCode(this.titleId) + IntIntPair$$ExternalSyntheticOutline0.m(this.playIconId, IntIntPair$$ExternalSyntheticOutline0.m(this.playContainerId, IntIntPair$$ExternalSyntheticOutline0.m(this.artworkId, Integer.hashCode(this.containerId) * 31, 31), 31), 31);
        }

        public final String toString() {
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.containerId, "CardSlot(containerId=", ", artworkId=", this.artworkId, ", playContainerId=");
            sbM3m.append(this.playContainerId);
            sbM3m.append(", playIconId=");
            sbM3m.append(this.playIconId);
            sbM3m.append(", titleId=");
            return Fragment$5$$ExternalSyntheticOutline0.m(sbM3m, this.titleId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FallbackArtworkKey {
        public final int cornerRadius;
        public final int fallbackIconRes;
        public final String targetType;

        public FallbackArtworkKey(String str, int i, int i2) {
            this.targetType = str;
            this.fallbackIconRes = i;
            this.cornerRadius = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FallbackArtworkKey)) {
                return false;
            }
            FallbackArtworkKey fallbackArtworkKey = (FallbackArtworkKey) obj;
            return this.targetType.equals(fallbackArtworkKey.targetType) && this.fallbackIconRes == fallbackArtworkKey.fallbackIconRes && this.cornerRadius == fallbackArtworkKey.cornerRadius;
        }

        public final int hashCode() {
            return Integer.hashCode(this.cornerRadius) + IntIntPair$$ExternalSyntheticOutline0.m(this.fallbackIconRes, this.targetType.hashCode() * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FallbackArtworkKey(targetType=");
            sb.append(this.targetType);
            sb.append(", fallbackIconRes=");
            sb.append(this.fallbackIconRes);
            sb.append(", cornerRadius=");
            return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.cornerRadius, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaylistSnapshot {
        public final String browseId;
        public final String id;
        public final boolean isLocal;
        public final String name;
        public final String thumbnailUrl;

        public PlaylistSnapshot(String str, String str2, String str3, String str4, boolean z) {
            str.getClass();
            str3.getClass();
            this.id = str;
            this.browseId = str2;
            this.name = str3;
            this.thumbnailUrl = str4;
            this.isLocal = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaylistSnapshot)) {
                return false;
            }
            PlaylistSnapshot playlistSnapshot = (PlaylistSnapshot) obj;
            return Intrinsics.areEqual(this.id, playlistSnapshot.id) && Intrinsics.areEqual(this.browseId, playlistSnapshot.browseId) && Intrinsics.areEqual(this.name, playlistSnapshot.name) && Intrinsics.areEqual(this.thumbnailUrl, playlistSnapshot.thumbnailUrl) && this.isLocal == playlistSnapshot.isLocal;
        }

        public final int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.browseId;
            int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.name);
            String str2 = this.thumbnailUrl;
            return Boolean.hashCode(this.isLocal) + ((iM + (str2 != null ? str2.hashCode() : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaylistSnapshot(id=", this.id, ", browseId=", this.browseId, ", name=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.name, ", thumbnailUrl=", this.thumbnailUrl, ", isLocal=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.isLocal, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class QuickPick {
        public final int fallbackIconRes;
        public final String key;
        public final String targetId;
        public final String targetType;
        public final String thumbnailUrl;
        public final String title;

        public QuickPick(int i, String str, String str2, String str3, String str4, String str5) {
            str3.getClass();
            str4.getClass();
            this.key = str;
            this.targetType = str2;
            this.targetId = str3;
            this.title = str4;
            this.thumbnailUrl = str5;
            this.fallbackIconRes = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuickPick)) {
                return false;
            }
            QuickPick quickPick = (QuickPick) obj;
            return this.key.equals(quickPick.key) && this.targetType.equals(quickPick.targetType) && Intrinsics.areEqual(this.targetId, quickPick.targetId) && Intrinsics.areEqual(this.title, quickPick.title) && Intrinsics.areEqual(this.thumbnailUrl, quickPick.thumbnailUrl) && this.fallbackIconRes == quickPick.fallbackIconRes;
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.key.hashCode() * 31, 31, this.targetType), 31, this.targetId), 31, this.title);
            String str = this.thumbnailUrl;
            return Integer.hashCode(this.fallbackIconRes) + ((iM + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("QuickPick(key=", this.key, ", targetType=", this.targetType, ", targetId=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.targetId, ", title=", this.title, ", thumbnailUrl=");
            sbM.append(this.thumbnailUrl);
            sbM.append(", fallbackIconRes=");
            sbM.append(this.fallbackIconRes);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class QuickPickSnapshot {
        public final List downloadedSongs;
        public final List likedSongs;
        public final List playlists;
        public final List speedDial;
        public final List topSongs;

        public QuickPickSnapshot(List list, List list2, List list3, List list4, List list5) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            list4.getClass();
            list5.getClass();
            this.speedDial = list;
            this.playlists = list2;
            this.likedSongs = list3;
            this.downloadedSongs = list4;
            this.topSongs = list5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuickPickSnapshot)) {
                return false;
            }
            QuickPickSnapshot quickPickSnapshot = (QuickPickSnapshot) obj;
            return Intrinsics.areEqual(this.speedDial, quickPickSnapshot.speedDial) && Intrinsics.areEqual(this.playlists, quickPickSnapshot.playlists) && Intrinsics.areEqual(this.likedSongs, quickPickSnapshot.likedSongs) && Intrinsics.areEqual(this.downloadedSongs, quickPickSnapshot.downloadedSongs) && Intrinsics.areEqual(this.topSongs, quickPickSnapshot.topSongs);
        }

        public final int hashCode() {
            return this.topSongs.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.speedDial.hashCode() * 31, 31, this.playlists), 31, this.likedSongs), 31, this.downloadedSongs);
        }

        public final String toString() {
            return "QuickPickSnapshot(speedDial=" + this.speedDial + ", playlists=" + this.playlists + ", likedSongs=" + this.likedSongs + ", downloadedSongs=" + this.downloadedSongs + ", topSongs=" + this.topSongs + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SongSnapshot {
        public final String id;
        public final String thumbnailUrl;

        public SongSnapshot(String str, String str2) {
            str.getClass();
            this.id = str;
            this.thumbnailUrl = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SongSnapshot)) {
                return false;
            }
            SongSnapshot songSnapshot = (SongSnapshot) obj;
            return Intrinsics.areEqual(this.id, songSnapshot.id) && Intrinsics.areEqual(this.thumbnailUrl, songSnapshot.thumbnailUrl);
        }

        public final int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.thumbnailUrl;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("SongSnapshot(id=", this.id, ", thumbnailUrl=", this.thumbnailUrl, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SpeedDialSnapshot {
        public final String id;
        public final String thumbnailUrl;
        public final String title;
        public final String type;

        public SpeedDialSnapshot(String str, String str2, String str3, String str4) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            this.type = str;
            this.id = str2;
            this.title = str3;
            this.thumbnailUrl = str4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpeedDialSnapshot)) {
                return false;
            }
            SpeedDialSnapshot speedDialSnapshot = (SpeedDialSnapshot) obj;
            return Intrinsics.areEqual(this.type, speedDialSnapshot.type) && Intrinsics.areEqual(this.id, speedDialSnapshot.id) && Intrinsics.areEqual(this.title, speedDialSnapshot.title) && Intrinsics.areEqual(this.thumbnailUrl, speedDialSnapshot.thumbnailUrl);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.type.hashCode() * 31, 31, this.id), 31, this.title);
            String str = this.thumbnailUrl;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("SpeedDialSnapshot(type=", this.type, ", id=", this.id, ", title="), this.title, ", thumbnailUrl=", this.thumbnailUrl, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WidgetState {
        public final String artist;
        public final String artworkUri;
        public final long currentPosition;
        public final long duration;
        public final boolean isLiked;
        public final boolean isPlaying;
        public final String title;

        public WidgetState(String str, String str2, String str3, boolean z, boolean z2, long j, long j2) {
            str.getClass();
            str2.getClass();
            this.title = str;
            this.artist = str2;
            this.artworkUri = str3;
            this.isPlaying = z;
            this.isLiked = z2;
            this.duration = j;
            this.currentPosition = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WidgetState)) {
                return false;
            }
            WidgetState widgetState = (WidgetState) obj;
            return Intrinsics.areEqual(this.title, widgetState.title) && Intrinsics.areEqual(this.artist, widgetState.artist) && Intrinsics.areEqual(this.artworkUri, widgetState.artworkUri) && this.isPlaying == widgetState.isPlaying && this.isLiked == widgetState.isLiked && this.duration == widgetState.duration && this.currentPosition == widgetState.currentPosition;
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.artist);
            String str = this.artworkUri;
            return Long.hashCode(this.currentPosition) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, this.isPlaying, 31), this.isLiked, 31), 31, this.duration);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("WidgetState(title=", this.title, ", artist=", this.artist, ", artworkUri=");
            sbM.append(this.artworkUri);
            sbM.append(", isPlaying=");
            sbM.append(this.isPlaying);
            sbM.append(", isLiked=");
            sbM.append(this.isLiked);
            sbM.append(", duration=");
            sbM.append(this.duration);
            sbM.append(", currentPosition=");
            sbM.append(this.currentPosition);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.widget.PlaylistWidgetManager$bindQuickPicks$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$4;
        public RemoteViews L$0;
        public CardSlot L$10;
        public RemoteViews L$12;
        public Iterator L$7;
        public QuickPick L$9;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaylistWidgetManager.this.bindQuickPicks(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.widget.PlaylistWidgetManager$createRemoteViews$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02201 extends ContinuationImpl {
        public RemoteViews L$5;
        public int label;
        public /* synthetic */ Object result;

        public C02201(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaylistWidgetManager.this.createRemoteViews(null, null, null, null, false, false, 0L, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.widget.PlaylistWidgetManager$getCachedAlbumArt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02211 extends ContinuationImpl {
        public String L$0;
        public int label;
        public /* synthetic */ Object result;

        public C02211(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaylistWidgetManager.this.getCachedAlbumArt(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.widget.PlaylistWidgetManager$updateIdleWidget$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02221 extends ContinuationImpl {
        public int I$0;
        public Bundle L$0;
        public AppWidgetManager L$1;
        public WidgetState L$2;
        public Bitmap L$3;
        public int label;
        public /* synthetic */ Object result;

        public C02221(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaylistWidgetManager.this.updateIdleWidget(0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.widget.PlaylistWidgetManager$updateWidgets$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02231 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$3;
        public long J$0;
        public long J$1;
        public String L$0;
        public String L$1;
        public AppWidgetManager L$3;
        public int[] L$5;
        public Bitmap L$6;
        public List L$7;
        public int[] L$8;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public C02231(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaylistWidgetManager.this.updateWidgets(null, null, null, false, false, 0L, 0L, this);
        }
    }

    public PlaylistWidgetManager(Context context, MusicDatabase musicDatabase, CoroutineScope coroutineScope) {
        musicDatabase.getClass();
        coroutineScope.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.applicationScope = coroutineScope;
        this.fallbackArtworkCache = new ConcurrentHashMap();
        this.roundedAppIconCache = new ConcurrentHashMap();
        String string = context.getString(R.string.not_playing);
        string.getClass();
        String string2 = context.getString(R.string.choose_something_below);
        string2.getClass();
        this.lastWidgetState = new WidgetState(string, string2, null, false, false, 0L, 0L);
        SafeFlow safeFlow = new SafeFlow((byte) 2, musicDatabase.delegate.getSpeedDialDao().getAll());
        FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$1 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(musicDatabase.$$delegate_0.playlistsByCreateDateAsc(), (byte) 1);
        FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$2 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(musicDatabase.$$delegate_0.likedSongsByCreateDateAsc(), (byte) 2);
        FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$3 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(musicDatabase.$$delegate_0.downloadedSongsByCreateDateAsc(), (byte) 3);
        LocalDateTime localDateTimeOf = LocalDateTime.of(1970, 1, 1, 0, 0);
        localDateTimeOf.getClass();
        Continuation continuation = null;
        byte b = 8;
        AwaitKt.launch$default(coroutineScope, null, null, new HazeSourceNode.AnonymousClass1(new DownloadUtil$getDownload$$inlined$map$1(StateFlowKt.debounce(StateFlowKt.distinctUntilChanged(new DownloadUtil$getDownload$$inlined$map$1(new Flow[]{safeFlow, flowKt__LimitKt$take$$inlined$unsafeFlow$1, flowKt__LimitKt$take$$inlined$unsafeFlow$2, flowKt__LimitKt$take$$inlined$unsafeFlow$3, new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(musicDatabase.$$delegate_0.mostPlayedSongs(localDateTimeOf, 50, 0, LocalDateTime.now()), (byte) 4)}, new PlaylistWidgetManager$observeQuickPickChanges$6(null), (byte) 11)), 500L), new PlaylistWidgetManager$observeQuickPickChanges$7(this, continuation, (byte) 0), b), continuation, b), 3);
        this.cardSlots = CollectionsKt__IterablesKt.listOf((Object[]) new CardSlot[]{new CardSlot(R.id.widget_playlist_card_1, R.id.widget_playlist_card_1_art, R.id.widget_playlist_card_1_play_container, R.id.widget_playlist_card_1_play, R.id.widget_playlist_card_1_title), new CardSlot(R.id.widget_playlist_card_2, R.id.widget_playlist_card_2_art, R.id.widget_playlist_card_2_play_container, R.id.widget_playlist_card_2_play, R.id.widget_playlist_card_2_title), new CardSlot(R.id.widget_playlist_card_3, R.id.widget_playlist_card_3_art, R.id.widget_playlist_card_3_play_container, R.id.widget_playlist_card_3_play, R.id.widget_playlist_card_3_title), new CardSlot(R.id.widget_playlist_card_4, R.id.widget_playlist_card_4_art, R.id.widget_playlist_card_4_play_container, R.id.widget_playlist_card_4_play, R.id.widget_playlist_card_4_title), new CardSlot(R.id.widget_playlist_card_5, R.id.widget_playlist_card_5_art, R.id.widget_playlist_card_5_play_container, R.id.widget_playlist_card_5_play, R.id.widget_playlist_card_5_title), new CardSlot(R.id.widget_playlist_card_6, R.id.widget_playlist_card_6_art, R.id.widget_playlist_card_6_play_container, R.id.widget_playlist_card_6_play, R.id.widget_playlist_card_6_title), new CardSlot(R.id.widget_playlist_card_7, R.id.widget_playlist_card_7_art, R.id.widget_playlist_card_7_play_container, R.id.widget_playlist_card_7_play, R.id.widget_playlist_card_7_title), new CardSlot(R.id.widget_playlist_card_8, R.id.widget_playlist_card_8_art, R.id.widget_playlist_card_8_play_container, R.id.widget_playlist_card_8_play, R.id.widget_playlist_card_8_title)});
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        bitmapCreateBitmap.getClass();
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap2.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        float f2 = iMin;
        canvas.drawRoundRect(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f2, f2), f, f, paint);
        if (!bitmapCreateBitmap.equals(bitmap)) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public static QuickPick toQuickPick(Playlist playlist) {
        PlaylistEntity playlistEntity = playlist.playlist;
        String str = playlistEntity.browseId;
        boolean z = (str == null || playlistEntity.isLocal) ? false : true;
        String strM = z ? Fragment$5$$ExternalSyntheticOutline0.m("online:", str) : Fragment$5$$ExternalSyntheticOutline0.m("local:", playlistEntity.id);
        String str2 = z ? "online" : "local";
        if (str == null) {
            str = playlistEntity.id;
        }
        return new QuickPick(R.drawable.playlist_play, strM, str2, str, playlistEntity.name, (String) CollectionsKt.firstOrNull(playlist.getThumbnails()));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0255  */
    /* JADX WARN: Code duplicated, block: B:103:0x025b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0262  */
    /* JADX WARN: Code duplicated, block: B:62:0x0126  */
    /* JADX WARN: Code duplicated, block: B:64:0x012e  */
    /* JADX WARN: Code duplicated, block: B:66:0x014d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0176 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x0177  */
    /* JADX WARN: Code duplicated, block: B:74:0x0194  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:78:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x020b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0213  */
    /* JADX WARN: Code duplicated, block: B:92:0x021c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0225  */
    /* JADX WARN: Code duplicated, block: B:95:0x022e  */
    /* JADX WARN: Code duplicated, block: B:98:0x024c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0251  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0177 -> B:70:0x017e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object bindQuickPicks(android.widget.RemoteViews r21, android.os.Bundle r22, java.util.List r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            Method dump skipped, instruction units count: 746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.widget.PlaylistWidgetManager.bindQuickPicks(android.widget.RemoteViews, android.os.Bundle, java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object createRemoteViews(Bundle bundle, String str, String str2, Bitmap bitmap, boolean z, boolean z2, long j, long j2, List list, ContinuationImpl continuationImpl) throws PackageManager.NameNotFoundException {
        C02201 c02201;
        if (continuationImpl instanceof C02201) {
            c02201 = (C02201) continuationImpl;
            int i = c02201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02201.label = i - Integer.MIN_VALUE;
            } else {
                c02201 = new C02201(continuationImpl);
            }
        } else {
            c02201 = new C02201(continuationImpl);
        }
        Object obj = c02201.result;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c02201.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            RemoteViews remoteViews = c02201.L$5;
            ResultKt.throwOnFailure(obj);
            return remoteViews;
        }
        ResultKt.throwOnFailure(obj);
        RemoteViews remoteViews2 = new RemoteViews(this.context.getPackageName(), R.layout.widget_playlist);
        remoteViews2.setTextViewText(R.id.widget_playlist_song_title, str);
        remoteViews2.setTextViewText(R.id.widget_playlist_artist_name, str2);
        if (bitmap != null) {
            Bitmap roundedCornerBitmap = this.cachedRoundedAlbumArt;
            if (roundedCornerBitmap == null || this.cachedRoundedSource != bitmap) {
                roundedCornerBitmap = getRoundedCornerBitmap(bitmap, 36.0f);
                this.cachedRoundedSource = bitmap;
                this.cachedRoundedAlbumArt = roundedCornerBitmap;
            }
            remoteViews2.setImageViewBitmap(R.id.widget_playlist_album_art, roundedCornerBitmap);
        } else {
            Context context = this.context;
            ConcurrentHashMap concurrentHashMap = this.roundedAppIconCache;
            Bitmap roundedCornerBitmap2 = (Bitmap) concurrentHashMap.get(36);
            if (roundedCornerBitmap2 == null) {
                Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
                applicationIcon.getClass();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.getClass();
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                applicationIcon.setBounds(0, 0, 300, 300);
                applicationIcon.draw(canvas);
                roundedCornerBitmap2 = getRoundedCornerBitmap(bitmapCreateBitmap, 36.0f);
                concurrentHashMap.put(36, roundedCornerBitmap2);
            }
            remoteViews2.setImageViewBitmap(R.id.widget_playlist_album_art, roundedCornerBitmap2);
        }
        remoteViews2.setImageViewResource(R.id.widget_playlist_play_pause, z ? R.drawable.ic_widget_pause : R.drawable.ic_widget_play);
        remoteViews2.setImageViewResource(R.id.widget_playlist_like_button, z2 ? R.drawable.ic_widget_heart_nav : R.drawable.ic_widget_heart_outline_nav);
        remoteViews2.setInt(R.id.widget_playlist_progress_fill, "setImageLevel", j > 0 ? UuidKt.coerceIn((int) ((j2 / j) * 10000.0d), 0, 10000) : 0);
        Context context2 = this.context;
        PendingIntent activity = PendingIntent.getActivity(context2, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, new Intent(context2, (Class<?>) MainActivity.class), 201326592);
        activity.getClass();
        remoteViews2.setOnClickPendingIntent(R.id.widget_playlist_album_art, activity);
        remoteViews2.setOnClickPendingIntent(R.id.widget_playlist_prev_container, getMusicWidgetIntent(501, "com.metrolist.music.widget.PREVIOUS"));
        remoteViews2.setOnClickPendingIntent(R.id.widget_playlist_play_pause_container, getMusicWidgetIntent(502, "com.metrolist.music.widget.PLAY_PAUSE"));
        remoteViews2.setOnClickPendingIntent(R.id.widget_playlist_next_container, getMusicWidgetIntent(503, "com.metrolist.music.widget.NEXT"));
        remoteViews2.setOnClickPendingIntent(R.id.widget_playlist_like_button, getMusicWidgetIntent(504, "com.metrolist.music.widget.LIKE"));
        c02201.L$5 = remoteViews2;
        c02201.label = 1;
        return bindQuickPicks(remoteViews2, bundle, list, c02201) == obj2 ? obj2 : remoteViews2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getCachedAlbumArt(String str, ContinuationImpl continuationImpl) {
        C02211 c02211;
        if (continuationImpl instanceof C02211) {
            c02211 = (C02211) continuationImpl;
            int i = c02211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02211.label = i - Integer.MIN_VALUE;
            } else {
                c02211 = new C02211(continuationImpl);
            }
        } else {
            c02211 = new C02211(continuationImpl);
        }
        Object objWithContext = c02211.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c02211.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (str == null) {
                this.cachedArtworkUri = null;
                this.cachedAlbumArt = null;
                this.cachedRoundedAlbumArt = null;
                this.cachedRoundedSource = null;
                return null;
            }
            if (!str.equals(this.cachedArtworkUri)) {
                c02211.L$0 = str;
                c02211.label = 1;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new PlaylistWidgetManager$loadBitmap$2(this, str, 240, null), c02211);
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return this.cachedAlbumArt;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        str = c02211.L$0;
        ResultKt.throwOnFailure(objWithContext);
        Bitmap bitmap = (Bitmap) objWithContext;
        this.cachedAlbumArt = bitmap;
        this.cachedRoundedAlbumArt = null;
        this.cachedRoundedSource = null;
        this.cachedArtworkUri = bitmap != null ? str : null;
        return this.cachedAlbumArt;
    }

    public final PendingIntent getMusicWidgetIntent(int i, String str) {
        Context context = this.context;
        Intent intent = new Intent(context, (Class<?>) MusicWidgetReceiver.class);
        intent.setAction(str);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 201326592);
        broadcast.getClass();
        return broadcast;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object updateIdleWidget(int i, Bundle bundle, ContinuationImpl continuationImpl) throws PackageManager.NameNotFoundException {
        C02221 c02221;
        AppWidgetManager appWidgetManager;
        Bundle bundle2;
        WidgetState widgetState;
        int i2;
        Bitmap bitmap;
        int i3;
        AppWidgetManager appWidgetManager2;
        int i4;
        AppWidgetManager appWidgetManager3;
        if (continuationImpl instanceof C02221) {
            c02221 = (C02221) continuationImpl;
            int i5 = c02221.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c02221.label = i5 - Integer.MIN_VALUE;
            } else {
                c02221 = new C02221(continuationImpl);
            }
        } else {
            c02221 = new C02221(continuationImpl);
        }
        C02221 c02222 = c02221;
        Object objCreateRemoteViews = c02222.result;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i6 = c02222.label;
        Continuation continuation = null;
        if (i6 == 0) {
            ResultKt.throwOnFailure(objCreateRemoteViews);
            appWidgetManager = AppWidgetManager.getInstance(this.context);
            WidgetState widgetState2 = this.lastWidgetState;
            String str = widgetState2.artworkUri;
            bundle2 = bundle;
            c02222.L$0 = bundle2;
            c02222.L$1 = appWidgetManager;
            c02222.L$2 = widgetState2;
            c02222.I$0 = i;
            c02222.label = 1;
            Object cachedAlbumArt = getCachedAlbumArt(str, c02222);
            if (cachedAlbumArt != obj) {
                widgetState = widgetState2;
                objCreateRemoteViews = cachedAlbumArt;
                i2 = i;
            }
            return obj;
        }
        if (i6 == 1) {
            i2 = c02222.I$0;
            widgetState = c02222.L$2;
            appWidgetManager = c02222.L$1;
            bundle2 = c02222.L$0;
            ResultKt.throwOnFailure(objCreateRemoteViews);
        } else {
            if (i6 == 2) {
                i2 = c02222.I$0;
                bitmap = c02222.L$3;
                widgetState = c02222.L$2;
                appWidgetManager = c02222.L$1;
                bundle2 = c02222.L$0;
                ResultKt.throwOnFailure(objCreateRemoteViews);
                i3 = i2;
                appWidgetManager2 = appWidgetManager;
                List list = (List) objCreateRemoteViews;
                String str2 = widgetState.title;
                String str3 = widgetState.artist;
                boolean z = widgetState.isPlaying;
                boolean z2 = widgetState.isLiked;
                long j = widgetState.duration;
                long j2 = widgetState.currentPosition;
                c02222.L$0 = null;
                c02222.L$1 = appWidgetManager2;
                c02222.L$2 = null;
                c02222.L$3 = null;
                c02222.I$0 = i3;
                c02222.label = 3;
                objCreateRemoteViews = createRemoteViews(bundle2, str2, str3, bitmap, z, z2, j, j2, list, c02222);
                if (objCreateRemoteViews != obj) {
                    i4 = i3;
                    appWidgetManager3 = appWidgetManager2;
                }
                return obj;
            }
            if (i6 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i4 = c02222.I$0;
            appWidgetManager3 = c02222.L$1;
            ResultKt.throwOnFailure(objCreateRemoteViews);
        }
        appWidgetManager3.updateAppWidget(i4, (RemoteViews) objCreateRemoteViews);
        return Unit.INSTANCE;
        Bitmap bitmap2 = (Bitmap) objCreateRemoteViews;
        c02222.L$0 = bundle2;
        c02222.L$1 = appWidgetManager;
        c02222.L$2 = widgetState;
        c02222.L$3 = bitmap2;
        c02222.I$0 = i2;
        c02222.label = 2;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new PlaylistWidgetManager$buildQuickPicks$2(this, continuation, (byte) 0), c02222);
        if (objWithContext != obj) {
            bitmap = bitmap2;
            objCreateRemoteViews = objWithContext;
            i3 = i2;
            appWidgetManager2 = appWidgetManager;
            List list2 = (List) objCreateRemoteViews;
            String str4 = widgetState.title;
            String str5 = widgetState.artist;
            boolean z3 = widgetState.isPlaying;
            boolean z4 = widgetState.isLiked;
            long j3 = widgetState.duration;
            long j4 = widgetState.currentPosition;
            c02222.L$0 = null;
            c02222.L$1 = appWidgetManager2;
            c02222.L$2 = null;
            c02222.L$3 = null;
            c02222.I$0 = i3;
            c02222.label = 3;
            objCreateRemoteViews = createRemoteViews(bundle2, str4, str5, bitmap, z3, z4, j3, j4, list2, c02222);
            if (objCreateRemoteViews != obj) {
                i4 = i3;
                appWidgetManager3 = appWidgetManager2;
                appWidgetManager3.updateAppWidget(i4, (RemoteViews) objCreateRemoteViews);
                return Unit.INSTANCE;
            }
        }
        return obj;
    }

    public final Object updateIdleWidgets(ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$1) throws PackageManager.NameNotFoundException {
        Context context = this.context;
        String string = context.getString(R.string.not_playing);
        string.getClass();
        String string2 = context.getString(R.string.choose_something_below);
        string2.getClass();
        Object objUpdateWidgets = updateWidgets(string, string2, null, false, false, 0L, 0L, shimmerModifierKt$shimmer$1$1);
        return objUpdateWidgets == CoroutineSingletons.COROUTINE_SUSPENDED ? objUpdateWidgets : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0189  */
    /* JADX WARN: Code duplicated, block: B:35:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01d3 -> B:36:0x01e6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object updateWidgets(java.lang.String r34, java.lang.String r35, java.lang.String r36, boolean r37, boolean r38, long r39, long r41, kotlin.coroutines.jvm.internal.ContinuationImpl r43) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.widget.PlaylistWidgetManager.updateWidgets(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, long, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
