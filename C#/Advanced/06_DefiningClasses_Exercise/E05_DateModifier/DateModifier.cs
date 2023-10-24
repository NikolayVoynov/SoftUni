using System;

namespace DateModifier;

public static class DateModifier
{
    public static int GetDifferenceInDays(string startDate, string endDate)
    {
        DateTime start = DateTime.Parse(startDate);
        DateTime end = DateTime.Parse(endDate);

       TimeSpan difference = start - end;

        return Math.Abs(difference.Days);
    }
}
