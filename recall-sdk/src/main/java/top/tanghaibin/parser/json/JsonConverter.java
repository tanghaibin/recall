package top.tanghaibin.parser.json;


import com.google.gson.GsonBuilder;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.parser.api.Converter;

public class JsonConverter implements Converter {
	public <T> T fromResponse(String text, Class<T> clazz) throws BizException {
		return new GsonBuilder().disableHtmlEscaping().create().fromJson(text,clazz);
	}

	public <T> String toResponse(Object obj) throws BizException {
		return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
	}

}
