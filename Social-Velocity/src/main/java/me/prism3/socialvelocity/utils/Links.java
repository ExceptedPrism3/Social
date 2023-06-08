package me.prism3.socialvelocity.utils;


/**
 * The Links class represents a social link.
 * It stores information about a link, such as its header and URL.
 */
public final class Links {

    private final String header;
    private final String url;
    private final String hexColor;

    /**
     * Constructs a new Links object with the specified header and URL.
     *
     * @param header The header of the link.
     * @param url    The URL of the link.
     */
    public Links(final String header, final String url, final String hexColor) {
        this.header = header;
        this.url = url;
        this.hexColor = hexColor;
    }

    /**
     * Retrieves the header of the link.
     *
     * @return The header of the link.
     */
    public String getHeader() {return this.header; }

    /**
     * Retrieves the URL of the link.
     *
     * @return The URL of the link.
     */
    public String getUrl() { return this.url; }

    /**
     * Retrieves the Hex color of the link.
     *
     * @return the Hex color of the link.
     */
    public String getHexColor() { return this.hexColor; }
}
