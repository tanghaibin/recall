package top.tanghaibin.parser.xml;


import top.tanghaibin.exception.BizException;
import top.tanghaibin.parser.api.Parser;

public class XmlParser implements Parser {
	public <T> T from(String text, Class<T> clazz) throws BizException {
		return new XmlConverter().fromResponse(text, clazz);
	}

	public <T> String to(Object obj) throws BizException {
		return new XmlConverter().toResponse(obj);
	}
}
