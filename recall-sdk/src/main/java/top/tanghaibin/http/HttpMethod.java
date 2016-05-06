package top.tanghaibin.http;

public enum HttpMethod {
	GET("GET"), POST("POST");

	private String value;

	private HttpMethod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}