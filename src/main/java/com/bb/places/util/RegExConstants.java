package com.bb.places.util;

public class RegExConstants {

	private RegExConstants() {

	}

	// 6-24 CHARS, ONLY INCLUDES lower case alphanumeric AND _ AND .
	// NO __ OR _. OR ._ OR .. INSIDE
	// NO _ OR . AT THE END
	public static final String VALID_USER_ID = "^(?=[a-z0-9._]{6,24}$)(?!.*[_.]{2})[^_.].*[^_.]$";

	public static final String ALPHA_NUMERIC_STRING = "^[a-zA-Z0-9]+$";

	public static final String NUMBERIC_STRING = "^[0-9]+$";

}
