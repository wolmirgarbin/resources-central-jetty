package br.com.sample.filter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.Arrays;
import java.util.Calendar;

class AddExpiresHeaderResponse extends HttpServletResponseWrapper {

    public static final String[] CACHEABLE_CONTENT_TYPES = new String[] { "text/css", "text/javascript", "application/javascript", "image/png", "image/jpeg", "image/gif", "image/jpg" };

    static {
        Arrays.sort(CACHEABLE_CONTENT_TYPES);
    }

    public AddExpiresHeaderResponse(ServletResponse response) {
        super((HttpServletResponse) response);
    }

    @Override
    public void setContentType(String contentType) {
        if (contentType != null && Arrays.binarySearch(CACHEABLE_CONTENT_TYPES, contentType) > -1) {
            Calendar inTwoMonths = Calendar.getInstance();
            inTwoMonths.add(Calendar.MONTH, 2);

            super.setDateHeader("Expires", inTwoMonths.getTimeInMillis());
        } else {
            super.setHeader("Expires", "-1");
            super.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        }
        super.setContentType(contentType);
    }
}