package cs121;

import java.util.Date;

public class TimeIntervalDemo {
    public static void main(String[] args) throws InterruptedException {
        Date first = new Date();
        Thread.sleep(1000);
        Date second = new Date();

        System.out.println("first = " + TimeInterval.formatDate(first));
        System.out.println("second= " + TimeInterval.formatDate(second));
        TimeInterval ti1 = new TimeInterval(first, second);
        TimeInterval ti2 = new TimeInterval(second, first);

        if (ti1 == ti2) {
            System.out.println("ti1 == ti2, bad");
        } else {
            System.out.println("ti1 != ti2, good");
        }
        if (ti1.equals(ti2)) {
            System.out.println("ti1.equals(ti2), good");
        } else {
            System.out.println("!ti1.equals(ti2), bad");
        }
        System.out.println("ti1=" + ti1);
        System.out.println("ti2=" + ti2);
        System.out.println("ti1.duration(), should be close to 1.0: " + ti1.duration());


        Date firstCopy = new Date(first.getTime());
        System.out.println("firstCopy= " + TimeInterval.formatDate(firstCopy));
        if (!first.equals(firstCopy)) {
            System.err.println("!first.equals(firstCopy) unexpected");
        }


        TimeInterval ti3 = new TimeInterval(firstCopy, second);
        System.out.println("\nti3=" + ti3);
        if (ti2 == ti3) {
            System.out.println("ti2 == ti3, bad");
        } else {
            System.out.println("ti2 != ti3, good");
        }
        if (ti2.equals(ti3)) {
            System.out.println("ti2.equals(ti3), good");
        } else {
            System.out.println("!ti2.equals(ti3), bad");
        }


        Date third = new Date();
        TimeInterval ti4 = new TimeInterval(second, third);
        System.out.println("\nti4=" + ti4);
        System.out.println("ti4.duration(), should be less than 0.2: " + ti4.duration());
        if (ti3.equals(ti4)) {
            System.out.println("ti3.equals(ti4), bad");
        } else {
            System.out.println("!ti3.equals(ti4), good");
        }
        if (ti4.includes(first)) {
            System.out.println("ti4.includes(first), bad");
        } else {
            System.out.println("!ti4.includes(first), good");
        }
        if (ti4.includes(second)) {
            System.out.println("ti4.includes(second), good");
        } else {
            System.out.println("!ti4.includes(second), bad");
        }
        if (ti1.overlaps(ti4)) {
            System.out.println("ti1.overlaps(ti4), good");
        } else {
            System.out.println("!ti4.overlaps(ti4), bad");
        }


        Date fourth = new Date();
        TimeInterval ti5 = new TimeInterval(third, fourth);
        System.out.println("\nti5=" + ti5);
        if (ti1.overlaps(ti5)) {
            System.out.println("ti1.overlaps(ti5), bad");
        } else {
            System.out.println("!ti1.overlaps(ti5), good");
        }

        first.setSeconds(first.getSeconds() + 20);
        System.out.println("\nti1=" + ti1);
        if (ti1.duration() < 0.0) {
            System.out.println("very bad!!!");
            System.out.println("ti1.duration()= " + ti1.duration());
        }
        System.out.println("ti2=" + ti2);
        if (ti2.duration() < 0.0) {
            System.out.println("very bad!!!");
            System.out.println("ti2.duration()= " + ti2.duration());
        }
        System.out.println("ti3=" + ti3);
        if (ti3.duration() < 0.0) {
            System.out.println("very bad!!!");
            System.out.println("ti3.duration()= " + ti3.duration());
        }
    }
}
