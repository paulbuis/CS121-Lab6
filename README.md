## class TimeInterval

Fetch the project from GitHub at
```
https://github.com/paulbuis/CS121-Lab6.git
```

`class TimeInterval` is in `src/main/java/cs121/TimeInterval.java`.
This is the only file you should modify!

Some preliminary testing is done in `class TimeIntervalDemo`
found in `TimeIntervalDemo.java` in the same directory.
You should not modify it, but you should run the `main()` found
there to see if `class TimeInterval` is working correctly.

There are 3 problems with `class TimeInterval:

### The `.toString()` method

As given, this method obviously is not satisfactory.
Note, however, there is a method in this class
with the signature
```java
public static String formatDate(Date date)
```
that outputs the year, month, and day followed
by hours, minutes, seconds, and milliseconds followed
by the time zone offset from
[Greenwich Mean Time](https://en.wikipedia.org/wiki/Greenwich_Mean_Time).
like:
```
2022-02-17T10:18:44.245-05:00
```

If your computer has its time zone set correctly, note that Indiana in winter
is 5 hours behind Greenwich.

We want the `TimeIterval.toString()` method to produce output
that looks like:
```
[2022-02-17T10:18:44.245-05:00 to 2022-02-17T10:18:45.251-05:00]
```
Note that this starts with a `[`, has a `to` in the middle and ends with a `]`.

### The `.equals()` method

Note that `ti1`, `ti2`, and `ti3` should
all be distinct objects (the `==` operator returns `false` when
comparing them). However, `ti2.equals(ti3)` returns `false`, but
should not.

Note that the `TimeInterval.equals()` method
uses the `==` operator to compare `Date` objects
when it really should use the `Date.equals()` method.

### TimeInterval.TimeInterval(Date, Date)`

This constructor has a subtle bug.
Note that near the end of the output
from `TimeIntervalDemo.main()` there
are some negative durations being output.

The problem is that when `main()`
modifies the value of its local
variable `start` it causes
changes to the data member
called `start` in `ti1` and `ti2`
since the constructor caused them
all to be aliases that refer to the
same object.

What you need to do is have the
constructor make copies of the
`Date` objects used as parameters
so the data members of `TimeInterval`
are copies rather than aliases.
The `TimeInterval` method with the signature
```java
private static Date copy(Date date)
```
will make a copy of a `Date` object
for you.

### Completion

Run `TimeIntervalDemo.main()`
to verify that the output
looks good:
* `TimeInterval`s are printing out as specified above.
* `bad` is not being printed out for checks of `.equals()`.
* No negative durations occur at the end.
