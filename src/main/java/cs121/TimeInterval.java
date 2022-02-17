package cs121;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeInterval {
    final private Date start;
    final private Date end;
    private static DateFormat dateFormatter =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public TimeInterval(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException("start may not be null");
        }
        if (end == null) {
            throw new IllegalArgumentException("end may not be null");
        }
        // TODO: fix sneaky error in following if statement!
        //       changes to start will cause changes to this.start
        //       since they are aliases for same Date object
        //       same with end and this.end
        if (start.before(end)) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public TimeInterval(TimeInterval other) {
        this(other.start, other.end);
    }

    private static Date copy(Date date) {
        return new Date(date.getTime());
    }

    public static String formatDate(Date date) {
        return dateFormatter.format(date);
    }

    // duration should never be negative !!!
    public double duration() {
        return (end.getTime() - start.getTime())/1000.0;
    }

    public boolean includes(Date date) {
        return start.compareTo(date) <= 0 &&
                end.compareTo(date) >= 0;
    }

    public boolean overlaps(TimeInterval other) {
        return includes(other.start) || includes(other.end) ||
                other.includes(start) || other.includes(end);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TimeInterval other) {
            // TODO: fix this return statement!!!
            return start==other.start && end==other.end;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO: fix this return statement
        //       use static formatDate method!
        return "fix this!";
    }

}
