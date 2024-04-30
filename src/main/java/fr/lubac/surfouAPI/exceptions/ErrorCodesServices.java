package fr.lubac.surfouAPI.exceptions;

public abstract class ErrorCodesServices {
	
//	NAUTICAL ACTIVITY SERVICE
	public static final int NA_SPOT_OR_SPOTID_REQUIRED_RULE = 1000;
	public static final int NA_ACTIVITYDESCR_OR_ACTIVITYDESCID_REQUIRED_RULE=1001;
	public static final int NA_WEATHERC_OR_WEATHERCID_REQUIRED_RULE=1002;
	public static final int NA_SPOT_SPOTID_COHERENTS_RULE=1003;
	public static final int NA_SPOTID_NOTFOUND=1004;
	public static final int NA_ACTIVITYDESCR_ACTIVITYDESCRID_COHERENTS_RULE=1005;
	public static final int NA_ACTIVITYDESCRID_NOTFOUND=1006;
	public static final int NA_WEATHERC_WEATHERCID_COHERENTS_RULE=1007;
	public static final int NA_WEATHERCID_NOTFOUND=1008;
	public static final int NA_ASSOCIATION_ALREADY_EXISTS = 1009;
	
// SPOT SERVIVCE
	public static final int SPOT_ALREADY_EXISTS = 2000;
	public static final int SPOT_CREATORUSER_RULE = 2001;
	public static final int SPOT_NOT_FOUND = 2002;
}
