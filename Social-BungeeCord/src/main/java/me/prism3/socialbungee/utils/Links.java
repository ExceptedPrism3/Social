package me.prism3.socialbungee.utils;


/**
 * The Links class represents a social link.
 * It stores information about a link, such as its header and URL.
 */
public final class Links {

    private final String header;
    private final String url;

    /**
     * Constructs a new Links object with the specified header and URL.
     *
     * @param header The header of the link.
     * @param url    The URL of the link.
     */
    public Links(String header, String url) {
        this.header = header;
        this.url = url;
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
}
