package be.cytomine.client.models;

public class AbstractSlice extends Model<AbstractSlice> {

    public AbstractSlice() {}

    public AbstractSlice(AbstractImage image, UploadedFile uploadedFile, String mime, Integer channel, Integer zStack, Integer time) {
        this(image.getId(), uploadedFile.getId(), mime, channel, zStack, time);
    }

    public AbstractSlice(Long imageId, Long uploadedFileId, String mime, Integer channel, Integer zStack, Integer time) {
        this.set("image", imageId);
        this.set("uploadedFile", uploadedFileId);
        this.set("mime", mime);

        this.set("channel", channel);
        this.set("zStack", zStack);
        this.set("time", time);
    }
}
