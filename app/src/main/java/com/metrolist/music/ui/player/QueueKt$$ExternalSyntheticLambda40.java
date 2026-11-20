package com.metrolist.music.ui.player;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.utils.ArtistNameAliases;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda40 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Map f$0;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda40(Map map, byte b) {
        this.$r8$classId = b;
        this.f$0 = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Map map = this.f$0;
        switch (b) {
            case 0:
                MediaMetadata.Artist artist = (MediaMetadata.Artist) obj;
                artist.getClass();
                ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist.id, artist.name, map);
            case 1:
                Artist artist2 = (Artist) obj;
                artist2.getClass();
                ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist2.id, artist2.name, map);
            case 2:
                Artist artist3 = (Artist) obj;
                artist3.getClass();
                ArtistNameAliases artistNameAliases3 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist3.id, artist3.name, map);
            case 3:
                Artist artist4 = (Artist) obj;
                artist4.getClass();
                ArtistNameAliases artistNameAliases4 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist4.id, artist4.name, map);
            case 4:
                Artist artist5 = (Artist) obj;
                artist5.getClass();
                ArtistNameAliases artistNameAliases5 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist5.id, artist5.name, map);
            case 5:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                ArtistNameAliases artistNameAliases6 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity.id, artistEntity.name, map);
            case 6:
                ArtistEntity artistEntity2 = (ArtistEntity) obj;
                artistEntity2.getClass();
                ArtistNameAliases artistNameAliases7 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity2.id, artistEntity2.name, map);
            case 7:
                MediaMetadata.Artist artist6 = (MediaMetadata.Artist) obj;
                artist6.getClass();
                ArtistNameAliases artistNameAliases8 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist6.id, artist6.name, map);
            case 8:
                Artist artist7 = (Artist) obj;
                artist7.getClass();
                ArtistNameAliases artistNameAliases9 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist7.id, artist7.name, map);
            case 9:
                Artist artist8 = (Artist) obj;
                artist8.getClass();
                ArtistNameAliases artistNameAliases10 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist8.id, artist8.name, map);
            case 10:
                Artist artist9 = (Artist) obj;
                artist9.getClass();
                ArtistNameAliases artistNameAliases11 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist9.id, artist9.name, map);
            case 11:
                Artist artist10 = (Artist) obj;
                artist10.getClass();
                ArtistNameAliases artistNameAliases12 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist10.id, artist10.name, map);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ArtistEntity artistEntity3 = (ArtistEntity) obj;
                artistEntity3.getClass();
                ArtistNameAliases artistNameAliases13 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity3.id, artistEntity3.name, map);
            case 13:
                Artist artist11 = (Artist) obj;
                artist11.getClass();
                ArtistNameAliases artistNameAliases14 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist11.id, artist11.name, map);
            default:
                ArtistEntity artistEntity4 = (ArtistEntity) obj;
                artistEntity4.getClass();
                ArtistNameAliases artistNameAliases15 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity4.id, artistEntity4.name, map);
        }
    }
}
