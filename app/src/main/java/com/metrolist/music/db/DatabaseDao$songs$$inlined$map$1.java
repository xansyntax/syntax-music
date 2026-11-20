package com.metrolist.music.db;

import androidx.datastore.core.Data;
import androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1;
import androidx.datastore.core.Final;
import androidx.datastore.core.NoValueDataState;
import androidx.datastore.core.ReadException;
import androidx.datastore.core.State;
import androidx.datastore.core.UnInitialized;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.App$onCreate$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.App$onCreate$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseDao$songs$$inlined$map$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseDao$songs$$inlined$map$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, byte b) {
            this.$r8$classId = b;
            this.$this_unsafeFlow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:114:0x023f  */
        /* JADX WARN: Code duplicated, block: B:129:0x0284  */
        /* JADX WARN: Code duplicated, block: B:159:0x0329  */
        /* JADX WARN: Code duplicated, block: B:174:0x036e  */
        /* JADX WARN: Code duplicated, block: B:189:0x03b3  */
        /* JADX WARN: Code duplicated, block: B:204:0x03f8  */
        /* JADX WARN: Code duplicated, block: B:219:0x043d  */
        /* JADX WARN: Code duplicated, block: B:234:0x0482  */
        /* JADX WARN: Code duplicated, block: B:249:0x04c6  */
        /* JADX WARN: Code duplicated, block: B:264:0x050a  */
        /* JADX WARN: Code duplicated, block: B:279:0x054e  */
        /* JADX WARN: Code duplicated, block: B:294:0x0592  */
        /* JADX WARN: Code duplicated, block: B:309:0x05d6  */
        /* JADX WARN: Code duplicated, block: B:324:0x0619  */
        /* JADX WARN: Code duplicated, block: B:339:0x065c  */
        /* JADX WARN: Code duplicated, block: B:357:0x06a4  */
        /* JADX WARN: Code duplicated, block: B:375:0x06ed  */
        /* JADX WARN: Code duplicated, block: B:390:0x073a  */
        /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:405:0x0776  */
        /* JADX WARN: Code duplicated, block: B:420:0x07b2  */
        /* JADX WARN: Code duplicated, block: B:438:0x07f4  */
        /* JADX WARN: Code duplicated, block: B:453:0x0830  */
        /* JADX WARN: Code duplicated, block: B:468:0x086c  */
        /* JADX WARN: Code duplicated, block: B:486:0x08b5  */
        /* JADX WARN: Code duplicated, block: B:517:0x0914  */
        /* JADX WARN: Code duplicated, block: B:54:0x0110  */
        /* JADX WARN: Code duplicated, block: B:84:0x01b5  */
        /* JADX WARN: Code duplicated, block: B:99:0x01fa  */
        /* JADX WARN: Code duplicated, block: B:9:0x0026  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) throws Throwable {
            AnonymousClass1 anonymousClass1;
            DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1;
            App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1 app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1;
            App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1 app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1;
            App$onCreate$1$invokeSuspend$$inlined$map$1$2$1 app$onCreate$1$invokeSuspend$$inlined$map$1$2$1;
            MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1 mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1;
            DatabaseDao$albums$$inlined$map$1$2$1 databaseDao$albums$$inlined$map$1$2$1;
            DatabaseDao$albums$$inlined$map$2$2$1 databaseDao$albums$$inlined$map$2$2$1;
            DatabaseDao$albumsLiked$$inlined$map$1$2$1 databaseDao$albumsLiked$$inlined$map$1$2$1;
            DatabaseDao$albumsLiked$$inlined$map$2$2$1 databaseDao$albumsLiked$$inlined$map$2$2$1;
            DatabaseDao$albumsUploaded$$inlined$map$1$2$1 databaseDao$albumsUploaded$$inlined$map$1$2$1;
            DatabaseDao$albumsUploaded$$inlined$map$2$2$1 databaseDao$albumsUploaded$$inlined$map$2$2$1;
            DatabaseDao$artistSongs$$inlined$map$1$2$1 databaseDao$artistSongs$$inlined$map$1$2$1;
            DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1;
            DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1;
            DatabaseDao$downloadedSongs$$inlined$map$1$2$1 databaseDao$downloadedSongs$$inlined$map$1$2$1;
            DatabaseDao$downloadedSongs$$inlined$map$2$2$1 databaseDao$downloadedSongs$$inlined$map$2$2$1;
            DatabaseDao$likedSongs$$inlined$map$1$2$1 databaseDao$likedSongs$$inlined$map$1$2$1;
            DatabaseDao$likedSongs$$inlined$map$2$2$1 databaseDao$likedSongs$$inlined$map$2$2$1;
            DatabaseDao$playlists$$inlined$map$1$2$1 databaseDao$playlists$$inlined$map$1$2$1;
            DatabaseDao$savedPodcastEpisodes$$inlined$map$1$2$1 databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1;
            DatabaseDao$savedPodcastEpisodes$$inlined$map$2$2$1 databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1;
            DatabaseDao$songs$$inlined$map$2$2$1 databaseDao$songs$$inlined$map$2$2$1;
            DatabaseDao$uploadedSongs$$inlined$map$1$2$1 databaseDao$uploadedSongs$$inlined$map$1$2$1;
            DatabaseDao$uploadedSongs$$inlined$map$2$2$1 databaseDao$uploadedSongs$$inlined$map$2$2$1;
            byte b = this.$r8$classId;
            byte b2 = 2;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Unit unit = Unit.INSTANCE;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b3 = 1;
            switch (b) {
                case 0:
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj3 = anonymousClass1.result;
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        Object objSortedWith = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), objArr == true ? 1 : 0));
                        anonymousClass1.label = 1;
                        return flowCollector.emit(objSortedWith, anonymousClass1) == obj2 ? obj2 : unit;
                    }
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj3);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    if (continuation instanceof DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1) {
                        dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 = (DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i3 = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 = new DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 = new DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj4 = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i4 = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj4);
                        State state = (State) obj;
                        if (state instanceof ReadException) {
                            throw ((ReadException) state).readException;
                        }
                        if (state instanceof Data) {
                            Object obj5 = ((Data) state).value;
                            dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                            return flowCollector.emit(obj5, dataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                        }
                        if ((state instanceof Final) || (state instanceof UnInitialized) || (state instanceof NoValueDataState)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                    } else {
                        if (i4 == 1) {
                            ResultKt.throwOnFailure(obj4);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                case 2:
                    if (continuation instanceof App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1) {
                        app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1 = (App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i5 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1 = new App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1 = new App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj6 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i6 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            ResultKt.throwOnFailure(obj6);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                    Integer num = (Integer) ((MutablePreferences) obj).get(PreferenceKeysKt.MaxImageCacheSizeKey);
                    Object num2 = new Integer(num != null ? num.intValue() : 512);
                    app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(num2, app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                case 3:
                    if (continuation instanceof App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i7 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj7 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i8 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i8 == 0) {
                        ResultKt.throwOnFailure(obj7);
                        Object obj8 = ((MutablePreferences) obj).get(PreferenceKeysKt.VisitorDataKey);
                        app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj8, app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj7);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    if (continuation instanceof App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i9 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj9 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1.result;
                    int i10 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj9);
                        Object obj10 = ((MutablePreferences) obj).get(PreferenceKeysKt.DataSyncIdKey);
                        app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj10, app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj9);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 5:
                    if (continuation instanceof App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i11 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj11 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1.result;
                    int i12 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj11);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                    Object obj12 = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.InnerTubeAuthUserKey);
                    if (obj12 == null) {
                        obj12 = "0";
                    }
                    app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(obj12, app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                case 6:
                    if (continuation instanceof App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i13 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj13 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1.result;
                    int i14 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i14 == 0) {
                        ResultKt.throwOnFailure(obj13);
                        Object obj14 = ((MutablePreferences) obj).get(PreferenceKeysKt.InnerTubeCookieKey);
                        app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj14, app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i14 == 1) {
                        ResultKt.throwOnFailure(obj13);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 7:
                    if (continuation instanceof App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i15 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj15 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1.result;
                    int i16 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i16 == 0) {
                        ResultKt.throwOnFailure(obj15);
                        Object obj16 = ((MutablePreferences) obj).get(PreferenceKeysKt.LastFMSessionKey);
                        app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj16, app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj15);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 8:
                    if (continuation instanceof App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1) {
                        app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1 = (App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i17 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1 = new App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj17 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1.result;
                    int i18 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            ResultKt.throwOnFailure(obj17);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj17);
                    MutablePreferences mutablePreferences = (MutablePreferences) obj;
                    Object triple = new Triple(mutablePreferences.get(PreferenceKeysKt.ContentCountryKey), mutablePreferences.get(PreferenceKeysKt.ContentLanguageKey), mutablePreferences.get(PreferenceKeysKt.AppLanguageKey));
                    app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple, app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                case 9:
                    if (continuation instanceof App$onCreate$1$invokeSuspend$$inlined$map$1$2$1) {
                        app$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = (App$onCreate$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i19 = app$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            app$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            app$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = new App$onCreate$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        app$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = new App$onCreate$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj18 = app$onCreate$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i20 = app$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            ResultKt.throwOnFailure(obj18);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj18);
                    Integer num3 = (Integer) ((MutablePreferences) obj).get(PreferenceKeysKt.MaxImageCacheSizeKey);
                    Object num4 = new Integer(num3 != null ? num3.intValue() : 512);
                    app$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(num4, app$onCreate$1$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                case 10:
                    if (continuation instanceof MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1) {
                        mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = (MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i21 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = new MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1 = new MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj19 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i22 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i22 != 0) {
                        if (i22 == 1) {
                            ResultKt.throwOnFailure(obj19);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj19);
                    Boolean bool = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.DisableScreenshotKey);
                    Object objValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
                    mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(objValueOf, mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                case 11:
                    if (continuation instanceof DatabaseDao$albums$$inlined$map$1$2$1) {
                        databaseDao$albums$$inlined$map$1$2$1 = (DatabaseDao$albums$$inlined$map$1$2$1) continuation;
                        int i23 = databaseDao$albums$$inlined$map$1$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albums$$inlined$map$1$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albums$$inlined$map$1$2$1 = new DatabaseDao$albums$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albums$$inlined$map$1$2$1 = new DatabaseDao$albums$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj20 = databaseDao$albums$$inlined$map$1$2$1.result;
                    int i24 = databaseDao$albums$$inlined$map$1$2$1.label;
                    if (i24 == 0) {
                        ResultKt.throwOnFailure(obj20);
                        Object objSortedWith2 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), b3));
                        databaseDao$albums$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith2, databaseDao$albums$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i24 == 1) {
                        ResultKt.throwOnFailure(obj20);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof DatabaseDao$albums$$inlined$map$2$2$1) {
                        databaseDao$albums$$inlined$map$2$2$1 = (DatabaseDao$albums$$inlined$map$2$2$1) continuation;
                        int i25 = databaseDao$albums$$inlined$map$2$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albums$$inlined$map$2$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albums$$inlined$map$2$2$1 = new DatabaseDao$albums$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albums$$inlined$map$2$2$1 = new DatabaseDao$albums$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj21 = databaseDao$albums$$inlined$map$2$2$1.result;
                    int i26 = databaseDao$albums$$inlined$map$2$2$1.label;
                    if (i26 == 0) {
                        ResultKt.throwOnFailure(obj21);
                        Object objSortedWith3 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), b2));
                        databaseDao$albums$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith3, databaseDao$albums$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i26 == 1) {
                        ResultKt.throwOnFailure(obj21);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 13:
                    if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$1$2$1) {
                        databaseDao$albumsLiked$$inlined$map$1$2$1 = (DatabaseDao$albumsLiked$$inlined$map$1$2$1) continuation;
                        int i27 = databaseDao$albumsLiked$$inlined$map$1$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsLiked$$inlined$map$1$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsLiked$$inlined$map$1$2$1 = new DatabaseDao$albumsLiked$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsLiked$$inlined$map$1$2$1 = new DatabaseDao$albumsLiked$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj22 = databaseDao$albumsLiked$$inlined$map$1$2$1.result;
                    int i28 = databaseDao$albumsLiked$$inlined$map$1$2$1.label;
                    if (i28 == 0) {
                        ResultKt.throwOnFailure(obj22);
                        Object objSortedWith4 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 3));
                        databaseDao$albumsLiked$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith4, databaseDao$albumsLiked$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i28 == 1) {
                        ResultKt.throwOnFailure(obj22);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 14:
                    if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$2$2$1) {
                        databaseDao$albumsLiked$$inlined$map$2$2$1 = (DatabaseDao$albumsLiked$$inlined$map$2$2$1) continuation;
                        int i29 = databaseDao$albumsLiked$$inlined$map$2$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsLiked$$inlined$map$2$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsLiked$$inlined$map$2$2$1 = new DatabaseDao$albumsLiked$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsLiked$$inlined$map$2$2$1 = new DatabaseDao$albumsLiked$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj23 = databaseDao$albumsLiked$$inlined$map$2$2$1.result;
                    int i30 = databaseDao$albumsLiked$$inlined$map$2$2$1.label;
                    if (i30 == 0) {
                        ResultKt.throwOnFailure(obj23);
                        Object objSortedWith5 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 4));
                        databaseDao$albumsLiked$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith5, databaseDao$albumsLiked$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i30 == 1) {
                        ResultKt.throwOnFailure(obj23);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 15:
                    if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$1$2$1) {
                        databaseDao$albumsUploaded$$inlined$map$1$2$1 = (DatabaseDao$albumsUploaded$$inlined$map$1$2$1) continuation;
                        int i31 = databaseDao$albumsUploaded$$inlined$map$1$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsUploaded$$inlined$map$1$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsUploaded$$inlined$map$1$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$1$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj24 = databaseDao$albumsUploaded$$inlined$map$1$2$1.result;
                    int i32 = databaseDao$albumsUploaded$$inlined$map$1$2$1.label;
                    if (i32 == 0) {
                        ResultKt.throwOnFailure(obj24);
                        Object objSortedWith6 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 5));
                        databaseDao$albumsUploaded$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith6, databaseDao$albumsUploaded$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i32 == 1) {
                        ResultKt.throwOnFailure(obj24);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 16:
                    if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$2$2$1) {
                        databaseDao$albumsUploaded$$inlined$map$2$2$1 = (DatabaseDao$albumsUploaded$$inlined$map$2$2$1) continuation;
                        int i33 = databaseDao$albumsUploaded$$inlined$map$2$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsUploaded$$inlined$map$2$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsUploaded$$inlined$map$2$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$2$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj25 = databaseDao$albumsUploaded$$inlined$map$2$2$1.result;
                    int i34 = databaseDao$albumsUploaded$$inlined$map$2$2$1.label;
                    if (i34 == 0) {
                        ResultKt.throwOnFailure(obj25);
                        Object objSortedWith7 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 6));
                        databaseDao$albumsUploaded$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith7, databaseDao$albumsUploaded$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i34 == 1) {
                        ResultKt.throwOnFailure(obj25);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 17:
                    if (continuation instanceof DatabaseDao$artistSongs$$inlined$map$1$2$1) {
                        databaseDao$artistSongs$$inlined$map$1$2$1 = (DatabaseDao$artistSongs$$inlined$map$1$2$1) continuation;
                        int i35 = databaseDao$artistSongs$$inlined$map$1$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            databaseDao$artistSongs$$inlined$map$1$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$artistSongs$$inlined$map$1$2$1 = new DatabaseDao$artistSongs$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$artistSongs$$inlined$map$1$2$1 = new DatabaseDao$artistSongs$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj26 = databaseDao$artistSongs$$inlined$map$1$2$1.result;
                    int i36 = databaseDao$artistSongs$$inlined$map$1$2$1.label;
                    if (i36 == 0) {
                        ResultKt.throwOnFailure(obj26);
                        Object objSortedWith8 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 7));
                        databaseDao$artistSongs$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith8, databaseDao$artistSongs$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i36 == 1) {
                        ResultKt.throwOnFailure(obj26);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 18:
                    if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1) continuation;
                        int i37 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj27 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1.result;
                    int i38 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1.label;
                    if (i38 == 0) {
                        ResultKt.throwOnFailure(obj27);
                        Object objSortedWith9 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 8));
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith9, databaseDao$downloadedPodcastEpisodes$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i38 == 1) {
                        ResultKt.throwOnFailure(obj27);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 19:
                    if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1) continuation;
                        int i39 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj28 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1.result;
                    int i40 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1.label;
                    if (i40 == 0) {
                        ResultKt.throwOnFailure(obj28);
                        Object objSortedWith10 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 9));
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith10, databaseDao$downloadedPodcastEpisodes$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i40 == 1) {
                        ResultKt.throwOnFailure(obj28);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 20:
                    if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$1$2$1) {
                        databaseDao$downloadedSongs$$inlined$map$1$2$1 = (DatabaseDao$downloadedSongs$$inlined$map$1$2$1) continuation;
                        int i41 = databaseDao$downloadedSongs$$inlined$map$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedSongs$$inlined$map$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedSongs$$inlined$map$1$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$1$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj29 = databaseDao$downloadedSongs$$inlined$map$1$2$1.result;
                    int i42 = databaseDao$downloadedSongs$$inlined$map$1$2$1.label;
                    if (i42 == 0) {
                        ResultKt.throwOnFailure(obj29);
                        Object objSortedWith11 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 10));
                        databaseDao$downloadedSongs$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith11, databaseDao$downloadedSongs$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i42 == 1) {
                        ResultKt.throwOnFailure(obj29);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 21:
                    if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$2$2$1) {
                        databaseDao$downloadedSongs$$inlined$map$2$2$1 = (DatabaseDao$downloadedSongs$$inlined$map$2$2$1) continuation;
                        int i43 = databaseDao$downloadedSongs$$inlined$map$2$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedSongs$$inlined$map$2$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedSongs$$inlined$map$2$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$2$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj30 = databaseDao$downloadedSongs$$inlined$map$2$2$1.result;
                    int i44 = databaseDao$downloadedSongs$$inlined$map$2$2$1.label;
                    if (i44 == 0) {
                        ResultKt.throwOnFailure(obj30);
                        Object objSortedWith12 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 11));
                        databaseDao$downloadedSongs$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith12, databaseDao$downloadedSongs$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i44 == 1) {
                        ResultKt.throwOnFailure(obj30);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 22:
                    if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$1$2$1) {
                        databaseDao$likedSongs$$inlined$map$1$2$1 = (DatabaseDao$likedSongs$$inlined$map$1$2$1) continuation;
                        int i45 = databaseDao$likedSongs$$inlined$map$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            databaseDao$likedSongs$$inlined$map$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$likedSongs$$inlined$map$1$2$1 = new DatabaseDao$likedSongs$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$likedSongs$$inlined$map$1$2$1 = new DatabaseDao$likedSongs$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj31 = databaseDao$likedSongs$$inlined$map$1$2$1.result;
                    int i46 = databaseDao$likedSongs$$inlined$map$1$2$1.label;
                    if (i46 == 0) {
                        ResultKt.throwOnFailure(obj31);
                        Object objSortedWith13 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 12));
                        databaseDao$likedSongs$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith13, databaseDao$likedSongs$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i46 == 1) {
                        ResultKt.throwOnFailure(obj31);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 23:
                    if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$2$2$1) {
                        databaseDao$likedSongs$$inlined$map$2$2$1 = (DatabaseDao$likedSongs$$inlined$map$2$2$1) continuation;
                        int i47 = databaseDao$likedSongs$$inlined$map$2$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            databaseDao$likedSongs$$inlined$map$2$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$likedSongs$$inlined$map$2$2$1 = new DatabaseDao$likedSongs$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$likedSongs$$inlined$map$2$2$1 = new DatabaseDao$likedSongs$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj32 = databaseDao$likedSongs$$inlined$map$2$2$1.result;
                    int i48 = databaseDao$likedSongs$$inlined$map$2$2$1.label;
                    if (i48 != 0) {
                        if (i48 == 1) {
                            ResultKt.throwOnFailure(obj32);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj32);
                    List listSortedWith = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 13));
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj33 : listSortedWith) {
                        AlbumEntity albumEntity = ((Song) obj33).album;
                        String str = albumEntity != null ? albumEntity.title : null;
                        Object arrayList = linkedHashMap.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            linkedHashMap.put(str, arrayList);
                        }
                        ((List) arrayList).add(obj33);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(CollectionsKt.sortedWith((List) ((Map.Entry) it.next()).getValue(), new DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1(b3)), arrayList2);
                    }
                    databaseDao$likedSongs$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(arrayList2, databaseDao$likedSongs$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                case 24:
                    if (continuation instanceof DatabaseDao$playlists$$inlined$map$1$2$1) {
                        databaseDao$playlists$$inlined$map$1$2$1 = (DatabaseDao$playlists$$inlined$map$1$2$1) continuation;
                        int i49 = databaseDao$playlists$$inlined$map$1$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            databaseDao$playlists$$inlined$map$1$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$playlists$$inlined$map$1$2$1 = new DatabaseDao$playlists$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$playlists$$inlined$map$1$2$1 = new DatabaseDao$playlists$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj34 = databaseDao$playlists$$inlined$map$1$2$1.result;
                    int i50 = databaseDao$playlists$$inlined$map$1$2$1.label;
                    if (i50 == 0) {
                        ResultKt.throwOnFailure(obj34);
                        Object objSortedWith14 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 14));
                        databaseDao$playlists$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith14, databaseDao$playlists$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i50 == 1) {
                        ResultKt.throwOnFailure(obj34);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 25:
                    if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$1$2$1) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$1$2$1) continuation;
                        int i51 = databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj35 = databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1.result;
                    int i52 = databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1.label;
                    if (i52 == 0) {
                        ResultKt.throwOnFailure(obj35);
                        Object objSortedWith15 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 15));
                        databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith15, databaseDao$savedPodcastEpisodes$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i52 == 1) {
                        ResultKt.throwOnFailure(obj35);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 26:
                    if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$2$2$1) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$2$2$1) continuation;
                        int i53 = databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1.label;
                        if ((i53 & Integer.MIN_VALUE) != 0) {
                            databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1.label = i53 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj36 = databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1.result;
                    int i54 = databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1.label;
                    if (i54 == 0) {
                        ResultKt.throwOnFailure(obj36);
                        Object objSortedWith16 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 16));
                        databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(objSortedWith16, databaseDao$savedPodcastEpisodes$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i54 == 1) {
                        ResultKt.throwOnFailure(obj36);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 27:
                    if (continuation instanceof DatabaseDao$songs$$inlined$map$2$2$1) {
                        databaseDao$songs$$inlined$map$2$2$1 = (DatabaseDao$songs$$inlined$map$2$2$1) continuation;
                        int i55 = databaseDao$songs$$inlined$map$2$2$1.label;
                        if ((i55 & Integer.MIN_VALUE) != 0) {
                            databaseDao$songs$$inlined$map$2$2$1.label = i55 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$songs$$inlined$map$2$2$1 = new DatabaseDao$songs$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$songs$$inlined$map$2$2$1 = new DatabaseDao$songs$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj37 = databaseDao$songs$$inlined$map$2$2$1.result;
                    int i56 = databaseDao$songs$$inlined$map$2$2$1.label;
                    if (i56 != 0) {
                        if (i56 == 1) {
                            ResultKt.throwOnFailure(obj37);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj37);
                    List listSortedWith2 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 17));
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Object obj38 : listSortedWith2) {
                        AlbumEntity albumEntity2 = ((Song) obj38).album;
                        String str2 = albumEntity2 != null ? albumEntity2.title : null;
                        Object arrayList3 = linkedHashMap2.get(str2);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            linkedHashMap2.put(str2, arrayList3);
                        }
                        ((List) arrayList3).add(obj38);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = linkedHashMap2.entrySet().iterator();
                    while (it2.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(CollectionsKt.sortedWith((List) ((Map.Entry) it2.next()).getValue(), new DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1(objArr2 == true ? 1 : 0)), arrayList4);
                    }
                    databaseDao$songs$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(arrayList4, databaseDao$songs$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
                case 28:
                    if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$1$2$1) {
                        databaseDao$uploadedSongs$$inlined$map$1$2$1 = (DatabaseDao$uploadedSongs$$inlined$map$1$2$1) continuation;
                        int i57 = databaseDao$uploadedSongs$$inlined$map$1$2$1.label;
                        if ((i57 & Integer.MIN_VALUE) != 0) {
                            databaseDao$uploadedSongs$$inlined$map$1$2$1.label = i57 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$uploadedSongs$$inlined$map$1$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$1$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj39 = databaseDao$uploadedSongs$$inlined$map$1$2$1.result;
                    int i58 = databaseDao$uploadedSongs$$inlined$map$1$2$1.label;
                    if (i58 == 0) {
                        ResultKt.throwOnFailure(obj39);
                        Object objSortedWith17 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 18));
                        databaseDao$uploadedSongs$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(objSortedWith17, databaseDao$uploadedSongs$$inlined$map$1$2$1) == obj2 ? obj2 : unit;
                    }
                    if (i58 == 1) {
                        ResultKt.throwOnFailure(obj39);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$2$2$1) {
                        databaseDao$uploadedSongs$$inlined$map$2$2$1 = (DatabaseDao$uploadedSongs$$inlined$map$2$2$1) continuation;
                        int i59 = databaseDao$uploadedSongs$$inlined$map$2$2$1.label;
                        if ((i59 & Integer.MIN_VALUE) != 0) {
                            databaseDao$uploadedSongs$$inlined$map$2$2$1.label = i59 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$uploadedSongs$$inlined$map$2$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$2$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj40 = databaseDao$uploadedSongs$$inlined$map$2$2$1.result;
                    int i60 = databaseDao$uploadedSongs$$inlined$map$2$2$1.label;
                    if (i60 != 0) {
                        if (i60 == 1) {
                            ResultKt.throwOnFailure(obj40);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj40);
                    List listSortedWith3 = CollectionsKt.sortedWith((List) obj, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 19));
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Object obj41 : listSortedWith3) {
                        AlbumEntity albumEntity3 = ((Song) obj41).album;
                        String str3 = albumEntity3 != null ? albumEntity3.title : null;
                        Object arrayList5 = linkedHashMap3.get(str3);
                        if (arrayList5 == null) {
                            arrayList5 = new ArrayList();
                            linkedHashMap3.put(str3, arrayList5);
                        }
                        ((List) arrayList5).add(obj41);
                    }
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it3 = linkedHashMap3.entrySet().iterator();
                    while (it3.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(CollectionsKt.sortedWith((List) ((Map.Entry) it3.next()).getValue(), new DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1(b2)), arrayList6);
                    }
                    databaseDao$uploadedSongs$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(arrayList6, databaseDao$uploadedSongs$$inlined$map$2$2$1) == obj2 ? obj2 : unit;
            }
        }
    }

    public /* synthetic */ DatabaseDao$songs$$inlined$map$1(Flow flow, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = flow;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:144:0x0233  */
    /* JADX WARN: Code duplicated, block: B:159:0x026e  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:204:0x031f  */
    /* JADX WARN: Code duplicated, block: B:219:0x035a  */
    /* JADX WARN: Code duplicated, block: B:234:0x0395  */
    /* JADX WARN: Code duplicated, block: B:249:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:264:0x040b  */
    /* JADX WARN: Code duplicated, block: B:279:0x0446  */
    /* JADX WARN: Code duplicated, block: B:294:0x0481  */
    /* JADX WARN: Code duplicated, block: B:309:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:324:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:339:0x0532  */
    /* JADX WARN: Code duplicated, block: B:354:0x056d  */
    /* JADX WARN: Code duplicated, block: B:369:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:384:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:399:0x061b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:414:0x0655  */
    /* JADX WARN: Code duplicated, block: B:429:0x068f  */
    /* JADX WARN: Code duplicated, block: B:444:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:69:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0147  */
    /* JADX WARN: Code duplicated, block: B:99:0x0182  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1 app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1;
        App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1 app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1;
        App$onCreate$1$invokeSuspend$$inlined$map$1$1 app$onCreate$1$invokeSuspend$$inlined$map$1$1;
        MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1 mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1;
        DatabaseDao$albums$$inlined$map$1$1 databaseDao$albums$$inlined$map$1$1;
        DatabaseDao$albums$$inlined$map$2$1 databaseDao$albums$$inlined$map$2$1;
        DatabaseDao$albumsLiked$$inlined$map$1$1 databaseDao$albumsLiked$$inlined$map$1$1;
        DatabaseDao$albumsLiked$$inlined$map$2$1 databaseDao$albumsLiked$$inlined$map$2$1;
        DatabaseDao$albumsUploaded$$inlined$map$1$1 databaseDao$albumsUploaded$$inlined$map$1$1;
        DatabaseDao$albumsUploaded$$inlined$map$2$1 databaseDao$albumsUploaded$$inlined$map$2$1;
        DatabaseDao$artistSongs$$inlined$map$1$1 databaseDao$artistSongs$$inlined$map$1$1;
        DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1;
        DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1;
        DatabaseDao$downloadedSongs$$inlined$map$1$1 databaseDao$downloadedSongs$$inlined$map$1$1;
        DatabaseDao$downloadedSongs$$inlined$map$2$1 databaseDao$downloadedSongs$$inlined$map$2$1;
        DatabaseDao$likedSongs$$inlined$map$1$1 databaseDao$likedSongs$$inlined$map$1$1;
        DatabaseDao$likedSongs$$inlined$map$2$1 databaseDao$likedSongs$$inlined$map$2$1;
        DatabaseDao$playlists$$inlined$map$1$1 databaseDao$playlists$$inlined$map$1$1;
        DatabaseDao$savedPodcastEpisodes$$inlined$map$1$1 databaseDao$savedPodcastEpisodes$$inlined$map$1$1;
        DatabaseDao$savedPodcastEpisodes$$inlined$map$2$1 databaseDao$savedPodcastEpisodes$$inlined$map$2$1;
        DatabaseDao$songs$$inlined$map$2$1 databaseDao$songs$$inlined$map$2$1;
        DatabaseDao$uploadedSongs$$inlined$map$1$1 databaseDao$uploadedSongs$$inlined$map$1$1;
        DatabaseDao$uploadedSongs$$inlined$map$2$1 databaseDao$uploadedSongs$$inlined$map$2$1;
        ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1 listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Flow flow = this.$this_unsafeTransform$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, (byte) 0);
                    anonymousClass1.label = 1;
                    return flow.collect(anonymousClass2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                if (continuation instanceof App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1) {
                    app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1 = (App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i3 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1 = new App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1 = new App$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj2 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1.result;
                int i4 = app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, (byte) 2);
                    app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass3, app$newImageLoader$cacheSize$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i5 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj3 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1.result;
                int i6 = app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, (byte) 3);
                    app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass4, app$observeSettingsChanges$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1) continuation;
                    int i7 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj4 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1.result;
                int i8 = app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, (byte) 4);
                    app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass5, app$observeSettingsChanges$2$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1) continuation;
                    int i9 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj5 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1.result;
                int i10 = app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, (byte) 5);
                    app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass6, app$observeSettingsChanges$3$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1) continuation;
                    int i11 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj6 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1.result;
                int i12 = app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, (byte) 6);
                    app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass7, app$observeSettingsChanges$4$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1) continuation;
                    int i13 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj7 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1.result;
                int i14 = app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, (byte) 7);
                    app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass8, app$observeSettingsChanges$5$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1) {
                    app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1 = (App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1) continuation;
                    int i15 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1 = new App$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj8 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1.result;
                int i16 = app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, (byte) 8);
                    app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass9, app$observeSettingsChanges$6$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof App$onCreate$1$invokeSuspend$$inlined$map$1$1) {
                    app$onCreate$1$invokeSuspend$$inlined$map$1$1 = (App$onCreate$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i17 = app$onCreate$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        app$onCreate$1$invokeSuspend$$inlined$map$1$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        app$onCreate$1$invokeSuspend$$inlined$map$1$1 = new App$onCreate$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    app$onCreate$1$invokeSuspend$$inlined$map$1$1 = new App$onCreate$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj9 = app$onCreate$1$invokeSuspend$$inlined$map$1$1.result;
                int i18 = app$onCreate$1$invokeSuspend$$inlined$map$1$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, (byte) 9);
                    app$onCreate$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass10, app$onCreate$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1) {
                    mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1 = (MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i19 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1 = new MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1 = new MainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj10 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1.result;
                int i20 = mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, (byte) 10);
                    mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass11, mainActivity$onCreate$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof DatabaseDao$albums$$inlined$map$1$1) {
                    databaseDao$albums$$inlined$map$1$1 = (DatabaseDao$albums$$inlined$map$1$1) continuation;
                    int i21 = databaseDao$albums$$inlined$map$1$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albums$$inlined$map$1$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albums$$inlined$map$1$1 = new DatabaseDao$albums$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$albums$$inlined$map$1$1 = new DatabaseDao$albums$$inlined$map$1$1(this, continuation);
                }
                Object obj11 = databaseDao$albums$$inlined$map$1$1.result;
                int i22 = databaseDao$albums$$inlined$map$1$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, (byte) 11);
                    databaseDao$albums$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass12, databaseDao$albums$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof DatabaseDao$albums$$inlined$map$2$1) {
                    databaseDao$albums$$inlined$map$2$1 = (DatabaseDao$albums$$inlined$map$2$1) continuation;
                    int i23 = databaseDao$albums$$inlined$map$2$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albums$$inlined$map$2$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albums$$inlined$map$2$1 = new DatabaseDao$albums$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$albums$$inlined$map$2$1 = new DatabaseDao$albums$$inlined$map$2$1(this, continuation);
                }
                Object obj12 = databaseDao$albums$$inlined$map$2$1.result;
                int i24 = databaseDao$albums$$inlined$map$2$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, (byte) 12);
                    databaseDao$albums$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass13, databaseDao$albums$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$1$1) {
                    databaseDao$albumsLiked$$inlined$map$1$1 = (DatabaseDao$albumsLiked$$inlined$map$1$1) continuation;
                    int i25 = databaseDao$albumsLiked$$inlined$map$1$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsLiked$$inlined$map$1$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsLiked$$inlined$map$1$1 = new DatabaseDao$albumsLiked$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsLiked$$inlined$map$1$1 = new DatabaseDao$albumsLiked$$inlined$map$1$1(this, continuation);
                }
                Object obj13 = databaseDao$albumsLiked$$inlined$map$1$1.result;
                int i26 = databaseDao$albumsLiked$$inlined$map$1$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, (byte) 13);
                    databaseDao$albumsLiked$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass14, databaseDao$albumsLiked$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$2$1) {
                    databaseDao$albumsLiked$$inlined$map$2$1 = (DatabaseDao$albumsLiked$$inlined$map$2$1) continuation;
                    int i27 = databaseDao$albumsLiked$$inlined$map$2$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsLiked$$inlined$map$2$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsLiked$$inlined$map$2$1 = new DatabaseDao$albumsLiked$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsLiked$$inlined$map$2$1 = new DatabaseDao$albumsLiked$$inlined$map$2$1(this, continuation);
                }
                Object obj14 = databaseDao$albumsLiked$$inlined$map$2$1.result;
                int i28 = databaseDao$albumsLiked$$inlined$map$2$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, (byte) 14);
                    databaseDao$albumsLiked$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass15, databaseDao$albumsLiked$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$1$1) {
                    databaseDao$albumsUploaded$$inlined$map$1$1 = (DatabaseDao$albumsUploaded$$inlined$map$1$1) continuation;
                    int i29 = databaseDao$albumsUploaded$$inlined$map$1$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsUploaded$$inlined$map$1$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$1$1 = new DatabaseDao$albumsUploaded$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsUploaded$$inlined$map$1$1 = new DatabaseDao$albumsUploaded$$inlined$map$1$1(this, continuation);
                }
                Object obj15 = databaseDao$albumsUploaded$$inlined$map$1$1.result;
                int i30 = databaseDao$albumsUploaded$$inlined$map$1$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, (byte) 15);
                    databaseDao$albumsUploaded$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass16, databaseDao$albumsUploaded$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$2$1) {
                    databaseDao$albumsUploaded$$inlined$map$2$1 = (DatabaseDao$albumsUploaded$$inlined$map$2$1) continuation;
                    int i31 = databaseDao$albumsUploaded$$inlined$map$2$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsUploaded$$inlined$map$2$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsUploaded$$inlined$map$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$2$1(this, continuation);
                }
                Object obj16 = databaseDao$albumsUploaded$$inlined$map$2$1.result;
                int i32 = databaseDao$albumsUploaded$$inlined$map$2$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, (byte) 16);
                    databaseDao$albumsUploaded$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass17, databaseDao$albumsUploaded$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof DatabaseDao$artistSongs$$inlined$map$1$1) {
                    databaseDao$artistSongs$$inlined$map$1$1 = (DatabaseDao$artistSongs$$inlined$map$1$1) continuation;
                    int i33 = databaseDao$artistSongs$$inlined$map$1$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        databaseDao$artistSongs$$inlined$map$1$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$artistSongs$$inlined$map$1$1 = new DatabaseDao$artistSongs$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$artistSongs$$inlined$map$1$1 = new DatabaseDao$artistSongs$$inlined$map$1$1(this, continuation);
                }
                Object obj17 = databaseDao$artistSongs$$inlined$map$1$1.result;
                int i34 = databaseDao$artistSongs$$inlined$map$1$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, (byte) 17);
                    databaseDao$artistSongs$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass18, databaseDao$artistSongs$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$1) {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$1) continuation;
                    int i35 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$1$1(this, continuation);
                }
                Object obj18 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1.result;
                int i36 = databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, (byte) 18);
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass19, databaseDao$downloadedPodcastEpisodes$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$1) {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$1) continuation;
                    int i37 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$2$1(this, continuation);
                }
                Object obj19 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1.result;
                int i38 = databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, (byte) 19);
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass20, databaseDao$downloadedPodcastEpisodes$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$1$1) {
                    databaseDao$downloadedSongs$$inlined$map$1$1 = (DatabaseDao$downloadedSongs$$inlined$map$1$1) continuation;
                    int i39 = databaseDao$downloadedSongs$$inlined$map$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedSongs$$inlined$map$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$1$1 = new DatabaseDao$downloadedSongs$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedSongs$$inlined$map$1$1 = new DatabaseDao$downloadedSongs$$inlined$map$1$1(this, continuation);
                }
                Object obj20 = databaseDao$downloadedSongs$$inlined$map$1$1.result;
                int i40 = databaseDao$downloadedSongs$$inlined$map$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, (byte) 20);
                    databaseDao$downloadedSongs$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass21, databaseDao$downloadedSongs$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$2$1) {
                    databaseDao$downloadedSongs$$inlined$map$2$1 = (DatabaseDao$downloadedSongs$$inlined$map$2$1) continuation;
                    int i41 = databaseDao$downloadedSongs$$inlined$map$2$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedSongs$$inlined$map$2$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedSongs$$inlined$map$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$2$1(this, continuation);
                }
                Object obj21 = databaseDao$downloadedSongs$$inlined$map$2$1.result;
                int i42 = databaseDao$downloadedSongs$$inlined$map$2$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, (byte) 21);
                    databaseDao$downloadedSongs$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass22, databaseDao$downloadedSongs$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$1$1) {
                    databaseDao$likedSongs$$inlined$map$1$1 = (DatabaseDao$likedSongs$$inlined$map$1$1) continuation;
                    int i43 = databaseDao$likedSongs$$inlined$map$1$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        databaseDao$likedSongs$$inlined$map$1$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$likedSongs$$inlined$map$1$1 = new DatabaseDao$likedSongs$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$likedSongs$$inlined$map$1$1 = new DatabaseDao$likedSongs$$inlined$map$1$1(this, continuation);
                }
                Object obj22 = databaseDao$likedSongs$$inlined$map$1$1.result;
                int i44 = databaseDao$likedSongs$$inlined$map$1$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, (byte) 22);
                    databaseDao$likedSongs$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass23, databaseDao$likedSongs$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$2$1) {
                    databaseDao$likedSongs$$inlined$map$2$1 = (DatabaseDao$likedSongs$$inlined$map$2$1) continuation;
                    int i45 = databaseDao$likedSongs$$inlined$map$2$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        databaseDao$likedSongs$$inlined$map$2$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$likedSongs$$inlined$map$2$1 = new DatabaseDao$likedSongs$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$likedSongs$$inlined$map$2$1 = new DatabaseDao$likedSongs$$inlined$map$2$1(this, continuation);
                }
                Object obj23 = databaseDao$likedSongs$$inlined$map$2$1.result;
                int i46 = databaseDao$likedSongs$$inlined$map$2$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, (byte) 23);
                    databaseDao$likedSongs$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass24, databaseDao$likedSongs$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof DatabaseDao$playlists$$inlined$map$1$1) {
                    databaseDao$playlists$$inlined$map$1$1 = (DatabaseDao$playlists$$inlined$map$1$1) continuation;
                    int i47 = databaseDao$playlists$$inlined$map$1$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        databaseDao$playlists$$inlined$map$1$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$playlists$$inlined$map$1$1 = new DatabaseDao$playlists$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$playlists$$inlined$map$1$1 = new DatabaseDao$playlists$$inlined$map$1$1(this, continuation);
                }
                Object obj24 = databaseDao$playlists$$inlined$map$1$1.result;
                int i48 = databaseDao$playlists$$inlined$map$1$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, (byte) 24);
                    databaseDao$playlists$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass25, databaseDao$playlists$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$1$1) {
                    databaseDao$savedPodcastEpisodes$$inlined$map$1$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$1$1) continuation;
                    int i49 = databaseDao$savedPodcastEpisodes$$inlined$map$1$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$1$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$1$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$savedPodcastEpisodes$$inlined$map$1$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$1$1(this, continuation);
                }
                Object obj25 = databaseDao$savedPodcastEpisodes$$inlined$map$1$1.result;
                int i50 = databaseDao$savedPodcastEpisodes$$inlined$map$1$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, (byte) 25);
                    databaseDao$savedPodcastEpisodes$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass26, databaseDao$savedPodcastEpisodes$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 25:
                if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$2$1) {
                    databaseDao$savedPodcastEpisodes$$inlined$map$2$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$2$1) continuation;
                    int i51 = databaseDao$savedPodcastEpisodes$$inlined$map$2$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$2$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$savedPodcastEpisodes$$inlined$map$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$2$1(this, continuation);
                }
                Object obj26 = databaseDao$savedPodcastEpisodes$$inlined$map$2$1.result;
                int i52 = databaseDao$savedPodcastEpisodes$$inlined$map$2$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, (byte) 26);
                    databaseDao$savedPodcastEpisodes$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass27, databaseDao$savedPodcastEpisodes$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 26:
                if (continuation instanceof DatabaseDao$songs$$inlined$map$2$1) {
                    databaseDao$songs$$inlined$map$2$1 = (DatabaseDao$songs$$inlined$map$2$1) continuation;
                    int i53 = databaseDao$songs$$inlined$map$2$1.label;
                    if ((i53 & Integer.MIN_VALUE) != 0) {
                        databaseDao$songs$$inlined$map$2$1.label = i53 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$songs$$inlined$map$2$1 = new DatabaseDao$songs$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$songs$$inlined$map$2$1 = new DatabaseDao$songs$$inlined$map$2$1(this, continuation);
                }
                Object obj27 = databaseDao$songs$$inlined$map$2$1.result;
                int i54 = databaseDao$songs$$inlined$map$2$1.label;
                if (i54 == 0) {
                    ResultKt.throwOnFailure(obj27);
                    AnonymousClass2 anonymousClass28 = new AnonymousClass2(flowCollector, (byte) 27);
                    databaseDao$songs$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass28, databaseDao$songs$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i54 == 1) {
                    ResultKt.throwOnFailure(obj27);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 27:
                if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$1$1) {
                    databaseDao$uploadedSongs$$inlined$map$1$1 = (DatabaseDao$uploadedSongs$$inlined$map$1$1) continuation;
                    int i55 = databaseDao$uploadedSongs$$inlined$map$1$1.label;
                    if ((i55 & Integer.MIN_VALUE) != 0) {
                        databaseDao$uploadedSongs$$inlined$map$1$1.label = i55 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$1$1 = new DatabaseDao$uploadedSongs$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$uploadedSongs$$inlined$map$1$1 = new DatabaseDao$uploadedSongs$$inlined$map$1$1(this, continuation);
                }
                Object obj28 = databaseDao$uploadedSongs$$inlined$map$1$1.result;
                int i56 = databaseDao$uploadedSongs$$inlined$map$1$1.label;
                if (i56 == 0) {
                    ResultKt.throwOnFailure(obj28);
                    AnonymousClass2 anonymousClass29 = new AnonymousClass2(flowCollector, (byte) 28);
                    databaseDao$uploadedSongs$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass29, databaseDao$uploadedSongs$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i56 == 1) {
                    ResultKt.throwOnFailure(obj28);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 28:
                if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$2$1) {
                    databaseDao$uploadedSongs$$inlined$map$2$1 = (DatabaseDao$uploadedSongs$$inlined$map$2$1) continuation;
                    int i57 = databaseDao$uploadedSongs$$inlined$map$2$1.label;
                    if ((i57 & Integer.MIN_VALUE) != 0) {
                        databaseDao$uploadedSongs$$inlined$map$2$1.label = i57 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$uploadedSongs$$inlined$map$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$2$1(this, continuation);
                }
                Object obj29 = databaseDao$uploadedSongs$$inlined$map$2$1.result;
                int i58 = databaseDao$uploadedSongs$$inlined$map$2$1.label;
                if (i58 == 0) {
                    ResultKt.throwOnFailure(obj29);
                    AnonymousClass2 anonymousClass30 = new AnonymousClass2(flowCollector, (byte) 29);
                    databaseDao$uploadedSongs$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass30, databaseDao$uploadedSongs$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i58 == 1) {
                    ResultKt.throwOnFailure(obj29);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1) {
                    listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1 = (ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i59 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i59 & Integer.MIN_VALUE) != 0) {
                        listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1.label = i59 - Integer.MIN_VALUE;
                    } else {
                        listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1 = new ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1 = new ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj30 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1.result;
                int i60 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1.label;
                if (i60 == 0) {
                    ResultKt.throwOnFailure(obj30);
                    SyncUtils$special$$inlined$map$1.AnonymousClass2 anonymousClass31 = new SyncUtils$special$$inlined$map$1.AnonymousClass2(flowCollector, b2);
                    listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass31, listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i60 == 1) {
                    ResultKt.throwOnFailure(obj30);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
