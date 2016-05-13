package top.tanghaibin.parser.json;

import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import top.tanghaibin.exception.BizException;
import top.tanghaibin.parser.api.Parser;

import java.io.*;
import java.util.List;
import java.util.Map;

public class JsonParser implements Parser {

	public <T> T from(String text, Class<T> clazz) throws BizException {
		return new GsonBuilder().disableHtmlEscaping().create().fromJson(text,clazz);
	}


	public <T> String to(Object obj) throws BizException {
		return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
	}

	public <T> T to(InputStream inputStream,Class<T> clazz)throws Exception{
		byte [] buf = new byte[1024*1024];
		inputStream.read(buf);
		inputStream.close();
		return new GsonBuilder().disableHtmlEscaping().create().fromJson(new String (buf,"utf-8").trim(),clazz);
	}
}
