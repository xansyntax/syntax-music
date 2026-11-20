package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.YouTube$resolveArtistIdMap$9;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ArtistItemsPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.playback.MusicService$startRadioSeamlessly$1$1$relatedPage$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistViewModel$fetchArtistsFromYTM$1 extends SuspendLambda implements Function2 {
    public Object L$0;
    public ArtistViewModel L$1;
    public ArtistPage L$2;
    public ArrayList L$4;
    public Ref$ObjectRef L$5;
    public boolean Z$0;
    public boolean Z$1;
    public boolean Z$2;
    public byte label;
    public final /* synthetic */ ArtistViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistViewModel$fetchArtistsFromYTM$1(ArtistViewModel artistViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = artistViewModel;
    }

    public static final Artist invokeSuspend$lambda$0$resolve(Artist artist, Map map) {
        String str;
        return (artist.id != null || (str = (String) map.get(artist.name)) == null) ? artist : Artist.copy$default(artist, str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ArtistViewModel$fetchArtistsFromYTM$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ArtistViewModel$fetchArtistsFromYTM$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0233  */
    /* JADX WARN: Code duplicated, block: B:102:0x0237  */
    /* JADX WARN: Code duplicated, block: B:105:0x0256 A[LOOP:7: B:103:0x0250->B:105:0x0256, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:107:0x026e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0278  */
    /* JADX WARN: Code duplicated, block: B:111:0x027e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0293 A[LOOP:8: B:112:0x028d->B:114:0x0293, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:119:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:121:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:124:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:126:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:128:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:129:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:131:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:133:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:135:0x02de  */
    /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0314  */
    /* JADX WARN: Code duplicated, block: B:145:0x0324  */
    /* JADX WARN: Code duplicated, block: B:148:0x032e  */
    /* JADX WARN: Code duplicated, block: B:164:0x037d A[Catch: Exception -> 0x0425, TryCatch #3 {Exception -> 0x0425, blocks: (B:162:0x0375, B:164:0x037d, B:165:0x038b, B:172:0x039f, B:175:0x03ac, B:180:0x03c8, B:182:0x03ce, B:183:0x03eb, B:185:0x03f1, B:187:0x03fb, B:189:0x0402), top: B:237:0x0375 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0391 A[Catch: Exception -> 0x002c, TRY_ENTER, TryCatch #1 {Exception -> 0x002c, blocks: (B:8:0x0025, B:167:0x0391, B:169:0x0399, B:178:0x03b8, B:191:0x0412), top: B:233:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:178:0x03b8 A[Catch: Exception -> 0x002c, LOOP:1: B:177:0x03b6->B:178:0x03b8, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x002c, blocks: (B:8:0x0025, B:167:0x0391, B:169:0x0399, B:178:0x03b8, B:191:0x0412), top: B:233:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x03ce A[Catch: Exception -> 0x0425, TryCatch #3 {Exception -> 0x0425, blocks: (B:162:0x0375, B:164:0x037d, B:165:0x038b, B:172:0x039f, B:175:0x03ac, B:180:0x03c8, B:182:0x03ce, B:183:0x03eb, B:185:0x03f1, B:187:0x03fb, B:189:0x0402), top: B:237:0x0375 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x03f1 A[Catch: Exception -> 0x0425, TryCatch #3 {Exception -> 0x0425, blocks: (B:162:0x0375, B:164:0x037d, B:165:0x038b, B:172:0x039f, B:175:0x03ac, B:180:0x03c8, B:182:0x03ce, B:183:0x03eb, B:185:0x03f1, B:187:0x03fb, B:189:0x0402), top: B:237:0x0375 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x042a  */
    /* JADX WARN: Code duplicated, block: B:201:0x044a  */
    /* JADX WARN: Code duplicated, block: B:204:0x0453 A[Catch: Exception -> 0x0421, TRY_LEAVE, TryCatch #4 {Exception -> 0x0421, blocks: (B:193:0x041c, B:199:0x042d, B:200:0x0433, B:202:0x044d, B:204:0x0453), top: B:239:0x041c }] */
    /* JADX WARN: Code duplicated, block: B:219:0x04a3 A[LOOP:3: B:217:0x049d->B:219:0x04a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:222:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:228:0x0513  */
    /* JADX WARN: Code duplicated, block: B:242:0x0399 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x038b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x04dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x04c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:264:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x0474 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0208  */
    /* JADX WARN: Code duplicated, block: B:97:0x0223  */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v25, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        Object objM998artistgIAlus;
        boolean z;
        boolean z2;
        Object obj2;
        ArtistPage artistPage;
        EmptyMap emptyMap;
        ArtistViewModel artistViewModel;
        boolean z3;
        Object objCoroutineScope;
        boolean z4;
        boolean z5;
        ArtistPage artistPage2;
        ArtistViewModel artistViewModel2;
        Artist artist;
        Map map;
        ArrayList arrayList;
        int i;
        Iterator it;
        CoroutineSingletons coroutineSingletons;
        Ref$ObjectRef ref$ObjectRef;
        Object obj3;
        Object obj4;
        ArtistViewModel artistViewModel3;
        List list;
        Iterator it2;
        YTItem yTItem;
        ArtistViewModel artistViewModel4;
        boolean z6;
        boolean z7;
        ArtistPage artistPage3;
        Object objWithContext;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Iterator it3;
        Object objCopy$default;
        Iterator it4;
        Iterator it5;
        CoroutineSingletons coroutineSingletons2;
        Artist artist2;
        Artist artistInvokeSuspend$lambda$0$resolve;
        Artist artist3;
        Artist artistInvokeSuspend$lambda$0$resolve2;
        Artist artist4;
        Artist artistInvokeSuspend$lambda$0$resolve3;
        List list2;
        ArrayList arrayList4;
        Iterator it6;
        ArrayList arrayList5;
        Iterator it7;
        Object obj5;
        Throwable thM1866exceptionOrNullimpl;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int size;
        int i2;
        Object obj6;
        boolean z8;
        Object obj7;
        Throwable thM1866exceptionOrNullimpl2;
        ArrayList arrayList8;
        int iMapCapacity;
        LinkedHashMap linkedHashMap;
        int size2;
        int i3;
        ArrayList arrayList9;
        ArtistViewModel artistViewModel5 = this.this$0;
        Context context = artistViewModel5.context;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            DataStore dataStore = UtilsKt.getDataStore(context);
            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
            Boolean bool = Boolean.FALSE;
            boolean zBooleanValue2 = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
            boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
            zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
            YouTube youTube = YouTube.INSTANCE;
            String str = artistViewModel5.artistId;
            this.Z$0 = zBooleanValue2;
            this.Z$1 = zBooleanValue3;
            this.Z$2 = zBooleanValue;
            this.label = (byte) 1;
            objM998artistgIAlus = youTube.m998artistgIAlus(str, this);
            if (objM998artistgIAlus != coroutineSingletons3) {
                z = zBooleanValue2;
                z2 = zBooleanValue3;
            }
            objCoroutineScope = emptyMap;
            return coroutineSingletons3;
        }
        if (b != 1) {
            if (b != 2) {
                if (b != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z3 = this.Z$2;
                z6 = this.Z$1;
                z7 = this.Z$0;
                ref$ObjectRef = this.L$5;
                arrayList2 = this.L$4;
                artistPage3 = this.L$2;
                artistViewModel4 = this.L$1;
                obj2 = this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                    try {
                        obj7 = ((Result) objWithContext).value;
                        if (obj7 instanceof Result.Failure) {
                            z8 = z3;
                            obj3 = null;
                            thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(obj7);
                            if (thM1866exceptionOrNullimpl2 != null) {
                                thM1866exceptionOrNullimpl2.printStackTrace();
                            }
                            z3 = z8;
                            obj4 = obj2;
                            artistViewModel3 = artistViewModel4;
                            artistPage = artistPage3;
                            z = z7;
                            z2 = z6;
                            ArtistPage artistPageCopy$default = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                            List<ArtistSection> list3 = artistPageCopy$default.sections;
                            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                            for (ArtistSection artistSection : list3) {
                                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                            }
                            arrayList7 = new ArrayList();
                            size = arrayList6.size();
                            i2 = 0;
                            while (i2 < size) {
                                obj6 = arrayList6.get(i2);
                                i2++;
                                if (!((ArtistSection) obj6).items.isEmpty()) {
                                    arrayList7.add(obj6);
                                }
                            }
                            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default, arrayList7));
                            CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(artistViewModel3);
                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                            ?? r13 = obj3;
                            AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, r13, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default, (Object) artistViewModel3, (Continuation) r13, false), 2);
                            StateFlowImpl stateFlowImpl = artistViewModel3._apiSubscribed;
                            Boolean boolValueOf = Boolean.valueOf(artistPageCopy$default.isSubscribed);
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(r13, boolValueOf);
                            obj2 = obj4;
                        } else {
                            List list4 = ((ArtistItemsPage) obj7).items;
                            arrayList8 = new ArrayList();
                            for (Object obj8 : list4) {
                                if (obj8 instanceof SongItem) {
                                    arrayList8.add(obj8);
                                }
                            }
                            iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList8, 10));
                            if (iMapCapacity < 16) {
                                iMapCapacity = 16;
                            }
                            linkedHashMap = new LinkedHashMap(iMapCapacity);
                            size2 = arrayList8.size();
                            i3 = 0;
                            while (i3 < size2) {
                                Object obj9 = arrayList8.get(i3);
                                i3++;
                                SongItem songItem = (SongItem) obj9;
                                linkedHashMap.put(songItem.id, songItem.duration);
                            }
                            if (linkedHashMap.isEmpty()) {
                                z8 = z3;
                                obj3 = null;
                            } else {
                                ArtistSection artistSection2 = (ArtistSection) CollectionsKt.first((List) arrayList2);
                                List<Object> list5 = ((ArtistSection) CollectionsKt.first((List) arrayList2)).items;
                                arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                                for (Object objCopy$default2 : list5) {
                                    if ((objCopy$default2 instanceof SongItem) || ((SongItem) objCopy$default2).duration != null) {
                                        z8 = z3;
                                    } else {
                                        SongItem songItem2 = (SongItem) objCopy$default2;
                                        Integer num = (Integer) linkedHashMap.get(((SongItem) objCopy$default2).id);
                                        if (num == null) {
                                            num = ((SongItem) objCopy$default2).duration;
                                        }
                                        z8 = z3;
                                        obj3 = null;
                                        try {
                                            objCopy$default2 = SongItem.copy$default(songItem2, null, num, null, 131055);
                                        } catch (Exception e) {
                                            e = e;
                                            z3 = z8;
                                            e.printStackTrace();
                                            obj4 = obj2;
                                            artistViewModel3 = artistViewModel4;
                                            artistPage = artistPage3;
                                            z = z7;
                                            z2 = z6;
                                            ArtistPage artistPageCopy$default2 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                                            List<ArtistSection> list6 = artistPageCopy$default2.sections;
                                            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                                            while (r2.hasNext()) {
                                                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                                            }
                                            arrayList7 = new ArrayList();
                                            size = arrayList6.size();
                                            i2 = 0;
                                            while (i2 < size) {
                                                obj6 = arrayList6.get(i2);
                                                i2++;
                                                if (!((ArtistSection) obj6).items.isEmpty()) {
                                                    arrayList7.add(obj6);
                                                }
                                            }
                                            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default2, arrayList7));
                                            CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(artistViewModel3);
                                            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                            ?? r14 = obj3;
                                            AwaitKt.launch$default(viewModelScope2, DefaultIoScheduler.INSTANCE, r14, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default2, (Object) artistViewModel3, (Continuation) r14, false), 2);
                                            StateFlowImpl stateFlowImpl2 = artistViewModel3._apiSubscribed;
                                            Boolean boolValueOf2 = Boolean.valueOf(artistPageCopy$default2.isSubscribed);
                                            stateFlowImpl2.getClass();
                                            stateFlowImpl2.updateState(r14, boolValueOf2);
                                            obj2 = obj4;
                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                            if (thM1866exceptionOrNullimpl != null) {
                                                thM1866exceptionOrNullimpl.printStackTrace();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    arrayList9.add(objCopy$default2);
                                    z3 = z8;
                                }
                                z8 = z3;
                                obj3 = null;
                                ref$ObjectRef.element = CollectionsKt.plus((Iterable) CollectionsKt.drop(arrayList2, 1), (Collection) CollectionsKt__IterablesKt.listOf(ArtistSection.copy$default(artistSection2, arrayList9)));
                            }
                            thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(obj7);
                            if (thM1866exceptionOrNullimpl2 != null) {
                                thM1866exceptionOrNullimpl2.printStackTrace();
                            }
                            z3 = z8;
                            obj4 = obj2;
                            artistViewModel3 = artistViewModel4;
                            artistPage = artistPage3;
                            z = z7;
                            z2 = z6;
                            ArtistPage artistPageCopy$default3 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                            List<ArtistSection> list7 = artistPageCopy$default3.sections;
                            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10));
                            while (r2.hasNext()) {
                                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                            }
                            arrayList7 = new ArrayList();
                            size = arrayList6.size();
                            i2 = 0;
                            while (i2 < size) {
                                obj6 = arrayList6.get(i2);
                                i2++;
                                if (!((ArtistSection) obj6).items.isEmpty()) {
                                    arrayList7.add(obj6);
                                }
                            }
                            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default3, arrayList7));
                            CloseableCoroutineScope viewModelScope3 = ViewModelKt.getViewModelScope(artistViewModel3);
                            DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                            ?? r15 = obj3;
                            AwaitKt.launch$default(viewModelScope3, DefaultIoScheduler.INSTANCE, r15, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default3, (Object) artistViewModel3, (Continuation) r15, false), 2);
                            StateFlowImpl stateFlowImpl3 = artistViewModel3._apiSubscribed;
                            Boolean boolValueOf3 = Boolean.valueOf(artistPageCopy$default3.isSubscribed);
                            stateFlowImpl3.getClass();
                            stateFlowImpl3.updateState(r15, boolValueOf3);
                            obj2 = obj4;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z8 = z3;
                        obj3 = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    z3 = z3;
                    obj3 = null;
                    e.printStackTrace();
                    obj4 = obj2;
                    artistViewModel3 = artistViewModel4;
                    artistPage = artistPage3;
                    z = z7;
                    z2 = z6;
                    ArtistPage artistPageCopy$default4 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                    List<ArtistSection> list8 = artistPageCopy$default4.sections;
                    arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list8, 10));
                    while (r2.hasNext()) {
                        arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                    }
                    arrayList7 = new ArrayList();
                    size = arrayList6.size();
                    i2 = 0;
                    while (i2 < size) {
                        obj6 = arrayList6.get(i2);
                        i2++;
                        if (!((ArtistSection) obj6).items.isEmpty()) {
                            arrayList7.add(obj6);
                        }
                    }
                    artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default4, arrayList7));
                    CloseableCoroutineScope viewModelScope4 = ViewModelKt.getViewModelScope(artistViewModel3);
                    DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                    ?? r16 = obj3;
                    AwaitKt.launch$default(viewModelScope4, DefaultIoScheduler.INSTANCE, r16, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default4, (Object) artistViewModel3, (Continuation) r16, false), 2);
                    StateFlowImpl stateFlowImpl4 = artistViewModel3._apiSubscribed;
                    Boolean boolValueOf4 = Boolean.valueOf(artistPageCopy$default4.isSubscribed);
                    stateFlowImpl4.getClass();
                    stateFlowImpl4.updateState(r16, boolValueOf4);
                    obj2 = obj4;
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                    if (thM1866exceptionOrNullimpl != null) {
                        thM1866exceptionOrNullimpl.printStackTrace();
                    }
                    return Unit.INSTANCE;
                }
                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                if (thM1866exceptionOrNullimpl != null) {
                    thM1866exceptionOrNullimpl.printStackTrace();
                }
                return Unit.INSTANCE;
            }
            z3 = this.Z$2;
            z4 = this.Z$1;
            z5 = this.Z$0;
            artistPage2 = this.L$2;
            ArtistViewModel artistViewModel6 = this.L$1;
            obj2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            obj5 = obj;
            artistViewModel = artistViewModel6;
            artistPage = artistPage2;
            z = z5;
            z2 = z4;
            map = (Map) obj5;
            ArtistViewModel artistViewModel7 = artistViewModel;
            List list9 = artistPage.sections;
            i = 10;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list9, 10));
            it = list9.iterator();
            while (it.hasNext()) {
                ArtistSection artistSection3 = (ArtistSection) it.next();
                List list10 = artistSection3.items;
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list10, i));
                it3 = list10.iterator();
                while (it3.hasNext()) {
                    objCopy$default = (YTItem) it3.next();
                    if (objCopy$default == null) {
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                    } else if (objCopy$default instanceof SongItem) {
                        SongItem songItem3 = (SongItem) objCopy$default;
                        List list11 = songItem3.artists;
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                        arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list11, 10));
                        it7 = list11.iterator();
                        while (it7.hasNext()) {
                            arrayList5.add(invokeSuspend$lambda$0$resolve((Artist) it7.next(), map));
                        }
                        objCopy$default = SongItem.copy$default(songItem3, arrayList5, null, null, 131067);
                    } else {
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                        if (objCopy$default instanceof AlbumItem) {
                            AlbumItem albumItem = (AlbumItem) objCopy$default;
                            list2 = albumItem.artists;
                            if (list2 != null) {
                                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                it6 = list2.iterator();
                                while (it6.hasNext()) {
                                    arrayList4.add(invokeSuspend$lambda$0$resolve((Artist) it6.next(), map));
                                }
                            } else {
                                arrayList4 = null;
                            }
                            objCopy$default = AlbumItem.copy$default(albumItem, arrayList4);
                        } else if (objCopy$default instanceof PlaylistItem) {
                            PlaylistItem playlistItem = (PlaylistItem) objCopy$default;
                            artist4 = playlistItem.author;
                            if (artist4 != null) {
                                artistInvokeSuspend$lambda$0$resolve3 = invokeSuspend$lambda$0$resolve(artist4, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve3 = null;
                            }
                            objCopy$default = PlaylistItem.copy$default(playlistItem, artistInvokeSuspend$lambda$0$resolve3, null, 4091);
                        } else if (objCopy$default instanceof EpisodeItem) {
                            EpisodeItem episodeItem = (EpisodeItem) objCopy$default;
                            artist3 = episodeItem.author;
                            if (artist3 != null) {
                                artistInvokeSuspend$lambda$0$resolve2 = invokeSuspend$lambda$0$resolve(artist3, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve2 = null;
                            }
                            objCopy$default = EpisodeItem.copy$default(episodeItem, artistInvokeSuspend$lambda$0$resolve2);
                        } else if (!(objCopy$default instanceof PodcastItem)) {
                            PodcastItem podcastItem = (PodcastItem) objCopy$default;
                            artist2 = podcastItem.author;
                            if (artist2 != null) {
                                artistInvokeSuspend$lambda$0$resolve = invokeSuspend$lambda$0$resolve(artist2, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve = null;
                            }
                            objCopy$default = PodcastItem.copy$default(podcastItem, artistInvokeSuspend$lambda$0$resolve);
                        }
                    }
                    arrayList3.add(objCopy$default);
                    it = it4;
                    it3 = it5;
                    coroutineSingletons3 = coroutineSingletons2;
                }
                arrayList.add(ArtistSection.copy$default(artistSection3, arrayList3));
                it = it;
                i = 10;
            }
            coroutineSingletons = coroutineSingletons3;
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = arrayList;
            if (!arrayList.isEmpty()) {
                list = ((ArtistSection) CollectionsKt.first((List) arrayList)).items;
                if (!list.isEmpty()) {
                    it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            yTItem = (YTItem) it2.next();
                            if (!(yTItem instanceof SongItem) && ((SongItem) yTItem).duration == null) {
                                BrowseEndpoint browseEndpoint = ((ArtistSection) CollectionsKt.first((List) arrayList)).moreEndpoint;
                                if (browseEndpoint != null) {
                                    try {
                                        DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                        try {
                                            MusicService$startRadioSeamlessly$1$1$relatedPage$1 musicService$startRadioSeamlessly$1$1$relatedPage$1 = new MusicService$startRadioSeamlessly$1$1$relatedPage$1(browseEndpoint, null, (byte) 1);
                                            this.L$0 = obj2;
                                            this.L$1 = artistViewModel7;
                                            this.L$2 = artistPage;
                                            this.L$4 = arrayList;
                                            this.L$5 = ref$ObjectRef;
                                            this.Z$0 = z;
                                            this.Z$1 = z2;
                                            this.Z$2 = z3;
                                            this.label = (byte) 3;
                                            objWithContext = AwaitKt.withContext(defaultIoScheduler, musicService$startRadioSeamlessly$1$1$relatedPage$1, this);
                                            CoroutineSingletons coroutineSingletons4 = coroutineSingletons;
                                            if (objWithContext == coroutineSingletons4) {
                                                return coroutineSingletons4;
                                            }
                                            ArtistPage artistPage4 = artistPage;
                                            artistViewModel4 = artistViewModel7;
                                            z6 = z2;
                                            z7 = z;
                                            artistPage3 = artistPage4;
                                            arrayList2 = arrayList;
                                            obj7 = ((Result) objWithContext).value;
                                            if (obj7 instanceof Result.Failure) {
                                                List list12 = ((ArtistItemsPage) obj7).items;
                                                arrayList8 = new ArrayList();
                                                while (r5.hasNext()) {
                                                    if (obj8 instanceof SongItem) {
                                                        arrayList8.add(obj8);
                                                    }
                                                }
                                                iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList8, 10));
                                                if (iMapCapacity < 16) {
                                                    iMapCapacity = 16;
                                                }
                                                linkedHashMap = new LinkedHashMap(iMapCapacity);
                                                size2 = arrayList8.size();
                                                i3 = 0;
                                                while (i3 < size2) {
                                                    Object obj10 = arrayList8.get(i3);
                                                    i3++;
                                                    SongItem songItem4 = (SongItem) obj10;
                                                    linkedHashMap.put(songItem4.id, songItem4.duration);
                                                }
                                                if (linkedHashMap.isEmpty()) {
                                                    ArtistSection artistSection4 = (ArtistSection) CollectionsKt.first((List) arrayList2);
                                                    List<Object> list13 = ((ArtistSection) CollectionsKt.first((List) arrayList2)).items;
                                                    arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list13, 10));
                                                    while (r6.hasNext()) {
                                                        if (objCopy$default2 instanceof SongItem) {
                                                            z8 = z3;
                                                        } else {
                                                            z8 = z3;
                                                        }
                                                        arrayList9.add(objCopy$default2);
                                                        z3 = z8;
                                                    }
                                                    z8 = z3;
                                                    obj3 = null;
                                                    ref$ObjectRef.element = CollectionsKt.plus((Iterable) CollectionsKt.drop(arrayList2, 1), (Collection) CollectionsKt__IterablesKt.listOf(ArtistSection.copy$default(artistSection4, arrayList9)));
                                                } else {
                                                    z8 = z3;
                                                    obj3 = null;
                                                }
                                                thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(obj7);
                                                if (thM1866exceptionOrNullimpl2 != null) {
                                                    thM1866exceptionOrNullimpl2.printStackTrace();
                                                }
                                                z3 = z8;
                                                obj4 = obj2;
                                                artistViewModel3 = artistViewModel4;
                                                artistPage = artistPage3;
                                                z = z7;
                                                z2 = z6;
                                            } else {
                                                z8 = z3;
                                                obj3 = null;
                                                thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(obj7);
                                                if (thM1866exceptionOrNullimpl2 != null) {
                                                    thM1866exceptionOrNullimpl2.printStackTrace();
                                                }
                                                z3 = z8;
                                                obj4 = obj2;
                                                artistViewModel3 = artistViewModel4;
                                                artistPage = artistPage3;
                                                z = z7;
                                                z2 = z6;
                                            }
                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                            if (thM1866exceptionOrNullimpl != null) {
                                                thM1866exceptionOrNullimpl.printStackTrace();
                                            }
                                            return Unit.INSTANCE;
                                        } catch (Exception e4) {
                                            e = e4;
                                            obj3 = null;
                                            ArtistPage artistPage5 = artistPage;
                                            artistViewModel4 = artistViewModel7;
                                            z6 = z2;
                                            z7 = z;
                                            artistPage3 = artistPage5;
                                            e.printStackTrace();
                                            obj4 = obj2;
                                            artistViewModel3 = artistViewModel4;
                                            artistPage = artistPage3;
                                            z = z7;
                                            z2 = z6;
                                            ArtistPage artistPageCopy$default5 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                                            List<ArtistSection> list14 = artistPageCopy$default5.sections;
                                            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list14, 10));
                                            while (r2.hasNext()) {
                                                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                                            }
                                            arrayList7 = new ArrayList();
                                            size = arrayList6.size();
                                            i2 = 0;
                                            while (i2 < size) {
                                                obj6 = arrayList6.get(i2);
                                                i2++;
                                                if (!((ArtistSection) obj6).items.isEmpty()) {
                                                    arrayList7.add(obj6);
                                                }
                                            }
                                            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default5, arrayList7));
                                            CloseableCoroutineScope viewModelScope5 = ViewModelKt.getViewModelScope(artistViewModel3);
                                            DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                                            ?? r17 = obj3;
                                            AwaitKt.launch$default(viewModelScope5, DefaultIoScheduler.INSTANCE, r17, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default5, (Object) artistViewModel3, (Continuation) r17, false), 2);
                                            StateFlowImpl stateFlowImpl5 = artistViewModel3._apiSubscribed;
                                            Boolean boolValueOf5 = Boolean.valueOf(artistPageCopy$default5.isSubscribed);
                                            stateFlowImpl5.getClass();
                                            stateFlowImpl5.updateState(r17, boolValueOf5);
                                            obj2 = obj4;
                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                            if (thM1866exceptionOrNullimpl != null) {
                                                thM1866exceptionOrNullimpl.printStackTrace();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj3 = null;
                                    }
                                }
                                ArtistPage artistPageCopy$default6 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
                                List<ArtistSection> list15 = artistPageCopy$default6.sections;
                                arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list15, 10));
                                while (r2.hasNext()) {
                                    arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
                                }
                                arrayList7 = new ArrayList();
                                size = arrayList6.size();
                                i2 = 0;
                                while (i2 < size) {
                                    obj6 = arrayList6.get(i2);
                                    i2++;
                                    if (!((ArtistSection) obj6).items.isEmpty()) {
                                        arrayList7.add(obj6);
                                    }
                                }
                                artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default6, arrayList7));
                                CloseableCoroutineScope viewModelScope6 = ViewModelKt.getViewModelScope(artistViewModel3);
                                DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                                ?? r18 = obj3;
                                AwaitKt.launch$default(viewModelScope6, DefaultIoScheduler.INSTANCE, r18, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default6, (Object) artistViewModel3, (Continuation) r18, false), 2);
                                StateFlowImpl stateFlowImpl6 = artistViewModel3._apiSubscribed;
                                Boolean boolValueOf6 = Boolean.valueOf(artistPageCopy$default6.isSubscribed);
                                stateFlowImpl6.getClass();
                                stateFlowImpl6.updateState(r18, boolValueOf6);
                                obj2 = obj4;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                if (thM1866exceptionOrNullimpl != null) {
                                    thM1866exceptionOrNullimpl.printStackTrace();
                                }
                                return Unit.INSTANCE;
                            }
                            coroutineSingletons = coroutineSingletons;
                            z3 = z3;
                        }
                    }
                }
            }
            z3 = z3;
            obj3 = null;
            obj4 = obj2;
            artistViewModel3 = artistViewModel7;
            ArtistPage artistPageCopy$default7 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
            List<ArtistSection> list16 = artistPageCopy$default7.sections;
            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list16, 10));
            while (r2.hasNext()) {
                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
            }
            arrayList7 = new ArrayList();
            size = arrayList6.size();
            i2 = 0;
            while (i2 < size) {
                obj6 = arrayList6.get(i2);
                i2++;
                if (!((ArtistSection) obj6).items.isEmpty()) {
                    arrayList7.add(obj6);
                }
            }
            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default7, arrayList7));
            CloseableCoroutineScope viewModelScope7 = ViewModelKt.getViewModelScope(artistViewModel3);
            DefaultScheduler defaultScheduler8 = Dispatchers.Default;
            ?? r19 = obj3;
            AwaitKt.launch$default(viewModelScope7, DefaultIoScheduler.INSTANCE, r19, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default7, (Object) artistViewModel3, (Continuation) r19, false), 2);
            StateFlowImpl stateFlowImpl7 = artistViewModel3._apiSubscribed;
            Boolean boolValueOf7 = Boolean.valueOf(artistPageCopy$default7.isSubscribed);
            stateFlowImpl7.getClass();
            stateFlowImpl7.updateState(r19, boolValueOf7);
            obj2 = obj4;
            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
            if (thM1866exceptionOrNullimpl != null) {
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        zBooleanValue = this.Z$2;
        z2 = this.Z$1;
        z = this.Z$0;
        ResultKt.throwOnFailure(obj);
        objM998artistgIAlus = ((Result) obj).value;
        obj2 = objM998artistgIAlus;
        if (!(obj2 instanceof Result.Failure)) {
            artistPage = (ArtistPage) obj2;
            List list17 = artistPage.sections;
            ArrayList arrayList10 = new ArrayList();
            Iterator it8 = list17.iterator();
            while (it8.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(((ArtistSection) it8.next()).items, arrayList10);
            }
            boolean zIsEmpty = arrayList10.isEmpty();
            emptyMap = EmptyMap.INSTANCE;
            if (!zIsEmpty) {
                YouTube youTube2 = YouTube.INSTANCE;
                this.L$0 = obj2;
                this.L$1 = artistViewModel5;
                this.L$2 = artistPage;
                this.Z$0 = z;
                this.Z$1 = z2;
                this.Z$2 = zBooleanValue;
                this.label = (byte) 2;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int size3 = arrayList10.size();
                int i4 = 0;
                while (i4 < size3) {
                    Object obj11 = arrayList10.get(i4);
                    i4++;
                    YTItem yTItem2 = (YTItem) obj11;
                    if (yTItem2 == null) {
                        artistViewModel2 = artistViewModel5;
                    } else if (yTItem2 instanceof SongItem) {
                        List list18 = ((SongItem) yTItem2).artists;
                        ArrayList arrayList11 = new ArrayList();
                        for (Object obj12 : list18) {
                            ArtistViewModel artistViewModel8 = artistViewModel5;
                            if (((Artist) obj12).id == null) {
                                arrayList11.add(obj12);
                            }
                            artistViewModel5 = artistViewModel8;
                        }
                        artistViewModel2 = artistViewModel5;
                        int size4 = arrayList11.size();
                        int i5 = 0;
                        while (i5 < size4) {
                            Object obj13 = arrayList11.get(i5);
                            i5++;
                            linkedHashSet.add(((Artist) obj13).name);
                        }
                    } else {
                        artistViewModel2 = artistViewModel5;
                        if (yTItem2 instanceof AlbumItem) {
                            List list19 = ((AlbumItem) yTItem2).artists;
                            if (list19 != null) {
                                ArrayList arrayList12 = new ArrayList();
                                for (Object obj14 : list19) {
                                    if (((Artist) obj14).id == null) {
                                        arrayList12.add(obj14);
                                    }
                                }
                                int size5 = arrayList12.size();
                                int i6 = 0;
                                while (i6 < size5) {
                                    Object obj15 = arrayList12.get(i6);
                                    i6++;
                                    linkedHashSet.add(((Artist) obj15).name);
                                }
                            }
                        } else if (yTItem2 instanceof PlaylistItem) {
                            Artist artist5 = ((PlaylistItem) yTItem2).author;
                            if (artist5 != null && artist5.id == null) {
                                linkedHashSet.add(artist5.name);
                            }
                        } else if (yTItem2 instanceof EpisodeItem) {
                            Artist artist6 = ((EpisodeItem) yTItem2).author;
                            if (artist6 != null && artist6.id == null) {
                                linkedHashSet.add(artist6.name);
                            }
                        } else if ((yTItem2 instanceof PodcastItem) && (artist = ((PodcastItem) yTItem2).author) != null && artist.id == null) {
                            linkedHashSet.add(artist.name);
                        }
                    }
                    artistViewModel5 = artistViewModel2;
                }
                artistViewModel = artistViewModel5;
                if (!linkedHashSet.isEmpty()) {
                    objCoroutineScope = AwaitKt.coroutineScope(new YouTube$resolveArtistIdMap$9(linkedHashSet, null, (byte) 0), this);
                }
                if (objCoroutineScope != coroutineSingletons3) {
                    objCoroutineScope = emptyMap;
                    z3 = zBooleanValue;
                    z4 = z2;
                    z5 = z;
                    artistPage2 = artistPage;
                    obj5 = objCoroutineScope;
                    artistPage = artistPage2;
                    z = z5;
                    z2 = z4;
                    map = (Map) obj5;
                }
                objCoroutineScope = emptyMap;
                return coroutineSingletons3;
            }
            artistViewModel = artistViewModel5;
            z3 = zBooleanValue;
            map = emptyMap;
            ArtistViewModel artistViewModel9 = artistViewModel;
            List list20 = artistPage.sections;
            i = 10;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list20, 10));
            it = list20.iterator();
            while (it.hasNext()) {
                ArtistSection artistSection5 = (ArtistSection) it.next();
                List list110 = artistSection5.items;
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list110, i));
                it3 = list110.iterator();
                while (it3.hasNext()) {
                    objCopy$default = (YTItem) it3.next();
                    if (objCopy$default == null) {
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                    } else if (objCopy$default instanceof SongItem) {
                        SongItem songItem5 = (SongItem) objCopy$default;
                        List list111 = songItem5.artists;
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                        arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list111, 10));
                        it7 = list111.iterator();
                        while (it7.hasNext()) {
                            arrayList5.add(invokeSuspend$lambda$0$resolve((Artist) it7.next(), map));
                        }
                        objCopy$default = SongItem.copy$default(songItem5, arrayList5, null, null, 131067);
                    } else {
                        it4 = it;
                        it5 = it3;
                        coroutineSingletons2 = coroutineSingletons3;
                        if (objCopy$default instanceof AlbumItem) {
                            AlbumItem albumItem2 = (AlbumItem) objCopy$default;
                            list2 = albumItem2.artists;
                            if (list2 != null) {
                                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                it6 = list2.iterator();
                                while (it6.hasNext()) {
                                    arrayList4.add(invokeSuspend$lambda$0$resolve((Artist) it6.next(), map));
                                }
                            } else {
                                arrayList4 = null;
                            }
                            objCopy$default = AlbumItem.copy$default(albumItem2, arrayList4);
                        } else if (objCopy$default instanceof PlaylistItem) {
                            PlaylistItem playlistItem2 = (PlaylistItem) objCopy$default;
                            artist4 = playlistItem2.author;
                            if (artist4 != null) {
                                artistInvokeSuspend$lambda$0$resolve3 = invokeSuspend$lambda$0$resolve(artist4, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve3 = null;
                            }
                            objCopy$default = PlaylistItem.copy$default(playlistItem2, artistInvokeSuspend$lambda$0$resolve3, null, 4091);
                        } else if (objCopy$default instanceof EpisodeItem) {
                            EpisodeItem episodeItem2 = (EpisodeItem) objCopy$default;
                            artist3 = episodeItem2.author;
                            if (artist3 != null) {
                                artistInvokeSuspend$lambda$0$resolve2 = invokeSuspend$lambda$0$resolve(artist3, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve2 = null;
                            }
                            objCopy$default = EpisodeItem.copy$default(episodeItem2, artistInvokeSuspend$lambda$0$resolve2);
                        } else if (!(objCopy$default instanceof PodcastItem)) {
                            PodcastItem podcastItem2 = (PodcastItem) objCopy$default;
                            artist2 = podcastItem2.author;
                            if (artist2 != null) {
                                artistInvokeSuspend$lambda$0$resolve = invokeSuspend$lambda$0$resolve(artist2, map);
                            } else {
                                artistInvokeSuspend$lambda$0$resolve = null;
                            }
                            objCopy$default = PodcastItem.copy$default(podcastItem2, artistInvokeSuspend$lambda$0$resolve);
                        }
                    }
                    arrayList3.add(objCopy$default);
                    it = it4;
                    it3 = it5;
                    coroutineSingletons3 = coroutineSingletons2;
                }
                arrayList.add(ArtistSection.copy$default(artistSection5, arrayList3));
                it = it;
                i = 10;
            }
            coroutineSingletons = coroutineSingletons3;
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = arrayList;
            if (!arrayList.isEmpty()) {
                list = ((ArtistSection) CollectionsKt.first((List) arrayList)).items;
                if (!list.isEmpty()) {
                    it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            yTItem = (YTItem) it2.next();
                            if (!(yTItem instanceof SongItem)) {
                            }
                            coroutineSingletons = coroutineSingletons;
                            z3 = z3;
                        }
                    }
                }
            }
            z3 = z3;
            obj3 = null;
            obj4 = obj2;
            artistViewModel3 = artistViewModel9;
            ArtistPage artistPageCopy$default8 = ArtistPage.copy$default(artistPage, (List) ref$ObjectRef.element);
            List<ArtistSection> list112 = artistPageCopy$default8.sections;
            arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list112, 10));
            while (r2.hasNext()) {
                arrayList6.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, z), z2), z3)));
            }
            arrayList7 = new ArrayList();
            size = arrayList6.size();
            i2 = 0;
            while (i2 < size) {
                obj6 = arrayList6.get(i2);
                i2++;
                if (!((ArtistSection) obj6).items.isEmpty()) {
                    arrayList7.add(obj6);
                }
            }
            artistViewModel3.artistPage$delegate.setValue(ArtistPage.copy$default(artistPageCopy$default8, arrayList7));
            CloseableCoroutineScope viewModelScope8 = ViewModelKt.getViewModelScope(artistViewModel3);
            DefaultScheduler defaultScheduler9 = Dispatchers.Default;
            ?? r110 = obj3;
            AwaitKt.launch$default(viewModelScope8, DefaultIoScheduler.INSTANCE, r110, new DataStoreKt$get$2((byte) 24, (Object) artistPageCopy$default8, (Object) artistViewModel3, (Continuation) r110, false), 2);
            StateFlowImpl stateFlowImpl8 = artistViewModel3._apiSubscribed;
            Boolean boolValueOf8 = Boolean.valueOf(artistPageCopy$default8.isSubscribed);
            stateFlowImpl8.getClass();
            stateFlowImpl8.updateState(r110, boolValueOf8);
            obj2 = obj4;
        }
        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
