package androidx.media3.extractor.jpeg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.GlUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.io.IOException;
import java.io.StringReader;
import okhttp3.internal.http1.HeadersReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class XmpMotionPhotoDescriptionParser {
    public static final String[] MOTION_PHOTO_ATTRIBUTE_NAMES = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    public static final String[] DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static HeadersReader parseInternal(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!GlUtil.isStartTag(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer(null, "Couldn't find xmp metadata");
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        RegularImmutableList motionPhotoV1Directory = RegularImmutableList.EMPTY;
        long j = -9223372036854775807L;
        loop0: do {
            xmlPullParserNewPullParser.next();
            if (GlUtil.isStartTag(xmlPullParserNewPullParser, "rdf:Description")) {
                int i = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    String attributeValue = GlUtil.getAttributeValue(xmlPullParserNewPullParser, MOTION_PHOTO_ATTRIBUTE_NAMES[i2]);
                    if (attributeValue != null) {
                        if (Integer.parseInt(attributeValue) != 1) {
                            break loop0;
                        }
                        int i3 = 0;
                        while (true) {
                            if (i3 < 4) {
                                String attributeValue2 = GlUtil.getAttributeValue(xmlPullParserNewPullParser, DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES[i3]);
                                if (attributeValue2 != null) {
                                    j = Long.parseLong(attributeValue2);
                                    if (j != -1) {
                                        break;
                                    }
                                    break;
                                }
                                i3++;
                            }
                            j = -9223372036854775807L;
                            break;
                        }
                        while (true) {
                            if (i >= 2) {
                                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                                motionPhotoV1Directory = RegularImmutableList.EMPTY;
                                break;
                            }
                            String attributeValue3 = GlUtil.getAttributeValue(xmlPullParserNewPullParser, DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES[i]);
                            if (attributeValue3 != null) {
                                motionPhotoV1Directory = ImmutableList.of((Object) new MotionPhotoDescription$ContainerItem(0L, 0L, "image/jpeg"), (Object) new MotionPhotoDescription$ContainerItem(Long.parseLong(attributeValue3), 0L, "video/mp4"));
                                break;
                            }
                            i++;
                        }
                    }
                }
                return null;
            }
            if (GlUtil.isStartTag(xmlPullParserNewPullParser, "Container:Directory")) {
                motionPhotoV1Directory = parseMotionPhotoV1Directory(xmlPullParserNewPullParser, "Container", "Item");
            } else if (GlUtil.isStartTag(xmlPullParserNewPullParser, "GContainer:Directory")) {
                motionPhotoV1Directory = parseMotionPhotoV1Directory(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!GlUtil.isEndTag(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (motionPhotoV1Directory.isEmpty()) {
            break loop0;
        }
        return new HeadersReader(j, motionPhotoV1Directory);
        return null;
    }

    public static RegularImmutableList parseMotionPhotoV1Directory(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.Builder builder = ImmutableList.builder();
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (GlUtil.isStartTag(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String attributeValue = GlUtil.getAttributeValue(xmlPullParser, strConcat3);
                String attributeValue2 = GlUtil.getAttributeValue(xmlPullParser, strConcat4);
                String attributeValue3 = GlUtil.getAttributeValue(xmlPullParser, strConcat5);
                String attributeValue4 = GlUtil.getAttributeValue(xmlPullParser, strConcat6);
                if (attributeValue == null || attributeValue2 == null) {
                    return RegularImmutableList.EMPTY;
                }
                builder.add((Object) new MotionPhotoDescription$ContainerItem(attributeValue3 != null ? Long.parseLong(attributeValue3) : 0L, attributeValue4 != null ? Long.parseLong(attributeValue4) : 0L, attributeValue));
            }
        } while (!GlUtil.isEndTag(xmlPullParser, strConcat2));
        return builder.build();
    }
}
