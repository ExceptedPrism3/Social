package me.prism3.socialbukkit.utils;


/**
 * The Links class represents a link entry.
 * It stores information about a link, such as its header, disabled status, URL, etc.
 */
public class Links {

    private final String header;
    private final boolean isDisabled;
    private final String headLink;
    private final String displayName;
    private final String url;
    private final int slot;

    /**
     * Constructs a new Links object with the specified parameters.
     *
     * @param header      The header of the link.
     * @param isDisabled  The disabled status of the link.
     * @param headLink    The head link associated with the link.
     * @param displayName The display name of the link.
     * @param url         The URL of the link.
     * @param slot        The slot number of the link.
     */
    public Links(final String header, final boolean isDisabled, final String headLink, final String displayName, final String url, final int slot) {
        this.header = header;
        this.isDisabled = isDisabled;
        this.headLink = headLink;
        this.displayName = displayName;
        this.url = url;
        this.slot = slot;
    }

    /**
     * Retrieves the header of the link.
     *
     * @return The header of the link.
     */
    public String getHeader() { return this.header; }

    /**
     * Checks if the link is disabled.
     *
     * @return {@code true} if the link is disabled, {@code false} otherwise.
     */
    public boolean isDisabled() { return this.isDisabled; }

    /**
     * Retrieves the head link associated with the link.
     *
     * @return The head link associated with the link.
     */
    public String getHeadLink() { return this.headLink; }

    /**
     * Retrieves the display name of the link.
     *
     * @return The display name of the link.
     */
    public String getDisplayName() { return this.displayName; }

    /**
     * Retrieves the URL of the link.
     *
     * @return The URL of the link.
     */
    public String getUrl() { return this.url; }

    /**
     * Retrieves the slot number of the link.
     *
     * @return The slot number of the link.
     */
    public int getSlot() {
        return this.slot;
    }
}
