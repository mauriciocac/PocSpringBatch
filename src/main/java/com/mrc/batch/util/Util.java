package com.mrc.batch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static Integer getMin() {
		return Integer.parseInt(new SimpleDateFormat("mm").format(new Date())) + 1;
	}

	public static Integer getHour() {
		return Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
	}
}
