package virtual.friend;

public class QuotesCreator {

    public static final String SEPARATOR = "*";
    public static final int FRAMESIZE = 100;
    private String frame = "";

    public QuotesCreator() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< FRAMESIZE; i++) {
            sb.append(SEPARATOR);
        }
        frame =  sb.toString();
    }


    public String createQuote(String quote, String author) {
        StringBuilder sb = new StringBuilder();
        int diff = quote.length() - author.length();
        sb.append(frame).append("\n").append(quote).append("\n");
        for (int i=0; i<diff; i++) {
            sb.append(" ");
        }
        sb.append(author).append("\n").append(frame);
        return sb.toString();
    }
}
